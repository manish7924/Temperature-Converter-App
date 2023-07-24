package com.starkindustries.temperatureconverter;

import static android.app.ProgressDialog.show;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.lifecycle.viewmodel.CreationExtras;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.text.Layout;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {



    Button Button,Button2,Button3;
    ImageView img;
    TextView name;
    TextView editText;
    RadioGroup group;
    RadioButton radioButton;
    RadioButton radioButton2;
    RelativeLayout relative;
    float result=0,c,d=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        relative = findViewById(R.id.relative);
        Button = findViewById(R.id.btn1);
        Button2 = findViewById(R.id.btn2);
        group = findViewById(R.id.group);
        radioButton = findViewById(R.id.radioButton);
        radioButton2 = findViewById(R.id.radioButton2);
        name = findViewById(R.id.name);
        editText = findViewById(R.id.edit);


        Button.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                if (TextUtils.isEmpty(editText.getText().toString())) {
                    Toast.makeText(MainActivity.this, "Empty field not allowed!",
                            Toast.LENGTH_SHORT).show();
                } else {

                    if (radioButton.isChecked()) {
                        c = Float.parseFloat(editText.getText().toString());
                        result = (c - 32) * 5 / 9;
                        name.setText(String.valueOf(result) + "° C");
                    } else if (radioButton2.isChecked()) {
                        c = Float.parseFloat(editText.getText().toString());
                        result = (c * 9 / 5) + 32;
                        name.setText(String.valueOf(result) + "° F");
                    }
                }

            }
        });

        Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });

    }

    private void showDialog() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Delete");
        alertDialog.setMessage("Do you want to delete this conversion ?");

        alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        editText.setText("");
                        name.setText("");
                    }
                }).show();
        alertDialog.create();

    }
}