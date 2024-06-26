// Generated by view binder compiler. Do not edit!
package com.policyboss.policybosspro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager.widget.ViewPager;
import com.policyboss.policybosspro.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import me.relex.circleindicator.CircleIndicator;

public final class FragmentLakshayQuoteViewPagerBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final CircleIndicator indicator;

  @NonNull
  public final ViewPager viewpager;

  private FragmentLakshayQuoteViewPagerBinding(@NonNull LinearLayout rootView,
      @NonNull CircleIndicator indicator, @NonNull ViewPager viewpager) {
    this.rootView = rootView;
    this.indicator = indicator;
    this.viewpager = viewpager;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentLakshayQuoteViewPagerBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentLakshayQuoteViewPagerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_lakshay_quote_view_pager, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentLakshayQuoteViewPagerBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.indicator;
      CircleIndicator indicator = rootView.findViewById(id);
      if (indicator == null) {
        break missingId;
      }

      id = R.id.viewpager;
      ViewPager viewpager = rootView.findViewById(id);
      if (viewpager == null) {
        break missingId;
      }

      return new FragmentLakshayQuoteViewPagerBinding((LinearLayout) rootView, indicator,
          viewpager);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
