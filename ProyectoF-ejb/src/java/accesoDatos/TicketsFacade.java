/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accesoDatos;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modeloDatos.Tickets;

/**
 *
 * @author soyfroylan
 */
@Stateless
public class TicketsFacade extends AbstractFacade<Tickets> {

    @PersistenceContext(unitName = "ProyectoF-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TicketsFacade() {
        super(Tickets.class);
    }

    public void create(Tickets ticket) {
        em.persist(ticket); 
        em.flush();         
    }

}
