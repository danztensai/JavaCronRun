package com.bmt.cron.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.bmt.cron.controller.Accounting;
import com.bmt.cron.model.Rep_neraca_harian_temp;
import com.bmt.cron.model.Transaksi_detail;

public class DBUtil {
	
	final String TBL_NERACA_TEMP = "rep_neraca_harian_temp";
	
	static Logger log = Logger.getLogger(DBUtil.class);
	public static void closePreparedStatement( PreparedStatement p) {
        try {
            p.clearParameters();
            p.close();
        }
        catch (SQLException e) {
            log.error((Object)"Error", (Throwable)e);
        }
    }
	
	public void Update_temp_neraca_harian(double saldo_akhir1,double saldo_akhir2,double saldo_akhir3,double saldo_akhir4,String flag_last_upd,int flag,String kode_perk,String tanggal)
	{
		
		
		ConnectionManager conMan1 = new ConnectionManager();
		Connection con1 = conMan1.logOn();
		PreparedStatement pst1 = null;
		
		String SqlQuery ="update "+TBL_NERACA_TEMP+" "
				+ "set "
				+ "saldo_akhir1 = ? ,"
				+ "saldo_akhir2 = ? ,"
				+ "saldo_akhir3 = ? ,"
				+ "saldo_akhir4 = ? ,"
				+ "flag_last_upd = ? ,"
				+ "flag = ? where "
				+ "kode_perk = ? and "
				+ "flag = ? and "
				+ "dtm = ? ";
		try {
			pst1 = con1.prepareStatement(SqlQuery);
			pst1.setDouble(1, saldo_akhir1);
			pst1.setDouble(2, saldo_akhir2);
			pst1.setDouble(3, saldo_akhir3);
			pst1.setDouble(4, saldo_akhir4);
			pst1.setString(5,Accounting.currentDatetime());
			pst1.setInt(6, flag);
			pst1.setString(8, kode_perk);
			pst1.setInt(9, 0);
			pst1.setString(10, tanggal);
			pst1.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closePreparedStatement(pst1);
			conMan1.logOff();
		}
		
	
		
	}
	
	public void Update_temp_neraca_harian_by_id_perk(
			double saldo_akhir1,double saldo_akhir2,double saldo_akhir3,double saldo_akhir4,
			String flag_last_upd,
			int flag,
			int id_perk,
			String tanggal)
	{
		
		
		ConnectionManager conMan1 = new ConnectionManager();
		Connection con1 = conMan1.logOn();
		PreparedStatement pst1 = null;
		
		String SqlQuery ="update "+TBL_NERACA_TEMP+" "
				+ "set "
				+ "saldo_akhir1 = ? ,"
				+ "saldo_akhir2 = ? ,"
				+ "saldo_akhir3 = ? ,"
				+ "saldo_akhir4 = ? ,"
				+ "flag_last_upd = ? ,"
				+ "flag = ? where "
				+ "ID_PERK = ? and "
				+ "dtm = ? ";
		try {
			pst1 = con1.prepareStatement(SqlQuery);
			pst1.setDouble(1, saldo_akhir1);
			pst1.setDouble(2, saldo_akhir2);
			pst1.setDouble(3, saldo_akhir3);
			pst1.setDouble(4, saldo_akhir4);
			pst1.setString(5,Accounting.currentDatetime());
			pst1.setInt(6, flag);
			pst1.setInt(8, id_perk);
			pst1.setInt(9, 0);
			pst1.setString(10, tanggal);
			pst1.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closePreparedStatement(pst1);
			conMan1.logOff();
		}
		
	
		
	}
	public boolean Ins_report_perkiran()
	{
		boolean status = false;
		
		ConnectionManager conMan1 = new ConnectionManager();
		Connection con1 = conMan1.logOn();
		PreparedStatement pst1 = null;
		String SqlQuery ="insert into rep_neraca_harian_temp (kode_perk,kode_induk,type_perk,id_perk,id_induk,level_perk,g_or_d,dtm,d_or_k)  "
				+ "select kode_perk,kode_induk,type_perk,id_perk,id_induk,level_perk,g_or_d,?,d_or_k from perkiraan order by kode_perk";
		try {
			pst1 = con1.prepareStatement(SqlQuery);
			pst1.setString(1, Accounting.currentDate());
			pst1.executeUpdate();
			status = true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closePreparedStatement(pst1);
			conMan1.logOff();
		}
		
		
		return status;
	}
	
