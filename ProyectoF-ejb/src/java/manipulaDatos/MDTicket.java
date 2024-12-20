/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package manipulaDatos;

import accesoDatos.TicketsFacade;
import java.util.Date;
import java.util.List;
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

    public int crearTicketParcial(Date fechaEmitida, Date horaEmitida, Integer userID) {

        Tickets ticket = new Tickets();
        ticket.setFechaEmitida(fechaEmitida);
        ticket.setHoraEmitida(horaEmitida);
        ticket.setUserID(userID);

        String folio = generarFolio();
        ticket.setFolioTicket(folio);

        Date now = new Date();
        ticket.setFechaRecibida(now);
        ticket.setHoraRecibida(now);

        if (userID != null && userID > 0) {
            ticket.setFechaAsignada(now);
            ticket.setHorAsignada(now);
            ticket.setProcesoID(3);
        } else {
            ticket.setProcesoID(1);
        }

        ticket.setTipoID(1);
        ticketsFacade.create(ticket);
        return ticket.getIDTicket();
    }

    public List<Tickets> obtenerTodosLosTickets() {
        return ticketsFacade.findAll();
    }

    public Tickets obtenerTicketPorID(Integer ticketID) {
        return ticketsFacade.find(ticketID); // Método genérico en el Facade
    }

    public String generarFolio() {
        // Obtener el último ticket registrado
        List<Tickets> tickets = ticketsFacade.findAll();
        int numeroIncrementable = 1; // Por defecto, el primer folio será 1

        if (!tickets.isEmpty()) {
            numeroIncrementable = tickets.get(tickets.size() - 1).getIDTicket() + 1;
        }

        String numeroFormateado = String.format("%05d", numeroIncrementable);

        int anioActual = new Date().getYear() + 1900;

        return "ASFE/ST/" + numeroFormateado + "/" + anioActual;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
