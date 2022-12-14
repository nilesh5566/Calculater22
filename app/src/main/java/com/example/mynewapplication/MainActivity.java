package com.example.mynewapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9
            ,btnAC,btndel,btnadd,btnminus,btnmulti,btnequal,btndot,btndivid;

    private TextView textViewResult, textViewHistory;
    private String number =null;
    double firstnumber=0;
    double lastnumber=0;
    String status =null;
    boolean operater =false;

    DecimalFormat myformetter=new DecimalFormat("######.######");
    String history,currentResult;
    boolean dot=true;
    boolean btnACcontnol=true;
    boolean equalcontrole=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn0=findViewById(R.id.butzero);
        btn1=findViewById(R.id.butONE);
        btn2=findViewById(R.id.buttwo);
        btn3=findViewById(R.id.butthree);
        btn4=findViewById(R.id.butfour);
        btn5=findViewById(R.id.butfive);
        btn6=findViewById(R.id.butsix);
        btn7=findViewById(R.id.butseven);
        btn8=findViewById(R.id.buteight);
        btn9=findViewById(R.id.butnine);
        btnadd=findViewById(R.id.butplus);
        btnAC=findViewById(R.id.butAC);
        btndel=findViewById(R.id.butDEL);
        btnmulti=findViewById(R.id.butMULTI);
        btndot=findViewById(R.id.butpoint);
        btnminus=findViewById(R.id.butMinus);
        btndivid=findViewById(R.id.butDIVIDE);

        btnequal=findViewById(R.id.but_equal);

        textViewHistory=findViewById(R.id.textViewhistory);
        textViewResult=findViewById(R.id.textViewResult);


        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                   numberClick("0");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
numberClick("1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("9");
            }
        });

        btnAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                number=null;
                status=null;
                textViewResult.setText("0");
            textViewHistory.setText("");
            firstnumber=0;
            lastnumber=0;
            dot=true;
           btnACcontnol=true;
            }
        });

        btndel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnACcontnol){
                    textViewResult.setText("0");
            }
                else  {
                    number = number.substring(0, number.length() - 1);
                    if (number.length()==0){
                        btndel.setClickable(false);
                    }
                    else if(number.contains(".")){
                        dot=false;
                    }
                    else {
                        dot=true;
                    }
                    textViewResult.setText(number);
                }
            }
        });
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                history = textViewHistory.getText().toString();
                currentResult = textViewResult.getText().toString();
                textViewHistory.setText(history + currentResult + "+");
                if (operater)
                    if (status == "multiplacition") {
                        multiply();
                    } else if (status == "division") {
                        divide();
                    } else if (status == "subtraction") {
                        minus();
                    } else {
                        plus();
                    }


                status = "sum";
                operater = false;
                number = null;
            }

        });
        btnminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                history = textViewHistory.getText().toString();
                currentResult = textViewResult.getText().toString();
                textViewHistory.setText(history + currentResult + "-");
                if (operater){
                    if(status=="multiplacition"){
                        multiply();
                    }else if (status=="division"){
                        divide();
                    }else if (status=="sum"){
                        plus();
                    }else
                    {
                        minus();
                    }
                }
                status="subtraction";
                operater=false;
                number=null;

            }
        });
        btnmulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                history = textViewHistory.getText().toString();
                currentResult = textViewResult.getText().toString();
                textViewHistory.setText(history + currentResult + "*");
                if (operater){
                    if(status=="sum"){
                        plus();
                    }else if (status=="division"){
                        divide();
                    }else if (status=="subtraction"){
                        minus();
                    }else
                    {
                        multiply();
                    }
                }
                status="multiplacition";
                operater=false;
                number=null;

            }
        });

        btndivid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                history = textViewHistory.getText().toString();
                currentResult = textViewResult.getText().toString();
                textViewHistory.setText(history+1+ currentResult + "/");
                if (operater){
                    if(status=="multiplacition"){
                        multiply();
                    }else if (status=="sum"){
                        plus();
                    }else if (status=="subtraction"){
                        minus();
                    }else
                    {
                        divide();
                    }
                }
                status="division";
                operater=false;
                number=null;

            }
        });
        btnequal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(operater){
                    if (status=="sum"){
                        plus();
                    }
                    else if(status=="subtraction"){
                        minus();
                    }
                    else if (status=="multiply"){
                        multiply();
                    }
                    else if (status=="division"){
                        divide();
                    }
                    else{
                        firstnumber=Double.parseDouble(textViewResult.getText().toString());
                    }
                }
                operater=false;
                equalcontrole=true;

            }
        });
        btndot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dot) {
                    if (number == null) {
                        number = "0.";

                    } else {
                        number += ".";
                    }
                }
                textViewResult.setText(number);
                dot=false;

            }
        });


    }
    public void numberClick(String view){
        if(number==null){
            number=view;
        }
        else if (equalcontrole){
            firstnumber=0;
            lastnumber=0;
            number=view;
        }

        else{
            number+=view;
        }
        textViewResult.setText(number);
        operater=true;
        btnACcontnol=false;
        btndel.setClickable(true);
        equalcontrole=false;

    }

    public void plus(){
        lastnumber =Double.parseDouble(textViewResult.getText().toString());
        firstnumber+=lastnumber;
        textViewResult.setText(myformetter.format(firstnumber));
        dot=true;
    }
    public void minus(){
        if(firstnumber==0){
            firstnumber=Double.parseDouble(textViewResult.getText().toString());

        }else {
            lastnumber = Double.parseDouble(textViewResult.getText().toString());
            firstnumber -= lastnumber;

        }
        textViewResult.setText(myformetter.format(firstnumber));
        dot=true;
    }
    public void multiply(){
        if(firstnumber==0){
            firstnumber=1;
            lastnumber =Double.parseDouble(textViewResult.getText().toString());
            firstnumber *= lastnumber;
        }else {
            lastnumber =Double.parseDouble(textViewResult.getText().toString());
            firstnumber *= lastnumber;
        }
        textViewResult.setText(myformetter.format(firstnumber));
        dot=true;
    }
    public void divide(){
        if (firstnumber==0){
            lastnumber =Double.parseDouble(textViewResult.getText().toString());
            firstnumber=lastnumber/1;
        }else {
            lastnumber =Double.parseDouble(textViewResult.getText().toString());
            firstnumber /=lastnumber;
        }
        textViewResult.setText(myformetter.format(firstnumber));
        dot=true;
    }

}