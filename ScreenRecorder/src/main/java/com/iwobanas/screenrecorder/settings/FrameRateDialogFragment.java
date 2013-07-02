package com.iwobanas.screenrecorder.settings;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextThemeWrapper;

import com.iwobanas.screenrecorder.R;

import java.text.DecimalFormat;

public class FrameRateDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Context contextThemeWrapper = new ContextThemeWrapper(getActivity(), android.R.style.Theme_Holo);
        AlertDialog.Builder builder = new AlertDialog.Builder(contextThemeWrapper);
        builder.setIcon(R.drawable.ic_launcher);
        builder.setTitle(R.string.settings_frame_rate);
        DecimalFormat upTo = new DecimalFormat(getString(R.string.settings_frame_rate_up_to));
        final int[] frameRates = new int[]{-1, 30, 20, 15, 10, 5};
        String[] items = new String[]{getString(R.string.settings_frame_rate_max), upTo.format(30),
                upTo.format(20), upTo.format(15), upTo.format(10), upTo.format(5)};
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Settings.getInstance().setFrameRate(frameRates[i]);
                ((SettingsActivity) getActivity()).settingsChanged();
            }
        });
        return builder.create();
    }
}
