package AdminPackage;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sinner
 */
public class AdministratorDaoJdbc implements AdministratorDao{

    @Override
    public Administrator create(Administrator admin) {
        Connection conn = null;
        Statement stmt = null;
        try {
            // 1. Register the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            // 2. Get the connection for the URL jdbc:mysql://address:port/dbname?user=username&password=userpassword
            conn = DriverManager.getConnection("jdbc:mysql://localhost/proyectoarquitectura?" + "user=root&password=root");
            // 3. Creates the product in the database
            stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO administrator VALUES(" + admin.getIdAdmin() + ",'" + admin.getNameAdmin() + "','"+admin.getPassAdmin()+"')");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AdministratorDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try{
                stmt.close();
            }catch(SQLException ex) {
                Logger.getLogger(AdministratorDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(AdministratorDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return admin;
    }

    @Override
    public void update(int idAdmin) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            // 1. Register the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            // 2. Get the connection for the URL jdbc:mysql://addrress:port/dbname?user=username&password=userpassword
            conn = DriverManager.getConnection("jdbc:mysql://localhost/proyectoarquitectura?" + "user=root&password=root");
            // 3. Creates the product in the database
            stmt = conn.prepareStatement("UPDATE administrator SET nameAdministrator = ? , passAdministrator = ? WHERE idAdministrator = ?");
            stmt.setString(1, "pruebatestAdmin");
            stmt.setString(2,"passtestAdmin");
            stmt.setInt(3, idAdmin);
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(AdministratorDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdministratorDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(AdministratorDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(AdministratorDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void delete(int idAdmin) {
        Connection conn = null;
        Statement stmt = null;
        try {
            // 1. Register the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            // 2. Get the connection for the URL jdbc:mysql://address:port/dbname?user=username&password=userpassword
            conn = DriverManager.getConnection("jdbc:mysql://localhost/proyectoarquitectura?" + "user=root&password=root");
            // 3. Creates the product in the database
            stmt = conn.createStatement();
            stmt.executeUpdate("DELETE FROM administrator WHERE idAdministrator = " + idAdmin);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AdministratorDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(AdministratorDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(AdministratorDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    @Override
    public Administrator findById(int idAdmin) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs= null;
        Administrator a= null;
        try {
            // 1. Register the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            // 2. Get the connection for the URL jdbc:mysql://address:port/dbname?user=username&password=userpassword
            conn = DriverManager.getConnection("jdbc:mysql://localhost/proyectoarquitectura?" + "user=root&password=root");
            // 3. Creates the product in the database
            //stmt =conn.createStatement();
            //stmt.executeUpdate("SELECT * FROM  PRODUCTS WHERE ID_PRODUCT = " + productId.intValue());
            stmt = conn.prepareStatement("SELECT * FROM  administrator WHERE idAdministrator = ?");
            stmt.setInt(1, idAdmin);
            stmt.executeUpdate();
            rs = stmt.executeQuery();
            while(rs.next()){
            a = new Administrator();
            a.setIdAdmin(rs.getInt("idAdministrator"));
            a.setNameAdmin(rs.getString("nameAdministrator"));
            a.setPassAdmin(rs.getString("passAdministrator"));

            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(AdministratorDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdministratorDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(AdministratorDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(AdministratorDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return a;

    }
    
}
