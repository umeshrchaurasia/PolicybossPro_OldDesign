package magicfinmart.datacomp.com.finmartserviceapi.finmart.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class ContactlistEntity extends RealmObject {
    /**
     * name : Three
     * mobileno : 807232323
     */


    @PrimaryKey
    private String mobileno;
    private boolean isSync;
    private String url;
    private String name;


    public ContactlistEntity() {
        this.isSync = false;
    }

    public boolean isSync() {
        return isSync;
    }

    public void setSync(boolean sync) {
        isSync = sync;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }
}