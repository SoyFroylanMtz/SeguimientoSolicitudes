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
import modeloDatos.Usuarios;

/**
 *
 * @author soyfroylan
 */
@Stateless
public class UsuariosFacade extends AbstractFacade<Usuarios> {

    @PersistenceContext(unitName = "ProyectoF-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariosFacade() {
        super(Usuarios.class);
    }
    
    public List<Usuarios> obtenerTodosLosUsuarios() {
        List<Usuarios> municipios = null;
        try {
            Query query = em.createNamedQuery("Usuarios.findAll");
            municipios = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(); // Log del error para depuración
            return null;
        }
        return municipios;
    }
}
