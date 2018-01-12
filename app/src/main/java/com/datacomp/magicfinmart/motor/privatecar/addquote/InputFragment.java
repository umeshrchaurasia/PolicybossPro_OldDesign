package com.datacomp.magicfinmart.motor.privatecar.addquote;


import android.app.DatePickerDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.text.InputFilter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import com.datacomp.magicfinmart.BaseFragment;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.utility.Constants;
import com.datacomp.magicfinmart.utility.DateTimePicker;
import com.datacomp.magicfinmart.utility.GenericTextWatcher;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import io.realm.Realm;
import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;

import static com.datacomp.magicfinmart.utility.DateTimePicker.getDiffYears;

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

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    DBPersistanceController databaseController;
    Realm realm;
    List<String> makeModelList, fuelList, variantList, cityList;
    ArrayAdapter<String> makeModelAdapter, varientAdapter, fuelAdapter, cityAdapter, prevInsAdapter;
    int modelId = 0, varientId;
    String regplace;


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
        initialize_views();
        bind_Adapters();
        return view;
    }

    private void bind_Adapters() {

        //region make model
        makeModelAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, makeModelList);
        acMakeModel.setAdapter(makeModelAdapter);

        acMakeModel.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Constants.hideKeyBoard(acMakeModel, getActivity());
                modelId = databaseController.getModelID(getModel(acMakeModel.getText().toString()));

                fuelList = databaseController.getFuelTypeByModelId(modelId);
                variantList = databaseController.getVariantbyModelID(modelId);

                spFuel.setVisibility(View.VISIBLE);
                spVarient.setVisibility(View.VISIBLE);

                fuelAdapter = new
                        ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, fuelList);
                spFuel.setAdapter(fuelAdapter);

                varientAdapter = new
                        ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, variantList);
                spVarient.setAdapter(varientAdapter);
            }
        });


        spFuel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (fuelList.get(position).equals(Constants.EXTERNAL_LPG)
                        || fuelList.get(position).equals(Constants.EXTERNAL_CNG)) {
                    etExtValue.setFocusable(true);
                } else {
                    etExtValue.setFocusable(false);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                etExtValue.setFocusable(false);
            }
        });
        //endregion

        // region city adapter
        cityAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, cityList);
        acRto.setAdapter(cityAdapter);
        acRto.setThreshold(2);

        acRto.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                regplace = cityAdapter.getItem(position).toString();
                Constants.hideKeyBoard(acRto, getActivity());
            }
        });
        /**
         * Unset the var whenever the user types. Validation will
         * then fail. This is how we enforce selecting from the list.
         *//*
        acRto.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                regplace = null;
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });*/
        //endregion

        // region prev insurer adapter
        prevInsAdapter = new
                ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, databaseController.getInsurerList()) {
                    @Override
                    public boolean isEnabled(int position) {
                        if (position == 0) {
                            // Disable the first item from Spinner
                            // First item will be use for hint
                            return false;
                        } else {
                            return true;
                        }
                    }

                    @Override
                    public View getDropDownView(int position, View convertView,
                                                ViewGroup parent) {
                        View view = super.getDropDownView(position, convertView, parent);
                        TextView tv = (TextView) view;
                        if (position == 0) {
                            // Set the hint text color gray
                            tv.setTextColor(Color.GRAY);
                        } else {
                            tv.setTextColor(Color.BLACK);
                        }
                        return view;
                    }
                };
        spPrevIns.setAdapter(prevInsAdapter);

        //endregion
    }

    private void initialize_views() {
        cvInput.setVisibility(View.GONE);
    }

    private void setListener() {
        btnGetQuote.setOnClickListener(this);
        tvDontKnow.setOnClickListener(this);
        etreg1.addTextChangedListener(new GenericTextWatcher(etreg1, this));
        etreg2.addTextChangedListener(new GenericTextWatcher(etreg2, this));
        etreg3.addTextChangedListener(new GenericTextWatcher(etreg3, this));
        etreg4.addTextChangedListener(new GenericTextWatcher(etreg4, this));
        etRegDate.setOnClickListener(datePickerDialog);
        etMfgDate.setOnClickListener(datePickerDialog);
        etExpDate.setOnClickListener(datePickerDialog);
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
        tvCarNo = (TextView) view.findViewById(R.id.tvCarNo);
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
            case R.id.acRto:
                regplace = null;
                break;

        }
    }

    public String getModel(String makeModel) {
        String[] parts = makeModel.split(",");
        return parts[1];
    }


    private int getMonth(String date) {
        String mon = "" + date.charAt(5) + date.charAt(6);
        return Integer.parseInt(mon);
    }

    private int getYear(String date) {
        String year = "" + date.charAt(0) + date.charAt(1) + date.charAt(2) + date.charAt(3);
        return Integer.parseInt(year);
    }

    private int getDate(String date) {
        String dat = "" + date.charAt(8) + date.charAt(9);
        return Integer.parseInt(dat);
    }

    private int getYearDiffForNCB(String firstDay, String lastDay) {
        try {
            return getDiffYears(simpleDateFormat.parse(firstDay), simpleDateFormat.parse(lastDay));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    //region datepicker
    protected View.OnClickListener datePickerDialog = new View.OnClickListener() {
        @Override
        public void onClick(final View view) {
            Constants.hideKeyBoard(view, getActivity());

            if (view.getId() == R.id.etRegDate) {
                DateTimePicker.firstRegNewDatePicker(view.getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view1, int year, int monthOfYear, int dayOfMonth) {
                        if (view1.isShown()) {
                            Calendar calendar = Calendar.getInstance();
                            calendar.set(year, monthOfYear, dayOfMonth);
                            String currentDay = simpleDateFormat.format(calendar.getTime());
                            etRegDate.setText(currentDay);
                            etMfgDate.setText(currentDay);
                        }
                    }
                });

            } else if (view.getId() == R.id.etExpDate) {
                DateTimePicker.policyExpDatePicker(view.getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view1, int year, int monthOfYear, int dayOfMonth) {
                        if (view1.isShown()) {
                            Calendar calendar = Calendar.getInstance();
                            calendar.set(year, monthOfYear, dayOfMonth);
                            String currentDay = simpleDateFormat.format(calendar.getTime());
                            etExpDate.setText(currentDay);
                            if (etRegDate.getText().toString() != null && !etRegDate.getText().toString().equals("")) {
                                //int yearDiff = getYearDiffForNCB(currentDay, etRegDate.getText().toString());
                                //setNcbAdapter(yearDiff);
                            }
                        }
                    }
                });
            } else if (view.getId() == R.id.etMfgDate) {
                if (etRegDate.getText().toString().equals("") || etRegDate.getText().toString() == null) {
                    DateTimePicker.firstRegNewDatePicker(view.getContext(),
                            new DatePickerDialog.OnDateSetListener() {
                                @Override
                                public void onDateSet(DatePicker view1, int year, int monthOfYear, int dayOfMonth) {
                                    if (view1.isShown()) {
                                        Calendar calendar = Calendar.getInstance();
                                        calendar.set(year, monthOfYear, dayOfMonth);
                                        String currentDay = simpleDateFormat.format(calendar.getTime());
                                        etMfgDate.setText(currentDay);
                                    }

                                }
                            });
                } else {
                    DateTimePicker.manufactDatePicker(view.getContext(), getYear(etRegDate.getText().toString()), getMonth(etRegDate.getText().toString()), getDate(etRegDate.getText().toString()),
                            new DatePickerDialog.OnDateSetListener() {
                                @Override
                                public void onDateSet(DatePicker view1, int year, int monthOfYear, int dayOfMonth) {
                                    if (view1.isShown()) {
                                        Calendar calendar = Calendar.getInstance();
                                        calendar.set(year, monthOfYear, dayOfMonth);
                                        String currentDay = simpleDateFormat.format(calendar.getTime());
                                        etMfgDate.setText(currentDay);
                                    }

                                }
                            });
                }

            }

        }
    };
    //endregion

}
