// Generated by view binder compiler. Do not edit!
package com.policyboss.policybosspro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.policyboss.policybosspro.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class LayoutDashboardRecyclerBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final CardView cardView;

  @NonNull
  public final ImageView ivLogo;

  @NonNull
  public final RelativeLayout rlServiceName;

  @NonNull
  public final RecyclerView rvDashboard;

  @NonNull
  public final TextView tvPoweredBy;

  @NonNull
  public final TextView txtTypeName;

  private LayoutDashboardRecyclerBinding(@NonNull CardView rootView, @NonNull CardView cardView,
      @NonNull ImageView ivLogo, @NonNull RelativeLayout rlServiceName,
      @NonNull RecyclerView rvDashboard, @NonNull TextView tvPoweredBy,
      @NonNull TextView txtTypeName) {
    this.rootView = rootView;
    this.cardView = cardView;
    this.ivLogo = ivLogo;
    this.rlServiceName = rlServiceName;
    this.rvDashboard = rvDashboard;
    this.tvPoweredBy = tvPoweredBy;
    this.txtTypeName = txtTypeName;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static LayoutDashboardRecyclerBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static LayoutDashboardRecyclerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.layout_dashboard_recycler, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static LayoutDashboardRecyclerBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      CardView cardView = (CardView) rootView;

      id = R.id.ivLogo;
      ImageView ivLogo = rootView.findViewById(id);
      if (ivLogo == null) {
        break missingId;
      }

      id = R.id.rlServiceName;
      RelativeLayout rlServiceName = rootView.findViewById(id);
      if (rlServiceName == null) {
        break missingId;
      }

      id = R.id.rvDashboard;
      RecyclerView rvDashboard = rootView.findViewById(id);
      if (rvDashboard == null) {
        break missingId;
      }

      id = R.id.tvPoweredBy;
      TextView tvPoweredBy = rootView.findViewById(id);
      if (tvPoweredBy == null) {
        break missingId;
      }

      id = R.id.txtTypeName;
      TextView txtTypeName = rootView.findViewById(id);
      if (txtTypeName == null) {
        break missingId;
      }

      return new LayoutDashboardRecyclerBinding((CardView) rootView, cardView, ivLogo,
          rlServiceName, rvDashboard, tvPoweredBy, txtTypeName);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
