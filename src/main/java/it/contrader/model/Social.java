package it.contrader.model;
/**
 * Per dettagli vedi guida sez 4 Model
 */
public class Social {

	/**
	 * Qui sotto definisco gli attributi di Coin. 
	 */
	private int id;
    private String url;
	private int post;
	private String data;
	private String namecoin;

	
	// costruttore vuoto
	public Social() {
		
	}
	
	// costruttore senza id

	public Social(String url, int post, String data, String namecoin) {
		
		this.url = url;
		this.post= post;
		this.data = data;
		this.namecoin = namecoin;
	}
    
	// costruttore completo
	
	public Social(int id, String url, int post, String data, String namecoin) {
		
    	this.id = id;
    	this.url = url;
		this.post= post;
		this.data = data;
		this.namecoin = namecoin;
	}

	// gettere e setter
	
	
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

	public String getNamecoin() {
		return this.namecoin;
	}


	public void setNamecoin(String namecoin) {
		this.namecoin = namecoin;
	}
	
	@Override
	public String toString() {
		return  id + "\t"  + url +"\t\t" + post + "\t\t" + data +"\t\t" + namecoin;
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
			Social other = (Social) obj;
			if (id != other.id)
				return false;
			if (url == null) {
				if (other.url != null)
					return false;
			} else if (!url.equals(other.url))
				return false;
			if (post == 0) {
				if (other.post != 0)
					return false;
			} else if (post != (other.post))
				return false;
			if (data == null) {
				if (other.data != null)
					return false;
			} else if (!data.equals(other.data))
				return false;
			if (namecoin == null) {
				if (other.namecoin != null)
					return false;
			} else if (!namecoin.equals(other.namecoin))
				return false;
			return true;
		}
	}
