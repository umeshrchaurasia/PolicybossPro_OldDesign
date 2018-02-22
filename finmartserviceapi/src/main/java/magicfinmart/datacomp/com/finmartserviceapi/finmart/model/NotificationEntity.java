package magicfinmart.datacomp.com.finmartserviceapi.finmart.model;

public class NotificationEntity {
    /**
     * title : Finmart Offer
     * body : Notofication test
     * img_url : http://i.stack.imgur.com/CE5lz.png
     * action : HL
     * web_url : http://i.stack.imgur.com/CE5lz.png
     * web_title : Demo
     * is_read : 0
     */

    private String title;
    private String body;
    private String img_url;
    private String action;
    private String web_url;
    private String web_title;


    private String date;
    private int is_read;

    public NotificationEntity() {
        this.title = "";
        this.body = "";
        this.img_url = "";
        this.action = "";
        this.web_url = "";
        this.web_title = "";
        this.is_read = 0;
        this.date = "";

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getWeb_url() {
        return web_url;
    }

    public void setWeb_url(String web_url) {
        this.web_url = web_url;
    }

    public String getWeb_title() {
        return web_title;
    }

    public void setWeb_title(String web_title) {
        this.web_title = web_title;
    }

    public int getIs_read() {
        return is_read;
    }

    public void setIs_read(int is_read) {
        this.is_read = is_read;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}