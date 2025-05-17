package lowleveldesign.src.structural.proxy.example1;

public class ImageProxy implements Image {
    RealImage realImage;
    private String fileName;

    public ImageProxy(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void displayImage() {
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.displayImage();
    }
}
