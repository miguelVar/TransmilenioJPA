package modelo;
// Generated 6/10/2020 07:46:44 PM by Hibernate Tools 4.3.1

import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Recorridos generated by hbm2java
 */
@Entity
@Table(name = "recorridos")
public class Recorridos implements java.io.Serializable {

    @Id
    @Column(name = "usuarios_id_usuario")
    private int usuariosIdUsuario;

   @OneToOne
   @PrimaryKeyJoinColumn
    private Usuarios usuarios;

    @Column(name = "fecha_servicio")
    private Date fechaServicio;

    @Column(name = "hora")
    private Date hora;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recorridos")
    private Set<RecorridosHasServicios> recorridosHasServicioses = new HashSet(0);
    public Recorridos() {
    }

    public Recorridos(Usuarios usuarios, Date fechaServicio, Date hora) {
        this.usuarios = usuarios;
        this.fechaServicio = fechaServicio;
        this.hora = hora;
    }

    /*public Recorridos(Usuarios usuarios, Date fechaServicio, Date hora, Set recorridosHasServicioses) {
        this.usuarios = usuarios;
        this.fechaServicio = fechaServicio;
        this.hora = hora;
        this.recorridosHasServicioses = recorridosHasServicioses;
    }*/

    public Recorridos(int usuariosIdUsuario, Usuarios usuarios, Date fechaServicio, Date hora) {
        this.usuariosIdUsuario = usuariosIdUsuario;
        this.usuarios = usuarios;
        this.fechaServicio = fechaServicio;
        this.hora = hora;
    }
    

    public int getUsuariosIdUsuario() {
        return this.usuariosIdUsuario;
    }

    public void setUsuariosIdUsuario(int usuariosIdUsuario) {
        this.usuariosIdUsuario = usuariosIdUsuario;
    }

    public Usuarios getUsuarios() {
        return this.usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    public Date getFechaServicio() {
        return this.fechaServicio;
    }

    public void setFechaServicio(Date fechaServicio) {
        this.fechaServicio = fechaServicio;
    }

    public Date getHora() {
        return this.hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public Set getRecorridosHasServicioses() {
        return this.recorridosHasServicioses;
    }

    public void setRecorridosHasServicioses(Set recorridosHasServicioses) {
        this.recorridosHasServicioses = recorridosHasServicioses;
    }

}