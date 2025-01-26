package com.parkee.parkee_backend_engineer_test.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Buku {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBuku;

    private String judulBuku;

    private String nomorIsbn;

    private Integer stokBuku;

}


