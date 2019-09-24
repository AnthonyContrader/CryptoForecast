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
	
	private String namecoin;
	
	

	/**
	 * Definisco i due costruttori, uno vuoto e uno con tre parametri per costrire oggetti di tipo User
	 */
	public Trend() {
		
	}

	public Trend (String variation, String time, String namecoin ) {
		this.variation = variation;
		this.time = time;
		this.namecoin = namecoin;
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

	public String getNamecoin() {
		return this.time;
	}

	public void setNamecoin(String time) {
		this.time = time;
	}

	//Trasforma un oggetto in una stringa
	@Override
	public String toString() {
		return  idtrend + "\t"  + variation +"\t\t" +   time + "\t\t" + namecoin + "\t\t";
	}

	//Metodo per il confronto degli oggetti
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trend other = (Trend) obj;
		if (idtrend != other.idtrend)
			return false;
		if (namecoin == null) {
			if (other.namecoin != null)
				return false;
		}
		return true;
	}
}

