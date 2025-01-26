package com.parkee.parkee_backend_engineer_test.controller;

import com.parkee.parkee_backend_engineer_test.dto.PeminjamRequestDTO;
import com.parkee.parkee_backend_engineer_test.entity.Peminjam;
import com.parkee.parkee_backend_engineer_test.service.PeminjamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/peminjam")
public class PeminjamController {

    @Autowired
    private PeminjamService peminjamService;

    @GetMapping
    public ResponseEntity<?> getAllPeminjam(){
        List<Peminjam> peminjamList = this.peminjamService.get();

        return ResponseEntity.status(HttpStatus.OK).body(peminjamList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPeminjamById(@PathVariable("id") Long id){
        Peminjam existPeminjam = this.peminjamService.getById(id);

        return ResponseEntity.status(HttpStatus.OK).body(existPeminjam);
    }

    @PostMapping
    public ResponseEntity<?> createPeminjam(@RequestBody PeminjamRequestDTO dto){
        Peminjam peminjam = this.peminjamService.create(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(peminjam);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePeminjam(@PathVariable("id") Long id, @RequestBody PeminjamRequestDTO dto){
        Peminjam peminjam = this.peminjamService.update(id, dto);

        return ResponseEntity.status(HttpStatus.OK).body(peminjam);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePeminjam(@PathVariable("id") Long id){
        this.peminjamService.delete(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}


