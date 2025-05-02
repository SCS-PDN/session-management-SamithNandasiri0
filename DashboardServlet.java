import java.io.IOException;
import java.rmi.ServerException;
import java.util.Arrays;
import java.util.List;

public class DashboardServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServerException, IOException{
        HttpSession session = request.getSession(false);
        if (session==null || session.getAttribute("username")==null) {
            response.sendRedirection("index.html");
            return;            
        }
        List<Course> courseList = Arrays.asList(
            new Course("101","Data Structures","Dr. Smith"),
            new Course("102","Operating Systems","Dr. Green"),
            new Course("103","Databases","Dr. Brown")  
        );

        request.setAttribute("couese",courseList);
        request.setAttribute("message", request.getPatameter("message"));

        RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
        rd.forward(request,response);
    }
    
}