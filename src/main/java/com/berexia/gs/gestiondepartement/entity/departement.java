package com.berexia.gs.gestiondepartement.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


public class departement {

    long idDepart;
    String nomDepart;
    long Capacite;
    List<employe> employes = new ArrayList<employe>();
    public long getIdDepart() {
        return idDepart;
    }

    public void setIdDepart(long idDepart) {
        this.idDepart = idDepart;
    }

    public String getNomDepart() {
        return nomDepart;
    }

    public void setNomDepart(String nomDepart) {
        this.nomDepart = nomDepart;
    }

    public long getCapacite() {
        return Capacite;
    }

    public void setCapacite(long capacite) {
        Capacite = capacite;
    }

    public List<employe> getEmployes() {
        return employes;
    }

    public void setEmployes(List<employe> employes) {
        this.employes = employes;
    }


}
