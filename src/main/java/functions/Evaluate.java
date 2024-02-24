package functions;

import com.google.cloud.functions.HttpFunction;
import com.google.cloud.functions.HttpRequest;
import com.google.cloud.functions.HttpResponse;
import interpreter.Interpreter;
import interpreter.parser.SyntaxError;

import java.io.BufferedWriter;

public class Evaluate implements HttpFunction {
    @Override
    public void service(HttpRequest httpRequest, HttpResponse httpResponse) throws Exception {
        httpResponse.setContentType("text/plain");
        BufferedWriter writer = httpResponse.getWriter();

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
