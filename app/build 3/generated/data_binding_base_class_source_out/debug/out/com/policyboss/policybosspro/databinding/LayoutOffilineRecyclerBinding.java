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
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.policyboss.policybosspro.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class LayoutOffilineRecyclerBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final CardView cardView;

  @NonNull
  public final ImageView ivEdit;

  @NonNull
  public final LinearLayout ivllEdit;

  @NonNull
  public final LinearLayout lyParent;

  @NonNull
  public final RecyclerView rvOfflineItem;

  @NonNull
  public final TextView textDate;

  @NonNull
  public final TextView textProductDesc;

  @NonNull
  public final TextView txtDate;

  @NonNull
  public final TextView txtProductDesc;

  @NonNull
  public final TextView txtProductName;

  private LayoutOffilineRecyclerBinding(@NonNull LinearLayout rootView, @NonNull CardView cardView,
      @NonNull ImageView ivEdit, @NonNull LinearLayout ivllEdit, @NonNull LinearLayout lyParent,
      @NonNull RecyclerView rvOfflineItem, @NonNull TextView textDate,
      @NonNull TextView textProductDesc, @NonNull TextView txtDate,
      @NonNull TextView txtProductDesc, @NonNull TextView txtProductName) {
    this.rootView = rootView;
    this.cardView = cardView;
    this.ivEdit = ivEdit;
    this.ivllEdit = ivllEdit;
    this.lyParent = lyParent;
    this.rvOfflineItem = rvOfflineItem;
    this.textDate = textDate;
    this.textProductDesc = textProductDesc;
    this.txtDate = txtDate;
    this.txtProductDesc = txtProductDesc;
    this.txtProductName = txtProductName;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static LayoutOffilineRecyclerBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static LayoutOffilineRecyclerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.layout_offiline_recycler, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static LayoutOffilineRecyclerBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.card_view;
      CardView cardView = rootView.findViewById(id);
      if (cardView == null) {
        break missingId;
      }

      id = R.id.ivEdit;
      ImageView ivEdit = rootView.findViewById(id);
      if (ivEdit == null) {
        break missingId;
      }

      id = R.id.ivllEdit;
      LinearLayout ivllEdit = rootView.findViewById(id);
      if (ivllEdit == null) {
        break missingId;
      }

      id = R.id.lyParent;
      LinearLayout lyParent = rootView.findViewById(id);
      if (lyParent == null) {
        break missingId;
      }

      id = R.id.rvOfflineItem;
      RecyclerView rvOfflineItem = rootView.findViewById(id);
      if (rvOfflineItem == null) {
        break missingId;
      }

      id = R.id.textDate;
      TextView textDate = rootView.findViewById(id);
      if (textDate == null) {
        break missingId;
      }

      id = R.id.textProductDesc;
      TextView textProductDesc = rootView.findViewById(id);
      if (textProductDesc == null) {
        break missingId;
      }

      id = R.id.txtDate;
      TextView txtDate = rootView.findViewById(id);
      if (txtDate == null) {
        break missingId;
      }

      id = R.id.txtProductDesc;
      TextView txtProductDesc = rootView.findViewById(id);
      if (txtProductDesc == null) {
        break missingId;
      }

      id = R.id.txtProductName;
      TextView txtProductName = rootView.findViewById(id);
      if (txtProductName == null) {
        break missingId;
      }

      return new LayoutOffilineRecyclerBinding((LinearLayout) rootView, cardView, ivEdit, ivllEdit,
          lyParent, rvOfflineItem, textDate, textProductDesc, txtDate, txtProductDesc,
          txtProductName);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
