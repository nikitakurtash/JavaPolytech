import java.util.Scanner;

public class StartGame {
    public static void main(String[] args) {
        int x1, y1, x2, y2, typeOfMoving;
        Hero hr = new Hero();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter begin point: ");
        x1 = sc.nextInt();
        y1 = sc.nextInt();

        System.out.println("\n Moving type category: \n 1 - Walking \n 2 - Riding \n 3 - Flying \n 0 - End program \n");

        System.out.println("Enter type of moving: ");
        typeOfMoving = sc.nextInt();
        while(true){
            if(typeOfMoving == 0){
                break;
            } else if (typeOfMoving>=1 && typeOfMoving<= 3) {
                hr.setMoving(getMove(typeOfMoving));
                System.out.println("Enter end point: ");
                int endX = sc.nextInt();
                int endY = sc.nextInt();
                hr.startMoving(x1, y1, endX, endY);
                x1 = endX;
                y1 = endY;
                System.out.println("Enter type of moving: ");
                typeOfMoving = sc.nextInt();

            }else{
                System.out.println("Enter number from 0 to 3 for chose type of moving: ");
                typeOfMoving = sc.nextInt();
            }
        }



    }

    private static MoveStrategy getMove(int typeOfMoving) {
        switch (typeOfMoving) {
            case 1:
                return new Walk();
            case 2:
                return new Ride();
            case 3:
                return new Fly();
            default:
                return null;
        }
    }
}
