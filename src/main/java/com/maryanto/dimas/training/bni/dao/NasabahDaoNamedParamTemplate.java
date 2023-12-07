package com.maryanto.dimas.training.bni.dao;

import com.maryanto.dimas.training.bni.model.Nasabah;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
public class NasabahDaoNamedParamTemplate implements NasabahInt{

    private NamedParameterJdbcOperations jdbcOperations;

    @Autowired
    public NasabahDaoNamedParamTemplate(NamedParameterJdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    public List<Nasabah> findAll() {
        log.info("from nasabah dao named param operation");
        String sql = "select * from nasabah";
        List<Nasabah> list = new ArrayList<>();
        this.jdbcOperations.query(sql, rs -> {
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
        log.info("from nasabah dao named param operation");
        String sql = "select * from nasabah where cif = :cif";
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("cif", cif);
        try {
            Nasabah nasabah = this.jdbcOperations.queryForObject(
                    sql,
                    param,
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

