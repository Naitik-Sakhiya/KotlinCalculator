package com.naitiks.kotlincalculator

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.AppCompatTextView
import android.support.v7.widget.Toolbar
import android.view.View
import android.view.View.OnClickListener
import android.widget.TextView

class MainActivity : AppCompatActivity(), OnClickListener {
    private var calHelper = CalculationHelper();
    private var addingVal = "0";
    override fun onClick(view: View?) {
        if(view is AppCompatTextView){
            val pressedBtn = (view).text.toString()
            println("KOTCAL: "+pressedBtn)
            when(pressedBtn){
                "=" -> {
                    addingVal += "#"
                    addingVal = calHelper.calculateIt(addingVal).toString()
                    setScreen()
                }
                "%" -> {
                    addingVal += "%"
                    addingVal = calHelper.calculateIt(addingVal).toString()
                    setScreen()
                }
                "." -> {
                    if (addingVal.contains('.'))
                    else {
                        addingVal += "."
                        setScreen()
                    }
                }
                "C" -> {
                    if(addingVal.length>1){
                        addingVal =  addingVal.removeRange(addingVal.length-1,addingVal.length)
                    }else if(addingVal.length==1){
                        addingVal =  ""
                    }
                    setScreen()
                }
                "AC" -> reInitAll()
                else -> {
                    addingVal += pressedBtn
                    (findViewById(R.id.result_view) as TextView).text = addingVal
                }
            }
            println("KOTCAL: screenVal" + addingVal);
        }
    }

    fun reInitAll(){
        calHelper = CalculationHelper();
        addingVal = "";
        setScreen()
    }
    fun setScreen(){
        (findViewById(R.id.result_view) as TextView).text = ""+addingVal
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        toolbar.setTitle(R.string.calcultor)

        (findViewById(R.id.btn_clear) as AppCompatTextView).setOnClickListener(this)
        (findViewById(R.id.btn_val_state) as AppCompatTextView).setOnClickListener(this)
        (findViewById(R.id.btn_mode) as AppCompatTextView).setOnClickListener(this)
        (findViewById(R.id.btn_divide) as AppCompatTextView).setOnClickListener(this)

        (findViewById(R.id.btn_seven) as AppCompatTextView).setOnClickListener(this)
        (findViewById(R.id.btn_eight) as AppCompatTextView).setOnClickListener(this)
        (findViewById(R.id.btn_nine) as AppCompatTextView).setOnClickListener(this)
        (findViewById(R.id.btn_multiply) as AppCompatTextView).setOnClickListener(this)

        (findViewById(R.id.btn_four) as AppCompatTextView).setOnClickListener(this)
        (findViewById(R.id.btn_five) as AppCompatTextView).setOnClickListener(this)
        (findViewById(R.id.btn_six) as AppCompatTextView).setOnClickListener(this)
        (findViewById(R.id.btn_minus) as AppCompatTextView).setOnClickListener(this)

        (findViewById(R.id.btn_three) as AppCompatTextView).setOnClickListener(this)
        (findViewById(R.id.btn_two) as AppCompatTextView).setOnClickListener(this)
        (findViewById(R.id.btn_one) as AppCompatTextView).setOnClickListener(this)
        (findViewById(R.id.btn_plus) as AppCompatTextView).setOnClickListener(this)

        (findViewById(R.id.btn_zero) as AppCompatTextView).setOnClickListener(this)
        (findViewById(R.id.btn_dot) as AppCompatTextView).setOnClickListener(this)
        (findViewById(R.id.btn_equal) as AppCompatTextView).setOnClickListener(this)
    }

}
