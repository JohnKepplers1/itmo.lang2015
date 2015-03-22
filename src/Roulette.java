import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Roulette extends SimpleFileVisitor<Path> {

    private List<String> fileList;
    private Random random;

    public Roulette() {
        fileList = new ArrayList<String>();
        random = new Random();
    }


    public String chooseFile() {
        int i = random.nextInt(fileList.size());
        return fileList.get(i);
    }

    public List<String> getList() {
        return fileList;
    }

}