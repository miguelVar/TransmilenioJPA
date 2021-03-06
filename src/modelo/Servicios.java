package modelo;
// Generated 6/10/2020 07:46:44 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Servicios generated by hbm2java
 */
@Entity
@Table(name = "servicios")
public class Servicios  implements java.io.Serializable {


    @Id
    @Column(name = "id_servicio")
     private int idServicio;
    
    @JoinColumn(name = "tipo_servicio_id_tipo_servicio", nullable = false)
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
     private TipoServicio tipoServicio;
     
     @Column(name = "nombre_servicio")
     private String nombreServicio;
     
     @Column(name = "color_servicio")
     private String colorServicio;
     
     @Column(name = "descripcion_servicio")
     private String descripcionServicio;
     
     @Column(name = "tiempo_opera")
     private String tiempoOpera;
     
     @OneToMany(cascade = CascadeType.ALL, mappedBy = "servicios")
     private Set<RecorridosHasServicios> recorridosHasServicioses = new HashSet(0);
     
     @OneToMany(cascade = CascadeType.ALL, mappedBy = "servicios")
     private Set<Horario> horarios = new HashSet(0);
     
     @OneToMany(cascade = CascadeType.ALL, mappedBy = "servicios")
     private Set<Rutas> rutases = new HashSet(0);

    public Servicios() {
    }

	
    public Servicios(int idServicio, TipoServicio tipoServicio, String nombreServicio, String colorServicio, String tiempoOpera) {
        this.idServicio = idServicio;
        this.tipoServicio = tipoServicio;
        this.nombreServicio = nombreServicio;
        this.colorServicio = colorServicio;
        this.tiempoOpera = tiempoOpera;
    }
    public Servicios(int idServicio, TipoServicio tipoServicio, String nombreServicio, String colorServicio, String descripcionServicio, String tiempoOpera, Set recorridosHasServicioses, Set horarios, Set rutases) {
       this.idServicio = idServicio;
       this.tipoServicio = tipoServicio;
       this.nombreServicio = nombreServicio;
       this.colorServicio = colorServicio;
       this.descripcionServicio = descripcionServicio;
       this.tiempoOpera = tiempoOpera;
       this.recorridosHasServicioses = recorridosHasServicioses;
       this.horarios = horarios;
       this.rutases = rutases;
    }
   
    public int getIdServicio() {
        return this.idServicio;
    }
    
    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }
    public TipoServicio getTipoServicio() {
        return this.tipoServicio;
    }
    
    public void setTipoServicio(TipoServicio tipoServicio) {
        this.tipoServicio = tipoServicio;
    }
    public String getNombreServicio() {
        return this.nombreServicio;
    }
    
    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }
    public String getColorServicio() {
        return this.colorServicio;
    }
    
    public void setColorServicio(String colorServicio) {
        this.colorServicio = colorServicio;
    }
    public String getDescripcionServicio() {
        return this.descripcionServicio;
    }
    
    public void setDescripcionServicio(String descripcionServicio) {
        this.descripcionServicio = descripcionServicio;
    }
    public String getTiempoOpera() {
        return this.tiempoOpera;
    }
    
    public void setTiempoOpera(String tiempoOpera) {
        this.tiempoOpera = tiempoOpera;
    }
    public Set getRecorridosHasServicioses() {
        return this.recorridosHasServicioses;
    }
    
    public void setRecorridosHasServicioses(Set recorridosHasServicioses) {
        this.recorridosHasServicioses = recorridosHasServicioses;
    }
    public Set getHorarios() {
        return this.horarios;
    }
    
    public void setHorarios(Set horarios) {
        this.horarios = horarios;
    }
    public Set getRutases() {
        return this.rutases;
    }
    
    public void setRutases(Set rutases) {
        this.rutases = rutases;
    }




}


