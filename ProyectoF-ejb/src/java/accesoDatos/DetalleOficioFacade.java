/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accesoDatos;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modeloDatos.DetalleOficio;

/**
 *
 * @author soyfroylan
 */
@Stateless
public class DetalleOficioFacade extends AbstractFacade<DetalleOficio> {

    @PersistenceContext(unitName = "ProyectoF-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetalleOficioFacade() {
        super(DetalleOficio.class);
    }
    
}
