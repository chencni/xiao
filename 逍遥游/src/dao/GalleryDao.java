package dao;

import model.Gallery;
import org.json.JSONArray;
import org.json.JSONObject;
import util.JDBCUtils;
import util.StaticParameters;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;

public class GalleryDao {

	public int save(ArrayList<Gallery> gList) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int rs = -1;
		try {
			con = JDBCUtils.getConnection();//使用数据库连接池
			String insertUserSql = "insert into gallery(imageUrl,title,detail,userId,createTime) values(?,?,?,?,?)";
			con.setAutoCommit(false);// 关闭事务
			pstmt = con.prepareStatement(insertUserSql);
			for (Iterator<Gallery> iterator = gList.iterator(); iterator.hasNext();) {
				Gallery gallery = (Gallery) iterator.next();
				pstmt.setString(1, gallery.getImageUrl());
				pstmt.setString(2, gallery.getTitle());
				pstmt.setString(3, gallery.getDetail());
				pstmt.setString(4, gallery.getUserId());
				// java.util.Date 与MySQL：datetime在字符串层面的对应关系
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				pstmt.setString(5, simpleDateFormat.format(gallery.getCreateTime()));
				pstmt.addBatch();
			}
			pstmt.executeBatch();// 影响行的个数
			con.commit();
			rs = gList.size();
			System.out.println("影响行的个数=" + rs);
		} catch (SQLException e) {
			System.out.println("数据库连接出错");
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("关闭出错");
			}
		}
		return rs;

	}

	public JSONArray getGalleryJsonArrayByCurPage(Integer currentPage) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		JSONArray galleryJsonArray = new JSONArray();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3307/myblog?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";
			String userName = "root";
			String pwd1 = "czcat";
			con = DriverManager.getConnection(url, userName, pwd1);
			String querySql = "select imageUrl,title,detail,userId from gallery order by id desc limit ?,?";
			pstmt = con.prepareStatement(querySql);
			int pagesize = StaticParameters.GaLLERYPAGESIZE;
			int offset = (currentPage - 1) * pagesize;
			pstmt.setInt(1, offset);
			pstmt.setInt(2, pagesize);
			rs = pstmt.executeQuery();
			ResultSetMetaData metaData = rs.getMetaData();// map类型的结构可以遍历获取字段名
			int columnCount = metaData.getColumnCount();// 记录的列数
			while (rs.next()) {
				JSONObject jsonObject = new JSONObject();// 一条记录
				for (int i = 1; i <= columnCount; i++) {// 遍历获取该记录的字段名
					String columnName = metaData.getColumnName(i);
					String columnValue = rs.getString(columnName);
					jsonObject.put(columnName, columnValue);
				}
				galleryJsonArray.put(jsonObject);
			}

		} catch (ClassNotFoundException e) {
			System.out.println("驱动加载出错");
		} catch (SQLException e) {
			System.out.println("数据库连接出错");
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("关闭出错");
			}
		}
		return galleryJsonArray;
	}

	public int getTotalRecords() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int TotalPages = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3307/myblog?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";
			String userName = "root";
			String pwd1 = "czcat";
			con = DriverManager.getConnection(url, userName, pwd1);
			String querySql = "select count(*) from gallery";
			pstmt = con.prepareStatement(querySql);
			rs = pstmt.executeQuery(querySql);
			if (rs.next()) {
				TotalPages = rs.getInt(1);
			}
		} catch (ClassNotFoundException e) {
			System.out.println("驱动加载出错");
		} catch (SQLException e) {
			System.out.println("数据库连接出错");
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("关闭出错");
			}
		}
		return TotalPages;

	}

}
