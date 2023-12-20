package com.chillarcards.servicexpert.ui.register

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.chillarcards.servicexpert.R

public class RegisterFragmentDirections private constructor() {
  public companion object {
    public fun actionRegisterFragmentToBankFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_RegisterFragment_to_bankFragment)

    public fun actionRegisterFragmentToMapFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_RegisterFragment_to_mapFragment)
  }
}
