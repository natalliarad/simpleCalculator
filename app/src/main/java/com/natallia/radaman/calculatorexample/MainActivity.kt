package com.natallia.radaman.calculatorexample

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.text.method.DigitsKeyListener
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toast_operation.*

class MainActivity : AppCompatActivity() {

    private var isFloat = true
    private var isSigned = true
    private var operation = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        floatValuesCheck.setOnCheckedChangeListener { _, isChecked ->
            isFloat = isChecked
            changeInputTypes(isFloat, isSigned, editTextField1)
            changeInputTypes(isFloat, isSigned, editTextField2)
        }

        signedValuesCheck.setOnCheckedChangeListener { _, isChecked ->
            isSigned = isChecked
            changeInputTypes(isFloat, isSigned, editTextField1)
            changeInputTypes(isFloat, isSigned, editTextField2)
        }

        operations.clearCheck()
        operations.setOnCheckedChangeListener { group, checkedId ->
            val checkedOperation = group.findViewById<RadioButton>(checkedId)

            if (checkedOperation != null && checkedId > -1) {
                when (checkedId) {
                    R.id.plus -> operation = "plus"
                    R.id.minus -> operation = "minus"
                    R.id.divide -> operation = "divide"
                    R.id.multiple -> operation = "multiple"
                }
            }
        }

        calculateButton.setOnClickListener {
            if (operation.isEmpty()) {
                val layoutInflater = layoutInflater
                val toastLayout = layoutInflater.inflate(R.layout.toast_operation, toast_operation_custom)
                val toast = Toast.makeText(this, R.string.notFoundOperationMsg, Toast.LENGTH_SHORT)
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 200)
                toast.view = toastLayout
                toast.show()
            }
        }
    }

}
