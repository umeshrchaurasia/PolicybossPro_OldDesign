// Generated by view binder compiler. Do not edit!
package com.policyboss.policybosspro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.textfield.TextInputLayout;
import com.policyboss.policybosspro.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityIciciCreditapplyBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final AutoCompleteTextView acCity;

  @NonNull
  public final AutoCompleteTextView acPerCity;

  @NonNull
  public final AutoCompleteTextView acPerState;

  @NonNull
  public final AutoCompleteTextView acState;

  @NonNull
  public final Button btnICICINext;

  @NonNull
  public final CardView ccCompantDetail;

  @NonNull
  public final CardView ccContactDetail;

  @NonNull
  public final CardView ccCurrentAddress;

  @NonNull
  public final CardView ccPersonal;

  @NonNull
  public final CheckBox chkSameAsAbove;

  @NonNull
  public final CheckBox chkTermsCondition;

  @NonNull
  public final EditText etArea;

  @NonNull
  public final EditText etAreaCode;

  @NonNull
  public final EditText etBankName;

  @NonNull
  public final EditText etBuildingName;

  @NonNull
  public final EditText etCardName;

  @NonNull
  public final AutoCompleteTextView etCompany;

  @NonNull
  public final EditText etCreditLimit;

  @NonNull
  public final EditText etDOB;

  @NonNull
  public final EditText etDesignation;

  @NonNull
  public final EditText etFirstName;

  @NonNull
  public final EditText etFlatNo;

  @NonNull
  public final EditText etICICINumber;

  @NonNull
  public final EditText etIncome;

  @NonNull
  public final EditText etLastName;

  @NonNull
  public final EditText etMemberSince;

  @NonNull
  public final EditText etMobileNo;

  @NonNull
  public final EditText etMotherName;

  @NonNull
  public final EditText etPancard;

  @NonNull
  public final EditText etPerArea;

  @NonNull
  public final EditText etPerBuildingName;

  @NonNull
  public final EditText etPerEmail;

  @NonNull
  public final EditText etPerFlatNo;

  @NonNull
  public final EditText etPerPincode;

  @NonNull
  public final EditText etPhoneNumber;

  @NonNull
  public final EditText etPincode;

  @NonNull
  public final EditText etStdCode;

  @NonNull
  public final EditText etTelephoneNo;

  @NonNull
  public final EditText etTotalExp;

  @NonNull
  public final EditText etWorkEmail;

  @NonNull
  public final RadioButton rbHaveCC;

  @NonNull
  public final RadioButton rbHaveNoCC;

  @NonNull
  public final RadioButton rbIndian;

  @NonNull
  public final RadioButton rbNo;

  @NonNull
  public final RadioButton rbSalaried;

  @NonNull
  public final RadioButton rbSavingAccYes;

  @NonNull
  public final RadioButton rbSelfEmployed;

  @NonNull
  public final RadioButton rbSingle;

  @NonNull
  public final RadioButton rbfemale;

  @NonNull
  public final RadioButton rbmale;

  @NonNull
  public final RadioGroup rgGender;

  @NonNull
  public final Spinner spICICIRelationShip;

  @NonNull
  public final Spinner spMailingAddress;

  @NonNull
  public final Spinner spNoOfDependents;

  @NonNull
  public final Spinner spPerResidenceType;

  @NonNull
  public final Spinner spQualification;

  @NonNull
  public final Spinner spResidenceType;

  @NonNull
  public final Spinner spSalaryAccountType;

  @NonNull
  public final Spinner spSupplementaryCard;

  @NonNull
  public final Spinner spTypeCompany;

  @NonNull
  public final TextInputLayout tlBank;

  @NonNull
  public final TextInputLayout tlCreditLimit;

  @NonNull
  public final TextInputLayout tlMemberSince;

  @NonNull
  public final Toolbar toolbar;

  @NonNull
  public final TextView txtEmploymentType;

  private ActivityIciciCreditapplyBinding(@NonNull LinearLayout rootView,
      @NonNull AutoCompleteTextView acCity, @NonNull AutoCompleteTextView acPerCity,
      @NonNull AutoCompleteTextView acPerState, @NonNull AutoCompleteTextView acState,
      @NonNull Button btnICICINext, @NonNull CardView ccCompantDetail,
      @NonNull CardView ccContactDetail, @NonNull CardView ccCurrentAddress,
      @NonNull CardView ccPersonal, @NonNull CheckBox chkSameAsAbove,
      @NonNull CheckBox chkTermsCondition, @NonNull EditText etArea, @NonNull EditText etAreaCode,
      @NonNull EditText etBankName, @NonNull EditText etBuildingName, @NonNull EditText etCardName,
      @NonNull AutoCompleteTextView etCompany, @NonNull EditText etCreditLimit,
      @NonNull EditText etDOB, @NonNull EditText etDesignation, @NonNull EditText etFirstName,
      @NonNull EditText etFlatNo, @NonNull EditText etICICINumber, @NonNull EditText etIncome,
      @NonNull EditText etLastName, @NonNull EditText etMemberSince, @NonNull EditText etMobileNo,
      @NonNull EditText etMotherName, @NonNull EditText etPancard, @NonNull EditText etPerArea,
      @NonNull EditText etPerBuildingName, @NonNull EditText etPerEmail,
      @NonNull EditText etPerFlatNo, @NonNull EditText etPerPincode,
      @NonNull EditText etPhoneNumber, @NonNull EditText etPincode, @NonNull EditText etStdCode,
      @NonNull EditText etTelephoneNo, @NonNull EditText etTotalExp, @NonNull EditText etWorkEmail,
      @NonNull RadioButton rbHaveCC, @NonNull RadioButton rbHaveNoCC, @NonNull RadioButton rbIndian,
      @NonNull RadioButton rbNo, @NonNull RadioButton rbSalaried,
      @NonNull RadioButton rbSavingAccYes, @NonNull RadioButton rbSelfEmployed,
      @NonNull RadioButton rbSingle, @NonNull RadioButton rbfemale, @NonNull RadioButton rbmale,
      @NonNull RadioGroup rgGender, @NonNull Spinner spICICIRelationShip,
      @NonNull Spinner spMailingAddress, @NonNull Spinner spNoOfDependents,
      @NonNull Spinner spPerResidenceType, @NonNull Spinner spQualification,
      @NonNull Spinner spResidenceType, @NonNull Spinner spSalaryAccountType,
      @NonNull Spinner spSupplementaryCard, @NonNull Spinner spTypeCompany,
      @NonNull TextInputLayout tlBank, @NonNull TextInputLayout tlCreditLimit,
      @NonNull TextInputLayout tlMemberSince, @NonNull Toolbar toolbar,
      @NonNull TextView txtEmploymentType) {
    this.rootView = rootView;
    this.acCity = acCity;
    this.acPerCity = acPerCity;
    this.acPerState = acPerState;
    this.acState = acState;
    this.btnICICINext = btnICICINext;
    this.ccCompantDetail = ccCompantDetail;
    this.ccContactDetail = ccContactDetail;
    this.ccCurrentAddress = ccCurrentAddress;
    this.ccPersonal = ccPersonal;
    this.chkSameAsAbove = chkSameAsAbove;
    this.chkTermsCondition = chkTermsCondition;
    this.etArea = etArea;
    this.etAreaCode = etAreaCode;
    this.etBankName = etBankName;
    this.etBuildingName = etBuildingName;
    this.etCardName = etCardName;
    this.etCompany = etCompany;
    this.etCreditLimit = etCreditLimit;
    this.etDOB = etDOB;
    this.etDesignation = etDesignation;
    this.etFirstName = etFirstName;
    this.etFlatNo = etFlatNo;
    this.etICICINumber = etICICINumber;
    this.etIncome = etIncome;
    this.etLastName = etLastName;
    this.etMemberSince = etMemberSince;
    this.etMobileNo = etMobileNo;
    this.etMotherName = etMotherName;
    this.etPancard = etPancard;
    this.etPerArea = etPerArea;
    this.etPerBuildingName = etPerBuildingName;
    this.etPerEmail = etPerEmail;
    this.etPerFlatNo = etPerFlatNo;
    this.etPerPincode = etPerPincode;
    this.etPhoneNumber = etPhoneNumber;
    this.etPincode = etPincode;
    this.etStdCode = etStdCode;
    this.etTelephoneNo = etTelephoneNo;
    this.etTotalExp = etTotalExp;
    this.etWorkEmail = etWorkEmail;
    this.rbHaveCC = rbHaveCC;
    this.rbHaveNoCC = rbHaveNoCC;
    this.rbIndian = rbIndian;
    this.rbNo = rbNo;
    this.rbSalaried = rbSalaried;
    this.rbSavingAccYes = rbSavingAccYes;
    this.rbSelfEmployed = rbSelfEmployed;
    this.rbSingle = rbSingle;
    this.rbfemale = rbfemale;
    this.rbmale = rbmale;
    this.rgGender = rgGender;
    this.spICICIRelationShip = spICICIRelationShip;
    this.spMailingAddress = spMailingAddress;
    this.spNoOfDependents = spNoOfDependents;
    this.spPerResidenceType = spPerResidenceType;
    this.spQualification = spQualification;
    this.spResidenceType = spResidenceType;
    this.spSalaryAccountType = spSalaryAccountType;
    this.spSupplementaryCard = spSupplementaryCard;
    this.spTypeCompany = spTypeCompany;
    this.tlBank = tlBank;
    this.tlCreditLimit = tlCreditLimit;
    this.tlMemberSince = tlMemberSince;
    this.toolbar = toolbar;
    this.txtEmploymentType = txtEmploymentType;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityIciciCreditapplyBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityIciciCreditapplyBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_icici_creditapply, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityIciciCreditapplyBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.acCity;
      AutoCompleteTextView acCity = rootView.findViewById(id);
      if (acCity == null) {
        break missingId;
      }

      id = R.id.acPerCity;
      AutoCompleteTextView acPerCity = rootView.findViewById(id);
      if (acPerCity == null) {
        break missingId;
      }

      id = R.id.acPerState;
      AutoCompleteTextView acPerState = rootView.findViewById(id);
      if (acPerState == null) {
        break missingId;
      }

      id = R.id.acState;
      AutoCompleteTextView acState = rootView.findViewById(id);
      if (acState == null) {
        break missingId;
      }

      id = R.id.btnICICINext;
      Button btnICICINext = rootView.findViewById(id);
      if (btnICICINext == null) {
        break missingId;
      }

      id = R.id.ccCompantDetail;
      CardView ccCompantDetail = rootView.findViewById(id);
      if (ccCompantDetail == null) {
        break missingId;
      }

      id = R.id.ccContactDetail;
      CardView ccContactDetail = rootView.findViewById(id);
      if (ccContactDetail == null) {
        break missingId;
      }

      id = R.id.ccCurrentAddress;
      CardView ccCurrentAddress = rootView.findViewById(id);
      if (ccCurrentAddress == null) {
        break missingId;
      }

      id = R.id.ccPersonal;
      CardView ccPersonal = rootView.findViewById(id);
      if (ccPersonal == null) {
        break missingId;
      }

      id = R.id.chkSameAsAbove;
      CheckBox chkSameAsAbove = rootView.findViewById(id);
      if (chkSameAsAbove == null) {
        break missingId;
      }

      id = R.id.chkTermsCondition;
      CheckBox chkTermsCondition = rootView.findViewById(id);
      if (chkTermsCondition == null) {
        break missingId;
      }

      id = R.id.etArea;
      EditText etArea = rootView.findViewById(id);
      if (etArea == null) {
        break missingId;
      }

      id = R.id.etAreaCode;
      EditText etAreaCode = rootView.findViewById(id);
      if (etAreaCode == null) {
        break missingId;
      }

      id = R.id.etBankName;
      EditText etBankName = rootView.findViewById(id);
      if (etBankName == null) {
        break missingId;
      }

      id = R.id.etBuildingName;
      EditText etBuildingName = rootView.findViewById(id);
      if (etBuildingName == null) {
        break missingId;
      }

      id = R.id.etCardName;
      EditText etCardName = rootView.findViewById(id);
      if (etCardName == null) {
        break missingId;
      }

      id = R.id.etCompany;
      AutoCompleteTextView etCompany = rootView.findViewById(id);
      if (etCompany == null) {
        break missingId;
      }

      id = R.id.etCreditLimit;
      EditText etCreditLimit = rootView.findViewById(id);
      if (etCreditLimit == null) {
        break missingId;
      }

      id = R.id.etDOB;
      EditText etDOB = rootView.findViewById(id);
      if (etDOB == null) {
        break missingId;
      }

      id = R.id.etDesignation;
      EditText etDesignation = rootView.findViewById(id);
      if (etDesignation == null) {
        break missingId;
      }

      id = R.id.etFirstName;
      EditText etFirstName = rootView.findViewById(id);
      if (etFirstName == null) {
        break missingId;
      }

      id = R.id.etFlatNo;
      EditText etFlatNo = rootView.findViewById(id);
      if (etFlatNo == null) {
        break missingId;
      }

      id = R.id.etICICINumber;
      EditText etICICINumber = rootView.findViewById(id);
      if (etICICINumber == null) {
        break missingId;
      }

      id = R.id.etIncome;
      EditText etIncome = rootView.findViewById(id);
      if (etIncome == null) {
        break missingId;
      }

      id = R.id.etLastName;
      EditText etLastName = rootView.findViewById(id);
      if (etLastName == null) {
        break missingId;
      }

      id = R.id.etMemberSince;
      EditText etMemberSince = rootView.findViewById(id);
      if (etMemberSince == null) {
        break missingId;
      }

      id = R.id.etMobileNo;
      EditText etMobileNo = rootView.findViewById(id);
      if (etMobileNo == null) {
        break missingId;
      }

      id = R.id.etMotherName;
      EditText etMotherName = rootView.findViewById(id);
      if (etMotherName == null) {
        break missingId;
      }

      id = R.id.etPancard;
      EditText etPancard = rootView.findViewById(id);
      if (etPancard == null) {
        break missingId;
      }

      id = R.id.etPerArea;
      EditText etPerArea = rootView.findViewById(id);
      if (etPerArea == null) {
        break missingId;
      }

      id = R.id.etPerBuildingName;
      EditText etPerBuildingName = rootView.findViewById(id);
      if (etPerBuildingName == null) {
        break missingId;
      }

      id = R.id.etPerEmail;
      EditText etPerEmail = rootView.findViewById(id);
      if (etPerEmail == null) {
        break missingId;
      }

      id = R.id.etPerFlatNo;
      EditText etPerFlatNo = rootView.findViewById(id);
      if (etPerFlatNo == null) {
        break missingId;
      }

      id = R.id.etPerPincode;
      EditText etPerPincode = rootView.findViewById(id);
      if (etPerPincode == null) {
        break missingId;
      }

      id = R.id.etPhoneNumber;
      EditText etPhoneNumber = rootView.findViewById(id);
      if (etPhoneNumber == null) {
        break missingId;
      }

      id = R.id.etPincode;
      EditText etPincode = rootView.findViewById(id);
      if (etPincode == null) {
        break missingId;
      }

      id = R.id.etStdCode;
      EditText etStdCode = rootView.findViewById(id);
      if (etStdCode == null) {
        break missingId;
      }

      id = R.id.etTelephoneNo;
      EditText etTelephoneNo = rootView.findViewById(id);
      if (etTelephoneNo == null) {
        break missingId;
      }

      id = R.id.etTotalExp;
      EditText etTotalExp = rootView.findViewById(id);
      if (etTotalExp == null) {
        break missingId;
      }

      id = R.id.etWorkEmail;
      EditText etWorkEmail = rootView.findViewById(id);
      if (etWorkEmail == null) {
        break missingId;
      }

      id = R.id.rbHaveCC;
      RadioButton rbHaveCC = rootView.findViewById(id);
      if (rbHaveCC == null) {
        break missingId;
      }

      id = R.id.rbHaveNoCC;
      RadioButton rbHaveNoCC = rootView.findViewById(id);
      if (rbHaveNoCC == null) {
        break missingId;
      }

      id = R.id.rbIndian;
      RadioButton rbIndian = rootView.findViewById(id);
      if (rbIndian == null) {
        break missingId;
      }

      id = R.id.rbNo;
      RadioButton rbNo = rootView.findViewById(id);
      if (rbNo == null) {
        break missingId;
      }

      id = R.id.rbSalaried;
      RadioButton rbSalaried = rootView.findViewById(id);
      if (rbSalaried == null) {
        break missingId;
      }

      id = R.id.rbSavingAccYes;
      RadioButton rbSavingAccYes = rootView.findViewById(id);
      if (rbSavingAccYes == null) {
        break missingId;
      }

      id = R.id.rbSelfEmployed;
      RadioButton rbSelfEmployed = rootView.findViewById(id);
      if (rbSelfEmployed == null) {
        break missingId;
      }

      id = R.id.rbSingle;
      RadioButton rbSingle = rootView.findViewById(id);
      if (rbSingle == null) {
        break missingId;
      }

      id = R.id.rbfemale;
      RadioButton rbfemale = rootView.findViewById(id);
      if (rbfemale == null) {
        break missingId;
      }

      id = R.id.rbmale;
      RadioButton rbmale = rootView.findViewById(id);
      if (rbmale == null) {
        break missingId;
      }

      id = R.id.rgGender;
      RadioGroup rgGender = rootView.findViewById(id);
      if (rgGender == null) {
        break missingId;
      }

      id = R.id.spICICIRelationShip;
      Spinner spICICIRelationShip = rootView.findViewById(id);
      if (spICICIRelationShip == null) {
        break missingId;
      }

      id = R.id.spMailingAddress;
      Spinner spMailingAddress = rootView.findViewById(id);
      if (spMailingAddress == null) {
        break missingId;
      }

      id = R.id.spNoOfDependents;
      Spinner spNoOfDependents = rootView.findViewById(id);
      if (spNoOfDependents == null) {
        break missingId;
      }

      id = R.id.spPerResidenceType;
      Spinner spPerResidenceType = rootView.findViewById(id);
      if (spPerResidenceType == null) {
        break missingId;
      }

      id = R.id.spQualification;
      Spinner spQualification = rootView.findViewById(id);
      if (spQualification == null) {
        break missingId;
      }

      id = R.id.spResidenceType;
      Spinner spResidenceType = rootView.findViewById(id);
      if (spResidenceType == null) {
        break missingId;
      }

      id = R.id.spSalaryAccountType;
      Spinner spSalaryAccountType = rootView.findViewById(id);
      if (spSalaryAccountType == null) {
        break missingId;
      }

      id = R.id.spSupplementaryCard;
      Spinner spSupplementaryCard = rootView.findViewById(id);
      if (spSupplementaryCard == null) {
        break missingId;
      }

      id = R.id.spTypeCompany;
      Spinner spTypeCompany = rootView.findViewById(id);
      if (spTypeCompany == null) {
        break missingId;
      }

      id = R.id.tlBank;
      TextInputLayout tlBank = rootView.findViewById(id);
      if (tlBank == null) {
        break missingId;
      }

      id = R.id.tlCreditLimit;
      TextInputLayout tlCreditLimit = rootView.findViewById(id);
      if (tlCreditLimit == null) {
        break missingId;
      }

      id = R.id.tlMemberSince;
      TextInputLayout tlMemberSince = rootView.findViewById(id);
      if (tlMemberSince == null) {
        break missingId;
      }

      id = R.id.toolbar;
      Toolbar toolbar = rootView.findViewById(id);
      if (toolbar == null) {
        break missingId;
      }

      id = R.id.txtEmploymentType;
      TextView txtEmploymentType = rootView.findViewById(id);
      if (txtEmploymentType == null) {
        break missingId;
      }

      return new ActivityIciciCreditapplyBinding((LinearLayout) rootView, acCity, acPerCity,
          acPerState, acState, btnICICINext, ccCompantDetail, ccContactDetail, ccCurrentAddress,
          ccPersonal, chkSameAsAbove, chkTermsCondition, etArea, etAreaCode, etBankName,
          etBuildingName, etCardName, etCompany, etCreditLimit, etDOB, etDesignation, etFirstName,
          etFlatNo, etICICINumber, etIncome, etLastName, etMemberSince, etMobileNo, etMotherName,
          etPancard, etPerArea, etPerBuildingName, etPerEmail, etPerFlatNo, etPerPincode,
          etPhoneNumber, etPincode, etStdCode, etTelephoneNo, etTotalExp, etWorkEmail, rbHaveCC,
          rbHaveNoCC, rbIndian, rbNo, rbSalaried, rbSavingAccYes, rbSelfEmployed, rbSingle,
          rbfemale, rbmale, rgGender, spICICIRelationShip, spMailingAddress, spNoOfDependents,
          spPerResidenceType, spQualification, spResidenceType, spSalaryAccountType,
          spSupplementaryCard, spTypeCompany, tlBank, tlCreditLimit, tlMemberSince, toolbar,
          txtEmploymentType);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
