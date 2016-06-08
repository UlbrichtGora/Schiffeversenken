//import java.util.ArrayList;
//
///**
// * Created by mgora on 13.05.2016.
// */
//public class Schiff {
//    private ArrayList<String> zellorte;
//    private String name;
//
//    public void setZellorte(ArrayList<String> orte) {
//        zellorte = orte;
//    }
//
//    public void setName(String n) {
//        name = n;
//    }
//
//    public String pruefDich(String benutzereingabe) {
//        String ergebnis = "Vorbei";
//        int index = zellorte.indexOf(benutzereingabe);
//
//        if (index >= 0) {
//            zellorte.remove(index);
//
//            if (zellorte.isEmpty()) {
//                ergebnis = "Versenkt!";
//                System.out.println("Yihaaa! Du hast ein(e) " + name + " versenkt!!!: ");
//            } else {
//                ergebnis = "Treffer!";
//            }
//        }
//        return ergebnis;
//    }
//
//
//}
