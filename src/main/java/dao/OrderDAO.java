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
import Model.comanda;

public class OrderDAO {
	/**
	 * operations with orders and databases
	 * @author Hotupan Rares
	 * @version 1.0
	 * @since 2022-05-16
	 */
	protected static final Logger LOGGER = Logger.getLogger(OrderDAO.class.getName());
	private static final String insertStatementString = "INSERT INTO comanda (ID,IDClient,IDProduct,numar_elemente)"
			+ " VALUES (?,?,?,?)";
	private final static String findStatementString = "SELECT * FROM comanda where id = ?";
	private final static String UpdateidcStatementString="UPDATE comanda SET IDClient =? WHERE ID=?";
	private final static String UpdateidpStatementString="UPDATE comanda SET IDProduct =? WHERE ID=?";
	private final static String UpdateelStatementString="UPDATE comanda SET numar_elemente =? WHERE ID=?";
	private final static String DeleteStatementString="Delete from comanda WHERE ID=?";
	public static comanda findById(int ComandaId) {
		comanda toReturn = null;

		Connection dbConnection = connection.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		try {
			findStatement = dbConnection.prepareStatement(findStatementString);
			findStatement.setLong(1, ComandaId);
			rs = findStatement.executeQuery();
			rs.next();

			int IDClient = rs.getInt("IDClient");
			int IDProdus = rs.getInt("IDProduct");
			int numar_elemente = rs.getInt("numar_elemente");
			toReturn = new comanda(ComandaId, IDClient, IDProdus, numar_elemente);
		} catch (SQLException e) {
			//LOGGER.log(Level.WARNING,"OrderDAO:findById " + e.getMessage());
		} finally {
			connection.close(rs);
			connection.close(findStatement);
			connection.close(dbConnection);
		}
		return toReturn;
	}

	public static int insert(comanda comanda) {
		Connection dbConnection = connection.getConnection();

		PreparedStatement insertStatement = null;
		int insertedId = -1;
		try {
			insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
			insertStatement.setString(1, Integer.toString(comanda.getID()));
			insertStatement.setInt(2, comanda.getIDClient());
			insertStatement.setInt(3, comanda.getIDProduct());
			insertStatement.setInt(4, comanda.getNumarElemente());
			insertStatement.executeUpdate();

			ResultSet rs = insertStatement.getGeneratedKeys();
			if (rs.next()) {
				insertedId = rs.getInt(1);
			}
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "OrderDAO:insert " + e.getMessage());
		} finally {
			connection.close(insertStatement);
			connection.close(dbConnection);
		}
		return insertedId;
	}
	public static int updateidc(int productid,int id)
	{
		Connection dbConnection = connection.getConnection();

		PreparedStatement insertStatement = null;
		int insertedId = -1;
		try {
			insertStatement = dbConnection.prepareStatement(UpdateidcStatementString, Statement.RETURN_GENERATED_KEYS);
			insertStatement.setInt(1,id);
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
	public static int updateidp(int productid,int id)
	{
		Connection dbConnection = connection.getConnection();

		PreparedStatement insertStatement = null;
		int insertedId = -1;
		try {
			insertStatement = dbConnection.prepareStatement(UpdateidpStatementString, Statement.RETURN_GENERATED_KEYS);
			insertStatement.setInt(1,id);
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
	public static int updateel(int productid,int id)
	{
		Connection dbConnection = connection.getConnection();

		PreparedStatement insertStatement = null;
		int insertedId = -1;
		try {
			insertStatement = dbConnection.prepareStatement(UpdateelStatementString, Statement.RETURN_GENERATED_KEYS);
			insertStatement.setInt(1,id);
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
