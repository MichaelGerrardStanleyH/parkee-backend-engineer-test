package com.parkee.parkee_backend_engineer_test.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TransaksiPinjam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTransaksiPinjam;

    private LocalDate tanggalPinjam;

    private Boolean isPinjam;

    private Boolean isTepatWaktu;

    private LocalDate deadlinePengembalian;

    private LocalDate tanggalPengembalian;

    @ManyToOne
    @JoinColumn(name = "idBuku", referencedColumnName = "idBuku")
    private Buku buku;

    @ManyToOne
    @JoinColumn(name = "idPeminjam", referencedColumnName = "idPeminjam")
    private Peminjam peminjam;

}
