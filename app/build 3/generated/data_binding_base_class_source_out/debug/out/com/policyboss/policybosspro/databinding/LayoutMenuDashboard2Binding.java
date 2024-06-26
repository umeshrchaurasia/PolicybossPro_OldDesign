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

public final class LayoutMenuDashboard2Binding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final ImageView cFinpeace;

  @NonNull
  public final CardView cvFinpeace;

  @NonNull
  public final CardView cvHealthAssure;

  @NonNull
  public final ImageView ivCross;

  @NonNull
  public final LinearLayout llFinpeace;

  @NonNull
  public final LinearLayout llhealth;

  @NonNull
  public final TextView txtTile;

  private LayoutMenuDashboard2Binding(@NonNull LinearLayout rootView, @NonNull ImageView cFinpeace,
      @NonNull CardView cvFinpeace, @NonNull CardView cvHealthAssure, @NonNull ImageView ivCross,
      @NonNull LinearLayout llFinpeace, @NonNull LinearLayout llhealth, @NonNull TextView txtTile) {
    this.rootView = rootView;
    this.cFinpeace = cFinpeace;
    this.cvFinpeace = cvFinpeace;
    this.cvHealthAssure = cvHealthAssure;
    this.ivCross = ivCross;
    this.llFinpeace = llFinpeace;
    this.llhealth = llhealth;
    this.txtTile = txtTile;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static LayoutMenuDashboard2Binding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static LayoutMenuDashboard2Binding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.layout_menu_dashboard2, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static LayoutMenuDashboard2Binding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.cFinpeace;
      ImageView cFinpeace = rootView.findViewById(id);
      if (cFinpeace == null) {
        break missingId;
      }

      id = R.id.cvFinpeace;
      CardView cvFinpeace = rootView.findViewById(id);
      if (cvFinpeace == null) {
        break missingId;
      }

      id = R.id.cvHealthAssure;
      CardView cvHealthAssure = rootView.findViewById(id);
      if (cvHealthAssure == null) {
        break missingId;
      }

      id = R.id.ivCross;
      ImageView ivCross = rootView.findViewById(id);
      if (ivCross == null) {
        break missingId;
      }

      id = R.id.llFinpeace;
      LinearLayout llFinpeace = rootView.findViewById(id);
      if (llFinpeace == null) {
        break missingId;
      }

      id = R.id.llhealth;
      LinearLayout llhealth = rootView.findViewById(id);
      if (llhealth == null) {
        break missingId;
      }

      id = R.id.txtTile;
      TextView txtTile = rootView.findViewById(id);
      if (txtTile == null) {
        break missingId;
      }

      return new LayoutMenuDashboard2Binding((LinearLayout) rootView, cFinpeace, cvFinpeace,
          cvHealthAssure, ivCross, llFinpeace, llhealth, txtTile);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
