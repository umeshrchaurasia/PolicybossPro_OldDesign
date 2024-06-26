// Generated by view binder compiler. Do not edit!
package com.policyboss.policybosspro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.policyboss.policybosspro.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class LayoutOffilineDocItemBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final LinearLayout lyParent;

  @NonNull
  public final TextView txtDocName;

  private LayoutOffilineDocItemBinding(@NonNull LinearLayout rootView,
      @NonNull LinearLayout lyParent, @NonNull TextView txtDocName) {
    this.rootView = rootView;
    this.lyParent = lyParent;
    this.txtDocName = txtDocName;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static LayoutOffilineDocItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static LayoutOffilineDocItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.layout_offiline_doc_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static LayoutOffilineDocItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.lyParent;
      LinearLayout lyParent = rootView.findViewById(id);
      if (lyParent == null) {
        break missingId;
      }

      id = R.id.txtDocName;
      TextView txtDocName = rootView.findViewById(id);
      if (txtDocName == null) {
        break missingId;
      }

      return new LayoutOffilineDocItemBinding((LinearLayout) rootView, lyParent, txtDocName);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
