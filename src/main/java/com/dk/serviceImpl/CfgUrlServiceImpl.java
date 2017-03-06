package com.dk.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dk.entity.CfgUrlEntity;
import com.dk.result.DKResult;
import com.dk.service.CfgUrlService;
import com.dk.util.DKUtil;

@Service
public class CfgUrlServiceImpl implements CfgUrlService{

	public DKResult addCfgUrlEntity(CfgUrlEntity cfgUrlEntity) {
		// TODO Auto-generated method stub
		DKResult result = new DKResult();
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = DKUtil.getConnection();
			String sql = "insert into cfgUrl(Url,DateCreated) values(?,?)";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, cfgUrlEntity.getUrl());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			try {
				Date time = sdf.parse(cfgUrlEntity.getDateCreated());
				sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				ps.setTimestamp(2, Timestamp.valueOf(sdf.format(time)));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			ps.execute();
			
			result.setState(true);
			result.setMessage("save successed!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			result.setState(false);
			result.setMessage("save failed");
			e.printStackTrace();
		} finally{
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(ps!=null){
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return result;
		
	}

	public DKResult getCfgUrlEntitys() {
		// TODO Auto-generated method stub
		DKResult result = new DKResult();
		List<CfgUrlEntity> datas = new ArrayList<CfgUrlEntity>();
		Connection conn = null;
		Statement st = null;
		
		try {
			conn = DKUtil.getConnection();
			String sql = "select id,Url,DateCreated from cfgUrl";
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				CfgUrlEntity data = new CfgUrlEntity();
				data.setId(rs.getInt("Id"));
				data.setUrl(rs.getString("Url"));
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
//				data.setDateCreated(rs.getTimestamp("DateCreated"));
				Timestamp time = rs.getTimestamp("DateCreated");
				data.setDateCreated(sdf.format(time));
				datas.add(data);
			}
			
			result.setData(datas);
			result.setState(true);
			result.setMessage("操作成功");
		} catch (SQLException e) {
			result.setMessage("操作失败");
			result.setState(false);
			e.printStackTrace();
		} finally{
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(st!=null){
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	public DKResult updateCfgUrlEntity(CfgUrlEntity cfgUrlEntity) {
		// TODO Auto-generated method stub
		DKResult result = new DKResult();
		Connection conn = null;
		PreparedStatement ps = null;
		
		String sql = "update cfgurl set Url = ?,DateCreated = ? where Id = ?";
		conn = DKUtil.getConnection();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, cfgUrlEntity.getUrl());
//			ps.setString(2, cfgUrlEntity.getDateCreated());
			ps.setInt(3, cfgUrlEntity.getId());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			String dateCreated = cfgUrlEntity.getDateCreated();
			try {
				Date time = sdf.parse(dateCreated);
				sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				ps.setTimestamp(2, Timestamp.valueOf(sdf.format(time)));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			ps.execute();
			result.setState(true);
			result.setMessage("操作成功");
			result.setId(cfgUrlEntity.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			result.setState(false);
			result.setMessage("操作失败");
			result.setId(cfgUrlEntity.getId());
			e.printStackTrace();
		} finally{
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(ps!=null){
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	public DKResult deleteCfgUrlEntity(Integer id) {
		// TODO Auto-generated method stub
		DKResult result = new DKResult();
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "delete from cfgurl where id = ?";
		
		try {
			conn = DKUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
			result.setId(id);
			result.setState(true);
			result.setMessage("操作成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			result.setId(id);
			result.setState(false);
			result.setMessage("操作失败");
			e.printStackTrace();
		} finally{
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(ps!=null){
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return result;
	}

}
