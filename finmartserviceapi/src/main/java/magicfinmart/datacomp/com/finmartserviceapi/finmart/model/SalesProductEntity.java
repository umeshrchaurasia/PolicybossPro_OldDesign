package magicfinmart.datacomp.com.finmartserviceapi.finmart.model;

import android.os.Parcel;
import android.os.Parcelable;

public class SalesProductEntity implements Parcelable {
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.Product_Id);
        dest.writeString(this.Product_Name);
        dest.writeString(this.Product_image);
        dest.writeInt(this.Count);
    }

    public SalesProductEntity() {
    }

    protected SalesProductEntity(Parcel in) {
        this.Product_Id = in.readInt();
        this.Product_Name = in.readString();
        this.Product_image = in.readString();
        this.Count = in.readInt();
    }

    public static final Parcelable.Creator<SalesProductEntity> CREATOR = new Parcelable.Creator<SalesProductEntity>() {
        @Override
        public SalesProductEntity createFromParcel(Parcel source) {
            return new SalesProductEntity(source);
        }

        @Override
        public SalesProductEntity[] newArray(int size) {
            return new SalesProductEntity[size];
        }
    };
}