package com.chillarcards.servicexpert.ui.home

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import kotlin.String
import kotlin.jvm.JvmStatic

public data class HomeFragmentArgs(
  public val mobileNo: String? = "",
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putString("mobileNo", this.mobileNo)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("mobileNo", this.mobileNo)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): HomeFragmentArgs {
      bundle.setClassLoader(HomeFragmentArgs::class.java.classLoader)
      val __mobileNo : String?
      if (bundle.containsKey("mobileNo")) {
        __mobileNo = bundle.getString("mobileNo")
      } else {
        __mobileNo = ""
      }
      return HomeFragmentArgs(__mobileNo)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): HomeFragmentArgs {
      val __mobileNo : String?
      if (savedStateHandle.contains("mobileNo")) {
        __mobileNo = savedStateHandle["mobileNo"]
      } else {
        __mobileNo = ""
      }
      return HomeFragmentArgs(__mobileNo)
    }
  }
}
