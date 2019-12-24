package com.berexia.gs.gestiondepartement.service;

import com.berexia.gs.gestiondepartement.entity.departement;
import com.berexia.gs.gestiondepartement.entity.employe;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
@RunWith(SpringRunner.class)
@SpringBootTest
public class departementServiceTest {
    @Autowired(required = true)
    departementService derpartementService;
    @Test
    public void findDepartementById() {
    }

    @Test
    public void addDepartement() {
        departement dept = new departement();
        dept.setIdDepart(1L);
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
    }

    @Test
    public void updateDepartement() {
    }

    @Test
    public void getAllDepartement() {
    }
}