package com.chillarcards.servicexpert.ui.register

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import kotlin.String
import kotlin.jvm.JvmStatic

public data class OTPFragmentArgs(
  public val mobile: String? = "",
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putString("mobile", this.mobile)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("mobile", this.mobile)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): OTPFragmentArgs {
      bundle.setClassLoader(OTPFragmentArgs::class.java.classLoader)
      val __mobile : String?
      if (bundle.containsKey("mobile")) {
        __mobile = bundle.getString("mobile")
      } else {
        __mobile = ""
      }
      return OTPFragmentArgs(__mobile)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): OTPFragmentArgs {
      val __mobile : String?
      if (savedStateHandle.contains("mobile")) {
        __mobile = savedStateHandle["mobile"]
      } else {
        __mobile = ""
      }
      return OTPFragmentArgs(__mobile)
    }
  }
}
