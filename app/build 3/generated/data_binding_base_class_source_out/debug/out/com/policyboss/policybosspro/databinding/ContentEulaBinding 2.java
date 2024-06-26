// Generated by view binder compiler. Do not edit!
package com.policyboss.policybosspro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.policyboss.policybosspro.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ContentEulaBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final Button btnAgree;

  @NonNull
  public final Button btnDisAgree;

  @NonNull
  public final WebView webView;

  private ContentEulaBinding(@NonNull LinearLayout rootView, @NonNull Button btnAgree,
      @NonNull Button btnDisAgree, @NonNull WebView webView) {
    this.rootView = rootView;
    this.btnAgree = btnAgree;
    this.btnDisAgree = btnDisAgree;
    this.webView = webView;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ContentEulaBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ContentEulaBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.content_eula, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ContentEulaBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnAgree;
      Button btnAgree = rootView.findViewById(id);
      if (btnAgree == null) {
        break missingId;
      }

      id = R.id.btnDisAgree;
      Button btnDisAgree = rootView.findViewById(id);
      if (btnDisAgree == null) {
        break missingId;
      }

      id = R.id.webView;
      WebView webView = rootView.findViewById(id);
      if (webView == null) {
        break missingId;
      }

      return new ContentEulaBinding((LinearLayout) rootView, btnAgree, btnDisAgree, webView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
