package maceraOyunu;

import java.util.Scanner;

public class Oyun {
	private Scanner scan = new Scanner(System.in);
	
	public void basla() {
		System.out.println("Macera oyuna basliyor..Hosgeldinizzzz");
		System.out.print("Bir isim giriniz : ");
		String oyuncuIsmi = scan.nextLine();
		
		Oyuncu oyuncu = new Oyuncu(oyuncuIsmi);
		System.out.println(oyuncu.getIsim() + " oyuna giris yapti! Burdaki olaylar gercek hayattan esinlenerek yapilmistir!!");
		System.out.println("Bir karakter seciniz.");
		oyuncu.karakterSecme();
		
		while(true) {
			oyuncu.printInfo();
			Location lokasyon = null;
			System.out.println();
			System.out.println("Bolgeler");
			System.out.println("1- Guvenli Ev");
			System.out.println("2- Depo");
			System.out.println("3- Dag(DIKKATLI OL!)");
			System.out.println("4- Nehir(Gizemli seyler olabilir dikkat!)");
			System.out.println("5- Orman(Kan emiciler varrr!)");
			System.out.println("0- Cikis yap");
			System.out.println("Bir bolge seciniz : ");
			int lokasyonSecme = scan.nextInt();
			switch(lokasyonSecme) {
			case 0:
				lokasyon = null;
				break;
			case 1:
				lokasyon = new GuvenliEv(oyuncu);
				break;
			case 2:
				lokasyon = new AletDolabi(oyuncu);
				break;
			case 3:
				lokasyon = new Dag(oyuncu);
				break;
			case 4:
				lokasyon = new Nehir(oyuncu);
				break;
			case 5:
				lokasyon = new Orman(oyuncu);
				break;
				default:
					System.out.println("Gecerli alana geciniz.");
					break;
			}
			if(lokasyon == null) {
				System.out.println("Oyun bittiii, tekrar gelmen dilegiyle.");
				break;
			}
			if(!lokasyon.onLocation()) {
				System.out.println("Kaybettin!!");
				break;
			}
			
		}
		
	}

}
