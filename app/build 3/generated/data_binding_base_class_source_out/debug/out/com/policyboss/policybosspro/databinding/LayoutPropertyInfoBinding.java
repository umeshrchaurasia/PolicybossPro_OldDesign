// Generated by view binder compiler. Do not edit!
package com.policyboss.policybosspro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.policyboss.policybosspro.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class LayoutPropertyInfoBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final AutoCompleteTextView acCity;

  @NonNull
  public final EditText etContact;

  @NonNull
  public final EditText etCostOfProp;

  @NonNull
  public final TextView etTenureInYear;

  @NonNull
  public final RadioButton rbForcons;

  @NonNull
  public final RadioButton rbOther;

  @NonNull
  public final RadioButton rbReady;

  @NonNull
  public final RadioButton rbResale;

  @NonNull
  public final RadioButton rbSearching;

  @NonNull
  public final RadioButton rbUnder;

  @NonNull
  public final RadioGroup rgProperty1;

  @NonNull
  public final RadioGroup rgProperty2;

  @NonNull
  public final SeekBar sbTenure;

  @NonNull
  public final TextView txtApplicantDetail;

  @NonNull
  public final TextView txtDispalayMaxTenureYear;

  @NonNull
  public final TextView txtDispalayMinTenureYear;

  @NonNull
  public final EditText txtMaxLoanAmntAllow;

  private LayoutPropertyInfoBinding(@NonNull LinearLayout rootView,
      @NonNull AutoCompleteTextView acCity, @NonNull EditText etContact,
      @NonNull EditText etCostOfProp, @NonNull TextView etTenureInYear,
      @NonNull RadioButton rbForcons, @NonNull RadioButton rbOther, @NonNull RadioButton rbReady,
      @NonNull RadioButton rbResale, @NonNull RadioButton rbSearching, @NonNull RadioButton rbUnder,
      @NonNull RadioGroup rgProperty1, @NonNull RadioGroup rgProperty2, @NonNull SeekBar sbTenure,
      @NonNull TextView txtApplicantDetail, @NonNull TextView txtDispalayMaxTenureYear,
      @NonNull TextView txtDispalayMinTenureYear, @NonNull EditText txtMaxLoanAmntAllow) {
    this.rootView = rootView;
    this.acCity = acCity;
    this.etContact = etContact;
    this.etCostOfProp = etCostOfProp;
    this.etTenureInYear = etTenureInYear;
    this.rbForcons = rbForcons;
    this.rbOther = rbOther;
    this.rbReady = rbReady;
    this.rbResale = rbResale;
    this.rbSearching = rbSearching;
    this.rbUnder = rbUnder;
    this.rgProperty1 = rgProperty1;
    this.rgProperty2 = rgProperty2;
    this.sbTenure = sbTenure;
    this.txtApplicantDetail = txtApplicantDetail;
    this.txtDispalayMaxTenureYear = txtDispalayMaxTenureYear;
    this.txtDispalayMinTenureYear = txtDispalayMinTenureYear;
    this.txtMaxLoanAmntAllow = txtMaxLoanAmntAllow;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static LayoutPropertyInfoBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static LayoutPropertyInfoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.layout_property_info, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static LayoutPropertyInfoBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.acCity;
      AutoCompleteTextView acCity = rootView.findViewById(id);
      if (acCity == null) {
        break missingId;
      }

      id = R.id.etContact;
      EditText etContact = rootView.findViewById(id);
      if (etContact == null) {
        break missingId;
      }

      id = R.id.etCostOfProp;
      EditText etCostOfProp = rootView.findViewById(id);
      if (etCostOfProp == null) {
        break missingId;
      }

      id = R.id.etTenureInYear;
      TextView etTenureInYear = rootView.findViewById(id);
      if (etTenureInYear == null) {
        break missingId;
      }

      id = R.id.rbForcons;
      RadioButton rbForcons = rootView.findViewById(id);
      if (rbForcons == null) {
        break missingId;
      }

      id = R.id.rbOther;
      RadioButton rbOther = rootView.findViewById(id);
      if (rbOther == null) {
        break missingId;
      }

      id = R.id.rbReady;
      RadioButton rbReady = rootView.findViewById(id);
      if (rbReady == null) {
        break missingId;
      }

      id = R.id.rbResale;
      RadioButton rbResale = rootView.findViewById(id);
      if (rbResale == null) {
        break missingId;
      }

      id = R.id.rbSearching;
      RadioButton rbSearching = rootView.findViewById(id);
      if (rbSearching == null) {
        break missingId;
      }

      id = R.id.rbUnder;
      RadioButton rbUnder = rootView.findViewById(id);
      if (rbUnder == null) {
        break missingId;
      }

      id = R.id.rgProperty1;
      RadioGroup rgProperty1 = rootView.findViewById(id);
      if (rgProperty1 == null) {
        break missingId;
      }

      id = R.id.rgProperty2;
      RadioGroup rgProperty2 = rootView.findViewById(id);
      if (rgProperty2 == null) {
        break missingId;
      }

      id = R.id.sbTenure;
      SeekBar sbTenure = rootView.findViewById(id);
      if (sbTenure == null) {
        break missingId;
      }

      id = R.id.txtApplicantDetail;
      TextView txtApplicantDetail = rootView.findViewById(id);
      if (txtApplicantDetail == null) {
        break missingId;
      }

      id = R.id.txtDispalayMaxTenureYear;
      TextView txtDispalayMaxTenureYear = rootView.findViewById(id);
      if (txtDispalayMaxTenureYear == null) {
        break missingId;
      }

      id = R.id.txtDispalayMinTenureYear;
      TextView txtDispalayMinTenureYear = rootView.findViewById(id);
      if (txtDispalayMinTenureYear == null) {
        break missingId;
      }

      id = R.id.txtMaxLoanAmntAllow;
      EditText txtMaxLoanAmntAllow = rootView.findViewById(id);
      if (txtMaxLoanAmntAllow == null) {
        break missingId;
      }

      return new LayoutPropertyInfoBinding((LinearLayout) rootView, acCity, etContact, etCostOfProp,
          etTenureInYear, rbForcons, rbOther, rbReady, rbResale, rbSearching, rbUnder, rgProperty1,
          rgProperty2, sbTenure, txtApplicantDetail, txtDispalayMaxTenureYear,
          txtDispalayMinTenureYear, txtMaxLoanAmntAllow);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
