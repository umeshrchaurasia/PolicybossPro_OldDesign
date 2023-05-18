// Generated by view binder compiler. Do not edit!
package com.policyboss.policybosspro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
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

public final class ActivityWelcomeSyncContactNewBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final Button btnNext;

  @NonNull
  public final TextView btnSkip;

  @NonNull
  public final CheckBox chkagree;

  @NonNull
  public final CheckBox chkcommunication;

  @NonNull
  public final CheckBox chktele;

  @NonNull
  public final ImageView dot1;

  @NonNull
  public final ImageView dot2;

  @NonNull
  public final ImageView dot3;

  @NonNull
  public final LinearLayout layoutDots;

  @NonNull
  public final LinearLayout llDontKnow;

  @NonNull
  public final LinearLayout llTerm;

  @NonNull
  public final TextView tvClickHere;

  @NonNull
  public final TextView txtprivacy;

  @NonNull
  public final TextView txtterm;

  @NonNull
  public final TextView txttermspace;

  private ActivityWelcomeSyncContactNewBinding(@NonNull LinearLayout rootView,
      @NonNull Button btnNext, @NonNull TextView btnSkip, @NonNull CheckBox chkagree,
      @NonNull CheckBox chkcommunication, @NonNull CheckBox chktele, @NonNull ImageView dot1,
      @NonNull ImageView dot2, @NonNull ImageView dot3, @NonNull LinearLayout layoutDots,
      @NonNull LinearLayout llDontKnow, @NonNull LinearLayout llTerm, @NonNull TextView tvClickHere,
      @NonNull TextView txtprivacy, @NonNull TextView txtterm, @NonNull TextView txttermspace) {
    this.rootView = rootView;
    this.btnNext = btnNext;
    this.btnSkip = btnSkip;
    this.chkagree = chkagree;
    this.chkcommunication = chkcommunication;
    this.chktele = chktele;
    this.dot1 = dot1;
    this.dot2 = dot2;
    this.dot3 = dot3;
    this.layoutDots = layoutDots;
    this.llDontKnow = llDontKnow;
    this.llTerm = llTerm;
    this.tvClickHere = tvClickHere;
    this.txtprivacy = txtprivacy;
    this.txtterm = txtterm;
    this.txttermspace = txttermspace;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityWelcomeSyncContactNewBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityWelcomeSyncContactNewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_welcome_sync_contact_new, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityWelcomeSyncContactNewBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnNext;
      Button btnNext = rootView.findViewById(id);
      if (btnNext == null) {
        break missingId;
      }

      id = R.id.btn_skip;
      TextView btnSkip = rootView.findViewById(id);
      if (btnSkip == null) {
        break missingId;
      }

      id = R.id.chkagree;
      CheckBox chkagree = rootView.findViewById(id);
      if (chkagree == null) {
        break missingId;
      }

      id = R.id.chkcommunication;
      CheckBox chkcommunication = rootView.findViewById(id);
      if (chkcommunication == null) {
        break missingId;
      }

      id = R.id.chktele;
      CheckBox chktele = rootView.findViewById(id);
      if (chktele == null) {
        break missingId;
      }

      id = R.id.dot1;
      ImageView dot1 = rootView.findViewById(id);
      if (dot1 == null) {
        break missingId;
      }

      id = R.id.dot2;
      ImageView dot2 = rootView.findViewById(id);
      if (dot2 == null) {
        break missingId;
      }

      id = R.id.dot3;
      ImageView dot3 = rootView.findViewById(id);
      if (dot3 == null) {
        break missingId;
      }

      id = R.id.layoutDots;
      LinearLayout layoutDots = rootView.findViewById(id);
      if (layoutDots == null) {
        break missingId;
      }

      id = R.id.llDontKnow;
      LinearLayout llDontKnow = rootView.findViewById(id);
      if (llDontKnow == null) {
        break missingId;
      }

      id = R.id.ll_term;
      LinearLayout llTerm = rootView.findViewById(id);
      if (llTerm == null) {
        break missingId;
      }

      id = R.id.tvClickHere;
      TextView tvClickHere = rootView.findViewById(id);
      if (tvClickHere == null) {
        break missingId;
      }

      id = R.id.txtprivacy;
      TextView txtprivacy = rootView.findViewById(id);
      if (txtprivacy == null) {
        break missingId;
      }

      id = R.id.txtterm;
      TextView txtterm = rootView.findViewById(id);
      if (txtterm == null) {
        break missingId;
      }

      id = R.id.txttermspace;
      TextView txttermspace = rootView.findViewById(id);
      if (txttermspace == null) {
        break missingId;
      }

      return new ActivityWelcomeSyncContactNewBinding((LinearLayout) rootView, btnNext, btnSkip,
          chkagree, chkcommunication, chktele, dot1, dot2, dot3, layoutDots, llDontKnow, llTerm,
          tvClickHere, txtprivacy, txtterm, txttermspace);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}