package com.chillarcards.servicexpert.ui.home

import android.os.Bundle
import androidx.navigation.NavDirections
import com.chillarcards.servicexpert.R
import kotlin.Int
import kotlin.String

public class HomeFragmentDirections private constructor() {
  private data class ActionHomeFragmentToBookingFragment(
    public val staffId: String? = "",
  ) : NavDirections {
    public override val actionId: Int = R.id.action_homeFragment_to_BookingFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("staffId", this.staffId)
        return result
      }
  }

  private data class ActionHomeFragmentToStaffBookFragment(
    public val staffId: String? = "",
  ) : NavDirections {
    public override val actionId: Int = R.id.action_homeFragment_to_StaffBookFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("staffId", this.staffId)
        return result
      }
  }

  private data class ActionHomeFragmentToEstimateFragment(
    public val staffId: String? = "",
  ) : NavDirections {
    public override val actionId: Int = R.id.action_homeFragment_to_estimateFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("staffId", this.staffId)
        return result
      }
  }

  public companion object {
    public fun actionHomeFragmentToBookingFragment(staffId: String? = ""): NavDirections =
        ActionHomeFragmentToBookingFragment(staffId)

    public fun actionHomeFragmentToStaffBookFragment(staffId: String? = ""): NavDirections =
        ActionHomeFragmentToStaffBookFragment(staffId)

    public fun actionHomeFragmentToEstimateFragment(staffId: String? = ""): NavDirections =
        ActionHomeFragmentToEstimateFragment(staffId)
  }
}
