// Generated by view binder compiler. Do not edit!
package com.policyboss.policybosspro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.policyboss.policybosspro.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentHealthApplicationBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final EditText etSearch;

  @NonNull
  public final ImageView ivAdd;

  @NonNull
  public final ImageView ivSearch;

  @NonNull
  public final LinearLayout llSearch;

  @NonNull
  public final RecyclerView rvHealthApplicationList;

  @NonNull
  public final TextView tvAdd;

  @NonNull
  public final TextView tvSearch;

  private FragmentHealthApplicationBinding(@NonNull RelativeLayout rootView,
      @NonNull EditText etSearch, @NonNull ImageView ivAdd, @NonNull ImageView ivSearch,
      @NonNull LinearLayout llSearch, @NonNull RecyclerView rvHealthApplicationList,
      @NonNull TextView tvAdd, @NonNull TextView tvSearch) {
    this.rootView = rootView;
    this.etSearch = etSearch;
    this.ivAdd = ivAdd;
    this.ivSearch = ivSearch;
    this.llSearch = llSearch;
    this.rvHealthApplicationList = rvHealthApplicationList;
    this.tvAdd = tvAdd;
    this.tvSearch = tvSearch;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentHealthApplicationBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentHealthApplicationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_health_application, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentHealthApplicationBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.etSearch;
      EditText etSearch = rootView.findViewById(id);
      if (etSearch == null) {
        break missingId;
      }

      id = R.id.ivAdd;
      ImageView ivAdd = rootView.findViewById(id);
      if (ivAdd == null) {
        break missingId;
      }

      id = R.id.ivSearch;
      ImageView ivSearch = rootView.findViewById(id);
      if (ivSearch == null) {
        break missingId;
      }

      id = R.id.llSearch;
      LinearLayout llSearch = rootView.findViewById(id);
      if (llSearch == null) {
        break missingId;
      }

      id = R.id.rvHealthApplicationList;
      RecyclerView rvHealthApplicationList = rootView.findViewById(id);
      if (rvHealthApplicationList == null) {
        break missingId;
      }

      id = R.id.tvAdd;
      TextView tvAdd = rootView.findViewById(id);
      if (tvAdd == null) {
        break missingId;
      }

      id = R.id.tvSearch;
      TextView tvSearch = rootView.findViewById(id);
      if (tvSearch == null) {
        break missingId;
      }

      return new FragmentHealthApplicationBinding((RelativeLayout) rootView, etSearch, ivAdd,
          ivSearch, llSearch, rvHealthApplicationList, tvAdd, tvSearch);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
