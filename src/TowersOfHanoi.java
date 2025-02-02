import java.util.Objects;
import java.util.Scanner;

public class TowersOfHanoi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rings = GameCreation.rings();
        int[][] arr = new int[rings][3];
        //заполнение массива

        for (int i = 0; i < rings; i++) {
            arr[i][0] = i + 1;
        }
        GameCreation.mode(arr, rings);
    }
}