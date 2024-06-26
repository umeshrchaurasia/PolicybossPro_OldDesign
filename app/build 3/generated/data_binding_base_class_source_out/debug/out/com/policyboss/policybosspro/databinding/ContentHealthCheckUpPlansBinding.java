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
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.policyboss.policybosspro.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ContentHealthCheckUpPlansBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final ImageView imgShare;

  @NonNull
  public final RecyclerView rvHealthCheck;

  @NonNull
  public final TextView txtFBAName;

  @NonNull
  public final TextView txtMobile;

  private ContentHealthCheckUpPlansBinding(@NonNull LinearLayout rootView,
      @NonNull ImageView imgShare, @NonNull RecyclerView rvHealthCheck,
      @NonNull TextView txtFBAName, @NonNull TextView txtMobile) {
    this.rootView = rootView;
    this.imgShare = imgShare;
    this.rvHealthCheck = rvHealthCheck;
    this.txtFBAName = txtFBAName;
    this.txtMobile = txtMobile;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ContentHealthCheckUpPlansBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ContentHealthCheckUpPlansBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.content_health_check_up_plans, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ContentHealthCheckUpPlansBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.imgShare;
      ImageView imgShare = rootView.findViewById(id);
      if (imgShare == null) {
        break missingId;
      }

      id = R.id.rvHealthCheck;
      RecyclerView rvHealthCheck = rootView.findViewById(id);
      if (rvHealthCheck == null) {
        break missingId;
      }

      id = R.id.txtFBAName;
      TextView txtFBAName = rootView.findViewById(id);
      if (txtFBAName == null) {
        break missingId;
      }

      id = R.id.txtMobile;
      TextView txtMobile = rootView.findViewById(id);
      if (txtMobile == null) {
        break missingId;
      }

      return new ContentHealthCheckUpPlansBinding((LinearLayout) rootView, imgShare, rvHealthCheck,
          txtFBAName, txtMobile);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
