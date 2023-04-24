// Generated by view binder compiler. Do not edit!
package com.policyboss.policybosspro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.policyboss.policybosspro.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityCreditCardBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final CardView CardStyle;

  @NonNull
  public final AppBarLayout appBar;

  @NonNull
  public final FloatingActionButton fabFilter;

  @NonNull
  public final RecyclerView rvCreditCards;

  @NonNull
  public final Spinner spIncome;

  @NonNull
  public final Toolbar toolbar;

  private ActivityCreditCardBinding(@NonNull RelativeLayout rootView, @NonNull CardView CardStyle,
      @NonNull AppBarLayout appBar, @NonNull FloatingActionButton fabFilter,
      @NonNull RecyclerView rvCreditCards, @NonNull Spinner spIncome, @NonNull Toolbar toolbar) {
    this.rootView = rootView;
    this.CardStyle = CardStyle;
    this.appBar = appBar;
    this.fabFilter = fabFilter;
    this.rvCreditCards = rvCreditCards;
    this.spIncome = spIncome;
    this.toolbar = toolbar;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityCreditCardBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityCreditCardBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_credit_card, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityCreditCardBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.CardStyle;
      CardView CardStyle = rootView.findViewById(id);
      if (CardStyle == null) {
        break missingId;
      }

      id = R.id.app_bar;
      AppBarLayout appBar = rootView.findViewById(id);
      if (appBar == null) {
        break missingId;
      }

      id = R.id.fabFilter;
      FloatingActionButton fabFilter = rootView.findViewById(id);
      if (fabFilter == null) {
        break missingId;
      }

      id = R.id.rvCreditCards;
      RecyclerView rvCreditCards = rootView.findViewById(id);
      if (rvCreditCards == null) {
        break missingId;
      }

      id = R.id.spIncome;
      Spinner spIncome = rootView.findViewById(id);
      if (spIncome == null) {
        break missingId;
      }

      id = R.id.toolbar;
      Toolbar toolbar = rootView.findViewById(id);
      if (toolbar == null) {
        break missingId;
      }

      return new ActivityCreditCardBinding((RelativeLayout) rootView, CardStyle, appBar, fabFilter,
          rvCreditCards, spIncome, toolbar);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
