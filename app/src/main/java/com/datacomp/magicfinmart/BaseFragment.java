package com.datacomp.magicfinmart;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Rohit on 17/01/16.
 */
public class BaseFragment extends Fragment {
    PopUpListener popUpListener;
    ProgressDialog dialog;

    public BaseFragment() {

    }

    public void registerPopUp(PopUpListener popUpListener) {
        this.popUpListener = popUpListener;
    }

    protected void cancelDialog() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();

    }

    protected void showDialog() {
        showDialog("Loading...");
    }

    protected void showDialog(String msg) {
        dialog = ProgressDialog.show(getActivity(), "", msg, true);
    }

    public void sendSms(String mobNumber) {
        try {
            mobNumber = mobNumber.replaceAll("\\s", "");
            mobNumber = mobNumber.replaceAll("\\+", "");
            mobNumber = mobNumber.replaceAll("-", "");
            mobNumber = mobNumber.replaceAll(",", "");
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", mobNumber, null)));
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getActivity(), "Invalid Number", Toast.LENGTH_SHORT).show();
        }

    }

    public void dialNumber(String mobNumber) {
        try {
            mobNumber = mobNumber.replaceAll("\\s", "");
            mobNumber = mobNumber.replaceAll("\\+", "");
            mobNumber = mobNumber.replaceAll("-", "");
            mobNumber = mobNumber.replaceAll(",", "");
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:" + mobNumber));
            if (ActivityCompat.checkSelfPermission(getActivity(), android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            startActivity(callIntent);
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getActivity(), "Invalid Number", Toast.LENGTH_SHORT).show();
        }
    }

    public static boolean isValidePhoneNumber(EditText editText) {
        String phoneNumberPattern = "^(?:(?:\\+|0{0,2})91(\\s*[\\-]\\s*)?|[0]?)?[789]\\d{9}$";
        String phoneNumberEntered = editText.getText().toString().trim();
        return !(phoneNumberEntered.isEmpty() || !phoneNumberEntered.matches(phoneNumberPattern));
    }

    public static boolean isValideEmailID(EditText editText) {
        String emailEntered = editText.getText().toString().trim();
        return !(emailEntered.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(emailEntered).matches());
    }

    public static boolean isEmpty(EditText editText) {
        String text = editText.getText().toString().trim();
        return !(text.isEmpty());
    }

    public static boolean validatePhoneNumber(EditText editText) {
        String phoneNumberPattern = "^(?:(?:\\+|0{0,2})91(\\s*[\\-]\\s*)?|[0]?)?[789]\\d{9}$";
        String phoneNumberEntered = editText.getText().toString().trim();
        if (phoneNumberEntered.isEmpty() || !phoneNumberEntered.matches(phoneNumberPattern)) {
            return false;
        }
        return true;
    }

    public static boolean isValidPan(String Pan) {
//        String rx = "/[A-Z]{5}[0-9]{4}[A-Z]{1}$/";
        Pattern pattern = Pattern.compile("[A-Z]{5}[0-9]{4}[A-Z]{1}");
        Matcher matcher = pattern.matcher(Pan);
        if (matcher.matches()) {
            return true;

        } else {
            return false;
        }
    }


    public String getDateFromAge(int age) {
        Calendar cal = Calendar.getInstance();
        int year = age;
        cal.add(Calendar.YEAR, -year);
        return new SimpleDateFormat("dd-MM-yyyy").format(cal.getTime());
    }

    public int getAgeFromDate(String birthdate) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Calendar bithDate = Calendar.getInstance();
            bithDate.setTime(dateFormat.parse(birthdate));
            Calendar today = Calendar.getInstance();
            int curYear = today.get(Calendar.YEAR);
            int dobYear = bithDate.get(Calendar.YEAR);

            return curYear - dobYear;

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public interface PopUpListener {

        void onPositiveButtonClick(Dialog dialog, View view);

        void onCancelButtonClick(Dialog dialog, View view);
    }

    public void openPopUp(final View view, String title, String desc, String positiveButtonName, boolean isCancelable) {
        try {
            final Dialog dialog;
            dialog = new Dialog(getActivity());
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.layout_common_popup);

            TextView tvTitle = (TextView) dialog.findViewById(R.id.tvTitle);
            tvTitle.setText(title);
            TextView tvOk = (TextView) dialog.findViewById(R.id.tvOk);
            tvOk.setText(positiveButtonName);
            TextView txtMessage = (TextView) dialog.findViewById(R.id.txtMessage);
            txtMessage.setText(desc);
            ImageView ivCross = (ImageView) dialog.findViewById(R.id.ivCross);

            dialog.setCancelable(isCancelable);
            dialog.setCanceledOnTouchOutside(isCancelable);

            Window dialogWindow = dialog.getWindow();
            WindowManager.LayoutParams lp = dialogWindow.getAttributes();
            lp.width = lp.MATCH_PARENT;  // Width
            lp.height = lp.WRAP_CONTENT; // Height
            dialogWindow.setAttributes(lp);

            dialog.show();
            tvOk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Close dialog
                    popUpListener.onPositiveButtonClick(dialog, view);
                }
            });

            ivCross.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Close dialog
                    popUpListener.onCancelButtonClick(dialog, view);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
