package project.aamir.sheikh.eandpedittextexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import project.aamir.sheikh.eandpedittext.EEditText;
import project.aamir.sheikh.eandpedittext.PEditText;

public class MainActivity extends AppCompatActivity {
    EEditText eEditText;
    PEditText pEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialze just like you do normally
        pEditText = (PEditText) findViewById(R.id.pedit);
        eEditText = (EEditText) findViewById(R.id.eedit);
        

        //Use Email Edit Text Properties

        /********************************************************************************
        eEditText.setTextSize(15);
        eEditText.setTextColor(getResources().getColor(android.R.color.holo_blue_bright));
        eEditText.setTextHintColor(getResources().getColor(R.color.colorAccent));
        eEditText.setIconBackgroundColor(getResources().getColor(R.color.colorPrimary));
        eEditText.setIcon(R.mipmap.ic_launcher);
        eEditText.setTickIconColor(getResources().getColor(R.color.colorPrimaryDark));
        eEditText.setErrorMessage("Email Provided is invalid");
        eEditText.setHintText("Lorem Ipsum");
        eEditText.setTextHintColor(getResources().getColor(R.color.colorPrimaryDark));
        *******************************************************************************/

        //Use Password Edit Text Properties

        /********************************************************************************
        pEditText.setEyeOnIcon(R.mipmap.ic_launcher);
         pEditText.setEyeOffIcon(R.mipmap.ic_launcher);
        pEditText.setText("password");
        pEditText.setTextSize(15);
        pEditText.setTextColor(getResources().getColor(android.R.color.holo_blue_bright));
        pEditText.setTextHintColor(getResources().getColor(R.color.colorAccent));
        pEditText.setIconBackgroundColor(getResources().getColor(R.color.colorPrimary));
        pEditText.setIcon(R.mipmap.ic_launcher);
        pEditText.setHintText("Lorem Ipsum");
        pEditText.setTextHintColor(getResources().getColor(R.color.colorPrimaryDark));
        *******************************************************************************/
    }
}
