package com.kovacivan.splashscreenhelper

import android.graphics.Color
import android.graphics.Typeface
import android.widget.ImageView

internal object Constants {
	const val DEFAULT_DURATION: Long = 3000
	const val DEFAULT_DELAY: Long = 0
	const val DEFAULT_PAUSE: Long = 0
	const val DEFAULT_ANIMATION_TYPE = 1
	const val DEFAULT_SHOW_LOGO = true
	const val DEFAULT_LOGO_WIDTH = 200
	const val DEFAULT_LOGO_HEIGHT = 200
	val DEFAULT_LOGO_SCALE_TYPE = ImageView.ScaleType.FIT_CENTER
	const val DEFAULT_SHOW_BOTTOM_IMAGE = false
	const val DEFAULT_HEIGHT_BOTTOM_IMAGE = 40
	val DEFAULT_BOTTOM_IMAGE_SCALE_TYPE = ImageView.ScaleType.FIT_CENTER
	const val DEFAULT_SHOW_TEXT = true
	const val DEFAULT_TEXT = "Splash Screen Helper"
	const val DEFAULT_TEXT_COLOR = Color.BLACK
	const val DEFAULT_TEXT_TYPEFACE = Typeface.NORMAL
	const val DEFAULT_TEXT_SIZE = 10
	const val DEFAULT_TEXT_COLOR_HEX = "#000000"
	const val DEFAULT_SHOW_SUB_TEXT = false
	const val DEFAULT_SUB_TEXT = "Easiest solution for adding splash screen to your app"
	const val DEFAULT_SUB_TEXT_COLOR = Color.BLACK
	const val DEFAULT_SUB_TEXT_TYPEFACE = Typeface.NORMAL
	const val DEFAULT_SUB_TEXT_SIZE = 10
	const val DEFAULT_SUB_TEXT_COLOR_HEX = "#000000"
	const val DEFAULT_BACKGROUND_COLOR = Color.WHITE
	const val DEFAULT_BACKGROUND_COLOR_HEX = "#ffffff"
	const val FLY_IN_INT_EXTRA = 1
	const val FLY_OUT_INT_EXTRA = 2
	const val FADE_IN_INT_EXTRA = 3
	const val FADE_OUT_INT_EXTRA = 4
	const val SERIALIZABLE_EXTRA_NAME = "SplashScreenHelperModel"
	const val DEFAULT_SPIN_LOGO = false
	const val DEFAULT_SHOW_PROGRESS_BAR = false
	const val DEFAULT_PROGRESS_BAR_TYPE = ProgressBarType.CIRCULAR
	const val DEFAULT_PROGRESS_BAR_POSITION = ProgressBarPosition.BOTTOM
	const val DEFAULT_DIVIDER1_HEIGHT = 0
	const val DEFAULT_DIVIDER2_HEIGHT = 0
	const val DEFAULT_PROGRESS_BAR_COLOR = Color.BLUE
	const val DEFAULT_PROGRESS_BAR_COLOR_HEX = "#0000ff"
	const val DEFAULT_FINISH_ON_CLICK = false
	const val DEFAULT_SHOW_VIDEO_CONTAINER = false
	const val DEFAULT_VIDEO_FIT_SCREEN = false
	const val DEFAULT_FULLSCREEN = true
	const val DEFAULT_LOOP_VIDEO = false
}