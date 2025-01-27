package com.parkee.parkee_backend_engineer_test.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BukuRequestDTO {

    @NotBlank(message = "judul buku tidak boleh kosong")
    private String judulBuku;

    @NotBlank(message = "nomor ISBN tidak boleh kosong")
    private String nomorIsbn;

    @NotNull(message = "stok buku tidak boleh kosong")
    @Min(value=0, message="minimal input 0")
    private Integer stokBuku;
}
