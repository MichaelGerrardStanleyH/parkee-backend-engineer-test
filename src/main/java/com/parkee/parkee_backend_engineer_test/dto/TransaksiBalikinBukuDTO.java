package com.parkee.parkee_backend_engineer_test.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TransaksiBalikinBukuDTO {

    @NotNull(message = "stok buku tidak boleh kosong")
    @Min(value=1, message="minimal input 1")
    private Long idPeminjam;

}


