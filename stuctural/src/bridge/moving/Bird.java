package bridge.moving;

public class Bird extends Animal {

    public Bird(MovingLogic movingLogic) {
        super(movingLogic);
    }

    @Override
    void howDoIMove() {
        movingLogic.move();
    }
}
