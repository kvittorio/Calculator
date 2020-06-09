package Calculator;

import java.util.Scanner;

public class Calculator {
    private static boolean arabic = true;
    private static String[] numCrunch(String line) {
        String[] romNum = line.split(" ");
        if (romNum.length != 3) {
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Вводите с пробелами");
            line = scanner1.nextLine();
            return numCrunch(line);
        } else {
            return romNum;
        }
    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String line = scanner.nextLine();
        while (!line.isEmpty()) {
            String[] romNum = Calculator.numCrunch(line);
            String operation = romNum[1];
            Number result;
            int num1 = 0;
            int num2 = 0;
            // Переводим в int. Если введены римские, выкинет исключение
            try {
                num1 = Integer.parseInt(romNum[0]);
                num2 = Integer.parseInt(romNum[2]);
                //result = new Arabic(num1, num2, 0);
            } catch (NumberFormatException e) {
                arabic = false;

                //result = new Roman (romNum[0], romNum[2], 0);
            }

            if (arabic) {
                result = new Arabic(num1, num2);
            } else {
                result = new Roman(romNum[0], romNum[2]);
            }

            switch (operation) {
                case "+":
                    result.add();
                    break;
                case "-":
                    result.sub();
                    break;
                case "/":
                case ":":
                    result.div();
                    break;
                case "*":
                case "x":
                    result.mul();
                    break;
            }

            if (arabic) {
                System.out.println("Ответ: " + result.getAnswer());
            } else {
                System.out.println("Ответ: " + result.getRomanAnswer());
            }
            System.out.println();
            System.out.print("Введите следующее выражение: ");
            line = scanner.nextLine();
        }
        System.out.println("Вы вышли из калькулятора");

    }
}
