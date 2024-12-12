/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package manipulaDatos;

import accesoDatos.UsuariosFacade;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.inject.Inject;
import modeloDatos.Usuarios;

/**
 *
 * @author soyfroylan
 */
@Stateless
@LocalBean
public class MDUsuarios {

    @Inject
    private UsuariosFacade usuariosFacade; // Inyección de dependencia usando CDI

    public List<Usuarios> obtenerUsuarios() {
        // Lógica de negocio adicional, si es necesario
        return usuariosFacade.obtenerTodosLosUsuarios();
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
