/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package admos;

import accesoDatos.DetalleCorreoFacade;
import accesoDatos.ExternosFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import manipulaDatos.MDDetalleCorreo;
import manipulaDatos.MDTicket;
import modeloDatos.DetalleCorreo;
import modeloDatos.Externos;
import modeloDatos.Tickets;

/**
 *
 * @author soyfroylan
 */
@Named(value = "aDDetalleCorreo")
@SessionScoped
public class ADDetalleCorreo implements Serializable {

    @Inject
    private MDDetalleCorreo mDDetalleCorreo;
    @Inject
    private ExternosFacade externosFacade;
    @Inject
    private MDTicket mDTicket;

    private List<DetalleCorreo> listaDetalles;
    private Map<Integer, Externos> mapaExternos;
    private Map<Integer, Tickets> mapaTicketsRelacionados;

    private String asunto;

    @PostConstruct
    public void init() {
        System.out.println("Inicializando ADDetalleCorreo...");
        cargarDetalles(); // Cargar todos los detalles al inicio
    }

    /**
     * Creates a new instance of ADDetalleCorreo
     */
    public void guardarDetalleCorreo(Integer selectedExterno) {
        try {

            mDDetalleCorreo.crearDetalleCorreo("hola", selectedExterno);

        } catch (Exception e) {

        }
    }

    public void cargarDetalles() {
        // Inicializar listas y mapas
        listaDetalles = mDDetalleCorreo.obtenerTodosLosDetalles(); // Obtener todos los detalles
        mapaExternos = new HashMap<>();
        mapaTicketsRelacionados = new HashMap<>();

        // Iterar sobre cada detalle
        for (DetalleCorreo detalle : listaDetalles) {
            if (detalle != null && detalle.getExternoID() != null) {
                // Obtener el externo relacionado
                Externos externo = externosFacade.find(detalle.getExternoID());
                if (externo != null) {
                    mapaExternos.put(detalle.getExternoID(), externo); // Asociar el Externo con su ID

                    // Obtener el ticket relacionado al externo (si existe)
                    if (externo.getTicketID() != null) {
                        // Evitar cargar el mismo ticket más de una vez
                        if (!mapaTicketsRelacionados.containsKey(externo.getTicketID())) {
                            Tickets ticket = mDTicket.obtenerTicketPorID(externo.getTicketID());
                            if (ticket != null) {
                                mapaTicketsRelacionados.put(externo.getTicketID(), ticket);
                            } else {
                                System.out.println("No se encontró Ticket para ID: " + externo.getTicketID());
                            }
                        }
                    }
                } else {
                    System.out.println("No se encontró Externo para ID: " + detalle.getExternoID());
                }
            } else {
                System.out.println("El detalle no tiene un Externo asociado.");
            }
        }

        System.out.println("Carga completada. Total detalles: " + listaDetalles.size());
        System.out.println("Total externos cargados: " + mapaExternos.size());
        System.out.println("Total tickets cargados: " + mapaTicketsRelacionados.size());
    }

    public boolean isProcesoID(DetalleCorreo detalle, int procesoID) {
        if (detalle != null) {
            Externos externo = externoByID(detalle.getExternoID());
            if (externo != null) {
                Tickets ticket = ticketByID(externo.getTicketID());
                return ticket != null && ticket.getProcesoID() != null && ticket.getProcesoID() == procesoID;
            }
        }
        return false;
    }

    public List<DetalleCorreo> getListaDetallesProceso3() {
        List<DetalleCorreo> listaFiltrada = new ArrayList<>();
        for (DetalleCorreo detalle : listaDetalles) {
            Externos externo = externoByID(detalle.getExternoID());
            if (externo != null && externo.getTicketID() != null) {
                Tickets ticket = ticketByID(externo.getTicketID());
                if (ticket != null && ticket.getProcesoID() != null && ticket.getProcesoID() == 3) {
                    listaFiltrada.add(detalle);
                }
            }
        }
        return listaFiltrada;
    }

    public List<DetalleCorreo> getListaDetallesProceso1() {
        List<DetalleCorreo> listaFiltrada = new ArrayList<>();
        for (DetalleCorreo detalle : listaDetalles) {
            Externos externo = externoByID(detalle.getExternoID());
            if (externo != null && externo.getTicketID() != null) {
                Tickets ticket = ticketByID(externo.getTicketID());
                if (ticket != null && ticket.getProcesoID() != null && ticket.getProcesoID() == 1) {
                    listaFiltrada.add(detalle);
                }
            }
        }
        return listaFiltrada;
    }

    public List<DetalleCorreo> getListaDetallesProceso4() {
        List<DetalleCorreo> listaFiltrada = new ArrayList<>();
        for (DetalleCorreo detalle : listaDetalles) {
            Externos externo = externoByID(detalle.getExternoID());
            if (externo != null && externo.getTicketID() != null) {
                Tickets ticket = ticketByID(externo.getTicketID());
                if (ticket != null && ticket.getProcesoID() != null && ticket.getProcesoID() == 4) {
                    listaFiltrada.add(detalle);
                }
            }
        }
        return listaFiltrada;
    }

    public List<DetalleCorreo> getListaDetallesProceso2() {
        List<DetalleCorreo> listaFiltrada = new ArrayList<>();
        for (DetalleCorreo detalle : listaDetalles) {
            Externos externo = externoByID(detalle.getExternoID());
            if (externo != null && externo.getTicketID() != null) {
                Tickets ticket = ticketByID(externo.getTicketID());
                if (ticket != null && ticket.getProcesoID() != null && ticket.getProcesoID() == 2) {
                    listaFiltrada.add(detalle);
                }
            }
        }
        return listaFiltrada;
    }

    public Externos externoByID(Integer externoID) {
        return mapaExternos.get(externoID); // Busca en el mapa
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public List<DetalleCorreo> getListaDetalles() {
        return listaDetalles;
    }

    public Map<Integer, Externos> getMapaExternos() {
        return mapaExternos;
    }

    public void setMapaExternos(Map<Integer, Externos> mapaExternos) {
        this.mapaExternos = mapaExternos;
    }

    public void setListaDetalles(List<DetalleCorreo> listaDetalles) {
        this.listaDetalles = listaDetalles;
    }

    public Map<Integer, Tickets> getMapaTicketsRelacionados() {
        return mapaTicketsRelacionados;
    }

    public void setMapaTicketsRelacionados(Map<Integer, Tickets> mapaTicketsRelacionados) {
        this.mapaTicketsRelacionados = mapaTicketsRelacionados;
    }

    public Tickets ticketByID(Integer ticketID) {
        return mapaTicketsRelacionados.get(ticketID); // Busca en el mapa
    }

    public ADDetalleCorreo() {
    }

}
