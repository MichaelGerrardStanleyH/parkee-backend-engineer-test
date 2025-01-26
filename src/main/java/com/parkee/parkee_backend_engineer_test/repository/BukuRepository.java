package com.parkee.parkee_backend_engineer_test.repository;

import com.parkee.parkee_backend_engineer_test.entity.Buku;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BukuRepository extends JpaRepository<Buku, Long> {
}
