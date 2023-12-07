package com.maryanto.dimas.training.bni.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tabungan")
public class Tabungan {

    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "no_rekening")
    private String noRek;
    @ManyToOne
    @JoinColumn(name = "nasabah_id")
    private Nasabah nasabah;
    @Column(name = "saldo")
    private BigDecimal saldo;

}
