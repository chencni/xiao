package util;

import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public final class JDBCUtils {
	private static BasicDataSource dataSource = new BasicDataSource();
	static {
		dataSource.setUsername("root");
		dataSource.setPassword("czcat");
		dataSource.setUrl(
				"jdbc:mysql://localhost:3307/myblog?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true");
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");

		// 3. 指定数据源的一些可选的属性.
		// 1). 指定数据库连接池中初始化连接数的个数
		dataSource.setInitialSize(5);

		// 2). 指定最大的连接数: 同一时刻可以同时向数据库申请的连接数
		dataSource.setMaxActive(5);

		// 3). 指定小连接数: 在数据库连接池中保存的最少的空闲连接的数量
		dataSource.setMinIdle(2);

		// 4).等待数据库连接池分配连接的最长时间. 单位为毫秒. 超出该时间将抛出异常.
		dataSource.setMaxWait(1000 * 5);
	}

	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}

}
