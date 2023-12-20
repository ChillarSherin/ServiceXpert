package com.chillarcards.servicexpert.ui.register

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.Boolean
import kotlin.String
import kotlin.jvm.JvmStatic

public data class MobileFragmentArgs(
  public val isVerifyTrm: Boolean = false,
  public val mobileNo: String? = "",
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putBoolean("isVerifyTrm", this.isVerifyTrm)
    result.putString("mobileNo", this.mobileNo)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("isVerifyTrm", this.isVerifyTrm)
    result.set("mobileNo", this.mobileNo)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): MobileFragmentArgs {
      bundle.setClassLoader(MobileFragmentArgs::class.java.classLoader)
      val __isVerifyTrm : Boolean
      if (bundle.containsKey("isVerifyTrm")) {
        __isVerifyTrm = bundle.getBoolean("isVerifyTrm")
      } else {
        __isVerifyTrm = false
      }
      val __mobileNo : String?
      if (bundle.containsKey("mobileNo")) {
        __mobileNo = bundle.getString("mobileNo")
      } else {
        __mobileNo = ""
      }
      return MobileFragmentArgs(__isVerifyTrm, __mobileNo)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): MobileFragmentArgs {
      val __isVerifyTrm : Boolean?
      if (savedStateHandle.contains("isVerifyTrm")) {
        __isVerifyTrm = savedStateHandle["isVerifyTrm"]
        if (__isVerifyTrm == null) {
          throw IllegalArgumentException("Argument \"isVerifyTrm\" of type boolean does not support null values")
        }
      } else {
        __isVerifyTrm = false
      }
      val __mobileNo : String?
      if (savedStateHandle.contains("mobileNo")) {
        __mobileNo = savedStateHandle["mobileNo"]
      } else {
        __mobileNo = ""
      }
      return MobileFragmentArgs(__isVerifyTrm, __mobileNo)
    }
  }
}
