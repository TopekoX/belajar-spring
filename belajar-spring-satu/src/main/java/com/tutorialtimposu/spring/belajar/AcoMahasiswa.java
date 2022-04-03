package com.tutorialtimposu.spring.belajar;

public class AcoMahasiswa implements Mahasiswa {
	
	// mendefinisikan variabel private depedency JadwalService
	private JadwalService jadwalService;
	
	// mendefiniskan  constructor private depedency JadwalService
	public AcoMahasiswa(JadwalService jadwalService) {
		this.jadwalService = jadwalService;
	}

	@Override
	public String getFakultas() {
		return "Aco kuliah di Fakultas Hukum";
	}

	@Override
	public String getJadwalHarian() {
		
		// menggunakan jadwalService getJadwal
		return jadwalService.getJadwal();
	}
	
}
