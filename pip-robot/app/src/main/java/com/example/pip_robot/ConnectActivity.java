package com.example.pip_robot;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ConnectActivity extends AppCompatActivity {
    static String IP = null;
    static int PORT = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect);
        getSupportActionBar().hide();

        Button connect = (Button)findViewById(R.id.connect);
        connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IP = GetIP();
                PORT = GetPort();
            }
        });
    }
    public String GetIP() {
        EditText ipBox = (EditText) findViewById(R.id.ipBox);
        return ipBox.getText().toString();
    }
    public int GetPort() {
        EditText portBox = (EditText) findViewById(R.id.portBox);
        return Integer.parseInt(portBox.getText().toString());
    }
}