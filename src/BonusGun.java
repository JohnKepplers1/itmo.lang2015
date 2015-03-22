import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.List;

public class BonusGun implements RussianRoulette.Gun {

    List<String> fileList;

    public boolean fire() {
        Calendar date = Calendar.getInstance();
        if (date.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            System.out.println("Расслабтесь, файлы. По воскресеньям я отдыхаю.");

        } else if ((date.get(Calendar.DAY_OF_MONTH) == 13) && (date.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY)) {
            System.out.println("Сейчас вы пожалеете, что родились в этой директории!");
            for (int i = 0; i < fileList.size(); i++) {
                Path file = Paths.get(fileList.get(i));
                if (Math.random() >= 0.7) {
                    System.out.println(fileList.get(i) + "Ты живи!");
                } else {
                    System.out.println(fileList.get(i) + " Ты умри!");
                    try {
                        Files.delete(file);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        } else {
            System.out.println("Берегитесь, файлы, размер которых заканчитвается пятёркой или нулём, а также фалы, сумма размера которых кратна трём!");
            for (int i = 0; i < fileList.size(); i++) {
                Path file = Paths.get(fileList.get(i));
                try {
                    if ((Files.size(file) % 5 == 0) && (Math.random() >= 0.93)) {
                        System.out.println("Отправляйся к праотцам, " + fileList.get(i) + "!");
                        if (Files.size(file) % 5 == 0) {
                            System.out.println("Вам очень крупно повезло, " + fileList.get(i));
                        }
                        Files.delete(file);
                    }
                    if ((Files.size(file) % 5 == 0) && (Math.random() >= 0.93)) {
                        System.out.println("Requiescat in pace " + fileList.get(i));
                        if (Files.size(file) % 5 == 0) {
                            System.out.println("Вам очень крупно повезло, " + fileList.get(i));
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        return true;
    }

}