
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowServletMethods extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
       
       PrintWriter out = response.getWriter();

       out.println("<html><body>");
       out.println("<h1>HttpServletRequest and ServletRequest Method Names</h1>");

       // Create a servlet to use and display all the getX() methods from the HttpServletRequest class: 
       out.println("<h2>display all the getX() methods from the HttpServletRequest class: </h2>") ;
       String [] HttpServletRequestMethods = getMethodNames(HttpServletRequest.class);
       for(String methods:HttpServletRequestMethods ){
            out.println("<p>"+methods+"</p>");
       } 

       // and all the inherited getX() methods from the super interface ServletRequest:
       out.println("<h2>and all the inherited getX() methods from the super interface ServletRequest: </h2>") ;
       String [] InterfaceServletRequestMethods = getMethodNames(javax.servlet.ServletRequest.class);
       for(String methods:InterfaceServletRequestMethods ){
            out.println("<p>"+methods+"</p>");
       } 

       out.println("</body></html>");
        
    }

  // get method which starts with "get" 
    public String[] getMethodNames(Class<?>  HttpServletRequest){
        Method[] methods =  HttpServletRequest.getMethods();
        ArrayList<String> methodNamesList = new ArrayList<>();

        for(Method method : methods){
            if(method.getName().startsWith("get")){
                   methodNamesList.add(method.getName());
            }
        }
    return methodNamesList.toArray(new String[0]);
    }

  
}
