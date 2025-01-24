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


public class processFormServlet extends HttpServlet{
    

    
    private static final String UPLOAD_DIR = "uploads";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        

    

        //bluid html
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<body>");
        //using getParameterNames();
        Enumeration<String> parameterNames = request.getParameterNames();
        while(parameterNames.hasMoreElements()){
            String parameterName = parameterNames.nextElement();
            String[] parameterValues = request.getParameterValues(parameterName);

            out.println("<p>"+parameterName+":");
            for(String value : parameterValues){
                out.println(value+" ");
            }
            out.println("</p>");
        }
     

        out.println("</body>");
        out.println("</html>");
    }

 
}
