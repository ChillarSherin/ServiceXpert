package com.chillarcards.servicexpert.ui.register

import android.os.Bundle
import androidx.navigation.NavDirections
import com.chillarcards.servicexpert.R
import kotlin.Int
import kotlin.String

public class MapsFragmentDirections private constructor() {
  private data class ActionMapFragmentToRegFragment(
    public val mobile: String? = "",
  ) : NavDirections {
    public override val actionId: Int = R.id.action_MapFragment_to_RegFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("mobile", this.mobile)
        return result
      }
  }

  public companion object {
    public fun actionMapFragmentToRegFragment(mobile: String? = ""): NavDirections =
        ActionMapFragmentToRegFragment(mobile)
  }
}
