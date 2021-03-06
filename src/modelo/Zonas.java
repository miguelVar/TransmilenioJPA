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
 * Zonas generated by hbm2java
 */
@Entity
@Table(name = "zonas")
public class Zonas implements java.io.Serializable {

    @Id
    @Column(name = "id_zona")
    private int idZona;
    
    @JoinColumn(name = "troncales_id_troncal", nullable = false)
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Troncales troncales;
    
    @Column(name = "letra_zona")
    private String letraZona;
    
    @Column(name = "color_zona")
    private String colorZona;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "zonas")
    private Set<Estaciones> estacioneses = new HashSet(0);

    public Zonas() {
    }

    public Zonas(int idZona, Troncales troncales, String letraZona, String colorZona) {
        this.idZona = idZona;
        this.troncales = troncales;
        this.letraZona = letraZona;
        this.colorZona = colorZona;
    }

    public Zonas(int idZona, Troncales troncales, String letraZona, String colorZona, Set estacioneses) {
        this.idZona = idZona;
        this.troncales = troncales;
        this.letraZona = letraZona;
        this.colorZona = colorZona;
        this.estacioneses = estacioneses;
    }

    public int getIdZona() {
        return this.idZona;
    }

    public void setIdZona(int idZona) {
        this.idZona = idZona;
    }

    public Troncales getTroncales() {
        return this.troncales;
    }

    public void setTroncales(Troncales troncales) {
        this.troncales = troncales;
    }

    public String getLetraZona() {
        return this.letraZona;
    }

    public void setLetraZona(String letraZona) {
        this.letraZona = letraZona;
    }

    public String getColorZona() {
        return this.colorZona;
    }

    public void setColorZona(String colorZona) {
        this.colorZona = colorZona;
    }

    public Set getEstacioneses() {
        return this.estacioneses;
    }

    public void setEstacioneses(Set estacioneses) {
        this.estacioneses = estacioneses;
    }

}
