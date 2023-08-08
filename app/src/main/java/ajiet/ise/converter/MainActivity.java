package ajiet.ise.converter;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editTextTemperature;
    private RadioButton radioCelsius;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTemperature = findViewById(R.id.editTextTemperature);
        radioCelsius = findViewById(R.id.radioCelsius);
        textViewResult = findViewById(R.id.textViewResult);

        Button btnConvert = findViewById(R.id.btnConvert);

        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertTemperature();
            }
        });
    }

    private void convertTemperature() {
        try {
            double temperature = Double.parseDouble(editTextTemperature.getText().toString());

            if (radioCelsius.isChecked()) {
                // Convert Celsius to Fahrenheit
                double fahrenheit = (temperature * 9/5) + 32;
                textViewResult.setText("Result: " + fahrenheit + " °F");
            } else {
                // Convert Fahrenheit to Celsius
                double celsius = (temperature - 32) * 5/9;
                textViewResult.setText("Result: " + celsius + " °C");
            }

        } catch (NumberFormatException e) {
            textViewResult.setText("Error: Invalid input");
        }
    }
}
