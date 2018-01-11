package com.datacomp.magicfinmart.motor.privatecar.addquote;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.text.InputFilter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import com.datacomp.magicfinmart.BaseFragment;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.utility.Constants;
import com.datacomp.magicfinmart.utility.GenericTextWatcher;

import java.util.List;

import io.realm.Realm;
import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;

/**
 * A simple {@link Fragment} subclass.
 */
public class InputFragment extends BaseFragment implements View.OnClickListener, GenericTextWatcher.iVehicle {

    CardView cvNewRenew, cvRegNo, cvInput;
    Button btnGetQuote;
    TextView tvDontKnow;
    EditText etreg1, etreg2, etreg3, etreg4;
    Switch switchNewRenew;
    String TAG = "InputFragment";

    //region inputs
    Spinner spFuel, spVarient, spPrevIns;
    EditText etExtValue, etRegDate, etMfgDate, etExpDate, etCustomerName, etMobile;
    AutoCompleteTextView acMakeModel, acRto;
    TextView tvCarNo;
    Switch swIndividual, swClaim;
    SeekBar sbClaim;
    //endregion
    DBPersistanceController databaseController;
    Realm realm;

    List<String> makeModelList, fuelList, variantList, cityList;
    ArrayAdapter<String> makeModelAdapter, varientAdapter, fuelAdapter, cityAdapter;

    public InputFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_input, container, false);
        realm = Realm.getDefaultInstance();
        databaseController = new DBPersistanceController(getActivity());
        //cityList= databaseController.get
        makeModelList = databaseController.getCarMakeModel();
        intit_view(view);
        setListener();
        init_views();
        bind_Adapters();
        return view;
    }

    private void bind_Adapters() {

    }

    private void init_views() {
        cvInput.setVisibility(View.GONE);
    }

    private void setListener() {
        btnGetQuote.setOnClickListener(this);
        tvDontKnow.setOnClickListener(this);
        etreg1.addTextChangedListener(new GenericTextWatcher(etreg1, this));
        etreg2.addTextChangedListener(new GenericTextWatcher(etreg2, this));
        etreg3.addTextChangedListener(new GenericTextWatcher(etreg3, this));
        etreg4.addTextChangedListener(new GenericTextWatcher(etreg4, this));
    }

    private void intit_view(View view) {
        cvNewRenew = (CardView) view.findViewById(R.id.cvNewRenew);
        cvRegNo = (CardView) view.findViewById(R.id.cvRegNo);
        cvInput = (CardView) view.findViewById(R.id.cvInput);
        btnGetQuote = (Button) view.findViewById(R.id.btnGetQuote);
        tvDontKnow = (TextView) view.findViewById(R.id.tvDontKnow);

        etreg1 = (EditText) view.findViewById(R.id.etreg1);
        etreg1.setFilters(new InputFilter[]{new InputFilter.AllCaps(), new InputFilter.LengthFilter(2)});
        etreg2 = (EditText) view.findViewById(R.id.etreg2);
        etreg2.setFilters(new InputFilter[]{new InputFilter.AllCaps(), new InputFilter.LengthFilter(2)});
        etreg3 = (EditText) view.findViewById(R.id.etreg3);
        etreg3.setFilters(new InputFilter[]{new InputFilter.AllCaps(), new InputFilter.LengthFilter(2)});
        etreg4 = (EditText) view.findViewById(R.id.etreg4);
        etreg4.setFilters(new InputFilter[]{new InputFilter.AllCaps(), new InputFilter.LengthFilter(4)});

        switchNewRenew = (Switch) view.findViewById(R.id.switchNewRenew);

        //region init views
        spFuel = (Spinner) view.findViewById(R.id.spFuel);
        spVarient = (Spinner) view.findViewById(R.id.spVarient);
        spPrevIns = (Spinner) view.findViewById(R.id.spPrevIns);
        etExtValue = (EditText) view.findViewById(R.id.etExtValue);
        etRegDate = (EditText) view.findViewById(R.id.etRegDate);
        etMfgDate = (EditText) view.findViewById(R.id.etMfgDate);
        etExpDate = (EditText) view.findViewById(R.id.etExpDate);
        etCustomerName = (EditText) view.findViewById(R.id.etCustomerName);
        etMobile = (EditText) view.findViewById(R.id.etMobile);
        acMakeModel = (AutoCompleteTextView) view.findViewById(R.id.acMakeModel);
        acRto = (AutoCompleteTextView) view.findViewById(R.id.acRto);
        tvCarNo = (EditText) view.findViewById(R.id.tvCarNo);
        swIndividual = (Switch) view.findViewById(R.id.swIndividual);
        swClaim = (Switch) view.findViewById(R.id.swClaim);
        sbClaim = (SeekBar) view.findViewById(R.id.sbClaim);
        //endregion
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnGetQuote:
                break;
            case R.id.tvDontKnow:
                cvInput.setVisibility(View.VISIBLE);
                cvNewRenew.setVisibility(View.GONE);
                cvRegNo.setVisibility(View.GONE);
                break;
        }
    }

    @Override
    public void getVehicleNumber(View view, String vehicleNo) {
        switch (view.getId()) {
            case R.id.etreg1:
                etreg2.requestFocus();
                break;
            case R.id.etreg2:
                etreg3.requestFocus();
                break;
            case R.id.etreg3:
                etreg4.requestFocus();
                break;
            case R.id.etreg4:
                String regNo = etreg1.getText().toString() + etreg2.getText().toString()
                        + etreg3.getText().toString() + etreg4.getText().toString();
                Constants.hideKeyBoard(etreg4, this.getActivity());
                Log.d(TAG, regNo);
                break;
        }
    }

    @Override
    public void cancelVehicleNumber(View view) {
        switch (view.getId()) {
            case R.id.etreg1:
                break;
            case R.id.etreg2:
                etreg1.requestFocus();
                break;
            case R.id.etreg3:
                etreg2.requestFocus();
                break;
            case R.id.etreg4:
                etreg3.requestFocus();
                break;
        }
    }
}
