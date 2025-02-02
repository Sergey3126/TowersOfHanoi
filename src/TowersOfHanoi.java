import java.util.Objects;
import java.util.Scanner;

public class TowersOfHanoi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rings = rings();
        int[][] arr = new int[rings][3];
        //заполнение массива
        for (int i = 0; i < rings; i++) {
            arr[i][0] = i + 1;
        }
        mode(arr, rings);
    }


    // выбор режима
    private static void mode(int[][] arr, int rings) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите режим ");
        System.out.println("Ручной или автоматический(1-ручной, 2-автоматический)");
        int num1 = scanner.nextInt();
        if (num1 == 1) {
            System.out.println("Выбран ручной режим");
            num1 = 0;
            while (win(arr, rings)) {
                modManual(arr, rings, num1);
            }
            printSticks(arr, rings);
        } else if (num1 == 2) {
            System.out.println("Выбран автоматический режим");
            while (win(arr, rings))
                modAuto(arr);
        } else {
            System.out.println("Выбран не тот режим ");
            mode(arr, rings);
        }
    }


    //авто режим
    private static void modAuto(int[][] arr) {


    }


    //выйгрыш
    private static boolean win(int[][] arr, int rings) {
        for (int i = 0; i < rings; i++) {
            if (arr[0][2] == 0) {
                return true;
            } else {
                System.out.println("Победа");
                return false;
            }
        }
        return false;
    }


    //ручной режим modManual(arr, num2);
    private static void modManual(int[][] arr, int rings, int num1) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите откуда и куда переместь");
        printSticks(arr, rings);
        System.out.println("Пример:");
        System.out.println("1 3");
        System.out.println("Где 1 = стержень откуда, а 3 = стержень куда");
        int rodIn = scanner.nextInt() - 1;
        int rodOut = scanner.nextInt() - 1;
        int var = 0;
        int varI = 0;
        num1++;
        System.out.println("Количество ходов = " + num1);
        if (rodIn > 4 || rodOut > 4 || rodOut < 0 || rodIn < 0) {
            System.out.println("Неверный стержень");
            System.out.println("От 1 до 3 включительно");
            return;
        }
        if (arr[rings - 1][rodIn] == 0) {
            System.out.println("Пустой стержень");
            return;
        }
        for (int i = 0; i < rings; i++) {
            if (arr[i][rodIn] != 0) {
                var = arr[i][rodIn];
                varI = i;
                break;
            }
        }
        if (arr[rings - 1][rodOut] == 0) {
            arr[rings - 1][rodOut] = var;
            arr[varI][rodIn] = 0;
            return;
        }
        for (int i = 0; i < rings - 1; i++) {
            if (arr[rings - 2 - i][rodOut] == 0 && arr[rings - 1][rodOut] > var) {
                arr[rings - 2 - i][rodOut] = var;
                arr[varI][rodIn] = 0;
                return;
            }
        }
        for (int i = 0; i < rings - 1; i++) {
            if (arr[rings - 2 - i][rodOut] == 0 && arr[rings - 1][rodOut] < var) {
                System.out.println("Невозможно");
                return;
            }
        }
    }


    // кол-во колец
    private static int rings() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите количество колец");
        System.out.println("Минимум - 3, максимум - 8");
        int rings = scanner.nextInt();
        if (rings >= 3 && rings <= 8) {
            return rings;
        } else {
            System.out.println("Введено не верное количество колец");
            rings();
        }
        return 1;
    }


    // вывод палок      printSticks(arr, num2);
    private static void printSticks(int[][] arr, int rings) {
        for (int i = 0; i < rings; i++) {
            for (int j = 0; j < 3; j++)
                if (arr[i][j] == 0) {
                    System.out.print("* ");
                } else
                    System.out.print(arr[i][j] + " ");
            System.out.println();
        }
    }
}

