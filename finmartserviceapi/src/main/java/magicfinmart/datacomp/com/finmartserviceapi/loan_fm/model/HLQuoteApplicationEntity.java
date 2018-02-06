package magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ApplicationListEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.QuoteListEntity;

/**
 * Created by IN-RB on 01-02-2018.
 */

public class HLQuoteApplicationEntity implements Parcelable   {

    private List<LoanQuoteEntity> quote;
    private List<LoanApplicationEntity> application;


    protected HLQuoteApplicationEntity(Parcel in) {

        this.quote = new ArrayList<LoanQuoteEntity>();
        in.readList(this.quote,QuoteListEntity.class.getClassLoader());

        this.application = new ArrayList<LoanApplicationEntity>();
        in.readList(this.application,LoanApplicationEntity.class.getClassLoader());
    }

    public static final Creator<HLQuoteApplicationEntity> CREATOR = new Creator<HLQuoteApplicationEntity>() {
        @Override
        public HLQuoteApplicationEntity createFromParcel(Parcel in) {

            return new HLQuoteApplicationEntity(in);
        }

        @Override
        public HLQuoteApplicationEntity[] newArray(int size) {
            return new HLQuoteApplicationEntity[size];
        }
    };

    public List<LoanQuoteEntity> getQuote() {
        return quote;
    }

    public void setQuote(List<LoanQuoteEntity> quote) {
        this.quote = quote;
    }


    public List<LoanApplicationEntity> getApplication() {
        return application;
    }

    public void setApplication(List<LoanApplicationEntity> application) {
        this.application = application;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(this.quote);
        dest.writeList(this.application);
    }
}
