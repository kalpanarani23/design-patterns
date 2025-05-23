package bridge.moving;

public abstract class Animal {
    MovingLogic movingLogic;

    public Animal(MovingLogic movingLogic) {
        this.movingLogic = movingLogic;
    }

    abstract void howDoIMove();

}
