package com.example.cofeeordering;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int N_O_C=0;
    int price=0;
    CheckBox choc_cb;
    CheckBox whit_cb;
    boolean cho_cream;
    boolean whit_cream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void add_btn_handler(View view) {
        // casting plus btn
        Button btn_add=(Button) findViewById(R.id.btn_add);
        if (N_O_C <=99 ){
                N_O_C+=1;
                show_no_of_coffe(N_O_C);
        }
        else{
            Toast.makeText(this, "Exceed Limit", Toast.LENGTH_SHORT).show();
        }
    }

    public void sub_btn_handler(View view) {
        Button btn_sub = (Button) findViewById(R.id.btn_sub);
        if (N_O_C >0) {
            N_O_C-=1;
            show_no_of_coffe(N_O_C);
        }
    }

    public int show_no_of_coffe(int number_of_coffee){
        TextView tv_noc=(TextView) findViewById(R.id.tv_noc);
        tv_noc.setText(Integer.toString(number_of_coffee));
        return number_of_coffee;
    }

    public void calculate_price(int coffee_Q){
        // casting
        CheckBox c_cb=(CheckBox)findViewById(R.id.choclate_checkbox);
        CheckBox w_cb=(CheckBox)findViewById(R.id.Whitecream_checkbox);
        cho_cream=c_cb.isChecked();
        whit_cream=w_cb.isChecked();
        if(c_cb.isChecked() && w_cb.isChecked()){
            price=(coffee_Q*10)+(coffee_Q*5);
            show_order_detail(price);
        }
        else if(c_cb.isChecked()){
            price=(coffee_Q*10)+(coffee_Q*3);
            show_order_detail(price);
        }
        else if(w_cb.isChecked()){
            price=(coffee_Q*10)+(coffee_Q*2);
            show_order_detail(price);
        }
        else{
            price=coffee_Q*10;
            show_order_detail(price);
        }
    }
    public void show_order_detail(int p){
        // casting
        TextView tv_detail=(TextView) findViewById(R.id.tv_order_detail);
        tv_detail.setText("No of Coffee : "+Integer.toString(N_O_C)+"\n"+"Amount of Coffee : "+Integer.toString(p)+"\n"+"Add Choclate Cream : "+cho_cream+"\n"+"Add White Cream : "+whit_cream+"\n\n"+"Thankyou");
    }
    public void order_btn(View view) {
        calculate_price(N_O_C);
    }
}