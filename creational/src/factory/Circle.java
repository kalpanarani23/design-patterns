package factory;

public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("draw circle");
    }

    @Override
    public void erase() {
        System.out.println("erase circle");
    }

//    only for static factory pattern
    public static Circle doGetCircle(){
        System.out.println("static method do get circle");
        return new Circle();
    }
}
