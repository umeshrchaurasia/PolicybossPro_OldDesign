package magicfinmart.datacomp.com.finmartserviceapi.finmart.model;

public class NotificationEntity {


    private String title;
    private String body;
    private String img_url;
    private String action;
    private String notifyFlag;
    private String web_url;
    private String web_title;
    private String is_read;
    private String date;
    private int message_id;
    private  boolean isOpen;


    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
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

    public String getNotifyFlag() {
        return notifyFlag;
    }

    public void setNotifyFlag(String notifyFlag) {
        this.notifyFlag = notifyFlag;
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

    public String getIs_read() {
        return is_read;
    }

    public void setIs_read(String is_read) {
        this.is_read = is_read;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getMessage_id() {
        return message_id;
    }

    public void setMessage_id(int message_id) {
        this.message_id = message_id;
    }


}