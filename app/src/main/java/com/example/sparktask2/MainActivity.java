package com.example.sparktask2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

import de.hdodenhof.circleimageview.CircleImageView;

import static android.provider.ContactsContract.Intents.Insert.EMAIL;

public class MainActivity extends AppCompatActivity {
private LoginButton  loginButton;
private CircleImageView circleImageView;
private TextView profile_Name,getTextemial;

private CallbackManager callbackManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        loginButton=findViewById(R.id.login_button);
        circleImageView=findViewById(R.id.profile_pic);
        profile_Name=findViewById(R.id.profile_Name);

        callbackManager = CallbackManager.Factory.create();
        loginButton.setReadPermissions(Arrays.asList("email","public_profile"));
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {




            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);

        super.onActivityResult(requestCode, resultCode, data);
    }

AccessTokenTracker tokenTracker = new AccessTokenTracker() {
    @Override
    protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken)
    {

        if (currentAccessToken==null){

            profile_Name.setText(" ");
           Toast.makeText(MainActivity.this, "User Logut", Toast.LENGTH_SHORT).show();
        }else {
            loaduser(currentAccessToken);
        }

    }
};
    private  void  loaduser(AccessToken newAcessToken){

        final GraphRequest request=GraphRequest.newMeRequest(newAcessToken, new GraphRequest.GraphJSONObjectCallback() {
            @Override
            public void onCompleted(JSONObject object, GraphResponse response) {
                try {
                    String  f_name=object.getString("first_name");
                    String  l_name=object.getString("last_name");
                   // String   email=object.getString("email");
//                    String  id=object.getString("id");
//                    String im_url="https://graph.facebook.com/"+id+"/picture?type=normal";



                profile_Name.setText(f_name +" "+ l_name);

                RequestOptions requestOptions=new RequestOptions();
                requestOptions.dontAnimate();


//                    Glide.with(MainActivity.this).load(im_url).into(circleImageView);

                }
                catch (JSONException e){
                    e.printStackTrace();

                }
            }
        });


    }
}