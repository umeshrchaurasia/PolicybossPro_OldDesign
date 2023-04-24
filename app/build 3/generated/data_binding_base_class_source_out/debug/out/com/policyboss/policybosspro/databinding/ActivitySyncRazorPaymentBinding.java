// Generated by view binder compiler. Do not edit!
package com.policyboss.policybosspro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.policyboss.policybosspro.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivitySyncRazorPaymentBinding implements ViewBinding {
  @NonNull
  private final CoordinatorLayout rootView;

  @NonNull
  public final Button btnBuy;

  @NonNull
  public final Button btnCancel;

  @NonNull
  public final Button btnContinue;

  @NonNull
  public final Button btnHomeContinue;

  @NonNull
  public final CardView cvBuy;

  @NonNull
  public final CardView cvFailure;

  @NonNull
  public final CardView cvSuccess;

  @NonNull
  public final TextView lblPayable;

  @NonNull
  public final TextView lblcustomername;

  @NonNull
  public final TextView lblfailcustid;

  @NonNull
  public final TextView lblname;

  @NonNull
  public final TextView lblpaymentstatus;

  @NonNull
  public final Toolbar toolbar;

  @NonNull
  public final TextView txtCustomerName;

  @NonNull
  public final TextView txtDisplayAmount;

  @NonNull
  public final TextView txtFailureMessage;

  @NonNull
  public final TextView txtProdName;

  @NonNull
  public final TextView txtSuccessMessage;

  @NonNull
  public final TextView txtSuccessTitle;

  @NonNull
  public final TextView txtfailcustid;

  @NonNull
  public final TextView txtpaymentstatus;

  @NonNull
  public final TextView txtprdName;

  private ActivitySyncRazorPaymentBinding(@NonNull CoordinatorLayout rootView,
      @NonNull Button btnBuy, @NonNull Button btnCancel, @NonNull Button btnContinue,
      @NonNull Button btnHomeContinue, @NonNull CardView cvBuy, @NonNull CardView cvFailure,
      @NonNull CardView cvSuccess, @NonNull TextView lblPayable, @NonNull TextView lblcustomername,
      @NonNull TextView lblfailcustid, @NonNull TextView lblname,
      @NonNull TextView lblpaymentstatus, @NonNull Toolbar toolbar,
      @NonNull TextView txtCustomerName, @NonNull TextView txtDisplayAmount,
      @NonNull TextView txtFailureMessage, @NonNull TextView txtProdName,
      @NonNull TextView txtSuccessMessage, @NonNull TextView txtSuccessTitle,
      @NonNull TextView txtfailcustid, @NonNull TextView txtpaymentstatus,
      @NonNull TextView txtprdName) {
    this.rootView = rootView;
    this.btnBuy = btnBuy;
    this.btnCancel = btnCancel;
    this.btnContinue = btnContinue;
    this.btnHomeContinue = btnHomeContinue;
    this.cvBuy = cvBuy;
    this.cvFailure = cvFailure;
    this.cvSuccess = cvSuccess;
    this.lblPayable = lblPayable;
    this.lblcustomername = lblcustomername;
    this.lblfailcustid = lblfailcustid;
    this.lblname = lblname;
    this.lblpaymentstatus = lblpaymentstatus;
    this.toolbar = toolbar;
    this.txtCustomerName = txtCustomerName;
    this.txtDisplayAmount = txtDisplayAmount;
    this.txtFailureMessage = txtFailureMessage;
    this.txtProdName = txtProdName;
    this.txtSuccessMessage = txtSuccessMessage;
    this.txtSuccessTitle = txtSuccessTitle;
    this.txtfailcustid = txtfailcustid;
    this.txtpaymentstatus = txtpaymentstatus;
    this.txtprdName = txtprdName;
  }

  @Override
  @NonNull
  public CoordinatorLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivitySyncRazorPaymentBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivitySyncRazorPaymentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_sync_razor_payment, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivitySyncRazorPaymentBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnBuy;
      Button btnBuy = rootView.findViewById(id);
      if (btnBuy == null) {
        break missingId;
      }

      id = R.id.btnCancel;
      Button btnCancel = rootView.findViewById(id);
      if (btnCancel == null) {
        break missingId;
      }

      id = R.id.btnContinue;
      Button btnContinue = rootView.findViewById(id);
      if (btnContinue == null) {
        break missingId;
      }

      id = R.id.btnHomeContinue;
      Button btnHomeContinue = rootView.findViewById(id);
      if (btnHomeContinue == null) {
        break missingId;
      }

      id = R.id.cvBuy;
      CardView cvBuy = rootView.findViewById(id);
      if (cvBuy == null) {
        break missingId;
      }

      id = R.id.cvFailure;
      CardView cvFailure = rootView.findViewById(id);
      if (cvFailure == null) {
        break missingId;
      }

      id = R.id.cvSuccess;
      CardView cvSuccess = rootView.findViewById(id);
      if (cvSuccess == null) {
        break missingId;
      }

      id = R.id.lblPayable;
      TextView lblPayable = rootView.findViewById(id);
      if (lblPayable == null) {
        break missingId;
      }

      id = R.id.lblcustomername;
      TextView lblcustomername = rootView.findViewById(id);
      if (lblcustomername == null) {
        break missingId;
      }

      id = R.id.lblfailcustid;
      TextView lblfailcustid = rootView.findViewById(id);
      if (lblfailcustid == null) {
        break missingId;
      }

      id = R.id.lblname;
      TextView lblname = rootView.findViewById(id);
      if (lblname == null) {
        break missingId;
      }

      id = R.id.lblpaymentstatus;
      TextView lblpaymentstatus = rootView.findViewById(id);
      if (lblpaymentstatus == null) {
        break missingId;
      }

      id = R.id.toolbar;
      Toolbar toolbar = rootView.findViewById(id);
      if (toolbar == null) {
        break missingId;
      }

      id = R.id.txtCustomerName;
      TextView txtCustomerName = rootView.findViewById(id);
      if (txtCustomerName == null) {
        break missingId;
      }

      id = R.id.txtDisplayAmount;
      TextView txtDisplayAmount = rootView.findViewById(id);
      if (txtDisplayAmount == null) {
        break missingId;
      }

      id = R.id.txtFailureMessage;
      TextView txtFailureMessage = rootView.findViewById(id);
      if (txtFailureMessage == null) {
        break missingId;
      }

      id = R.id.txtProdName;
      TextView txtProdName = rootView.findViewById(id);
      if (txtProdName == null) {
        break missingId;
      }

      id = R.id.txtSuccessMessage;
      TextView txtSuccessMessage = rootView.findViewById(id);
      if (txtSuccessMessage == null) {
        break missingId;
      }

      id = R.id.txtSuccessTitle;
      TextView txtSuccessTitle = rootView.findViewById(id);
      if (txtSuccessTitle == null) {
        break missingId;
      }

      id = R.id.txtfailcustid;
      TextView txtfailcustid = rootView.findViewById(id);
      if (txtfailcustid == null) {
        break missingId;
      }

      id = R.id.txtpaymentstatus;
      TextView txtpaymentstatus = rootView.findViewById(id);
      if (txtpaymentstatus == null) {
        break missingId;
      }

      id = R.id.txtprdName;
      TextView txtprdName = rootView.findViewById(id);
      if (txtprdName == null) {
        break missingId;
      }

      return new ActivitySyncRazorPaymentBinding((CoordinatorLayout) rootView, btnBuy, btnCancel,
          btnContinue, btnHomeContinue, cvBuy, cvFailure, cvSuccess, lblPayable, lblcustomername,
          lblfailcustid, lblname, lblpaymentstatus, toolbar, txtCustomerName, txtDisplayAmount,
          txtFailureMessage, txtProdName, txtSuccessMessage, txtSuccessTitle, txtfailcustid,
          txtpaymentstatus, txtprdName);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
