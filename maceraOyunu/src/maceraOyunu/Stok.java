package maceraOyunu;

public class Stok {
	private Silahlar silah;
	private Zirhlar zirh;

	public Stok(Silahlar silah) {
		this.silah = new Silahlar("Yumruk", -1 , 0, 0);
		this.zirh = new Zirhlar(-1, "Yok", 0, 0);
	}

	public Silahlar getSilah() {
		return this.silah;
	}

	public void setSilah(Silahlar silah) {
		this.silah = silah;
	}

	public Zirhlar getZirh() {
		return this.zirh;
	}

	public void setZirh(Zirhlar zirh) {
		this.zirh = zirh;
	}
	
	
	
	
	
	
	
	
	

}
