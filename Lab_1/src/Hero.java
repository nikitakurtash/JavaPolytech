public class Hero {
    private MoveStrategy moving;

    public void setMoving(MoveStrategy moving) {
        this.moving = moving;
    }
    public void startMoving(int startX, int startY, int endX, int endY){
        moving.move(startX, startY, endX, endY);
    }
}
