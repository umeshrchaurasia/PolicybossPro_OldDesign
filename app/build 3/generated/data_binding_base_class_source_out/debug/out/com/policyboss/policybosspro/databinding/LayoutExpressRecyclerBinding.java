// Generated by view binder compiler. Do not edit!
package com.policyboss.policybosspro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public final class LayoutExpressRecyclerBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final CardView cardView;

  @NonNull
  public final RecyclerView rvExpress;

  @NonNull
  public final TextView txtTypeName;

  private LayoutExpressRecyclerBinding(@NonNull CardView rootView, @NonNull CardView cardView,
      @NonNull RecyclerView rvExpress, @NonNull TextView txtTypeName) {
    this.rootView = rootView;
    this.cardView = cardView;
    this.rvExpress = rvExpress;
    this.txtTypeName = txtTypeName;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static LayoutExpressRecyclerBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static LayoutExpressRecyclerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.layout_express_recycler, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static LayoutExpressRecyclerBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      CardView cardView = (CardView) rootView;

      id = R.id.rvExpress;
      RecyclerView rvExpress = rootView.findViewById(id);
      if (rvExpress == null) {
        break missingId;
      }

      id = R.id.txtTypeName;
      TextView txtTypeName = rootView.findViewById(id);
      if (txtTypeName == null) {
        break missingId;
      }

      return new LayoutExpressRecyclerBinding((CardView) rootView, cardView, rvExpress,
          txtTypeName);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}