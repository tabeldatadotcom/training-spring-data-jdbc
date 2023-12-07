package com.maryanto.dimas.training.bni.repository;

import com.maryanto.dimas.training.bni.model.Nasabah;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
public interface NasabahRepository extends CrudRepository<Nasabah, String> {

    Optional<Nasabah> findByCif(String cif);
}
