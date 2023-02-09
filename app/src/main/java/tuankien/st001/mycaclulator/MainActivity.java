package tuankien.st001.mycaclulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.io.CharArrayReader;
import java.nio.charset.Charset;

public class MainActivity extends AppCompatActivity {
    private Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnDot,btnAC,btnDel,btnMod,btnMulti,btnDiv,btnPlus,btnMinus,btnEqual;

    private TextView textViewHandle , textViewResult;

    private String number = null;

    double firstnum = 0 , lastnum = 0;

    boolean operator = false;

    String status = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Số
        btn0 = this.findViewById(R.id.btn0);
        btn1 = this.findViewById(R.id.btn1);
        btn2 = this.findViewById(R.id.btn2);
        btn3 = this.findViewById(R.id.btn3);
        btn4 = this.findViewById(R.id.btn4);
        btn5 = this.findViewById(R.id.btn5);
        btn6 = this.findViewById(R.id.btn6);
        btn7 = this.findViewById(R.id.btn7);
        btn8 = this.findViewById(R.id.btn8);
        btn9 = this.findViewById(R.id.btn9);
        btnDot = this.findViewById(R.id.btnDot);
//        Chức năng
        btnAC = this.findViewById(R.id.btnAC);
        btnDel = this.findViewById(R.id.btnDEL);
        btnMod = this.findViewById(R.id.btnMod);
        btnEqual = this.findViewById(R.id.btnEqual);
//         Phép tính
        btnDiv = this.findViewById(R.id.btnDiv);
        btnPlus = this.findViewById(R.id.btnPlus);
        btnMinus = this.findViewById(R.id.btnMinus);
        btnMulti = this.findViewById(R.id.btnMulti);
//            Hiển thị
        textViewHandle = this.findViewById(R.id.textviewHandle);
        textViewResult = this.findViewById(R.id.textviewResult);

//        Nhấn
        btn0.setOnClickListener(view -> numberClick("0"));
        btn1.setOnClickListener(view -> numberClick("1"));
        btn2.setOnClickListener(view -> numberClick("2"));
        btn3.setOnClickListener(view -> numberClick("3"));
        btn4.setOnClickListener(view -> numberClick("4"));
        btn5.setOnClickListener(view -> numberClick("5"));
        btn6.setOnClickListener(view -> numberClick("6"));
        btn7.setOnClickListener(view -> numberClick("7"));
        btn8.setOnClickListener(view -> numberClick("8"));
        btn9.setOnClickListener(view -> numberClick("9"));

        //        Trừ
        btnMinus.setOnClickListener(view -> {
            if (operator) {
                if (status == "multi")
                    Multi();
                else if (status == "div")
                    Div();
                else if (status == "plus")
                    Plus();
                else if (status == "mod")
                    Mod();
                else
                    Minus();
            }
            operator = false;
            number = null;
            status = "minus";
        });
        //        Cộng
        btnPlus.setOnClickListener(view -> {
            if (operator) {
                if (status == "multi")
                    Multi();
                else if (status == "div")
                    Div();
                else if (status == "minus")
                    Minus();
                else if (status == "mod")
                    Mod();
                else
                    Plus();
            }
            operator = false;
            number = null;
            status = "plus";
        });
        //        Nhân
        btnMulti.setOnClickListener(view -> {
            if (operator) {
                if (status == "minus")
                    Minus();
                else if (status == "div")
                    Div();
                else if (status == "plus")
                    Plus();
                else if (status == "mod")
                    Mod();
                else
                    Multi();
            }
            operator = false;
            number = null;
            status = "multi";
        });
        //        Chia
        btnDiv.setOnClickListener(view -> {
            if (operator) {
                if (status == "multi")
                    Multi();
                else if (status == "minus")
                    Minus();
                else if (status == "plus")
                    Plus();
                else if (status == "mod")
                    Mod();
                else
                    Div();
            }
            operator = false;
            number = null;
            status = "div";
        });
        //        Chia lấy dư
        btnMod.setOnClickListener(view -> {
            if (operator) {
                if (status == "multi")
                    Multi();
                else if (status == "minus")
                    Minus();
                else if (status == "plus")
                    Plus();
                else if (status == "div")
                    Div();
                else
                    Mod();
            }
            operator = false;
            number = null;
            status = "mod";
        });
        //        Dấu bằng
        btnEqual.setOnClickListener(view -> {
            if (operator) {
                if (status == "multi")
                    Multi();
                else if (status == "minus")
                    Minus();
                else if (status == "plus")
                    Plus();
                else if (status == "div")
                    Div();
                else if (status == "mod")
                    Mod();
                else
                    firstnum = Double.parseDouble(textViewResult.getText().toString());

            }
            operator = false;
        });
        //        AC
        btnAC.setOnClickListener(view -> {
            operator = false;
            number = null;
            textViewHandle.setText("");
            textViewResult.setText("0");
            firstnum = 0;
            lastnum = 0;
        });
        //        Del
        btnDel.setOnClickListener(view -> {
            operator = false;
            number = number.substring(0,number.length()-1);
            textViewHandle.setText(number);
        });
        //      Dấu chấm
        btnDot.setOnClickListener(view -> {
            if(number ==null) {
                number = "0.";
            }else {
                number = number+".";
            }
            textViewHandle.setText(number);
        });


    }

    public void numberClick (String view) {
        if (number == null)
            number = view;
        else
            number += view;

        textViewHandle.setText(number);
        operator = true;
    }

    public void Minus() {
        if (firstnum == 0)
            firstnum = Double.parseDouble(textViewHandle.getText().toString());
        else {
            lastnum = Double.parseDouble(textViewHandle.getText().toString());
            firstnum = firstnum - lastnum;
        }
        textViewResult.setText(""+firstnum);
    }

    public void Plus() {
        lastnum = Double.parseDouble(textViewHandle.getText().toString());
        firstnum = firstnum + lastnum;
        textViewResult.setText(""+firstnum);
    }

    public void Div() {
        if (firstnum == 0){
            lastnum = Double.parseDouble(textViewHandle.getText().toString());
            firstnum = lastnum;}
        else {
            lastnum = Double.parseDouble(textViewHandle.getText().toString());
            firstnum = firstnum / lastnum;
        }
        textViewResult.setText(""+firstnum);
    }

    public void Mod() {
        if (firstnum == 0){
            lastnum = Double.parseDouble(textViewHandle.getText().toString());
            firstnum = lastnum;}
        else {
            lastnum = Double.parseDouble(textViewHandle.getText().toString());
            firstnum = firstnum % lastnum;
        }
        textViewResult.setText(""+firstnum);
    }

    public void Multi() {
        lastnum = Double.parseDouble(textViewHandle.getText().toString());
        firstnum = firstnum * lastnum;
        textViewResult.setText(""+firstnum);
    }


}