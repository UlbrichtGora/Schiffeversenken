/**
 * Created by mgora on 13.05.2016.
 */
public class Runner {
    public static void main(String[] args) {
        new FrameHolder();

        SchiffVersenken spiel = new SchiffVersenken();
        spiel.spielCreate();
        spiel.spielStart();
    }
}
