package codelab3;
import org.apache.commons.lang3.StringUtils;

public class App {
    public static void main(String[] args) {
        String text = "Hello, Maven!";
        // Menggunakan StringUtils dari Apache Commons untuk membalik teks
        String reversedText = StringUtils.reverse(text);
        // Menampilkan teks yang dibalik ke layar
        System.out.println(reversedText);
    }
}
