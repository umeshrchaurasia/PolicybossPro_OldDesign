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
import androidx.viewbinding.ViewBinding;
import com.policyboss.policybosspro.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class LayoutHealthItemQuoteBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final LinearLayout llFooter;

  @NonNull
  public final ImageView txtOverflowMenu;

  @NonNull
  public final TextView txtPersonName;

  @NonNull
  public final TextView txtQuoteDate;

  @NonNull
  public final TextView txtSumAssured;

  @NonNull
  public final TextView txtVehicleName;

  private LayoutHealthItemQuoteBinding(@NonNull LinearLayout rootView,
      @NonNull LinearLayout llFooter, @NonNull ImageView txtOverflowMenu,
      @NonNull TextView txtPersonName, @NonNull TextView txtQuoteDate,
      @NonNull TextView txtSumAssured, @NonNull TextView txtVehicleName) {
    this.rootView = rootView;
    this.llFooter = llFooter;
    this.txtOverflowMenu = txtOverflowMenu;
    this.txtPersonName = txtPersonName;
    this.txtQuoteDate = txtQuoteDate;
    this.txtSumAssured = txtSumAssured;
    this.txtVehicleName = txtVehicleName;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static LayoutHealthItemQuoteBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static LayoutHealthItemQuoteBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.layout_health_item_quote, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static LayoutHealthItemQuoteBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.llFooter;
      LinearLayout llFooter = rootView.findViewById(id);
      if (llFooter == null) {
        break missingId;
      }

      id = R.id.txtOverflowMenu;
      ImageView txtOverflowMenu = rootView.findViewById(id);
      if (txtOverflowMenu == null) {
        break missingId;
      }

      id = R.id.txtPersonName;
      TextView txtPersonName = rootView.findViewById(id);
      if (txtPersonName == null) {
        break missingId;
      }

      id = R.id.txtQuoteDate;
      TextView txtQuoteDate = rootView.findViewById(id);
      if (txtQuoteDate == null) {
        break missingId;
      }

      id = R.id.txtSumAssured;
      TextView txtSumAssured = rootView.findViewById(id);
      if (txtSumAssured == null) {
        break missingId;
      }

      id = R.id.txtVehicleName;
      TextView txtVehicleName = rootView.findViewById(id);
      if (txtVehicleName == null) {
        break missingId;
      }

      return new LayoutHealthItemQuoteBinding((LinearLayout) rootView, llFooter, txtOverflowMenu,
          txtPersonName, txtQuoteDate, txtSumAssured, txtVehicleName);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
