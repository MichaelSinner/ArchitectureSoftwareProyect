package UserPackage;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sinner
 */
public class UserDaoJdbc implements UserDao{

    @Override
    public User create(User user) {
        Connection conn = null;
        Statement stmt = null;
        try {
            // 1. Register the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            // 2. Get the connection for the URL jdbc:mysql://address:port/dbname?user=username&password=userpassword
            conn = DriverManager.getConnection("jdbc:mysql://localhost/proyectoarquitectura?" + "user=root&password=root");
            // 3. Creates the product in the database
            stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO users VALUES(" + user.getIdUser() + ",'" + user.getNameUser() + "','"+user.getPassUser()+"')");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UserDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try{
                stmt.close();
            }catch(SQLException ex) {
                Logger.getLogger(UserDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return user;
    }

    @Override
    public void update(int idUser) {
        Connection conn = null;
            PreparedStatement stmt = null;
        try {
            // 1. Register the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            // 2. Get the connection for the URL jdbc:mysql://address:port/dbname?user=username&password=userpassword
            conn = DriverManager.getConnection("jdbc:mysql://localhost/proyectoarquitectura?" + "user=root&password=root");
            // 3. Creates the product in the database
            stmt = conn.prepareStatement("UPDATE users SET nameUser = ? , passUser = ? WHERE idUser = ?");
            stmt.setString(1, "pruebatestUser");
            stmt.setString(2,"passtestuser");
            stmt.setInt(3, idUser);
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    @Override
    public void delete(int idUser) {
        Connection conn = null;
        Statement stmt = null;
        try {
            // 1. Register the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            // 2. Get the connection for the URL jdbc:mysql://address:port/dbname?user=username&password=userpassword
            conn = DriverManager.getConnection("jdbc:mysql://localhost/proyectoarquitectura?" + "user=root&password=root");
            // 3. Creates the product in the database
            stmt = conn.createStatement();
            stmt.executeUpdate("DELETE FROM users WHERE idUser = " + idUser);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UserDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    @Override
    public User findById(Integer idUser) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs= null;
        User u= null;
        try {
            // 1. Register the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            // 2. Get the connection for the URL jdbc:mysql://address:port/dbname?user=username&password=userpassword
            conn = DriverManager.getConnection("jdbc:mysql://localhost/proyectoarquitectura?" + "user=root&password=root");
            // 3. Creates the product in the database
            //stmt =conn.createStatement();
            //stmt.executeUpdate("SELECT * FROM  PRODUCTS WHERE ID_PRODUCT = " + productId.intValue());
            stmt = conn.prepareStatement("SELECT * FROM  users WHERE idUser = ?");
            stmt.setInt(1, idUser);
            stmt.executeUpdate();
            rs = stmt.executeQuery();
            while(rs.next()){
            u = new User();
            u.setIdUser(rs.getInt("idUser"));
            u.setNameUser(rs.getString("nameUser"));
            u.setPassUser(rs.getString("passUser"));

            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return u;

    }

    @Override
    public List<User> findAll() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs= null;
        List<User> l= null;
        try {
            // 1. Register the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            // 2. Get the connection for the URL jdbc:mysql://address:port/dbname?user=username&password=userpassword
            conn = DriverManager.getConnection("jdbc:mysql://localhost/proyectoarquitectura?" + "user=root&password=root");
            // 3. Creates the product in the database
            
            stmt = conn.prepareStatement("SELECT * FROM  users");
            stmt.executeUpdate();
            rs = stmt.executeQuery();
            while(rs.next()){
            User u = new User();
            u.setIdUser(rs.getInt("idUser"));
            u.setNameUser(rs.getString("nameUser"));
            u.setPassUser(rs.getString("passUser"));
            l.add(u);
            }
          
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return  l;
    }
    
}
