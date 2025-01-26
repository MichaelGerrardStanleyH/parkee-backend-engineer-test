package com.parkee.parkee_backend_engineer_test.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransaksiPinjamDTO {


    private Long idBuku;

    private Long idPeminjam;

    private LocalDate deadlinePengembalian;

}
