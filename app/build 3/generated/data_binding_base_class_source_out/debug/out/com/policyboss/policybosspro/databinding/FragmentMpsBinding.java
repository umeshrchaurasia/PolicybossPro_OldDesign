// Generated by view binder compiler. Do not edit!
package com.policyboss.policybosspro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.policyboss.policybosspro.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentMpsBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final Button btnApplyPromo;

  @NonNull
  public final Button btnPayNow;

  @NonNull
  public final CheckBox chkAgree;

  @NonNull
  public final EditText etPromoCode;

  @NonNull
  public final LinearLayout llPromo;

  @NonNull
  public final TextView txtGSTAmount;

  @NonNull
  public final TextView txtMessage;

  @NonNull
  public final TextView txtPromoCode;

  @NonNull
  public final TextView txtSubscriptionAmount;

  @NonNull
  public final TextView txtTermsCondition;

  @NonNull
  public final TextView txtTotalAmount;

  private FragmentMpsBinding(@NonNull LinearLayout rootView, @NonNull Button btnApplyPromo,
      @NonNull Button btnPayNow, @NonNull CheckBox chkAgree, @NonNull EditText etPromoCode,
      @NonNull LinearLayout llPromo, @NonNull TextView txtGSTAmount, @NonNull TextView txtMessage,
      @NonNull TextView txtPromoCode, @NonNull TextView txtSubscriptionAmount,
      @NonNull TextView txtTermsCondition, @NonNull TextView txtTotalAmount) {
    this.rootView = rootView;
    this.btnApplyPromo = btnApplyPromo;
    this.btnPayNow = btnPayNow;
    this.chkAgree = chkAgree;
    this.etPromoCode = etPromoCode;
    this.llPromo = llPromo;
    this.txtGSTAmount = txtGSTAmount;
    this.txtMessage = txtMessage;
    this.txtPromoCode = txtPromoCode;
    this.txtSubscriptionAmount = txtSubscriptionAmount;
    this.txtTermsCondition = txtTermsCondition;
    this.txtTotalAmount = txtTotalAmount;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentMpsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentMpsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_mps, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentMpsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnApplyPromo;
      Button btnApplyPromo = rootView.findViewById(id);
      if (btnApplyPromo == null) {
        break missingId;
      }

      id = R.id.btnPayNow;
      Button btnPayNow = rootView.findViewById(id);
      if (btnPayNow == null) {
        break missingId;
      }

      id = R.id.chkAgree;
      CheckBox chkAgree = rootView.findViewById(id);
      if (chkAgree == null) {
        break missingId;
      }

      id = R.id.etPromoCode;
      EditText etPromoCode = rootView.findViewById(id);
      if (etPromoCode == null) {
        break missingId;
      }

      id = R.id.llPromo;
      LinearLayout llPromo = rootView.findViewById(id);
      if (llPromo == null) {
        break missingId;
      }

      id = R.id.txtGSTAmount;
      TextView txtGSTAmount = rootView.findViewById(id);
      if (txtGSTAmount == null) {
        break missingId;
      }

      id = R.id.txtMessage;
      TextView txtMessage = rootView.findViewById(id);
      if (txtMessage == null) {
        break missingId;
      }

      id = R.id.txtPromoCode;
      TextView txtPromoCode = rootView.findViewById(id);
      if (txtPromoCode == null) {
        break missingId;
      }

      id = R.id.txtSubscriptionAmount;
      TextView txtSubscriptionAmount = rootView.findViewById(id);
      if (txtSubscriptionAmount == null) {
        break missingId;
      }

      id = R.id.txtTermsCondition;
      TextView txtTermsCondition = rootView.findViewById(id);
      if (txtTermsCondition == null) {
        break missingId;
      }

      id = R.id.txtTotalAmount;
      TextView txtTotalAmount = rootView.findViewById(id);
      if (txtTotalAmount == null) {
        break missingId;
      }

      return new FragmentMpsBinding((LinearLayout) rootView, btnApplyPromo, btnPayNow, chkAgree,
          etPromoCode, llPromo, txtGSTAmount, txtMessage, txtPromoCode, txtSubscriptionAmount,
          txtTermsCondition, txtTotalAmount);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}