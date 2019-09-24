package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Trend;

/**
 * 
 * @author Atif
 *
 *Per i dettagli della classe vedi Guida sez 6: DAO
 */
public class TrendDAO {

	private final String QUERY_ALL = "SELECT * FROM trend";
	private final String QUERY_CREATE = "INSERT INTO trend (time,variation,namecoin) VALUES (?,?,?)";
	private final String QUERY_READ = "SELECT * FROM trend WHERE idtrend=?";
	private final String QUERY_UPDATE = "UPDATE trend SET time=?, variation=?, namecoin=?  WHERE idtrend=?";
	private final String QUERY_DELETE = "DELETE FROM trend WHERE idtrend=?";

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
				int idtrend = resultSet.getInt("idtrend");
				String time = resultSet.getString("time");
				String variation = resultSet.getString("variation");
				String namecoin = resultSet.getString("namecoin");
				trend = new Trend(time, variation, namecoin);
				trend.setId(idtrend);
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
			preparedStatement.setString(2, trendToInsert.getVariation());
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
			String time, variation,namecoin;

			time = resultSet.getString("time");
			variation = resultSet.getString("variation");
			namecoin = resultSet.getString("namecoin");
			Trend trend = new Trend(time, variation, namecoin);
			trend.setId(resultSet.getInt("idtrend"));

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

				if (trendToUpdate.getVariation() == null || trendToUpdate.getVariation().equals("")) {
					trendToUpdate.setVariation(trendRead.getVariation());
				}

				

				// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, trendToUpdate.getTime());
				preparedStatement.setString(2, trendToUpdate.getVariation());
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

	public boolean delete(int idtrend) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, idtrend);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;

		} catch (SQLException e) {
		}
		return false;
	}


}
