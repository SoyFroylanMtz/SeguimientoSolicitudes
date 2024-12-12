/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package manipulaDatos;

import accesoDatos.MunicipiosFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.inject.Inject;
import modeloDatos.Municipios;

/**
 *
 * @author soyfroylan
 */
@Stateless
@LocalBean
public class MDMunicipios {

    @Inject
    private MunicipiosFacade municipiosFacade; // Inyección de dependencia usando CDI

    public List<Municipios> obtenerMunicipios() {
        // Lógica de negocio adicional, si es necesario
        return municipiosFacade.obtenerTodosLosMunicipios();
    }
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
