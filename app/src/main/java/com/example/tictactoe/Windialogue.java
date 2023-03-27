package com.example.tictactoe;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class Windialogue extends Dialog {
    private final String message;
    private final MainActivity mainActivity;

    public Windialogue(@NonNull Context context, String message, MainActivity mainActivity) {
        super(context);
        this.message = message;


        this.mainActivity = mainActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.win_dialog_layout);

        final TextView msgtxt = findViewById(R.id.msgtxt);
        final Button startagain = findViewById(R.id.startagainbtn);

        msgtxt.setText(message);

        startagain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mainActivity.restartMatch();
                dismiss();
            }
        });
    }
}
