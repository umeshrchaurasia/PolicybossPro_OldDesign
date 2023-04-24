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

public final class LayoutItemMotorLeadBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final ImageView imgEdit;

  @NonNull
  public final ImageView imgView;

  @NonNull
  public final LinearLayout llDetails;

  @NonNull
  public final LinearLayout llEditLead;

  @NonNull
  public final LinearLayout llNewLead;

  @NonNull
  public final LinearLayout llViewLead;

  @NonNull
  public final TextView txtCrnNo;

  @NonNull
  public final TextView txtEdit;

  @NonNull
  public final TextView txtLost;

  @NonNull
  public final TextView txtPersonName;

  @NonNull
  public final TextView txtQuoteDate;

  @NonNull
  public final TextView txtVehicleName;

  @NonNull
  public final TextView txtView;

  private LayoutItemMotorLeadBinding(@NonNull LinearLayout rootView, @NonNull ImageView imgEdit,
      @NonNull ImageView imgView, @NonNull LinearLayout llDetails, @NonNull LinearLayout llEditLead,
      @NonNull LinearLayout llNewLead, @NonNull LinearLayout llViewLead, @NonNull TextView txtCrnNo,
      @NonNull TextView txtEdit, @NonNull TextView txtLost, @NonNull TextView txtPersonName,
      @NonNull TextView txtQuoteDate, @NonNull TextView txtVehicleName, @NonNull TextView txtView) {
    this.rootView = rootView;
    this.imgEdit = imgEdit;
    this.imgView = imgView;
    this.llDetails = llDetails;
    this.llEditLead = llEditLead;
    this.llNewLead = llNewLead;
    this.llViewLead = llViewLead;
    this.txtCrnNo = txtCrnNo;
    this.txtEdit = txtEdit;
    this.txtLost = txtLost;
    this.txtPersonName = txtPersonName;
    this.txtQuoteDate = txtQuoteDate;
    this.txtVehicleName = txtVehicleName;
    this.txtView = txtView;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static LayoutItemMotorLeadBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static LayoutItemMotorLeadBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.layout_item_motor_lead, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static LayoutItemMotorLeadBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.imgEdit;
      ImageView imgEdit = rootView.findViewById(id);
      if (imgEdit == null) {
        break missingId;
      }

      id = R.id.imgView;
      ImageView imgView = rootView.findViewById(id);
      if (imgView == null) {
        break missingId;
      }

      id = R.id.llDetails;
      LinearLayout llDetails = rootView.findViewById(id);
      if (llDetails == null) {
        break missingId;
      }

      id = R.id.llEditLead;
      LinearLayout llEditLead = rootView.findViewById(id);
      if (llEditLead == null) {
        break missingId;
      }

      id = R.id.llNewLead;
      LinearLayout llNewLead = rootView.findViewById(id);
      if (llNewLead == null) {
        break missingId;
      }

      id = R.id.llViewLead;
      LinearLayout llViewLead = rootView.findViewById(id);
      if (llViewLead == null) {
        break missingId;
      }

      id = R.id.txtCrnNo;
      TextView txtCrnNo = rootView.findViewById(id);
      if (txtCrnNo == null) {
        break missingId;
      }

      id = R.id.txtEdit;
      TextView txtEdit = rootView.findViewById(id);
      if (txtEdit == null) {
        break missingId;
      }

      id = R.id.txtLost;
      TextView txtLost = rootView.findViewById(id);
      if (txtLost == null) {
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

      id = R.id.txtVehicleName;
      TextView txtVehicleName = rootView.findViewById(id);
      if (txtVehicleName == null) {
        break missingId;
      }

      id = R.id.txtView;
      TextView txtView = rootView.findViewById(id);
      if (txtView == null) {
        break missingId;
      }

      return new LayoutItemMotorLeadBinding((LinearLayout) rootView, imgEdit, imgView, llDetails,
          llEditLead, llNewLead, llViewLead, txtCrnNo, txtEdit, txtLost, txtPersonName,
          txtQuoteDate, txtVehicleName, txtView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
