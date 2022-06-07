package com.nndata.work.nndata.domain.dto;

import com.nndata.work.nndata.domain.exceptions.InvalidMovementTypeException;
import com.nndata.work.nndata.persintence.entity.Movimientos;
import com.nndata.work.nndata.persintence.entity.TipoMovimiento;


import java.math.BigDecimal;
import java.util.Date;

public class NewMovementData {

    private BigDecimal saldo;

    private String tipoMovimiento;

    private Date fecha;

    private BigDecimal valor;

    public NewMovementData(){}

    public NewMovementData(BigDecimal saldo, String type){
        this.saldo = saldo;
        this.tipoMovimiento = type;
    }

    public Movimientos toMovement() throws InvalidMovementTypeException {
        try {
            TipoMovimiento _type = TipoMovimiento.valueOf(tipoMovimiento);
            return new Movimientos(_type, new Date(), saldo);
        } catch (Exception e) {
            throw new InvalidMovementTypeException(tipoMovimiento);
        }
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
