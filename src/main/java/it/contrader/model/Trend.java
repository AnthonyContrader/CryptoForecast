package it.contrader.model;
/**
 * Per dettagli vedi guida sez 4 Model
 */
public class Trend {

	/**
	 * Qui sotto definisco gli attributi di Trend. 
	 */
	private int id;
	private String time;
	private int variation;
	private String namecoin;
	
	

	/**
<<<<<<< HEAD
	 * Definisco i tre costruttori, uno vuoto e uno con tre parametri per costrire oggetti di tipo Trend
=======
	 * Definisco i due costruttori, uno vuoto e uno con tre parametri per costrire oggetti di tipo Trend
>>>>>>> 061a4818da1b50224fcf056ac0ccb302c91aca35
	 */
	public Trend() {
		
	}
	
	public Trend (int variation, String namecoin) {
	
		this.variation = variation;
		this.namecoin = namecoin;
	}
	
	

	public Trend (String time, int variation, String namecoin ) {
		this.time = time;
		this.variation = variation;
		this.namecoin = namecoin;
	}

	public Trend(int id,String time, int variation,  String namecoin) {
		
		this.id = id;
		this.time = time;
		this.variation = variation;
		this.namecoin = namecoin;
	}

	/**
	 * Getter e Setter: servono alle altre classi a recuperare e modificare gli attributi di Trend
	 */
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getVariation() {
		return this.variation;
	}

	public void setVariation(int variation) {
		this.variation = variation;
	}


	public String getNamecoin() {
		return this.namecoin;
	}

	public void setNamecoin(String namecoin) {
		this.namecoin = namecoin;
	}

	//Trasforma un oggetto in una stringa
	@Override
	public String toString() {
		return  id + "\t"  + time +"\t\t" +   variation + "\t\t" + namecoin + "\t\t";
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
		if (id != other.id)
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		if (variation == 0) {
			if (other.variation != 0)
				return false;
		} else if (variation != (other.variation))
			return false;
		if (namecoin == null) {
			if (other.namecoin != null)
				return false;
		} else if (!namecoin.equals(other.namecoin))
			return false;
		return true;
	}
}

