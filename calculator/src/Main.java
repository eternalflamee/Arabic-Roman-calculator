import java.util.Scanner;

public class Main {
    private static int number1;
    private static int number2;
    private static char operation;
    private static boolean romanStr1 = false;
    private static boolean romanStr2 = false;

    public static void main(String[] args) throws CalculatorException {

        read();
        int resultArabic = calculate(number1, number2, operation);
        String resultRoman;

        if ((romanStr1 && romanStr2)) {
            resultRoman = numberToRoman(resultArabic);
            System.out.println(resultRoman);
        } else {
            System.out.println(resultArabic);
        }

    }

    public static void read() throws CalculatorException {

        String[] roman = {"X", "IX", "VIII", "VII", "VI", "V", "IV", "III", "II", "I"};

        System.out.println("Калькулятор умеет выполнять операции сложения, вычитания, умножения и деления с двумя числами: a+b, a-b, a*b, a/b. Введите эти числа и нажмите enter: ");
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        String[] numStr = text.split("[+-/*]");

        if (numStr.length > 2) {
            throw new CalculatorException("Используйте только два числа");
        }



        for (String s : roman) {
            if (s.equals(numStr[0])) {
                romanStr1 = true;
                break;
            }
        }
        for (String s : roman) {
            if (s.equals(numStr[1])) {
                romanStr2 = true;
                break;
            }
        }

        if (romanStr1 && romanStr2) {
            number1 = romanToNumber(numStr[0]);
            number2 = romanToNumber(numStr[1]);
        } else if (romanStr1 || romanStr2){
            throw new CalculatorException("Введенные числа имеют разные системы счисления");
        } else {
            number1 = Integer.parseInt(numStr[0]);
            number2 = Integer.parseInt(numStr[1]);
        }
        operation = text.charAt(numStr[0].length());

        if ((number1 > 10 || number1 < 0) || (number2 > 10 || number2 < 0)) {
            throw new CalculatorException("Введеные числа меньше 0 или больше 10");
        }

    }

    public static int romanToNumber(String roman) throws CalculatorException {
        return switch (roman) {
            case "I" -> 1;
            case "II" -> 2;
            case "III" -> 3;
            case "IV" -> 4;
            case "V" -> 5;
            case "VI" -> 6;
            case "VII" -> 7;
            case "VIII" -> 8;
            case "IX" -> 9;
            case "X" -> 10;
            default -> throw new CalculatorException("Введено римское число больше 10");
        };
    }

    public static String numberToRoman (int numArabian) throws CalculatorException {
        if (numArabian < 0) {
            throw new CalculatorException("В римской системе счисления нет нулей");
        }
        String[] roman = {"string4accuracy", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        return roman[numArabian];
    }

    public static int calculate (int number1, int number2, char operation) throws CalculatorException {
        return switch (operation) {
            case '+' -> number1 + number2;
            case '-' -> number1 - number2;
            case '*' -> number1 * number2;
            case '/' -> number1 / number2;
            default -> throw new CalculatorException("Неверный знак операции");
        };
    }

}