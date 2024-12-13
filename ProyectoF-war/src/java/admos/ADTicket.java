/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package admos;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import javax.inject.Inject;
import manipulaDatos.MDTicket;
import modeloDatos.Tickets;

/**
 *
 * @author soyfroylan
 */
@Named(value = "aDTicket")
@SessionScoped
public class ADTicket implements Serializable {

    @Inject
    private MDTicket mDTicket;
    @Inject
    private ADUusarios aDUusarios;
    @Inject
    private ADExternos aDExternos;

    private Date fechaEmitida;
    private Date horaEmitida;
    private Integer selectedUser;
    private String mensaje;

    public void guardarTicketParcial() {
        try {
            selectedUser = aDUusarios.getSelectedUsuario();
            
            int ticketID = mDTicket.crearTicketParcial(fechaEmitida, horaEmitida, selectedUser != 0 ? selectedUser : null);
            aDExternos.guardarExterno(ticketID);

            mensaje = "El ticket se creó correctamente con los datos proporcionados.";
        } catch (Exception e) {
            mensaje = "Error al crear el ticket: " + e.getMessage();
        }
    }

    public Date getFechaEmitida() {
        return fechaEmitida;
    }

    public void setFechaEmitida(Date fechaEmitida) {
        this.fechaEmitida = fechaEmitida;
    }

    public Date getHoraEmitida() {
        return horaEmitida;
    }

    public void setHoraEmitida(Date horaEmitida) {
        this.horaEmitida = horaEmitida;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
