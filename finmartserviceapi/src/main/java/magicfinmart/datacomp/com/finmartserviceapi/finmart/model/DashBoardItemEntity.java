package magicfinmart.datacomp.com.finmartserviceapi.finmart.model;

public class DashBoardItemEntity {
    /**
     * menuid : 6
     * menuname : Dashboard 1
     * link : http://bo.magicfinmart.com
     * iconimage : http://bo.magicfinmart.com
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
}