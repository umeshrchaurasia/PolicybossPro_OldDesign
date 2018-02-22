package com.datacomp.magicfinmart.whatsnew;

/**
 * Created by Rajeev Ranjan on 22/02/2018.
 */

public class WhatsNewEntity {
    String title;
    String desc;

    public WhatsNewEntity(String title, String desc) {
        this.title = title;
        this.desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
