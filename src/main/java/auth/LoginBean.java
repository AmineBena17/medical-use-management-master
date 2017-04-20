/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auth;

import entities.Admin;
import entities.Medecin;
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
@Named(value = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

    
    @Inject
    AuthService authService;
    

    Medecin medecin=new Medecin();



    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }
    

    
    
    
    /*auth medecin*/
    public String authMedecin(){
        boolean validerMed=authService.validateMedecin(medecin.getEmail(), medecin.getPassword());
        if(validerMed){
            HttpSession session=SessionUtils.getSession();
           session.setAttribute("login", medecin.getEmail());
            return "medecinhome";
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
    
        public String logoutMedecin(){
        HttpSession session=SessionUtils.getSession();
        session.invalidate();
        return "/index";
    }
    
    
    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
    }
    
}
