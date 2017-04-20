/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auth;

import entities.Infirmier;
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
@Named(value = "loginBeanInfirmier")
@SessionScoped
public class LoginBeanInfirmier implements Serializable {

    @Inject
    AuthService authService;
    
    
    Infirmier infirmier= new Infirmier();

    public Infirmier getInfirmier() {
        return infirmier;
    }

    public void setInfirmier(Infirmier infirmier) {
        this.infirmier = infirmier;
    }
    
    
    
    
    public String authInfirmier(){
         boolean validerMed=authService.validateInfirmier(infirmier.getEmail(), infirmier.getPassword());
        if(validerMed){
            HttpSession session=SessionUtils.getSession();
           session.setAttribute("login", infirmier.getEmail());
            return "infirimierhome";
        }
        else{
              FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Email ou Mot de passe incorrecte",
							"Merci de réssayer"));
            return "index";
        }
    }
    
    
    
    
    public String logoutInfirmier(){
        HttpSession session=SessionUtils.getSession();
        session.invalidate();
        return "/index";
    }
    /**
     * Creates a new instance of LoginBeanInfirmier
     */
    public LoginBeanInfirmier() {
    }
    
}
