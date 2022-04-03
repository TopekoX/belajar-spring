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
	
	// mendefinisikan init method
	public void startUpMahasiswa() {
		System.out.println("BudiMahasiswa: di dalam method startUpMahasiswa");
	}
	
	// mendefinisikan destroy method
	public void destroyMahasiswa() {
		System.out.println("BudiMahasiswa: di dalam method destroyMahasiswa");
	}
	
}
