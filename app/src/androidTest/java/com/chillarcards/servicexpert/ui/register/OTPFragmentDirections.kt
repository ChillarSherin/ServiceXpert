package com.chillarcards.servicexpert.ui.register

import android.os.Bundle
import androidx.navigation.NavDirections
import com.chillarcards.servicexpert.R
import kotlin.Int
import kotlin.String

public class OTPFragmentDirections private constructor() {
  private data class ActionOTPFragmentToRegFragment(
    public val mobile: String? = "",
  ) : NavDirections {
    public override val actionId: Int = R.id.action_OTPFragment_to_RegFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("mobile", this.mobile)
        return result
      }
  }

  public companion object {
    public fun actionOTPFragmentToRegFragment(mobile: String? = ""): NavDirections =
        ActionOTPFragmentToRegFragment(mobile)
  }
}
