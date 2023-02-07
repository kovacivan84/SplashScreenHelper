package com.kovacivan.splashscreenhelper

import android.app.Activity
import android.net.Uri
import android.util.DisplayMetrics
import android.util.TypedValue

internal object GlobalUtils {

	fun intToDp(int: Int, displayMetrics: DisplayMetrics): Int {
		return TypedValue.applyDimension(
			TypedValue.COMPLEX_UNIT_DIP,
			int.toFloat(),
			displayMetrics
		).toInt()
	}

	fun intToSp(int: Int, displayMetrics: DisplayMetrics): Float {
		return TypedValue.applyDimension(
			TypedValue.COMPLEX_UNIT_SP,
			int.toFloat(),
			displayMetrics
		)
	}
}