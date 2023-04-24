// Generated by view binder compiler. Do not edit!
package com.policyboss.policybosspro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.policyboss.policybosspro.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityBikeAddQuoteBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final AppBarLayout appBar;

  @NonNull
  public final RelativeLayout bottmc;

  @NonNull
  public final BottomNavigationView bottomNavigation;

  @NonNull
  public final FrameLayout frameLayout;

  @NonNull
  public final ImageView ivHdrInput;

  @NonNull
  public final ImageView ivHdrQuote;

  @NonNull
  public final LinearLayout lyheader;

  @NonNull
  public final Toolbar toolbar;

  @NonNull
  public final View viewHeader;

  private ActivityBikeAddQuoteBinding(@NonNull RelativeLayout rootView,
      @NonNull AppBarLayout appBar, @NonNull RelativeLayout bottmc,
      @NonNull BottomNavigationView bottomNavigation, @NonNull FrameLayout frameLayout,
      @NonNull ImageView ivHdrInput, @NonNull ImageView ivHdrQuote, @NonNull LinearLayout lyheader,
      @NonNull Toolbar toolbar, @NonNull View viewHeader) {
    this.rootView = rootView;
    this.appBar = appBar;
    this.bottmc = bottmc;
    this.bottomNavigation = bottomNavigation;
    this.frameLayout = frameLayout;
    this.ivHdrInput = ivHdrInput;
    this.ivHdrQuote = ivHdrQuote;
    this.lyheader = lyheader;
    this.toolbar = toolbar;
    this.viewHeader = viewHeader;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityBikeAddQuoteBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityBikeAddQuoteBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_bike_add_quote, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityBikeAddQuoteBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.app_bar;
      AppBarLayout appBar = rootView.findViewById(id);
      if (appBar == null) {
        break missingId;
      }

      id = R.id.bottmc;
      RelativeLayout bottmc = rootView.findViewById(id);
      if (bottmc == null) {
        break missingId;
      }

      id = R.id.bottomNavigation;
      BottomNavigationView bottomNavigation = rootView.findViewById(id);
      if (bottomNavigation == null) {
        break missingId;
      }

      id = R.id.frame_layout;
      FrameLayout frameLayout = rootView.findViewById(id);
      if (frameLayout == null) {
        break missingId;
      }

      id = R.id.ivHdrInput;
      ImageView ivHdrInput = rootView.findViewById(id);
      if (ivHdrInput == null) {
        break missingId;
      }

      id = R.id.ivHdrQuote;
      ImageView ivHdrQuote = rootView.findViewById(id);
      if (ivHdrQuote == null) {
        break missingId;
      }

      id = R.id.lyheader;
      LinearLayout lyheader = rootView.findViewById(id);
      if (lyheader == null) {
        break missingId;
      }

      id = R.id.toolbar;
      Toolbar toolbar = rootView.findViewById(id);
      if (toolbar == null) {
        break missingId;
      }

      id = R.id.viewHeader;
      View viewHeader = rootView.findViewById(id);
      if (viewHeader == null) {
        break missingId;
      }

      return new ActivityBikeAddQuoteBinding((RelativeLayout) rootView, appBar, bottmc,
          bottomNavigation, frameLayout, ivHdrInput, ivHdrQuote, lyheader, toolbar, viewHeader);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
