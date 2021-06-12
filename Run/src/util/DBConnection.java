/**
 * @author 1120707 - Sagnik
 */

package util;
import java.sql.*;
public class DBConnection {
	private static final String userName = "E1128959";
	private static final String password = "E1128959";
	private static final String driver = "oracle.jdbc.OracleDriver";
	private static final String dbURL = "jdbc:oracle:thin:@inchnilpdb03.india.tcs.com:1521:javadb03";

	public static Connection getConnection() throws DBException{
		Connection con = null;
		try{
			Class.forName(driver);
			con = DriverManager.getConnection(dbURL,userName,password);
		}
		catch(Exception exception){
			exception.printStackTrace();
			throw new DBException(exception.toString());
		}
		return con;
	}

	public static void closeConnection(Connection con) throws DBException{
		if(con!=null){
			try{
				con.close();
			}
			catch(SQLException exception){
				exception.printStackTrace();
				throw new DBException(exception.toString());
			}
		}
	}

	public static void closePreparedStatement(PreparedStatement pst) throws DBException{
		if(pst!=null){
			try{
				pst.close();
			}
			catch(SQLException exception){
				exception.printStackTrace();
				throw new DBException(exception.toString());
			}
		}
	}

	public static void closeStatement(Statement st) throws DBException{
		if(st!=null){
			try{
				st.close();
			}
			catch(SQLException exception){
				exception.printStackTrace();
				throw new DBException(exception.toString());
			}
		}
	}

	public static void closeResultSet(ResultSet rs) throws DBException{
		if(rs!=null){
			try{
				rs.close();
			}
			catch(SQLException exception){
				exception.printStackTrace();
				throw new DBException(exception.toString());
			}
		}
	}
}