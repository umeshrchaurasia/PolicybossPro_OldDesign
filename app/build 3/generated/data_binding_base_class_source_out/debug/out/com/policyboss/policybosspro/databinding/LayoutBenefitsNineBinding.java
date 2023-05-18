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

public final class LayoutBenefitsNineBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final ImageView imgBenefits;

  @NonNull
  public final LinearLayout llBenefits;

  @NonNull
  public final TextView txtBenefitsName;

  @NonNull
  public final TextView txtSelect;

  private LayoutBenefitsNineBinding(@NonNull CardView rootView, @NonNull ImageView imgBenefits,
      @NonNull LinearLayout llBenefits, @NonNull TextView txtBenefitsName,
      @NonNull TextView txtSelect) {
    this.rootView = rootView;
    this.imgBenefits = imgBenefits;
    this.llBenefits = llBenefits;
    this.txtBenefitsName = txtBenefitsName;
    this.txtSelect = txtSelect;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static LayoutBenefitsNineBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static LayoutBenefitsNineBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.layout_benefits_nine, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static LayoutBenefitsNineBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.imgBenefits;
      ImageView imgBenefits = rootView.findViewById(id);
      if (imgBenefits == null) {
        break missingId;
      }

      id = R.id.llBenefits;
      LinearLayout llBenefits = rootView.findViewById(id);
      if (llBenefits == null) {
        break missingId;
      }

      id = R.id.txtBenefitsName;
      TextView txtBenefitsName = rootView.findViewById(id);
      if (txtBenefitsName == null) {
        break missingId;
      }

      id = R.id.txtSelect;
      TextView txtSelect = rootView.findViewById(id);
      if (txtSelect == null) {
        break missingId;
      }

      return new LayoutBenefitsNineBinding((CardView) rootView, imgBenefits, llBenefits,
          txtBenefitsName, txtSelect);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}