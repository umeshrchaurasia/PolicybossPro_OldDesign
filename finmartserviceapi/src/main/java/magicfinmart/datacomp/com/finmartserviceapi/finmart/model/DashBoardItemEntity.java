package magicfinmart.datacomp.com.finmartserviceapi.finmart.model;

import android.os.Parcel;
import android.os.Parcelable;

public class DashBoardItemEntity implements Parcelable {

    /**
     * menuid : 6
     * menuname : Dashboard 1
     * link : https://bo.magicfinmart.com
     * iconimage : https://bo.magicfinmart.com
     * isActive : 1
     * description : Dashboard 1
     * type : 2
     */

    private int menuid;
    private String menuname;
    private String link;

    private String iconimage;
    private int isActive;
    private String description;

    private int type;
    private int dashboard_type;
    private String sequence;
    private int ProdId;
    private String ProductNameFontColor;
    private String ProductDetailsFontColor;
    private String ProductBackgroundColor;

    private String IsExclusive;
    private String IsNewprdClickable;
    private String IsSharable;
    private String popupmsg;
    private String title;


    private String info;


    protected DashBoardItemEntity(Parcel in) {
        menuid = in.readInt();
        menuname = in.readString();
        link = in.readString();
        iconimage = in.readString();
        isActive = in.readInt();
        description = in.readString();
        type = in.readInt();
        dashboard_type = in.readInt();
        sequence = in.readString();
        ProdId = in.readInt();
        ProductNameFontColor = in.readString();
        ProductDetailsFontColor = in.readString();
        ProductBackgroundColor = in.readString();
        IsExclusive = in.readString();
        IsNewprdClickable = in.readString();
        IsSharable = in.readString();
        popupmsg = in.readString();
        title = in.readString();
        info = in.readString();
    }

    public static final Creator<DashBoardItemEntity> CREATOR = new Creator<DashBoardItemEntity>() {
        @Override
        public DashBoardItemEntity createFromParcel(Parcel in) {
            return new DashBoardItemEntity(in);
        }

        @Override
        public DashBoardItemEntity[] newArray(int size) {
            return new DashBoardItemEntity[size];
        }
    };

    public int getMenuid() {
        return menuid;
    }

    public void setMenuid(int menuid) {
        this.menuid = menuid;
    }

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getIconimage() {
        return iconimage;
    }

    public void setIconimage(String iconimage) {
        this.iconimage = iconimage;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getDashboard_type() {
        return dashboard_type;
    }

    public void setDashboard_type(int dashboard_type) {
        this.dashboard_type = dashboard_type;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public int getProdId() {
        return ProdId;
    }

    public void setProdId(int prodId) {
        ProdId = prodId;
    }

    public String getProductNameFontColor() {
        return ProductNameFontColor;
    }

    public void setProductNameFontColor(String productNameFontColor) {
        ProductNameFontColor = productNameFontColor;
    }

    public String getProductDetailsFontColor() {
        return ProductDetailsFontColor;
    }

    public void setProductDetailsFontColor(String productDetailsFontColor) {
        ProductDetailsFontColor = productDetailsFontColor;
    }

    public String getProductBackgroundColor() {
        return ProductBackgroundColor;
    }

    public void setProductBackgroundColor(String productBackgroundColor) {
        ProductBackgroundColor = productBackgroundColor;
    }

    public String getIsExclusive() {
        return IsExclusive;
    }

    public void setIsExclusive(String isExclusive) {
        IsExclusive = isExclusive;
    }

    public String getIsNewprdClickable() {
        return IsNewprdClickable;
    }

    public void setIsNewprdClickable(String isNewprdClickable) {
        IsNewprdClickable = isNewprdClickable;
    }

    public String getIsSharable() {
        return IsSharable;
    }

    public void setIsSharable(String isSharable) {
        IsSharable = isSharable;
    }

    public String getPopupmsg() {
        return popupmsg;
    }

    public void setPopupmsg(String popupmsg) {
        this.popupmsg = popupmsg;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(menuid);
        dest.writeString(menuname);
        dest.writeString(link);
        dest.writeString(iconimage);
        dest.writeInt(isActive);
        dest.writeString(description);
        dest.writeInt(type);
        dest.writeInt(dashboard_type);
        dest.writeString(sequence);
        dest.writeInt(ProdId);
        dest.writeString(ProductNameFontColor);
        dest.writeString(ProductDetailsFontColor);
        dest.writeString(ProductBackgroundColor);
        dest.writeString(IsExclusive);
        dest.writeString(IsNewprdClickable);
        dest.writeString(IsSharable);
        dest.writeString(popupmsg);
        dest.writeString(title);
        dest.writeString(info);
    }
}