// Generated by view binder compiler. Do not edit!
package com.policyboss.policybosspro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.navigation.NavigationView;
import com.policyboss.policybosspro.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityHomeBinding implements ViewBinding {
  @NonNull
  private final DrawerLayout rootView;

  @NonNull
  public final AppBarLayout appbar;

  @NonNull
  public final DrawerLayout drawer;

  @NonNull
  public final FrameLayout frame;

  @NonNull
  public final LinearLayout llSwitchUser;

  @NonNull
  public final NavigationView navigationView;

  @NonNull
  public final Toolbar toolbar;

  private ActivityHomeBinding(@NonNull DrawerLayout rootView, @NonNull AppBarLayout appbar,
      @NonNull DrawerLayout drawer, @NonNull FrameLayout frame, @NonNull LinearLayout llSwitchUser,
      @NonNull NavigationView navigationView, @NonNull Toolbar toolbar) {
    this.rootView = rootView;
    this.appbar = appbar;
    this.drawer = drawer;
    this.frame = frame;
    this.llSwitchUser = llSwitchUser;
    this.navigationView = navigationView;
    this.toolbar = toolbar;
  }

  @Override
  @NonNull
  public DrawerLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityHomeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_home, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityHomeBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.appbar;
      AppBarLayout appbar = rootView.findViewById(id);
      if (appbar == null) {
        break missingId;
      }

      DrawerLayout drawer = (DrawerLayout) rootView;

      id = R.id.frame;
      FrameLayout frame = rootView.findViewById(id);
      if (frame == null) {
        break missingId;
      }

      id = R.id.llSwitchUser;
      LinearLayout llSwitchUser = rootView.findViewById(id);
      if (llSwitchUser == null) {
        break missingId;
      }

      id = R.id.navigation_view;
      NavigationView navigationView = rootView.findViewById(id);
      if (navigationView == null) {
        break missingId;
      }

      id = R.id.toolbar;
      Toolbar toolbar = rootView.findViewById(id);
      if (toolbar == null) {
        break missingId;
      }

      return new ActivityHomeBinding((DrawerLayout) rootView, appbar, drawer, frame, llSwitchUser,
          navigationView, toolbar);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}