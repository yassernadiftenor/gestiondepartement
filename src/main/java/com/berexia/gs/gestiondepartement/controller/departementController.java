package com.berexia.gs.gestiondepartement.controller;

import com.berexia.gs.gestiondepartement.entity.departement;
import com.berexia.gs.gestiondepartement.exceptions.invalidFields;
import com.berexia.gs.gestiondepartement.service.departementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = {"/departements"})
public class departementController {
    @Autowired
    departementService departementService;
    @GetMapping(value = "/{id}")
    public ResponseEntity<departement> findDepartementById(@PathVariable Long id) {

        Optional<departement> dep = departementService.findDepartementById(id);
        if (!dep.isPresent()) {
            return new ResponseEntity<departement>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<departement>(dep.get(), HttpStatus.OK);
    }
    @GetMapping(value = "/{departements}")
    public ResponseEntity<List<departement>> getAllDepartement(){
        List<departement> depts =departementService.getAllDepartement();
        if(depts.isEmpty()) {
            return new ResponseEntity<List<departement>>(HttpStatus.NOT_FOUND);
        }else
            return new ResponseEntity<List<departement>>(departementService.getAllDepartement(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<departement> create(@RequestBody departement dep) throws invalidFields {
        try {
            departementService.addDepartement(dep);
        } catch (Exception e) {
            return new ResponseEntity<departement>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<departement>(HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<departement> updateDepartement(@RequestBody departement dep) throws invalidFields {
        Optional<departement> dept = departementService.findDepartementById(dep.getIdDepart());
        if (!dept.isPresent()) {
            return new ResponseEntity<departement>(dep,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<departement>(departementService.updateDepartement(dep), HttpStatus.OK);
    }
    @DeleteMapping(value = "/{idDepartement}")
    public ResponseEntity<Void> deleteDepartement(@PathVariable Long id) throws invalidFields {
        Optional<departement> dep = departementService.findDepartementById(id);
        if (!dep.isPresent()) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        departementService.removeDepartementById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
