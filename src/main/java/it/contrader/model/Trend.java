package it.contrader.model;
/**
 * Per dettagli vedi guida sez 4 Model
 */
public class Trend {

	/**
	 * Qui sotto definisco gli attributi di User. 
	 */
	private int idtrend;

	private String variation;
	
	private String time;
	
	

	/**
	 * Definisco i due costruttori, uno vuoto e uno con tre parametri per costrire oggetti di tipo User
	 */
	public Trend() {
		
	}

	public Trend (String variation, String time) {
		this.variation = variation;
		this.time = time;
		
	}

	/**
	 * Getter e Setter: servono alle altre classi a recuperare e modificare gli attributi di User
	 */
	public int getId() {
		return this.idtrend;
	}
	public void setId(int idtrend) {
		this.idtrend = idtrend;
	}

	public String getVariation() {
		return this.variation;
	}

	public void setVariation(String variation) {
		this.variation = variation;
	}


	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	

	//Trasforma un oggetto in una stringa
	@Override
	public String toString() {
		return  idtrend + "\t"  + variation +"\t\t" +   time + "\t\t";
	}

	//Metodo per il confronto degli oggetti
	/*@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trend other = (Trend) obj;
		if (idtrend != other.idtrend)
			return false;*/
		/*if (variation == null) {
			if (other.variation != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		if (usertype == null) {
			if (other.usertype != null)
				return false;
		} else if (!usertype.equals(other.usertype))
			return false;
		return true;
	}*/
}
