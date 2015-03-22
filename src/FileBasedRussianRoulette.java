public class FileBasedRussianRoulette implements RussianRoulette {

    public static void main(String[] args) {
        Gun gun;

        String path = args[0];
        if (args[1].equals("bonus")) {
            gun = new BonusGun(path);
        } else {
                int bullets = (args[1].charAt(1) - '1');
            gun = new SimpleGun(path, bullets);
        }

        RussianRoulette russianRoulette = new FileBasedRussianRoulette();
        russianRoulette.play(gun);
    }

    public void play(Gun gun) {
        gun.fire();
    }
}