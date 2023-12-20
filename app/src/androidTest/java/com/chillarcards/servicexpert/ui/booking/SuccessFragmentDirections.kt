package com.chillarcards.servicexpert.ui.booking

import android.os.Bundle
import androidx.navigation.NavDirections
import com.chillarcards.servicexpert.R
import kotlin.Int
import kotlin.String

public class SuccessFragmentDirections private constructor() {
  private data class ActionSuccessFragmentToHomeFragment(
    public val mobileNo: String? = "",
  ) : NavDirections {
    public override val actionId: Int = R.id.action_successFragment_to_homeFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("mobileNo", this.mobileNo)
        return result
      }
  }

  public companion object {
    public fun actionSuccessFragmentToHomeFragment(mobileNo: String? = ""): NavDirections =
        ActionSuccessFragmentToHomeFragment(mobileNo)
  }
}
