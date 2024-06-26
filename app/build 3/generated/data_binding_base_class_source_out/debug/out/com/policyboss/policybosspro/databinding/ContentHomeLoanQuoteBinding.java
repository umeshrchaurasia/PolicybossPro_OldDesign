// Generated by view binder compiler. Do not edit!
package com.policyboss.policybosspro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.policyboss.policybosspro.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ContentHomeLoanQuoteBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final CardView cvInputSummary;

  @NonNull
  public final ImageView ivEdit;

  @NonNull
  public final ImageView ivShare;

  @NonNull
  public final LinearLayout ivllEdit;

  @NonNull
  public final RecyclerView rvQuotes;

  @NonNull
  public final TextView txtCostOfProp;

  @NonNull
  public final TextView txtCount;

  @NonNull
  public final TextView txtExistEmi;

  @NonNull
  public final TextView txtInputSummary;

  @NonNull
  public final TextView txtLoanTenure;

  @NonNull
  public final TextView txtMonthlyIncome;

  @NonNull
  public final TextView txtOccupation;

  @NonNull
  public final TextView txtPropertyType;

  private ContentHomeLoanQuoteBinding(@NonNull LinearLayout rootView,
      @NonNull CardView cvInputSummary, @NonNull ImageView ivEdit, @NonNull ImageView ivShare,
      @NonNull LinearLayout ivllEdit, @NonNull RecyclerView rvQuotes,
      @NonNull TextView txtCostOfProp, @NonNull TextView txtCount, @NonNull TextView txtExistEmi,
      @NonNull TextView txtInputSummary, @NonNull TextView txtLoanTenure,
      @NonNull TextView txtMonthlyIncome, @NonNull TextView txtOccupation,
      @NonNull TextView txtPropertyType) {
    this.rootView = rootView;
    this.cvInputSummary = cvInputSummary;
    this.ivEdit = ivEdit;
    this.ivShare = ivShare;
    this.ivllEdit = ivllEdit;
    this.rvQuotes = rvQuotes;
    this.txtCostOfProp = txtCostOfProp;
    this.txtCount = txtCount;
    this.txtExistEmi = txtExistEmi;
    this.txtInputSummary = txtInputSummary;
    this.txtLoanTenure = txtLoanTenure;
    this.txtMonthlyIncome = txtMonthlyIncome;
    this.txtOccupation = txtOccupation;
    this.txtPropertyType = txtPropertyType;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ContentHomeLoanQuoteBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ContentHomeLoanQuoteBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.content_home_loan_quote, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ContentHomeLoanQuoteBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.cvInputSummary;
      CardView cvInputSummary = rootView.findViewById(id);
      if (cvInputSummary == null) {
        break missingId;
      }

      id = R.id.ivEdit;
      ImageView ivEdit = rootView.findViewById(id);
      if (ivEdit == null) {
        break missingId;
      }

      id = R.id.ivShare;
      ImageView ivShare = rootView.findViewById(id);
      if (ivShare == null) {
        break missingId;
      }

      id = R.id.ivllEdit;
      LinearLayout ivllEdit = rootView.findViewById(id);
      if (ivllEdit == null) {
        break missingId;
      }

      id = R.id.rvQuotes;
      RecyclerView rvQuotes = rootView.findViewById(id);
      if (rvQuotes == null) {
        break missingId;
      }

      id = R.id.txtCostOfProp;
      TextView txtCostOfProp = rootView.findViewById(id);
      if (txtCostOfProp == null) {
        break missingId;
      }

      id = R.id.txtCount;
      TextView txtCount = rootView.findViewById(id);
      if (txtCount == null) {
        break missingId;
      }

      id = R.id.txtExistEmi;
      TextView txtExistEmi = rootView.findViewById(id);
      if (txtExistEmi == null) {
        break missingId;
      }

      id = R.id.txtInputSummary;
      TextView txtInputSummary = rootView.findViewById(id);
      if (txtInputSummary == null) {
        break missingId;
      }

      id = R.id.txtLoanTenure;
      TextView txtLoanTenure = rootView.findViewById(id);
      if (txtLoanTenure == null) {
        break missingId;
      }

      id = R.id.txtMonthlyIncome;
      TextView txtMonthlyIncome = rootView.findViewById(id);
      if (txtMonthlyIncome == null) {
        break missingId;
      }

      id = R.id.txtOccupation;
      TextView txtOccupation = rootView.findViewById(id);
      if (txtOccupation == null) {
        break missingId;
      }

      id = R.id.txtPropertyType;
      TextView txtPropertyType = rootView.findViewById(id);
      if (txtPropertyType == null) {
        break missingId;
      }

      return new ContentHomeLoanQuoteBinding((LinearLayout) rootView, cvInputSummary, ivEdit,
          ivShare, ivllEdit, rvQuotes, txtCostOfProp, txtCount, txtExistEmi, txtInputSummary,
          txtLoanTenure, txtMonthlyIncome, txtOccupation, txtPropertyType);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
