import java.util.ArrayList;

/**
 * Created by mgora on 03.06.2016.
 */
public class Flotte {
    private ArrayList<Schiff> flotte = new ArrayList<>();
    private int anzahl = 0;

    public void spielCreate() {
        Schiff uboot = new Schiff();
        uboot.setName("UBoot");

        Schiff fregatte = new Schiff();
        fregatte.setName("Fregatte");

        Schiff zerstoerer = new Schiff();
        zerstoerer.setName("Zerstörer");

        Schiff flugzeugtraeger = new Schiff();
        flugzeugtraeger.setName("Flugzeugtraeger");

        flotte.add(uboot);
        flotte.add(fregatte);
        flotte.add(zerstoerer);
        flotte.add(flugzeugtraeger);

        for (Schiff aktuellesSchiff : flotte) {
            System.out.println(aktuellesSchiff.getClass().getName());

        }

    }
}
