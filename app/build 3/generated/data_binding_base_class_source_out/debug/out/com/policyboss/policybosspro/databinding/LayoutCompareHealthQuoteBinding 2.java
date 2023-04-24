// Generated by view binder compiler. Do not edit!
package com.policyboss.policybosspro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

public final class LayoutCompareHealthQuoteBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final Button btnClose;

  @NonNull
  public final Button btnOk;

  @NonNull
  public final ImageView imgInsurerLogo;

  @NonNull
  public final TextView txtEstPremium;

  @NonNull
  public final TextView txtInsPremium;

  @NonNull
  public final TextView txtPlanName;

  @NonNull
  public final TextView txtProductName;

  private LayoutCompareHealthQuoteBinding(@NonNull LinearLayout rootView, @NonNull Button btnClose,
      @NonNull Button btnOk, @NonNull ImageView imgInsurerLogo, @NonNull TextView txtEstPremium,
      @NonNull TextView txtInsPremium, @NonNull TextView txtPlanName,
      @NonNull TextView txtProductName) {
    this.rootView = rootView;
    this.btnClose = btnClose;
    this.btnOk = btnOk;
    this.imgInsurerLogo = imgInsurerLogo;
    this.txtEstPremium = txtEstPremium;
    this.txtInsPremium = txtInsPremium;
    this.txtPlanName = txtPlanName;
    this.txtProductName = txtProductName;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static LayoutCompareHealthQuoteBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static LayoutCompareHealthQuoteBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.layout_compare_health_quote, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static LayoutCompareHealthQuoteBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnClose;
      Button btnClose = rootView.findViewById(id);
      if (btnClose == null) {
        break missingId;
      }

      id = R.id.btnOk;
      Button btnOk = rootView.findViewById(id);
      if (btnOk == null) {
        break missingId;
      }

      id = R.id.imgInsurerLogo;
      ImageView imgInsurerLogo = rootView.findViewById(id);
      if (imgInsurerLogo == null) {
        break missingId;
      }

      id = R.id.txtEstPremium;
      TextView txtEstPremium = rootView.findViewById(id);
      if (txtEstPremium == null) {
        break missingId;
      }

      id = R.id.txtInsPremium;
      TextView txtInsPremium = rootView.findViewById(id);
      if (txtInsPremium == null) {
        break missingId;
      }

      id = R.id.txtPlanName;
      TextView txtPlanName = rootView.findViewById(id);
      if (txtPlanName == null) {
        break missingId;
      }

      id = R.id.txtProductName;
      TextView txtProductName = rootView.findViewById(id);
      if (txtProductName == null) {
        break missingId;
      }

      return new LayoutCompareHealthQuoteBinding((LinearLayout) rootView, btnClose, btnOk,
          imgInsurerLogo, txtEstPremium, txtInsPremium, txtPlanName, txtProductName);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
