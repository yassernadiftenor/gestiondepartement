package com.berexia.gs.gestiondepartement.service;

import com.berexia.gs.gestiondepartement.entity.departement;
import com.berexia.gs.gestiondepartement.exceptions.emptyFields;
import com.berexia.gs.gestiondepartement.exceptions.invalidFields;
import com.berexia.gs.gestiondepartement.repository.departementRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class departementService {
    @Autowired
    departementRepository departementRepository ;
   departement dept;
    public static final Logger logger = LogManager.getLogger(departementService.class.getName());

    public Optional<departement> findDepartementById(Long idDept) {
        return departementRepository.findById(idDept);
    }

    public void addDepartement(departement dept) {
        if(dept.getNomDepart().equals("")){
            throw new emptyFields("the departement name is empty ");
        }else if(departementByName(dept.getNomDepart())!=null){
            throw  new invalidFields("the departement name already exist");
        } else {
            logger.info("departement has been added");
            departementRepository.save(dept);
        }

    }

    public void removeDepartementById(Long idDept) {
        if (findDepartementById(idDept).isPresent()) {
            logger.info("departement has been removed successfully");
            departementRepository.deleteById(idDept);
        }
    }

    public departement updateDepartement(departement dept) {
        departement deptReturn = null;
        if (findDepartementById(dept.getIdDepart()).isPresent()) {
            logger.info("departement has been updated successfully");
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

