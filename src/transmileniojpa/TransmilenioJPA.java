/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transmileniojpa;

import constantes.EnumServicios;
import controlador.TransmilenioJpaController;
import java.util.Date;
import modelo.Dias;
import modelo.Estaciones;
import modelo.Horario;
import modelo.HorarioId;
import modelo.Recorridos;
import modelo.RecorridosHasServicios;
import modelo.RecorridosHasServiciosId;
import modelo.Rutas;
import modelo.RutasId;
import modelo.Servicios;
import modelo.TipoServicio;
import modelo.Troncales;
import modelo.Usuarios;
import modelo.Zonas;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.NewHibernateUtil;
import util.SessionManagment;

/**
 *
 * @author migue
 */
public class TransmilenioJPA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        TransmilenioJpaController transmilenioJpaController = new TransmilenioJpaController();
        Troncales troncales = new Troncales(7, "Troncal C", "C");
        Zonas zonas = new Zonas(7, troncales, "F", "Amarillo");
        troncales.getZonases().add(zonas);
        zonas.setTroncales(troncales);
        
        Estaciones estaciones = new Estaciones(7, zonas, "Calle 161");
        estaciones.setZonas(zonas);
        zonas.getEstacioneses().add(estaciones);
        
        TipoServicio tipoServicio = new TipoServicio(7, "Ruta Facil");
        Servicios servicios = new Servicios(7, tipoServicio, "F14", "Azul", EnumServicios.COMPLETO.toString());
        RutasId rutasId = new RutasId(servicios.getIdServicio(), estaciones.getIdEstacion());
        Rutas rutas = new Rutas(rutasId, estaciones, servicios, (byte)1, (byte)0);
        
        estaciones.getRutases().add(rutas);
        servicios.getRutases().add(rutas);
        
        Dias dias = new Dias(7, "Lunes-Viernes");
        HorarioId horarioId = new HorarioId(servicios.getIdServicio(), dias.getIdDia());
        Horario horario = new Horario(horarioId, dias, servicios, new Date(), new Date());
        dias.getHorarios().add(horario);
        servicios.getHorarios().add(horario);
        
        Usuarios usuarios = new Usuarios(7, "Miguel", "Vargas", "343");
        Recorridos recorridos = new Recorridos(usuarios, new Date(), new Date());
        usuarios.setRecorridos(recorridos);
        recorridos.setUsuariosIdUsuario(usuarios.getIdUsuario());
        
        RecorridosHasServiciosId recorridosHasServiciosId = new RecorridosHasServiciosId(usuarios.getIdUsuario(), servicios.getIdServicio());
        RecorridosHasServicios recorridosHasServicios = new RecorridosHasServicios(recorridosHasServiciosId, estaciones, estaciones, recorridos, servicios, "1");
        estaciones.getRecorridosHasServiciosesForEstacionInicio().add(recorridosHasServicios);
        recorridos.getRecorridosHasServicioses().add(recorridosHasServicios);
        servicios.getRecorridosHasServicioses().add(recorridosHasServicios);
        
        SessionManagment.openSessionHibernate(usuarios);
        SessionManagment.openSessionHibernate(servicios);
        
        System.out.println("Satisfactorio!!");
        System.exit(0);
    }
    
}
