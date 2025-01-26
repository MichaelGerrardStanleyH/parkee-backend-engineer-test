package com.parkee.parkee_backend_engineer_test.service;

import com.parkee.parkee_backend_engineer_test.dto.TransaksiPinjamRequestDTO;
import com.parkee.parkee_backend_engineer_test.entity.Buku;
import com.parkee.parkee_backend_engineer_test.entity.Peminjam;
import com.parkee.parkee_backend_engineer_test.entity.TransaksiPinjam;
import com.parkee.parkee_backend_engineer_test.repository.TransaksiPinjamRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TransaksiPinjamService {

    @Autowired
    private TransaksiPinjamRepository transaksiPinjamRepository;

    @Autowired
    private PeminjamService peminjamService;

    @Autowired
    private BukuService bukuService;


    public List<TransaksiPinjam> get(){
        return this.transaksiPinjamRepository.findAll();
    }

    public TransaksiPinjam getById(Long id){
        TransaksiPinjam existTransaksiPinjam = this.transaksiPinjamRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("no transaksi pinjam with id " + id)
        );

        return existTransaksiPinjam;
    }

    public TransaksiPinjam pinjamBuku(TransaksiPinjamRequestDTO dto){
        Buku existBuku = this.bukuService.getById(dto.getIdBuku());

        if(existBuku.getStokBuku() < 1){
            throw new ValidationException("Stock buku habis");
        }

        Peminjam existPeminjam = this.peminjamService.getById(dto.getIdPeminjam());

        Optional<TransaksiPinjam> optionalTransaksiPinjam = this.transaksiPinjamRepository.findByPeminjamAndIsPinjam(existPeminjam, true);

        if(optionalTransaksiPinjam.isPresent()){
            throw new ValidationException("Ada peminjaman yang sedang berjalan");
        }

        existBuku.setStokBuku(existBuku.getStokBuku() - 1);
//        this.bukuService.save(existBuku);


        TransaksiPinjam transaksiPinjam = new TransaksiPinjam();

        transaksiPinjam.setTanggalPinjam(LocalDate.now());
        transaksiPinjam.setIsPinjam(true);
        transaksiPinjam.setBuku(existBuku);
        transaksiPinjam.setPeminjam(existPeminjam);
        transaksiPinjam.setDeadlinePengembalian(dto.getDeadlinePengembalian());

        return this.transaksiPinjamRepository.save(transaksiPinjam);
    }

    public void delete(Long id){
        TransaksiPinjam existTransaksiPinjam = this.getById(id);

        this.transaksiPinjamRepository.delete(existTransaksiPinjam);
    }

}
