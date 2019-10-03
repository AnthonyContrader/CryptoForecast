package it.contrader.model;
/**
 * Per dettagli vedi guida sez 4 Model
 */
public class Commit {

	/**
	 * Qui sotto definisco gli attributi di Coin. 
	 */
	private int id;

	private String namecoin;
	
	private int number;
	
	private String data;

	
	// costruttore vuoto
	public Commit() {
		
	}
	
	// costruttore senza id

	public Commit(String namecoin, int number, String data) {
		
		this.namecoin = namecoin;
		this.number = number;
		this.data = data;
	}
    
	// costruttore completo
	
	public Commit(int id, String namecoin, int number, String data) {
		
    	this.id = id;
		this.namecoin = namecoin;
		this.number = number;
		this.data = data;
	}

	// gettere e setter
	
	
	public int getId() {
		return this.id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNamecoin() {
		return this.namecoin;
	}


	public void setNamecoin(String namecoin) {
		this.namecoin = namecoin;
	}


	public int getNumber() {
		return this.number;
	}


	public void setNumber(int number) {
		this.number = number;
	}


	public String getData() {
		return this.data;
	}


	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return  id + "\t"  + namecoin +"\t\t" + number + "\t\t" + data;
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
			Commit other = (Commit) obj;
			if (id != other.id)
				return false;
			if (namecoin == null) {
				if (other.namecoin != null)
					return false;
			} else if (!namecoin.equals(other.namecoin))
				return false;
			if (number == 0) {
				if (other.number != 0)
					return false;
			} else if (number != (other.number))
				return false;
			if (data == null) {
				if (other.data != null)
					return false;
			} else if (!data.equals(other.data))
				return false;
			return true;
		}
	}
