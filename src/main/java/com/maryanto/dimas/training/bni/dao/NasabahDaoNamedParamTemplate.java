package com.maryanto.dimas.training.bni.dao;

import com.maryanto.dimas.training.bni.model.Nasabah;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Repository
public class NasabahDaoNamedParamTemplate implements NasabahInt {

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

    @Override
    public Nasabah save(Nasabah nasabah) {
        String sql = "insert into nasabah (id, cif, nama_depan, nama_belakang, tgl_lahir, created_date) values (:id, :cif, :namaDepan, :namaBelakang, :tglLahir, :createdDate)";
        MapSqlParameterSource param = new MapSqlParameterSource();
        nasabah.setId(UUID.randomUUID().toString());
        param.addValue("id", nasabah.getId());
        param.addValue("cif", nasabah.getCif());
        param.addValue("namaDepan", nasabah.getNamaDepan());
        param.addValue("namaBelakang", nasabah.getNamaBelakang());
        param.addValue("tglLahir", Date.valueOf(nasabah.getTanggalLahir()));
        param.addValue("createdDate", Timestamp.valueOf(LocalDateTime.now()));

        this.jdbcOperations.update(sql, param);
        return nasabah;
    }

    @Override
    public void update(Nasabah nasabah) {
        String sql = "update nasabah set nama_depan = :namaDepan, nama_belakang = :namaBelakang, tgl_lahir = :tanggalLahir where id = :id";
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("id", nasabah.getId());
        param.addValue("cif", nasabah.getCif());
        param.addValue("namaDepan", nasabah.getNamaDepan());
        param.addValue("namaBelakang", nasabah.getNamaBelakang());
        param.addValue("tanggalLahir", Date.valueOf(nasabah.getTanggalLahir()));

        this.jdbcOperations.update(sql, param);
    }

    @Override
    public void delete(String id) {
        String sql = "delete from nasabah where id = :id";
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("id", id);

        this.jdbcOperations.update(sql, param);
    }
}

