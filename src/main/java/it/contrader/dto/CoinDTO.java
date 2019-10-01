package it.contrader.dto;

/**
 * 
 * @author team GDA
 *
 *Il DTO è simile al Model ma può contenere meno attributi (ad esempio d dati sensibili
 *che non devono arrivare alla View). GLi oggetti vengono trasformati da oggetti del Model
 *a oggetti del DTO tramite i Converter (chiamati dai Service). 
 *Per la descrizione della classe far riferimento al Model "User".
 */
public class CoinDTO {
	
	private int id;

	private String name;
	
	private int quotation;
	
	private String symbol;

	//costruttore senza campi
		public CoinDTO() {
		
	}
		
// costruttore senza campo idcoin
public CoinDTO(String name, int quotation, String symbol) {

		this.name = name;
		this.quotation = quotation;
		this.symbol = symbol;
	}


//costruttore con campi
	public CoinDTO(int id, String name, int quotation, String symbol) {
	
		this.id = id;
		this.name = name;
		this.quotation = quotation;
		this.symbol = symbol;
	}

//costruttore getters and setters
	public int getId() {
		return this.id;
	}



	public void setId(int id) {
		this.id = id;
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
		return  id + "\t"  + name +"\t\t" +   quotation + "\t\t" + symbol;
	}
}
