public class Ride implements MoveStrategy{
    @Override
    public void move(int startX, int startY, int endX, int endY){
        System.out.println("Hero is riding from (" + startX + ","+startY+") to ("+endX+","+endY+")\n");
    }
}
