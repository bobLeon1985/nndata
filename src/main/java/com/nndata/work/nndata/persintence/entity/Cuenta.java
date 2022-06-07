package com.nndata.work.nndata.persintence.entity;

import java.math.BigDecimal;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="cuenta")
public class Cuenta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cuentaid")
    private Long cuentaid;
    @Column(name = "numero_cuenta")
    private Integer numeroCuenta;
    @Column(name = "tipo_cuenta")
    private String tipoCuenta;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "saldo_inicial")
    private BigDecimal saldoInicial;
    @Column(name = "estado")
    private Boolean estado;

    @JoinColumn(name = "clienteid", referencedColumnName = "clienteid")
    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente clienteid;

    @OneToMany(mappedBy = "cuentaid", fetch = FetchType.LAZY)
    private List<Movimientos> movimientosList;

    public Cuenta() {
    }

    public Cuenta(Long cuentaid) {
        this.cuentaid = cuentaid;
    }

    public Long getCuentaid() {
        return cuentaid;
    }

    public void setCuentaid(Long cuentaid) {
        this.cuentaid = cuentaid;
    }

    public Integer getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(Integer numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public BigDecimal getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(BigDecimal saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Cliente getClienteid() {
        return clienteid;
    }

    public void setClienteid(Cliente clienteid) {
        this.clienteid = clienteid;
    }

    public List<Movimientos> getMovimientosList() {
        return movimientosList;
    }

    public void setMovimientosList(List<Movimientos> movimientosList) {
        this.movimientosList = movimientosList;
    }

}
