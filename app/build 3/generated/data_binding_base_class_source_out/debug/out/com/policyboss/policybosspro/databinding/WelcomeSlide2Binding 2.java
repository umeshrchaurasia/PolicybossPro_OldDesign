// Generated by view binder compiler. Do not edit!
package com.policyboss.policybosspro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.policyboss.policybosspro.R;
import java.lang.NullPointerException;
import java.lang.Override;

public final class WelcomeSlide2Binding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  private WelcomeSlide2Binding(@NonNull LinearLayout rootView) {
    this.rootView = rootView;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static WelcomeSlide2Binding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static WelcomeSlide2Binding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.welcome_slide2, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static WelcomeSlide2Binding bind(@NonNull View rootView) {
    if (rootView == null) {
      throw new NullPointerException("rootView");
    }

    return new WelcomeSlide2Binding((LinearLayout) rootView);
  }
}
