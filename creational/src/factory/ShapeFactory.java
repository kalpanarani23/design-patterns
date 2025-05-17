package factory;

public class ShapeFactory {

    public Shape createShape(String type) {
        switch (type){
            case "circle" : return new Circle();
            case "rectangle" : return new Rectangle();
            default:
                System.out.println("Not a shape");
        }
        return null;
    }
}
