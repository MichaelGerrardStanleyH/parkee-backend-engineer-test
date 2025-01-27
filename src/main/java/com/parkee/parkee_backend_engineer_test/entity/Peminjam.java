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
public class Peminjam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPeminjam;

    private String noKTP;

    private String nama;

    private String email;



}


