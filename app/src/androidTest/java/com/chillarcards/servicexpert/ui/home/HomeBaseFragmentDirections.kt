package com.chillarcards.servicexpert.ui.home

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.chillarcards.servicexpert.R

public class HomeBaseFragmentDirections private constructor() {
  public companion object {
    public fun actionHomebaseToAddStaffFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_homebase_to_addStaffFragment)
  }
}
