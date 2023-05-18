// Generated by view binder compiler. Do not edit!
package com.policyboss.policybosspro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.policyboss.policybosspro.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class LayoutHealthCheckupItemBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final TextView txtMRP;

  @NonNull
  public final TextView txtMobileNo;

  @NonNull
  public final TextView txtName;

  @NonNull
  public final TextView txtPackageName;

  @NonNull
  public final TextView txtStatus;

  private LayoutHealthCheckupItemBinding(@NonNull LinearLayout rootView, @NonNull TextView txtMRP,
      @NonNull TextView txtMobileNo, @NonNull TextView txtName, @NonNull TextView txtPackageName,
      @NonNull TextView txtStatus) {
    this.rootView = rootView;
    this.txtMRP = txtMRP;
    this.txtMobileNo = txtMobileNo;
    this.txtName = txtName;
    this.txtPackageName = txtPackageName;
    this.txtStatus = txtStatus;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static LayoutHealthCheckupItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static LayoutHealthCheckupItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.layout_health_checkup_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static LayoutHealthCheckupItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.txtMRP;
      TextView txtMRP = rootView.findViewById(id);
      if (txtMRP == null) {
        break missingId;
      }

      id = R.id.txtMobileNo;
      TextView txtMobileNo = rootView.findViewById(id);
      if (txtMobileNo == null) {
        break missingId;
      }

      id = R.id.txtName;
      TextView txtName = rootView.findViewById(id);
      if (txtName == null) {
        break missingId;
      }

      id = R.id.txtPackageName;
      TextView txtPackageName = rootView.findViewById(id);
      if (txtPackageName == null) {
        break missingId;
      }

      id = R.id.txtStatus;
      TextView txtStatus = rootView.findViewById(id);
      if (txtStatus == null) {
        break missingId;
      }

      return new LayoutHealthCheckupItemBinding((LinearLayout) rootView, txtMRP, txtMobileNo,
          txtName, txtPackageName, txtStatus);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}