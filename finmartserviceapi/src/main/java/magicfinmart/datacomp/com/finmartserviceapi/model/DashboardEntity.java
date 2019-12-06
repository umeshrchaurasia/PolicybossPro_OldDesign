package magicfinmart.datacomp.com.finmartserviceapi.model;

import io.realm.RealmObject;

/**
 * Created by Rajeev Ranjan on 04/01/2018.
 */

public class DashboardEntity extends RealmObject {
    private String type;
    private int productId;
    private String productName;
    private String productDetails;
    private String link;
    private String serverIcon;

    private String Id;
    private String Kname;
    private String ETitle;
    private String HTitle;
    private String MTitle;
    private String GTitle;

    private String EDesc;
    private String HDesc;
    private String MDesc;
    private String GDesc;


    public DashboardEntity(String type, int productId, String productName, String productDetails, int icon) {
        this.type = type;
        this.productId = productId;
        this.productName = productName;
        this.productDetails = productDetails;
        this.icon = icon;     this.Kname = Kname;
    }

    public DashboardEntity(String type, int productId, String productName, String productDetails, int icon,String Kname,String ETitle,
                           String HTitle, String MTitle, String GTitle ,String EDesc ,String HDesc,String MDesc, String GDesc) {
        this.type = type;
        this.productId = productId;
        this.productName = productName;
        this.productDetails = productDetails;
        this.icon = icon;

        this.Kname = Kname;
        this.ETitle = ETitle;
        this.MTitle = MTitle;
        this.GTitle = GTitle;
        this.HTitle = HTitle;
        this.EDesc = EDesc;
        this.HDesc = HDesc;
        this.MDesc = MDesc;
        this.GDesc = GDesc;

    }
    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getKname() {
        return Kname;
    }

    public void setKname(String kname) {
        Kname = kname;
    }

    public String getETitle() {
        return ETitle;
    }

    public void setETitle(String ETitle) {
        this.ETitle = ETitle;
    }

    public String getHTitle() {
        return HTitle;
    }

    public void setHTitle(String HTitle) {
        this.HTitle = HTitle;
    }

    public String getMTitle() {
        return MTitle;
    }

    public void setMTitle(String MTitle) {
        this.MTitle = MTitle;
    }

    public String getGTitle() {
        return GTitle;
    }

    public void setGTitle(String GTitle) {
        this.GTitle = GTitle;
    }

    public String getEDesc() {
        return EDesc;
    }

    public void setEDesc(String EDesc) {
        this.EDesc = EDesc;
    }

    public String getHDesc() {
        return HDesc;
    }

    public void setHDesc(String HDesc) {
        this.HDesc = HDesc;
    }

    public String getMDesc() {
        return MDesc;
    }

    public void setMDesc(String MDesc) {
        this.MDesc = MDesc;
    }

    public String getGDesc() {
        return GDesc;
    }

    public void setGDesc(String GDesc) {
        this.GDesc = GDesc;
    }


    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getServerIcon() {
        return serverIcon;
    }

    public void setServerIcon(String serverIcon) {
        this.serverIcon = serverIcon;
    }


    public DashboardEntity() {
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(String productDetails) {
        this.productDetails = productDetails;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    private int icon;
}
