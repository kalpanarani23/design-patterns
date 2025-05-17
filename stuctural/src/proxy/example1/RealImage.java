package proxy.example1;

public class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromDisk();
    }

    private void loadFromDisk() {
        System.out.println("Loading image: " + filename);
        // Expensive operation - loads image from disk
    }

    @Override
    public void displayImage() {
        System.out.println("Displaying image: " + filename);
    }
}
