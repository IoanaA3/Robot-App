package com.example.pip_robot;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CommandsActivity extends AppCompatActivity {
    static String comanda = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commands);
        getSupportActionBar().hide();

        TextView console = (TextView) findViewById(R.id.console);
        console.setMovementMethod(new ScrollingMovementMethod());

        Button type = (Button) findViewById(R.id.type);
        type.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (console.getText().toString().matches("")) {
                    comanda = GetCommand();
                    console.append(comanda);
                    CommandSender cs = new CommandSender();
                    cs.execute(comanda);

                }
                else {
                    comanda = GetCommand();
                    console.append("\n" + comanda);
                    CommandSender cs = new CommandSender();
                    cs.execute(comanda);

                }
            }
        });
    }
    public String GetCommand() {
        EditText commandBox = (EditText) findViewById(R.id.commandBox);
        return commandBox.getText().toString();
    }
}