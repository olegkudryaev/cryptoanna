import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class BruteForce {
    static int key = 0;
    static String russianAlphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    static String englishAlphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static String symbols = "\r\n.?!,;: -()\"";
    static String numbers = "1234567890";
    static String CryptoAlphabet = englishAlphabet + russianAlphabet + symbols + numbers;
    static char[] chars = CryptoAlphabet.toCharArray();

    StringBuilder readFileForBrute(Path path) throws IOException {
        List<String> list = Files.readAllLines(path);
        StringBuilder text = new StringBuilder();
        for (String str : list) {
            text.append(str);
        }
        return text;
    }

    StringBuilder examText(StringBuilder text) {
        int number = 0;
        StringBuilder newText = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        boolean b = true;
        do{
        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);
            char symbol2 = text.charAt(i + 1);
            if (symbol == ',' && symbol2 == ' ') {
                answer = newText;
                b = false;
                break;
            }
        }
        for (int k = 0; k < text.length(); k++) {
            char symbol3 = text.charAt(k);
            for (int j = 0; j < chars.length; j++) {
                if (symbol3 == chars[j]) {
                    System.out.print("Исходный символ " + symbol3 + " ");
                    int indexChar = j;
                    if (indexChar + number >= chars.length) {
                        symbol3 = chars[(j - chars.length) - number];
                        newText.append(symbol3);
                        break;
                    }
                    symbol3 = chars[j - number];
                    System.out.println("и измененный символ " + symbol3);
                    newText.append(symbol3);
                    break;
                }
            }
        }} while (b);

        return answer;
    }

    StringBuilder textNormalLoading(StringBuilder newText, Path path) throws IOException {
        Files.createFile(Path.of("F:\\Test\\Text3.txt"));
        String str = newText.toString();
        Files.writeString(Path.of("F:\\Test\\Text3.txt"), str);
        return null;
    }

//            for (int j = 0; j < chars.length; j++) {
//                if (symbol == chars[j]) {
//                    System.out.print("Исходный символ " + symbol + " ");
//                    int indexChar = j;
//                    if (indexChar + number >= chars.length) {
//                        symbol = chars[(j - chars.length) - number];
//                        newText.append(symbol);
//                        break;
//                    }
//                    symbol = chars[j - number];
//                    System.out.println("и измененный символ " + symbol);
//                    newText.append(symbol);
//                    break;
//                }
//            }

//        System.out.println(newText);


//  public StringBuilder bruteForce (StringBuffer text) {
//      return null;
////      while (true) {
////          String forMethod = text.toString();
////          char[] start = forMethod.toCharArray();
////          char[] result = new char[start.length];
////          int keyForDecr = chars.length - key;
////          for (int i = 0; i < start.length; i++) {
////              char stCh = start[i];
////              for (int j = 0; j < chars.length; j++) {
////                  char resCh = chars[j];
////                  if (stCh == resCh) {
////                      result[i] = chars[(j + keyForDecr) % chars.length];
////                  }
////              }
////          }
////          StringBuffer str = new StringBuffer(new String(result));
////          String textForTest = new String(result);
////          int count = 0;
////          for (int i = 0; i < textForTest.length(); i++) {
////              int ch = i;
////              if (ch == result.length - 1) {
////                  break;
////              }
////              if ((result[i] == '.' && result[i + 1] == ' ') || (result[i] == ',' && result[i + 1] == ' ')) {
////                  count++;
////              }
////          }
////          if (count > 10) {
////              return str;
////          } else {
////              key++;
////          }
////      }
//  }
}