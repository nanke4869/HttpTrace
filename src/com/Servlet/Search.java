package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.Servlet.JsonTools;

import com.DBTool.DBUtil;

public class Search extends HttpServlet{
	public Search() {
		super();
	}
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		  // Put your code here
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			   throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			   throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
	
		String searchString = request.getParameter("search");
		
		List<Map<String,Object>>list = new ArrayList<Map<String,Object>>();
		double lat,lon;
		String flag = null;
		try {
			if (searchString.equals("Trace")) {
				Connection con=DBUtil.getConnection();
				Statement stmt=con.createStatement();
				for(int i = 1; ; i++) {
					String sql = "select * from demodatabase.Trace where uid='"+i+"'";
					ResultSet rs=stmt.executeQuery(sql);
					//String sql2 = "select flag from demodatabase.Trace where uid='"+i+"'";
					//ResultSet rs2=stmt.executeQuery(sql2);
					while(rs.next()) {
						Map<String,Object> map = new HashMap<String, Object>();
						lat = rs.getDouble("latitude");
						lon = rs.getDouble("longitude");
						map.put("latitude", lat);
						map.put("longitude", lon);
						flag = rs.getString("flag");
						list.add(map);
					}
					if(flag.equals("N")) {
						String jsonString = JsonTools.createJsonString("maps",list);
						out.write(jsonString);
						break;
					}
				}
			}
		}catch(Exception ex)
        {
        	ex.printStackTrace();
        	out.println("异常");
        }
		finally
        {
        	DBUtil.Close();
        	//out.print(type);
        	out.flush();
        	out.close();
        }
		
	}
}
