package com.bmt.cron.controller;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import org.apache.log4j.Logger;

import com.bmt.cron.model.Rep_neraca_harian_temp;
import com.bmt.cron.model.Transaksi_detail;
import com.bmt.cron.util.DBUtil;

public class Accounting {
	static Logger log = Logger.getLogger(Accounting.class);

	public static void getNeracaHarian() {
		String transid = trxId();
		Date currentDate = new Date();
		DBUtil dbUtil = new DBUtil();
		int count_total = dbUtil.countReportPerkiraan();

		if (count_total == 0) {
			boolean statusInsert = dbUtil.Ins_report_perkiran();
			if (!statusInsert) {
				log.error("Something Wrong With Insert Report Perkiraan with trxid " + transid);
				System.exit(-1);
			}
		}
		List<Rep_neraca_harian_temp> repList = dbUtil.Perkiraan_by_gord(currentDate());

		if (repList.size() > 0) {
			log.info("Jumlah List Perkiraan_by_gord : "+repList.size());
			int counter=1;
			for (Rep_neraca_harian_temp rep : repList) {
				log.info("List Ke "+counter);
				log.debug("Isi Rep_neraca_harian_temp "+rep.toString());
				log.info("trxid : "+transid);
				process_by_kode_perk(transid, rep.getKode_perk(), currentDate(), String.valueOf(rep.getId_perk()));
				log.info("End Of List ke "+counter);
				counter++;
				
			}

		} else {
			log.error("Something Wrong with Perkiraan by Gord with trxid " + transid);
		//	System.exit(-1);
		}

	}

	public static void process_by_kode_perk(String transid, String kodePerk, String tanggal, String id_perk) {

		DBUtil dbUtil = new DBUtil();
		List<Transaksi_detail> transDetail = dbUtil.trans_detail_saldo_awal(tanggal, kodePerk);
		double awal_deb = 0;
		double awal_kre = 0;
		double tday_deb = 0;
		double tday_kre = 0;
		DecimalFormat df = new DecimalFormat("0", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
		df.setMaximumFractionDigits(340);
		for (Transaksi_detail td : transDetail) {
			awal_deb = td.getDebet();
			awal_kre = td.getKredit();
		}
		
		List<Transaksi_detail> transDork = dbUtil.trans_detail_dork(tanggal, kodePerk);
		for (Transaksi_detail td : transDork) {
			tday_deb = td.getDebet();
			tday_kre = td.getKredit();
		}
		log.info("Jumlah awal Deb : "+df.format(awal_deb)+" | awal Kre : "+df.format(awal_kre));
		log.info("Jumlah tday_Deb : "+tday_deb+" | tday_Kre : "+tday_kre);
		double count_saldo_awal = awal_deb - awal_kre;
		log.info("count_saldo_awal = awal_deb-awal_kre : "+df.format(count_saldo_awal) +"("+df.format(awal_deb)+"-"+df.format(awal_kre)+")");
		double count_saldo_akhir = count_saldo_awal + tday_deb;
		log.info("count_saldo_akhir = count_saldo_awal + tday_deb : "+df.format(count_saldo_akhir) +"("+df.format(count_saldo_awal)+"+"+df.format(tday_deb)+")");
		
		dbUtil.Update_temp_neraca_harian(count_saldo_awal, tday_deb, tday_kre, count_saldo_akhir, currentDatetime(), 1,
				kodePerk, tanggal);
		Process_by_idPerk(transid, tanggal, id_perk);

	}

	public static void Process_by_idPerk(String trxid, String tanggal, String idPerk) {
		DBUtil dbUtil = new DBUtil();
		int id_induk = dbUtil.Perkiraan_idInduk_by_kdPerk(idPerk, tanggal);
		List<Rep_neraca_harian_temp> repList = dbUtil.Trans_main_induk(id_induk);
		for (Rep_neraca_harian_temp rp : repList) {
			
			dbUtil.Update_temp_neraca_harian_by_id_perk(rp.getSaldo_akhir1(), rp.getSaldo_akhir2(),
					rp.getSaldo_akhir3(), rp.getSaldo_akhir4(), currentDatetime(), 1, Integer.parseInt(idPerk), tanggal);
			
		}

	}

	public static String trxId() {
		String pattern = "yyyyMMdd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		String date = simpleDateFormat.format(new Date()) + getSaltString();
		// System.out.println(date);
		return date;
	}

	public static String currentDate() {
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String date = sdf.format(new Date());
		return date;
	}

	public static String currentDatetime() {
		String pattern = "yyyy-MM-dd hh:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String date = sdf.format(new Date());
		return date;
	}

	public static String getSaltString() {
		String SALTCHARS = "1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 14) { // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr;

	}

	public static void main(String[] args) {
		getNeracaHarian();
	log.info("test");
	}

}
