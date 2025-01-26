package com.parkee.parkee_backend_engineer_test.controller;

import com.parkee.parkee_backend_engineer_test.dto.TransaksiBalikinBukuDTO;
import com.parkee.parkee_backend_engineer_test.dto.TransaksiPinjamDTO;
import com.parkee.parkee_backend_engineer_test.entity.TransaksiPinjam;
import com.parkee.parkee_backend_engineer_test.service.TransaksiPinjamService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/transaksi")
public class TransaksiPinjamController {

    @Autowired
    private TransaksiPinjamService transaksiPinjamService;

    @GetMapping("/pinjam")
    public ResponseEntity<?> getAllPinjamDetail(){
        List<TransaksiPinjam> transaksiPinjamList = this.transaksiPinjamService.get();

        return ResponseEntity.status(HttpStatus.OK).body(transaksiPinjamList);
    }

    @GetMapping("/pinjam/{id}")
    public ResponseEntity<?> getPinjamDetail(@PathVariable("id") Long id){
        TransaksiPinjam existTransaksiPinjam = this.transaksiPinjamService.getById(id);

        return ResponseEntity.status(HttpStatus.OK).body(existTransaksiPinjam);
    }

    @PostMapping("/pinjam")
    public ResponseEntity<?> pinjam(@Valid @RequestBody TransaksiPinjamDTO dto){
        TransaksiPinjam transaksiPinjam = this.transaksiPinjamService.pinjamBuku(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(transaksiPinjam);
    }

    @DeleteMapping("/pinjam/{id}")
    public ResponseEntity<?> deletePinjamDetail(@PathVariable("id") Long id){
        this.transaksiPinjamService.delete(id);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/balikin")
    public ResponseEntity<?> balikinBuku(@Valid @RequestBody TransaksiBalikinBukuDTO dto){

        TransaksiPinjam transaksiPinjam = this.transaksiPinjamService.balikinBuku(dto);

        return ResponseEntity.status(HttpStatus.OK).body(transaksiPinjam);
    }



}
