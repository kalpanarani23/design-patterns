package builder;

public class Phoneb {
    private String camera;
    private String ram;
    private String processor;
    private String cpu;
    private String battry;
    private String networkType;
    private Boolean jack;

    public String getCamera() {
        return camera;
    }

    public String getRam() {
        return ram;
    }

    public String getProcessor() {
        return processor;
    }

    public String getCpu() {
        return cpu;
    }

    public String getBattry() {
        return battry;
    }

    public String getNetworkType() {
        return networkType;
    }

    public Boolean getJack() {
        return jack;
    }

    private Phoneb(PhoneBuilder phoneBuilder) {
        this.camera = phoneBuilder.camera;
        this.battry = phoneBuilder.battry;
        this.cpu = phoneBuilder.cpu;
        this.jack = phoneBuilder.jack;
        this.processor = phoneBuilder.processor;
        this.networkType = phoneBuilder.networkType;
        this.ram = phoneBuilder.ram;
    }

    public static class PhoneBuilder {
        private String camera;
        private String ram;
        private String processor;
        private String cpu;
        private String battry;
        private String networkType;
        private Boolean jack;

        public PhoneBuilder setBattry(String battry) {
            this.battry = battry;
            return this;
        }

        public PhoneBuilder setCpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public PhoneBuilder setProcessor(String processor) {
            this.processor = processor;
            return this;
        }

        public PhoneBuilder setRam(String ram) {
            this.ram = ram;
            return this;
        }

        public PhoneBuilder setCamera(String camera) {
            this.camera = camera;
            return this;
        }

        public PhoneBuilder setNetworkType(String networkType) {
            this.networkType = networkType;
            return this;
        }

        public PhoneBuilder setJack(Boolean jack) {
            this.jack = jack;
            return this;
        }

        public Phoneb build() {
            return new Phoneb(this);
        }
    }
}
