package bridge.moving;

public class Main {
    public static void main(String[] args) {
        MovingLogic movingLogicWalk = new Walk();
        MovingLogic movingLogicFly = new Fly();

        Animal person1 = new Person(movingLogicWalk);
        Animal person2= new Bird(movingLogicFly);

        person1.howDoIMove();
        person2.howDoIMove();

    }
}
