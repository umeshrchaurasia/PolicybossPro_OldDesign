// Generated by view binder compiler. Do not edit!
package com.policyboss.policybosspro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.policyboss.policybosspro.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityHealthMemberDetailsDialogBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final Button btnContinue;

  @NonNull
  public final RecyclerView rvMemberDetail;

  private ActivityHealthMemberDetailsDialogBinding(@NonNull LinearLayout rootView,
      @NonNull Button btnContinue, @NonNull RecyclerView rvMemberDetail) {
    this.rootView = rootView;
    this.btnContinue = btnContinue;
    this.rvMemberDetail = rvMemberDetail;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityHealthMemberDetailsDialogBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityHealthMemberDetailsDialogBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_health_member_details_dialog, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityHealthMemberDetailsDialogBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnContinue;
      Button btnContinue = rootView.findViewById(id);
      if (btnContinue == null) {
        break missingId;
      }

      id = R.id.rvMemberDetail;
      RecyclerView rvMemberDetail = rootView.findViewById(id);
      if (rvMemberDetail == null) {
        break missingId;
      }

      return new ActivityHealthMemberDetailsDialogBinding((LinearLayout) rootView, btnContinue,
          rvMemberDetail);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
