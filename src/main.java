import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException {

        Encoder encoder = new Encoder();
        Scanner consoleText = new Scanner(System.in);
        System.out.println("Выбери действие, введя его номер.\n" +
                "1 Зашифровать текст в файле с помощью ключа\n" +
                "2 Расшифровать текст в файле с помощью ключа \n" +
                "3  Криптоанализ текса в файле (выбрать метод)\n" +
                "A метод Brute force\n" +
                "B метод статистического анализа \n" +
                "Для выхода из программы введи exit");
        System.out.println();
        System.out.println("Выберите метод");
        while (consoleText.hasNextLine()) {
            String question = consoleText.nextLine();
            if (question.equals("1")) {
//                fileAddressRequestforEncryption();

                System.out.println("Введите путь до файла");
                Path pathToFile = Path.of(consoleText.nextLine());
                StringBuilder text = encoder.readFile(pathToFile);

                System.out.println("Введите ключ от 1 до 100");
                int number = Integer.parseInt(consoleText.nextLine());
                StringBuilder moveText = encoder.moveText(text, number);

                System.out.println("Введите адрес, для создания файла с зашифрованным текстом");
                String str = consoleText.nextLine();
                Path pathToCrFile = Path.of(str);
                encoder.textCryptoLoading(moveText, pathToCrFile);

                break;
            } else if (question.equals("2")) {
//                fileAddressRequestforDecryption();
                break;
            } else if (question.equals("3")) {
                System.out.println(" Вы выбрали криптоанализ\n" +
                        "Выберите какой метод будете использовать?\n" +
                        "A метод Brute force\n" +
                        "B метод статистического анализа \n" +
                        "Для выхода из программы введи exit");
                String choiceOfMethod = consoleText.nextLine();
                if (choiceOfMethod.equals("A")) {
                    System.out.println("Выбран метод Brute force");
                    //           fileAddressRequestforBruteForce();
                    break;
                } else if (choiceOfMethod.equals("B")) {
                    System.out.println("Выбран метод статистического анализа");
//                    fileAddressRequestforStats();
                    break;
                } else {
                    System.out.println("Ввели недопустимые значения");
                }
            } else if (question.equals("exit")) {
                break;
            } else {
                System.out.println("Ввели недопустимые значения");
            }
        }
        System.out.println("Ввели недопустимые значения");

//        Encoder encoder = new Encoder();
//       StringBuilder str = new StringBuilder("a");
//                StringBuilder normalText = encoder.readFile();
//                StringBuilder answerText = encoder.moveText(normalText);
//        encoder.textCryptoLoading(answerText);
//       StringBuilder cryptoText = encoder.readCryptoFile();
//       StringBuilder answerText2 = encoder.moveCryptoText(cryptoText);
//      encoder.textCryptoLoading(answerText2);

    }
}