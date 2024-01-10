import java.util.Scanner;

public class Main {
    public static final String CORRECT_CHARS = "АаБбВвГгДдЕеЁёЖжЗзИиЙйКкЛлМмНнОоПпРрСсТтУуФфХхЦцЧчШшЩщЪъЫыЬьЭэЮюЯя -";
    public static void main(String[] args) {
        String userInput = getUserInput();
        fioCheck(userInput);

    }
    private static String getUserInput() {
        System.out.println("Введите ФИО: ");
        return new Scanner(System.in).nextLine().trim();
    }
    private static void fioCheck(String input) {
        boolean isValid = true;
        int spaceCount = 0;
        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == ' ') {
                spaceCount++;
            }
            if(!CORRECT_CHARS.contains(String.valueOf(input.charAt(i)))) {
                isValid = false;
                break;
            }
        }
        if(spaceCount == 2) {
            printResult(input);
        } else {
            System.out.println("Ввод ФИО некорректен!");
        }
    }
    private static void printResult(String input) {
        System.out.println("Фамилия: " + input.substring(0, input.indexOf(' ')).trim() +
                "\nИмя: " + input.substring(input.indexOf(' '), input.lastIndexOf(' ')).trim() +
                "\nОтчество: " + input.substring(input.lastIndexOf(' ')).trim());
    }
}