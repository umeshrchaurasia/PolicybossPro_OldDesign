package com.datacomp.magicfinmart.onlineexpressloan;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.datacomp.magicfinmart.BaseActivity;
import com.datacomp.magicfinmart.R;

import com.datacomp.magicfinmart.utility.DateTimePicker;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController;
import magicfinmart.datacomp.com.finmartserviceapi.express_loan.controller.ExpressLoanController;
import magicfinmart.datacomp.com.finmartserviceapi.express_loan.requestentity.HdfcPers_SaveRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.express_loan.response.HdfcPers_SaveResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber;


public class HdfcpersonalloanActivity extends BaseActivity implements View.OnClickListener, IResponseSubcriber {


    CardView ccPersonal, ccCurrentAddress;
    CheckBox chkTermsCondition, chkSameAsAbove;
    Button btnhdfc;
    //personal detail
    EditText etCustomerName, etEmailPersContInfo, etDOB, etLoanAmount,
            etPincode,etPancard;
    EditText etCompany, etNetIncome,etyrs_of_emp ;
    EditText etMobileNo, etaltmobile, etLandline1, etLandline2,etOngoingEMI
            ,etcurrentaddress,etPermanentaddress;


    Spinner speducationList, spIncomeSource;
    TextView tvBankbranch;

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");


    ArrayAdapter<String> branchListAdapter;
    List<String> branchList;

