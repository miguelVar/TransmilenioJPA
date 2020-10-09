package modelo;
// Generated 6/10/2020 07:46:44 PM by Hibernate Tools 4.3.1

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * RecorridosHasServicios generated by hbm2java
 */
@Entity
@Table(name = "recorridos_has_servicios")
public class RecorridosHasServicios implements java.io.Serializable {

    @EmbeddedId
    private RecorridosHasServiciosId id;

    @JoinColumn(name = "estacioneFin", nullable = false)
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Estaciones estacionesByEstacioneFin;

    @JoinColumn(name = "estacionInicio", nullable = false)
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Estaciones estacionesByEstacionInicio;

    @JoinColumn(name = "recorridos_usuarios_id_usuario", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Recorridos recorridos;

    @JoinColumn(name = "servicios_id_servicio", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Servicios servicios;

    @Column(name = "orden")
    private String orden;

    public RecorridosHasServicios() {
    }

    public RecorridosHasServicios(RecorridosHasServiciosId id, Estaciones estacionesByEstacioneFin, Estaciones estacionesByEstacionInicio, Recorridos recorridos, Servicios servicios, String orden) {
        this.id = id;
        this.estacionesByEstacioneFin = estacionesByEstacioneFin;
        this.estacionesByEstacionInicio = estacionesByEstacionInicio;
        this.recorridos = recorridos;
        this.servicios = servicios;
        this.orden = orden;
    }

    public RecorridosHasServiciosId getId() {
        return this.id;
    }

    public void setId(RecorridosHasServiciosId id) {
        this.id = id;
    }

    public Estaciones getEstacionesByEstacioneFin() {
        return this.estacionesByEstacioneFin;
    }

    public void setEstacionesByEstacioneFin(Estaciones estacionesByEstacioneFin) {
        this.estacionesByEstacioneFin = estacionesByEstacioneFin;
    }

    public Estaciones getEstacionesByEstacionInicio() {
        return this.estacionesByEstacionInicio;
    }

    public void setEstacionesByEstacionInicio(Estaciones estacionesByEstacionInicio) {
        this.estacionesByEstacionInicio = estacionesByEstacionInicio;
    }

    public Recorridos getRecorridos() {
        return this.recorridos;
    }

    public void setRecorridos(Recorridos recorridos) {
        this.recorridos = recorridos;
    }

    public Servicios getServicios() {
        return this.servicios;
    }

    public void setServicios(Servicios servicios) {
        this.servicios = servicios;
    }

    public String getOrden() {
        return this.orden;
    }

    public void setOrden(String orden) {
        this.orden = orden;
    }

}