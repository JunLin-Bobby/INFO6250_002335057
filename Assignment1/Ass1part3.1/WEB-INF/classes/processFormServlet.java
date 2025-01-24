import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;
import java.io.File;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class processFormServlet extends HttpServlet{
  

    
    private static final String UPLOAD_DIR = "uploads";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm-password");
        String gender = request.getParameter("gender");
        String country = request.getParameter("country");
        String[] hobbies = request.getParameterValues("hobby");
        String address = request.getParameter("address");
        String fileName =  request.getParameter("upload");
       
        PrintWriter out = resp.getWriter();
        out.println("<html>");

        out.println("<body>");
        out.println("<h1>Submitted Information</h1>");
        out.println("<p><strong>Email:</strong> " + email + "</p>");
        out.println("<p><strong>Password:</strong> " + password + "</p>");
        out.println("<p><strong>Confirm Password:</strong> " + confirmPassword + "</p>");
       out.println("<p><strong>Uploaded File:</strong> " + fileName + "</p>");
        out.println("<p><strong>Gender:</strong> " + (gender != null ? gender : "Not selected") + "</p>");
        out.println("<p><strong>Country:</strong> " + country + "</p>");

         out.println("<p><strong>Hobby:</strong> ");
         if(hobbies!=null){
            for (String hobby: hobbies){
                  out.println( hobby+" " );
            }
         }
         out.println("</p>");

        out.println("<p><strong>Address:</strong> " + address + "</p>");
        out.println("</body>");

        out.println("</html>");
    }

   
}
