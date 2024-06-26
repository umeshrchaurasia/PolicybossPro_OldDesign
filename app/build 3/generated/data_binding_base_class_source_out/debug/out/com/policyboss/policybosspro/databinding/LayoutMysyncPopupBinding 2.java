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
import com.policyboss.policybosspro.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class LayoutMysyncPopupBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final Button btnAllow;

  @NonNull
  public final ImageView ivCross;

  @NonNull
  public final ImageView ivMessage;

  @NonNull
  public final TextView txtMessage;

  @NonNull
  public final TextView txtOther;

  @NonNull
  public final TextView txtTile;

  @NonNull
  public final View viewSeperator;

  private LayoutMysyncPopupBinding(@NonNull LinearLayout rootView, @NonNull Button btnAllow,
      @NonNull ImageView ivCross, @NonNull ImageView ivMessage, @NonNull TextView txtMessage,
      @NonNull TextView txtOther, @NonNull TextView txtTile, @NonNull View viewSeperator) {
    this.rootView = rootView;
    this.btnAllow = btnAllow;
    this.ivCross = ivCross;
    this.ivMessage = ivMessage;
    this.txtMessage = txtMessage;
    this.txtOther = txtOther;
    this.txtTile = txtTile;
    this.viewSeperator = viewSeperator;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static LayoutMysyncPopupBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static LayoutMysyncPopupBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.layout_mysync_popup, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static LayoutMysyncPopupBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnAllow;
      Button btnAllow = rootView.findViewById(id);
      if (btnAllow == null) {
        break missingId;
      }

      id = R.id.ivCross;
      ImageView ivCross = rootView.findViewById(id);
      if (ivCross == null) {
        break missingId;
      }

      id = R.id.ivMessage;
      ImageView ivMessage = rootView.findViewById(id);
      if (ivMessage == null) {
        break missingId;
      }

      id = R.id.txtMessage;
      TextView txtMessage = rootView.findViewById(id);
      if (txtMessage == null) {
        break missingId;
      }

      id = R.id.txtOther;
      TextView txtOther = rootView.findViewById(id);
      if (txtOther == null) {
        break missingId;
      }

      id = R.id.txtTile;
      TextView txtTile = rootView.findViewById(id);
      if (txtTile == null) {
        break missingId;
      }

      id = R.id.viewSeperator;
      View viewSeperator = rootView.findViewById(id);
      if (viewSeperator == null) {
        break missingId;
      }

      return new LayoutMysyncPopupBinding((LinearLayout) rootView, btnAllow, ivCross, ivMessage,
          txtMessage, txtOther, txtTile, viewSeperator);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
