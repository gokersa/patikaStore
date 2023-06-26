public class Phone extends Product{
    private int power;
    private int camera;
    public Phone(int id, String productName, int price, int storage, int screen, int power, String colour, int ram,int camera,Brand productBrand) {
        super(id, productName, price, storage, screen, colour, ram, productBrand);
        this.power = power;
        this.camera = camera;
    }

    @Override
    public int getPower() {
        return power;
    }

    @Override
    public void setPower(int power) {
        this.power = power;
    }

    public int getCamera() {
        return camera;
    }

    public void setCamera(int camera) {
        this.camera = camera;
    }
}
