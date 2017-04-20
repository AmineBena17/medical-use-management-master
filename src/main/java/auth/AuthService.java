/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auth;

import entities.Admin;
import entities.Infirmier;
import entities.Medecin;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author l_a-b
 */

@Stateless
public class AuthService {
        
    
     @PersistenceContext
     private EntityManager em;
     
     public boolean validateMedecin(String email, String password){
         
         try {
             Query query=em.createQuery("SELECT m FROM Medecin m WHERE m.email=:email AND m.password=:password");
             query.setParameter("email", email);
             query.setParameter("password", password);
             Medecin medecin= (Medecin) query.getSingleResult();
             if(medecin instanceof Medecin){
                 return true;
             }
             
         } catch (NoResultException e) {
         }
         return false;
     }
     
     
     public boolean validateAdmin(String email, String password){
         try {
             Query q=em.createQuery("SELECT a FROM Admin a WHERE a.email=:email AND a.password=:password");
             q.setParameter("email", email);
             q.setParameter("password", password);
             Admin admin=(Admin) q.getSingleResult();
             if(admin instanceof Admin){
                 return true;
             }
         } catch (NoResultException e) {
         }
         return false;
     }
    
     
     
     public boolean validateInfirmier(String email, String password){
         try {
                Query q=em.createQuery("SELECT a FROM Infirmier a WHERE a.email=:email AND a.password=:password");
             q.setParameter("email", email);
             q.setParameter("password", password);
             Infirmier infirmier=(Infirmier) q.getSingleResult();
             if(infirmier instanceof Infirmier){
                 return true;
             }
         } catch (Exception e) {
         }
         return false;
     }
     
}
