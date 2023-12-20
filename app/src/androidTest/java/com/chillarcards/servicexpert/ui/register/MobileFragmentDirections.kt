package com.chillarcards.servicexpert.ui.register

import android.os.Bundle
import androidx.navigation.NavDirections
import com.chillarcards.servicexpert.R
import kotlin.Int
import kotlin.String

public class MobileFragmentDirections private constructor() {
  private data class ActionMobileFragmentToOTPFragment(
    public val mobile: String? = "",
  ) : NavDirections {
    public override val actionId: Int = R.id.action_mobileFragment_to_OTPFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("mobile", this.mobile)
        return result
      }
  }

  public companion object {
    public fun actionMobileFragmentToOTPFragment(mobile: String? = ""): NavDirections =
        ActionMobileFragmentToOTPFragment(mobile)
  }
}
