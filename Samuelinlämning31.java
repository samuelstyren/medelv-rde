package inl�mningar;

import javax.swing.JOptionPane;

public class Samuelinl�mning31 {

	/*
	 * Metoden kontrollerar om man har skrivit in minst ett tal n�r man f�rs�ker r�kna ut 
	 * medelv�rdet om man inte skrivt in minst ett tal s� kommer en dialogruta upp som 
	 * s�ger att man m�ste skriva in minst ett tal, annars s� kommer det upp dialogruta 
	 * d�r medelv�rdet st�r.         
	 */
	
	public static void kontrollAvInskrivning(int antal, double medelv�rde) {
		if (antal == 0) {
			JOptionPane.showMessageDialog(null, "Kan inte ber�kna medelv�rde!\nDu m�ste mata in minst ett tal");
		} else {
			JOptionPane.showMessageDialog(null, "Medelv�rdet av de " + antal + " talen �r " + medelv�rde);
		}
	}

	/*
	 * Programmet r�knar ut medelv�rdet av de tal man skriver in i en dialogruta
	 * och sedan skriver programmet ut medelv�rdet i ny dialogruta
	 */
	public static void main(String[] args) {

		Medelv�rde utr�kning = new Medelv�rde();
		utr�kning.utr�kningMedelv�rde();
		kontrollAvInskrivning(utr�kning.antal, utr�kning.medelv�rde);

	}

}

class Medelv�rde {

	/*
	 * Jag har valt att anv�nda mig av instansvariabler f�r att dessa 3 variabler ska
	 * vara l�tta att anv�nda i hela programmet.
	 */
	public double summa = 0;
	public int antal = 0;
	public double medelv�rde = 0;

	/*
	 * Denna metod anv�nds f�r att r�knar ut medelv�rdet. Den inerh�ller en
	 * while loop som g�r s� att dialogrutan d�r man skriver in talen kommer upp
	 * p� nytt n�r man tryckt p� ok efter man skrivit in ett tal. Medelv�rdet
	 * r�knas ut efter man tryckt p� ok eller avbryt i dialogrutan men denna
	 * g�ngen inte skrivit in ett tal.
	 */
	public void utr�kningMedelv�rde() {
		while (true) {
			String tal = JOptionPane.showInputDialog("Ange ett tal:");
			if (tal == null || tal.isEmpty()) {
				medelv�rde = summa / antal;
				break;
			} else {
				try {
					summa = summa + Double.parseDouble(tal);
				} catch (NumberFormatException a) {
					continue; // om anv�ndaren skriver in en str�ng ignorerar vi det och
					          // dialogrutan f�r inmatning av tal kommer upp igen
				}
				antal++;
			}
		}
	}

}