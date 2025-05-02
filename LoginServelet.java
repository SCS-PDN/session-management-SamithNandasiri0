import java.net.CookieManager;
import java.util.Map;

public class LoginServelet extends HttpServlet{

    private final Map<String, String> users = Map.of(
        "student1","pass1",
        "student2", "pass2"
    );

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException{
        String username=request.getPatameter("username");
        String password=request.getPatameter("password");

if ((username.equals("student1")&&password.equals("pass1"))||(username.equals("student2")&&password.equals("pass2"))) {
//             if (users.containsKey(username)&& users.get(username).equals(password)) {
    
// }            
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
                        
            Cookie userCookie = new Cookie("username", username);
            userCookie.setMaxAge(3600);
            response.addCookie(userCookie);

            response.sendRedirection("DashboardServelet");
        } else{
            response.getWriter().println("Invalid credentials");
        }
        }
    }
