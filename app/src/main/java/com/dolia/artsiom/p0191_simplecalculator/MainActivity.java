package com.dolia.artsiom.p0191_simplecalculator;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements OnClickListener {

    final int MENU_RESET_ID = 1;
    final int MENU_QUIT_ID  = 2;

    EditText etNum1;
    EditText etNum2;

    Button btnAdd;
    Button btnSub;
    Button btnMult;
    Button btnDiv;

    TextView tvResult;

    String oper = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        etNum1 = (EditText) findViewById(R.id.etNum1);
        etNum2 = (EditText) findViewById(R.id.etNum2);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);

        btnSub = (Button) findViewById(R.id.btnSub);
        btnSub.setOnClickListener(this);

        btnMult = (Button) findViewById(R.id.btnMult);
        btnMult.setOnClickListener(this);

        btnDiv = (Button) findViewById(R.id.btnDiv);
        btnDiv.setOnClickListener(this);

        tvResult = (TextView) findViewById(R.id.tvResult);
    }


    @Override
    public void onClick (View v){

        float num1 = 0;
        float num2 = 0;
        float result = 0;

        if(TextUtils.isEmpty(etNum1.getText().toString())
                || TextUtils.isEmpty((etNum2.getText().toString()))){
            return;
        }

        num1 = Float.parseFloat(etNum1.getText().toString());
        num2 = Float.parseFloat(etNum2.getText().toString());

        switch (v.getId()){

            case R.id.btnAdd:
                oper = "+";
                result = num1 + num2;
                break;

            case R.id.btnSub:
                oper = "-";
                result = num1 - num2;
                break;

            case R.id.btnMult:
                oper = "x";
                result = num1 * num2;
                break;

            case R.id.btnDiv:
                if(num2 == 0){

                    Toast.makeText(this, "Error: devision by 0", Toast.LENGTH_LONG).show();
                    tvResult.setText("");
                    return;

                }else{
                    oper = "/";
                    result = num1 / num2;
                }
                break;
            default:
                break;
        }
        tvResult.setText(num1 + " " + oper + " " + num2 + " = " + result);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        menu.add(0, MENU_RESET_ID, 0, "Clear");
        menu.add(0, MENU_QUIT_ID, 0, "Quit");

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        switch (item.getItemId()){

            case MENU_RESET_ID:
                etNum1.setText("");
                etNum2.setText("");
                tvResult.setText("");
                break;
            case MENU_QUIT_ID:
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);

    }
}