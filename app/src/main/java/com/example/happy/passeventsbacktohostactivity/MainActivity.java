package com.example.happy.passeventsbacktohostactivity;

import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends FragmentActivity implements NoticeDialogFragment.NoticeDialogListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void showNoticeDialog(View view){

        //Create an instance of dialogFragment and show it.
        DialogFragment dialogFragment =new NoticeDialogFragment();
        dialogFragment.show(getSupportFragmentManager(),"NoticeDialog Frag");
    }

    // The dialog fragment receives a reference to this Activity through the
    // Fragment.onAttach() callback, which it uses to call the following methods
    // defined by the NoticeDialogFragment.NoticeDialogListener interface
    public void onDialogPositiveClick(DialogFragment dialog){
        Toast.makeText(getBaseContext(),"Positive Button Is Clicked",Toast.LENGTH_LONG).show();
    }
    public void onDialognegativeClick(DialogFragment dialog){
        Toast.makeText(getBaseContext(),"Negative Button Is Clicked",Toast.LENGTH_LONG).show();
    }
}
