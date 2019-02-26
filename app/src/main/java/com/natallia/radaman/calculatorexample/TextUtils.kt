package com.natallia.radaman.calculatorexample

import android.os.Build
import android.text.InputType
import android.text.method.DigitsKeyListener
import android.widget.EditText

fun changeInputTypes(isFloat: Boolean, isSigned: Boolean, editText: EditText) {
    if (isFloat && isSigned) {
        editText.inputType = InputType.TYPE_CLASS_NUMBER
        editText.inputType = InputType.TYPE_NUMBER_FLAG_DECIMAL
        editText.inputType = InputType.TYPE_NUMBER_FLAG_SIGNED

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            editText.keyListener = DigitsKeyListener.getInstance(null, false, true)
        } else {
            editText.keyListener = DigitsKeyListener.getInstance(false, true)
        }
    } else if (isFloat && !isSigned) {
        editText.inputType = InputType.TYPE_CLASS_NUMBER
        editText.inputType = InputType.TYPE_NUMBER_FLAG_DECIMAL
        editText.keyListener = DigitsKeyListener.getInstance("0123456789.")
    } else if (!isFloat && isSigned) {
        editText.inputType = InputType.TYPE_CLASS_NUMBER
        editText.inputType = InputType.TYPE_NUMBER_FLAG_SIGNED

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            editText.keyListener = DigitsKeyListener.getInstance(null, false, false)
        } else {
            editText.keyListener = DigitsKeyListener.getInstance(false, false)
        }
    } else {
        editText.inputType = InputType.TYPE_CLASS_NUMBER
        editText.keyListener = DigitsKeyListener.getInstance("0123456789")
    }
}
