/**
 * Created by mgora on 13.05.2016.
 */
public class Runner {
    public static void main(String[] args) {
        new FrameHolder();

        SchiffVersenken spiel = new SchiffVersenken();
        spiel.spielCreate();
        spiel.spielStart();

//        int anzahl = 0;
//        SpielHelfer feld = new SpielHelfer();
//
//        Schiff dasSchiff = new Schiff();
//
//        int zufallszahl = (int) (Math.random() * 5);
//
//        int[] orte = {zufallszahl, zufallszahl + 1, zufallszahl + 2};
//
//        dasSchiff.setZellorte(orte);
//
//        boolean lebt = true;
//
//        while (lebt == true) {
//            String tipp = feld.getBenutzereingabe("Gib eine Zahl ein: ");
//            String ergebnis = dasSchiff.pruefDich(tipp);
//            anzahl++;
//            if (ergebnis.equals("Versenkt")) {
//                lebt = false;
//                System.out.println("Sie haben " + anzahl + "Versuche benötigt");
//            }
//        }

    }
}
