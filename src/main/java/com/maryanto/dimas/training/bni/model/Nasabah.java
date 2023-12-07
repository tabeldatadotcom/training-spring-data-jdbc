package com.maryanto.dimas.training.bni.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "nasabah")
@ToString(exclude = "tabunganList")
public class Nasabah {

    public Nasabah(String id, String cif, String namaDepan, String namaBelakang, LocalDate tanggalLahir, LocalDateTime createdDate) {
        this.id = id;
        this.cif = cif;
        this.namaDepan = namaDepan;
        this.namaBelakang = namaBelakang;
        this.tanggalLahir = tanggalLahir;
        this.createdDate = createdDate;
    }

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
    @OneToMany(mappedBy = "nasabah", fetch = FetchType.EAGER)
    private List<Tabungan> tabunganList = new ArrayList<>();
}
