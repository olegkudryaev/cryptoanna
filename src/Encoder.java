import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class Encoder {

    static int key = 0;
    static String russianAlphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    static String englishAlphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static String symbols = "\r\n.?!,;: -()\"";
    static String numbers = "1234567890";
    static String CryptoAlphabet = englishAlphabet + russianAlphabet + symbols + numbers;
    static char[] chars = CryptoAlphabet.toCharArray();

//    static String CryptoAlphabet = "ja";
//    static char[] chars = CryptoAlphabet.toCharArray();

    //Читаем текст и сохраняем его в СтрингБилдере

    StringBuilder readFile(Path path) throws IOException {
        List<String> list = Files.readAllLines(path);
        StringBuilder text = new StringBuilder();
        for (String str : list) {
            text.append(str);
        }
        System.out.println(text);
        return text;
    }

    //Берем стринг билдер и сдвигаем символы по альфавиту на ключ
    StringBuilder moveText(StringBuilder text, int number) {
        StringBuilder newText = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);
            for (int j = 0; j < chars.length; j++) {
                if (symbol == chars[j]) {
                    //                   System.out.print("Исходный символ " + symbol + " ");
                    int indexChar = j;
                    if (indexChar + number >= chars.length) {
                        symbol = chars[(j - chars.length) + number];
                        newText.append(symbol);
                        System.out.println(newText.toString());
                        break;
                    }
                    symbol = chars[j + 2];
                    //                  System.out.println("и измененный символ " + symbol);
                    newText.append(symbol);
                    break;
                }
            }
        }
//        System.out.println(newText);
        return newText;
    }

    //Сдвинутый билдер грузим в файл
    void textCryptoLoading(StringBuilder newText, Path path) throws IOException {
        Files.createFile(path);
        Files.writeString(path, newText);
    }

    StringBuilder readCryptoFile() throws IOException {
        Path path = Path.of("F:\\Test\\Test2.txt");
        List<String> list = Files.readAllLines(path);
        StringBuilder text = new StringBuilder();
        for (String str : list) {
            text.append(str);
        }
        return text;
    }

    StringBuilder moveCryptoText(StringBuilder text) {
        StringBuilder newText = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);
            for (int j = 0; j < chars.length; j++) {
                if (symbol == chars[j]) {
//                   System.out.print("Исходный символ " + symbol + " ");
                    symbol = chars[j - 1];
//                   System.out.println("и измененный символ " + symbol);
                    newText.append(symbol);
                    break;
                }
            }
        }
        System.out.println(newText);
        return newText;
    }

    StringBuilder textNormalLoading(StringBuilder newText) throws IOException {
        Files.createFile(Path.of("F:\\Test\\Text3.txt"));
        String str = newText.toString();
        Files.writeString(Path.of("F:\\Test\\Text3.txt"), str);
        return null;
    }


}
