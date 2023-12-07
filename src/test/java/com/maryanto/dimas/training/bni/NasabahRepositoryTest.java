package com.maryanto.dimas.training.bni;

import com.maryanto.dimas.training.bni.dao.NasabahInt;
import com.maryanto.dimas.training.bni.model.Nasabah;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootTest
@Slf4j
public class NasabahDaoTest {

    private NasabahInt dao;

    @Autowired
    public NasabahDaoTest(@Qualifier("nasabahDaoNamedParamTemplate") NasabahInt dao) {
        this.dao = dao;
    }

    @Test
    public void testFindNasabahByCif() {
        Optional<Nasabah> nasabah001Optional = this.dao.findByCif("001");
        Assertions.assertTrue(nasabah001Optional.isPresent(), "check nasabah 001 datanya ada!");
        log.info("check nasabah 001 datanya ada!, {}", nasabah001Optional.isPresent());

//        List<Nasabah> list = this.dao.findAll();
//        log.info("check jumlah data nasabah ada: {}", list.size());
//        Assertions.assertEquals(list.size(), 1, "Jumlah data nasabah ada 1!");

    }

    @Test
    public void testSaveNasabah() {
        Nasabah dimas = this.dao.save(new Nasabah("002", "002", "Dimas", "Maryanto", LocalDate.of(2023, 12, 7), LocalDateTime.now()));

        Optional<Nasabah> nasabah002Optional = this.dao.findByCif(dimas.getCif());
        log.info("check data nasabah 002: {}", nasabah002Optional.isPresent());
        Assertions.assertNotNull(nasabah002Optional.get());
        Nasabah nasabah = nasabah002Optional.get();
        Assertions.assertEquals("Maryanto", nasabah.getNamaBelakang(), "Check nama nasabah ==> Maryanto");
    }

    @Test
    public void testUpdateNasabah(){
        Optional<Nasabah> nasabah002Optional = this.dao.findByCif("002");
        log.info("check data nasabah 002: {}", nasabah002Optional.isPresent());
        Assertions.assertNotNull(nasabah002Optional.get());
        Nasabah nasabah = nasabah002Optional.get();
        Assertions.assertEquals("Maryanto", nasabah.getNamaBelakang(), "Check nama nasabah ==> Maryanto");

        nasabah.setNamaBelakang("Maryanto (updated)");
        this.dao.update(nasabah);

        this.dao.findByCif("002");
        log.info("check data nasabah 002: {}", nasabah002Optional.isPresent());
        Assertions.assertNotNull(nasabah002Optional.get());
        nasabah = nasabah002Optional.get();
        Assertions.assertEquals("Maryanto (updated)", nasabah.getNamaBelakang(), "Check nama nasabah ==> Maryanto (updated)");
    }

}
