package it.contrader.model;
/**
 * Per dettagli vedi guida sez 4 Model
 */
public class Coin {

	/**
	 * Qui sotto definisco gli attributi di User. 
	 */
	private int idcoin;

	private String name;
	
	private String quotation;
	
	private String symbol;

	
	// costruttore vuoto
	public Coin() {
		
	}
	
	// costruttore senza id

	public Coin(String name, String quotation, String symbol) {
		
		this.name = name;
		this.quotation = quotation;
		this.symbol = symbol;
	}

	// gettere e setter
	
	
	public int getId() {
		return idcoin;
	}


	public void setId(int idcoin) {
		this.idcoin = idcoin;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getQuotation() {
		return quotation;
	}


	public void setQuotation(String quotation) {
		this.quotation = quotation;
	}


	public String getSymbol() {
		return symbol;
	}


	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	@Override
	public String toString() {
		return  idcoin + "\t"  + name +"\t\t" +   quotation + "\t\t" + symbol;
	}
	





}