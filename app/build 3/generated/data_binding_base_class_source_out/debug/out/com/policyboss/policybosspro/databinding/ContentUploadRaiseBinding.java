// Generated by view binder compiler. Do not edit!
package com.policyboss.policybosspro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.policyboss.policybosspro.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ContentUploadRaiseBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final Button btnSubmit;

  @NonNull
  public final EditText etComment;

  @NonNull
  public final ImageView ivCross;

  @NonNull
  public final ImageView ivProfile;

  @NonNull
  public final ImageView ivUser;

  @NonNull
  public final ScrollView mainScrollView;

  @NonNull
  public final TextView textView1;

  @NonNull
  public final TextView textView3;

  @NonNull
  public final TextView txtTile;

  private ContentUploadRaiseBinding(@NonNull LinearLayout rootView, @NonNull Button btnSubmit,
      @NonNull EditText etComment, @NonNull ImageView ivCross, @NonNull ImageView ivProfile,
      @NonNull ImageView ivUser, @NonNull ScrollView mainScrollView, @NonNull TextView textView1,
      @NonNull TextView textView3, @NonNull TextView txtTile) {
    this.rootView = rootView;
    this.btnSubmit = btnSubmit;
    this.etComment = etComment;
    this.ivCross = ivCross;
    this.ivProfile = ivProfile;
    this.ivUser = ivUser;
    this.mainScrollView = mainScrollView;
    this.textView1 = textView1;
    this.textView3 = textView3;
    this.txtTile = txtTile;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ContentUploadRaiseBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ContentUploadRaiseBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.content_upload_raise, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ContentUploadRaiseBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_submit;
      Button btnSubmit = rootView.findViewById(id);
      if (btnSubmit == null) {
        break missingId;
      }

      id = R.id.et_Comment;
      EditText etComment = rootView.findViewById(id);
      if (etComment == null) {
        break missingId;
      }

      id = R.id.ivCross;
      ImageView ivCross = rootView.findViewById(id);
      if (ivCross == null) {
        break missingId;
      }

      id = R.id.ivProfile;
      ImageView ivProfile = rootView.findViewById(id);
      if (ivProfile == null) {
        break missingId;
      }

      id = R.id.ivUser;
      ImageView ivUser = rootView.findViewById(id);
      if (ivUser == null) {
        break missingId;
      }

      id = R.id.mainScrollView;
      ScrollView mainScrollView = rootView.findViewById(id);
      if (mainScrollView == null) {
        break missingId;
      }

      id = R.id.textView1;
      TextView textView1 = rootView.findViewById(id);
      if (textView1 == null) {
        break missingId;
      }

      id = R.id.textView3;
      TextView textView3 = rootView.findViewById(id);
      if (textView3 == null) {
        break missingId;
      }

      id = R.id.txtTile;
      TextView txtTile = rootView.findViewById(id);
      if (txtTile == null) {
        break missingId;
      }

      return new ContentUploadRaiseBinding((LinearLayout) rootView, btnSubmit, etComment, ivCross,
          ivProfile, ivUser, mainScrollView, textView1, textView3, txtTile);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
