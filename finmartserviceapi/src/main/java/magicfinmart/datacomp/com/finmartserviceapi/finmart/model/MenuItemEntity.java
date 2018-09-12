package magicfinmart.datacomp.com.finmartserviceapi.finmart.model;

public class MenuItemEntity {
    /**
     * menuid : 1
     * menuname : Reports
     * link : http://bo.magicfinmart.com
     * iconimage : http://api.magicfinmart.com/InsurerImages/car_1.png
     * isActive : 1
     * description : null
     * type : 1
     */

    private int menuid;
    private String menuname;
    private String link;
    private String iconimage;
    private int isActive;
    private Object description;
    private int type;

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

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}