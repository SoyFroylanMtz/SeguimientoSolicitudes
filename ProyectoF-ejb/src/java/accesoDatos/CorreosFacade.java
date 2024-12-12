/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accesoDatos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modeloDatos.Correos;

/**
 *
 * @author soyfroylan
 */
@Stateless
public class CorreosFacade extends AbstractFacade<Correos> {

    @PersistenceContext(unitName = "ProyectoF-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CorreosFacade() {
        super(Correos.class);
    }
    
    public List<Correos> obtenerTodosLosCorreos() {
        List<Correos> municipios = null;
        try {
            Query query = em.createNamedQuery("Correos.findAll");
            municipios = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(); // Log del error para depuración
            return null;
        }
        return municipios;
    }
    
}
