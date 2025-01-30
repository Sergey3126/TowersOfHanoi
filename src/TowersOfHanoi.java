import java.util.Objects;
import java.util.Scanner;

public class TowersOfHanoi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num2 = rings();
        int[][] arr = new int[num2][3];
        //заполнение массива
        for (int i = 0; i < num2; i++) {
            arr[i][0] = i + 1;
        }
        mode(arr, num2);


    }


    // выбор режима
    private static void mode(int[][] arr, int num2) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите режим ");
        System.out.println("Ручной или автоматический(1-ручной, 2-автоматический)");
        int num1 = scanner.nextInt();
        if (num1 == 1) {
            System.out.println("Выбран ручной режим");
           while (win(arr, num2))
            modManual(arr, num2);
        } else if (num1 == 2) {
            System.out.println("Выбран автоматический режим");
            while (win(arr, num2))
            modAuto(arr);
        } else {
            System.out.println("Выбран не тот режим ");
            mode(arr, num2);
        }
    }

    //авто режим
    private static void modAuto(int[][] arr) {


    }


    //выйгрыш
    private static boolean win(int[][] arr,int num2){
        for (int i = 0; i < num2; i++) {
            if (arr[0][2]==0){
                return true;
            }else
                System.out.println("Победа");
                return false;
        }
        return false;
    }

    //ручной режим
    private static void modManual(int[][] arr, int num2) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите откуда и куда переместь");
        printSticks(arr, num2);
        System.out.println("Пример:");
        System.out.println("1 3");

        int num1 = scanner.nextInt() - 1;
        int num3 = scanner.nextInt() - 1;
        for (int i = 0; i < num2; i++) {
            if (arr[num2 - i - 1][num3] == 0) {
                for (int j = 0; j < num2; j++) {
                    if (arr[j][num1] != 0) {
                        arr[num2 - i - 1][num3] = arr[j][num1];
                        break;
                    }
                }
                break;
            }
        }
        for (int i = 0; i < num2; i++) {
            if (arr[i][num1] != 0) {
                arr[i][num1] = 0;
                break;
            }
        }
        printSticks(arr, num2);


    }


    // кол-во колец
    private static int rings() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите количество колец");
        System.out.println("Минимум - 3, максимум - 8");
        int num2 = scanner.nextInt();
        if (num2 >= 3 && num2 <= 8) {
            return num2;
        } else {
            System.out.println("Введено не верное количество колец");
            rings();
        }
        return 1;
    }

    // вывод палок
    private static void printSticks(int[][] arr, int num2) {
        for (int i = 0; i < num2; i++) {
            for (int j = 0; j < 3; j++)
                if (arr[i][j] == 0) {
                    System.out.print("* ");
                } else
                    System.out.print(arr[i][j] + " ");
            System.out.println();
        }
    }
}