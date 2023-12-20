package com.chillarcards.servicexpert.ui.booking

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import kotlin.String
import kotlin.jvm.JvmStatic

public data class BookingAllFragmentArgs(
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
    public fun fromBundle(bundle: Bundle): com.chillarcards.servicexpert.ui.booking.BookingAllFragmentArgs {
      bundle.setClassLoader(com.chillarcards.servicexpert.ui.booking.BookingAllFragmentArgs::class.java.classLoader)
      val __staffId : String?
      if (bundle.containsKey("staffId")) {
        __staffId = bundle.getString("staffId")
      } else {
        __staffId = ""
      }
      return com.chillarcards.servicexpert.ui.booking.BookingAllFragmentArgs(__staffId)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): com.chillarcards.servicexpert.ui.booking.BookingAllFragmentArgs {
      val __staffId : String?
      if (savedStateHandle.contains("staffId")) {
        __staffId = savedStateHandle["staffId"]
      } else {
        __staffId = ""
      }
      return com.chillarcards.servicexpert.ui.booking.BookingAllFragmentArgs(__staffId)
    }
  }
}
