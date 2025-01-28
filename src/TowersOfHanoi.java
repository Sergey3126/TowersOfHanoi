import java.util.Scanner;

public class TowersOfHanoi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        System.out.println("Выберите режим ");
//        System.out.println("Ручной или автоматический(1-ручной, 2-автоматический)");
//        int num1=scanner.nextInt();
//        if (num1==1){
//            System.out.println("Выбран ручной режим");
//
//        } else if (num1==2){
//            System.out.println("Выбран автоматический режим");
//
//        }else {
//            System.out.println("Выбран не тот режим ");
//
//        }
//        System.out.println("Выберите количество колец");
//        System.out.println("Минимум - 3, максимум - 8");
//        int num2 = scanner.nextInt();
//        if (num2>=3 && num2<=8){
//
//        }else {
//            System.out.println("Введено не верное количество колец");
//
//        }
        int num1;
        int num2 = 3;
        int[][] arr = new int[num2][3];
        //заполнение массива
        for (int i = 0; i < num2; i++) {
            arr[i][0] = i + 1;
        }
      printSticks(arr,num2);
        System.out.println("Выберите откуда взять кольцо");
        num1 = scanner.nextInt();
        System.out.println("Куда переместить");
        int num3 = scanner.nextInt();
        printSticks(arr,num2);


        }










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
