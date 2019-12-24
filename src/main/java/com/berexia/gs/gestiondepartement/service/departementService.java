package com.berexia.gs.gestiondepartement.service;

import com.berexia.gs.gestiondepartement.entity.departement;
import com.berexia.gs.gestiondepartement.exceptions.emptyFields;
import com.berexia.gs.gestiondepartement.exceptions.invalidFields;
import com.berexia.gs.gestiondepartement.repository.departementRepository;
import com.sun.tools.sjavac.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Log4j2
@Service
public class departementService {

    departementRepository departementRepository ;

    public Optional<departement> findDepartementById(Long idDept) {
        return departementRepository.findById(idDept);
    }

    public departement addDepartement(departement dept) {
        if(dept.getNomDepart()==""){
            throw new emptyFields("the departement name is empty ");
        }else if(departementByName(dept.getNomDepart())!=null){
            throw  new invalidFields("the departement name already exist");
        }else {
            Log.info("departement has been added");
            return departementRepository.save(dept);
        }
    }

    public void removeDepartementById(Long idDept) {
        if (findDepartementById(idDept).isPresent()) {
            Log.info("departement has been removed successfully");
            departementRepository.deleteById(idDept);
        }
    }

    public departement updateDepartement(departement dept) {
        departement deptReturn = null;
        if (findDepartementById(dept.getIdDepart()).isPresent()) {
            Log.info("departement has been updated successfully");
           deptReturn=   departementRepository.save(dept);
        }
        return deptReturn;
    }
    public List<departement> getAllDepartement(){
        return (List<departement>) departementRepository.findAll();
    }
    public departement departementByName(String deptName ){
        for (departement dept :departementRepository.findAll()){
            if(dept.getNomDepart().equals(deptName)){
            return dept;
            }
        }
        return null;
    }
}

