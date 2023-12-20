package com.chillarcards.servicexpert.ui.booking

import android.os.Bundle
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.chillarcards.servicexpert.R
import kotlin.Int
import kotlin.String

public class BookingAllFragmentDirections private constructor() {
  private data class ActionBookingFragmentToEstimateFragment(
    public val staffId: String? = "",
  ) : NavDirections {
    public override val actionId: Int = R.id.action_BookingFragment_to_EstimateFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("staffId", this.staffId)
        return result
      }
  }

  public companion object {
    public fun actionOTPFragmentToRegFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_OTPFragment_to_RegFragment)

    public fun actionBookingFragmentToEstimateFragment(staffId: String? = ""): NavDirections =
        ActionBookingFragmentToEstimateFragment(staffId)
  }
}
