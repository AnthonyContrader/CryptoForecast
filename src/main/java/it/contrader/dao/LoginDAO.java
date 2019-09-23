package it.contrader.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import it.contrader.main.ConnectionSingleton;
/*
* il DAO di un entità è la classe che si occupa dell'esecuzione delle query al database
* per l'entita in questione
* In questo caso LoginDAO conterra al suo interno la definizione delle query per il login
* e la loro gestione
*/

/**
 * 
 * @author Vittorio
 *
 *Per i dettagli della classe vedi Guida sez 6: DAO
 */
public class LoginDAO {
	/*
		SEZIONE 11 per vedere SQL (work in progress)
		definisco qui le varie interrogazioni al database e le assegno a dei nomi più
		facilmente compressibili
		in questo caso la query specifica è : SELECT * FROM user WHERE username = ? AND password = ?
		assegnandola a QUERY_LOGIN , posso chiamarla utilizzando quel nome come riferimento
		------
		nello specifico questa query recuperera tutti gli elementi dalla tabella user dove il campo username
		avrà un valore e password un altro , essi verranno settati ad ogni chiamata
		PS: il ? indica un valore che deve essere sostituito
	*/
	private final String QUERY_LOGIN = "SELECT * FROM user WHERE username = ? AND password = ?";

	/*
	metodo login
	parametri: string username : username del profilo
						string password : password del profilo
	output: String : restituisce in output il tipo
	*/
	public String login (String username, String password) {

		/*
		recupera la connessione al database
		PS: la connessione è singola perchè è consigliabile non creare concorrenza nelle
		richieste al database
		*/
		Connection connection = ConnectionSingleton.getInstance();
		try {
			/*
			la variabile statement caricherà al suo interno la query che vuole essere
			eseguita
			*/
			PreparedStatement statement = connection.prepareStatement(QUERY_LOGIN);

			/*
			setString sostituisce con una stringa una dei parametri della query
			prima segnati con un ? al momento della definizione della query
			*/
			statement.setString(1, username);
			statement.setString(2, password);

			String usertype = null;

			/*
			Result set conterrà il risultato della query
			*/
			ResultSet resultSet;

			/*
				eseguo la query caricata nello statement
			*/
			if(statement.executeQuery().next()) {
				/*
					nel result set avrò quindi il ri
				*/
				resultSet = statement.executeQuery();
				resultSet.next();
				usertype = resultSet.getString("usertype");
			}

			return usertype;
		}

		catch (SQLException e) {

			return null;
		}
	}
}
