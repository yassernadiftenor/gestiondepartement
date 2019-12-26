package com.berexia.gs.gestiondepartement.service;

import com.berexia.gs.gestiondepartement.entity.departement;
import com.berexia.gs.gestiondepartement.entity.employe;
import com.berexia.gs.gestiondepartement.exceptions.emptyFields;
import com.berexia.gs.gestiondepartement.exceptions.invalidFields;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
@RunWith(SpringRunner.class)
@SpringBootTest
public class departementServiceTest {
    @Autowired(required = true)
    departementService derpartementService;
    departement departement= new departement();
    @Test
    public void findDepartementById() {
    }

    @Test
    public void addDepartement() {
        departement dept = new departement();
        dept.setIdDepart(13L);
        dept.setNomDepart("mpùol");
        dept.setCapacite(50L);
        derpartementService.addDepartement(dept);
        Optional<departement> checkout = derpartementService.findDepartementById(dept.getIdDepart());
        assertEquals(dept.getNomDepart(), checkout.get().getNomDepart());
    }
    @Test(expected = emptyFields.class)
    public void addDepartementNomNullKo(){
        departement dept = new departement();
        dept.setIdDepart(2L);
        dept.setNomDepart("");
        List<employe> employes=new ArrayList<>();
        dept.setCapacite(50L);
        dept.setEmployes(employes);
        derpartementService.addDepartement(dept);
        Optional<departement> checkout = derpartementService.findDepartementById(dept.getIdDepart());
        assertEquals(dept.getNomDepart(), checkout.get().getNomDepart());
    }
    @Test(expected = invalidFields.class)
    public void addDepartementNomInvalid(){
        departement dept = new departement();
        dept.setIdDepart(12L);
        dept.setNomDepart("multimedia ");
        List<employe> employes=new ArrayList<>();
        dept.setCapacite(50L);
        dept.setEmployes(employes);
        derpartementService.addDepartement(dept);
        Optional<departement> checkout = derpartementService.findDepartementById(dept.getIdDepart());
        assertEquals(dept.getNomDepart(), checkout.get().getNomDepart());
    }
    @Test
    public void removeDepartementById() {
        departement dept1 = new departement();
        dept1.setIdDepart(4L);
        dept1.setNomDepart("olkuyf");
        List<employe> employes=new ArrayList<>();
        dept1.setCapacite(51L);
        dept1.setEmployes(employes);
        derpartementService.addDepartement(dept1);
        derpartementService.removeDepartementById(dept1.getIdDepart());
        Optional<departement> checkout = derpartementService.findDepartementById(dept1.getIdDepart());
        assertEquals(Optional.empty(), checkout.get());
    }

    @Test
    public void updateDepartement() {
    }

    @Test
    public void getAllDepartement() {
    }
}