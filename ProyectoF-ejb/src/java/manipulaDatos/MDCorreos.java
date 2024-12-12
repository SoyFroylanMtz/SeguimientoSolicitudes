/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package manipulaDatos;

import accesoDatos.CorreosFacade;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.inject.Inject;
import modeloDatos.Correos;

/**
 *
 * @author soyfroylan
 */
@Stateless
@LocalBean
public class MDCorreos {

    @Inject
    private CorreosFacade correosFacade; // Inyección de dependencia usando CDI

    public List<Correos> obtenerCorreos() {
        // Lógica de negocio adicional, si es necesario
        return correosFacade.obtenerTodosLosCorreos();
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
