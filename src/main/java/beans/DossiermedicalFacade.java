/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.Dossiermedical;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author l_a-b
 */
@Stateless
public class DossiermedicalFacade extends AbstractFacade<Dossiermedical> {

    @PersistenceContext(unitName = "com.mycompany_MedicalUseManagement_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DossiermedicalFacade() {
        super(Dossiermedical.class);
    }
    
}
