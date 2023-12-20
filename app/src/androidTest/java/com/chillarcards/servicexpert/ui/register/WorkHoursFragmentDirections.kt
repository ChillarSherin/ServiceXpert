package com.chillarcards.servicexpert.ui.register

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.chillarcards.servicexpert.R

public class WorkHoursFragmentDirections private constructor() {
  public companion object {
    public fun actionTimeFragmentToHomeFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_TimeFragment_to_HomeFragment)
  }
}
