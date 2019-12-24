package com.berexia.gs.gestiondepartement.repository;

import com.berexia.gs.gestiondepartement.entity.departement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface departementRepository extends CrudRepository<departement,Long> {
}
