/**
 * Created by mgora on 08.06.2016.
 */
public class MasterSchiff {
    protected String schiffsName;
    protected int schiffsgroesse[];
    protected int[][] schiffskoordinaten;

    public String getSchiffsName() {
        System.out.println(getSchiffsName());
        return schiffsName;
    }

    public void setSchiffsName(String schiffsName) {
        this.schiffsName = schiffsName;
    }

    public int[] getSchiffsgroesse() {
        return schiffsgroesse;
    }

    public void setSchiffsgroesse(int[] schiffsgroesse) {
        this.schiffsgroesse = schiffsgroesse;
    }

    public int[][] getSchiffskoordinaten() {
        return schiffskoordinaten;
    }

    public void setSchiffskoordinaten(int[][] schiffskoordinaten) {
        this.schiffskoordinaten = schiffskoordinaten;
    }
}
