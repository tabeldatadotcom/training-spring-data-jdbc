package com.maryanto.dimas.training.bni.dao;

import com.maryanto.dimas.training.bni.model.Nasabah;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class NasabahDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Nasabah> findAll() {
        String sql = "select * from nasabah";
        List<Nasabah> list = new ArrayList<>();
        this.jdbcTemplate.query(sql, rs -> {
            Nasabah n = new Nasabah(rs.getString("id"),
                    rs.getString("cif"),
                    rs.getString("nama_depan"),
                    rs.getString("nama_belakang"),
                    rs.getDate("tgl_lahir").toLocalDate(),
                    rs.getTimestamp("created_date").toLocalDateTime());
            list.add(n);
        });
        return list;
    }

    public Optional<Nasabah> findByCif(String cif) {
        String sql = "select * from nasabah where cif = ?";
        try {
            Nasabah nasabah = this.jdbcTemplate.queryForObject(
                    sql,
                    new Object[]{cif},
                    (rs, rowNum) -> {
                        return new Nasabah(rs.getString("id"),
                                rs.getString("cif"),
                                rs.getString("nama_depan"),
                                rs.getString("nama_belakang"),
                                rs.getDate("tgl_lahir").toLocalDate(),
                                rs.getTimestamp("created_date").toLocalDateTime());
                    });
            return Optional.of(nasabah);
        } catch (EmptyResultDataAccessException ers) {
            return Optional.empty();
        }
    }
}
