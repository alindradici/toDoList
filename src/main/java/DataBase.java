import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alin on 7/13/2016.
 */
public class DataBase {
    public void demoCDU(String fName,String lName,String email,String pass,String nick) throws ClassNotFoundException, SQLException {

        // 1. load driver
        Class.forName("org.postgresql.Driver");

        // 2. define connection params to db
        final String URL = "jdbc:postgresql://54.93.65.5:5432/4_alin";
        final String USERNAME = "fasttrackit_dev";
        final String PASSWORD = "fasttrackit_dev";

        // 3. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 4. create a query statement
        PreparedStatement pSt = conn.prepareStatement("INSERT INTO todolist (firstname,lastname,email,password,nickname) VALUES ('" + fName + "','" + lName + "','" + email + "','" + pass + "','" + nick + "')");

        // 5. execute a prepared statement
        int rowsInserted = pSt.executeUpdate();

        // 6. close the objects
        pSt.close();
        conn.close();

    }

    public List demoRead() throws ClassNotFoundException, SQLException {

        List<String> list = new ArrayList<String>();


        // 1. load driver
        Class.forName("org.postgresql.Driver");

        // 2. define connection params to db
        final String URL = "jdbc:postgresql://54.93.65.5:5432/4_alin";
        final String USERNAME = "fasttrackit_dev";
        final String PASSWORD = "fasttrackit_dev";

        // 3. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 4. create a query statement
        Statement st = conn.createStatement();

        // 5. execute a query
        ResultSet rs = st.executeQuery("SELECT FROM nickname,password FROM todolist ");

        // 6. iterate the result set and print the values
        while (rs.next()) {
            String value = rs.getString("nickname");
            list.add(value);
            String pass = rs.getString("password");
            list.add(pass);

        }

        // 7. close the objects
        rs.close();
        st.close();
        conn.close();

        return list;
    }


}
