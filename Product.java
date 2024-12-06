/*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
FILENAME    : Product.java
DESCRIPTION : A class that stores the actual product name and price based from user-input. This then instantiates a 
              WebScrapper class that performs web scrapping with methods that returns the information obtained and
              further stores such into this class. Moreover, it also contains methods accessible for the App Class.
AUTHORS     : Justine Anne Loo, John Carlo Salinas, and Sharina Sodario
CREATED     : November 24, 2022
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-*/
public class Product {
    private final String[] productCategory = {"groceries", "appliances", "clothing", "stationery", "medical-supplies"};
    private String productName;
    private String category;
    private String name;
    private String price;
    private String minPrice;
    private String maxPrice;

    Product(){
        this(0, "NULL");
    }

    Product(int category, String productName){
        this.productName = productName;
        this.category = productCategory[category];
        WebScrapper product = new WebScrapper(this.productName, this.category);

        this.name = product.getNameResult();
        this.price = product.getPriceResult();
        separateMinMaxPrice();
    }

    public void setProductName(String productName){
        this.productName = productName;
    }

    public void setCategory(int category){
        this.category = productCategory[category];
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPrice(String price){
        this.price = price;
    }

    public void setMinPrice(String minPrice){
        this.minPrice = minPrice;
    }

    public void setMaxPrice(String maxPrice){
        this.maxPrice = maxPrice;
    }

    public void separateMinMaxPrice() {
        String temp = (this.price).replaceAll("[₱,\\s]", "");

        if (temp.contains("-")){
            String[] split = temp.split("-");
            this.minPrice = split[0];
            this.maxPrice = split[1];

        } else {
            this.minPrice = temp;
            this.maxPrice = temp;
        }
    }

    public String getProductName(){
        return productName;
    }

    public String getCategory(){
        return category;
    }

    public String getName(){
        return name;
    }

    public String getPrice() {
        return price.replaceFirst("₱ ","Php ");
    }

    public String getMinPrice(){
        return minPrice;
    }

    public String getMaxPrice(){
        return maxPrice;
    }
}