// Generated by view binder compiler. Do not edit!
package com.policyboss.policybosspro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.policyboss.policybosspro.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class LayoutOfflineMemberdetailsBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final EditText etDOB;

  @NonNull
  public final LinearLayout llMarried;

  @NonNull
  public final RadioButton rbFemale;

  @NonNull
  public final RadioButton rbMale;

  @NonNull
  public final Spinner spHealthRelation;

  @NonNull
  public final Switch swUnMarried;

  @NonNull
  public final TextView txtMarried;

  @NonNull
  public final TextView txtSingle;

  private LayoutOfflineMemberdetailsBinding(@NonNull LinearLayout rootView, @NonNull EditText etDOB,
      @NonNull LinearLayout llMarried, @NonNull RadioButton rbFemale, @NonNull RadioButton rbMale,
      @NonNull Spinner spHealthRelation, @NonNull Switch swUnMarried, @NonNull TextView txtMarried,
      @NonNull TextView txtSingle) {
    this.rootView = rootView;
    this.etDOB = etDOB;
    this.llMarried = llMarried;
    this.rbFemale = rbFemale;
    this.rbMale = rbMale;
    this.spHealthRelation = spHealthRelation;
    this.swUnMarried = swUnMarried;
    this.txtMarried = txtMarried;
    this.txtSingle = txtSingle;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static LayoutOfflineMemberdetailsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static LayoutOfflineMemberdetailsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.layout_offline_memberdetails, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static LayoutOfflineMemberdetailsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.etDOB;
      EditText etDOB = rootView.findViewById(id);
      if (etDOB == null) {
        break missingId;
      }

      id = R.id.llMarried;
      LinearLayout llMarried = rootView.findViewById(id);
      if (llMarried == null) {
        break missingId;
      }

      id = R.id.rbFemale;
      RadioButton rbFemale = rootView.findViewById(id);
      if (rbFemale == null) {
        break missingId;
      }

      id = R.id.rbMale;
      RadioButton rbMale = rootView.findViewById(id);
      if (rbMale == null) {
        break missingId;
      }

      id = R.id.spHealthRelation;
      Spinner spHealthRelation = rootView.findViewById(id);
      if (spHealthRelation == null) {
        break missingId;
      }

      id = R.id.swUnMarried;
      Switch swUnMarried = rootView.findViewById(id);
      if (swUnMarried == null) {
        break missingId;
      }

      id = R.id.txtMarried;
      TextView txtMarried = rootView.findViewById(id);
      if (txtMarried == null) {
        break missingId;
      }

      id = R.id.txtSingle;
      TextView txtSingle = rootView.findViewById(id);
      if (txtSingle == null) {
        break missingId;
      }

      return new LayoutOfflineMemberdetailsBinding((LinearLayout) rootView, etDOB, llMarried,
          rbFemale, rbMale, spHealthRelation, swUnMarried, txtMarried, txtSingle);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
