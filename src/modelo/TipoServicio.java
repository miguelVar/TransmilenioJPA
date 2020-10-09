package modelo;
// Generated 6/10/2020 07:46:44 PM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TipoServicio generated by hbm2java
 */
@Entity
@Table(name = "tipo_servicio")
public class TipoServicio implements java.io.Serializable {

    @Id
    @Column(name = "id_tipo_servicio")
    private int idTipoServicio;

    @Column(name = "nombre_tipo_servicio")
    private String nombreTipoServicio;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoServicio")
    private Set<Servicios> servicioses = new HashSet(0);

    public TipoServicio() {
    }

    public TipoServicio(int idTipoServicio, String nombreTipoServicio) {
        this.idTipoServicio = idTipoServicio;
        this.nombreTipoServicio = nombreTipoServicio;
    }

    public TipoServicio(int idTipoServicio, String nombreTipoServicio, Set servicioses) {
        this.idTipoServicio = idTipoServicio;
        this.nombreTipoServicio = nombreTipoServicio;
        this.servicioses = servicioses;
    }

    public int getIdTipoServicio() {
        return this.idTipoServicio;
    }

    public void setIdTipoServicio(int idTipoServicio) {
        this.idTipoServicio = idTipoServicio;
    }

    public String getNombreTipoServicio() {
        return this.nombreTipoServicio;
    }

    public void setNombreTipoServicio(String nombreTipoServicio) {
        this.nombreTipoServicio = nombreTipoServicio;
    }

    public Set getServicioses() {
        return this.servicioses;
    }

    public void setServicioses(Set servicioses) {
        this.servicioses = servicioses;
    }

}