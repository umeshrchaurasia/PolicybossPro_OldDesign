// Generated by view binder compiler. Do not edit!
package com.policyboss.policybosspro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

public final class ActivityPolicyBossAttendanceBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final Button btnLocation;

  @NonNull
  public final Button btnSubmitAttendance;

  @NonNull
  public final LinearLayout lyParent;

  @NonNull
  public final RecyclerView rvOfflineItem;

  @NonNull
  public final TextView textLatitudedesc;

  @NonNull
  public final TextView textLongitudedesc;

  @NonNull
  public final TextView tvLatitude;

  @NonNull
  public final TextView tvLongitude;

  private ActivityPolicyBossAttendanceBinding(@NonNull LinearLayout rootView,
      @NonNull Button btnLocation, @NonNull Button btnSubmitAttendance,
      @NonNull LinearLayout lyParent, @NonNull RecyclerView rvOfflineItem,
      @NonNull TextView textLatitudedesc, @NonNull TextView textLongitudedesc,
      @NonNull TextView tvLatitude, @NonNull TextView tvLongitude) {
    this.rootView = rootView;
    this.btnLocation = btnLocation;
    this.btnSubmitAttendance = btnSubmitAttendance;
    this.lyParent = lyParent;
    this.rvOfflineItem = rvOfflineItem;
    this.textLatitudedesc = textLatitudedesc;
    this.textLongitudedesc = textLongitudedesc;
    this.tvLatitude = tvLatitude;
    this.tvLongitude = tvLongitude;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityPolicyBossAttendanceBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityPolicyBossAttendanceBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_policy_boss_attendance, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityPolicyBossAttendanceBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_location;
      Button btnLocation = rootView.findViewById(id);
      if (btnLocation == null) {
        break missingId;
      }

      id = R.id.btn_submit_attendance;
      Button btnSubmitAttendance = rootView.findViewById(id);
      if (btnSubmitAttendance == null) {
        break missingId;
      }

      id = R.id.lyParent;
      LinearLayout lyParent = rootView.findViewById(id);
      if (lyParent == null) {
        break missingId;
      }

      id = R.id.rvOfflineItem;
      RecyclerView rvOfflineItem = rootView.findViewById(id);
      if (rvOfflineItem == null) {
        break missingId;
      }

      id = R.id.textLatitudedesc;
      TextView textLatitudedesc = rootView.findViewById(id);
      if (textLatitudedesc == null) {
        break missingId;
      }

      id = R.id.textLongitudedesc;
      TextView textLongitudedesc = rootView.findViewById(id);
      if (textLongitudedesc == null) {
        break missingId;
      }

      id = R.id.tv_latitude;
      TextView tvLatitude = rootView.findViewById(id);
      if (tvLatitude == null) {
        break missingId;
      }

      id = R.id.tv_longitude;
      TextView tvLongitude = rootView.findViewById(id);
      if (tvLongitude == null) {
        break missingId;
      }

      return new ActivityPolicyBossAttendanceBinding((LinearLayout) rootView, btnLocation,
          btnSubmitAttendance, lyParent, rvOfflineItem, textLatitudedesc, textLongitudedesc,
          tvLatitude, tvLongitude);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
