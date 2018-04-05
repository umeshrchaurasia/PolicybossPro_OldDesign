package magicfinmart.datacomp.com.finmartserviceapi.pospapp.response;

import android.os.Parcel;
import android.os.Parcelable;

import magicfinmart.datacomp.com.finmartserviceapi.pospapp.APIResponse;

/**
 * Created by Rajeev Ranjan on 03/04/2017.
 */

public class SubmitResponse extends APIResponse implements Parcelable {

    /**
     * MarksObtained : 43
     * PassingMarks : 35
     * ResultMessage : Thank You for giving the exam !!You will receive your passing certificate on the registered Mail Id.
     * ResultStatus : Pass
     * TotalMarks : 150
     */

    private int MarksObtained;
    private int PassingMarks;
    private String ResultMessage;
    private String ResultStatus;
    private int TotalMarks;

    public int getNoofAttempt() {
        return NoofAttempt;
    }

    /**
     * NoofAttempt : 2147483647
     * PdfPath : String content
     */

    private int NoofAttempt;
    private String PdfPath;

    public int getMarksObtained() {
        return MarksObtained;
    }

    public void setMarksObtained(int MarksObtained) {
        this.MarksObtained = MarksObtained;
    }

    public int getPassingMarks() {
        return PassingMarks;
    }

    public void setPassingMarks(int PassingMarks) {
        this.PassingMarks = PassingMarks;
    }

    public String getResultMessage() {
        return ResultMessage;
    }

    public void setResultMessage(String ResultMessage) {
        this.ResultMessage = ResultMessage;
    }

    public String getResultStatus() {
        return ResultStatus;
    }

    public void setResultStatus(String ResultStatus) {
        this.ResultStatus = ResultStatus;
    }

    public int getTotalMarks() {
        return TotalMarks;
    }

    public void setTotalMarks(int TotalMarks) {
        this.TotalMarks = TotalMarks;
    }

    public void setNoofAttempt(int NoofAttempt) {
        this.NoofAttempt = NoofAttempt;
    }

    public String getPdfPath() {
        return PdfPath;
    }

    public void setPdfPath(String PdfPath) {
        this.PdfPath = PdfPath;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.MarksObtained);
        dest.writeInt(this.PassingMarks);
        dest.writeString(this.ResultMessage);
        dest.writeString(this.ResultStatus);
        dest.writeInt(this.TotalMarks);
        dest.writeInt(this.NoofAttempt);
        dest.writeString(this.PdfPath);
    }

    public SubmitResponse() {
    }

    protected SubmitResponse(Parcel in) {
        this.MarksObtained = in.readInt();
        this.PassingMarks = in.readInt();
        this.ResultMessage = in.readString();
        this.ResultStatus = in.readString();
        this.TotalMarks = in.readInt();
        this.NoofAttempt = in.readInt();
        this.PdfPath = in.readString();
    }

    public static final Creator<SubmitResponse> CREATOR = new Creator<SubmitResponse>() {
        @Override
        public SubmitResponse createFromParcel(Parcel source) {
            return new SubmitResponse(source);
        }

        @Override
        public SubmitResponse[] newArray(int size) {
            return new SubmitResponse[size];
        }
    };
}
