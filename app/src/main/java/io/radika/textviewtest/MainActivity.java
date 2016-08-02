package io.radika.textviewtest;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;


public class MainActivity extends Activity{
    TextView alarmValTV,jumpNumTV,fftimeTV;
    NumberPicker Alarmpicker;

    private void showEditDialog(String title) {
        FragmentManager fm = getFragmentManager();
        EditNameDialogFragment editNameDialogFragment = EditNameDialogFragment.newInstance(title);
        editNameDialogFragment.show(fm, "fragment_edit_name");
    }

    NumberPicker.OnValueChangeListener AlarmListener = new NumberPicker.OnValueChangeListener() {
        @Override
        public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
            //Toast.makeText(MainActivity.this, ""+picker.getValue(), Toast.LENGTH_SHORT).show();
            alarmValTV.setText(picker.getValue() + "");
        }
    };

    View.OnClickListener clickHandler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String title="";
            int id;
            switch (v.getId()){
                case R.id.alarmValue:
                    title = "Set Alarm "+Alarmpicker.getValue()+1;
                    id = R.id.alarmValue;
                    break;
                case R.id.jumpNum:
                    title = "Set Jump #";
                    id = R.id.jumpNum;
                    break;
                case R.id.fftime:
                    title = "Set Free fall time";
                    id =R.id.jumpNum;
                    break;
                default: return;
            }
            showEditDialog(title);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainv2);
        //tv = (TextView)findViewById(R.id.TEXT_STATUS_ID);
        //tv.setMovementMethod(new ScrollingMovementMethod());


        alarmValTV = (TextView)findViewById(R.id.alarmValue);
        alarmValTV.setOnClickListener(clickHandler);
        jumpNumTV = (TextView)findViewById(R.id.jumpNum);
        jumpNumTV.setOnClickListener(clickHandler);
        fftimeTV = (TextView)findViewById(R.id.fftime);
        fftimeTV.setOnClickListener(clickHandler);

        Alarmpicker = (NumberPicker) findViewById(R.id.np1);
        Alarmpicker.setMinValue(0);
        Alarmpicker.setDisplayedValues(new String[]{"Alarm 1", "Alarm 2", "Alarm 3"});
        Alarmpicker.setMaxValue(2);
        Alarmpicker.setWrapSelectorWheel(false);
        Alarmpicker.setOnValueChangedListener(AlarmListener);
        Alarmpicker.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);


       /* NumberPicker picker2 = (NumberPicker) findViewById(R.id.np2);
        picker2.setMinValue(1);
        picker2.setMaxValue(9);
        picker2.setWrapSelectorWheel(true);
        NumberPicker picker3 = (NumberPicker) findViewById(R.id.np3);
        picker3.setMinValue(1);
        picker3.setMaxValue(9);
        picker3.setWrapSelectorWheel(true);*/

        //showEditDialog();
        Intent intent = new Intent(MainActivity.this, Preferences.class);
        startActivity(intent);

    }
    public void launchPref(View v){
        Intent intent = new Intent(MainActivity.this, Preferences.class);
        startActivity(intent);
    }
}
