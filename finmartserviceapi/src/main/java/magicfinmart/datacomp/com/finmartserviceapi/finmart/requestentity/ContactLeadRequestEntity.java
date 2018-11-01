package magicfinmart.datacomp.com.finmartserviceapi.finmart.requestentity;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ContactlistEntity;

/**
 * Created by IN-RB on 17-10-2018.
 */

public class ContactLeadRequestEntity {


    /**
     * fbaid : 12
     * contactlist : [{"name":"Three","mobileno":"807232323"},{"name":"Four","mobileno":"77232323"}]
     */

    private String fbaid;
    private List<ContactlistEntity> contactlist;

    public String getFbaid() {
        return fbaid;
    }

    public void setFbaid(String fbaid) {
        this.fbaid = fbaid;
    }

    public List<ContactlistEntity> getContactlist() {
        return contactlist;
    }

    public void setContactlist(List<ContactlistEntity> contactlist) {
        this.contactlist = contactlist;
    }


}
