package com.maryanto.dimas.training.bni.controller;

import com.maryanto.dimas.training.bni.dao.NasabahDao;

public class NasabahController {

    private NasabahDao dao;

    public void getNasabah(){
        dao.findByCif("123434");

    }
}
