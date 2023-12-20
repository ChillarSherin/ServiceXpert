package com.chillarcards.servicexpert.ui.register

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.chillarcards.servicexpert.R

public class BankFragmentDirections private constructor() {
  public companion object {
    public fun actionBankFragmentToTimeFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_BankFragment_to_TimeFragment)
  }
}
