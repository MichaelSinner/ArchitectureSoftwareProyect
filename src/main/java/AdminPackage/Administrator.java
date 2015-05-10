package AdminPackage;

/**
 *
 * @author Sinner
 */
public class Administrator {
    private Integer idAdmin=0;
    private String nameAdmin;
    private String passAdmin; 
    
    public Administrator(int idAdmin, String name , String pass){
        this.idAdmin=idAdmin;
        this.nameAdmin=name;
        this.passAdmin=pass;
    }
    
    public Administrator(){
        this.idAdmin=idAdmin;
        this.nameAdmin=nameAdmin;
        this.passAdmin=passAdmin;
    }

    public void setIdAdmin(Integer idAdmin) {
        this.idAdmin = idAdmin;
    }

    public void setNameAdmin(String nameAdmin) {
        this.nameAdmin = nameAdmin;
    }

    public void setPassAdmin(String passAdmin) {
        this.passAdmin = passAdmin;
    }

    public Integer getIdAdmin() {
        return idAdmin;
    }

    public String getNameAdmin() {
        return nameAdmin;
    }

    public String getPassAdmin() {
        return passAdmin;
    }
    
    
}
