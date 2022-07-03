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
import Model.Product;
import Model.comanda;

public class ProductDAO {
	/**
	 * operations with products and databases
	 * @author Hotupan Rares
	 * @version 1.0
	 * @since 2022-05-16
	 */
	protected static final Logger LOGGER = Logger.getLogger(ProductDAO.class.getName());
	private static final String insertStatementString = "INSERT INTO product (ID,nume,stock)"
			+ " VALUES (?,?,?)";
	private final static String findStatementString = "SELECT * FROM product where id = ?";
	private final static String UpdateStatementString="UPDATE product SET stock =? WHERE ID=?";
	private final static String UpdatenameStatementString="UPDATE product SET nume =? WHERE ID=?";
	private final static String DeleteStatementString="Delete from product WHERE ID=?";
	
	public static Product findById(int ProductID) {
		Product toReturn = null;

		Connection dbConnection = connection.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		try {
			findStatement = dbConnection.prepareStatement(findStatementString);
			findStatement.setLong(1, ProductID);
			rs = findStatement.executeQuery();
			rs.next();

			String nume = rs.getString("nume");
			int stock = rs.getInt("stock");
			toReturn = new Product(ProductID, stock,nume);
		} catch (SQLException e) {
			//LOGGER.log(Level.WARNING,"ProductDAO:findById " + e.getMessage());
		} finally {
			connection.close(rs);
			connection.close(findStatement);
			connection.close(dbConnection);
		}
		return toReturn;
	}

	public static int insert(Product product) {
		Connection dbConnection = connection.getConnection();

		PreparedStatement insertStatement = null;
		int insertedId = -1;
		try {
			insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
			insertStatement.setInt(1, product.getID());
			insertStatement.setString(2, product.getName());
			insertStatement.setInt(3, product.getStock());
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
	public static int update(int productid,int stock)
	{
		Connection dbConnection = connection.getConnection();

		PreparedStatement insertStatement = null;
		int insertedId = -1;
		try {
			insertStatement = dbConnection.prepareStatement(UpdateStatementString, Statement.RETURN_GENERATED_KEYS);
			insertStatement.setInt(1,stock);
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
