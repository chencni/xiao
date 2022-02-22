package dao;

import model.News;
import org.json.JSONArray;
import org.json.JSONObject;
import util.StaticParameters;

import java.sql.*;
import java.text.SimpleDateFormat;

public class NewsDao {

	public int save(News news) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int rs = -1;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/tour?characterEncoding=UTF-8";
			String userName = "root";
			String pwd1 = "cnyw5242";
			con = DriverManager.getConnection(url, userName, pwd1);
			String insertUserSql = "insert into news(newsImg,title,detail,content,userId,createTime) values(?,?,?,?,?,?)";
			pstmt = con.prepareStatement(insertUserSql);
			pstmt.setString(1, news.getNewsImg());
			pstmt.setString(2, news.getTitle());
			pstmt.setString(3, news.getDetail());
			pstmt.setString(4, news.getContent());
			pstmt.setString(5, news.getUserId());
			// java.util.Date 与MySQL：datetime在字符串层面的对应关系
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			pstmt.setString(6, simpleDateFormat.format(news.getCreateTime()));
			System.out.println(news.getNewsImg());
			System.out.println(news.getTitle());
			System.out.println(news.getDetail());
			System.out.println(news.getContent());
			System.out.println(news.getUserId());
			rs = pstmt.executeUpdate();// 影响行的个数
			System.out.println("影响行的个数=" + rs);
		} catch (ClassNotFoundException e) {
			System.out.println("驱动加载出错");
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

	public JSONArray getNewsJsonArrayByCurPage(Integer currentPage) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		JSONArray newsJsonArray = new JSONArray();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/tour?characterEncoding=UTF-8";
			String userName = "root";
			String pwd1 = "cnyw5242";
			con = DriverManager.getConnection(url, userName, pwd1);
			String querySql = "select newsImg,title,detail,content from news order by id desc limit ?,?";
			pstmt = con.prepareStatement(querySql);
			int pagesize = StaticParameters.PAGESIZE;
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
				newsJsonArray.put(jsonObject);
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
		return newsJsonArray;
	}

	public int getTotalRecords() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int TotalPages = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/tour?characterEncoding=UTF-8";
			String userName = "root";
			String pwd1 = "cnyw5242";
			con = DriverManager.getConnection(url, userName, pwd1);
			String querySql = "select count(*) from news";
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
