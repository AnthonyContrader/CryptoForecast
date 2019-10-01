package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.model.Trend;


/**
 * 
 * @author team GDA
 *
 *Per i dettagli della classe vedi Guida sez 6: DAO
 */
public class TrendDAO implements DAO<Trend> {

	private final String QUERY_ALL = "SELECT * FROM trend";
	private final String QUERY_CREATE = "INSERT INTO trend (time,variation,namecoin) VALUES (?,?,?)";
	private final String QUERY_READ = "SELECT * FROM trend WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE trend SET time=?, variation=?, namecoin=?  WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM trend WHERE id=?";
	public TrendDAO() {

	}

	public List<Trend> getAll() {
		List<Trend> trendsList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Trend trend;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String time = resultSet.getString("time");
				int variation = resultSet.getInt("variation");
            	String namecoin = resultSet.getString("namecoin");
				
				trend = new Trend(time, variation, namecoin);
				trend.setId(id);
				trendsList.add(trend);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return trendsList;
	}

	public boolean insert(Trend trendToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, trendToInsert.getTime());
			preparedStatement.setInt(2, trendToInsert.getVariation());
			preparedStatement.setString(3, trendToInsert.getNamecoin());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	public Trend read(int trendId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {


			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, trendId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();

			String time,  namecoin;
			int variation;

			time = resultSet.getString("time");
			variation = resultSet.getInt("variation");
			namecoin = resultSet.getString("namecoin");
			Trend trend = new Trend(time,variation,namecoin);
			
			trend.setId(resultSet.getInt("id"));

			return trend;
		} catch (SQLException e) {
			return null;
		}

	}

	public boolean update(Trend trendToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (trendToUpdate.getId() == 0)
			return false;

		Trend trendRead = read(trendToUpdate.getId());
		if (!trendRead.equals(trendToUpdate)) {
			try {
				// Fill the userToUpdate object
				if (trendToUpdate.getTime() == null || trendToUpdate.getTime().equals("")) {
					trendToUpdate.setTime(trendRead.getTime());
				}

				if (trendToUpdate.getVariation() == 0) {
					trendToUpdate.setVariation(trendRead.getVariation());
				}
				if (trendToUpdate.getNamecoin() == null || trendToUpdate.getNamecoin().equals("")) {
					trendToUpdate.setNamecoin(trendRead.getNamecoin());

				}

				// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, trendToUpdate.getTime());
				preparedStatement.setInt(2, trendToUpdate.getVariation());
				preparedStatement.setString(3, trendToUpdate.getNamecoin());
				preparedStatement.setInt(4, trendToUpdate.getId());
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
