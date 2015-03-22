
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

class SimpleGun implements RussianRoulette.Gun {

    private int bullets;
    private Random random;
    private String path;

    public SimpleGun(String path, int bullets) {
        this.bullets = bullets;
        this.path = path;
        random = new Random();
    }

    public boolean fire() {
        double probability = (double) bullets / 6;
        double random = Math.random();
        boolean success = (probability >= random);

        Path files = Paths.get(path);
        Roulette roulette = new Roulette();
        try {
            if (roulette.chooseFile() != null) {
                Path file = Paths.get(roulette.chooseFile());
                if (success) {
                    System.out.println("Сегодня нас покинул " + file.getFileName().toString() + ". Помолимся же за него.");
                    Files.delete(file);
                } else {
                    System.out.println("Слава великому рандому! Невинный " + file.getFileName().toString() + "остался жить!");
                }
            } else {
                if (success) {
                    System.out.println("Не выбрана жертва.");
                } else {
                    System.out.println("Вы сломали программу!");
                }

            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return success;
    }
}