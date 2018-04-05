package magicfinmart.datacomp.com.finmartserviceapi.pospapp.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Rajeev Ranjan on 07/04/2017.
 */

public class StudyMaterialEntity implements Parcelable {
    public StudyMaterialEntity() {

    }

    public StudyMaterialEntity(String title, String link, long timeLeft, long totalTime, int type) {
        this.title = title;
        this.link = link;
        this.timeLeft = timeLeft;
        this.totalTime = totalTime;
        this.type = type;
    }

    String title, link;
    long timeLeft, totalTime;
    int type;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public long getTimeLeft() {
        return timeLeft;
    }

    public void setTimeLeft(long timeLeft) {
        this.timeLeft = timeLeft;
    }

    public long getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(long totalTime) {
        this.totalTime = totalTime;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.link);
        dest.writeLong(this.timeLeft);
        dest.writeLong(this.totalTime);
        dest.writeInt(this.type);
    }

    protected StudyMaterialEntity(Parcel in) {
        this.title = in.readString();
        this.link = in.readString();
        this.timeLeft = in.readLong();
        this.totalTime = in.readLong();
        this.type = in.readInt();
    }

    public static final Creator<StudyMaterialEntity> CREATOR = new Creator<StudyMaterialEntity>() {
        @Override
        public StudyMaterialEntity createFromParcel(Parcel source) {
            return new StudyMaterialEntity(source);
        }

        @Override
        public StudyMaterialEntity[] newArray(int size) {
            return new StudyMaterialEntity[size];
        }
    };
}
