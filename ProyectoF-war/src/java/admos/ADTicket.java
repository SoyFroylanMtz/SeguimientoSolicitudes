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

    private Date fechaEmitida;
    private Date horaEmitida;
    private Integer selectedUser;
    private String mensaje;

    public void guardarTicketParcial() {
        try {
            System.out.println("Fecha Emitida: " + fechaEmitida);
            System.out.println("Hora Emitida: " + horaEmitida);
            System.out.println("Usuario Seleccionado: " + aDUusarios.getSelectedUsuario());

            selectedUser = aDUusarios.getSelectedUsuario();
            if (fechaEmitida == null || horaEmitida == null || selectedUser == null) {
                mensaje = "Error: Datos incompletos.";
                return;
            }

            mDTicket.crearTicketParcial(fechaEmitida, horaEmitida, selectedUser);
            mensaje = "El ticket se creó correctamente con datos específicos.";
        } catch (Exception e) {
            mensaje = "Error al crear el ticket: " + e.getMessage();
        }
    }

    // Getters y Setters
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
