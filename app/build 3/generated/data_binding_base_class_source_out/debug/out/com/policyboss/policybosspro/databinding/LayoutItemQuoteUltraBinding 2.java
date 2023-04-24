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

public final class LayoutItemQuoteUltraBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final LinearLayout llDetails;

  @NonNull
  public final LinearLayout lyParent;

  @NonNull
  public final TextView tvQuoteDate;

  @NonNull
  public final TextView tvloanamount;

  @NonNull
  public final TextView txtCrn;

  @NonNull
  public final ImageView txtOverflowMenu;

  @NonNull
  public final TextView txtPersonName;

  @NonNull
  public final TextView txtQuoteDate;

  private LayoutItemQuoteUltraBinding(@NonNull LinearLayout rootView,
      @NonNull LinearLayout llDetails, @NonNull LinearLayout lyParent,
      @NonNull TextView tvQuoteDate, @NonNull TextView tvloanamount, @NonNull TextView txtCrn,
      @NonNull ImageView txtOverflowMenu, @NonNull TextView txtPersonName,
      @NonNull TextView txtQuoteDate) {
    this.rootView = rootView;
    this.llDetails = llDetails;
    this.lyParent = lyParent;
    this.tvQuoteDate = tvQuoteDate;
    this.tvloanamount = tvloanamount;
    this.txtCrn = txtCrn;
    this.txtOverflowMenu = txtOverflowMenu;
    this.txtPersonName = txtPersonName;
    this.txtQuoteDate = txtQuoteDate;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static LayoutItemQuoteUltraBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static LayoutItemQuoteUltraBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.layout_item_quote_ultra, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static LayoutItemQuoteUltraBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.llDetails;
      LinearLayout llDetails = rootView.findViewById(id);
      if (llDetails == null) {
        break missingId;
      }

      id = R.id.lyParent;
      LinearLayout lyParent = rootView.findViewById(id);
      if (lyParent == null) {
        break missingId;
      }

      id = R.id.tvQuoteDate;
      TextView tvQuoteDate = rootView.findViewById(id);
      if (tvQuoteDate == null) {
        break missingId;
      }

      id = R.id.tvloanamount;
      TextView tvloanamount = rootView.findViewById(id);
      if (tvloanamount == null) {
        break missingId;
      }

      id = R.id.txtCrn;
      TextView txtCrn = rootView.findViewById(id);
      if (txtCrn == null) {
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

      return new LayoutItemQuoteUltraBinding((LinearLayout) rootView, llDetails, lyParent,
          tvQuoteDate, tvloanamount, txtCrn, txtOverflowMenu, txtPersonName, txtQuoteDate);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
