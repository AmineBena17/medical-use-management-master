/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.Medecin;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author l_a-b
 */
@Stateless
public class MedecinFacade extends AbstractFacade<Medecin> {

    @PersistenceContext(unitName = "com.mycompany_MedicalUseManagement_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MedecinFacade() {
        super(Medecin.class);
    }
    
}
