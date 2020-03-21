package com.dicodingtraining.tumbas.BasicActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.dicodingtraining.tumbas.Helper.SQLiteHelper;
import com.dicodingtraining.tumbas.Model.UserClass;
import com.dicodingtraining.tumbas.R;

public class LoginActivity extends AppCompatActivity {

    EditText editTextEmail;
    EditText editTextPassword;
    Button buttonLogin;
    SQLiteHelper SQLh;
    NotificationCompat.Builder notificationBuilder =  new NotificationCompat.Builder(this);

   private void notificationcall() {
        notificationBuilder.setDefaults(NotificationCompat.DEFAULT_ALL)
                .setSmallIcon(R.drawable.logo_fix)
                //     .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.logo_fix))
                .setContentTitle("You Login TUMBASS")
                .setAutoCancel(true)
                .setContentText("HAI selamat datang di Tumbas");

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1, notificationBuilder.build());
       Intent intent = new Intent(LoginActivity.this, MainActivity.class);
       TaskStackBuilder stackBuilder = TaskStackBuilder.create(LoginActivity.this);
       stackBuilder.addParentStack(MainActivity.class);

       stackBuilder.addNextIntent(intent);

       PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
       notificationBuilder.setContentIntent(resultPendingIntent);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        SQLh = new SQLiteHelper(this);
        initCreateAccountTextView();
        initViews();
        EditText passwordhint = (EditText) findViewById(R.id.editTextPassword);
        passwordhint.setTransformationMethod(new PasswordTransformationMethod());


        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validate()) {

                    String Email = editTextEmail.getText().toString();
                    String Password = editTextPassword.getText().toString();

                    //notificationcall();



                    UserClass currentUser = SQLh.Authenticate(new UserClass(null, null, Email, Password));


                    if (currentUser != null) {

                        Intent i = new Intent(LoginActivity.this, MainActivity.class);


                        notificationcall();
                        startActivity(i);


                        finish();

                    } else {
                    }
                }






            }
        });

    }




    private void initCreateAccountTextView() {
        TextView textViewCreateAccount = (TextView) findViewById(R.id.textViewCreateAccount);
        textViewCreateAccount.setText(fromHtml("<font color='#ffffff'>I don't have account yet. </font><font color='#0c0099'>create one</font>"));
        textViewCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initViews() {
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        buttonLogin = (Button) findViewById(R.id.buttonLogin);

    }

    public static Spanned fromHtml(String html) {
        Spanned result;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            result = Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY);
        } else {
            result = Html.fromHtml(html);
        }
        return result;
    }

    public boolean validate() {
        boolean valid=false;


        String Email = editTextEmail.getText().toString();
        String Password = editTextPassword.getText().toString();


        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
            editTextEmail.setError("Please enter valid email!");
        } else {
            editTextPassword.setError(null);
        }


        if (Password.isEmpty()) {
            valid=false;
            editTextPassword.setError("Please enter valid password!");
        } else {
            if (Password.length() < 5) {
                valid=false;
                editTextPassword.setError("Password incorrect!");
            } else
                valid=true;
                editTextPassword.setError(null);
        }
        return valid;
    }
}
