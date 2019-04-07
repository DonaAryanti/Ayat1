package com.example.al_quran;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity_login extends AppCompatActivity {
    EditText user, pass;
    Button login;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Boolean savelogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user = (EditText) findViewById(R.id.user);
        pass = (EditText) findViewById(R.id.pass);
        login = (Button) findViewById(R.id.login);

        sharedPreferences = getSharedPreferences("loginref", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });


        savelogin = sharedPreferences.getBoolean("savelogin", true);
        if (savelogin == true) {

            user.setText(sharedPreferences.getString("username", null));
            pass.setText(sharedPreferences.getString("password", null));
            Intent intent = new Intent(Activity_login.this, MainActivity.class);
            startActivity(intent);
        }
    }
    public void login() {
        String usrname = user.getText().toString();
        String passwrd = pass.getText().toString();
        if (usrname.equals("admin") && passwrd.equals("123")) {
            Toast.makeText(this, "username and passwrod matched!", Toast.LENGTH_LONG).show();
            editor.putBoolean("savelogin", true);
            editor.putString("username", usrname);
            editor.putString("password", passwrd);
            editor.commit();
            Intent intent = new Intent(Activity_login.this, MainActivity.class);
            startActivity(intent);

        }
    }

}
