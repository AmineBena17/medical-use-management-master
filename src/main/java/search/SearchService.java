/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search;

import entities.Dossiermedical;
import entities.Infirmier;
import entities.Medecin;
import entities.Structurehopital;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author l_a-b
 */
@Stateless
public class SearchService {
    
    @PersistenceContext
    private EntityManager em;
    
    //chercher dossier
   public List<Dossiermedical> searchDossier(String nom){
       Query query= em.createQuery("SELECT d FROM Dossiermedical d WHERE d.nompatient=:nom");
       query.setParameter("nom", nom);
       return query.getResultList();
   } 
   
   //chercher medecin
   public List<Medecin> searchMedecin(String nom){
       Query q=em.createQuery("SELECT m FROM Medecin m WHERE m.nom=:nom");
       q.setParameter("nom", nom);
       return q.getResultList();
   }
   
   //chercher structure
    public List<Structurehopital> searchStructure(String nom){
       Query q2=em.createQuery("SELECT s FROM Structurehopital s WHERE s.departement=:nom");
       q2.setParameter("nom", nom);
       return q2.getResultList();
   }
    
    
    public List<Infirmier> searchInfirmier(String nom){
        Query q3=em.createQuery("SELECT a FROM Infirmier a WHERE a.nom=:nom OR a.prenom=:nom");
        q3.setParameter("nom", nom);
        return q3.getResultList();
    }
}
