//import java.util.ArrayList;
//
///**
// * Created by mgora on 17.05.2016.
// */
//public class SchiffVersenken {
//    private SpielHelfer spielHelfer = new SpielHelfer();
//    private ArrayList<Schiff> flotte = new ArrayList<Schiff>();
//    private int anzahl = 0;
//
//    public void spielCreate() {
//        Schiff fregatte = new Schiff();
//        fregatte.setName("Fregatte");
//
//        Schiff zerstoerer = new Schiff();
//        fregatte.setName("Zerstörer");
//
//        Schiff flugzeugtraeger = new Schiff();
//        flugzeugtraeger.setName("Flugzeugtraeger");
//
//        Schiff uboot = new Schiff();
//        uboot.setName("UBoot");
//
//        flotte.add(fregatte);
//        flotte.add(zerstoerer);
//        flotte.add(flugzeugtraeger);
//        flotte.add(uboot);
//
//        for (Schiff aktuellesSchiff : flotte) {
//            ArrayList<String> ort = spielHelfer.platziereSchiffe(4);
//            aktuellesSchiff.setZellorte(ort);
//
//        }
//
//    }
//
//    public void spielStart() {
//        while (!flotte.isEmpty()) {
//            String rateVersuch = spielHelfer.getBenutzereingabe("Ihren Versuch bitte. Koordinate angeben:  ");
//            checkVersuch(rateVersuch);
//        }
//        beendeSpiel();
//    }
//
//
//    private void checkVersuch(String rateVersuch) {
//        anzahl++;
//        String ergebnis = "Vorbei!";
//
//        for (Schiff aktuellesSchiff : flotte) {
//            ergebnis = aktuellesSchiff.pruefDich(rateVersuch);
//            if (ergebnis.equals("Treffer!")) {
//                break;
//            }
//            if (ergebnis.equals("Versenkt!")) {
//                flotte.remove(aktuellesSchiff);
//                break;
//            }
//
//        }
//        System.out.println(ergebnis);
//    }
//
//    private void beendeSpiel() {
//        System.out.println("Alle Schiffe sind bereits versenkt");
//        if (anzahl <= 18) {
//            System.out.println("Nicht schlecht, du hast " + anzahl + " Versuche gebraucht");
//        } else {
//            System.out.println("OMG du Flasche hast " + anzahl + " Versuche gebraucht");
//        }
//
//    }
//}
