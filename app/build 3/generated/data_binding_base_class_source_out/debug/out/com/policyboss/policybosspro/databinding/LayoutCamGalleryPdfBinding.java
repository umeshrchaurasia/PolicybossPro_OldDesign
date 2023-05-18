// Generated by view binder compiler. Do not edit!
package com.policyboss.policybosspro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.policyboss.policybosspro.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class LayoutCamGalleryPdfBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final LinearLayout lyCamera;

  @NonNull
  public final LinearLayout lyGallery;

  @NonNull
  public final LinearLayout lyPdf;

  private LayoutCamGalleryPdfBinding(@NonNull CardView rootView, @NonNull LinearLayout lyCamera,
      @NonNull LinearLayout lyGallery, @NonNull LinearLayout lyPdf) {
    this.rootView = rootView;
    this.lyCamera = lyCamera;
    this.lyGallery = lyGallery;
    this.lyPdf = lyPdf;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static LayoutCamGalleryPdfBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static LayoutCamGalleryPdfBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.layout_cam_gallery_pdf, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static LayoutCamGalleryPdfBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.lyCamera;
      LinearLayout lyCamera = rootView.findViewById(id);
      if (lyCamera == null) {
        break missingId;
      }

      id = R.id.lyGallery;
      LinearLayout lyGallery = rootView.findViewById(id);
      if (lyGallery == null) {
        break missingId;
      }

      id = R.id.lyPdf;
      LinearLayout lyPdf = rootView.findViewById(id);
      if (lyPdf == null) {
        break missingId;
      }

      return new LayoutCamGalleryPdfBinding((CardView) rootView, lyCamera, lyGallery, lyPdf);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}