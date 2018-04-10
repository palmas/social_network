package com.rsa.android.socialnetwork;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by work on 10.04.2018.
 */

public class ProfileActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    @BindView(R.id.txtUserName)
    TextView txtUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);
        firebaseAuth = FirebaseAuth.getInstance();
        txtUserName.setText("Вы вошли под именем " + firebaseAuth.getCurrentUser().getDisplayName());
    }

    @OnClick(R.id.btnLogout)
    public void onLogout() {
        firebaseAuth.signOut();
        startActivity(new Intent(this, AuthActivity.class));
        finish();
    }
}
