// Generated by view binder compiler. Do not edit!
package com.policyboss.policybosspro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.policyboss.policybosspro.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class LeadDetailItemBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final TextView textFollDate;

  @NonNull
  public final TextView textRemark;

  @NonNull
  public final TextView textStattus;

  @NonNull
  public final TextView textUpdateBy;

  @NonNull
  public final TextView textUpdateDate;

  @NonNull
  public final TextView txtFollowUpDate;

  @NonNull
  public final TextView txtRemark;

  @NonNull
  public final TextView txtStatus;

  @NonNull
  public final TextView txtUpdatedBy;

  @NonNull
  public final TextView txtUpdatepDate;

  private LeadDetailItemBinding(@NonNull LinearLayout rootView, @NonNull TextView textFollDate,
      @NonNull TextView textRemark, @NonNull TextView textStattus, @NonNull TextView textUpdateBy,
      @NonNull TextView textUpdateDate, @NonNull TextView txtFollowUpDate,
      @NonNull TextView txtRemark, @NonNull TextView txtStatus, @NonNull TextView txtUpdatedBy,
      @NonNull TextView txtUpdatepDate) {
    this.rootView = rootView;
    this.textFollDate = textFollDate;
    this.textRemark = textRemark;
    this.textStattus = textStattus;
    this.textUpdateBy = textUpdateBy;
    this.textUpdateDate = textUpdateDate;
    this.txtFollowUpDate = txtFollowUpDate;
    this.txtRemark = txtRemark;
    this.txtStatus = txtStatus;
    this.txtUpdatedBy = txtUpdatedBy;
    this.txtUpdatepDate = txtUpdatepDate;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static LeadDetailItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static LeadDetailItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.lead_detail_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static LeadDetailItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.textFollDate;
      TextView textFollDate = rootView.findViewById(id);
      if (textFollDate == null) {
        break missingId;
      }

      id = R.id.textRemark;
      TextView textRemark = rootView.findViewById(id);
      if (textRemark == null) {
        break missingId;
      }

      id = R.id.textStattus;
      TextView textStattus = rootView.findViewById(id);
      if (textStattus == null) {
        break missingId;
      }

      id = R.id.textUpdateBy;
      TextView textUpdateBy = rootView.findViewById(id);
      if (textUpdateBy == null) {
        break missingId;
      }

      id = R.id.textUpdateDate;
      TextView textUpdateDate = rootView.findViewById(id);
      if (textUpdateDate == null) {
        break missingId;
      }

      id = R.id.txtFollowUpDate;
      TextView txtFollowUpDate = rootView.findViewById(id);
      if (txtFollowUpDate == null) {
        break missingId;
      }

      id = R.id.txtRemark;
      TextView txtRemark = rootView.findViewById(id);
      if (txtRemark == null) {
        break missingId;
      }

      id = R.id.txtStatus;
      TextView txtStatus = rootView.findViewById(id);
      if (txtStatus == null) {
        break missingId;
      }

      id = R.id.txtUpdatedBy;
      TextView txtUpdatedBy = rootView.findViewById(id);
      if (txtUpdatedBy == null) {
        break missingId;
      }

      id = R.id.txtUpdatepDate;
      TextView txtUpdatepDate = rootView.findViewById(id);
      if (txtUpdatepDate == null) {
        break missingId;
      }

      return new LeadDetailItemBinding((LinearLayout) rootView, textFollDate, textRemark,
          textStattus, textUpdateBy, textUpdateDate, txtFollowUpDate, txtRemark, txtStatus,
          txtUpdatedBy, txtUpdatepDate);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
