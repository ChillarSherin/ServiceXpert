package com.chillarcards.servicexpert.ui.staffs

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.chillarcards.servicexpert.R

public class ViewAllStaffFragmentDirections private constructor() {
  public companion object {
    public fun actionStaffFragmentToAddStaffFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_StaffFragment_to_AddStaffFragment)
  }
}
