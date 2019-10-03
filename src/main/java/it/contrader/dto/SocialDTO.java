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
public class SocialDTO {
	
	private int id;
	private String url;
	private int post;
	private String data;
    private String namecoin;

	//costruttore senza campi
		public SocialDTO() {
		
	}
		
		
		
// costruttore senza campo id
public SocialDTO(String url, int post, String data, String namecoin) {

		this.url = url;
		this.post = post;
		this.data = data;
		this.namecoin = namecoin;
	}


//costruttore con campi
	public SocialDTO(int id, String url, int post, String data, String namecoin) {
	
		this.id = id;
		this.url = url;
		this.post = post;
		this.data = data;
		this.namecoin = namecoin;
	}

//costruttore getters and setters
	public int getId() {
		return this.id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getUrl() {
		return this.url;
	}



	public void setUrl(String url) {
		this.url = url;
	}



	public int getPost() {
		return this.post;
	}



	public void setPost(int post) {
		this.post = post;
	}



	public String getData() {
		return this.data;
	}
	
	public void setData(String data) {
		this.data = data;
	}


	public void setNamecoin(String namecoin) {
		this.namecoin = namecoin;
	}
	
	public String getNamecoin() {
		return this.namecoin;
	}


	@Override
	public String toString() {
		return  id + "\t"  + url +"\t\t" +   post + "\t\t" + data + "\t\t" + namecoin;
	}
}
