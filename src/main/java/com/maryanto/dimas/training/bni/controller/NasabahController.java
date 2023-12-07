package com.maryanto.dimas.training.bni.controller;

import com.maryanto.dimas.training.bni.dao.NasabahDaoJdbcTemplate;

public class NasabahController {

    private NasabahDaoJdbcTemplate dao;

    public void getNasabah(){
        dao.findByCif("123434");

    }
}
