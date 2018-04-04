package magicfinmart.datacomp.com.finmartserviceapi.inspection.entity;

import android.graphics.Bitmap;

/**
 * Created by Rajeev Ranjan on 11/12/2017.
 */

public class FrontRearEntity {

    private Bitmap bitmap;
    private int id;
    private String name;
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public FrontRearEntity(String name, int id) {
        this.name = name;
        this.id = id;
        this.value = "SAFE";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
