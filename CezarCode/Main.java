package CezarCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("src/CezarCode/input.txt"));
            PrintWriter output = new PrintWriter("src/CezarCode/output.txt");
            StringBuilder text = new StringBuilder();
            while (sc.hasNextLine()) {
                text.append(sc.nextLine());
            }
            int shift = (int) (Math.random() * (150 + 1));
            System.out.println("рандомное смещение = " + shift);
            EncryptCezar cezar = new EncryptCezar(text.toString(), shift);
            output.println(cezar.encryption());
            output.close();
        } catch (FileNotFoundException e) {
            System.err.println("файла нет");
        } catch (NoSuchElementException e) {
            System.err.println("ни одна строка не найдена");
        } catch (SecurityException e) {
            System.err.println("доступ к записи в файл закрыт");
        }
    }
}
