/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package manipulaDatos;

import accesoDatos.PlataformasFacade;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.inject.Inject;
import modeloDatos.Plataformas;

/**
 *
 * @author soyfroylan
 */
@Stateless
@LocalBean
public class MDPlataforma {

    @Inject
    private PlataformasFacade plataformasFacade; // Inyección de dependencia usando CDI

    public List<Plataformas> obtenerPlataformas() {
        // Lógica de negocio adicional, si es necesario
        return plataformasFacade.obtenerTodaLasPlataformas();
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
