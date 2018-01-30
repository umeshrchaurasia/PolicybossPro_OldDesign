package com.datacomp.magicfinmart.motor.privatecar.addquote.fragment;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.text.InputFilter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.datacomp.magicfinmart.BaseFragment;
import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.utility.Constants;
import com.datacomp.magicfinmart.utility.DateTimePicker;
import com.datacomp.magicfinmart.utility.GenericTextWatcher;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import io.realm.Realm;
import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.fastlane.FastLaneController;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.FastLaneDataEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.FastLaneDataResponse;
import magicfinmart.datacomp.com.finmartserviceapi.motor.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.motor.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.motor.controller.MotorController;
import magicfinmart.datacomp.com.finmartserviceapi.motor.requestentity.MotorRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.motor.response.BikeUniqueResponse;

import static com.datacomp.magicfinmart.utility.DateTimePicker.getDiffYears;

/**
 * Created by Rajeev Ranjan on 29/01/2018.
 */

public class InputFragment extends BaseFragment implements View.OnClickListener, GenericTextWatcher.iVehicle, IResponseSubcriber, magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber {

    CardView cvNewRenew, cvRegNo;
    View cvInput;
    Button btnGetQuote;
    TextView tvDontKnow;
    EditText etreg1, etreg2, etreg3, etreg4;
    String regNo = "";
    Switch switchNewRenew;
    String TAG = "AddNewQuoteActivity";
    MotorRequestEntity motorRequestEntity;
    FastLaneDataEntity fastLaneResponseEntity;

    //region inputs
    Spinner spFuel, spVarient, spPrevIns;
    EditText etExtValue, etRegDate, etMfgDate, etExpDate, etCustomerName, etMobile;
    AutoCompleteTextView acMakeModel, acRto;
    TextView tvCarNo;
    Switch swIndividual, swClaim;
    Spinner spNcbPercent;
    //endregion

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    DBPersistanceController databaseController;
    Realm realm;
    List<String> makeModelList, fuelList, variantList, cityList;
    ArrayAdapter<String> makeModelAdapter, varientAdapter, fuelAdapter, cityAdapter, prevInsAdapter, ncbPerctAdapter;
    String modelId, varientId;
    String regplace, makeModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.content_add_new_quote, container, false);
        databaseController = new DBPersistanceController(getActivity());
        cityList = databaseController.getRTOListNames();
        makeModelList = databaseController.getCarMakeModel();
        motorRequestEntity = new MotorRequestEntity();
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
                makeModel = makeModelAdapter.getItem(position).toString();

                modelId = databaseController.getModelID(getModel(acMakeModel.getText().toString()));

                fuelList = databaseController.getFuelTypeByModelId(modelId);
                variantList = databaseController.getVariantbyModelID(modelId);

                spFuel.setVisibility(View.VISIBLE);
                spVarient.setVisibility(View.VISIBLE);

                //region varient adapter

                varientAdapter = new
                        ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, variantList);
                spVarient.setAdapter(varientAdapter);

                //endregion

                //region fuel adapter

                fuelAdapter = new
                        ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, fuelList);
                spFuel.setAdapter(fuelAdapter);

                //endregion

            }
        });


        spFuel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (fuelList.get(position).equals(Constants.EXTERNAL_LPG)
                        || fuelList.get(position).equals(Constants.EXTERNAL_CNG)) {
                    etExtValue.setEnabled(true);
                } else {
                    etExtValue.setEnabled(false);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                etExtValue.setEnabled(false);
            }
        });
        //endregion

        // region city adapter

        cityAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, cityList);
        acRto.setAdapter(cityAdapter);
        acRto.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                regplace = cityAdapter.getItem(position).toString();
                Constants.hideKeyBoard(acRto, getActivity());
            }
        });

        //endregion

        // region prev insurer adapter
        prevInsAdapter = new
                ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, databaseController.getInsurerList());
//        {
//                    @Override
//                    public boolean isEnabled(int position) {
//                        if (position == 0) {
//                            // Disable the first item from Spinner
//                            // First item will be use for hint
//                            return false;
//                        } else {
//                            return true;
//                        }
//                    }
//
//                    @Override
//                    public View getDropDownView(int position, View convertView,
//                                                ViewGroup parent) {
//                        View view = super.getDropDownView(position, convertView, parent);
//                        TextView tv = (TextView) view.findViewById(R.id.txtspinneritem);
//                        tv.setPadding(0, 0, 0, 0);
//                        if (position == 0) {
//                            // Set the hint text color gray
//                            tv.setTextColor(Color.GRAY);
//                        } else {
//                            tv.setTextColor(Color.BLACK);
//                        }
//                        return view;
//                    }
//
//
//                    @NonNull
//                    @Override
//                    public View getView(int position, @Nullable View convertView,
//                                        @NonNull ViewGroup parent) {
//                        View view1 = super.getView(position, convertView, parent);
//                        view1.setPadding(0, 0, 0, 0);
//                        return view1;
//
//                    }
//                };

