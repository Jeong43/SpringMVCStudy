/*====================================================
   #11. RegionDAO.java
   - 데이터베이스 액션 처리 클래스
   - 지역 정보 입력/ 출력 / 수정 / 삭제 액션
   - Connection 객체에 대한 의존성 주입을 위한 준비
     → 인터페이스 형태의 속성 구성(DataSource)
     → setter 메소드 정의 
====================================================*/
package com.test.mvc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

public class RegionDAO implements IRegionDAO
{
	private DataSource dataSource;

	public DataSource getDataSource()
	{
		return dataSource;
	}

	@Override
	public ArrayList<Region> list() throws SQLException
	{
		Connection conn = dataSource.getConnection();
		
		ArrayList<Region> result = new ArrayList<Region>();
		String sql = "SELECT REGIONID, REGIONNAME, DELCHECK"
				   + " FROM REGIONVIEW"
				   + " ORDER BY REGIONID";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next())
		{
			Region region = new Region();
			region.setRegionId(rs.getString("REGIONID"));
			region.setRegionName(rs.getString("REGIONNAME"));
			region.setDelCheck(rs.getInt("DELCHECK"));
			
			result.add(region);
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return result;
	}

	@Override
	public int add(Region region) throws SQLException
	{
		Connection conn = dataSource.getConnection();
		
		int result = 0;
		String sql = "INSERT INTO REGION(REGIONID, REGIONNAME)"
				   + " VALUES(REGIONSEQ.NEXTVAL, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, region.getRegionName());
		result = pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
		
		return result;
	}

	@Override
	public int remove(String regionId) throws SQLException
	{
		Connection conn = dataSource.getConnection();
		
		int result = 0;
		String sql = "DELETE"
				   + " FROM REGION"
				   + " WHERE REGIONID=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		result = pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
		
		return result;
	}

	@Override
	public int modify(Region region) throws SQLException
	{
		Connection conn = dataSource.getConnection();
		
		int result = 0;
		String sql = "UPDATE REGION"
				   + " SET REGIONNAME=?"
				   + " WHERE REGIONID=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, region.getRegionName());
		pstmt.setInt(2, Integer.parseInt(region.getRegionName()));
		result = pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
		
		return result;
	}
	
}
