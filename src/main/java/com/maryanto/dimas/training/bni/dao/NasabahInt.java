package com.maryanto.dimas.training.bni.dao;

import com.maryanto.dimas.training.bni.model.Nasabah;

import java.util.List;
import java.util.Optional;

public interface NasabahInt {

    public List<Nasabah> findAll();

    public Optional<Nasabah> findByCif(String cif);
}
