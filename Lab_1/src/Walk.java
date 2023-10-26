public class Walk implements MoveStrategy{
    @Override
    public void move(int startX, int startY, int endX, int endY){
        System.out.println("Hero is walking from (" + startX + ","+startY+") to ("+endX+","+endY+")\n");
    }
}
