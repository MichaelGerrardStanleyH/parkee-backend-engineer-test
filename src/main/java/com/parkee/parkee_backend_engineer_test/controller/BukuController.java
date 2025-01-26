package com.parkee.parkee_backend_engineer_test.controller;

import com.parkee.parkee_backend_engineer_test.dto.BukuRequestDTO;
import com.parkee.parkee_backend_engineer_test.entity.Buku;
import com.parkee.parkee_backend_engineer_test.service.BukuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/buku")
public class BukuController {

    @Autowired
    private BukuService bukuService;

    @GetMapping
    public ResponseEntity<?> getAllBuku(){
        List<Buku> bukuList = this.bukuService.get();

        return ResponseEntity.status(HttpStatus.OK).body(bukuList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBukuById(@PathVariable("id") Long id){
        Buku existBuku = this.bukuService.getById(id);

        return ResponseEntity.status(HttpStatus.OK).body(existBuku);
    }


    @PostMapping
    public ResponseEntity<?> createBuku(@RequestBody BukuRequestDTO dto){
        Buku buku = this.bukuService.create(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(buku);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBuku(@PathVariable("id") Long id, @RequestBody BukuRequestDTO dto){
        Buku buku = this.bukuService.update(id, dto);

        return ResponseEntity.status(HttpStatus.OK).body(buku);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBuku(@PathVariable("id") Long id){
        this.bukuService.delete(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
