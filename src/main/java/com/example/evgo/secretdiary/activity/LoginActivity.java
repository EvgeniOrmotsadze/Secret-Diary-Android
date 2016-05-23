package com.example.evgo.secretdiary.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.evgo.secretdiary.R;

/**
 * Created by evgo on 6/1/2015.
 * this activity for login for users
 */
public class LoginActivity extends Activity {

    private Button register;
    private Button login;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        if (getIntent().getBooleanExtra("EXIT", false)) {
            finish();
        }
        register = (Button) findViewById(R.id.register_btn);
        login = (Button) findViewById(R.id.login_btn);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    public void callSingUp(View view){
        Intent singUpActivity = new Intent(view.getContext(),SingUpActivity.class);
        startActivity(singUpActivity);
    }

    public void callRegister(View view){
        Intent registerActivity = new Intent(view.getContext(),RegisterActivity.class);
        startActivity(registerActivity);
    }
}
