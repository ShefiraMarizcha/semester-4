class KeluargaNode {
    String nama;
    String jenisKelamin;
    String relasi;
    KeluargaNode kiri;  // anak pertama
    KeluargaNode kanan; // anak kedua

    public KeluargaNode(String nama, String jenisKelamin, String relasi) {
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.relasi = relasi;
    }
}
