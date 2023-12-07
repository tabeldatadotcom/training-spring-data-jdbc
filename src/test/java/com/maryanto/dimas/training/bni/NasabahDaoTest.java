package com.maryanto.dimas.training.bni;

import com.maryanto.dimas.training.bni.dao.NasabahDao;
import com.maryanto.dimas.training.bni.model.Nasabah;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@Slf4j
public class NasabahDaoTest {

    private NasabahDao dao;

    @Autowired
    public NasabahDaoTest(NasabahDao dao) {
        this.dao = dao;
    }

    @Test
    public void testFindNasabahByCif() {
        Optional<Nasabah> nasabah001Optional = this.dao.findByCif("001");
        Assertions.assertTrue(nasabah001Optional.isPresent(), "check nasabah 001 datanya ada!");
        log.info("check nasabah 001 datanya ada!, {}", nasabah001Optional.isPresent());

        List<Nasabah> list = this.dao.findAll();
        log.info("check jumlah data nasabah ada: {}", list.size());
        Assertions.assertEquals(list.size(), 1, "Jumlah data nasabah ada 1!");

    }
}
