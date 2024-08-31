package com.example.calculadora;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    Button btn_sumar, btnNavigateToMain;
    EditText edt_num1, edt_num2;
    Spinner spinner_operations;
    String selectedOperation = "Suma";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btn_sumar = findViewById(R.id.btn_sumar);
        edt_num1 = findViewById(R.id.edt_num1);
        edt_num2 = findViewById(R.id.edt_num2);
        btnNavigateToMain = findViewById(R.id.btn_navigate_to_main);
        spinner_operations = findViewById(R.id.spinner_operations);

        spinner_operations.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedOperation = parent.getItemAtPosition(position).toString();
                btn_sumar.setText(selectedOperation);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                selectedOperation = "Suma";
                btn_sumar.setText("Sumar");
            }
        });

        btn_sumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text1 = edt_num1.getText().toString();
                String text2 = edt_num2.getText().toString();

                if (text1.equals("") || text2.equals("")) {
                    Toast.makeText(SecondActivity.this, "Los datos estan vacios", Toast.LENGTH_LONG).show();
                } else {
                    int num1 = Integer.parseInt(text1);
                    int num2 = Integer.parseInt(text2);
                    int result;

                    switch (selectedOperation) {
                        case "+":
                            result = num1 + num2;
                            break;
                        case "x":
                            result = num1 * num2;
                            break;
                        case "-":
                            result = num1 - num2;
                            break;
                        case "/":
                            if (num2 != 0) {
                                result = num1 / num2;
                            } else {
                                Toast.makeText(SecondActivity.this, "No se puede dividir por cero", Toast.LENGTH_LONG).show();
                                return;
                            }
                            break;
                        default:
                            result = 0;
                            break;
                    }

                    Toast.makeText(SecondActivity.this, "El resultado es: " + result, Toast.LENGTH_LONG).show();
                }
            }
        });

        btnNavigateToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}