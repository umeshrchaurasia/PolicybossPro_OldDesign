package magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.masters;

import android.content.Context;
import android.os.AsyncTask;

import magicfinmart.datacomp.com.finmartserviceapi.database.LoanCityFacade;
import magicfinmart.datacomp.com.finmartserviceapi.loan_fm.response.LoanCityResponse;

/**
 * Created by Rajeev Ranjan on 25/03/2019.
 */
public class AsyncLoanCityConstant extends AsyncTask<Void, Void, Void> {


    LoanCityResponse response;
    Context mContext;
    public AsyncLoanCityConstant(Context context, LoanCityResponse response) {
        mContext = context;
        this.response = response;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        new LoanCityFacade(mContext).saveLoanCity(response);
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }
}

