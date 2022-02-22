package service;

import model.Account;

import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

public class RegLoginService {


    public int reg(Account account) {
        int rs = -1;
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/tour?characterEncoding=UTF-8";
            String userName = "root";
            String pwd = "cnyw5242";
            conn = DriverManager.getConnection(url, userName, pwd);
            System.out.println(" 实例化Statement对象...");
            String insertUserSql= "insert into account(userName,email,mobile,sex,pwd,creatTime) values (?,?,?,?,?,?)";
            stmt = conn.prepareStatement(insertUserSql);
            stmt.setString(1, account.getUserName());
            stmt.setString(2,account.getEmail());
            stmt.setString(3, account.getMobile());
            stmt.setString(4,account.getSex());
            stmt.setString(5, account.getPassword());
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String creatTimerString = format.format(account.getCreatTime());
            account.getCreatTime();
            stmt.setString(6, creatTimerString);
            rs = stmt.executeUpdate();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            // 关闭资源
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
        return rs;
    }
    public boolean find(String email) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/tour?characterEncoding=UTF-8";
            String userName = "root";
            String pwd = "cnyw5242";
            con = DriverManager.getConnection(url, userName, pwd);
            String queryEmailSql = "select email from account where email=?";
            pstmt = con.prepareStatement(queryEmailSql);
            pstmt.setString(1, email);
            rs = pstmt.executeQuery();
            return rs.next();

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
        return true;
    }
    public String find(String email, String pwd) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/tour?characterEncoding=UTF-8";
            String userName = "root";
            String pwd1 = "cnyw5242";
            con = DriverManager.getConnection(url, userName, pwd1);
            String queryEmailSql = "select userName from account where email=? and pwd=?";
            pstmt = con.prepareStatement(queryEmailSql);
            pstmt.setString(1, email);
            pstmt.setString(2, pwd);
            rs = pstmt.executeQuery();
            if (rs.next())
                return rs.getString("userName");

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
        return null;
    }
    public String getUserId(String email) {
        String userId = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/tour?characterEncoding=UTF-8";
            String userName = "root";
            String pwd = "cnyw5242";
            con = DriverManager.getConnection(url,userName, pwd);
            String queryEmailSql = "select id from account where email=?";
            pstmt = con.prepareStatement(queryEmailSql);
            pstmt.setString(1, email);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                userId = rs.getString("id");
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
        return userId;
    }
}

