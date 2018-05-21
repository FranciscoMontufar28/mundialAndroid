package com.francisco.mundialapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.francisco.mundialapp.api.ApiClient;
import com.francisco.mundialapp.api.UserInterface;
import com.francisco.mundialapp.data.Login;
import com.francisco.mundialapp.data.Response;
import com.francisco.mundialapp.databinding.ActivityLoginBinding;
import com.francisco.mundialapp.util.Preferences;

import retrofit2.Call;
import retrofit2.Callback;


public class LoginActivity extends AppCompatActivity {


    SharedPreferences preferences;
    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preferences = getSharedPreferences(Preferences.PREFERENCES_NAME, MODE_PRIVATE);
        boolean logged = preferences.getBoolean(Preferences.KEY_LOGGED, false);
        if (logged){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            return;
        }

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        binding.setLoginHandler(this);
    }

    public void Login(){
        UserInterface retro = ApiClient.getClient().create(UserInterface.class);
        Login login = new Login();
        login.setCedula(binding.cedula.getEditText().getText().toString());
        login.setClave(binding.clave.getEditText().getText().toString());
        Call<Response> call = retro.login(login);
        call.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                Response res = response.body();
                String exitoso = res.isExitoso()?"true": "false";
                if(exitoso.equals("true")){
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString(Preferences.KEY_ID,binding.cedula.getEditText().getText().toString());
                    editor.putBoolean(Preferences.KEY_LOGGED, true);
                    editor.apply();
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);}else{
                    Toast.makeText(LoginActivity.this,"Usuario o Clave incorrectas",Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                Toast.makeText(LoginActivity.this,t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void Registrar(){
        Intent intent = new Intent(this, RegistrarActivity.class);
        startActivity(intent);

    }
}
