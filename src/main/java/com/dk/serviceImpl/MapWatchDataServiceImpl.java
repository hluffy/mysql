package com.dk.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.dk.entity.MapWatchData;
import com.dk.result.DKResult;
import com.dk.service.MapWatchDataService;
import com.dk.util.DKUtil;

@Service
public class MapWatchDataServiceImpl implements MapWatchDataService{

	public DKResult addMapWatchData(MapWatchData mapWatchData) {
		// TODO Auto-generated method stub
		DKResult result = new DKResult();
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		String sql = "insert into map_watch_data(IMEI,Xloc,Yloc,Bat,RSSI,sos,watch_date,create_date,is_position,address,type) values(?,?,?,?,?,?,?,?,?,?,?)";
		try {
			conn = DKUtil.getConnection();
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, mapWatchData.getIMEI());
			ps.setString(2, mapWatchData.getXloc());
			ps.setString(3, mapWatchData.getYloc());
			if(mapWatchData.getBat()==null){
				ps.setInt(4, 0);
			}else{
				ps.setInt(4, mapWatchData.getBat());
			}
			if(mapWatchData.getRSSI()==null){
				ps.setInt(5, 0);
			}else{
				ps.setInt(5, mapWatchData.getRSSI());
			}
			
			ps.setString(6, mapWatchData.getSos());
			ps.setString(9, mapWatchData.getIsPosition());
			ps.setString(10, mapWatchData.getAddress());
			ps.setString(11, mapWatchData.getType());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			try {
				if(mapWatchData.getWatchDate()!=null){
					Date watch = sdf.parse(mapWatchData.getWatchDate());
					sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					ps.setTimestamp(7, Timestamp.valueOf(sdf.format(watch)));
				}else{
					ps.setTimestamp(7, null);
				}
				if(mapWatchData.getCreateDate()!=null){
					Date create = sdf.parse(mapWatchData.getCreateDate());
					sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					ps.setTimestamp(8, Timestamp.valueOf(sdf.format(create)));
				}else{
					ps.setTimestamp(8, null);
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

}
