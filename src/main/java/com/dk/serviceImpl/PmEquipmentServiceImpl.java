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

import com.dk.entity.PmEquipmentEntity;
import com.dk.result.DKResult;
import com.dk.service.PmEquipmentService;
import com.dk.util.DKUtil;

@Service
public class PmEquipmentServiceImpl implements PmEquipmentService{

	public DKResult getPmEquipmentEntitys() {
		// TODO Auto-generated method stub
		DKResult result = new DKResult();
		List<PmEquipmentEntity> datas = new ArrayList<PmEquipmentEntity>();
		Connection conn = null;
		Statement st = null;
		
		conn = DKUtil.getConnection();
		String sql = "select * from pmequipment";
		
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				PmEquipmentEntity data = new PmEquipmentEntity();
				data.setIntervalTime(rs.getInt("Id"));
				data.setEquipmentNo(rs.getString("EquipmentNo"));
				data.setIMEI(rs.getString("IMEI"));
				data.setIp(rs.getString("IP"));
				data.setUid(rs.getInt("Uid"));
				data.setAlive(rs.getString("Alive"));
				data.setIntervalTime(rs.getInt("IntervalTime"));
				data.setState(rs.getInt("State"));
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
				Timestamp aliveTime = rs.getTimestamp("AliveTime");
				Timestamp dateCreated = rs.getTimestamp("DateCreated");
				Timestamp dateModified = rs.getTimestamp("DateModified");
				data.setAlive(sdf.format(aliveTime));
				data.setDateCreated(sdf.format(dateCreated));
				data.setDateModified(sdf.format(dateModified));
				
				datas.add(data);
				result.setData(datas);
				result.setMessage("查询成功");
				result.setState(true);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			result.setState(false);
			result.setMessage("查询失败");
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

	public DKResult addPmEquipmentEntity(PmEquipmentEntity pmEquipmentEntity) {
		DKResult result = new DKResult();
		if(pmEquipmentEntity.getEquipmentNo()==null
				||pmEquipmentEntity.getUid()==null
				||pmEquipmentEntity.getState()==null
				||pmEquipmentEntity.getDateCreated()==null){
			result.setState(false);
			result.setMessage("parameter is null!");
			return result;
		}
		// TODO Auto-generated method
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		String sql = "insert into pmequipment(EquipmentNo,IMEI,IP,Uid,Alive,AliveTime,IntervalTime,State,DateCreated,DateModified) values(?,?,?,?,?,?,?,?,?,?)";
		
		try {
			conn = DKUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, pmEquipmentEntity.getEquipmentNo());
			ps.setString(2, pmEquipmentEntity.getIMEI());
			ps.setString(3, pmEquipmentEntity.getIp());
			if(pmEquipmentEntity.getUid()!=null){
				ps.setInt(4, pmEquipmentEntity.getUid());
			}else{
				ps.setInt(4, 0);
			}
			
			ps.setString(5, pmEquipmentEntity.getAlive());
			
//			ps.setString(6, pmEquipmentEntity.getAliveTime());
			if(pmEquipmentEntity.getIntervalTime()!=null){
				ps.setInt(7, pmEquipmentEntity.getIntervalTime());
			}else{
				ps.setInt(7, 0);
			}
			if(pmEquipmentEntity.getState()!=null){
				ps.setInt(8, pmEquipmentEntity.getState());
			}else{
				ps.setInt(8, 0);
			}
			
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			String aliveTime = pmEquipmentEntity.getAliveTime();
			String dateCreated = pmEquipmentEntity.getDateCreated();
			String dateModified = pmEquipmentEntity.getDateModified();
			try {
				if(aliveTime!=null){
					Date time = sdf.parse(aliveTime);
					sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					ps.setTimestamp(6, Timestamp.valueOf(sdf.format(time)));
				}else{
					ps.setTimestamp(6, null);
				}
				if(dateCreated!=null){
					Date created = sdf.parse(dateCreated);
					sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					ps.setTimestamp(9, Timestamp.valueOf(sdf.format(created)));
				}else{
					ps.setTimestamp(9, null);
				}
				if(dateModified!=null){
					Date modified = sdf.parse(dateModified);
					sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					ps.setTimestamp(10, Timestamp.valueOf(sdf.format(modified)));
				}else{
					ps.setTime(10, null);
				}
				
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
			result.setMessage("save failed!");
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

	public DKResult updatPmEquipmentEntity(PmEquipmentEntity pmEquipmentEntity) {
		// TODO Auto-generated method stub
		DKResult result = new DKResult();
		Connection conn = null;
		PreparedStatement ps = null;
		
		String sql = "update pmequipment set Ip=?,Uid=?,Alive=?,AliveTime=?,IntervalTime=?,State=?,DateModified=?";
		
		try {
			conn = DKUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, pmEquipmentEntity.getIp());
			ps.setInt(2, pmEquipmentEntity.getUid());
			ps.setString(3, pmEquipmentEntity.getAlive());
			ps.setInt(5, pmEquipmentEntity.getIntervalTime());
			ps.setInt(6, pmEquipmentEntity.getState());
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			String aliveTime = pmEquipmentEntity.getAliveTime();
			String dateModified = pmEquipmentEntity.getDateModified();
			
			try {
				Date time = sdf.parse(aliveTime);
				Date modified = sdf.parse(dateModified);
				
				sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				ps.setTimestamp(4, Timestamp.valueOf(sdf.format(time)));
				ps.setTimestamp(7, Timestamp.valueOf(sdf.format(modified)));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			ps.execute();
			result.setState(true);
			result.setMessage("操作成功");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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

	public DKResult deletePmEquipmentEntity(Integer id) {
		// TODO Auto-generated method stub
		DKResult result = new DKResult();
		Connection conn = null;
		PreparedStatement ps = null;
		
		String sql = "delete from pmequipment where id = ?";
		try {
			conn = DKUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ps.execute();
			result.setState(true);
			result.setMessage("操作成功");
			result.setId(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			result.setState(false);
			result.setId(id);
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
