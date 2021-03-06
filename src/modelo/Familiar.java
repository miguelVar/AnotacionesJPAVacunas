package modelo;
// Generated 2/10/2020 08:48:06 PM by Hibernate Tools 4.3.1

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Familiar generated by hbm2java
 */
@Entity
@Table(name = "familiar")
public class Familiar implements java.io.Serializable {

    @Id
    @Column(name = "id_familiar")
    private Integer idFamiliar;
    
    @JoinColumn(name = "id_hijo", nullable = false)
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Persona personaByIdHijo;
    
    @JoinColumn(name = "id_padre", nullable = false)
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Persona personaByIdPadre;

    public Familiar() {
    }

    public Familiar(Integer idFamiliar) {
        this.idFamiliar = idFamiliar;
    }
    

    public Familiar(Integer idFamiliar, Persona personaByIdHijo, Persona personaByIdPadre) {
        this.idFamiliar = idFamiliar;
        this.personaByIdHijo = personaByIdHijo;
        this.personaByIdPadre = personaByIdPadre;
    }

    public Integer getIdFamiliar() {
        return this.idFamiliar;
    }

    public void setIdFamiliar(Integer idFamiliar) {
        this.idFamiliar = idFamiliar;
    }

    public Persona getPersonaByIdHijo() {
        return this.personaByIdHijo;
    }

    public void setPersonaByIdHijo(Persona personaByIdHijo) {
        this.personaByIdHijo = personaByIdHijo;
    }

    public Persona getPersonaByIdPadre() {
        return this.personaByIdPadre;
    }

    public void setPersonaByIdPadre(Persona personaByIdPadre) {
        this.personaByIdPadre = personaByIdPadre;
    }

}
