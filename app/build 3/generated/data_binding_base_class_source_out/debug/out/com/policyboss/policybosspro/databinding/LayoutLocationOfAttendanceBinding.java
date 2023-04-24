// Generated by view binder compiler. Do not edit!
package com.policyboss.policybosspro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.policyboss.policybosspro.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class LayoutLocationOfAttendanceBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final Button btnMyLoc;

  @NonNull
  public final LinearLayout layoutAddress;

  @NonNull
  public final TextView lblAdderess;

  @NonNull
  public final LinearLayout lvLocation;

  @NonNull
  public final TextView textViewType;

  @NonNull
  public final TextView txtAddress;

  @NonNull
  public final TextView txtType;

  @NonNull
  public final TextView txtViewlat;

  @NonNull
  public final TextView txtViewlog;

  private LayoutLocationOfAttendanceBinding(@NonNull LinearLayout rootView,
      @NonNull Button btnMyLoc, @NonNull LinearLayout layoutAddress, @NonNull TextView lblAdderess,
      @NonNull LinearLayout lvLocation, @NonNull TextView textViewType,
      @NonNull TextView txtAddress, @NonNull TextView txtType, @NonNull TextView txtViewlat,
      @NonNull TextView txtViewlog) {
    this.rootView = rootView;
    this.btnMyLoc = btnMyLoc;
    this.layoutAddress = layoutAddress;
    this.lblAdderess = lblAdderess;
    this.lvLocation = lvLocation;
    this.textViewType = textViewType;
    this.txtAddress = txtAddress;
    this.txtType = txtType;
    this.txtViewlat = txtViewlat;
    this.txtViewlog = txtViewlog;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static LayoutLocationOfAttendanceBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static LayoutLocationOfAttendanceBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.layout_location_of_attendance, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static LayoutLocationOfAttendanceBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnMyLoc;
      Button btnMyLoc = rootView.findViewById(id);
      if (btnMyLoc == null) {
        break missingId;
      }

      id = R.id.layout_address;
      LinearLayout layoutAddress = rootView.findViewById(id);
      if (layoutAddress == null) {
        break missingId;
      }

      id = R.id.lblAdderess;
      TextView lblAdderess = rootView.findViewById(id);
      if (lblAdderess == null) {
        break missingId;
      }

      id = R.id.lvLocation;
      LinearLayout lvLocation = rootView.findViewById(id);
      if (lvLocation == null) {
        break missingId;
      }

      id = R.id.textViewType;
      TextView textViewType = rootView.findViewById(id);
      if (textViewType == null) {
        break missingId;
      }

      id = R.id.txtAddress;
      TextView txtAddress = rootView.findViewById(id);
      if (txtAddress == null) {
        break missingId;
      }

      id = R.id.txtType;
      TextView txtType = rootView.findViewById(id);
      if (txtType == null) {
        break missingId;
      }

      id = R.id.txtViewlat;
      TextView txtViewlat = rootView.findViewById(id);
      if (txtViewlat == null) {
        break missingId;
      }

      id = R.id.txtViewlog;
      TextView txtViewlog = rootView.findViewById(id);
      if (txtViewlog == null) {
        break missingId;
      }

      return new LayoutLocationOfAttendanceBinding((LinearLayout) rootView, btnMyLoc, layoutAddress,
          lblAdderess, lvLocation, textViewType, txtAddress, txtType, txtViewlat, txtViewlog);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
