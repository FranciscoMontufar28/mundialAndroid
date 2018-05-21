package com.francisco.mundialapp;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.francisco.mundialapp.api.ApiClient;
import com.francisco.mundialapp.api.RegisterInterface;
import com.francisco.mundialapp.api.UserInterface;
import com.francisco.mundialapp.data.Response;
import com.francisco.mundialapp.data.User;
import com.francisco.mundialapp.databinding.ActivityRegistrarBinding;

import retrofit2.Call;
import retrofit2.Callback;

public class RegistrarActivity extends AppCompatActivity {

    ActivityRegistrarBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_registrar);
        binding.setRegistroHandler(this);
    }

        public void Registrar(){
            RegisterInterface retro = ApiClient.getClient().create(RegisterInterface.class);
            User user = new User();
            user.setName(binding.RegNombre.getEditText().getText().toString());
            user.setLastname(binding.RegApellido.getEditText().getText().toString());
            user.setIdentification(binding.RegCedula.getEditText().getText().toString());
            user.setPassword(binding.RegClave.getEditText().getText().toString());
            Toast.makeText(RegistrarActivity.this,""+binding.RegNombre.getEditText().getText().toString()+binding.RegApellido.getEditText().getText().toString()+binding.RegCedula.getEditText().getText().toString()+binding.RegClave.getEditText().getText().toString(),Toast.LENGTH_SHORT).show();
            Call<Response> call = retro.addUser(user);
            call.enqueue(new Callback<Response>() {
                @Override
                public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                    Response res = response.body();
                    String exitoso = res.isExitoso()?"true": "false";
                    String msg = res.getMsg() + exitoso;
                    Toast.makeText(RegistrarActivity.this,msg,Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<Response> call, Throwable t) {
                    Toast.makeText(RegistrarActivity.this,t.getMessage(),Toast.LENGTH_SHORT).show();
                }
            });

    }
        public void Cancelar(){
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }
    }

