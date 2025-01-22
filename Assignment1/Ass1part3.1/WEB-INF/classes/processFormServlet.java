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

@MultipartConfig(
    fileSizeThreshold = 1024 * 1024 * 10, // 10 MB
    maxFileSize = 1024 * 1024 * 10,      // 10MB
    maxRequestSize = 1024 * 1024 * 50    // 50MB
)
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

        Part filePart = request.getPart("upload"); 
        if (filePart == null) {
         throw new ServletException("File part is missing in the request.");
        }
        String fileName = getFileName(filePart);

        String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIR;
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir(); 
        }

        
        String filePath = uploadPath + File.separator + fileName;
        filePart.write(filePath);

        PrintWriter out = resp.getWriter();
        out.println("<html>");

        out.println("<body>");
        out.println("<h1>Submitted Information</h1>");
        out.println("<p><strong>Email:</strong> " + email + "</p>");
        out.println("<p><strong>Password:</strong> " + password + "</p>");
        out.println("<p><strong>Confirm Password:</strong> " + confirmPassword + "</p>");
       out.println("<p><strong>Uploaded File:</strong> " + fileName + "</p>");
       out.println("<img src='" + UPLOAD_DIR + "/" + fileName + "' alt='Uploaded Image' style='max-width: 300px; max-height: 300px;'>");
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

    private String getFileName(Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf("=") + 2, content.length() - 1);
            }
        }
        return "unknown";
    }
}
