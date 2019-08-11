import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.Scanner;


//Написать код, который будет копировать указанную папку с файлами
//с сохранением структуры в другую указанную папку.

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Укажите папку, которую нужно скопировать");
        String sourcePath = scanner.nextLine();
        System.out.println("Укажите папку, в которую нужно копировать");
        String outPath = scanner.nextLine();

//        String sourcePath = "C:\\Users\\User\\IdeaProjects\\untitled";
//        String outPath = "C:\\Users\\User\\IdeaProjects\\testCopy";

        File src = new File(sourcePath);
        File dest = new File(outPath);

        copyFolder(src, dest);

    }

    static void copyFolder(File src, File dest) {
        try {
            String newDir = dest.getAbsolutePath() + "\\" + src.getName();
            File newFile = new File(newDir);
            if (src.isDirectory()) {
                if (!newFile.exists()) {
                    newFile.mkdir();
                }
                File[] files = src.listFiles();
                for (File file:files){
                    copyFolder(file, newFile);
                }
            } else{
                Files.copy(src.toPath(), newFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
