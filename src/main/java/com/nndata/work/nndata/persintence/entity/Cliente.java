package com.nndata.work.nndata.persintence.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "cliente")
public class Cliente extends BasePersona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "clienteid")
    private Long clienteid;

    @Column(name = "contrasenia")
    private String contrasenia;

    @Column(name = "estado")
    private Boolean estado;

    /*@JoinColumn(name = "personaid", referencedColumnName = "personaid")
    @OneToOne(fetch = FetchType.LAZY)
    private Persona personaid;*/

    @OneToMany(mappedBy = "clienteid", fetch = FetchType.LAZY)
        private List<Cuenta> cuentaList;

    public Cliente() {
    }

    public Cliente(Long clienteid) {
        this.clienteid = clienteid;
    }

    public Long getClienteid() {
        return clienteid;
    }

    public void setClienteid(Long clienteid) {
        this.clienteid = clienteid;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    /*public Persona getPersonaid() {
        return personaid;
    }
    public void setPersonaid(Persona personaid) {
        this.personaid = personaid;
    }*/

    public List<Cuenta> getCuentaList() {
        return cuentaList;
    }

    public void setCuentaList(List<Cuenta> cuentaList) {
        this.cuentaList = cuentaList;
    }

}
