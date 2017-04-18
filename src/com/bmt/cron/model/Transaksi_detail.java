package com.bmt.cron.model;

public class Transaksi_detail {
	int id;
	int master_id;
	String kode_perk;
	double debet;
	double kredit;
	String keterangan;
	
	
	public Transaksi_detail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Transaksi_detail(int id, int master_id, String kode_perk, double debet, double kredit, String keterangan) {
		super();
		this.id = id;
		this.master_id = master_id;
		this.kode_perk = kode_perk;
		this.debet = debet;
		this.kredit = kredit;
		this.keterangan = keterangan;
	}
	@Override
	public String toString() {
		return "Transaksi_detail [id=" + id + ", master_id=" + master_id + ", kode_perk=" + kode_perk + ", debet="
				+ debet + ", kredit=" + kredit + ", keterangan=" + keterangan + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(debet);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + id;
		result = prime * result + ((keterangan == null) ? 0 : keterangan.hashCode());
		result = prime * result + ((kode_perk == null) ? 0 : kode_perk.hashCode());
		temp = Double.doubleToLongBits(kredit);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + master_id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaksi_detail other = (Transaksi_detail) obj;
		if (Double.doubleToLongBits(debet) != Double.doubleToLongBits(other.debet))
			return false;
		if (id != other.id)
			return false;
		if (keterangan == null) {
			if (other.keterangan != null)
				return false;
		} else if (!keterangan.equals(other.keterangan))
			return false;
		if (kode_perk == null) {
			if (other.kode_perk != null)
				return false;
		} else if (!kode_perk.equals(other.kode_perk))
			return false;
		if (Double.doubleToLongBits(kredit) != Double.doubleToLongBits(other.kredit))
			return false;
		if (master_id != other.master_id)
			return false;
		return true;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMaster_id() {
		return master_id;
	}
	public void setMaster_id(int master_id) {
		this.master_id = master_id;
	}
	public String getKode_perk() {
		return kode_perk;
	}
	public void setKode_perk(String kode_perk) {
		this.kode_perk = kode_perk;
	}
	public double getDebet() {
		return debet;
	}
	public void setDebet(double debet) {
		this.debet = debet;
	}
	public double getKredit() {
		return kredit;
	}
	public void setKredit(double kredit) {
		this.kredit = kredit;
	}
	public String getKeterangan() {
		return keterangan;
	}
	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}
	
	

}
