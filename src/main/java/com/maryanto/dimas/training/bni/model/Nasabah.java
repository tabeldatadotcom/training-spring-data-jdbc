package com.maryanto.dimas.training.bni.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "nasabah")
public class Nasabah {

    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "cif")
    private String cif;
    @Column(name = "nama_depan")
    private String namaDepan;
    @Column(name = "nama_belakang")
    private String namaBelakang;
    @Column(name = "tgl_lahir")
    private LocalDate tanggalLahir;
    @Column(name = "created_date")
    private LocalDateTime createdDate;
}
