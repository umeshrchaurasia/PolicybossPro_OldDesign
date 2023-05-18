// Generated by view binder compiler. Do not edit!
package com.policyboss.policybosspro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.policyboss.policybosspro.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ContentVehicleScanBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final Button btnLead;

  @NonNull
  public final Button btnVehicleInfo;

  @NonNull
  public final CardView cvVehicleDetail;

  @NonNull
  public final EditText etMobileNo;

  @NonNull
  public final EditText etName;

  @NonNull
  public final EditText etVehicleExpiryDate;

  @NonNull
  public final EditText etVehicleNo;

  @NonNull
  public final ImageView imageView;

  @NonNull
  public final TextView textView;

  @NonNull
  public final TextView txtCarDetail;

  @NonNull
  public final TextView txtRegistrationNo;

  private ContentVehicleScanBinding(@NonNull LinearLayout rootView, @NonNull Button btnLead,
      @NonNull Button btnVehicleInfo, @NonNull CardView cvVehicleDetail,
      @NonNull EditText etMobileNo, @NonNull EditText etName, @NonNull EditText etVehicleExpiryDate,
      @NonNull EditText etVehicleNo, @NonNull ImageView imageView, @NonNull TextView textView,
      @NonNull TextView txtCarDetail, @NonNull TextView txtRegistrationNo) {
    this.rootView = rootView;
    this.btnLead = btnLead;
    this.btnVehicleInfo = btnVehicleInfo;
    this.cvVehicleDetail = cvVehicleDetail;
    this.etMobileNo = etMobileNo;
    this.etName = etName;
    this.etVehicleExpiryDate = etVehicleExpiryDate;
    this.etVehicleNo = etVehicleNo;
    this.imageView = imageView;
    this.textView = textView;
    this.txtCarDetail = txtCarDetail;
    this.txtRegistrationNo = txtRegistrationNo;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ContentVehicleScanBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ContentVehicleScanBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.content_vehicle_scan, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ContentVehicleScanBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnLead;
      Button btnLead = rootView.findViewById(id);
      if (btnLead == null) {
        break missingId;
      }

      id = R.id.btnVehicleInfo;
      Button btnVehicleInfo = rootView.findViewById(id);
      if (btnVehicleInfo == null) {
        break missingId;
      }

      id = R.id.cvVehicleDetail;
      CardView cvVehicleDetail = rootView.findViewById(id);
      if (cvVehicleDetail == null) {
        break missingId;
      }

      id = R.id.etMobileNo;
      EditText etMobileNo = rootView.findViewById(id);
      if (etMobileNo == null) {
        break missingId;
      }

      id = R.id.etName;
      EditText etName = rootView.findViewById(id);
      if (etName == null) {
        break missingId;
      }

      id = R.id.etVehicleExpiryDate;
      EditText etVehicleExpiryDate = rootView.findViewById(id);
      if (etVehicleExpiryDate == null) {
        break missingId;
      }

      id = R.id.etVehicleNo;
      EditText etVehicleNo = rootView.findViewById(id);
      if (etVehicleNo == null) {
        break missingId;
      }

      id = R.id.imageView;
      ImageView imageView = rootView.findViewById(id);
      if (imageView == null) {
        break missingId;
      }

      id = R.id.textView;
      TextView textView = rootView.findViewById(id);
      if (textView == null) {
        break missingId;
      }

      id = R.id.txtCarDetail;
      TextView txtCarDetail = rootView.findViewById(id);
      if (txtCarDetail == null) {
        break missingId;
      }

      id = R.id.txtRegistrationNo;
      TextView txtRegistrationNo = rootView.findViewById(id);
      if (txtRegistrationNo == null) {
        break missingId;
      }

      return new ContentVehicleScanBinding((LinearLayout) rootView, btnLead, btnVehicleInfo,
          cvVehicleDetail, etMobileNo, etName, etVehicleExpiryDate, etVehicleNo, imageView,
          textView, txtCarDetail, txtRegistrationNo);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}