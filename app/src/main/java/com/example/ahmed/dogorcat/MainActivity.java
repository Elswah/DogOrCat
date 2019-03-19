package com.example.ahmed.dogorcat;

import android.app.Instrumentation;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    RadioGroup group1,group2;
    RadioButton btn1,btn2;
    SeekBar bar;
    TextView barText;
    CheckBox dog,cat,parrot;
    int dogCounter,catCounter;
    Button result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUp();
    }
    public  void setUp(){
        dogCounter=0;
        catCounter=0;
        group1=(RadioGroup)findViewById(R.id.radioGroup1);
        group2=(RadioGroup)findViewById(R.id.radioGroup2);

        bar=(SeekBar)findViewById(R.id.seekBar);


        barText=(TextView)findViewById(R.id.bar_text);
        barText.setText("Degree:"+bar.getProgress()+" / "+bar.getMax());
        seekBarUpdate(bar);

        dog=(CheckBox)findViewById(R.id.checkBox_dog);
        cat=(CheckBox)findViewById(R.id.checkBox_cat);
        parrot=(CheckBox)findViewById(R.id.checkBox_parrot);
        // سال لعابه
        cutestOne(dog,cat,parrot);
        droolOne(group2);
        // ناب
        canineOne(group1);

        result=(Button)findViewById(R.id.button_result);
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               //Toast.makeText(getApplicationContext()," cat :"+catCounter+" dog :"+dogCounter,Toast.LENGTH_SHORT).show();
               Intent i=new Intent(MainActivity.this, ResultActivity.class);
               i.putExtra("catCounter",catCounter);
               i.putExtra("dogCounter",dogCounter);
               startActivity(i);
            }
        });


    }
    public void cutestOne(CheckBox dog,CheckBox cat,CheckBox parrot){
    if(dog.isChecked()&& !cat.isChecked() && !parrot.isChecked()){
     dogCounter+=5;
      }else if(cat.isChecked()&& !dog.isChecked() && !parrot.isChecked()){
    catCounter+=5;
     }else{
    Toast.makeText(getApplicationContext(),"Not increase CheckBox Counter !!!",Toast.LENGTH_SHORT).show();
}
    }
    public  void droolOne(final RadioGroup group){
group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
       int id=  group.getCheckedRadioButtonId();
        btn2=(RadioButton)findViewById(id);
        if(btn2.getText().equals("Yes")){
         dogCounter+=5;
        }else{
            catCounter+=5;
        }
    }
});
    }
    public  void canineOne(final RadioGroup group){
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int id=  group.getCheckedRadioButtonId();
                btn1=(RadioButton)findViewById(id);
                if(btn1.getText().equals("Yes")){
                    dogCounter+=5;
                }else{
                    catCounter+=5;
                }
            }
        });
    }
    public void seekBarUpdate(SeekBar seekBar){
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                barText.setText("Degree:"+progress+" / "+seekBar.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }


}
