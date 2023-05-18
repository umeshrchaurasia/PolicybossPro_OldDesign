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
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.policyboss.policybosspro.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityHealthCheckUpPopUpBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final Button applyOk;

  @NonNull
  public final ImageView ivCross;

  @NonNull
  public final RecyclerView rvHealthCheckTestDetails;

  @NonNull
  public final TextView txtPlanName;

  private ActivityHealthCheckUpPopUpBinding(@NonNull LinearLayout rootView, @NonNull Button applyOk,
      @NonNull ImageView ivCross, @NonNull RecyclerView rvHealthCheckTestDetails,
      @NonNull TextView txtPlanName) {
    this.rootView = rootView;
    this.applyOk = applyOk;
    this.ivCross = ivCross;
    this.rvHealthCheckTestDetails = rvHealthCheckTestDetails;
    this.txtPlanName = txtPlanName;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityHealthCheckUpPopUpBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityHealthCheckUpPopUpBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_health_check_up_pop_up, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityHealthCheckUpPopUpBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.applyOk;
      Button applyOk = rootView.findViewById(id);
      if (applyOk == null) {
        break missingId;
      }

      id = R.id.ivCross;
      ImageView ivCross = rootView.findViewById(id);
      if (ivCross == null) {
        break missingId;
      }

      id = R.id.rvHealthCheckTestDetails;
      RecyclerView rvHealthCheckTestDetails = rootView.findViewById(id);
      if (rvHealthCheckTestDetails == null) {
        break missingId;
      }

      id = R.id.txtPlanName;
      TextView txtPlanName = rootView.findViewById(id);
      if (txtPlanName == null) {
        break missingId;
      }

      return new ActivityHealthCheckUpPopUpBinding((LinearLayout) rootView, applyOk, ivCross,
          rvHealthCheckTestDetails, txtPlanName);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}