//        prevInsAdapter = new
//                ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, databaseController.getInsurerList()) {
//                    @Override
//                    public boolean isEnabled(int position) {
//                        if (position == 0) {
//                            // Disable the first item from Spinner
//                            // First item will be use for hint
//                            return false;
//                        } else {
//                            return true;
//                        }
//                    }
//
//                    @Override
//                    public View getDropDownView(int position, View convertView,
//                                                ViewGroup parent) {
//                        View view = super.getDropDownView(position, convertView, parent);
//                        TextView tv = (TextView) view;
//                        if (position == 0) {
//                            // Set the hint text color gray
//                            tv.setTextColor(Color.GRAY);
//                        } else {
//                            tv.setTextColor(Color.BLACK);
//                        }
//                        return view;
//                    }
//                };
        spPrevIns.setAdapter(prevInsAdapter);

        //endregion

        // region ncb adapter
        ncbPerctAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.ncb_percent));
//        {
//            @NonNull
//            @Override
//            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//                View view1 = super.getView(position, convertView, parent);
//                TextView tx = (TextView) view1.findViewById(R.id.txtspinneritem);
//                tx.setPadding(0, 0, 0, 0);
//                return view1;
//            }
//        };
        spNcbPercent.setAdapter(ncbPerctAdapter);
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
        acMakeModel.addTextChangedListener(new GenericTextWatcher(acMakeModel, this));
        acRto.addTextChangedListener(new GenericTextWatcher(acRto, this));
        etRegDate.setOnClickListener(datePickerDialog);
        etMfgDate.setOnClickListener(datePickerDialog);
        etExpDate.setOnClickListener(datePickerDialog);
    }

    private void intit_view(View view) {
        cvNewRenew = (CardView) view.findViewById(R.id.cvNewRenew);
        cvRegNo = (CardView) view.findViewById(R.id.cvRegNo);
        cvInput = (View) view.findViewById(R.id.cvInput);
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
        swClaim = (Switch) view.findViewById(R.id.switchNcb);
        spNcbPercent = (Spinner) view.findViewById(R.id.spNcbPercent);
        //endregion
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnGetQuote:

                //region validations
                if (makeModel == null || makeModel.equals("")) {
                    acMakeModel.requestFocus();
                    acMakeModel.setError("Enter Make,Model");
                    return;
                }
                if (!isEmpty(etRegDate)) {
                    etRegDate.requestFocus();
                    etRegDate.setError("Enter Reg Date");
                    return;
                }
                if (!isEmpty(etMfgDate)) {
                    etMfgDate.requestFocus();
                    etMfgDate.setError("Enter Mfg Date");
                    return;
                }
                if (regplace == null || regplace.equals("")) {
                    acRto.requestFocus();
                    acRto.setError("Enter Rto");
                    return;
                }
                if (!isEmpty(etExpDate)) {
                    etExpDate.requestFocus();
                    etExpDate.setError("Enter Expiry Date");
                    return;
                }
                if (!isEmpty(etCustomerName)) {
                    etCustomerName.requestFocus();
                    etCustomerName.setError("Enter Name");
                    return;
                }
                if (!isValidePhoneNumber(etMobile)) {
                    etMobile.requestFocus();
                    etMobile.setError("Enter Mobile");
                    return;
                }
                if (spPrevIns.getSelectedItemPosition() == 0) {
                    spPrevIns.requestFocus();
                    Toast.makeText(getActivity(), "Select Present Insurer", Toast.LENGTH_SHORT).show();
                    return;
                }
                //endregion

                //TODO uncomment this
                if (switchNewRenew.isChecked()) {
                    setInputParametersReNewCar();
                } else {
                    setInputParametersNewCAR();
                }
                showDialog();
                new MotorController(getActivity()).getMotorPremiumInitiate(motorRequestEntity, this);

                //TODO remove this line
                //startActivity(new Intent(this, QuoteActivity.class).putExtra("CAR_REQUEST", motorRequestEntity).putExtra("RTO_NAME", regplace));
                break;
            case R.id.tvDontKnow:
                cvInput.setVisibility(View.VISIBLE);
                cvNewRenew.setVisibility(View.GONE);
                cvRegNo.setVisibility(View.GONE);
                btnGetQuote.setVisibility(View.VISIBLE);
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

                regNo = etreg1.getText().toString() + etreg2.getText().toString()
                        + etreg3.getText().toString() + etreg4.getText().toString();
                tvCarNo.setText(etreg1.getText().toString() + " " + etreg2.getText().toString()
                        + " " + etreg3.getText().toString() + " " + etreg4.getText().toString());
                Constants.hideKeyBoard(etreg4, getActivity());
                tvDontKnow.performClick();
                btnGetQuote.setVisibility(View.VISIBLE);
                showDialog("Fetching Car Details...");
                new FastLaneController(getActivity()).getVechileDetails(regNo, this);
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
            case R.id.acMakeModel:
                makeModel = null;
                break;

        }
    }

    public String getModel(String makeModel) {
        String[] parts = makeModel.split(",");
        return parts[1];
    }

    public String getMake(String makeModel) {
        String[] parts = makeModel.split(",");
        return parts[0];
    }

    public String getVarient(String varientWithCC) {
        String[] parts = varientWithCC.split(",");
        return parts[0];
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

    private String getRegistrationNo(String city) {
        return "" + city.charAt(1) + city.charAt(2) + "-" + city.charAt(3) + city.charAt(4) + "-AA-1234";
    }

    private String getManufacturingDate(String manufac) {
        //final Calendar calendar = Calendar.getInstance();
        return "" + manufac.charAt(0) + manufac.charAt(1) + manufac.charAt(2) + manufac.charAt(3) + manufac.charAt(4) + manufac.charAt(5) + manufac.charAt(6) + manufac.charAt(7) + "01";
        //return manufac + "-" + calendar.getTime().getMonth() + "-" + calendar.getTime().getDate();

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
                                int yearDiff = getYearDiffForNCB(currentDay, etRegDate.getText().toString());
                                setNcbAdapter(yearDiff);
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

    private void setInputParametersNewCAR() {
        motorRequestEntity.setBirth_date("1992-01-01");
        motorRequestEntity.setProduct_id(1);
        varientId = databaseController.getVariantID(getVarient(spVarient.getSelectedItem().toString()), getModel(acMakeModel.getText().toString()), getMake(acMakeModel.getText().toString()));
        motorRequestEntity.setVehicle_id(Integer.parseInt(varientId));
        motorRequestEntity.setRto_id(Integer.parseInt(databaseController.getCityID(regplace)));
        //motorRequestEntity.setSecret_key(Constants.SECRET_KEY);
        //motorRequestEntity.setClient_key(Constants.CLIENT_KEY);
        motorRequestEntity.setExecution_async("yes");
        motorRequestEntity.setVehicle_insurance_type("new");
        motorRequestEntity.setVehicle_manf_date(getManufacturingDate(etMfgDate.getText().toString()));
        motorRequestEntity.setVehicle_registration_date(etRegDate.getText().toString());
        motorRequestEntity.setPolicy_expiry_date("");
        motorRequestEntity.setPrev_insurer_id("");
        motorRequestEntity.setVehicle_registration_type("individual");
        motorRequestEntity.setVehicle_ncb_current("");
        motorRequestEntity.setIs_claim_exists("yes");
        motorRequestEntity.setMethod_type("Premium");
        motorRequestEntity.setElectrical_accessory("0");
        motorRequestEntity.setNon_electrical_accessory("0");
        if (regNo.equals(""))
            motorRequestEntity.setRegistration_no(getRegistrationNo(acRto.getText().toString()));
        else
            motorRequestEntity.setRegistration_no(regNo);
        motorRequestEntity.setIs_llpd("no");
        motorRequestEntity.setIs_antitheft_fit("no");
        motorRequestEntity.setVoluntary_deductible(0);
        motorRequestEntity.setIs_external_bifuel("no");
        motorRequestEntity.setPa_owner_driver_si("100000");
        motorRequestEntity.setPa_named_passenger_si("0");
        motorRequestEntity.setPa_unnamed_passenger_si("0");
        motorRequestEntity.setPa_paid_driver_si("0");
        motorRequestEntity.setVehicle_expected_idv(0);
        motorRequestEntity.setFirst_name("");
        motorRequestEntity.setMiddle_name("");
        motorRequestEntity.setLast_name("");
        motorRequestEntity.setMobile("");
        motorRequestEntity.setEmail("");
        motorRequestEntity.setCrn(0);
        motorRequestEntity.setIp_address("");
        setCustomerDetails();
    }


    private void setInputParametersReNewCar() {
        if (fastLaneResponseEntity != null) {
            motorRequestEntity.setVehicle_id(fastLaneResponseEntity.getVariant_Id());
            motorRequestEntity.setRto_id(fastLaneResponseEntity.getVehicleCity_Id());
            motorRequestEntity.setVehicle_manf_date(changeDateFormat(fastLaneResponseEntity.getRegistration_Date()));
            motorRequestEntity.setRegistration_no(formatRegistrationNo(fastLaneResponseEntity.getRegistration_Number()));
        } else {
            varientId = databaseController.getVariantID(getVarient(spVarient.getSelectedItem().toString()), getModel(acMakeModel.getText().toString()), getMake(acMakeModel.getText().toString()));
            motorRequestEntity.setVehicle_id(Integer.parseInt(varientId));
            motorRequestEntity.setRto_id(Integer.parseInt(databaseController.getCityID(acRto.getText().toString())));
            motorRequestEntity.setVehicle_manf_date(getManufacturingDate(etMfgDate.getText().toString()));
            if (regNo.equals(""))
                motorRequestEntity.setRegistration_no(getRegistrationNo(acRto.getText().toString()));
            else
                motorRequestEntity.setRegistration_no(regNo);
        }

        motorRequestEntity.setVehicle_registration_date(etRegDate.getText().toString());
        motorRequestEntity.setPolicy_expiry_date(etExpDate.getText().toString());
        motorRequestEntity.setPrev_insurer_id("" + databaseController.getInsurenceID(spPrevIns.getSelectedItem().toString()));

        motorRequestEntity.setBirth_date("1992-01-01");
        motorRequestEntity.setProduct_id(1);
        //motorRequestEntity.setSecret_key(Constants.SECRET_KEY);
        //motorRequestEntity.setClient_key(Constants.CLIENT_KEY);
        motorRequestEntity.setExecution_async("yes");
        motorRequestEntity.setVehicle_insurance_type("renew");


        motorRequestEntity.setVehicle_registration_type("individual");
        motorRequestEntity.setMethod_type("Premium");

        if (swClaim.isChecked()) {
            motorRequestEntity.setIs_claim_exists("yes");
            motorRequestEntity.setVehicle_ncb_current("");
        } else {
            motorRequestEntity.setIs_claim_exists("no");
            motorRequestEntity.setVehicle_ncb_current(spNcbPercent.getSelectedItem().toString());
        }

        motorRequestEntity.setElectrical_accessory("0");
        motorRequestEntity.setNon_electrical_accessory("0");

        motorRequestEntity.setIs_llpd("no");
        motorRequestEntity.setIs_antitheft_fit("no");
        motorRequestEntity.setVoluntary_deductible(0);
        motorRequestEntity.setIs_external_bifuel("no");
        motorRequestEntity.setPa_owner_driver_si("100000");
        motorRequestEntity.setPa_named_passenger_si("0");
        motorRequestEntity.setPa_unnamed_passenger_si("0");
        motorRequestEntity.setPa_paid_driver_si("0");
        motorRequestEntity.setVehicle_expected_idv(0);
        motorRequestEntity.setFirst_name("");
        motorRequestEntity.setMiddle_name("");
        motorRequestEntity.setLast_name("");
        motorRequestEntity.setMobile("");
        motorRequestEntity.setEmail("");
        motorRequestEntity.setCrn(0);
        motorRequestEntity.setIp_address("");
        setCustomerDetails();

    }


    void setCustomerDetails() {
        String[] fullName = etCustomerName.getText().toString().split(" ");

        if (fullName.length == 1) {
            motorRequestEntity.setFirst_name(fullName[0]);
        } else if (fullName.length == 2) {
            motorRequestEntity.setFirst_name(fullName[0]);
            motorRequestEntity.setLast_name(fullName[1]);

        } else if (fullName.length == 3) {
            motorRequestEntity.setFirst_name(fullName[0]);
            motorRequestEntity.setMiddle_name(fullName[1]);
            motorRequestEntity.setLast_name(fullName[2]);
        }
        motorRequestEntity.setMobile(etMobile.getText().toString());
        motorRequestEntity.setEmail("test@test.com");
    }

    @Override
    public void OnSuccess(APIResponse response, String message) {
        cancelDialog();
        if (response instanceof BikeUniqueResponse) {


            Bundle bundle = new Bundle();
            bundle.putParcelable("CAR_REQUEST", motorRequestEntity);
            bundle.putString("RTO_NAME", regplace);
            QuoteFragment quoteFragment = new QuoteFragment();
            quoteFragment.setArguments(bundle);
            FragmentTransaction transaction_quote = getActivity().getSupportFragmentManager().beginTransaction();
            transaction_quote.replace(R.id.frame_layout, quoteFragment, "QUOTE");
            transaction_quote.addToBackStack("QUOTE");
            transaction_quote.show(quoteFragment);
            //  transaction_quote.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            transaction_quote.commit();
            //startActivity(new Intent(getActivity(), QuoteActivity.class).putExtra("CAR_REQUEST", motorRequestEntity).putExtra("RTO_NAME", regplace));
        }

    }

    @Override
    public void OnSuccess(magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse response, String message) {
        if (response instanceof FastLaneDataResponse) {
            cancelDialog();
            Toast.makeText(getActivity(), "" + response.getMessage(), Toast.LENGTH_SHORT).show();
            if (response.getStatusNo() == 0) {
                if (((FastLaneDataResponse) response).getMasterData().getVariant_Id() != 0) {
                    this.fastLaneResponseEntity = ((FastLaneDataResponse) response).getMasterData();
                    bindFastLaneData(((FastLaneDataResponse) response).getMasterData());
                }
            }
        }
    }

    private void bindFastLaneData(FastLaneDataEntity masterData) {
        modelId = String.valueOf(masterData.getModel_ID());
        fuelList = new ArrayList<String>();
        fuelList.add("" + masterData.getFuel_Type());

        variantList = new ArrayList<String>();
        variantList.add("" + masterData.getVariant_Name() + " , ( " + masterData.getCubic_Capacity() + "CC )");
        //fuelList = databaseController.getFuelTypeByModelId(modelId);
        //variantList = databaseController.getVariantbyModelID(modelId);

        spFuel.setVisibility(View.VISIBLE);
        spVarient.setVisibility(View.VISIBLE);

        //region varient adapter

        varientAdapter = new
                ArrayAdapter(getActivity(), R.layout.sp_item_textview, R.id.txtspinneritem, variantList) {
                    @NonNull
                    @Override
                    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                        return super.getView(position, convertView, parent);
                    }
                };
        spVarient.setAdapter(varientAdapter);

        //endregion

        //region fuel adapter

        fuelAdapter = new
                ArrayAdapter(getActivity(), R.layout.sp_item_textview, R.id.txtspinneritem, fuelList) {
                    @NonNull
                    @Override
                    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                        View view1 = super.getView(position, convertView, parent);
                        TextView tv = (TextView) view1.findViewById(R.id.txtspinneritem);
                        tv.setPadding(0, 0, 0, 0);
                        return view1;
                    }
                };
        spFuel.setAdapter(fuelAdapter);

        //endregion

        acMakeModel.setText("" + masterData.getMake_Name() + "," + masterData.getModel_Name());
        etRegDate.setText("" + changeDateFormat(masterData.getRegistration_Date()));
        etMfgDate.setText("" + changeDateFormat(masterData.getPurchase_Date()));
        regplace = databaseController.getRTOCityName("" + masterData.getVehicleCity_Id());
        acRto.setText(regplace);
        makeModel = masterData.getMake_Name() + " , " + masterData.getModel_Name();
        setNcbAdapter(getYearDiffForNCB(etRegDate.getText().toString(), etExpDate.getText().toString()));
    }

    @Override
    public void OnFailure(Throwable t) {
        cancelDialog();
        Toast.makeText(getActivity(), "" + t.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                getActivity().finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public String changeDateFormat(String date) {

        SimpleDateFormat spf = new SimpleDateFormat("dd/MM/yyyy"); // 30/10/2010
        Date newDate = null;
        try {
            newDate = spf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return simpleDateFormat.format(newDate);
    }

    private String formatRegistrationNo(String regNo) {
        return "" + regNo.charAt(0) + regNo.charAt(1) + "-" + regNo.charAt(2) + regNo.charAt(3) + "-" + regNo.charAt(4) + regNo.charAt(5) + "-" + regNo.charAt(6) + regNo.charAt(7) + regNo.charAt(8) + regNo.charAt(9);
    }

    private void setNcbAdapter(int yearDiff) {
        if (yearDiff >= 5) {
            spNcbPercent.setSelection(5);
        } else {
            spNcbPercent.setSelection(yearDiff);
        }
    }

}
