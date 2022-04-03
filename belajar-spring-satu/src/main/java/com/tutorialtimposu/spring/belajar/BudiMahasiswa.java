package com.tutorialtimposu.spring.belajar;

public class BudiMahasiswa implements Mahasiswa {

	// mendefinisikan variabel private depedency JadwalService
	private JadwalService jadwalService;

	
	
	public BudiMahasiswa(JadwalService jadwalService) {
		this.jadwalService = jadwalService;
	}

	@Override
	public String getFakultas() {

		return "Budi kuliah di Fakultas FKIP";
	}

	@Override
	public String getJadwalHarian() {
		return jadwalService.getJadwal();
	}

}
