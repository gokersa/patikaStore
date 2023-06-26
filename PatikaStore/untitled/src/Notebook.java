public class Notebook extends Product {

    public Notebook(int id, String productName, int price, int storage, int screen, String colour, int ram, Brand productBrand) {
        super(id, productName, price, storage, screen, colour, ram, productBrand);
    }


    @Override
    public int getPower() {
        return 0;
    }

    @Override
    public void setPower(int power) {

    }
}
