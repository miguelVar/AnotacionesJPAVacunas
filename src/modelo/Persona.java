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
import javax.persistence.FetchType;
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
@Table(name = "persona")
public class Persona implements Serializable {

    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "documento")
    private String documento;
    @Column(name = "tipo_documento")
    private String tipoDocumento;
    @Column(name = "nombres")
    private String nombres;
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;

    @JoinColumn(name = "id_persona", referencedColumnName = "id")
    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Historial historial;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personaByIdHijo")
    private Set<Familiar> familiarsForIdHijo = new HashSet(0);

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personaByIdPadre")
    private Set<Familiar> familiarsForIdPadre = new HashSet(0);

    public Persona() {
    }

    public Persona(Integer id, String documento, String tipoDocumento, String nombres, String apellidos, Date fechaNacimiento) {
        this.id = id;
        this.documento = documento;
        this.tipoDocumento = tipoDocumento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
    }

    /*public Persona(Integer id, String documento, String tipoDocumento, String nombres, String apellidos, Date fechaNacimiento, Historial historial) {
     this.id = id;
     this.documento = documento;
     this.tipoDocumento = tipoDocumento;
     this.nombres = nombres;
     this.apellidos = apellidos;
     this.fechaNacimiento = fechaNacimiento;
     this.historial = historial;
     }*/
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Historial getHistorial() {
        return historial;
    }

    public void setHistorial(Historial historial) {
        this.historial = historial;
    }

    public Set getFamiliarsForIdHijo() {
        return familiarsForIdHijo;
    }

    public void setFamiliarsForIdHijo(Set familiarsForIdHijo) {
        this.familiarsForIdHijo = familiarsForIdHijo;
    }

    public Set getFamiliarsForIdPadre() {
        return familiarsForIdPadre;
    }

    public void setFamiliarsForIdPadre(Set familiarsForIdPadre) {
        this.familiarsForIdPadre = familiarsForIdPadre;
    }

}
