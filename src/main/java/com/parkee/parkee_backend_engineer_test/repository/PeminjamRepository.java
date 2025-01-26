package com.parkee.parkee_backend_engineer_test.repository;

import com.parkee.parkee_backend_engineer_test.entity.Peminjam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeminjamRepository extends JpaRepository<Peminjam, Long> {
}
