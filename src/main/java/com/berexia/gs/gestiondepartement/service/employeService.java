package com.berexia.gs.gestiondepartement.service;

import com.berexia.gs.gestiondepartement.entity.departement;
import com.berexia.gs.gestiondepartement.entity.employe;
import com.berexia.gs.gestiondepartement.exceptions.emptyFields;
import com.berexia.gs.gestiondepartement.exceptions.invalidFields;
import com.berexia.gs.gestiondepartement.repository.employeRepository;
import com.sun.tools.sjavac.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class employeService {
       @Autowired
       employeRepository employeRepository1;


       public employe addEmplye(employe empl){
      if(empl.getNomEmploye()==""){
          throw new emptyFields("the name of employee is empty");
      }else {
          Log.info("employee has been added successfully");
        return   employeRepository1.save(empl);
      }
  }
      public Optional<employe> findEmplyeById(long idEmpl){
           return employeRepository1.findById(idEmpl);
      }
      public void removeEmployeById(long idEmpl){
           if(findEmplyeById(idEmpl).isPresent()){
               Log.info("employee has been removed successfully");
               employeRepository1.deleteById(idEmpl);
           }else{
               throw new invalidFields("employee id is invalid");
           }
      }
      public employe updateEmploye(employe empl){
           employe emplReturn=null;
          if (!findEmplyeById(empl.getIdEmploye()).isPresent()) {
              Log.info("employee id is invalid");
          }else {
              Log.info("employee has been updated successfully");
              emplReturn= employeRepository1.save(empl);
          }
          return emplReturn;
      }
      public List<employe> getAllEmployees(){
           return (List<employe>) employeRepository1.findAll();
      }
}
