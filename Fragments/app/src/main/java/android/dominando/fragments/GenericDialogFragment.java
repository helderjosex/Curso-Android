package android.dominando.fragments;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

/**
 * Created by Mac on 12/03/15.
 */
public class GenericDialogFragment extends DialogFragment implements DialogInterface.OnClickListener {

    private static final String EXTRA_ID = "id";
    private static final String EXTRA_MESSAGE = "message";
    private static final String EXTRA_TITLE = "title";
    private static final String EXTRA_BUTTONS = "buttons";
    private static final String DIALOG_TAG = "SimpleDialog";

    private int mDialogId;

    public static GenericDialogFragment newDialog( int id, int title, int message, int[] buttonTexts){

        Bundle bundle = new Bundle();
        bundle.putInt(EXTRA_ID,id);
        bundle.putInt(EXTRA_TITLE,title);
        bundle.putInt(EXTRA_MESSAGE,message);
        bundle.putIntArray(EXTRA_BUTTONS,buttonTexts);

        GenericDialogFragment dialog = new GenericDialogFragment();
        dialog.setArguments(bundle);
        return dialog;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        mDialogId = getArguments().getInt(EXTRA_ID);
        int title = getArguments().getInt(EXTRA_TITLE);
        int message = getArguments().getInt(EXTRA_MESSAGE);
        int[] buttons = getArguments().getIntArray(EXTRA_BUTTONS);

        AlertDialog.Builder alertDialogBuider = new AlertDialog.Builder(getActivity());
        alertDialogBuider.setTitle(title);
        alertDialogBuider.setMessage(message);

        switch (buttons.length){
            case 3:
                alertDialogBuider.setNeutralButton(buttons[2],this);
            case 2:
                alertDialogBuider.setNegativeButton(buttons[1],this);
            case 1:
                alertDialogBuider.setPositiveButton(buttons[0],this);

        }

        return alertDialogBuider.create();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        Activity activity = getActivity();

        if (activity instanceof AoClicarNoDialog) {
            AoClicarNoDialog listener = (AoClicarNoDialog) activity;
            listener.aoClicar(mDialogId, which);
        }
    }
    public void abrir(FragmentManager supportFragmentManager){
        Fragment dialogFragment = supportFragmentManager.findFragmentByTag(DIALOG_TAG);

        if(dialogFragment == null){
            show(supportFragmentManager,DIALOG_TAG);
        }
    }
    public interface AoClicarNoDialog {
        void aoClicar(int id, int button);
    }

}
