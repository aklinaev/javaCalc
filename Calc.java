//public class Calc {
//}


import java.util.Scanner;

public class Calc {
    static int num1 = 0;
    static int num2 = 0;
    static int isRome = 0;
    static int isArabic = 0;
    static int sign = 0;

    public Calc() {
    }

    public static void intToRome(int input) {
        int des = -1;
        int eden = -1;
        des = input / 10;
        eden = input % 10;
        switch (des) {
            case 1:
                System.out.print("X");
                break;
            case 2:
                System.out.print("XX");
                break;
            case 3:
                System.out.print("XXX");
                break;
            case 4:
                System.out.print("XXXX");
                break;
            case 5:
                System.out.print("L");
                break;
            case 6:
                System.out.print("LX");
                break;
            case 7:
                System.out.print("LXX");
                break;
            case 8:
                System.out.print("LXXX");
                break;
            case 9:
                System.out.print("XC");
                break;
            case 10:
                System.out.print("C");
        }

        switch (eden) {
            case 1:
                System.out.print("I");
                break;
            case 2:
                System.out.print("II");
                break;
            case 3:
                System.out.print("III");
                break;
            case 4:
                System.out.print("IV");
                break;
            case 5:
                System.out.print("V");
        }

    }

    public static int sign(String input) throws MyExteptions {
        int num = -1;
        switch (input) {
            case "+":
                num = 1;
                break;
            case "-":
                num = 2;
                break;
            case "*":
                num = 3;
                break;
            case "/":
                num = 4;
        }

        if (num == -1) {
            throw new MyExteptions("//т.к. строка не является математической операцией");
        } else {
            return num;
        }
    }

    public static int numbers(String input) throws MyExteptions {
        int num = -1;
        switch (input) {
            case "1":
                isArabic = 1;
                num = 1;
                break;
            case "2":
                isArabic = 1;
                num = 2;
                break;
            case "3":
                isArabic = 1;
                num = 3;
                break;
            case "4":
                isArabic = 1;
                num = 4;
                break;
            case "5":
                isArabic = 1;
                num = 5;
                break;
            case "6":
                isArabic = 1;
                num = 6;
                break;
            case "7":
                isArabic = 1;
                num = 7;
                break;
            case "8":
                isArabic = 1;
                num = 8;
                break;
            case "9":
                isArabic = 1;
                num = 9;
                break;
            case "10":
                isArabic = 1;
                num = 10;
                break;
            case "I":
                num = 1;
                isRome = 1;
                break;
            case "II":
                num = 2;
                isRome = 1;
                break;
            case "III":
                num = 3;
                isRome = 1;
                break;
            case "IV":
                num = 4;
                isRome = 1;
                break;
            case "V":
                num = 5;
                isRome = 1;
                break;
            case "VI":
                num = 6;
                isRome = 1;
                break;
            case "VII":
                num = 7;
                isRome = 1;
                break;
            case "VIII":
                num = 8;
                isRome = 1;
                break;
            case "IX":
                num = 9;
                isRome = 1;
                break;
            case "X":
                num = 10;
                isRome = 1;
                break;
            case "+":
                num = 1;
                break;
            case "-":
                num = 2;
                break;
            case "*":
                num = 3;
                break;
            case "/":
                num = 4;
        }

        if (num == -1) {
            throw new MyExteptions("Похоже что вы ввели число болше 10, а так нельзя, запустите калькулятор заново.");
        } else {
            return num;
        }
    }

    public static String[] calc(String input) throws MyExteptions {
        int result = 0;
        String[] terms = input.split("[ ]");
        if (terms.length <= 2) {
            throw new MyExteptions("//т.к. строка не является математической операцией");
        } else if (terms.length >= 4) {
            throw new MyExteptions("//т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        } else {
            num1 = numbers(terms[0]);
            num2 = numbers(terms[2]);
            sign = sign(terms[1]);
            if (isRome == isArabic) {
                throw new MyExteptions("//т.к. используются одновременно разные системы счисления");
            } else {
                if (sign == 1) {
                    result = num1 + num2;
                } else if (sign == 2) {
                    result = num1 - num2;
                } else if (sign == 3) {
                    result = num1 * num2;
                } else if (sign == 4) {
                    result = num1 / num2;
                }

                if (isRome == 1) {
                    if (result < 1)
                        throw new MyExteptions("//т.к. для римских чисел результат не может быть равен 0, или быть отрицательным.");
                    intToRome(result);
                } else {
                    System.out.println(result);
                }

                return new String[]{input};
            }
        }
    }

    public static void main(String[] args) throws MyExteptions {
        Scanner str1 = new Scanner(System.in);
        System.out.println("Введите выражение в одну строку и нажмите Enter:");
        String inStr = str1.nextLine();
        calc(inStr);
    }
}
