package com.dk.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MysqlDump {
	//导出数据库
	public static void main(String[] args) {
		Runtime cmd = Runtime.getRuntime();
		try {
//			Process p = cmd.exec("mysqldump -t -uroot -phanxiao test score -r D://test1.sql".toString());
			Process p = cmd.exec("ipconfig");
//			System.out.println("导出成功");
			byte[] by = new byte[102400000];
			InputStream input = p.getInputStream();
			InputStreamReader in = new InputStreamReader(input,"gbk");
			BufferedReader reader = new BufferedReader(in);
			while(reader.read()!=-1){
				System.out.println(reader.readLine());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
