package dev.russellcullen.viewflow

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import dev.russellcullen.lib.textChangedFlow
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
class MainActivity : AppCompatActivity(R.layout.activity_main) {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    val editText = findViewById<EditText>(R.id.edit_text)
    lifecycleScope.launch {
      editText.textChangedFlow().collect {
        // Text changes here
      }
    }
  }
}
