import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


/**
 * Created by alin on 6/30/2016.
 */
@WebServlet("/log")
public class apples extends HttpServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String fName = req.getParameter("firstName");
        String lName = req.getParameter("lastName");
        String email = req.getParameter("mail");
        String pass = req.getParameter("pass");
        String nick = req.getParameter("nick");
        String userName = req.getParameter("enterName");
        String password = req.getParameter("password");

        try {
            new DataBase().demoCDU(fName,lName,email,pass,nick);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            List<String> list = new DataBase().demoRead();
            if(list.contains(userName)&&list.contains(password)){
                RequestDispatcher view = req.getRequestDispatcher("/Webapp/toDoList.html");
                view.forward(req, resp);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        }

    }


