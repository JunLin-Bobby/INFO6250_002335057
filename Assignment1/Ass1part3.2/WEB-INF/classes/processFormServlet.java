import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;
import java.io.File;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class processFormServlet extends HttpServlet{
    

    
    private static final String UPLOAD_DIR = "uploads";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

     
        Map<String,String[]> parameterMap = request.getParameterMap();

      

        //bluid html
        PrintWriter out = resp.getWriter();
          if (parameterMap.isEmpty()) {
        out.println("<html><body><h1>No parameters received</h1></body></html>");
        return;
    }
        out.println("<html>");
        out.println("<body>");
       for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
            String key = entry.getKey();
            String[] values = entry.getValue();

            out.println("<p><strong>" + key + ":</strong> ");
            for (String value : values) {
                out.println(value + " ");
            }
            out.println("</p>");
        }
       

        out.println("</body>");
        out.println("</html>");
    }

   
}
