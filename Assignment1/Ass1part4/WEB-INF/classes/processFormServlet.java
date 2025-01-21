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

@MultipartConfig(
    fileSizeThreshold = 1024 * 1024 * 10, // 10 MB
    maxFileSize = 1024 * 1024 * 10,      // 10MB
    maxRequestSize = 1024 * 1024 * 50    // 50MB
)
public class processFormServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;

    
    private static final String UPLOAD_DIR = "uploads";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        // String email = request.getParameter("email");
        // String password = request.getParameter("password");
        // String confirmPassword = request.getParameter("confirm-password");
        // String gender = request.getParameter("gender");
        // String country = request.getParameter("country");
        // String[] hobbies = request.getParameterValues("hobby");
        // String address = request.getParameter("address");

        //Using getParamemterNames to obtain data from form
        

        //process the upload photo
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
        ////////////////////////////////////////////////

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
        //printlin the upload photo
        if(filePart!=null){
            out.println("<p><strong>Uploaded File:</strong> " + fileName + "</p>");
            out.println("<img src='" + UPLOAD_DIR + "/" + fileName + "' alt='Uploaded Image' style='max-width: 300px; max-height: 300px;'>");
        }else{
             out.println("<p><strong>Uploaded File:</strong> No file uploaded</p>");
        }
        

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
