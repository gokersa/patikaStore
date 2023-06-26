import java.util.*;
import java.util.logging.Filter;

public class StoreBoard {
    private LinkedList <Brand> brandList = new LinkedList<>();
    private ArrayList<Product> phoneList = new ArrayList<>();
    private ArrayList<Product> notebookList = new ArrayList<>();

    Scanner input = new Scanner(System.in);

    public StoreBoard() {
        Brand samsung = new Brand(1,"Samsung");
        Brand apple = new Brand(2,"Apple");
        Brand xiaomi = new Brand(3,"Xiaomi");
        Brand lenovo = new Brand(4,"Lenovo");
        Brand huawei = new Brand(5,"Huawei");
        Brand asus = new Brand(6,"Asus");
        Brand hp = new Brand(7,"HP");
        Brand casper = new Brand(8,"Casper");
        Brand monster = new Brand(9,"Monster");

        brandList.addAll(List.of(new Brand[]{samsung,apple,xiaomi,lenovo, huawei, asus, hp, casper, monster}));

        Phone galaxyA51 = new Phone(1,"SAMSUNG GALAXY A51", 3199,128,65,4000,"Siyah",6,32,brandList.get(1));
        Phone iphone11 = new Phone(2,"Iphone 11 64 GB",7379,64,61,3046,"Mavi",6,5,brandList.get(2));
        Phone redMi = new Phone(3,"Redmi Note 10 Pro 8GB", 4012, 128,65,4000,"Beyaz",6,32,brandList.get(3));

        phoneList.addAll(List.of(new Phone[] {galaxyA51,iphone11,redMi}));

        Notebook matebook = new Notebook(1,"HUAWEI Matebook 14 ", 7000, 512,14,"Siyah", 6,brandList.get(5));
        Notebook lenovo14 = new Notebook(2,"LENOVO V14 IGL ", 3699,1024,14,"Mavi", 6, brandList.get(4));
        Notebook asustuf = new Notebook(3,"ASUS Tuf Gaming",8199,2048,15,"Beyaz", 6, brandList.get(5));

        notebookList.addAll(List.of((new Notebook[]{matebook,lenovo14,asustuf})));
        this.menu();
    }

