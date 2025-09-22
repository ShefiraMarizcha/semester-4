import java.util.Locale;
import java.util.Currency;
import java.text.NumberFormat;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class LocaleFormatter {
    public static void main(String[] args) {
        // Menampilkan informasi tentang minimal 3 locale
        Locale[] locales = {Locale.US, new Locale("id", "ID"), Locale.FRANCE};

        for (Locale locale : locales) {
            System.out.println("Locale: " + locale);
            System.out.println("Language: " + locale.getDisplayLanguage());
            System.out.println("Country: " + locale.getDisplayCountry());
            System.out.println("Display Name: " + locale.getDisplayName());
            System.out.println();
        }

        Scanner scanner = new Scanner(System.in);

        // Input angka dari pengguna
        System.out.print("Masukkan sebuah angka: ");
        double number = scanner.nextDouble();
        scanner.nextLine(); // Membersihkan buffer newline

        // Input tanggal dari pengguna
        System.out.print("Masukkan tanggal (dd-MM-yyyy): ");
        String inputDate = scanner.nextLine();

        // Parsing tanggal
        Date date = null;
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
            date = inputFormat.parse(inputDate);
        } catch (ParseException e) {
            System.out.println("Format tanggal tidak valid.");
            System.exit(1);
        }

        // Menampilkan format angka, mata uang, dan tanggal untuk setiap locale
        for (Locale locale : locales) {
            NumberFormat numberFormat = NumberFormat.getNumberInstance(locale);
            NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(locale);
            DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG, locale);
            Currency currency = Currency.getInstance(locale);

            System.out.println("Locale: " + locale);
            System.out.println("Formatted number: " + numberFormat.format(number));
            System.out.println("Formatted currency: " + currencyFormat.format(number));
            System.out.println("Currency symbol: " + currency.getSymbol(locale));
            System.out.println("Formatted date: " + dateFormat.format(date));
            System.out.println();
        }

        scanner.close();
    }
}
