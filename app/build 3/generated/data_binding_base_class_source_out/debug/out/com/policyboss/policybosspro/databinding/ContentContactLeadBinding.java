// Generated by view binder compiler. Do not edit!
package com.policyboss.policybosspro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.policyboss.policybosspro.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ContentContactLeadBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final Button btnSync;

  @NonNull
  public final LinearLayout lySync;

  @NonNull
  public final ProgressBar progressBar;

  @NonNull
  public final RecyclerView rvContactList;

  @NonNull
  public final ScrollView scroll;

  @NonNull
  public final TextView txtCount;

  @NonNull
  public final TextView txtMess;

  @NonNull
  public final TextView txtOutput;

  @NonNull
  public final TextView txtcontain;

  private ContentContactLeadBinding(@NonNull LinearLayout rootView, @NonNull Button btnSync,
      @NonNull LinearLayout lySync, @NonNull ProgressBar progressBar,
      @NonNull RecyclerView rvContactList, @NonNull ScrollView scroll, @NonNull TextView txtCount,
      @NonNull TextView txtMess, @NonNull TextView txtOutput, @NonNull TextView txtcontain) {
    this.rootView = rootView;
    this.btnSync = btnSync;
    this.lySync = lySync;
    this.progressBar = progressBar;
    this.rvContactList = rvContactList;
    this.scroll = scroll;
    this.txtCount = txtCount;
    this.txtMess = txtMess;
    this.txtOutput = txtOutput;
    this.txtcontain = txtcontain;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ContentContactLeadBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ContentContactLeadBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.content_contact_lead, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ContentContactLeadBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnSync;
      Button btnSync = rootView.findViewById(id);
      if (btnSync == null) {
        break missingId;
      }

      id = R.id.lySync;
      LinearLayout lySync = rootView.findViewById(id);
      if (lySync == null) {
        break missingId;
      }

      id = R.id.progressBar;
      ProgressBar progressBar = rootView.findViewById(id);
      if (progressBar == null) {
        break missingId;
      }

      id = R.id.rvContactList;
      RecyclerView rvContactList = rootView.findViewById(id);
      if (rvContactList == null) {
        break missingId;
      }

      id = R.id.scroll;
      ScrollView scroll = rootView.findViewById(id);
      if (scroll == null) {
        break missingId;
      }

      id = R.id.txtCount;
      TextView txtCount = rootView.findViewById(id);
      if (txtCount == null) {
        break missingId;
      }

      id = R.id.txtMess;
      TextView txtMess = rootView.findViewById(id);
      if (txtMess == null) {
        break missingId;
      }

      id = R.id.txtOutput;
      TextView txtOutput = rootView.findViewById(id);
      if (txtOutput == null) {
        break missingId;
      }

      id = R.id.txtcontain;
      TextView txtcontain = rootView.findViewById(id);
      if (txtcontain == null) {
        break missingId;
      }

      return new ContentContactLeadBinding((LinearLayout) rootView, btnSync, lySync, progressBar,
          rvContactList, scroll, txtCount, txtMess, txtOutput, txtcontain);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
