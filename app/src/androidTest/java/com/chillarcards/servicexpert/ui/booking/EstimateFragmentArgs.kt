package com.chillarcards.servicexpert.ui.booking

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import kotlin.String
import kotlin.jvm.JvmStatic

public data class EstimateFragmentArgs(
  public val staffId: String? = "",
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putString("staffId", this.staffId)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("staffId", this.staffId)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): EstimateFragmentArgs {
      bundle.setClassLoader(EstimateFragmentArgs::class.java.classLoader)
      val __staffId : String?
      if (bundle.containsKey("staffId")) {
        __staffId = bundle.getString("staffId")
      } else {
        __staffId = ""
      }
      return EstimateFragmentArgs(__staffId)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): EstimateFragmentArgs {
      val __staffId : String?
      if (savedStateHandle.contains("staffId")) {
        __staffId = savedStateHandle["staffId"]
      } else {
        __staffId = ""
      }
      return EstimateFragmentArgs(__staffId)
    }
  }
}
