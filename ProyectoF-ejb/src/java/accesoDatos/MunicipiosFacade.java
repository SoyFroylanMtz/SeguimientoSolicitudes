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
import modeloDatos.Municipios;

/**
 *
 * @author soyfroylan
 */
@Stateless
public class MunicipiosFacade extends AbstractFacade<Municipios> {

    @PersistenceContext(unitName = "ProyectoF-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MunicipiosFacade() {
        super(Municipios.class);
    }

    public List<Municipios> obtenerTodosLosMunicipios() {
        List<Municipios> municipios = null;
        try {
            Query query = em.createNamedQuery("Municipios.findAll");
            municipios = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(); // Log del error para depuración
            return null;
        }
        return municipios;
    }

}
