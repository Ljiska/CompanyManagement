import beans.*;
import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import db.*;

@SessionScoped
@ManagedBean
public class Controller implements Serializable {

    private String username;
    private String password;
    public String msg = "";
    private User newUser = new User();
    
    private ArrayList<User> users = new ArrayList<User>();

    public Controller() {
        initUsers();
    }

    public void initUsers(){
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            con = DB.getInstance().getConnection();
            stmt = con.createStatement();
            String querry = "SELECT * FROM user;";
            rs = stmt.executeQuery(querry);
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String address = rs.getString("address");
                Date dateOfBirth = rs.getDate("dateOfBirth");
                String email = rs.getString("email");
                String type = rs.getString("type");

                newUser = new User(id, username, password, name, surname, address, dateOfBirth, email, type);

                users.add(newUser);
            }
            newUser = new User();
            con.close();
        } catch (SQLException ex) {
        } finally {
            DB.getInstance().putConnection(con);
        }
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public User getNewUser() {
        return newUser;
    }

    public void setNewUser(User newUser) {
        this.newUser = newUser;
    }

    
    
}
