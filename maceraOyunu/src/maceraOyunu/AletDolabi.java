package maceraOyunu;

public class AletDolabi extends NormalLocation {
	public AletDolabi(Oyuncu oyuncu) {
		super(oyuncu, "Depo");
	}
	
	@Override
	public boolean onLocation() {
		System.out.println("Depoya hosgeldin!");
		boolean menu = true;
		while(menu) {
			System.out.println();
			System.out.println("1-Silahlar");
			System.out.println("2-Zirhlar");
			System.out.println("3-Cikis yap");
			System.out.print("Secilen komut : ");
			int komutSecme = scan.nextInt();
			while(komutSecme < 1 || komutSecme > 3) {
				System.out.println("Gecersiz, yeniden seciniz!");
				komutSecme = scan.nextInt();
			}
			switch(komutSecme) {
			case 1:
				silah();
				silahSatınAlma();
				break;
			case 2:
				zirh();
				zirhSatinAlma();
				break;
			case 3:
				System.out.println("Tekrar beklerizzz!");
				menu = false;
				break;
			}
		}
		return true;
		
	}
	public void silah() {
		System.out.println();
		System.out.println("Silahlar");
		for(Silahlar s : Silahlar.silah()) {
			System.out.println(s.getId() + "- " + s.getIsim() + " ==>" + "\tHasar : " + s.getHasar() + " Para : " + s.getPara());
		}
		System.out.println();
		System.out.println("0- Cikis yapiniz!");
	}
		
		public void silahSatınAlma() {
			System.out.println("Bir adet silah seciniz : ");
			int silahSecmeId = scan.nextInt();
			while(silahSecmeId < 0 || silahSecmeId > Silahlar.silah().length) {
				System.out.println("Gecersiz, yeniden seciniz!");
				silahSecmeId = scan.nextInt();
			}
			if(silahSecmeId != 0) {
				Silahlar silahiSecme = Silahlar.getSilahId(silahSecmeId);
				
				if(silahiSecme != null) {
					if(silahiSecme.getPara() > this.getOyuncu().getPara()) {
						System.out.println("Yetersiz Bakiye");
					}else {
						System.out.println(silahiSecme.getIsim() + " silahini aldiniz.");
						int kalan = this.getOyuncu().getPara() - silahiSecme.getPara();
						this.getOyuncu().setPara(kalan);
						System.out.print("Kalan para miktari : " + this.getOyuncu().getPara());
						System.out.println();
						System.out.println("Onceki sectiginiz silah : " + this.getOyuncu().getStok().getSilah().getIsim());
						this.getOyuncu().getStok().setSilah(silahiSecme);
						System.out.println("Yeni secilen silah : " + this.getOyuncu().getStok().getSilah().getIsim());
					}
				}
		}
			}
			
	public void zirh() {
		System.out.println();
		System.out.println("Zirhlar");
		for(Zirhlar z : Zirhlar.zirh()) {
			System.out.println(z.getId() + "- " + z.getIsim() + " ==>" + " \tBlok : " + z.getBlok() + "\tPara : " + z.getPara());
		}
		System.out.println();
		System.out.println("0- Cikis yapiniz!");
	}
	public void zirhSatinAlma() {
		System.out.println("Bir adet zirh seciniz : ");
		int zirhSecmeId = scan.nextInt();
		while(zirhSecmeId < 0 || zirhSecmeId > Zirhlar.zirh().length) {
			System.out.println("Gecersiz, yeniden seciniz!");
			zirhSecmeId = scan.nextInt();
		}
		if(zirhSecmeId != 0) {
			Zirhlar zirhiSecme = Zirhlar.getZirhId(zirhSecmeId);
			
			if(zirhiSecme != null) {
				if(zirhiSecme.getPara() > this.getOyuncu().getPara()) {
					System.out.println("Yetrsiz bakiye");
				}else {
					System.out.println(zirhiSecme.getIsim() + " zirhini aldiniz.");
					int kalan = this.getOyuncu().getPara() - zirhiSecme.getPara();
					this.getOyuncu().setPara(kalan);
					System.out.println("Kalan para miktari : " + this.getOyuncu().getPara());
					System.out.println();
					System.out.println("Onceki secilen zirh : " + this.getOyuncu().getStok().getZirh().getIsim());
					this.getOyuncu().getStok().setZirh(zirhiSecme);
					System.out.println("Yeni secilen zirh : " + this.getOyuncu().getStok().getZirh().getIsim());
				}
			}
		}
	}
		}
		
