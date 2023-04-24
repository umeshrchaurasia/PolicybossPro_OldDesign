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
import androidx.viewbinding.ViewBinding;
import com.policyboss.policybosspro.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class LayoutItemApplicationBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final ImageView imgInsurerLogo;

  @NonNull
  public final ImageView imgProgressStatus;

  @NonNull
  public final LinearLayout ll;

  @NonNull
  public final TextView txtCRN;

  @NonNull
  public final TextView txtCreatedDate;

  @NonNull
  public final TextView txtOverflowMenu;

  @NonNull
  public final TextView txtPersonName;

  @NonNull
  public final TextView txtVehicleNo;

  private LayoutItemApplicationBinding(@NonNull CardView rootView,
      @NonNull ImageView imgInsurerLogo, @NonNull ImageView imgProgressStatus,
      @NonNull LinearLayout ll, @NonNull TextView txtCRN, @NonNull TextView txtCreatedDate,
      @NonNull TextView txtOverflowMenu, @NonNull TextView txtPersonName,
      @NonNull TextView txtVehicleNo) {
    this.rootView = rootView;
    this.imgInsurerLogo = imgInsurerLogo;
    this.imgProgressStatus = imgProgressStatus;
    this.ll = ll;
    this.txtCRN = txtCRN;
    this.txtCreatedDate = txtCreatedDate;
    this.txtOverflowMenu = txtOverflowMenu;
    this.txtPersonName = txtPersonName;
    this.txtVehicleNo = txtVehicleNo;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static LayoutItemApplicationBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static LayoutItemApplicationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.layout_item_application, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static LayoutItemApplicationBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.imgInsurerLogo;
      ImageView imgInsurerLogo = rootView.findViewById(id);
      if (imgInsurerLogo == null) {
        break missingId;
      }

      id = R.id.imgProgressStatus;
      ImageView imgProgressStatus = rootView.findViewById(id);
      if (imgProgressStatus == null) {
        break missingId;
      }

      id = R.id.ll;
      LinearLayout ll = rootView.findViewById(id);
      if (ll == null) {
        break missingId;
      }

      id = R.id.txtCRN;
      TextView txtCRN = rootView.findViewById(id);
      if (txtCRN == null) {
        break missingId;
      }

      id = R.id.txtCreatedDate;
      TextView txtCreatedDate = rootView.findViewById(id);
      if (txtCreatedDate == null) {
        break missingId;
      }

      id = R.id.txtOverflowMenu;
      TextView txtOverflowMenu = rootView.findViewById(id);
      if (txtOverflowMenu == null) {
        break missingId;
      }

      id = R.id.txtPersonName;
      TextView txtPersonName = rootView.findViewById(id);
      if (txtPersonName == null) {
        break missingId;
      }

      id = R.id.txtVehicleNo;
      TextView txtVehicleNo = rootView.findViewById(id);
      if (txtVehicleNo == null) {
        break missingId;
      }

      return new LayoutItemApplicationBinding((CardView) rootView, imgInsurerLogo,
          imgProgressStatus, ll, txtCRN, txtCreatedDate, txtOverflowMenu, txtPersonName,
          txtVehicleNo);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
