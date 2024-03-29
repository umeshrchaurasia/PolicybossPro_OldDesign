// Generated by view binder compiler. Do not edit!
package com.policyboss.policybosspro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.policyboss.policybosspro.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class LayoutViewRaiseCommentBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final LinearLayout bottomSheet;

  @NonNull
  public final ImageView ivCross;

  @NonNull
  public final RecyclerView rvViewTicket;

  @NonNull
  public final TextView txtTile;

  private LayoutViewRaiseCommentBinding(@NonNull LinearLayout rootView,
      @NonNull LinearLayout bottomSheet, @NonNull ImageView ivCross,
      @NonNull RecyclerView rvViewTicket, @NonNull TextView txtTile) {
    this.rootView = rootView;
    this.bottomSheet = bottomSheet;
    this.ivCross = ivCross;
    this.rvViewTicket = rvViewTicket;
    this.txtTile = txtTile;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static LayoutViewRaiseCommentBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static LayoutViewRaiseCommentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.layout_view_raise_comment, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static LayoutViewRaiseCommentBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      LinearLayout bottomSheet = (LinearLayout) rootView;

      id = R.id.ivCross;
      ImageView ivCross = rootView.findViewById(id);
      if (ivCross == null) {
        break missingId;
      }

      id = R.id.rvViewTicket;
      RecyclerView rvViewTicket = rootView.findViewById(id);
      if (rvViewTicket == null) {
        break missingId;
      }

      id = R.id.txtTile;
      TextView txtTile = rootView.findViewById(id);
      if (txtTile == null) {
        break missingId;
      }

      return new LayoutViewRaiseCommentBinding((LinearLayout) rootView, bottomSheet, ivCross,
          rvViewTicket, txtTile);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
