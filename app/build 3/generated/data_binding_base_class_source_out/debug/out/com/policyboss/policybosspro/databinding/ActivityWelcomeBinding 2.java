// Generated by view binder compiler. Do not edit!
package com.policyboss.policybosspro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager.widget.ViewPager;
import com.policyboss.policybosspro.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityWelcomeBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final Button btnNext;

  @NonNull
  public final TextView btnSkip;

  @NonNull
  public final ImageView dot1;

  @NonNull
  public final ImageView dot2;

  @NonNull
  public final ImageView dot3;

  @NonNull
  public final ImageView dot4;

  @NonNull
  public final ImageView dot5;

  @NonNull
  public final LinearLayout layoutDots;

  @NonNull
  public final ViewPager viewPager;

  private ActivityWelcomeBinding(@NonNull LinearLayout rootView, @NonNull Button btnNext,
      @NonNull TextView btnSkip, @NonNull ImageView dot1, @NonNull ImageView dot2,
      @NonNull ImageView dot3, @NonNull ImageView dot4, @NonNull ImageView dot5,
      @NonNull LinearLayout layoutDots, @NonNull ViewPager viewPager) {
    this.rootView = rootView;
    this.btnNext = btnNext;
    this.btnSkip = btnSkip;
    this.dot1 = dot1;
    this.dot2 = dot2;
    this.dot3 = dot3;
    this.dot4 = dot4;
    this.dot5 = dot5;
    this.layoutDots = layoutDots;
    this.viewPager = viewPager;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityWelcomeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityWelcomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_welcome, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityWelcomeBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_next;
      Button btnNext = rootView.findViewById(id);
      if (btnNext == null) {
        break missingId;
      }

      id = R.id.btn_skip;
      TextView btnSkip = rootView.findViewById(id);
      if (btnSkip == null) {
        break missingId;
      }

      id = R.id.dot1;
      ImageView dot1 = rootView.findViewById(id);
      if (dot1 == null) {
        break missingId;
      }

      id = R.id.dot2;
      ImageView dot2 = rootView.findViewById(id);
      if (dot2 == null) {
        break missingId;
      }

      id = R.id.dot3;
      ImageView dot3 = rootView.findViewById(id);
      if (dot3 == null) {
        break missingId;
      }

      id = R.id.dot4;
      ImageView dot4 = rootView.findViewById(id);
      if (dot4 == null) {
        break missingId;
      }

      id = R.id.dot5;
      ImageView dot5 = rootView.findViewById(id);
      if (dot5 == null) {
        break missingId;
      }

      id = R.id.layoutDots;
      LinearLayout layoutDots = rootView.findViewById(id);
      if (layoutDots == null) {
        break missingId;
      }

      id = R.id.view_pager;
      ViewPager viewPager = rootView.findViewById(id);
      if (viewPager == null) {
        break missingId;
      }

      return new ActivityWelcomeBinding((LinearLayout) rootView, btnNext, btnSkip, dot1, dot2, dot3,
          dot4, dot5, layoutDots, viewPager);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
