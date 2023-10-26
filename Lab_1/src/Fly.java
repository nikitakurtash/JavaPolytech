public class Fly implements MoveStrategy{
    @Override
    public void move(int startX, int startY, int endX, int endY) {
        System.out.println("Hero is flying from (" + startX + ","+startY+") to ("+endX+","+endY+")\n");
    }
}
