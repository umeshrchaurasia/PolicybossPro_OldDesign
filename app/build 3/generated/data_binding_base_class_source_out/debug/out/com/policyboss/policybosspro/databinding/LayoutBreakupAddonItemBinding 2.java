// Generated by view binder compiler. Do not edit!
package com.policyboss.policybosspro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.policyboss.policybosspro.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class LayoutBreakupAddonItemBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final CheckBox chbxAddon;

  @NonNull
  public final TextView tvName;

  @NonNull
  public final TextView tvValue;

  private LayoutBreakupAddonItemBinding(@NonNull CardView rootView, @NonNull CheckBox chbxAddon,
      @NonNull TextView tvName, @NonNull TextView tvValue) {
    this.rootView = rootView;
    this.chbxAddon = chbxAddon;
    this.tvName = tvName;
    this.tvValue = tvValue;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static LayoutBreakupAddonItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static LayoutBreakupAddonItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.layout_breakup_addon_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static LayoutBreakupAddonItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.chbxAddon;
      CheckBox chbxAddon = rootView.findViewById(id);
      if (chbxAddon == null) {
        break missingId;
      }

      id = R.id.tvName;
      TextView tvName = rootView.findViewById(id);
      if (tvName == null) {
        break missingId;
      }

      id = R.id.tvValue;
      TextView tvValue = rootView.findViewById(id);
      if (tvValue == null) {
        break missingId;
      }

      return new LayoutBreakupAddonItemBinding((CardView) rootView, chbxAddon, tvName, tvValue);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
