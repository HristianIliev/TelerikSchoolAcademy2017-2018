import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double X = in.nextDouble();
        double Y = in.nextDouble();

        if(X == 0 && Y == 0){
            System.out.println(0);
        } else if (X == 0 && Y != 0){
            System.out.println(5);
        } else if (X != 0 && Y == 0){
            System.out.println(6);
        } else if (X > 0 && Y > 0){
            System.out.println(1);
        } else if (X < 0 && Y > 0){
            System.out.println(2);
        } else if (X < 0 && Y < 0){
            System.out.println(3);
        } else if (X > 0 && Y < 0){
            System.out.println(4);
        }
    }
}
