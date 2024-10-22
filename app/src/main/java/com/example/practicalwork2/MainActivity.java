package com.example.practicalwork2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText billAmountInput;
    private RadioGroup tipPercentGroup;
    private Button calculateButton;
    private TextView tipResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Инициализация элементов интерфейса
        billAmountInput = findViewById(R.id.billAmount);
        tipPercentGroup = findViewById(R.id.tipPercentGroup);
        calculateButton = findViewById(R.id.calculateButton);
        tipResult = findViewById(R.id.tipResult);

        // Установка слушателя на кнопку
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateTip();
            }
        });
    }

    // Метод для расчета чаевых
    private void calculateTip() {
        String billAmountText = billAmountInput.getText().toString();

        if (billAmountText.isEmpty()) {
            tipResult.setText("Пожалуйста, введите сумму счета.");
            return;
        }

        // Получение суммы счета
        double billAmount = Double.parseDouble(billAmountText);

        // Определение процента чаевых
        int selectedTipId = tipPercentGroup.getCheckedRadioButtonId();
        double tipPercent;

        if (selectedTipId == R.id.tip10) {
            tipPercent = 0.10;
        } else if (selectedTipId == R.id.tip15) {
            tipPercent = 0.15;
        } else if (selectedTipId == R.id.tip20) {
            tipPercent = 0.20;
        } else {
            tipResult.setText("Пожалуйста, выберите процент чаевых.");
            return;
        }

        // Рассчет чаевых
        double tipAmount = billAmount * tipPercent;
        tipResult.setText(String.format("Чаевые: %.2f руб.", tipAmount));
    }
}
