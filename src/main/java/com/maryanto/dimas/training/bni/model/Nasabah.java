package com.maryanto.dimas.training.bni.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Nasabah {

    private String id;
    private String cif;
    private String namaDepan;
    private String namaBelakang;
    private LocalDate tanggalLahir;
    private LocalDateTime createdDate;
}
