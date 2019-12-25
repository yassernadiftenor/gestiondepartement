package com.berexia.gs.gestiondepartement.controller;

import com.berexia.gs.gestiondepartement.entity.departement;
import com.berexia.gs.gestiondepartement.entity.employe;
import com.berexia.gs.gestiondepartement.exceptions.invalidFields;
import com.berexia.gs.gestiondepartement.service.employeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = {"/employees"})
public class employeControler {
    @Autowired
     employeService employeService;
    @GetMapping(value = "/{idEmploye}")
    public ResponseEntity<employe> findEmployeById(@PathVariable Long id) {

        Optional<employe> empl = employeService.findEmplyeById(id);
        if (!empl.isPresent()) {
            return new ResponseEntity<employe>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<employe>(empl.get(), HttpStatus.OK);
    }
    @GetMapping(value = "/{employees}")
    public ResponseEntity<List<employe>> getAllDepartement(){
        List<employe> employ =employeService.getAllEmployees();
        if(employ.isEmpty()) {
            return new ResponseEntity<List<employe>>(HttpStatus.NOT_FOUND);
        }else
            return new ResponseEntity<List<employe>>(employeService.getAllEmployees(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<employe> create(@RequestBody employe empl) throws invalidFields {
        try {
            employeService.addEmplye(empl);
        } catch (Exception e) {
            return new ResponseEntity<employe>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<employe>(HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<employe> updateDepartement(@RequestBody employe employe) throws invalidFields {
        Optional<employe> empl = employeService.findEmplyeById(employe.getIdEmploye());
        if (!empl.isPresent()) {
            return new ResponseEntity<employe>(employe,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<employe>(employeService.updateEmploye(employe), HttpStatus.OK);
    }
    @DeleteMapping(value = "/{idEmploye}")
    public ResponseEntity<Void> deleteDepartement(@PathVariable Long id) throws invalidFields {
        Optional<employe> dep = employeService.findEmplyeById(id);
        if (!dep.isPresent()) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        employeService.removeEmployeById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
