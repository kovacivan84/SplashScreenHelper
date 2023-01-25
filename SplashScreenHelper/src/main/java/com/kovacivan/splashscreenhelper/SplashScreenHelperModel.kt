package com.kovacivan.splashscreenhelper

import android.widget.ImageView

internal class SplashScreenHelperModel : java.io.Serializable {
	var animationDuration: Long = Constants.DEFAULT_DURATION
	var animationDelay: Long = Constants.DEFAULT_DELAY
	var afterAnimationPause: Long = Constants.DEFAULT_PAUSE
	var animationType: Int = Constants.DEFAULT_ANIMATION_TYPE
	var showLogo: Boolean = Constants.DEFAULT_SHOW_LOGO
	var logoResource: Int = R.drawable.splash
	var logoHeight: Int = Constants.DEFAULT_LOGO_HEIGHT
	var logoWidth: Int = Constants.DEFAULT_LOGO_WIDTH
	var logoSpin: Boolean = Constants.DEFAULT_SPIN_LOGO
	var logoScaleType: ImageView.ScaleType = Constants.DEFAULT_LOGO_SCALE_TYPE
	var showText: Boolean = Constants.DEFAULT_SHOW_TEXT
	var text: String = Constants.DEFAULT_TEXT
	var textColor: Int = Constants.DEFAULT_TEXT_COLOR
	var textTypeface: Int = Constants.DEFAULT_TEXT_TYPEFACE
	var textSize: Int = Constants.DEFAULT_TEXT_SIZE
	var textColorHex: String = Constants.DEFAULT_TEXT_COLOR_HEX
	var showSubText: Boolean = Constants.DEFAULT_SHOW_SUB_TEXT
	var subText: String = Constants.DEFAULT_SUB_TEXT
	var subTextColor: Int = Constants.DEFAULT_SUB_TEXT_COLOR
	var subTextTypeface: Int = Constants.DEFAULT_SUB_TEXT_TYPEFACE
	var subTextSize: Int = Constants.DEFAULT_SUB_TEXT_SIZE
	var subTextColorHex: String = Constants.DEFAULT_SUB_TEXT_COLOR_HEX
	var showBottomImage: Boolean = Constants.DEFAULT_SHOW_BOTTOM_IMAGE
	var bottomImageResource: Int = 0
	var bottomImageHeight: Int = Constants.DEFAULT_HEIGHT_BOTTOM_IMAGE
	var bottomImageScaleType: ImageView.ScaleType = Constants.DEFAULT_BOTTOM_IMAGE_SCALE_TYPE
	var backgroundColor: Int = Constants.DEFAULT_BACKGROUND_COLOR
	var backgroundColorHex: String = Constants.DEFAULT_BACKGROUND_COLOR_HEX
	var backgroundImageResource: Int = 0
	var showProgressBar: Boolean = Constants.DEFAULT_SHOW_PROGRESS_BAR
	var progressBarType: Int = Constants.DEFAULT_PROGRESS_BAR_TYPE
	var progressBarPosition: Int = Constants.DEFAULT_PROGRESS_BAR_POSITION
	var divider1Height: Int = Constants.DEFAULT_DIVIDER1_HEIGHT
	var divider2Height: Int = Constants.DEFAULT_DIVIDER2_HEIGHT
	var progressBarColor: Int = Constants.DEFAULT_PROGRESS_BAR_COLOR
	var progressBarColorHex: String = Constants.DEFAULT_PROGRESS_BAR_COLOR_HEX
	var finishOnClick: Boolean = Constants.DEFAULT_FINISH_ON_CLICK
	var showVideo: Boolean = Constants.DEFAULT_SHOW_VIDEO_CONTAINER
	var videoResource: Int = R.raw.splashvideo
	var videoFitScreen: Boolean = Constants.DEFAULT_VIDEO_FIT_SCREEN
	var loopVideo: Boolean = Constants.DEFAULT_LOOP_VIDEO
	var fullscreen: Boolean = Constants.DEFAULT_FULLSCREEN
}
