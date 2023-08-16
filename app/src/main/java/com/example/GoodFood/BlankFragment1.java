package com.example.GoodFood;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.ButtonBarLayout;
import androidx.fragment.app.Fragment;

import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.afinal.R;

public class BlankFragment1 extends Fragment{


    private Button button_timer;
    private EditText timer;
    private EditText text1;
    private EditText text2;
    private Button button_save1;
    private Button button_save2;
    private Button button3;
    private SharedPreferences sPreferences;
    private SharedPreferences sPreferences2;
    private String timer_help;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank1, container, false);
        button_timer = view.findViewById(R.id.button_timer);
        button_save1 = view.findViewById(R.id.button_save1);
        button_save2 = view.findViewById(R.id.button_save2);
        button3 = view.findViewById(R.id.button3);
        timer = view.findViewById(R.id.timer);
        timer.setText("");
        text1 = view.findViewById(R.id.text1);
        text2 = view.findViewById(R.id.text2);
        init();
        init2();


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.setText("");
            }
        });

        button_save1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sPreferences.edit();
                editor.putString("key1", text1.getText().toString());
                editor.apply();

            }
        });
        button_save2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sPreferences2.edit();
                editor.putString("key2", text2.getText().toString());
                editor.apply();

            }
        });


                button_timer.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        if (!timer.getText().toString().equals("")) {

                            long seconds = Long.parseLong(timer.getText().toString());

                            CountDownTimer count_timer = new CountDownTimer(seconds * 1000, 1000) {
                                @Override
                                public void onTick(long millisUntilFinished) {
                                    timer.setText(Long.toString(millisUntilFinished / 1000));
                                    button3.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            cancel();
                                            timer.setText("");
                                        }
                                    });

                                }

                                @Override
                                public void onFinish() {
                                    timer.setText("");
                                    Toast.makeText(getActivity(), "Финиш", Toast.LENGTH_SHORT).show();
                                }
                            };
                            count_timer.start();
                    }}
                });

        return view;


    }

    public void init(){
        sPreferences = getActivity().getSharedPreferences("Save1", Context.MODE_PRIVATE);
        text1.setText(sPreferences.getString("key1", "0"));
    }
    public void init2(){
        sPreferences2 = getActivity().getSharedPreferences("Save2", Context.MODE_PRIVATE);
        text2.setText(sPreferences2.getString("key2", "0"));
    }


}
