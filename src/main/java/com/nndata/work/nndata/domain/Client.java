package com.nndata.work.nndata.domain;

import com.nndata.work.nndata.persintence.entity.Cuenta;
import com.nndata.work.nndata.persintence.entity.Persona;

import java.util.List;

public class Client {
    private Long clientId;
    private String password;
    private Boolean state;
    private Persona item;

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public Persona getItem() {
        return item;
    }

    public void setItem(Persona item) {
        this.item = item;
    }
}