    Spinner acCitybranchList;
    HdfcPers_SaveRequestEntity requestEntity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hdfcpersonalloan);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        init();
        setListener();
        requestEntity = new HdfcPers_SaveRequestEntity();

        branchList = new ArrayList<>();
        branchList = new DBPersistanceController(this).gethdfcpersonalloanbankbranchlist();

        branchBinding();

    }

    private void init() {
        acCitybranchList = (Spinner) findViewById(R.id.spbranchlocation);
        tvBankbranch = (TextView) findViewById(R.id.tvBankbranch);


        ccPersonal = (CardView) findViewById(R.id.ccPersonal);

        ccCurrentAddress = (CardView) findViewById(R.id.ccCurrentAddress);

        chkTermsCondition = (CheckBox) findViewById(R.id.chkTermsCondition);
        chkSameAsAbove = (CheckBox) findViewById(R.id.chkSameAsAbove);


        //region personal detail
        etCustomerName = (EditText) findViewById(R.id.etCustomerName);
        etDOB = (EditText) findViewById(R.id.etDOB);
        etEmailPersContInfo = (EditText) findViewById(R.id.etEmailPersContInfo);
        etLoanAmount = (EditText) findViewById(R.id.etLoanAmount);
        etyrs_of_emp = (EditText) findViewById(R.id.etyrs_of_emp);


        speducationList = (Spinner) findViewById(R.id.speducationList);
        spIncomeSource = (Spinner) findViewById(R.id.spIncomeSource);


        etPancard = (EditText) findViewById(R.id.etPancard);
        etPancard.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        //endregion

        //region company detail
        etCompany = (EditText) findViewById(R.id.etCompany);
        etNetIncome = (EditText) findViewById(R.id.etNetIncome);

        etMobileNo = (EditText) findViewById(R.id.etMobileNo);
        etaltmobile = (EditText) findViewById(R.id.etaltmobile);
        etLandline1 = (EditText) findViewById(R.id.etLandline1);
        etLandline2 = (EditText) findViewById(R.id.etLandline2);



        etPincode = (EditText) findViewById(R.id.etPincode);

        etOngoingEMI = (EditText) findViewById(R.id.etOngoingEMI);
        etcurrentaddress = (EditText) findViewById(R.id.etcurrentaddress);
        etPermanentaddress = (EditText) findViewById(R.id.etPermanentaddress);

        btnhdfc=(Button)findViewById(R.id.btnhdfc);

        //endregion
    }

    private void branchBinding() {
        branchListAdapter = new
                ArrayAdapter(this, android.R.layout.simple_list_item_1, branchList);
        acCitybranchList.setAdapter(branchListAdapter);

    }


    private void setListener() {
        etDOB.setOnClickListener(datePickerDialog);

        btnhdfc.setOnClickListener(this);

        chkSameAsAbove.setOnCheckedChangeListener(addressSameAsAbove);
        acCitybranchList.setOnItemSelectedListener(onItemSelectedListener);

    }

    CompoundButton.OnCheckedChangeListener addressSameAsAbove = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if (b) {
                bindAddress();
            } else {

                etPermanentaddress.setText("");

            }
        }
    };

    AdapterView.OnItemSelectedListener onItemSelectedListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {

            if (position > 0) {


               // String s2= gethdfcplbankbranchrListName(acCitybranchList.getSelectedItem().toString());
                tvBankbranch.setText( new DBPersistanceController(HdfcpersonalloanActivity.this).gethdfcplbankbranchrList(acCitybranchList.getSelectedItem().toString()));
            } else {
                tvBankbranch.setText("");
            }

        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };

    protected void bindAddress() {
        etPermanentaddress.setText(etcurrentaddress.getText().toString());
    }
    //region datepicker

    protected View.OnClickListener datePickerDialog = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            if (view.getId() == R.id.etDOB) {
                DateTimePicker.showHealthAgeDatePicker(view.getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view1, int year, int monthOfYear, int dayOfMonth) {
                        if (view1.isShown()) {
                            Calendar calendar = Calendar.getInstance();
                            calendar.set(year, monthOfYear, dayOfMonth);
                            String currentDay = simpleDateFormat.format(calendar.getTime());
                            etDOB.setText(currentDay);
                        }
                    }
                });
            }

        }
    };

    //endregion

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.btnhdfc) {

            if (chkTermsCondition.isChecked()) {

                //region validation personal

                if (!isEmpty(etCustomerName)) {
                    etCustomerName.setError("Enter Customer name");
                    etCustomerName.setFocusable(true);
                    return;
                } else {
                    etCustomerName.setError(null);
                }


                if (!isEmpty(etDOB)) {
                    etDOB.setError("Invalid birth date");
                    etDOB.setFocusable(true);
                    return;
                } else {
                    etDOB.setError(null);
                }


                if (!isEmpty(etLoanAmount)) {
                    etLoanAmount.setError("Enter Loan Amount");
                    etLoanAmount.setFocusable(true);
                    return;
                } else {
                    etLoanAmount.setError(null);
                }



                if (!isValidPan(etPancard)) {
                    etPancard.setError("Invalid Pan card");
                    etPancard.setFocusable(true);
                    return;
                } else {
                    etPancard.setError(null);
                }
                if (!isEmpty(etCompany)) {
                    etCompany.setError("Enter Company name");
                    etCompany.setFocusable(true);
                    return;
                } else {
                    etCompany.setError(null);
                }


                if (!isEmpty(etMobileNo)) {
                    etMobileNo.setError("Enter Mobile No");
                    etMobileNo.setFocusable(true);
                    return;
                } else {
                    etMobileNo.setError(null);
                }


//                if (speducationList.getSelectedItemPosition() == 0) {
//
//                    Toast.makeText(this, "Select No of Dependents", Toast.LENGTH_SHORT).show();
//                    return;
//                }

//                if (spIncomeSource.getSelectedItemPosition() == 0) {
//                    Toast.makeText(this, "Select Supplementary card", Toast.LENGTH_SHORT).show();
//                    return;
//                }

//                if (spTypeCompany.getSelectedItemPosition() == 0) {
//                    Toast.makeText(this, "Select Mailing address", Toast.LENGTH_SHORT).show();
//                    return;
//                }
                //endregion

                //region validation company


                if (!isValidePhoneNumber(etMobileNo)) {
                    etMobileNo.setError("Enter Designation");
                    etMobileNo.setFocusable(true);
                    return;
                } else {
                    etMobileNo.setError(null);
                }

//                if (!isValidePhoneNumber(etaltmobile)) {
//                    etaltmobile.setError("Enter Designation");
//                    etaltmobile.setFocusable(true);
//                    return;
//                } else {
//                    etaltmobile.setError(null);
//                }



//                if (!isValidePhoneNumber(etLandline1)) {
//                    etLandline1.setError("Invalid Mobile number");
//                    etLandline1.setFocusable(true);
//                    return;
//                } else {
//                    etLandline1.setError(null);
//                }
//                if (!isValidePhoneNumber(etLandline2)) {
//                    etLandline2.setError("Invalid Mobile number");
//                    etLandline2.setFocusable(true);
//                    return;
//                } else {
//                    etLandline2.setError(null);
//                }


//                if (spTypeCompany.getSelectedItemPosition() == 0) {
//                    Toast.makeText(this, "Select Type of company", Toast.LENGTH_SHORT).show();
//                    return;
//                }


                //endregion

                //region validation current address

                if (!isEmpty(etNetIncome)) {
                    etNetIncome.setError("Enter Net Income");
                    etNetIncome.setFocusable(true);
                    return;
                } else {
                    etNetIncome.setError(null);
                }

                if (!isEmpty(etyrs_of_emp)) {
                    etyrs_of_emp.setError("Enter No of Years in Employment");
                    etyrs_of_emp.setFocusable(true);
                    return;
                } else {
                    etyrs_of_emp.setError(null);
                }

                if (etPincode.getText().toString().length() < 6) {
                    etPincode.setError("Invalid Pincode");
                    etPincode.setFocusable(true);
                    return;
                } else {
                    etPincode.setError(null);
                }

                //endregion

                //region validation permanent address

                if (!isEmpty(etEmailPersContInfo)) {
                    etEmailPersContInfo.setError("Enter Email Address");
                    etEmailPersContInfo.setFocusable(true);
                    return;
                } else {
                    etEmailPersContInfo.setError(null);
                }
                if (!isValideEmailID(etEmailPersContInfo)) {
                    etEmailPersContInfo.setError("Invalid Email ID");
                    etEmailPersContInfo.setFocusable(true);
                    return;
                }
                if (!isEmpty(etcurrentaddress)) {
                    etcurrentaddress.setError("Enter Current Address");
                    etcurrentaddress.setFocusable(true);
                    return;
                } else {
                    etcurrentaddress.setError(null);
                }
                //endregion

                //region creating request
                requestEntity.setBranch_location(acCitybranchList.getSelectedItem().toString());
                requestEntity.setBranch_code(tvBankbranch.getText().toString());

                requestEntity.setDob(etDOB.getText().toString());
                requestEntity.setCustomer_name(etCustomerName.getText().toString());

                if(etLoanAmount.getText().toString().length() > 0)
                {
                    requestEntity.setLoanamount(etLoanAmount.getText().toString());
                }else
                {
                    requestEntity.setLoanamount("0");
                }
                requestEntity.setQualification(speducationList.getSelectedItem().toString());
                requestEntity.setPancard(etPancard.getText().toString());
                requestEntity.setCompany_name(etCompany.getText().toString());
                requestEntity.setProfile(spIncomeSource.getSelectedItem().toString());


                if(etMobileNo.getText().toString().length() > 0)
                {
                    requestEntity.setMobile_num(etMobileNo.getText().toString());
                }else {
                    requestEntity.setMobile_num("0");
                }

                if(etaltmobile.getText().toString().length() > 0)
                {
                    requestEntity.setAlternate_num(etaltmobile.getText().toString());
                }else {
                    requestEntity.setAlternate_num("0");
                }

                if(etLandline1.getText().toString().length() > 0)
                {
                    requestEntity.setLandline(etLandline1.getText().toString());
                }else {
                    requestEntity.setLandline("0");
                }

                if(etLandline2.getText().toString().length() > 0)
                {
                    requestEntity.setAlt_landline(etLandline2.getText().toString());
                }else {
                    requestEntity.setAlt_landline("0");
                }

                if(etNetIncome.getText().toString().length() > 0)
                {
                    requestEntity.setNet_income(etNetIncome.getText().toString());
                }else {
                    requestEntity.setNet_income("0");
                }


                requestEntity.setPincode(etPincode.getText().toString());


                requestEntity.setFBAID(String.valueOf(new DBPersistanceController(this).getUserData().getFBAId()));
                requestEntity.setBrokerid(new DBPersistanceController(this).getUserData().getLoanId());
                requestEntity.setEmpid("");

                requestEntity.setCampaignName("HDFC PL");
                requestEntity.setSource("");
                requestEntity.setLoanType("Personal Loan");
               requestEntity.setCity("");
                //personal detail

                requestEntity.setEmail(etEmailPersContInfo.getText().toString());


                if(etOngoingEMI.getText().toString().length() > 0)
                {
                    requestEntity.setEmi(etOngoingEMI.getText().toString());
                }else {
                    requestEntity.setEmi("0");
                }
                if(etyrs_of_emp.getText().toString().length() > 0)
                {
                    requestEntity.setYrs_of_emp(etyrs_of_emp.getText().toString());
                }else {
                    requestEntity.setYrs_of_emp("0");
                }

                requestEntity.setSame("on");

                requestEntity.setCurrent_add(etcurrentaddress.getText().toString());
                requestEntity.setPer_add(etPermanentaddress.getText().toString());

                //endregion

                showDialog();
                new ExpressLoanController(this).saveHDFCPersonalLoan(requestEntity, this);
            } else {
                Toast.makeText(this, "Accept Terms and Condtion", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void OnSuccess(APIResponse response, String message) {

        cancelDialog();
        if (response instanceof HdfcPers_SaveResponse) {
            if (response.getStatusNo() == 0) {
               // if (((HdfcPers_SaveResponse) response).get().getApplicationId().length() > 1) {
                    dialogMessage(true, ((HdfcPers_SaveResponse) response).getMessage(), response.getMessage());
               // } else {
               //     dialogMessage(false, "", ((HdfcPers_SaveResponse) response).getMessage());
               // }
            }
        }
    }

    @Override
    public void OnFailure(Throwable t) {
        cancelDialog();
        dialogMessage(false, t.getMessage(), "");
    }

    private void dialogMessage(final boolean isSuccess, String AppNo, String displayMessage) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);

        StringBuilder Message = new StringBuilder();
        if (isSuccess) {
            builder.setTitle("Applied Successfully..!");
            String strMessage = "Application No:" + AppNo + "\n\n";
            String success = displayMessage;
            Message.append(strMessage + success);

        } else {
            builder.setTitle("Failed ");
            String failure = AppNo;
            Message.append(failure);
        }
        builder.setMessage(Message.toString())
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                        if (isSuccess) {
                            finish();
                        }

                    }
                });

        AlertDialog dialog = builder.create();
        dialog.show();
        TextView msgTxt = (TextView) dialog.findViewById(android.R.id.message);
        msgTxt.setTextSize(12.0f);
    }

}