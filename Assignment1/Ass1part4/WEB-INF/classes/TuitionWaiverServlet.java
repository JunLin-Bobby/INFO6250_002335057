import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;
import java.io.File;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TuitionWaiverServlet extends HttpServlet{


   @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Form Submission Results</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Form Submission Results</h1>");

            out.println("<h2>Submitted Data</h2>");
            //getting all parametersNames 
            Enumeration<String> parameterNames = request.getParameterNames();

            
            while (parameterNames.hasMoreElements()) {
                String paramName = parameterNames.nextElement();
                String[] paramValues = request.getParameterValues(paramName);

                out.println("<p><strong>" + paramName + ":</strong> ");
                //check the number of value
                if (paramValues.length == 1) {
                    out.println(paramValues[0]);
                } else {
                    out.println("<ul>");
                    for (String value : paramValues) {
                        out.println("<li>" + value + "</li>");
                    }
                    out.println("</ul>");
                }
                out.println("</p>");
            }

            out.println("<button onclick=\"window.history.back()\">Go Back</button>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}