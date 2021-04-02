package com.example.dimension_calculater;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {
    EditText height,wight,amount, thickness;
    TextView x;
    Button button;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        height=findViewById(R.id.heightID);
        wight= findViewById(R.id.weightID);
        amount= findViewById(R.id.amountID);
        thickness =findViewById(R.id.thikID);
        button= findViewById(R.id.button);
        img=(ImageView) findViewById(R.id.imageView);


        amount.setText("1");
        thickness.setText("0.");




        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double heightResult=Double.parseDouble(height.getText().toString());
                double wightResult=Double.parseDouble(wight.getText().toString());
                int amountResult=Integer.parseInt(amount.getText().toString());
                double thicknessResult=Double.parseDouble(thickness.getText().toString());



                TextView x=(TextView) findViewById(R.id.textView5);

                String sum=String.valueOf(calc(heightResult,wightResult,amountResult,thicknessResult));
                x.setText("Total price is : "+sum);
                Toast.makeText(MainActivity.this, "total price is: "+ sum, Toast.LENGTH_SHORT).show();
                img.getLayoutParams().height = (int) Double.parseDouble(height.getText().toString()+"00");
                img.getLayoutParams().width = (int) Double.parseDouble(wight.getText().toString()+"00");






            }
        });

    }

    public String calc(double heightResult, double wightResult, int amountResult,double thicknessResult) {

            if (thicknessResult < 0.3) {


                double price = 50;
                double thik=5;
                double thik2=10;
                double Result=0;
                double area = (heightResult * wightResult ) * price;
                if(thicknessResult==0.1){
                     Result = area + thik;
                }
                else if (thicknessResult==0.2){
                     Result = area + thik2;
                }
                else{
                    Toast.makeText(MainActivity.this, "tthikness should be 0.1 or 0.2 ", Toast.LENGTH_SHORT).show();
                }

                double finalResult = Result * amountResult;
                DecimalFormat df = new DecimalFormat("#.##");
                String x = String.valueOf(df.format(finalResult));
                area = 0;
                finalResult = 0;
                return x;
            }
        else{
            Toast.makeText(MainActivity.this, "please check your entry", Toast.LENGTH_SHORT).show();
            return "error";
        }



}
}


