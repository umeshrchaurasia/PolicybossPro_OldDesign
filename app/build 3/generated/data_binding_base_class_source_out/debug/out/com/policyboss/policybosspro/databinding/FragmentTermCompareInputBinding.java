// Generated by view binder compiler. Do not edit!
package com.policyboss.policybosspro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.policyboss.policybosspro.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentTermCompareInputBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final Button btnGetQuote;

  @NonNull
  public final CardView cvInputDetails;

  @NonNull
  public final EditText etPincode;

  @NonNull
  public final EditText etSumAssured;

  @NonNull
  public final ImageView ivEdit;

  @NonNull
  public final ContentTermHeaderBinding layoutCompare;

  @NonNull
  public final LinearLayout llCompareAll;

  @NonNull
  public final NestedScrollView mainScroll;

  @NonNull
  public final RecyclerView rvTerm;

  @NonNull
  public final Spinner spPolicyTerm;

  @NonNull
  public final Spinner spPremTerm;

  @NonNull
  public final TextView tvAge;

  @NonNull
  public final TextView tvCrn;

  @NonNull
  public final TextView tvGender;

  @NonNull
  public final TextView tvPolicyTerm;

  @NonNull
  public final TextView tvSmoker;

  @NonNull
  public final TextView tvSum;

  private FragmentTermCompareInputBinding(@NonNull LinearLayout rootView,
      @NonNull Button btnGetQuote, @NonNull CardView cvInputDetails, @NonNull EditText etPincode,
      @NonNull EditText etSumAssured, @NonNull ImageView ivEdit,
      @NonNull ContentTermHeaderBinding layoutCompare, @NonNull LinearLayout llCompareAll,
      @NonNull NestedScrollView mainScroll, @NonNull RecyclerView rvTerm,
      @NonNull Spinner spPolicyTerm, @NonNull Spinner spPremTerm, @NonNull TextView tvAge,
      @NonNull TextView tvCrn, @NonNull TextView tvGender, @NonNull TextView tvPolicyTerm,
      @NonNull TextView tvSmoker, @NonNull TextView tvSum) {
    this.rootView = rootView;
    this.btnGetQuote = btnGetQuote;
    this.cvInputDetails = cvInputDetails;
    this.etPincode = etPincode;
    this.etSumAssured = etSumAssured;
    this.ivEdit = ivEdit;
    this.layoutCompare = layoutCompare;
    this.llCompareAll = llCompareAll;
    this.mainScroll = mainScroll;
    this.rvTerm = rvTerm;
    this.spPolicyTerm = spPolicyTerm;
    this.spPremTerm = spPremTerm;
    this.tvAge = tvAge;
    this.tvCrn = tvCrn;
    this.tvGender = tvGender;
    this.tvPolicyTerm = tvPolicyTerm;
    this.tvSmoker = tvSmoker;
    this.tvSum = tvSum;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentTermCompareInputBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentTermCompareInputBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_term_compare_input, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentTermCompareInputBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnGetQuote;
      Button btnGetQuote = rootView.findViewById(id);
      if (btnGetQuote == null) {
        break missingId;
      }

      id = R.id.cvInputDetails;
      CardView cvInputDetails = rootView.findViewById(id);
      if (cvInputDetails == null) {
        break missingId;
      }

      id = R.id.etPincode;
      EditText etPincode = rootView.findViewById(id);
      if (etPincode == null) {
        break missingId;
      }

      id = R.id.etSumAssured;
      EditText etSumAssured = rootView.findViewById(id);
      if (etSumAssured == null) {
        break missingId;
      }

      id = R.id.ivEdit;
      ImageView ivEdit = rootView.findViewById(id);
      if (ivEdit == null) {
        break missingId;
      }

      id = R.id.layoutCompare;
      View layoutCompare = rootView.findViewById(id);
      if (layoutCompare == null) {
        break missingId;
      }
      ContentTermHeaderBinding binding_layoutCompare = ContentTermHeaderBinding.bind(layoutCompare);

      id = R.id.llCompareAll;
      LinearLayout llCompareAll = rootView.findViewById(id);
      if (llCompareAll == null) {
        break missingId;
      }

      id = R.id.mainScroll;
      NestedScrollView mainScroll = rootView.findViewById(id);
      if (mainScroll == null) {
        break missingId;
      }

      id = R.id.rvTerm;
      RecyclerView rvTerm = rootView.findViewById(id);
      if (rvTerm == null) {
        break missingId;
      }

      id = R.id.spPolicyTerm;
      Spinner spPolicyTerm = rootView.findViewById(id);
      if (spPolicyTerm == null) {
        break missingId;
      }

      id = R.id.spPremTerm;
      Spinner spPremTerm = rootView.findViewById(id);
      if (spPremTerm == null) {
        break missingId;
      }

      id = R.id.tvAge;
      TextView tvAge = rootView.findViewById(id);
      if (tvAge == null) {
        break missingId;
      }

      id = R.id.tvCrn;
      TextView tvCrn = rootView.findViewById(id);
      if (tvCrn == null) {
        break missingId;
      }

      id = R.id.tvGender;
      TextView tvGender = rootView.findViewById(id);
      if (tvGender == null) {
        break missingId;
      }

      id = R.id.tvPolicyTerm;
      TextView tvPolicyTerm = rootView.findViewById(id);
      if (tvPolicyTerm == null) {
        break missingId;
      }

      id = R.id.tvSmoker;
      TextView tvSmoker = rootView.findViewById(id);
      if (tvSmoker == null) {
        break missingId;
      }

      id = R.id.tvSum;
      TextView tvSum = rootView.findViewById(id);
      if (tvSum == null) {
        break missingId;
      }

      return new FragmentTermCompareInputBinding((LinearLayout) rootView, btnGetQuote,
          cvInputDetails, etPincode, etSumAssured, ivEdit, binding_layoutCompare, llCompareAll,
          mainScroll, rvTerm, spPolicyTerm, spPremTerm, tvAge, tvCrn, tvGender, tvPolicyTerm,
          tvSmoker, tvSum);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
