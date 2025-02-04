import java.util.Scanner;

public class Rules {
    //Ходы moves(arr, num1,rodIn,rodOut,rings);
   public static void moves(int[][] arr, int rodIn, int rodOut,int rings){
        GameCreation.printSticks(arr, rings);
        rodOut=rodOut-1;
        rodIn=rodIn-1;
        int var = 0;
        int varI = 0;
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
            if (arr[rings - 2 - i][rodOut] == 0 && arr[rings - 1][rodOut] < var||rodOut==rodIn) {
                System.out.println("Невозможно");
                return;
            }
        }
    }


    //выйгрыш
    public static boolean win(int[][] arr, int rings, int num1) {
        int num2 = 1;
        int num3 = 0;
       for (int i = 0; i <rings; i++) {
            if (arr[i][2] == num2) {
                num3++;
            }
           num2++;
        }
            if (num3==rings){
                GameCreation.printSticks(arr, rings);
                System.out.println("Победа");
                System.out.println("Количество ходов = "+num1);
                return false;
            }
        return true;
    }




}
