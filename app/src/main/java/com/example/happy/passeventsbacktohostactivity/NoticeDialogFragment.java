package com.example.happy.passeventsbacktohostactivity;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class NoticeDialogFragment extends DialogFragment {


    public NoticeDialogFragment() {
        // Required empty public constructor
    }

    /*The activity that creates the instance of this dialogFragment
    * Must implement this interface in order to recieve the event callbacks
    * Each method passes the dialog fragment to the activity for the activity to query it*/

    public interface NoticeDialogListener{
        public void onDialogPositiveClick(DialogFragment dialogFragment);
        public void onDialognegativeClick(DialogFragment dialogFragment);
    }

    //Use instance of this interface to deliver action events
    NoticeDialogListener mDialogListener;

    //Override the Fragment.onAttach() to instantiate the NoticeDialogLitener
    public void onAttach(Activity activity){
        super.onAttach(activity);
        //Verify that the host activity implements the callback interface
        try{
            mDialogListener = (NoticeDialogListener) activity;
        }catch (ClassCastException cce){
            throw new ClassCastException(activity.toString()+" must implement NoticeDialogListener");
        }
    }

    public Dialog onCreateDialog(Bundle savedInstance){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Fire Missiles")
                .setPositiveButton("fire", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mDialogListener.onDialogPositiveClick(NoticeDialogFragment.this);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mDialogListener.onDialognegativeClick(NoticeDialogFragment.this);
                    }
                });
        return builder.create();
    }

}
