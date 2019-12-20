package magicfinmart.datacomp.com.finmartserviceapi.dynamic_urls.model;

public class SwipeDetailsEntity {
    /**
     * city :
     * datetime : 4/12/2017 12:00:00 AM 18:11:01.5970000
     * lat : 19.0857105255127
     * lng : 72.8883972167969
     * location :
     */

    private String city;
    private String datetime;
    private String lat;
    private String lng;
    private String location;


    private String entrytype;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEntrytype() {
        return entrytype;
    }

    public void setEntrytype(String entrytype) {
        this.entrytype = entrytype;
    }

}