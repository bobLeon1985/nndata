package com.nndata.work.nndata.persintence.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="clientes")
public class Movimientos implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "movimientosid")
    private Long movimientosid;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "tipo_movimiento")
    private String tipoMovimiento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private BigDecimal valor;
    @Column(name = "saldo")
    private BigDecimal saldo;
    @JoinColumn(name = "cuentaid", referencedColumnName = "cuentaid")
    @ManyToOne(fetch = FetchType.LAZY)
    private Cuenta cuentaid;

    public Movimientos() {
    }

    public Movimientos(Long movimientosid) {
        this.movimientosid = movimientosid;
    }

    public Long getMovimientosid() {
        return movimientosid;
    }

    public void setMovimientosid(Long movimientosid) {
        this.movimientosid = movimientosid;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Cuenta getCuentaid() {
        return cuentaid;
    }

    public void setCuentaid(Cuenta cuentaid) {
        this.cuentaid = cuentaid;
    }

}
