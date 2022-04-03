package com.tutorialtimposu.spring.belajar;

public class CitraMahasiswa implements Mahasiswa {

	private JadwalService jadwalService;
	
	// tambah field email dan alamat
	private String email;
	private String alamat;
	
	// membuat constructor no-arg
	public CitraMahasiswa() {
		System.out.println("CitraMahasiswa: di dalam no-arg constructor");
	}
	
	// membuat setter	
	public void setJadwalService(JadwalService jadwalService) {
		System.out.println("CitraMahasiswa: di dalam method setter");
		this.jadwalService = jadwalService;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		System.out.println("CitraMahasiswa: di dalam method - setter Email");
		this.email = email;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		System.out.println("CitraMahasiswa: di dalam method - setter Alamat");
		this.alamat = alamat;
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
