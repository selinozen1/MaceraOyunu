package maceraOyunu;

public class Silahlar {
	private String isim;
	private int id;
	private int hasar;
	private int para;
	
	public Silahlar(String isim, int id, int hasar, int para) {
		this.isim = isim;
		this.id = id;
		this.hasar = hasar;
		this.para = para;
	}

	public String getIsim() {
		return this.isim;
	}

	public void setIsim(String isim) {
		this.isim = isim;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getHasar() {
		return this.hasar;
	}

	public void setHasar(int hasar) {
		this.hasar = hasar;
	}

	public int getPara() {
		return this.para;
	}

	public void setPara(int para) {
		this.para = para;
	}
	public static Silahlar[] silah() {
		Silahlar[] silahList = new Silahlar[3];
		silahList[0] = new Silahlar("Tabanca", 1, 5,30);
		silahList[1] = new Silahlar("Kilic", 2, 7,25);
		silahList[2] = new Silahlar("Mizrak", 3, 4, 20);
		return silahList;
	}
	public static Silahlar getSilahId(int id) {
		for(Silahlar s : Silahlar.silah()) {
			if(s.getId() == id) {
				return s;
			}
		}
		return null;
		
	}
}
