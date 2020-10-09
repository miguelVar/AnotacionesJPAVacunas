/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anotacionesjava;

import java.util.Calendar;
import modelo.Dosis;
import modelo.DosisAplicada;
import modelo.Enfermedad;
import modelo.Familiar;
import modelo.Historial;
import modelo.Persona;
import modelo.Vacuna;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.NewHibernateUtil;

/**
 *
 * @author migue
 */
public class AnotacionesJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Session sesion = NewHibernateUtil.getSessionFactory().openSession();
        Transaction transaction = sesion.beginTransaction();

        Enfermedad enfermedad = new Enfermedad(1, "Covid", "Covid 19");
        Persona persona = new Persona(1, "1234", "C", "Juan", "Caceres", Calendar.getInstance().getTime());
        Vacuna vacuna = new Vacuna(1, "Rusa", "Vacuna Rusa");
        Dosis dosis = new Dosis(1, vacuna, 2, "P");
        Historial historial = new Historial(persona.getId(), Calendar.getInstance().getTime());
        DosisAplicada dosisAplicada = new DosisAplicada(10, dosis, Calendar.getInstance().getTime());
        Familiar familiar = new Familiar(5);
        
        persona.setHistorial(historial);
        vacuna.getDosises().add(dosis);

        vacuna.getEnfermedades().add(enfermedad);
        enfermedad.getVacunas().add(vacuna);

        dosisAplicada.setHistorial(historial);
        dosisAplicada.setDosis(dosis);
        historial.getDosisAplicada().add(dosisAplicada);
        dosis.getDosisAplicada().add(dosisAplicada);     

        familiar.setPersonaByIdPadre(persona);
        familiar.setPersonaByIdHijo(persona);
        persona.getFamiliarsForIdHijo().add(familiar);
        persona.getFamiliarsForIdPadre().add(familiar);

        sesion.saveOrUpdate(persona);

        transaction.commit();
        sesion.close();
        System.out.println("Termino ejecución");
        System.exit(0);
    }
    
}
