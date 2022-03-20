package com.example.examplemvvmapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.widget.Toast;

import com.example.examplemvvmapplication.databinding.ActivityMainBinding;
import com.example.examplemvvmapplication.viewmodel.UserViewModel;

public class MainActivity extends AppCompatActivity {
    private UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initBinding();
//        handleCallApi();
    }
    public void initBinding(){
        ActivityMainBinding mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        userViewModel = new UserViewModel(this);
        mainBinding.setUserViewModel(userViewModel);
    }

//    public void handleCallApi(){
//        userViewModel.onClickCallApi(this);
//    }

}