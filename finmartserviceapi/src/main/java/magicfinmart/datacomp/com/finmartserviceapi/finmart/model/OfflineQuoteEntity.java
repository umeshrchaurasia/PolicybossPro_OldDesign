package magicfinmart.datacomp.com.finmartserviceapi.finmart.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public  class OfflineQuoteEntity implements Parcelable {


    /**
     * id : 28
     * FBAID : 1976
     * product_name : Motor Private
     * Quote_description : Type of Policy (Comprehensive / TP only) :
     Make :
     Model :
     Variant :
     Year of Manufacture :
     Date of Registration :
     RTO (where registered) :
     Claim Status in last policy : y7t
     Sum Insured (IDV) in the last policy : hihihiii
     Insurer :
     Any special cover needed :
     * Status :
     * Quote_status :
     * Comment :
     * Amount :
     * Converted_date :
     * Created_date :
     * Documents : [{"id":"5","quotes_request_id":"28","document_path":"1540994210.download 2.jpg","Created_date":"","Type":"1","Document_name":"Quote 1"},{"id":"6","quotes_request_id":"28","document_path":"1540994210.download 2.jpg","Created_date":"","Type":"1","Document_name":"Quote 2"},{"id":"7","quotes_request_id":"28","document_path":"1540994210.download 2.jpg","Created_date":"","Type":"1","Document_name":"Quote 3"}]
     */

    private String id;
    private String FBAID;
    private String product_name;
    private String Quote_description;
    private String Status;
    private String Quote_status;
    private String Comment;
    private String Amount;
    private String Converted_date;
    private String Created_date;

    private String editable;
    private List<DocumentsOfflineEntity> Documents;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFBAID() {
        return FBAID;
    }

    public void setFBAID(String FBAID) {
        this.FBAID = FBAID;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getQuote_description() {
        return Quote_description;
    }

    public void setQuote_description(String Quote_description) {
        this.Quote_description = Quote_description;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getQuote_status() {
        return Quote_status;
    }

    public void setQuote_status(String Quote_status) {
        this.Quote_status = Quote_status;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String Comment) {
        this.Comment = Comment;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String Amount) {
        this.Amount = Amount;
    }

    public String getConverted_date() {
        return Converted_date;
    }

    public void setConverted_date(String Converted_date) {
        this.Converted_date = Converted_date;
    }

    public String getCreated_date() {
        return Created_date;
    }

    public void setCreated_date(String Created_date) {
        this.Created_date = Created_date;
    }

    public String getEditable() {
        return editable;
    }

    public void setEditable(String editable) {
        this.editable = editable;
    }


    public List<DocumentsOfflineEntity> getDocuments() {
        return Documents;
    }

    public void setDocuments(List<DocumentsOfflineEntity> Documents) {
        this.Documents = Documents;
    }


    public OfflineQuoteEntity() {
    }

    protected OfflineQuoteEntity(Parcel in) {
        id = in.readString();
        FBAID = in.readString();
        product_name = in.readString();
        Quote_description = in.readString();
        Status = in.readString();
        Quote_status = in.readString();
        Comment = in.readString();
        Amount = in.readString();
        Converted_date = in.readString();
        Created_date = in.readString();
        editable = in.readString();
    }

    public static final Creator<OfflineQuoteEntity> CREATOR = new Creator<OfflineQuoteEntity>() {
        @Override
        public OfflineQuoteEntity createFromParcel(Parcel in) {
            return new OfflineQuoteEntity(in);
        }

        @Override
        public OfflineQuoteEntity[] newArray(int size) {
            return new OfflineQuoteEntity[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(FBAID);
        dest.writeString(product_name);
        dest.writeString(Quote_description);
        dest.writeString(Status);
        dest.writeString(Quote_status);
        dest.writeString(Comment);
        dest.writeString(Amount);
        dest.writeString(Converted_date);
        dest.writeString(Created_date);
        dest.writeString(editable);
    }
}