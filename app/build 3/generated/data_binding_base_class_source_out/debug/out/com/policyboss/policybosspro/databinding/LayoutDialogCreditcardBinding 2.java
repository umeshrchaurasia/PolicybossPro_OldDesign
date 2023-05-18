// Generated by view binder compiler. Do not edit!
package com.policyboss.policybosspro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.policyboss.policybosspro.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class LayoutDialogCreditcardBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final RadioButton rbSalaried;

  @NonNull
  public final RadioButton rbSelf;

  @NonNull
  public final RecyclerView rvIncomeSlabs;

  private LayoutDialogCreditcardBinding(@NonNull LinearLayout rootView,
      @NonNull RadioButton rbSalaried, @NonNull RadioButton rbSelf,
      @NonNull RecyclerView rvIncomeSlabs) {
    this.rootView = rootView;
    this.rbSalaried = rbSalaried;
    this.rbSelf = rbSelf;
    this.rvIncomeSlabs = rvIncomeSlabs;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static LayoutDialogCreditcardBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static LayoutDialogCreditcardBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.layout_dialog_creditcard, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static LayoutDialogCreditcardBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.rbSalaried;
      RadioButton rbSalaried = rootView.findViewById(id);
      if (rbSalaried == null) {
        break missingId;
      }

      id = R.id.rbSelf;
      RadioButton rbSelf = rootView.findViewById(id);
      if (rbSelf == null) {
        break missingId;
      }

      id = R.id.rvIncomeSlabs;
      RecyclerView rvIncomeSlabs = rootView.findViewById(id);
      if (rvIncomeSlabs == null) {
        break missingId;
      }

      return new LayoutDialogCreditcardBinding((LinearLayout) rootView, rbSalaried, rbSelf,
          rvIncomeSlabs);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}