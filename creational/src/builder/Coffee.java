package builder;

public class Coffee {
    private Boolean sugar;
    private Boolean coco;
    private String coffeeType;
    private String capacity;
    private String beverages;
    private Boolean chocolatePowder;

    public Boolean getSugar() {
        return sugar;
    }

    public Boolean getCoco() {
        return coco;
    }

    public String getCoffeeType() {
        return coffeeType;
    }

    public String getCapacity() {
        return capacity;
    }

    public String getBeverages() {
        return beverages;
    }

    public Boolean getChocolatePowder() {
        return chocolatePowder;
    }

    public Coffee(CoffeeBuilder coffeeBuilder) {
        this.sugar = coffeeBuilder.sugar;
        this.coco = coffeeBuilder.coco;
        this.coffeeType = coffeeBuilder.coffeeType;
        this.capacity = coffeeBuilder.capacity;
        this.beverages = coffeeBuilder.beverages;
        this.chocolatePowder = coffeeBuilder.chocolatePowder;
    }

    public static class CoffeeBuilder {
        private Boolean sugar;
        private Boolean coco;
        private String coffeeType;
        private String capacity;
        private String beverages;
        private Boolean chocolatePowder;

        public CoffeeBuilder setSugar(Boolean sugar) {
            this.sugar = sugar;
            return this;
        }

        public CoffeeBuilder setCoco(Boolean coco) {
            this.coco = coco;
            return this;
        }

        public CoffeeBuilder setCoffeeType(String coffeeType) {
            this.coffeeType = coffeeType;
            return this;
        }

        public CoffeeBuilder setCapacity(String capacity) {
            this.capacity = capacity;
            return this;
        }

        public CoffeeBuilder setBeverages(String beverages) {
            this.beverages = beverages;
            return this;
        }

        public CoffeeBuilder setChocolatePowder(Boolean chocolatePowder) {
            this.chocolatePowder = chocolatePowder;
            return this;
        }

        public Coffee build() {
            return new Coffee(this);
        }
    }
}
