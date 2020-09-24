package com.example.home.wieyes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.EditText;
import java.lang.String;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    public static SharedPreferences sharedpreferences;


    EditText username,ename1,ename2,enumber1,enumber2;
    //    String flg="false";
    public static final String mypreference = "mypref";
    public static final String UserName = "usernameKey";
    public static final String EName1 = "ename1Key";
    public static final String EPhone1 = "ephone1Key";
    public static final String EName2 = "ename2Key";
    public static final String EPhone2 = "ephone2Key";
    //  public static final String Flag="flagKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.editText1);
        ename1 = findViewById(R.id.editText2);
        enumber1 = findViewById(R.id.editText3);
        ename2 = findViewById(R.id.editText4);
        enumber2 = findViewById(R.id.editText5);
        sharedpreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE);

        if (sharedpreferences.contains(UserName)) {
            username.setText(sharedpreferences.getString(UserName, ""));
        }

        if (sharedpreferences.contains(EName1)) {
            ename1.setText(sharedpreferences.getString(EName1, ""));
        }

        if (sharedpreferences.contains(EPhone1)) {
            enumber1.setText(sharedpreferences.getString(EPhone1, ""));
        }
        if (sharedpreferences.contains(EName2)) {
            ename2.setText(sharedpreferences.getString(EName2, ""));
        }
        if (sharedpreferences.contains(EPhone2)) {
            enumber2.setText(sharedpreferences.getString(EPhone2, ""));
        }
        //   if(!sharedpreferences.contains(Flag)) {

        //      flg = "true";
        //    }

    }
    public void Next(View view) {
        String n = username.getText().toString();
        String en1 = ename1.getText().toString();
        String ph1 = enumber1.getText().toString();
        String en2 = ename2.getText().toString();
        String ph2 = enumber2.getText().toString();
        SharedPreferences.Editor editor = sharedpreferences.edit();


        if(ph1.length()==10 && ph2.length()==10) {
            editor.putString(UserName, n);
            editor.putString(EName1, en1);
            editor.putString(EPhone1, ph1);
            editor.putString(EName2, en2);
            editor.putString(EPhone2, ph2);
            getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                    .putBoolean("isFirstRun", false).apply();
            //editor.putString(Flag,flg);
            editor.apply();
            startActivity(new Intent(this,  MainActivity.class));

        }
        else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder

                    .setMessage("Incorrect Phone number!!!")
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(Login.this, "Enter correct number.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setNegativeButton("Cancel",null)
                    .show();


        }
    }
}

