// Generated by view binder compiler. Do not edit!
package com.policyboss.policybosspro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.policyboss.policybosspro.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityQuoteBinding implements ViewBinding {
  @NonNull
  private final CoordinatorLayout rootView;

  @NonNull
  public final AppBarLayout appBar;

  @NonNull
  public final FloatingActionButton filter;

  @NonNull
  public final ImageView ivEdit;

  @NonNull
  public final Toolbar toolbar;

  @NonNull
  public final TextView tvCrn;

  @NonNull
  public final TextView tvFuel;

  @NonNull
  public final TextView tvMakeModel;

  @NonNull
  public final TextView tvPolicyExp;

  @NonNull
  public final TextView tvRtoName;

  private ActivityQuoteBinding(@NonNull CoordinatorLayout rootView, @NonNull AppBarLayout appBar,
      @NonNull FloatingActionButton filter, @NonNull ImageView ivEdit, @NonNull Toolbar toolbar,
      @NonNull TextView tvCrn, @NonNull TextView tvFuel, @NonNull TextView tvMakeModel,
      @NonNull TextView tvPolicyExp, @NonNull TextView tvRtoName) {
    this.rootView = rootView;
    this.appBar = appBar;
    this.filter = filter;
    this.ivEdit = ivEdit;
    this.toolbar = toolbar;
    this.tvCrn = tvCrn;
    this.tvFuel = tvFuel;
    this.tvMakeModel = tvMakeModel;
    this.tvPolicyExp = tvPolicyExp;
    this.tvRtoName = tvRtoName;
  }

  @Override
  @NonNull
  public CoordinatorLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityQuoteBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityQuoteBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_quote, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityQuoteBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.app_bar;
      AppBarLayout appBar = rootView.findViewById(id);
      if (appBar == null) {
        break missingId;
      }

      id = R.id.filter;
      FloatingActionButton filter = rootView.findViewById(id);
      if (filter == null) {
        break missingId;
      }

      id = R.id.ivEdit;
      ImageView ivEdit = rootView.findViewById(id);
      if (ivEdit == null) {
        break missingId;
      }

      id = R.id.toolbar;
      Toolbar toolbar = rootView.findViewById(id);
      if (toolbar == null) {
        break missingId;
      }

      id = R.id.tvCrn;
      TextView tvCrn = rootView.findViewById(id);
      if (tvCrn == null) {
        break missingId;
      }

      id = R.id.tvFuel;
      TextView tvFuel = rootView.findViewById(id);
      if (tvFuel == null) {
        break missingId;
      }

      id = R.id.tvMakeModel;
      TextView tvMakeModel = rootView.findViewById(id);
      if (tvMakeModel == null) {
        break missingId;
      }

      id = R.id.tvPolicyExp;
      TextView tvPolicyExp = rootView.findViewById(id);
      if (tvPolicyExp == null) {
        break missingId;
      }

      id = R.id.tvRtoName;
      TextView tvRtoName = rootView.findViewById(id);
      if (tvRtoName == null) {
        break missingId;
      }

      return new ActivityQuoteBinding((CoordinatorLayout) rootView, appBar, filter, ivEdit, toolbar,
          tvCrn, tvFuel, tvMakeModel, tvPolicyExp, tvRtoName);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}