/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package manipulaDatos;

import accesoDatos.DetalleCorreoFacade;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.inject.Inject;
import modeloDatos.DetalleCorreo;

/**
 *
 * @author soyfroylan
 */
@Stateless
@LocalBean
public class MDDetalleCorreo {

    @Inject
    private DetalleCorreoFacade detalleCorreoFacade;

    public void crearDetalleCorreo(String asunto, Integer externoID) {

        DetalleCorreo detalleCorreo = new DetalleCorreo();

        detalleCorreo.setAsunto(asunto);
        detalleCorreo.setExternoID(externoID);

        detalleCorreoFacade.create(detalleCorreo);
    }

    public DetalleCorreo obtenerDetallePorExternoID(Integer externoID) {
        return detalleCorreoFacade.findByExternoID(externoID);
    }

    public List<DetalleCorreo> obtenerTodosLosDetalles() {
        return detalleCorreoFacade.findAll(); // Método genérico en el Facade
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
