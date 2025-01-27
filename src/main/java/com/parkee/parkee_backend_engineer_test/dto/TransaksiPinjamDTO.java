package com.parkee.parkee_backend_engineer_test.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotNull(message = "stok buku tidak boleh kosong")
    @Min(value=1, message="minimal input 1")
    private Long idBuku;

    @NotNull(message = "stok buku tidak boleh kosong")
    @Min(value=1, message="minimal input 1")
    private Long idPeminjam;

    @NotNull(message = "deadline pengembalian tidak boleh kosong")
    private LocalDate deadlinePengembalian;

}
