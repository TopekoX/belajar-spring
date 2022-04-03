package com.tutorialtimposu.spring.belajar;

public class CitraMahasiswa implements Mahasiswa {

	private JadwalService jadwalService;
	
	// membuat constructor no-arg
	public CitraMahasiswa() {
		System.out.println("CitraMahasiswa: di dalam no-arg constructor");
	}
	
	// membuat setter	
	public void setJadwalService(JadwalService jadwalService) {
		System.out.println("CitraMahasiswa: di dalam method setter");
		this.jadwalService = jadwalService;
	}

	@Override
	public String getFakultas() {
		return "Citra kuliah di Fakultas FISIP";
	}

	@Override
	public String getJadwalHarian() {
		return jadwalService.getJadwal();
	}

}
