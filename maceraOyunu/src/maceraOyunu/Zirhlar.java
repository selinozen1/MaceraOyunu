package maceraOyunu;

public class Zirhlar {
	private int id;
	private String isim;
	private int blok;
	private int para;
	
	public Zirhlar(int id, String isim, int blok, int para) {
		this.id = id;
		this.isim = isim;
		this.blok = blok;
		this.para = para;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIsim() {
		return this.isim;
	}

	public void setName(String isim) {
		this.isim = isim;
	}

	public int getBlok() {
		return this.blok;
	}

	public void setBlok(int blok) {
		this.blok = blok;
	}

	public int getPara() {
		return this.para;
	}

	public void setPara(int para) {
		this.para = para;
	}
	
	public static Zirhlar[] zirh() {
		Zirhlar[] zirhList = new Zirhlar[3];
		zirhList[0] = new Zirhlar(1, "Hafif", 2, 7);
		zirhList[1] = new Zirhlar(2, "Orta", 5, 8);
		zirhList[2] = new Zirhlar(3, "Agir", 8, 11);
		return zirhList;
	}
	public static Zirhlar getZirhId(int id) {
		for (Zirhlar  z : Zirhlar.zirh()) {
			if(z.getId() == id) {
				return z;
			}
		}
		return null;
	}
	
	
	

}
