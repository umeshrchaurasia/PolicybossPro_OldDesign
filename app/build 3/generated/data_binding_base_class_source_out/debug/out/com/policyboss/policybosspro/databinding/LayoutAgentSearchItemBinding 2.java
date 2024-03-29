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

public final class LayoutAgentSearchItemBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final LinearLayout lyParent;

  @NonNull
  public final TextView txtEmail;

  @NonNull
  public final TextView txtFBAID;

  @NonNull
  public final TextView txtSSID;

  @NonNull
  public final TextView txtTitle;

  private LayoutAgentSearchItemBinding(@NonNull LinearLayout rootView,
      @NonNull LinearLayout lyParent, @NonNull TextView txtEmail, @NonNull TextView txtFBAID,
      @NonNull TextView txtSSID, @NonNull TextView txtTitle) {
    this.rootView = rootView;
    this.lyParent = lyParent;
    this.txtEmail = txtEmail;
    this.txtFBAID = txtFBAID;
    this.txtSSID = txtSSID;
    this.txtTitle = txtTitle;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static LayoutAgentSearchItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static LayoutAgentSearchItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.layout_agent_search_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static LayoutAgentSearchItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.lyParent;
      LinearLayout lyParent = rootView.findViewById(id);
      if (lyParent == null) {
        break missingId;
      }

      id = R.id.txtEmail;
      TextView txtEmail = rootView.findViewById(id);
      if (txtEmail == null) {
        break missingId;
      }

      id = R.id.txtFBAID;
      TextView txtFBAID = rootView.findViewById(id);
      if (txtFBAID == null) {
        break missingId;
      }

      id = R.id.txtSSID;
      TextView txtSSID = rootView.findViewById(id);
      if (txtSSID == null) {
        break missingId;
      }

      id = R.id.txtTitle;
      TextView txtTitle = rootView.findViewById(id);
      if (txtTitle == null) {
        break missingId;
      }

      return new LayoutAgentSearchItemBinding((LinearLayout) rootView, lyParent, txtEmail, txtFBAID,
          txtSSID, txtTitle);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
