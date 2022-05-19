package com.example.pip_robot;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        ImageButton connectButton = (ImageButton)findViewById(R.id.connectButton);
        connectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { openConnectActivity(); }
        });

        ImageButton controlsButton = (ImageButton)findViewById(R.id.controlsButton);
        controlsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openControlsActivity();
                Toast.makeText(MainActivity.this, "Press a button in order to choose a joint", Toast.LENGTH_LONG).show();
            }
        });
        ImageButton commandsButton = (ImageButton)findViewById(R.id.commandsButton);
        commandsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { openCommandsActivity(); }
        });
    }
    public void openConnectActivity() {
        Intent intent = new Intent(this, ConnectActivity.class);
        startActivity(intent);
    }
    public void openControlsActivity() {
        Intent intent = new Intent(this, ControlsActivity.class);
        startActivity(intent);
    }
    public void openCommandsActivity() {
        Intent intent = new Intent(this, CommandsActivity.class);
        startActivity(intent);
    }
}