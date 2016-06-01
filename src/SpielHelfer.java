import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by mgora on 13.05.2016.
 */
public class SpielHelfer {
    private static final String alphabet = "abcdefghij";
    private int rasterLaenge = 7;
    private int rasterGroesse = 49;
    private int[] raster = new int[rasterGroesse];
    private int anzahlSchiffe = 0;

    public String getBenutzereingabe(String prompt) {
        String eingabeZeile = null;
        System.out.println(prompt + "  ");
        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            eingabeZeile = is.readLine();
            if (eingabeZeile.length() == 0)
                return null;

        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        return eingabeZeile.toLowerCase();
    }

    public ArrayList<String> platziereSchiffe(int schiffGroesse) {
        ArrayList<String> alphaZellen = new ArrayList<String>();     // enthält die Koordinaten der Form f6
        String temp = null;                                         // temporärer String für concat
        int[] koordinaten = new int[schiffGroesse];                // aktuell mögliche Koordinaten
        int versuche = 0;                                           // aktueller Versuchszaehler;
        boolean erfolg = false;                                     // schalter = einen guten Ort gefunden?
        int ort = 0;                                                // aktuelle Startposition

        anzahlSchiffe++;                                                   // n-tes zu platzierendes Schiff
        int inkrement = 1;                                          // horizontales Inkrement setzen
        if ((anzahlSchiffe % 2) == 1) {                                    // wenn ungerades Schiff (vertikal platzieren)
            inkrement = rasterLaenge;                               // vertikales Inkrement
        }
        while (!erfolg & versuche++ < 200) {                        // Hauptsuchschleife
            ort = (int) (Math.random() * rasterGroesse);             // Zufälligen Startpunkt holen
//            System.out.println("Versuche: " + ort);
            int x = 0;                                              // n-te Position in zu platzierendem Schiff
            erfolg = true;                                          // von Erfol ausgehen
            while (erfolg && x < schiffGroesse) {                   // nach angrenzendem freien suchen
                if (raster[ort] == 0) {                             // wenn noch nicht benutzt
                    koordinaten[x++] = ort;                          // Ort speichern
                    ort += inkrement;                               // 'naechste' angrenzdende Zelle suchen
                    if (ort >= rasterGroesse) {                       // außerhalb der Grenzen - 'Ende';
                        erfolg = false;                             // Fehlschlag
                    }
                    if (x > 0 & (ort % rasterLaenge == 0)) {            // außerhalb der Grenzen - rechter Rand
                        erfolg = false;                             // Fehlschlag
                    }
                } else {                                             // bereit belegten Ort gefunden
//                    System.out.println("verwendet " + ort);
                    erfolg = false;                             // Fehlschlag
                }
            }
        }
        // Ende While
        int x = 0;
        int zeile = 0;
        int spalte = 0;

        System.out.println("Zum Mogeln einkommentiert!!! Koordinaten sonst nicht sichtbar!");
        System.out.println("--------------------");
        while (x < schiffGroesse) {
            raster[koordinaten[x]] = 1;                         // Punkte im Referenzraster als 'verwendet' markieren
            zeile = (int) (koordinaten[x]) / rasterLaenge;      //  Zeilenwert holen
            spalte = koordinaten[x] % rasterLaenge;             // numerischen Spaltenwert holen
            temp = String.valueOf(alphabet.charAt(spalte));
            x++;
            alphaZellen.add(temp.concat(Integer.toString(zeile)));

            System.out.println(" Koordinaten " + x + " = " + alphaZellen.get(x - 1));  // <--- HIER AUSKOMMENTIEREN!!!

        }
        System.out.println("--------------------");
        System.out.println("\n");
        return alphaZellen;  // Ende Methode
    }
}
