package maceraOyunu;

public class Karakter {
	private String isim;
	private int hasar;
	private int saglik;
	private int para;
	private int id;
	
	public Karakter(String isim, int hasar, int saglik, int para, int id) {
		this.isim = isim;
		this.hasar = hasar;
		this.saglik = saglik;
		this.para = para;
		this.id = id;
	}
	
	public String getIsim() {
		return this.isim;
	}
	
	public void setIsim(String isim) {
		this.isim = isim;
	}

	public int getHasar() {
		return this.hasar;
	}

	public void setHasar(int hasar) {
		this.hasar = hasar;
	}

	public int getSaglik() {
		return this.saglik;
	}

	public void setSaglik(int saglik) {
		this.saglik = saglik;
	}

	public int getPara() {
		return this.para;
	}

	public void setPara(int para) {
		this.para = para;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
