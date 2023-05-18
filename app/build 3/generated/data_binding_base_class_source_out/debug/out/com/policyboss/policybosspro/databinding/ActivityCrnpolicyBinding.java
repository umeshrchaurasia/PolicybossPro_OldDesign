// Generated by view binder compiler. Do not edit!
package com.policyboss.policybosspro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.appbar.AppBarLayout;
import com.policyboss.policybosspro.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityCrnpolicyBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final AppBarLayout appBar;

  @NonNull
  public final Button btncrn;

  @NonNull
  public final EditText etcrn;

  @NonNull
  public final Toolbar toolbar;

  @NonNull
  public final TextView txtDesc;

  private ActivityCrnpolicyBinding(@NonNull LinearLayout rootView, @NonNull AppBarLayout appBar,
      @NonNull Button btncrn, @NonNull EditText etcrn, @NonNull Toolbar toolbar,
      @NonNull TextView txtDesc) {
    this.rootView = rootView;
    this.appBar = appBar;
    this.btncrn = btncrn;
    this.etcrn = etcrn;
    this.toolbar = toolbar;
    this.txtDesc = txtDesc;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityCrnpolicyBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityCrnpolicyBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_crnpolicy, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityCrnpolicyBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.appBar;
      AppBarLayout appBar = rootView.findViewById(id);
      if (appBar == null) {
        break missingId;
      }

      id = R.id.btncrn;
      Button btncrn = rootView.findViewById(id);
      if (btncrn == null) {
        break missingId;
      }

      id = R.id.etcrn;
      EditText etcrn = rootView.findViewById(id);
      if (etcrn == null) {
        break missingId;
      }

      id = R.id.toolbar;
      Toolbar toolbar = rootView.findViewById(id);
      if (toolbar == null) {
        break missingId;
      }

      id = R.id.txtDesc;
      TextView txtDesc = rootView.findViewById(id);
      if (txtDesc == null) {
        break missingId;
      }

      return new ActivityCrnpolicyBinding((LinearLayout) rootView, appBar, btncrn, etcrn, toolbar,
          txtDesc);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}