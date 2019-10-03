package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import it.contrader.model.Social;
import it.contrader.utils.ConnectionSingleton;


/**
 * 
 * @author team GDA
 *
 *Per i dettagli della classe vedi Guida sez 6: DAO
 */
public class SocialDAO implements DAO<Social> {

	private final String QUERY_ALL = "SELECT * FROM social";
	private final String QUERY_CREATE = "INSERT INTO social (url, post, data, namecoin) VALUES (?,?,?,?)";
	private final String QUERY_READ = "SELECT * FROM social WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE social SET url=?, post=?, data=?, namecoin=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM social WHERE id=?";

	public SocialDAO() {

	}

	public List<Social> getAll() {
		List<Social> socialsList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Social social;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String url = resultSet.getString("url");
				int post = resultSet.getInt("post");
				String data = resultSet.getString("data");
				String namecoin = resultSet.getString("namecoin");
				social = new Social (url, post, data, namecoin);
				social.setId(id);
				socialsList.add(social);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return socialsList;
	}

	public boolean insert(Social socialToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, socialToInsert.getUrl());
			preparedStatement.setInt(2, socialToInsert.getPost());
			preparedStatement.setString(3, socialToInsert.getData());
			preparedStatement.setString(1, socialToInsert.getNamecoin());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	public Social read(int id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {


			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String url, data, namecoin;
			int post;

			url = resultSet.getString("url");
			post = resultSet.getInt("post");
			data = resultSet.getString("data");
			namecoin = resultSet.getString("namecoin");
			Social social = new Social(url, post, data, namecoin);
			social.setId(resultSet.getInt("id"));

			return social;
		} catch (SQLException e) {
			return null;
		}

	}

	public boolean update(Social socialToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (socialToUpdate.getId() == 0)
			return false;

		Social socialRead = read(socialToUpdate.getId());
		if (!socialRead.equals(socialToUpdate)) {
			try {
				// Fill the userToUpdate object
				if (socialToUpdate.getUrl() == null || socialToUpdate.getUrl().equals("")) {
					socialToUpdate.setUrl(socialRead.getUrl());
				}

				if (socialToUpdate.getPost() == 0 /*|| coinToUpdate.getQuotation().equals("")*/) {
					socialToUpdate.setPost(socialRead.getPost());
				}

				if (socialToUpdate.getData() == null || socialToUpdate.getData().equals("")) {
					socialToUpdate.setData(socialRead.getData());
				}
				
				if (socialToUpdate.getNamecoin() == null || socialToUpdate.getNamecoin().equals("")) {
					socialToUpdate.setNamecoin(socialRead.getNamecoin());
				}

				// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, socialToUpdate.getUrl());
				preparedStatement.setInt(2, socialToUpdate.getPost());
				preparedStatement.setString(3, socialToUpdate.getData());
				preparedStatement.setString(4, socialToUpdate.getNamecoin());
				preparedStatement.setInt(5, socialToUpdate.getId());
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
