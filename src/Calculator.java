import java.util.Scanner;
public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
            System.out.print("Вводи цифры, приятель\n");
            String input = scanner.nextLine();

            try {
                String rezultat = vychislenya(input);
                System.out.println("Твой ответ " + rezultat);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
    }
    public static String vychislenya(String input) throws IllegalArgumentException {
        String[] massiv = input.split(" ");
        if (massiv.length != 3) {
            throw new IllegalArgumentException("Введи только два числа (либо раздели знаки пробелами))");
        }
        int a;
        int b;
        try {
            a = Integer.parseInt(massiv[0]);
            b = Integer.parseInt(massiv[2]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Не удалось превратить символы в числа!!");
        }
        if (a < 1 || a > 10 || b < 1 || b > 10) {
            throw new IllegalArgumentException("Я работаю только с числами от 1 до 10 включительно!!");
        }
        char znak = massiv[1].charAt(0);
        int operaciya;
        switch (znak) {
            case '+':
                operaciya = a + b;
                break;
            case '-':
                operaciya = a - b;
                break;
            case '*':
                operaciya = a * b;
                break;
            case '/':
                operaciya = a / b;
                break;
            default:
                throw new IllegalArgumentException("Неподдерживаемая операция");
        }
        return Integer.toString(operaciya);
    }
}