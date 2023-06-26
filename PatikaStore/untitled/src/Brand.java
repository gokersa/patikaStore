import java.util.ArrayList;
import java.util.List;

public class Brand implements Comparable<Brand> {
    private int id;
    private String name;

    public static List<Brand> Brands = new ArrayList<>();

    public Brand(int id, String name) {
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //markaları sıralamak için
    // isime göre sıralamak için
    @Override
    public int compareTo(Brand o1) {
        return this.getName().compareTo(o1.getName());
    }

}
