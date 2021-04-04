package com.human.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import com.human.dto.BDto;

public class BDao {
	
	DataSource dataSource;
	public BDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/myoracle");		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection conn = null;
	public static PreparedStatement ps = null;
	public static ResultSet  rs = null;
	
	public ArrayList<BDto> list(){	
		ArrayList<BDto> dtos = new ArrayList<BDto>();
		
		try {
			conn = dataSource.getConnection();
			String sql = "select * from mvc_board order by bGroup desc, bStep";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int bId = rs.getInt(1);
				String bName = rs.getString(2);
				String bTitle = rs.getString(3);
				String bContent = rs.getString(4);
				String bDate = rs.getString(5);
				int bHit = rs.getInt(6);
				int bGroup= rs.getInt(7);
				int bStep = rs.getInt(8);
				int bIndent = rs.getInt(9);
			
				BDto dto = new BDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
				dtos.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return dtos;
	}

	public void write(String bName, String bTitle, String bContent) {
		
		try {
			conn = dataSource.getConnection();
			String sql = "insert into mvc_board values(mvc_board_seq.nextVal, ?, ?, ?, 0 ,mvc_board_seq.currVal,0,0,0)";
			ps = conn.prepareStatement(sql);
			
			ps.setString(2, bName);
			ps.setString(3, bTitle);
			ps.setString(4, bContent);
			ps.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}

	public BDto contentView(String bId) {
		
		BDto dto = null;
		try {
			conn = dataSource.getConnection();
			String sql = "select * from mvc_board where bId=?";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, bId);
			ps.executeQuery();
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int bId2 = rs.getInt(1);
				String bName = rs.getString(2);
				String bTitle = rs.getString(3);
				String bContent = rs.getString(4);
				String bDate = rs.getString(5);
				int bHit = rs.getInt(6);
				int bGroup= rs.getInt(7);
				int bStep = rs.getInt(8);
				int bIndent = rs.getInt(9);
				
				dto = new BDto(bId2, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return dto;
	}
	
	
	
	
	public void upHit(String bId) {
		try {
			conn = dataSource.getConnection();
			String sql = "update mvc_board set bHit = bHit+1 where bId=? ";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, bId);
			ps.executeQuery();
			ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}

	public BDto delete(String bId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
