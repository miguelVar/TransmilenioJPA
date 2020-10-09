package modelo;
// Generated 6/10/2020 07:46:44 PM by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * HorarioId generated by hbm2java
 */
@Embeddable
public class HorarioId implements java.io.Serializable {

    @Column(name = "servicios_id_servicio")
    private int serviciosIdServicio;

    @Column(name = "dias_id_dia")
    private int diasIdDia;

    public HorarioId() {
    }

    public HorarioId(int serviciosIdServicio, int diasIdDia) {
        this.serviciosIdServicio = serviciosIdServicio;
        this.diasIdDia = diasIdDia;
    }

    public int getServiciosIdServicio() {
        return this.serviciosIdServicio;
    }

    public void setServiciosIdServicio(int serviciosIdServicio) {
        this.serviciosIdServicio = serviciosIdServicio;
    }

    public int getDiasIdDia() {
        return this.diasIdDia;
    }

    public void setDiasIdDia(int diasIdDia) {
        this.diasIdDia = diasIdDia;
    }

    public boolean equals(Object other) {
        if ((this == other)) {
            return true;
        }
        if ((other == null)) {
            return false;
        }
        if (!(other instanceof HorarioId)) {
            return false;
        }
        HorarioId castOther = (HorarioId) other;

        return (this.getServiciosIdServicio() == castOther.getServiciosIdServicio())
                && (this.getDiasIdDia() == castOther.getDiasIdDia());
    }

    public int hashCode() {
        int result = 17;

        result = 37 * result + this.getServiciosIdServicio();
        result = 37 * result + this.getDiasIdDia();
        return result;
    }

}
