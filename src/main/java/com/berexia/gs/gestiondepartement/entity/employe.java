package com.berexia.gs.gestiondepartement.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class employe {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    long idEmploye;
    String nomEmploye;
    String prenomEmploye;
    String ville;
    @ManyToOne
    departement departement;

    public departement getDepartement() {
        return departement;
    }

    public void setDepartement(departement departement) {
        this.departement = departement;
    }

    public long getIdEmploye() {
        return idEmploye;
    }

    public void setIdEmploye(long idEmploye) {
        this.idEmploye = idEmploye;
    }

    public String getNomEmploye() {
        return nomEmploye;
    }

    public void setNomEmploye(String nomEmploye) {
        this.nomEmploye = nomEmploye;
    }

    public String getPrenomEmploye() {
        return prenomEmploye;
    }

    public void setPrenomEmploye(String prenomEmploye) {
        this.prenomEmploye = prenomEmploye;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
}
