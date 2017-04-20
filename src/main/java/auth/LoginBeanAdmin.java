/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auth;

import entities.Admin;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import utils.SessionUtils;

/**
 *
 * @author l_a-b
 */
@Named(value = "loginBeanAdmin")
@SessionScoped
public class LoginBeanAdmin implements Serializable {

     @Inject
    
    AuthService authService;
    
    Admin admin=new Admin();

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
    
    
    
    public String authAdmin(){
        
        boolean valider=authService.validateAdmin(admin.getEmail(), admin.getPassword());
        if(valider){
            HttpSession session=SessionUtils.getSession();
           session.setAttribute("login", admin.getEmail());
            return "adminhome";
        }
        else {
            FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Email ou Mot de passe incorrecte",
							"Merci de réssayer"));
            return "index";
        }
        
    }
    
    
    
    public String logoutAdmin(){
        HttpSession session=SessionUtils.getSession();
        session.invalidate();
        return "/index";
    }
    /**
     * Creates a new instance of LoginBeanAdmin
     */
    public LoginBeanAdmin() {
    }
    
}
