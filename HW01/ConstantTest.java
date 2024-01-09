import java.util.Scanner;
public class ConstantTest {

        public static void main(String[] args) {
            int num1 = 10;
            float num2 = 5.5f;
            System.out.println(num1);
            System.out.println(num2);

            double num3 = (num1*num2);
            System.out.println(num3);

            float cast1 = (float) num1;
            System.out.println(cast1);

            int cast2 = (int) num2;
            System.out.println(cast2);

            char char1 = 'A';
            System.out.println(char1);

            char1 = (char) (char1 + (97-65));
            System.out.println(char1);

        }
    
}