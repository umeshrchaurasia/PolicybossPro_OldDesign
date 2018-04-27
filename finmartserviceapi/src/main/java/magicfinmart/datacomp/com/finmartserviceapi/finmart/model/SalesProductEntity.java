package magicfinmart.datacomp.com.finmartserviceapi.finmart.model;

import android.os.Parcel;
import android.os.Parcelable;

import io.realm.RealmObject;

public class SalesProductEntity extends RealmObject implements Parcelable {
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


    private boolean blnShow;

    public SalesProductEntity() {
    }

    protected SalesProductEntity(Parcel in) {
        Product_Id = in.readInt();
        Product_Name = in.readString();
        Product_image = in.readString();
        Count = in.readInt();
        blnShow = in.readByte() != 0;
    }

    public static final Creator<SalesProductEntity> CREATOR = new Creator<SalesProductEntity>() {
        @Override
        public SalesProductEntity createFromParcel(Parcel in) {
            return new SalesProductEntity(in);
        }

        @Override
        public SalesProductEntity[] newArray(int size) {
            return new SalesProductEntity[size];
        }
    };

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

    public boolean getBlnShow() {
        return blnShow;
    }

    public void setBlnShow(boolean blnShow) {
        this.blnShow = blnShow;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(Product_Id);
        dest.writeString(Product_Name);
        dest.writeString(Product_image);
        dest.writeInt(Count);
        dest.writeByte((byte) (blnShow ? 1 : 0));
    }
}