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
import modeloDatos.Plataformas;

/**
 *
 * @author soyfroylan
 */
@Stateless
public class PlataformasFacade extends AbstractFacade<Plataformas> {

    @PersistenceContext(unitName = "ProyectoF-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PlataformasFacade() {
        super(Plataformas.class);
    }
    
    public List<Plataformas> obtenerTodaLasPlataformas() {
        List<Plataformas> municipios = null;
        try {
            Query query = em.createNamedQuery("Plataformas.findAll");
            municipios = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(); // Log del error para depuración
            return null;
        }
        return municipios;
    }
    
}
