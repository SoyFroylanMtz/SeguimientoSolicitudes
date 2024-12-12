/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package manipulaDatos;

import accesoDatos.TicketsFacade;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.inject.Inject;
import modeloDatos.Tickets;

/**
 *
 * @author soyfroylan
 */
@Stateless
@LocalBean
public class MDTicket {

    @Inject
    private TicketsFacade ticketsFacade;

    public void crearTicketParcial(Date fechaEmitida, Date horaEmitida, Integer userID) {

        Tickets ticket = new Tickets();
        ticket.setFechaEmitida(fechaEmitida);
        ticket.setHoraEmitida(horaEmitida);
        ticket.setUserID(userID);

        Date now = new Date();
        ticket.setFechaRecibida(now);
        ticket.setHoraRecibida(now);

        if (userID != null && userID > 0) {
            ticket.setFechaAsignada(now);
            ticket.setHorAsignada(now);
        }

        ticketsFacade.create(ticket);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
