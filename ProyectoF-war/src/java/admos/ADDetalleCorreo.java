/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package admos;

import accesoDatos.DetalleCorreoFacade;
import accesoDatos.ExternosFacade;
import accesoDatos.PlataformasFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import manipulaDatos.MDDetalleCorreo;
import manipulaDatos.MDTicket;
import modeloDatos.DetalleCorreo;
import modeloDatos.Externos;
import modeloDatos.Plataformas;
import modeloDatos.Tickets;
import modeloDatos.Usuarios;

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
    @Inject
    private PlataformasFacade plataformasFacade;

    private List<DetalleCorreo> listaDetalles;
    private Map<Integer, Externos> mapaExternos;
    private Map<Integer, Tickets> mapaTicketsRelacionados;
    private List<DetalleCorreo> listaDetallesProceso1;

    private DetalleCorreo selectedDetalle;

    private String asunto;
    private String selectedAsunto;
    private Tickets selectedTicket;
    private Integer selectedPlataformaID;
    private Integer selectedMunicipioID;
    private Integer selectedCorreoID;
    private Integer selectedUsuarioID;

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
            recargarListas();
            FacesContext.getCurrentInstance().getExternalContext().redirect("correos.xhtml");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cargarDetalles() {
        // Inicializar las listas y mapas
        listaDetalles = mDDetalleCorreo.obtenerTodosLosDetalles();
        mapaExternos = new HashMap<>();
        mapaTicketsRelacionados = new HashMap<>();

        for (DetalleCorreo detalle : listaDetalles) {
            if (detalle != null && detalle.getExternoID() != null) {
                // Buscar Externo asociado al detalle
                Externos externo = externosFacade.find(detalle.getExternoID());
                if (externo != null) {
                    mapaExternos.put(externo.getIDExterno(), externo);

                    // Buscar el ticket asociado al Externo
                    if (externo.getTicketID() != null) {
                        if (!mapaTicketsRelacionados.containsKey(externo.getTicketID())) {
                            Tickets ticket = mDTicket.obtenerTicketPorID(externo.getTicketID());
                            if (ticket != null) {
                                mapaTicketsRelacionados.put(ticket.getIDTicket(), ticket);
                                System.out.println("Ticket cargado: " + ticket.getIDTicket());
                            } else {
                                System.out.println("No se encontró el ticket para ID: " + externo.getTicketID());
                            }
                        }
                    } else {
                        System.out.println("El Externo no tiene un ticket asociado: ExternoID " + externo.getIDExterno());
                    }
                } else {
                    System.out.println("No se encontró Externo para ID: " + detalle.getExternoID());
                }
            } else {
                System.out.println("Detalle sin Externo asociado: DetalleID " + (detalle != null ? detalle.getIDDetalleCorreo() : "null"));
            }
        }

        // Depuración de resultados
        System.out.println("Carga completada.");
        System.out.println("Total detalles cargados: " + listaDetalles.size());
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

    public void recargarListas() {
        listaDetalles = mDDetalleCorreo.obtenerTodosLosDetalles();
        getListaDetallesProceso1();
        getListaDetallesProceso2();
        getListaDetallesProceso3();
        getListaDetallesProceso4();
        System.out.println("Listas actualizadas");
    }

    public Externos externoByID(Integer externoID) {
        return mapaExternos.get(externoID); // Busca en el mapa
    }

    public void seleccionarDetalle(DetalleCorreo detalle) {
        if (detalle != null) {
            this.selectedDetalle = detalle;

            if (detalle.getExternoID() != null) {
                Externos externo = externoByID(detalle.getExternoID());
                if (externo != null) {
                    this.selectedMunicipioID = externo.getMunicipioID();
                    this.selectedPlataformaID = externo.getPlataformaID();
                    this.selectedCorreoID = externo.getCorreoID(); // Asignar el correo relacionado
                } else {
                    this.selectedMunicipioID = null;
                    this.selectedPlataformaID = null;
                    this.selectedCorreoID = null;
                }
            } else {
                this.selectedMunicipioID = null;
                this.selectedPlataformaID = null;
                this.selectedCorreoID = null;
            }

            if (detalle.getAsunto() != null) {
                this.selectedAsunto = detalle.getAsunto(); // Asignar el asunto
            } else {
                this.selectedAsunto = null;
            }

            if (detalle.getExternoID() != null) {
                Externos externo = externoByID(detalle.getExternoID());
                if (externo != null && externo.getTicketID() != null) {
                    Tickets ticket = ticketByID(externo.getTicketID());
                    if (ticket != null) {
                        this.selectedTicket = ticket;
                        this.selectedUsuarioID = ticket.getUserID(); // Asignar el usuario relacionado
                    } else {
                        this.selectedUsuarioID = null;
                    }
                } else {
                    this.selectedUsuarioID = null;
                }
            } else {
                this.selectedUsuarioID = null;
            }
        } else {
            this.selectedMunicipioID = null;
            this.selectedPlataformaID = null;
            this.selectedCorreoID = null;
            this.selectedAsunto = null;
            this.selectedUsuarioID = null;
            this.selectedTicket = null;
        }
    }

    public String getNombreMunicipioByExterno(Externos externo) {
        if (externo != null && externo.getMunicipio() != null) {
            return externo.getMunicipio().getNombre();
        }
        return "Desconocido";
    }

    public Integer getNumeroMunicipioByExterno(Externos externo) {
        if (externo != null && externo.getMunicipio() != null) {
            return externo.getMunicipio().getNum();
        }
        return null; // O algún valor por defecto
    }

    public String getNombreCompletoUsuarioByTicketID(Integer ticketID) {
        Tickets ticket = ticketByID(ticketID); // Obtén el ticket del mapa
        if (ticket != null && ticket.getUsuario() != null) {
            Usuarios usuario = ticket.getUsuario();
            return usuario.getNombre() + " " + usuario.getApellidoPaterno();
        }
        return "Sin asignar"; // Si el ticket o el usuario es nulo
    }

    public String getNombrePlataformaByExterno(Externos externo) {
        if (externo != null && externo.getPlataforma() != null) {
            return externo.getPlataforma().getNombre();
        }
        return "No especificada";
    }

    public void abrirDialogoDetalle(DetalleCorreo detalle) {
        seleccionarDetalle(detalle);
        System.out.println("Datos para el diálogo cargados: " + detalle.getIDDetalleCorreo());
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
        if (ticketID == null) {
            System.out.println("El ID del ticket es nulo.");
            return null;
        }

        Tickets ticket = mapaTicketsRelacionados.get(ticketID);

        if (ticket == null) {
            System.out.println("No se encontró el ticket en el mapa para ID: " + ticketID);
        } else {
            System.out.println("Ticket encontrado: " + ticket.getIDTicket());
        }

        return ticket;
    }

    public DetalleCorreo getSelectedDetalle() {
        return selectedDetalle;
    }

    public void setSelectedDetalle(DetalleCorreo selectedDetalle) {
        this.selectedDetalle = selectedDetalle;
    }

    public Tickets getSelectedTicket() {
        return selectedTicket;
    }

    public void setSelectedTicket(Tickets selectedTicket) {
        this.selectedTicket = selectedTicket;
    }

    public Integer getSelectedPlataformaID() {
        return selectedPlataformaID;
    }

    public void setSelectedPlataformaID(Integer selectedPlataformaID) {
        this.selectedPlataformaID = selectedPlataformaID;
    }

    public Integer getSelectedMunicipioID() {
        return selectedMunicipioID;
    }

    public void setSelectedMunicipioID(Integer selectedMunicipioID) {
        this.selectedMunicipioID = selectedMunicipioID;
    }

    public Integer getSelectedCorreoID() {
        return selectedCorreoID;
    }

    public void setSelectedCorreoID(Integer selectedCorreoID) {
        this.selectedCorreoID = selectedCorreoID;
    }

    public Integer getSelectedUsuarioID() {
        return selectedUsuarioID;
    }

    public void setSelectedUsuarioID(Integer selectedUsuarioID) {
        this.selectedUsuarioID = selectedUsuarioID;
    }

    public String getSelectedAsunto() {
        return selectedAsunto;
    }

    public void setSelectedAsunto(String selectedAsunto) {
        this.selectedAsunto = selectedAsunto;
    }

    public ADDetalleCorreo() {
    }

}
