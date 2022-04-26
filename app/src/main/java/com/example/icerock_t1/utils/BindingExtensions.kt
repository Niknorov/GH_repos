package com.example.icerock_t1.utils

import android.text.Editable
import android.text.TextWatcher
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import com.example.icerock_t1.R
import com.google.android.material.textfield.TextInputLayout

fun TextInputLayout.bindTextTwoWay(
    liveData: MutableLiveData<TextState>,
    lifecycleOwner: LifecycleOwner
) {
    val textWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) = Unit
        override fun afterTextChanged(s: Editable?) = Unit

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            liveData.postValue(NotValidatedText(text = s.toString()))
        }

    }
    this.editText?.addTextChangedListener(textWatcher)

    liveData.observe(lifecycleOwner) { textState ->
        when (textState) {
            is NotValidatedText -> {
                if (this.editText?.text.toString() == textState.text) {
                    return@observe
                }
                this.editText?.setText(textState.text)
            }
            is ValidatedText -> {
                if (!textState.valid) {
                    this.error = this.context.getString(R.string.invalid_values)
                }
                if (this.editText?.text.toString() == textState.text) {
                    return@observe
                }
                this.editText?.setText(textState.text)

            }

        }

    }

}