package com.parkee.parkee_backend_engineer_test.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BukuRequestDTO {

    private String judulBuku;

    private String nomorIsbn;

    private Integer stokBuku;
}
