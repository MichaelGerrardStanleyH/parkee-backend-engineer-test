package com.parkee.parkee_backend_engineer_test.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PinjamDetailResponseDTO {

    private Long idPinjamDetail;

    private LocalDate borrowedDate;

    private Boolean isBorrowed;

    private Boolean isOnTime;

    private LocalDate returnedDate;

    private BukuResponseDTO buku;

    private PeminjamResponseDTO peminjam;


}

