/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author migue
 */
@Entity
@Table(name="enfermedad")
public class Enfermedad implements Serializable{
    
    @Id
    @Column(name="id_enfermedad")
    private Integer id;
    @Column(name="nombre")
    private String nombre;
    @Column(name="description")
    private String descripcion;
    
    @ManyToMany(cascade = {CascadeType.ALL}, mappedBy = "enfermedades")
    private Set<Vacuna> vacunas = new HashSet<>();

    public Enfermedad() {
    }

    public Enfermedad(Integer id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<Vacuna> getVacunas() {
        return vacunas;
    }

    public void setVacunas(Set<Vacuna> vacunas) {
        this.vacunas = vacunas;
    }
    
    
}
