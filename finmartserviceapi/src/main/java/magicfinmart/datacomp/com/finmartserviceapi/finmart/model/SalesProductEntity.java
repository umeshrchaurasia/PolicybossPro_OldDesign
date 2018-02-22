package magicfinmart.datacomp.com.finmartserviceapi.finmart.model;

public class SalesProductEntity {
    /**
     * Product_Id : 1
     * Product_Name : Health Insurance
     * Product_image : api.magicfinmart.com/images/salesmaterial/health.png
     * Count : 7
     */

    private int Product_Id;
    private String Product_Name;
    private String Product_image;
    private int Count;

    public int getProduct_Id() {
        return Product_Id;
    }

    public void setProduct_Id(int Product_Id) {
        this.Product_Id = Product_Id;
    }

    public String getProduct_Name() {
        return Product_Name;
    }

    public void setProduct_Name(String Product_Name) {
        this.Product_Name = Product_Name;
    }

    public String getProduct_image() {
        return Product_image;
    }

    public void setProduct_image(String Product_image) {
        this.Product_image = Product_image;
    }

    public int getCount() {
        return Count;
    }

    public void setCount(int Count) {
        this.Count = Count;
    }
}