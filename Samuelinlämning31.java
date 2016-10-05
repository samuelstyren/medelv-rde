package inlämningar;

import javax.swing.JOptionPane;

public class Samuelinlämning31 {

	/*
	 * Metoden kontrollerar om man har skrivit in minst ett tal när man försöker räkna ut 
	 * medelvärdet om man inte skrivt in minst ett tal så kommer en dialogruta upp som 
	 * säger att man måste skriva in minst ett tal, annars så kommer det upp dialogruta 
	 * där medelvärdet står.         
	 */
	
	public static void kontrollAvInskrivning(int antal, double medelvärde) {
		if (antal == 0) {
			JOptionPane.showMessageDialog(null, "Kan inte beräkna medelvärde!\nDu måste mata in minst ett tal");
		} else {
			JOptionPane.showMessageDialog(null, "Medelvärdet av de " + antal + " talen är " + medelvärde);
		}
	}

	/*
	 * Programmet räknar ut medelvärdet av de tal man skriver in i en dialogruta
	 * och sedan skriver programmet ut medelvärdet i ny dialogruta
	 */
	public static void main(String[] args) {

		Medelvärde uträkning = new Medelvärde();
		uträkning.uträkningMedelvärde();
		kontrollAvInskrivning(uträkning.antal, uträkning.medelvärde);

	}

}

class Medelvärde {

	/*
	 * Jag har valt att använda mig av instansvariabler för att dessa 3 variabler ska
	 * vara lätta att använda i hela programmet.
	 */
	public double summa = 0;
	public int antal = 0;
	public double medelvärde = 0;

	/*
	 * Denna metod används för att räknar ut medelvärdet. Den inerhåller en
	 * while loop som gör så att dialogrutan där man skriver in talen kommer upp
	 * på nytt när man tryckt på ok efter man skrivit in ett tal. Medelvärdet
	 * räknas ut efter man tryckt på ok eller avbryt i dialogrutan men denna
	 * gången inte skrivit in ett tal.
	 */
	public void uträkningMedelvärde() {
		while (true) {
			String tal = JOptionPane.showInputDialog("Ange ett tal:");
			if (tal == null || tal.isEmpty()) {
				medelvärde = summa / antal;
				break;
			} else {
				try {
					summa = summa + Double.parseDouble(tal);
				} catch (NumberFormatException a) {
					continue; // om användaren skriver in en sträng ignorerar vi det och
					          // dialogrutan för inmatning av tal kommer upp igen
				}
				antal++;
			}
		}
	}

}