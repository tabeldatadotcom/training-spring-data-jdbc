package com.maryanto.dimas.training.bni.dao;

import com.maryanto.dimas.training.bni.model.Nasabah;

import java.util.List;
import java.util.Optional;

public interface NasabahInt {

    List<Nasabah> findAll();

    Optional<Nasabah> findByCif(String cif);

    Nasabah save(Nasabah nasabah);

    void update(Nasabah nasabah);

    void delete(String id);
}
