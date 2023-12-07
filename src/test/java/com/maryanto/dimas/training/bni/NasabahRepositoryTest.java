package com.maryanto.dimas.training.bni;

import com.maryanto.dimas.training.bni.model.Nasabah;
import com.maryanto.dimas.training.bni.repository.NasabahRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
@Slf4j
public class NasabahRepositoryTest {

    private NasabahRepository dao;

    @Autowired
    public NasabahRepositoryTest(NasabahRepository dao) {
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
        Nasabah dimas = new Nasabah(UUID.randomUUID().toString(), "003", "Dimas", "Maryanto", LocalDate.of(2023, 12, 7), LocalDateTime.now());
        dimas = this.dao.save(dimas);

//        Optional<Nasabah> nasabah002Optional = this.dao.findByCif(dimas.getCif());
//        log.info("check data nasabah 003: {}", nasabah002Optional.isPresent());
//        Assertions.assertNotNull(nasabah002Optional.get());
//        Nasabah nasabah = nasabah002Optional.get();
//        Assertions.assertEquals("Maryanto", nasabah.getNamaBelakang(), "Check nama nasabah ==> Maryanto");
    }

    @Test
    public void testUpdateNasabah() {
        Optional<Nasabah> nasabah002Optional = this.dao.findByCif("002");
        log.info("check data nasabah 002: {}", nasabah002Optional.isPresent());
        Assertions.assertNotNull(nasabah002Optional.get());
        Nasabah nasabah = nasabah002Optional.get();
        Assertions.assertEquals("Maryanto", nasabah.getNamaBelakang(), "Check nama nasabah ==> Maryanto");

        nasabah.setNamaBelakang("Maryanto (updated)");
        this.dao.save(nasabah);

        this.dao.findByCif("002");
        log.info("check data nasabah 002: {}", nasabah002Optional.isPresent());
        Assertions.assertNotNull(nasabah002Optional.get());
        nasabah = nasabah002Optional.get();
        Assertions.assertEquals("Maryanto (updated)", nasabah.getNamaBelakang(), "Check nama nasabah ==> Maryanto (updated)");
    }

}
