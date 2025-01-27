package com.parkee.parkee_backend_engineer_test.service;

import com.parkee.parkee_backend_engineer_test.dto.PeminjamRequestDTO;
import com.parkee.parkee_backend_engineer_test.entity.Peminjam;
import com.parkee.parkee_backend_engineer_test.repository.PeminjamRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeminjamService {

    @Autowired
    private PeminjamRepository peminjamRepository;


    public List<Peminjam> get(){
        return this.peminjamRepository.findAll();
    }

    public Peminjam getById(Long id){
        return this.peminjamRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("tidak ada peminjam dengan id " + id)
        );
    }

    public Peminjam create(PeminjamRequestDTO dto){
        Peminjam peminjam = new Peminjam();

        peminjam.setEmail(dto.getEmail());
        peminjam.setNama(dto.getNama());
        peminjam.setNoKTP(dto.getNoKTP());

        return this.peminjamRepository.save(peminjam);
    }

    public Peminjam update(Long id, PeminjamRequestDTO dto){
        Peminjam existPeminjam = this.getById(id);

        existPeminjam.setEmail(dto.getEmail());
        existPeminjam.setNama(dto.getNama());
        existPeminjam.setNoKTP(dto.getNoKTP());

        return this.peminjamRepository.save(existPeminjam);
    }

    public void delete(Long id){
        Peminjam existPeminjam = this.getById(id);

        this.peminjamRepository.delete(existPeminjam);
    }



}


