package com.bmt.cron.model;

import java.util.Date;

public class Rep_neraca_harian_temp {
	int tid;
	Date dtm;
	String kode_perk;
	String kode_induk;
	String type_perk;
	int level_perk;
	int id_perk;
	int id_induk;
	String g_or_d;
	double saldo_akhir1;
	double saldo_akhir2;
	double saldo_akhir3;
	double saldo_akhir4;
	double saldo_akhir5;
	double saldo_akhir6;
	double saldo_akhir7;
	double saldo_akhir8;
	double saldo_akhir9;
	double saldo_akhir10;
	String D_or_K ;
	int flag;
	Date flag_last_upd;
	String flagDesc;
	
	
	@Override
	public String toString() {
		return "Rep_neraca_harian_temp [tid=" + tid + ", dtm=" + dtm + ", kode_perk=" + kode_perk + ", kode_induk="
				+ kode_induk + ", type_perk=" + type_perk + ", level_perk=" + level_perk + ", id_perk=" + id_perk
				+ ", id_induk=" + id_induk + ", g_or_d=" + g_or_d + ", saldo_akhir1=" + saldo_akhir1 + ", saldo_akhir2="
				+ saldo_akhir2 + ", saldo_akhir3=" + saldo_akhir3 + ", saldo_akhir4=" + saldo_akhir4 + ", saldo_akhir5="
				+ saldo_akhir5 + ", saldo_akhir6=" + saldo_akhir6 + ", saldo_akhir7=" + saldo_akhir7 + ", saldo_akhir8="
				+ saldo_akhir8 + ", saldo_akhir9=" + saldo_akhir9 + ", saldo_akhir10=" + saldo_akhir10 + ", D_or_K="
				+ D_or_K + ", flag=" + flag + ", flag_last_upd=" + flag_last_upd + ", flagDesc=" + flagDesc + "]";
	}
	public Rep_neraca_harian_temp() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Rep_neraca_harian_temp(int tid, Date dtm, String kode_perk, String kode_induk, String type_perk,
			int level_perk, int id_perk, int id_induk, String g_or_d, double saldo_akhir1, double saldo_akhir2,
			double saldo_akhir3, double saldo_akhir4, double saldo_akhir5, double saldo_akhir6, double saldo_akhir7,
			double saldo_akhir8, double saldo_akhir9, double saldo_akhir10, String d_or_K, int flag, Date flag_last_upd,
			String flagDesc) {
		super();
		this.tid = tid;
		this.dtm = dtm;
		this.kode_perk = kode_perk;
		this.kode_induk = kode_induk;
		this.type_perk = type_perk;
		this.level_perk = level_perk;
		this.id_perk = id_perk;
		this.id_induk = id_induk;
		this.g_or_d = g_or_d;
		this.saldo_akhir1 = saldo_akhir1;
		this.saldo_akhir2 = saldo_akhir2;
		this.saldo_akhir3 = saldo_akhir3;
		this.saldo_akhir4 = saldo_akhir4;
		this.saldo_akhir5 = saldo_akhir5;
		this.saldo_akhir6 = saldo_akhir6;
		this.saldo_akhir7 = saldo_akhir7;
		this.saldo_akhir8 = saldo_akhir8;
		this.saldo_akhir9 = saldo_akhir9;
		this.saldo_akhir10 = saldo_akhir10;
		D_or_K = d_or_K;
		this.flag = flag;
		this.flag_last_upd = flag_last_upd;
		this.flagDesc = flagDesc;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((D_or_K == null) ? 0 : D_or_K.hashCode());
		result = prime * result + ((dtm == null) ? 0 : dtm.hashCode());
		result = prime * result + flag;
		result = prime * result + ((flagDesc == null) ? 0 : flagDesc.hashCode());
		result = prime * result + ((flag_last_upd == null) ? 0 : flag_last_upd.hashCode());
		result = prime * result + ((g_or_d == null) ? 0 : g_or_d.hashCode());
		result = prime * result + id_induk;
		result = prime * result + id_perk;
		result = prime * result + ((kode_induk == null) ? 0 : kode_induk.hashCode());
		result = prime * result + ((kode_perk == null) ? 0 : kode_perk.hashCode());
		result = prime * result + level_perk;
		long temp;
		temp = Double.doubleToLongBits(saldo_akhir1);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(saldo_akhir10);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(saldo_akhir2);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(saldo_akhir3);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(saldo_akhir4);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(saldo_akhir5);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(saldo_akhir6);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(saldo_akhir7);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(saldo_akhir8);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(saldo_akhir9);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + tid;
		result = prime * result + ((type_perk == null) ? 0 : type_perk.hashCode());
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
		Rep_neraca_harian_temp other = (Rep_neraca_harian_temp) obj;
		if (D_or_K == null) {
			if (other.D_or_K != null)
				return false;
		} else if (!D_or_K.equals(other.D_or_K))
			return false;
		if (dtm == null) {
			if (other.dtm != null)
				return false;
		} else if (!dtm.equals(other.dtm))
			return false;
		if (flag != other.flag)
			return false;
		if (flagDesc == null) {
			if (other.flagDesc != null)
				return false;
		} else if (!flagDesc.equals(other.flagDesc))
			return false;
		if (flag_last_upd == null) {
			if (other.flag_last_upd != null)
				return false;
		} else if (!flag_last_upd.equals(other.flag_last_upd))
			return false;
		if (g_or_d == null) {
			if (other.g_or_d != null)
				return false;
		} else if (!g_or_d.equals(other.g_or_d))
			return false;
		if (id_induk != other.id_induk)
			return false;
		if (id_perk != other.id_perk)
			return false;
		if (kode_induk == null) {
			if (other.kode_induk != null)
				return false;
		} else if (!kode_induk.equals(other.kode_induk))
			return false;
		if (kode_perk == null) {
			if (other.kode_perk != null)
				return false;
		} else if (!kode_perk.equals(other.kode_perk))
			return false;
		if (level_perk != other.level_perk)
			return false;
		if (Double.doubleToLongBits(saldo_akhir1) != Double.doubleToLongBits(other.saldo_akhir1))
			return false;
		if (Double.doubleToLongBits(saldo_akhir10) != Double.doubleToLongBits(other.saldo_akhir10))
			return false;
		if (Double.doubleToLongBits(saldo_akhir2) != Double.doubleToLongBits(other.saldo_akhir2))
			return false;
		if (Double.doubleToLongBits(saldo_akhir3) != Double.doubleToLongBits(other.saldo_akhir3))
			return false;
		if (Double.doubleToLongBits(saldo_akhir4) != Double.doubleToLongBits(other.saldo_akhir4))
			return false;
		if (Double.doubleToLongBits(saldo_akhir5) != Double.doubleToLongBits(other.saldo_akhir5))
			return false;
		if (Double.doubleToLongBits(saldo_akhir6) != Double.doubleToLongBits(other.saldo_akhir6))
			return false;
		if (Double.doubleToLongBits(saldo_akhir7) != Double.doubleToLongBits(other.saldo_akhir7))
			return false;
		if (Double.doubleToLongBits(saldo_akhir8) != Double.doubleToLongBits(other.saldo_akhir8))
			return false;
		if (Double.doubleToLongBits(saldo_akhir9) != Double.doubleToLongBits(other.saldo_akhir9))
			return false;
		if (tid != other.tid)
			return false;
		if (type_perk == null) {
			if (other.type_perk != null)
				return false;
		} else if (!type_perk.equals(other.type_perk))
			return false;
		return true;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public Date getDtm() {
		return dtm;
	}
	public void setDtm(Date dtm) {
		this.dtm = dtm;
	}
	public String getKode_perk() {
		return kode_perk;
	}
	public void setKode_perk(String kode_perk) {
		this.kode_perk = kode_perk;
	}
	public String getKode_induk() {
		return kode_induk;
	}
	public void setKode_induk(String kode_induk) {
		this.kode_induk = kode_induk;
	}
	public String getType_perk() {
		return type_perk;
	}
	public void setType_perk(String type_perk) {
		this.type_perk = type_perk;
	}
	public int getLevel_perk() {
		return level_perk;
	}
	public void setLevel_perk(int level_perk) {
		this.level_perk = level_perk;
	}
	public int getId_perk() {
		return id_perk;
	}
	public void setId_perk(int id_perk) {
		this.id_perk = id_perk;
	}
	public int getId_induk() {
		return id_induk;
	}
	public void setId_induk(int id_induk) {
		this.id_induk = id_induk;
	}
	public String getG_or_d() {
		return g_or_d;
	}
	public void setG_or_d(String g_or_d) {
		this.g_or_d = g_or_d;
	}
	public double getSaldo_akhir1() {
		return saldo_akhir1;
	}
	public void setSaldo_akhir1(double saldo_akhir1) {
		this.saldo_akhir1 = saldo_akhir1;
	}
	public double getSaldo_akhir2() {
		return saldo_akhir2;
	}
	public void setSaldo_akhir2(double saldo_akhir2) {
		this.saldo_akhir2 = saldo_akhir2;
	}
	public double getSaldo_akhir3() {
		return saldo_akhir3;
	}
	public void setSaldo_akhir3(double saldo_akhir3) {
		this.saldo_akhir3 = saldo_akhir3;
	}
	public double getSaldo_akhir4() {
		return saldo_akhir4;
	}
	public void setSaldo_akhir4(double saldo_akhir4) {
		this.saldo_akhir4 = saldo_akhir4;
	}
	public double getSaldo_akhir5() {
		return saldo_akhir5;
	}
	public void setSaldo_akhir5(double saldo_akhir5) {
		this.saldo_akhir5 = saldo_akhir5;
	}
	public double getSaldo_akhir6() {
		return saldo_akhir6;
	}
	public void setSaldo_akhir6(double saldo_akhir6) {
		this.saldo_akhir6 = saldo_akhir6;
	}
	public double getSaldo_akhir7() {
		return saldo_akhir7;
	}
	public void setSaldo_akhir7(double saldo_akhir7) {
		this.saldo_akhir7 = saldo_akhir7;
	}
	public double getSaldo_akhir8() {
		return saldo_akhir8;
	}
	public void setSaldo_akhir8(double saldo_akhir8) {
		this.saldo_akhir8 = saldo_akhir8;
	}
	public double getSaldo_akhir9() {
		return saldo_akhir9;
	}
	public void setSaldo_akhir9(double saldo_akhir9) {
		this.saldo_akhir9 = saldo_akhir9;
	}
	public double getSaldo_akhir10() {
		return saldo_akhir10;
	}
	public void setSaldo_akhir10(double saldo_akhir10) {
		this.saldo_akhir10 = saldo_akhir10;
	}
	public String getD_or_K() {
		return D_or_K;
	}
	public void setD_or_K(String d_or_K) {
		D_or_K = d_or_K;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public Date getFlag_last_upd() {
		return flag_last_upd;
	}
	public void setFlag_last_upd(Date flag_last_upd) {
		this.flag_last_upd = flag_last_upd;
	}
	public String getFlagDesc() {
		return flagDesc;
	}
	public void setFlagDesc(String flagDesc) {
		this.flagDesc = flagDesc;
	}
	
}
