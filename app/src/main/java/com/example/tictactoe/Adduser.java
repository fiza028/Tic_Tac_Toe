package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Adduser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adduser);

        final EditText playerone = findViewById(R.id.playerone);
        final EditText playertwo = findViewById(R.id.playertwo);
        final Button btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String p1name = playerone.getText().toString();
                final String p2name = playertwo.getText().toString();

                if(p1name.isEmpty() || p2name.isEmpty())
                {
                    Toast.makeText(Adduser.this, "Please enter player names", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent intent = new Intent(Adduser.this, MainActivity.class);
                    intent.putExtra("playerone", p1name);
                    intent.putExtra("playertwo", p2name);
                    startActivity(intent);
                }
            }
        });
    }
}