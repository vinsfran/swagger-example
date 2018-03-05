package com.example.swaggerexample.model;

import java.util.Date;

public class Rhmperso {

    private String codPerson;
    private String apePerson;
    private String nomPerson;
    private Date fecIngins;

    public Rhmperso() {
    }

    public Rhmperso(String codPerson, String apePerson, String nomPerson, Date fecIngins) {
        this.codPerson = codPerson;
        this.apePerson = apePerson;
        this.nomPerson = nomPerson;
        this.fecIngins = fecIngins;
    }

    public String getCodPerson() {
        return codPerson;
    }

    public void setCodPerson(String codPerson) {
        this.codPerson = codPerson;
    }

    public String getApePerson() {
        return apePerson;
    }

    public void setApePerson(String apePerson) {
        this.apePerson = apePerson;
    }

    public String getNomPerson() {
        return nomPerson;
    }

    public void setNomPerson(String nomPerson) {
        this.nomPerson = nomPerson;
    }

    public Date getFecIngins() {
        return fecIngins;
    }

    public void setFecIngins(Date fecIngins) {
        this.fecIngins = fecIngins;
    }

}
