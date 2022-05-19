package com.example.pip_robot;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import java.net.*;
import java.io.*;

public class ControlsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controls);
        getSupportActionBar().hide();

        Button art1 = (Button)findViewById(R.id.art1);
        art1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { replaceFragment(new art1fragment());

                CommandSender cs = new CommandSender();
                cs.execute("movej([0,1.57,-1.57,3.14,-1.57,1.57],a=1.4, v=1.05, t=0, r=0)");

            }
        });
        Button art2 = (Button)findViewById(R.id.art2);
        art2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { replaceFragment(new art2fragment()); }
        });
        Button art3 = (Button)findViewById(R.id.art3);
        art3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { replaceFragment(new art3fragment()); }
        });
        Button art4 = (Button)findViewById(R.id.art4);
        art4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { replaceFragment(new art4fragment()); }
        });
        Button art5 = (Button)findViewById(R.id.art5);
        art5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { replaceFragment(new art5fragment()); }
        });
    }
    private void replaceFragment(Fragment fragment) {
        FragmentManager fg = getSupportFragmentManager();
        FragmentTransaction ft = fg.beginTransaction();
        ft.replace(R.id.flFragment, fragment);
        ft.commit();
    }


}