package com.berexia.gs.gestiondepartement.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Data
@Entity
public class departement {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    long idDepart;
    String nomDepart;
    long Capacite;
    @OneToMany
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
