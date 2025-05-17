package proxy.example1;


public class Main {
    public static void main(String[] args) {
        Image image1 = new ImageProxy("photo1.jpg");
        image1.displayImage();
    }
}
