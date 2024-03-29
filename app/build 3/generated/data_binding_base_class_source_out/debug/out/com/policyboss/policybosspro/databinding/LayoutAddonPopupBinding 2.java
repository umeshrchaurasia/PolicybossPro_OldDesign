// Generated by view binder compiler. Do not edit!
package com.policyboss.policybosspro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.policyboss.policybosspro.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class LayoutAddonPopupBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final Button btnCancel;

  @NonNull
  public final Button btnOk;

  @NonNull
  public final RecyclerView rvAddOne;

  @NonNull
  public final ScrollView scrollView;

  private LayoutAddonPopupBinding(@NonNull RelativeLayout rootView, @NonNull Button btnCancel,
      @NonNull Button btnOk, @NonNull RecyclerView rvAddOne, @NonNull ScrollView scrollView) {
    this.rootView = rootView;
    this.btnCancel = btnCancel;
    this.btnOk = btnOk;
    this.rvAddOne = rvAddOne;
    this.scrollView = scrollView;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static LayoutAddonPopupBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static LayoutAddonPopupBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.layout_addon_popup, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static LayoutAddonPopupBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnCancel;
      Button btnCancel = rootView.findViewById(id);
      if (btnCancel == null) {
        break missingId;
      }

      id = R.id.btnOk;
      Button btnOk = rootView.findViewById(id);
      if (btnOk == null) {
        break missingId;
      }

      id = R.id.rvAddOne;
      RecyclerView rvAddOne = rootView.findViewById(id);
      if (rvAddOne == null) {
        break missingId;
      }

      id = R.id.scrollView;
      ScrollView scrollView = rootView.findViewById(id);
      if (scrollView == null) {
        break missingId;
      }

      return new LayoutAddonPopupBinding((RelativeLayout) rootView, btnCancel, btnOk, rvAddOne,
          scrollView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
