/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author migue
 */
@Entity
@Table(name="historial")
public class Historial implements Serializable{
    
    @Id
    @Column(name = "id_persona")
    private Integer idPersona;
    
    @Column(name = "fecha_creacion")
    private Date fechaCreacion;
    
    @OneToMany(mappedBy = "historial", cascade = CascadeType.ALL)
    private Set<DosisAplicada> dosisAplicada = new HashSet<>();
    
   /* //@JoinColumn(name = "id_persona", referencedColumnName = "id")
    @OneToOne(mappedBy = "historial")
    //@PrimaryKeyJoinColumn
    private Persona persona;*/

    public Historial() {
    }

    public Historial(Integer idPersona, Date fechaCreacion) {
        this.idPersona = idPersona;
        this.fechaCreacion = fechaCreacion;
    }

    
    /*public Historial(Integer idPersona, Date fechaCreacion, Persona persona) {
        this.idPersona = idPersona;
        this.fechaCreacion = fechaCreacion;
        this.persona = persona;
    }*/

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    
    /*public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }*/

    public Set<DosisAplicada> getDosisAplicada() {
        return dosisAplicada;
    }

    public void setDosisAplicada(Set<DosisAplicada> dosisAplicada) {
        this.dosisAplicada = dosisAplicada;
    }
    
    
    
    
    
}
