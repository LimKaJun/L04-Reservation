package sg.edu.rp.c346.id20026955.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etTelephone;
    EditText etSize;
    CheckBox checkBox;
    DatePicker datePicker;
    TimePicker timePicker;
    Button btReserve;
    Button btReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editName);
        etTelephone = findViewById(R.id.editPhoneNumber);
        etSize = findViewById(R.id.editPax);
        checkBox = findViewById(R.id.checkSmoking);
        datePicker = findViewById(R.id.datePicker);
        timePicker = findViewById(R.id.timePicker);
        btReserve = findViewById(R.id.buttonSubmit);
        btReset = findViewById(R.id.buttonReset);

        datePicker.updateDate(2021,5 ,1);

        btReserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = etName.getText().toString();
                String phoneNum = etTelephone.getText().toString();
                String pax = etSize.getText().toString();

                String isSmoke = "";
                if (checkBox.isChecked()){
                    isSmoke = "smoking";
                }else{
                    isSmoke = "non-smoking";
                }

                String date =datePicker.getYear() + "/" + (datePicker.getMonth() + 1) +"/" + datePicker.getDayOfMonth();
                String time = timePicker.getCurrentHour() + ":" +String.format("%02d", timePicker.getCurrentMinute());

                String msg = "Hi " + name +", you have booked a "
                        + pax +" person(s) "
                        + isSmoke + " table on "
                        +date +" at "
                        + time + ". Your mobile is "
                        + phoneNum + ".";

                Toast.makeText(MainActivity.this , msg, Toast.LENGTH_LONG).show();
            }
        });

        btReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etName .setText("");
                etTelephone .setText("");
                etSize .setText("");
                checkBox .setChecked(false);
                datePicker .updateDate(2021,5, 1);
                timePicker .setCurrentHour(20);
                timePicker.setCurrentMinute(30);
            }
        });
    }
}