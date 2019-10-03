package it.contrader.dao;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

import it.contrader.model.Commit;
import it.contrader.utils.ConnectionSingleton;

/**
 * 
 * @author Vittorio
 *
 *Per i dettagli della classe vedi Guida sez 6: DAO
 */
public class CommitDAO implements DAO<Commit> {

	private final String QUERY_ALL = "SELECT * FROM commit";
	private final String QUERY_CREATE = "INSERT INTO user (namecoin, number, data) VALUES (?,?,?)";
	private final String QUERY_READ = "SELECT * FROM user WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE user SET namecoin=?, number=?, data=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM user WHERE id=?";

	public CommitDAO() {

	}

	public List<Commit> getAll() {
		List<Commit>commitsList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Commit commit;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String namecoin = resultSet.getString("namecoin");
				int number = resultSet.getInt("number");
				String data = resultSet.getString("data");
				commit = new Commit(namecoin, number, data);
				commit.setId(id);
				commitsList.add(commit);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return commitsList;
	}

	public boolean insert(Commit commitToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, commitToInsert.getNamecoin());
			preparedStatement.setInt(2, commitToInsert.getNumber());
			preparedStatement.setString(3, commitToInsert.getData());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	public Commit read(int commitId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {


			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, commitId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String namecoin, data;
			int number;
			
			namecoin = resultSet.getString("namecoin");
			number = resultSet.getInt("number");
			data = resultSet.getString("data");
			Commit commit = new Commit(namecoin, number, data);
			commit.setId(resultSet.getInt("id"));

			return commit;
		} catch (SQLException e) {
			return null;
		}

	}

	public boolean update(Commit commitToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (commitToUpdate.getId() == 0)
			return false;

		Commit commitRead = read(commitToUpdate.getId());
		if (!commitRead.equals(commitToUpdate)) {
			try {
				// Fill the userToUpdate object
				if (commitToUpdate.getNamecoin() == null || commitToUpdate.getNamecoin().equals("")) {
					commitToUpdate.setNamecoin(commitRead.getNamecoin());
				}

				if (commitToUpdate.getNumber() == 0) {
					commitToUpdate.setNumber(commitRead.getNumber());
				}

				if (commitToUpdate.getData() == null || commitToUpdate.getData().equals("")) {
					commitToUpdate.setData(commitRead.getData());
				}

				// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, commitToUpdate.getNamecoin());
				preparedStatement.setInt(2, commitToUpdate.getNumber());
				preparedStatement.setString(3, commitToUpdate.getData());
				preparedStatement.setInt(4, commitToUpdate.getId());
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
