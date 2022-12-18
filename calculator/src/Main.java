import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String str = reader.readLine();
        System.out.println(calc(str));
    }

    public static String calc(String input) {
        String tenStr = "10";
        String plus = "+";
        String minus = "-";
        String multiply = "*";
        String division = "/";
        String sign;
        int i = 0;
        int firstNum;
        int secondNum;

        if (input.length() == 7) {
             if (input.substring(0, 2).equals(tenStr) && input.substring(5, 7).equals(tenStr)) {
                firstNum = Integer.parseInt(input.substring(0, 2));
                secondNum = Integer.parseInt(input.substring(5, 7));
                sign = input.substring(3, 4);

                if (sign.equals(plus)) {
                    i = firstNum + secondNum;
                } else if (sign.equals(minus)) {
                    i = firstNum - secondNum;
                } else if (sign.equals(multiply)) {
                    i = firstNum * secondNum;
                } else if (sign.equals(division)) {
                    i = firstNum / secondNum;
                }
            }
        } else if (input.length() == 6){
            if (input.substring(0, 2).equals(tenStr)) {
                firstNum = Integer.parseInt(input.substring(0, 2));
                secondNum = Integer.parseInt(input.substring(5, 6));
                sign = input.substring(3, 4);

                if (sign.equals(plus)) {
                    i = firstNum + secondNum;
                } else if (sign.equals(minus)) {
                    i = firstNum - secondNum;
                } else if (sign.equals(multiply)) {
                    i = firstNum * secondNum;
                } else if (sign.equals(division)) {
                    i = firstNum / secondNum;
                }
            } else if (input.substring(4, 6).equals(tenStr)) {
                firstNum = Integer.parseInt(input.substring(0, 1));
                secondNum = Integer.parseInt(input.substring(4, 6));
                sign = input.substring(2, 3);

                if (sign.equals(plus)) {
                    i = firstNum + secondNum;
                } else if (sign.equals(minus)) {
                    i = firstNum - secondNum;
                } else if (sign.equals(multiply)) {
                    i = firstNum * secondNum;
                } else if (sign.equals(division)) {
                    i = firstNum / secondNum;
                }
            }
        } else if (input.length() == 5) {
            firstNum = Integer.parseInt(input.substring(0, 1));
            secondNum = Integer.parseInt(input.substring(4, 5));
            sign = input.substring(2, 3);

            if (sign.equals(plus)) {
                i = firstNum + secondNum;
            } else if (sign.equals(minus)) {
                i = firstNum - secondNum;
            } else if (sign.equals(multiply)) {
                i = firstNum * secondNum;
            } else if (sign.equals(division)) {
                i = firstNum / secondNum;
            }
        }

        //1 + 1

        return Integer.toString(i);
    }

}