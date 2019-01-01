package com.example.six_1230_week1.Login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.six_1230_week1.Login.presenter.ILoginPresenter;
import com.example.six_1230_week1.Login.view.LoginView;
import com.example.six_1230_week1.R;
import com.example.six_1230_week1.home.ShowActivity;

public class MainActivity extends AppCompatActivity implements LoginView {
    EditText mLogin,mRegister;
    Button mLoginBut,mRegisterBut;
    private ILoginPresenter loginPresenter;
    String mLoginName,mRegisterPswd;
    private TextView viewById;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLogin = findViewById(R.id.login_name_et);
        mRegister = findViewById(R.id.login_pswd_et);
        mLoginBut= findViewById(R.id.login_lgbt);
        viewById = findViewById(R.id.text_view);
        mRegisterBut= findViewById(R.id.login_rebt);
        mLoginName = mLogin.getText().toString();
        mRegisterPswd = mRegister.getText().toString();
        //初始persenter
        loginPresenter = new ILoginPresenter(this);
        mLoginBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mLoginName.isEmpty()&&!mRegisterPswd.isEmpty()){
                    loginPresenter.Login(mLoginName,mRegisterPswd);
                }
            }
        });
    }

    @Override
    public void getPresenterData(final String data) {
        new Thread() {
            public void run() {
                //这儿是耗时操作，完成之后更新UI；
                runOnUiThread(new Runnable(){
                    @Override
                    public void run() {
                        //更新UI
                        viewById.setText(data);
                        startActivity(new Intent(MainActivity.this,ShowActivity.class));
                    }

                });
            }
        }.start();

    }
}
