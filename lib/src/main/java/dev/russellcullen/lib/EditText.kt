package dev.russellcullen.lib

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

@ExperimentalCoroutinesApi
public fun EditText.textChangedFlow(): Flow<CharSequence> = callbackFlow {
  val watcher = object : TextWatcher {
    override fun afterTextChanged(s: Editable?) {
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
      s?.let { offer(it) }
    }
  }
  addTextChangedListener(watcher)
  awaitClose { removeTextChangedListener(watcher) }
}