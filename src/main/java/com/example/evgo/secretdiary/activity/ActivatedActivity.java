package com.example.evgo.secretdiary.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.evgo.secretdiary.App;
import com.example.evgo.secretdiary.R;
import com.example.evgo.secretdiary.database.DbService;
import com.example.evgo.secretdiary.model.User;

/**
 * Created by evgo on 6/1/2015.
 * this activity for last user
 * which use this application on this mobile phone
 * save mobile id and don't need sing in any more after first sing up
 *
 */
public class ActivatedActivity extends Activity {

    private EditText password;
    private Button btn;
    private boolean exit = false;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activated_layout);

        password = (EditText) findViewById(R.id.activated_password);
        password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        btn = (Button) findViewById(R.id.activated_btn);

    }

    public void onBackPressed() {
        if (exit) {
            finish(); // finish activity
        } else {
            Toast.makeText(this, "Press Back again to Exit.",
                    Toast.LENGTH_SHORT).show();
            exit = true;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    exit = false;
                }
            }, 3 * 1000);
        }
    }


    public void activateUser(View view){
        String userP = password.getText().toString();
        String phoneId = ((App)getApplicationContext()).getPhone_id();
        DbService db = new DbService(App.getSqlLite());
        User user = db.getUserFromPP(userP, phoneId);
        password.setText("");
        if(user != null) {
            Intent activated = new Intent(this, DiaryActivity.class);
            activated.putExtra("User", user);
            startActivity(activated);
        }
    }
}
