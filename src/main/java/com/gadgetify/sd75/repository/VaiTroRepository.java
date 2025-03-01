package com.gadgetify.sd75.repository;

import com.gadgetify.sd75.entity.VaiTro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface VaiTroRepository extends JpaRepository<VaiTro, UUID> {
    Optional<VaiTro> findByTenVaiTro(String tenVaiTro);
    Optional<VaiTro> findVaiTroByTenVaiTro(String tenVaiTro);
}
