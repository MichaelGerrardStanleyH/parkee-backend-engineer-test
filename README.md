## Parkee Backend Engineer Test

### Feature

- Buku (Create, Read, Update, Delete)
- Peminjam (Create, Read, Update, Delete)
- Transaksi Pinjam (PinjamBuku, BalikinBuku, Read, Delete)

### Penjelasan Fitur Pinjam dan Pengembalian pada Entity Transaksi Pinjam

- Entity Transaksi Pinjam digunakan untuk mencatat history-history peminjaman buku yang didalamnya terdapat data Buku, Peminjam, dll.
- Fitur Pinjam Buku menggunakan method
<span style="color:Yellow">POST</span> dan endpoint <span style="background-color:grey;color:black">/transaksi/pinjam</span> dengan input seperti dibawah :

```json
{
    "idBuku": 1,
    "idPeminjam": 1,
    "deadlinePengembalian": "2025-01-26"
}
```

- Fitur Pengembalian Buku menggunakan method
<span style="color:Yellow">POST</span> dan endpoint <span style="background-color:grey;color:black">/transaksi/balikin</span> dengan input seperti dibawah :

```json
{
    "idPeminjam": 1
}
```

- Terdapat field isPinjam dengan tipe data Boolean agar admin dapat mengetahui status peminjaman aktif atau tidak
- Terdapat field isTepatWaktu dengan tipe data Boolean agar admin dapat mengetahui apakah Peminjam mengembalikan Buku tepat waktu

### Git Command

- git clone: mengunggah project backend ke local
- git pull: mengambil perubahan berdasarkan commmitan terbaru

### Maven Command

- mvn clean install: mengunggah dependency-dependency yang dibutuhkan pada project ini
- mvn spring-boot:run : menjalankan project backend springboot

### Note

- Project backend menggunakan database MS SQL Server dengan konfigurasi seperti :
  - databaseName = dbParkee
  - port: 1433
  - username: sa
  - password: admin
  - jika ingin menggunakan konfigurasi sendiri bisa diubah pada file (src/main/resources/application.yaml)

### SQL DDL Query

- create table buku (id_buku bigint identity not null, judul_buku varchar(255), nomor_isbn varchar(255), stok_buku int, primary key (id_buku))

- create table peminjam (id_peminjam bigint identity not null, email varchar(255), nama varchar(255), noktp varchar(255), primary key (id_peminjam))

- create table transaksi_pinjam (id_transaksi_pinjam bigint identity not null, deadline_pengembalian date, is_pinjam bit, is_tepat_waktu bit, tanggal_pengembalian date, tanggal_pinjam date, id_buku bigint, id_peminjam bigint, primary key (id_transaksi_pinjam))

- alter table transaksi_pinjam add constraint FKqaans79eq55f1ilvs18rho4jy foreign key (id_buku) references buku

- alter table transaksi_pinjam add constraint FKdactrl212bmg25ui0txx3jymx foreign key (id_peminjam) references peminjam

### Postman Collection
- https://drive.google.com/file/d/1fqy6u4lv95MnZFrMhNi_Sdz9hKqLNh5H/view?usp=sharing
