package dev.russellcullen.lib

import android.os.Build
import android.view.View
import android.widget.ScrollView
import androidx.annotation.RequiresApi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

public data class ScrollState(
  val view: View,
  val scrollX: Int,
  val scrollY: Int,
  val oldScrollX: Int,
  val oldScrollY: Int
)

@ExperimentalCoroutinesApi
@RequiresApi(Build.VERSION_CODES.M)
public fun ScrollView.onScrollChangedFlow(): Flow<ScrollState> = callbackFlow {
  setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
    offer(ScrollState(v, scrollX, scrollY, oldScrollX, oldScrollY))
  }
  awaitClose { setOnScrollChangeListener(null) }
}