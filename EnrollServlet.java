import java.io.IOException;
import java.util.List;

@WebServlet("/EnrollServlet")
public class EnrollServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
                String courseID = request.getParameter("courseID");
                HttpSession session =  request.getSession(false);

                if (session != null && session.getAttribute("username") != null) {
                    List<String> enrolledCourses = (List<String>) session.getAttribute("enrolledCourses");

                    if (!enrolledCourses.contains(courseID)) {
                        enrolledCourses.add(courseID);                        
                    }

                    response.sendRedirect("DashboardServlet?message=Successfully enrolled in course " + courseId);
                
                }else{
                    response.sendRedirect("index.html");
                }
            }
}