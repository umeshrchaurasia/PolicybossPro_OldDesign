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

public final class LayoutDashboardDisclosureBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final CardView cardView;

  @NonNull
  public final LinearLayout lyDisclosure;

  @NonNull
  public final TextView txtDisclosure;

  private LayoutDashboardDisclosureBinding(@NonNull LinearLayout rootView,
      @NonNull CardView cardView, @NonNull LinearLayout lyDisclosure,
      @NonNull TextView txtDisclosure) {
    this.rootView = rootView;
    this.cardView = cardView;
    this.lyDisclosure = lyDisclosure;
    this.txtDisclosure = txtDisclosure;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static LayoutDashboardDisclosureBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static LayoutDashboardDisclosureBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.layout_dashboard_disclosure, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static LayoutDashboardDisclosureBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.card_view;
      CardView cardView = rootView.findViewById(id);
      if (cardView == null) {
        break missingId;
      }

      id = R.id.lyDisclosure;
      LinearLayout lyDisclosure = rootView.findViewById(id);
      if (lyDisclosure == null) {
        break missingId;
      }

      id = R.id.txtDisclosure;
      TextView txtDisclosure = rootView.findViewById(id);
      if (txtDisclosure == null) {
        break missingId;
      }

      return new LayoutDashboardDisclosureBinding((LinearLayout) rootView, cardView, lyDisclosure,
          txtDisclosure);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
