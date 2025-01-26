package com.parkee.parkee_backend_engineer_test.controller;

import com.parkee.parkee_backend_engineer_test.dto.TransaksiPinjamRequestDTO;
import com.parkee.parkee_backend_engineer_test.entity.TransaksiPinjam;
import com.parkee.parkee_backend_engineer_test.service.TransaksiPinjamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pinjam")
public class TransaksiPinjamController {

    @Autowired
    private TransaksiPinjamService transaksiPinjamService;

    @GetMapping
    public ResponseEntity<?> getAllPinjamDetail(){
        List<TransaksiPinjam> transaksiPinjamList = this.transaksiPinjamService.get();

        return ResponseEntity.status(HttpStatus.OK).body(transaksiPinjamList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPinjamDetail(@PathVariable("id") Long id){
        TransaksiPinjam existTransaksiPinjam = this.transaksiPinjamService.getById(id);

        return ResponseEntity.status(HttpStatus.OK).body(existTransaksiPinjam);
    }

    @PostMapping
    public ResponseEntity<?> pinjam(@RequestBody TransaksiPinjamRequestDTO dto){
        TransaksiPinjam transaksiPinjam = this.transaksiPinjamService.pinjamBuku(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(transaksiPinjam);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePinjamDetail(@PathVariable("id") Long id){
        this.transaksiPinjamService.delete(id);

        return ResponseEntity.status(HttpStatus.OK).build();
    }



}
