package functions;

import com.google.cloud.functions.HttpFunction;
import com.google.cloud.functions.HttpRequest;
import com.google.cloud.functions.HttpResponse;
import interpreter.expressiontree.ExpressionTree;
import interpreter.parser.Parser;
import interpreter.parser.SyntaxError;
import interpreter.tokeniser.Tokeniser;

import java.io.BufferedWriter;
import java.net.HttpURLConnection;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class Tree implements HttpFunction {
    @Override
    public void service(HttpRequest httpRequest, HttpResponse httpResponse) throws Exception {
        httpResponse.setContentType("application/json");
        BufferedWriter writer = httpResponse.getWriter();

        httpResponse.appendHeader("Access-Control-Allow-Origin", "*");

        if ("OPTIONS".equals(httpRequest.getMethod())) {
            httpResponse.appendHeader("Access-Control-Allow-Methods", "GET");
            httpResponse.appendHeader("Access-Control-Allow-Headers", "Content-Type");
            httpResponse.appendHeader("Access-Control-Max-Age", "3600");
            httpResponse.setStatusCode(HttpURLConnection.HTTP_NO_CONTENT);
            return;
        }

        try {
            Tokeniser tokeniser = new Tokeniser(httpRequest.getFirstQueryParameter("expression").get());
            Parser parser = new Parser(tokeniser.tokenise());
            ExpressionTree tree = parser.parse();
            httpResponse.setStatusCode(200);
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String json = ow.writeValueAsString(tree);
            writer.write(json);
        } catch (SyntaxError | IllegalArgumentException e) {
            httpResponse.setStatusCode(500);
            writer.write(e.getMessage());
        }
    }
}
