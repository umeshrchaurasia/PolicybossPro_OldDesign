// Generated by view binder compiler. Do not edit!
package com.policyboss.policybosspro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
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

public final class ContentLeadInfoPopupBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final Button btnBack;

  @NonNull
  public final CardView cvInputSummary;

  @NonNull
  public final LinearLayout lyParent;

  @NonNull
  public final RecyclerView rvLeads;

  @NonNull
  public final TextView txtBank;

  @NonNull
  public final TextView txtCusName;

  @NonNull
  public final TextView txtMobile;

  @NonNull
  public final TextView txtNoData;

  @NonNull
  public final TextView txtProduct;

  private ContentLeadInfoPopupBinding(@NonNull RelativeLayout rootView, @NonNull Button btnBack,
      @NonNull CardView cvInputSummary, @NonNull LinearLayout lyParent,
      @NonNull RecyclerView rvLeads, @NonNull TextView txtBank, @NonNull TextView txtCusName,
      @NonNull TextView txtMobile, @NonNull TextView txtNoData, @NonNull TextView txtProduct) {
    this.rootView = rootView;
    this.btnBack = btnBack;
    this.cvInputSummary = cvInputSummary;
    this.lyParent = lyParent;
    this.rvLeads = rvLeads;
    this.txtBank = txtBank;
    this.txtCusName = txtCusName;
    this.txtMobile = txtMobile;
    this.txtNoData = txtNoData;
    this.txtProduct = txtProduct;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ContentLeadInfoPopupBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ContentLeadInfoPopupBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.content_lead_info_popup, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ContentLeadInfoPopupBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnBack;
      Button btnBack = rootView.findViewById(id);
      if (btnBack == null) {
        break missingId;
      }

      id = R.id.cvInputSummary;
      CardView cvInputSummary = rootView.findViewById(id);
      if (cvInputSummary == null) {
        break missingId;
      }

      id = R.id.lyParent;
      LinearLayout lyParent = rootView.findViewById(id);
      if (lyParent == null) {
        break missingId;
      }

      id = R.id.rvLeads;
      RecyclerView rvLeads = rootView.findViewById(id);
      if (rvLeads == null) {
        break missingId;
      }

      id = R.id.txtBank;
      TextView txtBank = rootView.findViewById(id);
      if (txtBank == null) {
        break missingId;
      }

      id = R.id.txtCusName;
      TextView txtCusName = rootView.findViewById(id);
      if (txtCusName == null) {
        break missingId;
      }

      id = R.id.txtMobile;
      TextView txtMobile = rootView.findViewById(id);
      if (txtMobile == null) {
        break missingId;
      }

      id = R.id.txtNoData;
      TextView txtNoData = rootView.findViewById(id);
      if (txtNoData == null) {
        break missingId;
      }

      id = R.id.txtProduct;
      TextView txtProduct = rootView.findViewById(id);
      if (txtProduct == null) {
        break missingId;
      }

      return new ContentLeadInfoPopupBinding((RelativeLayout) rootView, btnBack, cvInputSummary,
          lyParent, rvLeads, txtBank, txtCusName, txtMobile, txtNoData, txtProduct);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
