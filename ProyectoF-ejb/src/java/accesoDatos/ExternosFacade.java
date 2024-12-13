/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accesoDatos;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modeloDatos.Externos;

/**
 *
 * @author soyfroylan
 */
@Stateless
public class ExternosFacade extends AbstractFacade<Externos> {

    @PersistenceContext(unitName = "ProyectoF-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ExternosFacade() {
        super(Externos.class);
    }
    public void create(Externos externos) {
        em.persist(externos);
        em.flush();    
    }
    
}
