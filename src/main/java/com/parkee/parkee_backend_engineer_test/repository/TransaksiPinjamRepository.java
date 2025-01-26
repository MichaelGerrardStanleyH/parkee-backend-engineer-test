package com.parkee.parkee_backend_engineer_test.repository;

import com.parkee.parkee_backend_engineer_test.entity.Peminjam;
import com.parkee.parkee_backend_engineer_test.entity.TransaksiPinjam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TransaksiPinjamRepository extends JpaRepository<TransaksiPinjam, Long> {

    Optional<TransaksiPinjam> findByPeminjamAndIsPinjam(Peminjam peminjam, Boolean isPinjam);

}
