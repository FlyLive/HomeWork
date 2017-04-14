package JDBC;

import java.sql.*;

public class JDBCTest {
	public static void main(String[] args) {
		String dbName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String dbUrl = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=SeniorJava";
		String userName = "sa";
		String password = "LF20forYY";

		try {
			Class.forName(dbName);
			Connection deConn = DriverManager.getConnection(dbUrl, userName,
					password);
			System.out.println("连接成功");
			deConn.close();
		} catch (Exception e) {
			System.out.println("连接失败");
		}
	}

	public Connection getConnection() {
		String dbName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String dbUrl = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=SeniorJava";
		String userName = "sa";
		String password = "LF20forYY";
		Connection deConn = null;
		try {
			Class.forName(dbName);
			deConn = DriverManager.getConnection(dbUrl, userName, password);
		} catch (Exception e) {
			System.out.println("连接失败");
		}
		return deConn;
	}

	public int executeUpdateSQL(String sql, Object... args) {
		PreparedStatement pstmt = null;
		Connection conn = null;
		int counts = 0;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			for (int i = 1; i <= args.length; i++) {
				pstmt.setObject(i, args[i - 1]);
			}
			counts = pstmt.executeUpdate();
			return counts;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(conn);
		}
		return 0;
	}

	public ResultSet executeSelectSQL(String sql, Object... args) {
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			for (int i = 1; i <= args.length; i++) {
				pstmt.setObject(i, args[i - 1]);
			}
			rs = pstmt.executeQuery();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// close(conn,pstmt,rs);
		}
		return null;
	}

	public ResultSet executeSelectSQL(String sql) {
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// close(conn,pstmt,rs);
		}
		return null;
	}

	public void close(Connection cn) {
		if (cn != null) {
			try {
				if (!cn.getAutoCommit()) {
					cn.setAutoCommit(true);
				}
				cn.close();
			} catch (SQLException e) {
			}
		}
	}

	public void close(PreparedStatement pstmt) {
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
			}
		}
	}

	public void close(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
			}
		}
	}

	public void close(Connection cn, PreparedStatement pstmt, ResultSet rs) {
		this.close(rs);
		this.close(pstmt);
		this.close(cn);
	}

	public void rollback(Connection cn) {
		if (cn != null) {
			try {
				cn.rollback();
			} catch (SQLException e) {
			}
		}
	}
}
