package com.berexia.gs.gestiondepartement.repository;

import com.berexia.gs.gestiondepartement.entity.employe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface employeRepository extends CrudRepository<employe,Long> {
}
