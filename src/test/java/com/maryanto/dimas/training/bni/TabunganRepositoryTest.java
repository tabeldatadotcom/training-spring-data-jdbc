package com.maryanto.dimas.training.bni;

import com.maryanto.dimas.training.bni.model.Tabungan;
import com.maryanto.dimas.training.bni.repository.TabunganRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
@Slf4j
public class TabunganRepositoryTest {

    private TabunganRepository repo;

    @Autowired
    public TabunganRepositoryTest(TabunganRepository repo) {
        this.repo = repo;
    }

    @Test
    public void testFindAllTabungan() {
        Optional<Tabungan> optionalTabungan = this.repo.findById("001");
        if (optionalTabungan.isPresent()) {
            log.info("data tabungan: {}", optionalTabungan.get());
        }
    }
}
