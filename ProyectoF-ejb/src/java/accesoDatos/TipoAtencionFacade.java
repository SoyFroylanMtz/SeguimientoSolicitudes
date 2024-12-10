/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accesoDatos;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modeloDatos.TipoAtencion;

/**
 *
 * @author soyfroylan
 */
@Stateless
public class TipoAtencionFacade extends AbstractFacade<TipoAtencion> {

    @PersistenceContext(unitName = "ProyectoF-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoAtencionFacade() {
        super(TipoAtencion.class);
    }
    
}