	public int countReportPerkiraan()
	{
		ConnectionManager conMan = new ConnectionManager();
		Connection con = conMan.logOn();
		PreparedStatement pst = null;
		String querySelect ="select count(*) as total from rep_neraca_harian_temp where dtm = ?";
		
		int count_total = 0;
		try {
			pst = con.prepareStatement(querySelect);
			pst.setString(1, Accounting.currentDate());
			
			ResultSet rs = pst.executeQuery();
			while (rs.next())
			{
				count_total = rs.getInt("total");
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closePreparedStatement(pst);
			conMan.logOff();
		}
		return count_total;
	}
	
	public int Perkiraan_idInduk_by_kdPerk(String kodePerk,String dtm)
	{
		ConnectionManager conMan = new ConnectionManager();
		Connection con = conMan.logOn();
		PreparedStatement pst = null;
		String querySelect ="select "
				+ "ID_INDUK"
				+ " from "+TBL_NERACA_TEMP
				+ " where ID_PERK = ? and dtm = ?";
		
		int id_induk = 0;
		try {
			pst = con.prepareStatement(querySelect);
			pst.setString(1, kodePerk);
			pst.setString(2, dtm);
			ResultSet rs = pst.executeQuery();
			while (rs.next())
			{
				id_induk = rs.getInt("ID_INDUK");
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closePreparedStatement(pst);
			conMan.logOff();
		}
		return id_induk;
	}
	
	public List<Transaksi_detail> trans_detail_saldo_awal(String tgl,String kode_perk)
	{
		List<Transaksi_detail> transDetail = new ArrayList<Transaksi_detail>();
		ConnectionManager conMan = new ConnectionManager();
		Connection con = conMan.logOn();
		PreparedStatement pst = null;
		String querySelect ="select sum(debet) as debet,"
				+ "sum(kredit) as kredit"
				+ "from transaksi_detail"
				+ "where kode_perk = ?"
				+ "and master_id in "
				+ "(select trans_id from tansaksi_master where "
				+ "date (tgl_trans) < ?)";
		
		
	
		try {
		 
			pst = con.prepareStatement(querySelect);
			pst.setString(1, kode_perk);
			pst.setString(2, tgl);
			
			
			ResultSet rs = pst.executeQuery();
			while (rs.next())
			{
				Transaksi_detail transModel = new 				Transaksi_detail();
				
				transModel.setDebet(rs.getDouble("debet"));
				transModel.setKredit(rs.getDouble("kredit"));
				
				transDetail.add(transModel);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closePreparedStatement(pst);
			conMan.logOff();
		}

		return transDetail;
	}
	
	public List<Transaksi_detail> trans_detail_dork(String tgl,String kode_perk)
	{
		List<Transaksi_detail> transDetail = new ArrayList<Transaksi_detail>();
		ConnectionManager conMan = new ConnectionManager();
		Connection con = conMan.logOn();
		PreparedStatement pst = null;
		String querySelect ="select sum(debet) as debet,"
				+ "sum(kredit) as kredit"
				+ "from transaksi_detail"
				+ "where kode_perk = ?"
				+ "and master_id in "
				+ "(select trans_id from tansaksi_master where "
				+ "date(tgl_trans) = ?)";
		
		
	
		try {
		 
			pst = con.prepareStatement(querySelect);
			pst.setString(1, kode_perk);
			pst.setString(2, tgl);
			
			
			ResultSet rs = pst.executeQuery();
			while (rs.next())
			{
				Transaksi_detail transModel = new 				Transaksi_detail();
				
				transModel.setDebet(rs.getDouble("debet"));
				transModel.setKredit(rs.getDouble("kredit"));
				
				transDetail.add(transModel);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closePreparedStatement(pst);
			conMan.logOff();
		}

		return transDetail;
	}
	public List<Rep_neraca_harian_temp> Perkiraan_by_gord(String dtm)
	{
		List<Rep_neraca_harian_temp> rep =new ArrayList<Rep_neraca_harian_temp>();;
		
		
		ConnectionManager conMan = new ConnectionManager();
		Connection con = conMan.logOn();
		PreparedStatement pst = null;
		String querySelect ="SELECT KODE_PERK, ID_PERK, TYPE_PERK, "
				+ "LEVEL_PERK,D_OR_K from "+TBL_NERACA_TEMP+""
				+ " WHERE dtm = "
				+ "? AND G_OR_D=? AND flag =?";
		
		
	
		try {
		
			pst = con.prepareStatement(querySelect);
			pst.setString(1, dtm);
			pst.setString(2, "D");
			pst.setString(3, "0");
			
			ResultSet rs = pst.executeQuery();
			while (rs.next())
			{
				Rep_neraca_harian_temp repModel = new Rep_neraca_harian_temp();
				
				repModel.setKode_perk(rs.getString("KODE_PERK"));
				repModel.setId_perk(rs.getInt("ID_PERK"));
				repModel.setType_perk(rs.getString("TYPE_PERK"));
				repModel.setLevel_perk(rs.getInt("LEVEL_PERK"));
				
				rep.add(repModel);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closePreparedStatement(pst);
			conMan.logOff();
		}
		return rep; 
		
	}
	
	public List<Rep_neraca_harian_temp> Trans_main_induk(int id_induk)
	{
		List<Rep_neraca_harian_temp> rep =new ArrayList<Rep_neraca_harian_temp>();;
		
		
		ConnectionManager conMan = new ConnectionManager();
		Connection con = conMan.logOn();
		PreparedStatement pst = null;
		String querySelect ="select sum(saldo_akhir1) as awal,"
				+ "sum(saldo_akhir2) as debet,"
				+ "sum(saldo_akhir3) as kredit"
				+ "sum(saldo_akhir4) as akhir"
				+ "from "+TBL_NERACA_TEMP+" where id_induk = ?";
		
		
	
		try {
		
			pst = con.prepareStatement(querySelect);
			pst.setInt(1, id_induk);
			
			
			ResultSet rs = pst.executeQuery();
			while (rs.next())
			{
				Rep_neraca_harian_temp repModel = new Rep_neraca_harian_temp();
				
				repModel.setKode_perk(rs.getString("KODE_PERK"));
				repModel.setId_perk(rs.getInt("ID_PERK"));
				repModel.setSaldo_akhir1(rs.getDouble("awal"));
				repModel.setSaldo_akhir2(rs.getDouble("debet"));
				repModel.setSaldo_akhir3(rs.getDouble("kredit"));
				repModel.setSaldo_akhir4(rs.getDouble("akhir"));				
				rep.add(repModel);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closePreparedStatement(pst);
			conMan.logOff();
		}
		return rep; 
		
	}
	

}
