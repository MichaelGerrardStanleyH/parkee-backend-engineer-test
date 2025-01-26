package com.parkee.parkee_backend_engineer_test.service;

import com.parkee.parkee_backend_engineer_test.dto.BukuRequestDTO;
import com.parkee.parkee_backend_engineer_test.entity.Buku;
import com.parkee.parkee_backend_engineer_test.repository.BukuRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BukuService {

    @Autowired
    private BukuRepository bukuRepository;

    public List<Buku> get(){
        return this.bukuRepository.findAll();
    }

    public Buku getById(Long id){
        Buku existBuku = this.bukuRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("no buku with id " + id)
        );

        return existBuku;
    }


    public Buku create(BukuRequestDTO dto){
        Buku buku = new Buku();
        buku.setJudulBuku(dto.getJudulBuku());
        buku.setStokBuku(dto.getStokBuku());
        buku.setNomorIsbn(dto.getNomorIsbn());

        return this.bukuRepository.save(buku);
    }

    public Buku update(Long id, BukuRequestDTO dto){

        Buku existBuku = this.getById(id);


        existBuku.setJudulBuku(dto.getJudulBuku());
        existBuku.setStokBuku(dto.getStokBuku());
        existBuku.setNomorIsbn(dto.getNomorIsbn());

        return this.bukuRepository.save(existBuku);
    }

    public void delete(Long id){

        Buku existBuku = this.getById(id);

        this.bukuRepository.delete(existBuku);
    }

    public Buku save(Buku buku){
        return this.bukuRepository.save(buku);
    }

}
