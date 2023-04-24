// Generated by view binder compiler. Do not edit!
package com.policyboss.policybosspro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public final class LayoutOfflineMotorListItemBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final LinearLayout llOfflineMotor;

  @NonNull
  public final LinearLayout llQuoteList;

  @NonNull
  public final TextView txtName;

  @NonNull
  public final TextView txtRegDate;

  @NonNull
  public final TextView txtVehicleNo;

  private LayoutOfflineMotorListItemBinding(@NonNull CardView rootView,
      @NonNull LinearLayout llOfflineMotor, @NonNull LinearLayout llQuoteList,
      @NonNull TextView txtName, @NonNull TextView txtRegDate, @NonNull TextView txtVehicleNo) {
    this.rootView = rootView;
    this.llOfflineMotor = llOfflineMotor;
    this.llQuoteList = llQuoteList;
    this.txtName = txtName;
    this.txtRegDate = txtRegDate;
    this.txtVehicleNo = txtVehicleNo;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static LayoutOfflineMotorListItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static LayoutOfflineMotorListItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.layout_offline_motor_list_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static LayoutOfflineMotorListItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.llOfflineMotor;
      LinearLayout llOfflineMotor = rootView.findViewById(id);
      if (llOfflineMotor == null) {
        break missingId;
      }

      id = R.id.llQuoteList;
      LinearLayout llQuoteList = rootView.findViewById(id);
      if (llQuoteList == null) {
        break missingId;
      }

      id = R.id.txtName;
      TextView txtName = rootView.findViewById(id);
      if (txtName == null) {
        break missingId;
      }

      id = R.id.txtRegDate;
      TextView txtRegDate = rootView.findViewById(id);
      if (txtRegDate == null) {
        break missingId;
      }

      id = R.id.txtVehicleNo;
      TextView txtVehicleNo = rootView.findViewById(id);
      if (txtVehicleNo == null) {
        break missingId;
      }

      return new LayoutOfflineMotorListItemBinding((CardView) rootView, llOfflineMotor, llQuoteList,
          txtName, txtRegDate, txtVehicleNo);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
