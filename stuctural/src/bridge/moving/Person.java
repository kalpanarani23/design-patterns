package bridge.moving;

public class Person extends Animal{

    public Person(MovingLogic movingLogic) {
        super(movingLogic);
    }

    @Override
    void howDoIMove() {
        movingLogic.move();
    }


}
