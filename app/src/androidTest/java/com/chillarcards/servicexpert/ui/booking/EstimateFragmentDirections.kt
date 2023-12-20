package com.chillarcards.servicexpert.ui.booking

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.chillarcards.servicexpert.R

public class EstimateFragmentDirections private constructor() {
  public companion object {
    public fun actionEstimateFragmentToSuccessFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_estimateFragment_to_SuccessFragment)
  }
}