    public void list() {
        brandList.sort(new listBrands());
        Iterator<Brand> it  = this.brandList.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().getName());
        }
    }

    public void menu() {
        System.out.println("Patika Store Yönetim Paneli");
        System.out.println("===========================");
        System.out.println("1 - Notebook işlemleri \n" +
                "2 - Cep telefonu işlemleri \n" + "3 - Marka Listeleme \n" + "4 - Markaya göre filtrele \n" + "0 - Çıkış  \n " +  "Lütfen Seçiniz" );
        int inp = input.nextInt();
        switch (inp) {
            case 1 :
                System.out.println(" Notebook işlemleri : ");
                this.devicesMenu(notebookList);
                break;
            case 2 :
                System.out.println(" Cep telefonu işlemleri : ");
                this.devicesMenu(phoneList);
                break;
            case 3 :
                System.out.println(" Marka Listesi :  ");
                this.list();
                break;
            case 4 :
                System.out.println(" Markaya göre filtrele ");
                this.chooseBrand();
            case 0 :
                System.out.println(" Hoşçakalın ");
                break;

        }
    }

    public void devicesMenu(ArrayList<Product> productArrayList) {
        System.out.println("1 - Ürünleri listele \n" +
                           "2 - Ürün ekle \n" +
                           "3 - Ürün çıkar \n" +
                           "4 - Listele \n" +
                           "0 - Geri dön");
        int menuChoose = input.nextInt();
        switch (menuChoose) {
            case 1 :
                this.listingProducts(productArrayList);
                break;
            case 2 :
                this.addProduct(productArrayList);
                break;
            case 3 :
                this.removeProduct(productArrayList);
                break;
            case 4 :
                this.sortingProducts(productArrayList);
                break;
            case 0 :
                menu();
                break;
        }
    }

    public void listingProducts(ArrayList<Product> products) {
        System.out.println("| ID |    Ürün Adı    |    Fiyat    |    Marka    |    Depolama    |    Ekran    |    Ram   |");
        System.out.println("---------------------------------------------------------------------------------------------");
        for (Product p:products) {
            System.out.println(" | " + p.getId() + " | " + p.getProductName() + " | " + p.getPrice() + " TL " + " | " + p.getProductBrand() + " | " + p.getStorage() + " | " + p.getScreen() + " | " + p.getRam());
        }
    }

    public void addProduct (ArrayList<Product> productArrayList) {
        System.out.println(" Ürün ekle ");
        int productId = productArrayList.get(productArrayList.size()-1).getId()+1;
        System.out.println(" Ürün fiyatı ne kadar?");
        int productPrice = input.nextInt();
        System.out.println(" Ürün indirim oranı nedir?");
        int productDiscount = input.nextInt();
        System.out.println(" Ürün depolama alanı ne kadar ? ");
        int productStorage = input.nextInt();
        System.out.println(" Ürün adı nedir ? ");
        String productName = input.nextLine();
        Brand productBrand = chooseBrand();
        System.out.println(" Ürün hafızası ne kadardır ? ");
        int productMemory = input.nextInt();
        System.out.println(" Ürün ekran genişliği nedir ? ");
        int productScreensize = input.nextInt();
        System.out.println(" Ürün ram'i nedir ? ");
        int productRam = input.nextInt();
        System.out.println(" Ürün rengi nedir ? ");
        String productColour = input.nextLine();
        System.out.println(" Ürün kamerası kaç MP'dir ? ");
        int productCamera = input.nextInt();
        if (productArrayList == phoneList) {
            System.out.println(" Ürün gücü nedir ? ");
            int productPower = input.nextInt();
            productArrayList.add(new Phone(productId,productName,productPrice,productStorage,productScreensize,productPower,productColour,productRam,productCamera,productBrand));
            System.out.println(" Ürün eklendi");
        } else {
            productArrayList.add(new Notebook(productId,productName,productPrice,productStorage,productScreensize,productColour,productRam,productBrand));
        }
        devicesMenu(productArrayList);
    }

    public void removeProduct (ArrayList<Product> productArrayList) {
        listingProducts(productArrayList);
        System.out.println("Silmek istediğiniz ürünün id'sini giriniz");
        int removeChooser = input.nextInt();
        try {
            if(productArrayList.size()<1) {
               System.out.println("Listede hiç ürün yok");
            } else {
                for (Product product : productArrayList) {
                    if (product.getId() == removeChooser) {
                        productArrayList.remove(product);
                        System.out.println("Ürün listeden çıkarıldı");
                    }
                }
            }
        } catch (Exception e) {

        }
        devicesMenu(productArrayList);
    }

    public  Brand chooseBrand() {
        for (Brand b: brandList) {
            System.out.println(b.getId() + " - " + b.getName());
        }
        System.out.println("Ürününüzün markasını seçiniz!");
        int brandch = input.nextInt();
        return this.brandList.get(brandch-1);
    }

    public void brandfilter() {
        Brand choosebrand = this.chooseBrand();
        ArrayList<Product> FilterBrandProducts = new ArrayList<>();
        for (Product p : phoneList) {
            if (p.getProductBrand() == choosebrand) {
                FilterBrandProducts.add(p);
            }
        }
        for (Product p: notebookList) {
            if(p.getProductBrand() == choosebrand) {
                FilterBrandProducts.add(p);
            }
        }
        listingProducts(FilterBrandProducts);
        menu();
    }

    public void sortingProducts (ArrayList<Product> productArrayList) {
        System.out.println(" Filterleme seçenekleri : \n " +
                " 1 - A-Z \n " +
                " 2 - Z-A + \n" +
                " 3 - Düşük - Yüksek Fiyat \n " +
                " 4 - Yüksek - Düşük Fiyat \n"
        );
        int chooseSort = input.nextInt();
        switch (chooseSort) {
            case 1 :
                productArrayList.sort(new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        return o1.getProductName().compareTo(o2.getProductName());
                    }
                });
                listingProducts(productArrayList);
                break;
            case 2 :
                productArrayList.sort(new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        return o1.getProductName().compareTo(o2.getProductName());
                    }
                }.reversed());
                listingProducts(productArrayList);
                break;
            case 3 :
                productArrayList.sort(new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        return o1.getPrice()-o2.getPrice();
                    }
                });
                listingProducts(productArrayList);
                break;
            case 4 :
                productArrayList.sort(new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        return o1.getPrice()-o2.getPrice();
                    }
                }.reversed());
                listingProducts(productArrayList);
                break;
        }
    }

}
