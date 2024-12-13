/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package manipulaDatos;

import accesoDatos.ExternosFacade;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.inject.Inject;
import modeloDatos.Externos;

/**
 *
 * @author soyfroylan
 */
@Stateless
@LocalBean
public class MDExterno {

    @Inject
    private ExternosFacade externosFacade;
    
    public int crearExterno(int municipioID, int plataformaID, Integer ticketID,int correoID) {
        try {
            Externos externo = new Externos();
            externo.setMunicipioID(municipioID);
            externo.setPlataformaID(plataformaID);
            externo.setTipoAtencionID(1);
            externo.setTicketID(ticketID);
            externo.setCorreoID(correoID);

            externosFacade.create(externo);
            return externo.getIDExterno();
        } catch (Exception e) {
            throw e;
        }
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
