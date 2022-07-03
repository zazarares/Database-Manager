package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import connection.connection;
import Model.Client;

public class ClientDAO {
	/**
	 * operations with clients and databases
	 * @author Hotupan Rares
	 * @version 1.0
	 * @since 2022-05-16
	 */
	protected static final Logger LOGGER = Logger.getLogger(ClientDAO.class.getName());
	private static final String insertStatementString = "INSERT INTO Client (ID,nume,adresa,email,varsta)"
			+ " VALUES (?,?,?,?,?)";
	private final static String findStatementString = "SELECT * FROM Client where id = ?";
	private final static String UpdatenameStatementString="UPDATE Client SET nume =? WHERE ID=?";
	private final static String UpdateadressStatementString="UPDATE Client SET adresa =? WHERE ID=?";
	private final static String UpdateemailStatementString="UPDATE Client SET email =? WHERE ID=?";
	private final static String UpdateageStatementString="UPDATE Client SET varsta =? WHERE ID=?";
	private final static String DeleteStatementString="Delete from Client WHERE ID=?";
	public static Client findById(int ClientId) {
		Client toReturn = null;

		Connection dbConnection = connection.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		try {
			findStatement = dbConnection.prepareStatement(findStatementString);
			findStatement.setLong(1, ClientId);
			rs = findStatement.executeQuery();
			rs.next();

			String name = rs.getString("nume");
			String address = rs.getString("adresa");
			String email = rs.getString("email");
			int age = rs.getInt("varsta");
			toReturn = new Client(ClientId, name, address, email, age);
		} catch (SQLException e) {
			//LOGGER.log(Level.WARNING,"StudentDAO:findById " + e.getMessage());
		} finally {
			connection.close(rs);
			connection.close(findStatement);
			connection.close(dbConnection);
		}
		return toReturn;
	}

	public static int insert(Client client) {
		Connection dbConnection = connection.getConnection();

		PreparedStatement insertStatement = null;
		int insertedId = -1;
		try {
			insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
			insertStatement.setString(1, Integer.toString(client.getID()));
			insertStatement.setString(2, client.getNume());
			insertStatement.setString(3, client.getAdresa());
			insertStatement.setString(4, client.getEmail());
			insertStatement.setInt(5, client.getVarsta());
			insertStatement.executeUpdate();

			ResultSet rs = insertStatement.getGeneratedKeys();
			if (rs.next()) {
				insertedId = rs.getInt(1);
			}
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "StudentDAO:insert " + e.getMessage());
		} finally {
			connection.close(insertStatement);
			connection.close(dbConnection);
		}
		return insertedId;
	}
	public static int updatename(int productid,String name)
	{
		Connection dbConnection = connection.getConnection();

		PreparedStatement insertStatement = null;
		int insertedId = -1;
		try {
			insertStatement = dbConnection.prepareStatement(UpdatenameStatementString, Statement.RETURN_GENERATED_KEYS);
			insertStatement.setString(1,name);
			insertStatement.setInt(2, productid);
			insertStatement.executeUpdate();
			ResultSet rs = insertStatement.getGeneratedKeys();
			if (rs.next()) {
				insertedId = rs.getInt(1);
			}
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "productDAO:insert " + e.getMessage());
		} finally {
			connection.close(insertStatement);
			connection.close(dbConnection);
		}
		return insertedId;
	}
	public static int updateadress(int productid,String name)
	{
		Connection dbConnection = connection.getConnection();

		PreparedStatement insertStatement = null;
		int insertedId = -1;
		try {
			insertStatement = dbConnection.prepareStatement(UpdateadressStatementString, Statement.RETURN_GENERATED_KEYS);
			insertStatement.setString(1,name);
			insertStatement.setInt(2, productid);
			insertStatement.executeUpdate();
			ResultSet rs = insertStatement.getGeneratedKeys();
			if (rs.next()) {
				insertedId = rs.getInt(1);
			}
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "productDAO:insert " + e.getMessage());
		} finally {
			connection.close(insertStatement);
			connection.close(dbConnection);
		}
		return insertedId;
	}
	public static int updateemail(int productid,String name)
	{
		Connection dbConnection = connection.getConnection();

		PreparedStatement insertStatement = null;
		int insertedId = -1;
		try {
			insertStatement = dbConnection.prepareStatement(UpdateemailStatementString, Statement.RETURN_GENERATED_KEYS);
			insertStatement.setString(1,name);
			insertStatement.setInt(2, productid);
			insertStatement.executeUpdate();
			ResultSet rs = insertStatement.getGeneratedKeys();
			if (rs.next()) {
				insertedId = rs.getInt(1);
			}
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "productDAO:insert " + e.getMessage());
		} finally {
			connection.close(insertStatement);
			connection.close(dbConnection);
		}
		return insertedId;
	}
	public static int updateage(int productid,int age)
	{
		Connection dbConnection = connection.getConnection();

		PreparedStatement insertStatement = null;
		int insertedId = -1;
		try {
			insertStatement = dbConnection.prepareStatement(UpdateageStatementString, Statement.RETURN_GENERATED_KEYS);
			insertStatement.setInt(1,age);
			insertStatement.setInt(2, productid);
			insertStatement.executeUpdate();
			ResultSet rs = insertStatement.getGeneratedKeys();
			if (rs.next()) {
				insertedId = rs.getInt(1);
			}
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "productDAO:insert " + e.getMessage());
		} finally {
			connection.close(insertStatement);
			connection.close(dbConnection);
		}
		return insertedId;
	}
	public static int delete(int productid)
	{
		Connection dbConnection = connection.getConnection();

		PreparedStatement insertStatement = null;
		int insertedId = -1;
		try {
			insertStatement = dbConnection.prepareStatement(DeleteStatementString, Statement.RETURN_GENERATED_KEYS);
			insertStatement.setInt(1, productid);
			insertStatement.executeUpdate();
			ResultSet rs = insertStatement.getGeneratedKeys();
			if (rs.next()) {
				insertedId = rs.getInt(1);
			}
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "productDAO:insert " + e.getMessage());
		} finally {
			connection.close(insertStatement);
			connection.close(dbConnection);
		}
		return insertedId;
	}
}
