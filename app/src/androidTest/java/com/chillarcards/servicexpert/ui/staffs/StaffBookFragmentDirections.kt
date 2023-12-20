package com.chillarcards.servicexpert.ui.staffs

import android.os.Bundle
import androidx.navigation.NavDirections
import com.chillarcards.servicexpert.R
import kotlin.Int
import kotlin.String

public class StaffBookFragmentDirections private constructor() {
  private data class ActionStaffFragmentToBookingFragment(
    public val staffId: String? = "",
  ) : NavDirections {
    public override val actionId: Int = R.id.action_staffFragment_to_BookingFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("staffId", this.staffId)
        return result
      }
  }

  public companion object {
    public fun actionStaffFragmentToBookingFragment(staffId: String? = ""): NavDirections =
        ActionStaffFragmentToBookingFragment(staffId)
  }
}
