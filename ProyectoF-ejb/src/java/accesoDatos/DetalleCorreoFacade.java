/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accesoDatos;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modeloDatos.DetalleCorreo;

/**
 *
 * @author soyfroylan
 */
@Stateless
public class DetalleCorreoFacade extends AbstractFacade<DetalleCorreo> {

    @PersistenceContext(unitName = "ProyectoF-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetalleCorreoFacade() {
        super(DetalleCorreo.class);
    }

    public DetalleCorreo findByExternoID(Integer externoID) {
        try {
            return em.createNamedQuery("DetalleCorreo.findByExternoID", DetalleCorreo.class)
                    .setParameter("externoID", externoID)
                    .getSingleResult();
        } catch (Exception e) {
            return null; // O maneja el error como prefieras
        }
    }

}
