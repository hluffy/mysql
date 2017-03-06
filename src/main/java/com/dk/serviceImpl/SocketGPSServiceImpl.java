package com.dk.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.dk.entity.SocketGPSEntity;
import com.dk.result.DKResult;
import com.dk.service.SocketGPSService;
import com.dk.util.DKUtil;

@Service
public class SocketGPSServiceImpl implements SocketGPSService{

	public DKResult addSocketGPSEntity(SocketGPSEntity socketGpsEntity) {
		// TODO Auto-generated method stub
		DKResult result = new DKResult();
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		String sql = "insert into socketgps(EquipmentNo,Date,Time,IsPosition,Latitude,Longitude,Speed,Direction,Altitude,BaseStation,WiFi,Elec,Gsensor,DateCreated,Address,LatitudeConv,LongitudeConv,DateConv) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			conn = DKUtil.getConnection();
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, socketGpsEntity.getEquipmentNo());
			ps.setString(2, socketGpsEntity.getDate());
			ps.setString(3, socketGpsEntity.getTime());
			ps.setString(4, socketGpsEntity.getIsPosition());
			ps.setString(5, socketGpsEntity.getLatitude());
			ps.setString(6, socketGpsEntity.getLongitude());
			ps.setString(7, socketGpsEntity.getSpeed());
			ps.setString(8, socketGpsEntity.getDirection());
			ps.setString(9, socketGpsEntity.getAltitude());
			ps.setString(10, socketGpsEntity.getBaseStation());
			ps.setString(11, socketGpsEntity.getWifi());
			ps.setString(12, socketGpsEntity.getElec());
			ps.setString(13, socketGpsEntity.getGsensor());
//			ps.setString(14, socketGpsEntity.get);
			ps.setString(15, socketGpsEntity.getAddress());
			ps.setString(16, socketGpsEntity.getLatitudeConv());
			ps.setString(17, socketGpsEntity.getLongitdeConv());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			try {
				if(socketGpsEntity.getDateCreated()!=null){
					Date created = sdf.parse(socketGpsEntity.getDateCreated());
					sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					ps.setTimestamp(14, Timestamp.valueOf(sdf.format(created)));
				}else{
					ps.setTimestamp(14, null);
				}
				if(socketGpsEntity.getDateConv()!=null){
					Date conv = sdf.parse(socketGpsEntity.getDateConv());
					sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					ps.setTimestamp(18, Timestamp.valueOf(sdf.format(conv)));
				}else{
					ps.setTimestamp(18, null);
				}
				
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			ps.execute();
			result.setState(true);
			result.setMessage("save success!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			result.setMessage("save failed");
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
