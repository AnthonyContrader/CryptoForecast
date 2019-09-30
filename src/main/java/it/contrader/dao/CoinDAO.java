package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Coin;

/**
 * 
 * @author team GDA
 *
 *Per i dettagli della classe vedi Guida sez 6: DAO
 */
public class CoinDAO {

	private final String QUERY_ALL = "SELECT * FROM coin";
	private final String QUERY_CREATE = "INSERT INTO coin (name, quotation, symbol) VALUES (?,?,?)";
	private final String QUERY_READ = "SELECT * FROM coin WHERE idcoin=?";
	private final String QUERY_UPDATE = "UPDATE coin SET name=?, quotation=?, symbol=? WHERE idcoin=?";
	private final String QUERY_DELETE = "DELETE FROM coin WHERE idcoin=?";

	public CoinDAO() {

	}

	public List<Coin> getAll() {
		List<Coin> coinsList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Coin coin;
			while (resultSet.next()) {
				int idcoin = resultSet.getInt("idcoin");
				String name = resultSet.getString("name");
				int quotation = resultSet.getInt("quotation");
				String symbol = resultSet.getString("symbol");
				coin = new Coin (name, quotation, symbol);
				coin.setId(idcoin);
				coinsList.add(coin);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return coinsList;
	}

	public boolean insert(Coin coinToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, coinToInsert.getName());
			preparedStatement.setInt(2, coinToInsert.getQuotation());
			preparedStatement.setString(3, coinToInsert.getSymbol());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	public Coin read(int coinId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {


			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, coinId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String name,  symbol;
			int quotation;

			name = resultSet.getString("name");
			quotation = resultSet.getInt("quotation");
			symbol = resultSet.getString("symbol");
			Coin coin = new Coin(name, quotation, symbol);
			coin.setId(resultSet.getInt("idcoin"));

			return coin;
		} catch (SQLException e) {
			return null;
		}

	}

	public boolean update(Coin coinToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (coinToUpdate.getId() == 0)
			return false;

		Coin coinRead = read(coinToUpdate.getId());
		if (!coinRead.equals(coinToUpdate)) {
			try {
				// Fill the userToUpdate object
				if (coinToUpdate.getName() == null || coinToUpdate.getName().equals("")) {
					coinToUpdate.setName(coinRead.getName());
				}

				if (coinToUpdate.getQuotation() == 0 /*|| coinToUpdate.getQuotation().equals("")*/) {
					coinToUpdate.setQuotation(coinRead.getQuotation());
				}

				if (coinToUpdate.getSymbol() == null || coinToUpdate.getSymbol().equals("")) {
					coinToUpdate.setSymbol(coinRead.getSymbol());
				}

				// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, coinToUpdate.getName());
				preparedStatement.setInt(2, coinToUpdate.getQuotation());
				preparedStatement.setString(3, coinToUpdate.getSymbol());
				preparedStatement.setInt(4, coinToUpdate.getId());
				int a = preparedStatement.executeUpdate();
				if (a > 0)
					return true;
				else
					return false;

			} catch (SQLException e) {
				return false;
			}
		}

		return false;

	}

	public boolean delete(int id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, id);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;

		} catch (SQLException e) {
		}
		return false;
	}


}
