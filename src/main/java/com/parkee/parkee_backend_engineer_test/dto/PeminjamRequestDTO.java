package com.parkee.parkee_backend_engineer_test.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PeminjamRequestDTO {

    @NotBlank(message = "Nomor KTP tidak boleh kosong")
    private String noKTP;

    @NotBlank(message = "Nama tidak boleh kosong")
    private String nama;

    @Email(message = "Format email tidak sah")
    @NotBlank(message = "Email tidak boleh kosong")
    private String email;

}


