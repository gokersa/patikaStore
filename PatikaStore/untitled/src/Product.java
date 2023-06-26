public abstract class Product {
    private int id;
    private String productName;
    private Brand productBrand;
    private int price;
    private int storage;
    private int screen;
    private String colour;
    private int ram;
    private int discountRate;
    private int memory;

    public Product(int id, String productName, int price, int storage, int screen, String colour, int ram, Brand productBrand) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.storage = storage;
        this.screen = screen;
        this.colour = colour;
        this.ram = ram;
        this.productBrand = productBrand;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public int getScreen() {
        return screen;
    }

    public void setScreen(int screen) {
        this.screen = screen;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public abstract int getPower();

    public abstract void setPower(int power);

    public Brand getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(Brand productBrand) {
        this.productBrand = productBrand;
    }


}
