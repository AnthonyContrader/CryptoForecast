package it.contrader.model;
/**
 * Per dettagli vedi guida sez 4 Model
 */
public class Coin {

	/**
	 * Qui sotto definisco gli attributi di Coin. 
	 */
	private int idcoin;

	private String name;
	
	private int quotation;
	
	private String symbol;

	
	// costruttore vuoto
	public Coin() {
		
	}
	
	// costruttore senza id

	public Coin(String name, int quotation, String symbol) {
		
		this.name = name;
		this.quotation = quotation;
		this.symbol = symbol;
	}
    
	// costruttore completo
	
	public Coin(int idcoin, String name, int quotation, String symbol) {
		
    	this.idcoin = idcoin;
		this.name = name;
		this.quotation = quotation;
		this.symbol = symbol;
	}

	// gettere e setter
	
	
	public int getId() {
		return this.idcoin;
	}


	public void setId(int idcoin) {
		this.idcoin = idcoin;
	}


	public String getName() {
		return this.name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getQuotation() {
		return this.quotation;
	}


	public void setQuotation(int quotation) {
		this.quotation = quotation;
	}


	public String getSymbol() {
		return this.symbol;
	}


	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	@Override
	public String toString() {
		return  idcoin + "\t"  + name +"\t\t" + quotation + "\t\t" + symbol;
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
			Coin other = (Coin) obj;
			if (idcoin != other.idcoin)
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			if (quotation == 0) {
				if (other.quotation != 0)
					return false;
			} else if (quotation != (other.quotation))
				return false;
			if (symbol == null) {
				if (other.symbol != null)
					return false;
			} else if (!symbol.equals(other.symbol))
				return false;
			return true;
		}
	}
