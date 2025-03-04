import java.util.Random;
import java.util.Scanner;

public class GameCreation {


    // кол-во колец
    public static int rings() {
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
        return 0;

    }


    // вывод палок      printSticks(arr, num2);
    public static void printSticks(int[][] arr, int rings) {
        for (int i = 0; i < rings; i++) {
            for (int j = 0; j < 3; j++)
                if (arr[i][j] == 0) {
                    System.out.print("* ");
                } else
                    System.out.print(arr[i][j] + " ");
            System.out.println();
        }
    }


    //авто режим
    public static void modAuto(int[][] arr, int rings) {
        Random random = new Random();
        int randomNumber = random.nextInt(3);
        int rodIn = randomNumber + 1;
        int randomNumber2 = random.nextInt(3);
        int rodOut = randomNumber2 + 1;
        Rules.moves(arr,rodIn,rodOut,rings);
        System.out.println();
    }


    //ручной режим modManual(arr, num2);
    public static void modManual(int[][] arr, int rings) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите откуда и куда переместь");
        GameCreation.printSticks(arr, rings);
        System.out.println("Пример:");
        System.out.println("1 3");
        System.out.println("Где 1 = стержень откуда, а 3 = стержень куда");
        int rodIn = scanner.nextInt() ;
        int rodOut = scanner.nextInt() ;
        Rules.moves(arr,rodIn,rodOut,rings);
    }


    // выбор режима
    public static void mode(int[][] arr, int rings) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите режим ");
        System.out.println("Ручной или автоматический(1-ручной, 2-автоматический)");
        int num1 = scanner.nextInt();
        if (num1 == 1) {
            System.out.println("Выбран ручной режим");
            num1=0;
            while (Rules.win(arr, rings,num1)) {
                num1++;
                modManual(arr, rings);
            }
        } else if (num1 == 2) {
            System.out.println("Выбран автоматический режим");
            num1=0;
            while (Rules.win(arr, rings,num1)){
                num1++;
                modAuto(arr, rings);}
        } else {
            System.out.println("Выбран не тот режим ");
            mode(arr, rings);
        }
    }
}
