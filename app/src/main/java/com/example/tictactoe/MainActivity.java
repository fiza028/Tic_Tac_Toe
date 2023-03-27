package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final List<int[]> combinationlist = new ArrayList< >();
    private int [] boxpositions = {0,0,0,0,0,0,0,0,0};
    private int playerturn =1;
    private int totalselectedboxes=1;
    private LinearLayout p1ll, p2ll;
    private TextView p1name, p2name;
    private ImageView i1,i2,i3,i4,i5,i6,i7,i8,i9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       p1name = findViewById(R.id.playeronename);
       p2name = findViewById(R.id.playertwoname);
       p1ll = findViewById(R.id.p1layout);
       p2ll = findViewById(R.id.p2layout);

          i1 = findViewById(R.id.i1);
         i2 = findViewById(R.id.i2);
         i3 = findViewById(R.id.i3);
       i4 = findViewById(R.id.i4);
       i5 = findViewById(R.id.i5);
       i6 = findViewById(R.id.i6);
       i7 = findViewById(R.id.i7);
       i8 = findViewById(R.id.i8);
         i9 = findViewById(R.id.i9);

         combinationlist.add(new int[]{0,1,2});
        combinationlist.add(new int[]{3,4,5});
        combinationlist.add(new int[]{6,7,8});
        combinationlist.add(new int[]{0,3,6});
        combinationlist.add(new int[]{1,4,7});
        combinationlist.add(new int[]{2,5,8});
        combinationlist.add(new int[]{2,4,6});
        combinationlist.add(new int[]{0,4,8});

        final String getp1name = getIntent().getStringExtra("playerone");
        final String getp2name = getIntent().getStringExtra("playertwo");

        p1name.setText(getp1name);
        p2name.setText(getp2name);

        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               if( isboxselectable(0)){
                   performaction((ImageView)view,  0);
               }
            }
        });
        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( isboxselectable(1)){
                    performaction((ImageView)view,  1);
                }

            }
        });
        i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( isboxselectable(2)){
                    performaction((ImageView)view,  2);
                }

            }
        });
        i4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( isboxselectable(3)){
                    performaction((ImageView)view,  3);
                }
            }
        });
        i5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( isboxselectable(4)){
                    performaction((ImageView)view,  4);
                }
            }
        });
        i6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( isboxselectable(5)){
                    performaction((ImageView)view,  5);
                }
            }
        });
        i7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( isboxselectable(6)){
                    performaction((ImageView)view,  6);
                }
            }
        });
        i8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( isboxselectable(7)){

                    performaction((ImageView)view,  7);
                }
            }
        });
        i9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( isboxselectable(8)){
                    performaction((ImageView)view,  8);
                }
            }
        });
    }
    private void performaction(ImageView iv, int selecetedboxposition){
        boxpositions[selecetedboxposition] = playerturn;
        if(playerturn==1){
            iv.setImageResource(R.drawable.crossassss);
            if(checkplayerwin()){

                Windialogue windialogue = new Windialogue(MainActivity.this, p1name.getText().toString()+" has won this match", MainActivity.this);
           windialogue.setCancelable(false);
            windialogue.show();
            }
            else if(totalselectedboxes==9){
                Windialogue windialogue = new Windialogue(MainActivity.this, "It's a tie!", MainActivity.this);
                windialogue.show();
            }
            else{
changeplayerturn(2);
totalselectedboxes++;
            }
        }
        else{
            iv.setImageResource(R.drawable.zero);

            if(checkplayerwin()){

                Windialogue windialogue = new Windialogue(MainActivity.this, p2name.getText().toString()+" has won this match", MainActivity.this);
                windialogue.setCancelable(false);
                windialogue.show();
            }
            else if(selecetedboxposition == 9){
                Windialogue windialogue = new Windialogue(MainActivity.this, "It's a tie!", MainActivity.this);
                windialogue.setCancelable(false);
                windialogue.show();
            }
            else {
                changeplayerturn(1);
                totalselectedboxes++;
            }
        }
    }
    private void changeplayerturn(int currentplayerTurn){
playerturn = currentplayerTurn;
if(playerturn == 1){
    p1ll.setBackgroundResource(R.drawable.back);
    p2ll.setBackgroundResource(R.drawable.back);
}
else{
    p2ll.setBackgroundResource(R.drawable.back);
    p1ll.setBackgroundResource(R.drawable.back);
}
    }
    private boolean checkplayerwin(){
        boolean response = false;
        for(int i=0;i<combinationlist.size();i++)
        {
            final int [] combination = combinationlist.get(i);

            if(boxpositions[combination[0]]==playerturn && boxpositions[combination[1]]==playerturn && boxpositions[combination[2]]==playerturn)
            {
                response = true;
            }
        }
        return response;
    }
    private boolean isboxselectable(int boxposit){
        boolean response = false;
        if(boxpositions[boxposit]==0)
        {
            response = true;
        }
return response;
    }
    public void restartMatch(){
        boxpositions = new int[]{0,0,0,0,0,0,0,0,0};
        playerturn = 1;
        totalselectedboxes=1;
        i1.setImageResource(R.drawable.orange);
        i2.setImageResource(R.drawable.orange);
        i3.setImageResource(R.drawable.orange);
        i4.setImageResource(R.drawable.orange);
        i5.setImageResource(R.drawable.orange);
        i6.setImageResource(R.drawable.orange);
        i7.setImageResource(R.drawable.orange);
        i8.setImageResource(R.drawable.orange);
        i9.setImageResource(R.drawable.orange);
    }
}