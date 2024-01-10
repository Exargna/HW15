import java.util.Scanner;

public class Main {
    //Создаем строку с допустимыми символами
    public static final String CORRECT_CHARS = "АаБбВвГгДдЕеЁёЖжЗзИиЙйКкЛлМмНнОоПпРрСсТтУуФфХхЦцЧчШшЩщЪъЫыЬьЭэЮюЯя -";
    public static void main(String[] args) {
        //Обращаемся к методам
        String userInput = getUserInput();
        fioCheck(userInput);

    }
    //Метод ввода в консоль текста
    private static String getUserInput() {
        System.out.println("Введите ФИО: ");
        //Метод .trim удаляет пробелы в начале и в конце.
        return new Scanner(System.in).nextLine().trim();
    }
    //Метод проверки текста на соотвествие условиям
    private static void fioCheck(String input) {
        //Создаем булеан переменную, которая будет проводить валидацию текста
        boolean isValid = true;
        //Создаем флаг-переменную, которая будет в себе собирать количество пробелов
        int spaceCount = 0;
        //Создаем цикл от итератора до длины строки
        for (int i = 0; i < input.length(); i++) {
            //Условие, которое просчитывает количество пробелов
            if(input.charAt(i) == ' ') {
                spaceCount++;
            }
            //Проверка валидности текста
            if(!CORRECT_CHARS.contains(String.valueOf(input.charAt(i)))) {
                isValid = false;
                break;
            }
        }
        //Проверка условий и распечатка результата(обращение к методу)
        if(isValid && spaceCount == 2) {
            printResult(input);
        } else {
            System.out.println("Ввод ФИО некорректен!");
        }
    }
    //Метод распечатки текста
    private static void printResult(String input) {
        //Здесь .substring выделяет части текста с помощью индексов, от нуля до пробела и т.д
        System.out.println("Фамилия: " + input.substring(0, input.indexOf(' ')).trim() +
                "\nИмя: " + input.substring(input.indexOf(' '), input.lastIndexOf(' ')).trim() +
                "\nОтчество: " + input.substring(input.lastIndexOf(' ')).trim());
    }
}