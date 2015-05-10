/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserPackage;

/**
 *
 * @author Sinner
 */
public class User {
    private Integer idUser=0;
    private String nameUser;
    private String passUser;

    public User(int idUser,String name, String pass ){
        this.idUser=idUser;
        this.nameUser=name;
        this.passUser=pass;
    }
    public User(){
        this.idUser=idUser;
        this.nameUser=nameUser;
        this.passUser=passUser;
    }
    
    
    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public void setPassUser(String passUser) {
        this.passUser = passUser;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public String getPassUser() {
        return passUser;
    }
    
    
}
