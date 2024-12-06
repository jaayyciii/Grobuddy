/*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
FILENAME    : WebScrapper.java
DESCRIPTION : A class that utilizes webscrapping, iPrice PH for this application in particular, wherein it would look for
              a particular information by inspecting the elements of the website and return its String value. In detail, 
              the class should return the (1) product name and (2) price based from the first result of the site.
AUTHORS     : Justine Anne Loo, John Carlo Salinas, and Sharina Sodario
CREATED     : November 24, 2022
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-*/
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.IOException;

public class WebScrapper {
    private static final String SITE_PRODUCT = "https://iprice.ph/search/?term=";
    private static final String SITE_CATEGORY = "&category=";
    private String productQuery;
    private String productCategory;
    private String nameResult;
    private String priceResult;

    WebScrapper(String productQuery, String productCategory){
        this.productQuery = productQuery;
        this.productCategory = productCategory;
        
        Document scrape = site(SITE_PRODUCT+productQuery+SITE_CATEGORY+productCategory);
        
        Elements scrapedName = scrape.getElementById("pc0").getElementsByClass("u7");
        Elements scrapedPrice = scrape.getElementById("pc0").getElementsByClass("db");
        int priceIndex = scrapedPrice.size()-1;
    
        setNameResult(scrapedName.first().text());
        setPriceResult(scrapedPrice.get(priceIndex).text());
    }

    public Document site(String webAddress){
        Document scrape = null;

        try {
            scrape = Jsoup.connect(webAddress).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return scrape;
    }

    public void setProductQuery(String productQuery){
        this.productQuery = productQuery;
    }

    public void setProductCategory(String productCategory){
        this.productCategory = productCategory;
    }

    public void setNameResult(String result){
        this.nameResult = result;
    }

    public void setPriceResult(String result){
        this.priceResult = result;
    }

    public String getProductQuery(){
        return productQuery;
    }

    public String getProductCategory(){
        return productCategory;
    }

    public String getNameResult(){
        return nameResult;
    }

    public String getPriceResult(){
        return priceResult;
    }
}
