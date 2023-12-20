package com.chillarcards.servicexpert.ui.appointment

import android.os.Bundle
import androidx.navigation.NavDirections
import com.chillarcards.servicexpert.R
import kotlin.Int
import kotlin.String

public class WalkingFragmentDirections private constructor() {
  private data class ActionAddStaffFragmentToStaffFragment(
    public val staffId: String? = "",
  ) : NavDirections {
    public override val actionId: Int = R.id.action_addStaffFragment_to_StaffFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("staffId", this.staffId)
        return result
      }
  }

  private data class ActionWalkingFragmentToEstimateFragment(
    public val staffId: String? = "",
  ) : NavDirections {
    public override val actionId: Int = R.id.action_walkingFragment_to_EstimateFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("staffId", this.staffId)
        return result
      }
  }

  public companion object {
    public fun actionAddStaffFragmentToStaffFragment(staffId: String? = ""): NavDirections =
        com.chillarcards.servicexpert.ui.appointment.WalkingFragmentDirections.ActionAddStaffFragmentToStaffFragment(
            staffId
        )

    public fun actionWalkingFragmentToEstimateFragment(staffId: String? = ""): NavDirections =
        com.chillarcards.servicexpert.ui.appointment.WalkingFragmentDirections.ActionWalkingFragmentToEstimateFragment(
            staffId
        )
  }
}
