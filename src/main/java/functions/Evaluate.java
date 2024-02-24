package functions;

import com.google.cloud.functions.HttpFunction;
import com.google.cloud.functions.HttpRequest;
import com.google.cloud.functions.HttpResponse;
import interpreter.Interpreter;
import interpreter.parser.SyntaxError;

import java.io.BufferedWriter;
import java.net.HttpURLConnection;

public class Evaluate implements HttpFunction {
    @Override
    public void service(HttpRequest httpRequest, HttpResponse httpResponse) throws Exception {
        httpResponse.setContentType("text/plain");
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
            double result = Interpreter.evaluate(httpRequest.getFirstQueryParameter("expression").get());
            httpResponse.setStatusCode(200);
            writer.write(String.valueOf(result));
        } catch (SyntaxError | IllegalArgumentException e) {
            httpResponse.setStatusCode(500);
            writer.write(e.getMessage());
        }
    }
}
