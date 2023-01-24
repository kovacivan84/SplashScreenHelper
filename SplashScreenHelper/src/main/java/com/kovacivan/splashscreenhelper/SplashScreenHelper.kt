package com.kovacivan.splashscreenhelper

import android.app.Activity
import android.content.Intent
import android.widget.ImageView.ScaleType

class SplashScreenHelper(activity: Activity) {
	private var mActivity = activity
	private val mSplashScreenHelperIntent = Intent(activity, SplashScreenHelperActivity::class.java)
	private var mSplashScreenHelperModel = SplashScreenHelperModel()

	/**
	 * Set animation duration in milliseconds
	 *
	 * Default value is 3000 milliseconds or 3 second
	 */
	fun duration(durationInMilliseconds: Long): SplashScreenHelper {
		mSplashScreenHelperModel.animationDuration = durationInMilliseconds
		return this
	}

	/**
	 * Delay the start of animation
	 *
	 * Default is 0
	 */
	fun delay(delayInMilliseconds: Long): SplashScreenHelper {
		mSplashScreenHelperModel.animationDelay = delayInMilliseconds
		return this
	}

	/**
	 * Add pause after animation is finished
	 *
	 * Default is 0
	 */
	fun pause(pauseInMilliseconds: Long): SplashScreenHelper {
		mSplashScreenHelperModel.afterAnimationPause = pauseInMilliseconds
		return this
	}

	/**
	 * Choose the type of the animation:
	 *
	 * AnimationType.FADE_IN - Splash screen is not visible at start and it becomes
	 * visible after animation
	 *
	 * AnimationType.FADE_OUT - Splash screen is visible and it becomes invisible
	 * after animation
	 *
	 * AnimationType.FLY_IN - Logo flies in from the top and text or bottom image
	 * flies in from the bottom
	 *
	 * AnimationType.FLY_OUT - Logo flies out to top and text or bottom image flies out to the bottom
	 *
	 * Default type is FLY_IN
	 */
	fun animationType(animationType: AnimationType): SplashScreenHelper {
		val animationTypeIntExtra: Int = when (animationType) {
			AnimationType.FLY_IN -> Constants.FLY_IN_INT_EXTRA
			AnimationType.FLY_OUT -> Constants.FLY_OUT_INT_EXTRA
			AnimationType.FADE_IN -> Constants.FADE_IN_INT_EXTRA
			AnimationType.FADE_OUT -> Constants.FADE_OUT_INT_EXTRA
		}

		mSplashScreenHelperModel.animationType = animationTypeIntExtra
		return this
	}

	/**
	 * Choose to display logo or not
	 *
	 * Default is true
	 */
	fun showLogo(shouldShowLogo: Boolean): SplashScreenHelper {
		mSplashScreenHelperModel.showLogo = shouldShowLogo
		return this
	}

	/**
	 * Set resource image of your choosing as logo image
	 */
	fun logoResource(logoResource: Int): SplashScreenHelper {
		mSplashScreenHelperModel.logoResource = logoResource
		mSplashScreenHelperModel.showLogo = true
		return this
	}

	/**
	 * Set width and height of logo image
	 */
	fun logoDimensions(width: Int, height: Int): SplashScreenHelper {
		mSplashScreenHelperModel.logoWidth = width
		mSplashScreenHelperModel.logoHeight = height
		return this
	}

	/**
	 * Adds a spinning effect on a logo image
	 */
	fun logoSpin(shouldLogoSpin: Boolean): SplashScreenHelper {
		mSplashScreenHelperModel.logoSpin = shouldLogoSpin
		return this
	}

	/**
	 * Change scale type for logo
	 *
	 * Default is ImageView.ScaleType.FIT_CENTER
	 */
	fun logoScaleType(logoScaleType: ScaleType): SplashScreenHelper {
		mSplashScreenHelperModel.logoScaleType = logoScaleType
		return this
	}

	/**
	 * Choose should you want to show text
	 *
	 * Default is false
	 */
	fun showText(shouldShowText: Boolean): SplashScreenHelper {
		mSplashScreenHelperModel.showText = shouldShowText
		return this
	}

	/**
	 * Add text under logo image
	 *
	 * IMPORTANT: You can't choose text and bottom image at the same time
	 */
	fun setText(text: String): SplashScreenHelper {
		mSplashScreenHelperModel.text = text
		return this
	}

	/**
	 * Choose color for the text under logo (eg. Color.BLACK)
	 *
	 * Default is black
	 */
	fun textColor(textColor: Int): SplashScreenHelper {
		mSplashScreenHelperModel.textColor = textColor
		return this
	}

	/**
	 * Choose color for text under logo in HEX format (eg. "#ff0000" for red)
	 *
	 * Default is black
	 */
	fun textColorHex(textColorHex: String): SplashScreenHelper {
		mSplashScreenHelperModel.textColorHex = textColorHex
		return this
	}

	/**
	 * Set typeface for the text under logo (eg. Typeface.BOLD)
	 */
	fun textTypeface(textTypeface: Int): SplashScreenHelper {
		mSplashScreenHelperModel.textTypeface = textTypeface
		return this
	}

	/**
	 * Set text size for the text under logo
	 *
	 * Default is 10
	 */
	fun textSize(textSize: Int): SplashScreenHelper {
		mSplashScreenHelperModel.textSize = textSize
		return this
	}

	/**
	 * Choose should you want to show sub text
	 *
	 * Default is false
	 */
	fun showSubText(shouldShowSubText: Boolean): SplashScreenHelper {
		mSplashScreenHelperModel.showSubText = shouldShowSubText
		return this
	}

	/**
	 * Add sub text under text
	 *
	 * IMPORTANT: You can't choose text and bottom image at the same time
	 */
	fun setSubText(subText: String): SplashScreenHelper {
		mSplashScreenHelperModel.subText = subText
		return this
	}

	/**
	 * Choose color for the sub text (eg. Color.BLACK)
	 *
	 * Default is black
	 */
	fun subTextColor(subTextColor: Int): SplashScreenHelper {
		mSplashScreenHelperModel.subTextColor = subTextColor
		return this
	}

	/**
	 * Choose color for sub text in HEX format (eg. "#ff0000" for red)
	 *
	 * Default is black
	 */
	fun subTextColorHex(subTextColorHex: String): SplashScreenHelper {
		mSplashScreenHelperModel.subTextColorHex = subTextColorHex
		return this
	}

	/**
	 * Set typeface for the sub text (eg. Typeface.BOLD)
	 */
	fun subTextTypeface(subTextTypeface: Int): SplashScreenHelper {
		mSplashScreenHelperModel.subTextTypeface = subTextTypeface
		return this
	}

	/**
	 * Set text size for the sub text
	 *
	 * Default is 10
	 */
	fun subTextSize(subTextSize: Int): SplashScreenHelper {
		mSplashScreenHelperModel.subTextSize = subTextSize
		return this
	}

	/**
	 * Choose should you want to show bottom image instead of text
	 */
	fun showBottomImage(shouldShowBottomImage: Boolean): SplashScreenHelper {
		mSplashScreenHelperModel.showBottomImage = shouldShowBottomImage
		return this
	}

	/**
	 * Add resource image under logo image
	 *
	 * IMPORTANT: You can't choose bottom image and text at the same time
	 */
	fun bottomImageResource(bottomImageResource: Int): SplashScreenHelper {
		mSplashScreenHelperModel.bottomImageResource = bottomImageResource
		return this
	}

	/**
	 * Set the height of the bottom image
	 */
	fun bottomImageHeight(bottomImageHeight: Int): SplashScreenHelper {
		mSplashScreenHelperModel.bottomImageHeight = bottomImageHeight
		return this
	}

	/**
	 * Change scale type for bottom image
	 *
	 * Default is ImageView.ScaleType.FIT_CENTER
	 */
	fun bottomImageScaleType(bottomImageScaleType: ScaleType): SplashScreenHelper {
		mSplashScreenHelperModel.bottomImageScaleType = bottomImageScaleType
		return this
	}

	/**
	 * Choose background color (eg. Color.RED)
	 *
	 * White is the default color
	 */
	fun backgroundColor(backgroundColor: Int): SplashScreenHelper {
		mSplashScreenHelperModel.backgroundColor = backgroundColor
		return this
	}

	/**
	 * Choose background color in HEX format (eg. "#ff0000" for red)
	 *
	 * White is the default color
	 */
	fun backgroundColorHex(backgroundColorHex: String): SplashScreenHelper {
		mSplashScreenHelperModel.backgroundColorHex = backgroundColorHex
		return this
	}

	/**
	 * Set resource image of your choosing as logo image
	 */
	fun backgroundImageResource(backgroundImageResource: Int): SplashScreenHelper {
		mSplashScreenHelperModel.backgroundImageResource = backgroundImageResource
		return this
	}

	/**
	 * Shows indeterminate circular progress bar
	 */
	fun showProgressBar(shouldShowProgressBar: Boolean): SplashScreenHelper {
		mSplashScreenHelperModel.showProgressBar = shouldShowProgressBar
		return this
	}

	/**
	 * Choose style of progress bar (eg. ProgressBarType.CIRCULAR)
	 *
	 * Default is circular
	 */
	fun progressBarType(progressBarType: Int): SplashScreenHelper {
		mSplashScreenHelperModel.progressBarType = progressBarType
		return this
	}

	/**
	 * Choose position of progress bar (eg. ProgressBarPosition.BOTTOM)
	 *
	 * Default is bottom
	 */
	fun progressBarPosition(progressBarPosition: Int): SplashScreenHelper {
		mSplashScreenHelperModel.progressBarPosition = progressBarPosition
		return this
	}

	/**
	 * Choose progress bar color (eg. Color.RED)
	 *
	 * Default is blue
	 */
	fun progressBarColor(progressBarColor: Int): SplashScreenHelper {
		mSplashScreenHelperModel.progressBarColor = progressBarColor
		return this
	}

	/**
	 * Choose progress bar color in HEX format (eg. "#ff0000" for red)
	 *
	 * Default is blue
	 */
	fun progressBarColorHex(setProgressBarColorHex: String): SplashScreenHelper {
		mSplashScreenHelperModel.progressBarColorHex = setProgressBarColorHex
		return this
	}

	/**
	 * Set space between logo and text or bottom image
	 */
	fun dividerHeight(dividerHeight: Int): SplashScreenHelper {
		mSplashScreenHelperModel.divider1Height = dividerHeight
		return this
	}

	/**
	 * Set space between text and sub text
	 */
	fun textDividerHeight(dividerHeight: Int): SplashScreenHelper {
		mSplashScreenHelperModel.divider2Height = dividerHeight
		return this
	}

	/**
	 * Choose would you like to show video instead of logo and text
	 *
	 * Default is false
	 */
	fun showVideo(shouldShowVideo: Boolean): SplashScreenHelper {
		mSplashScreenHelperModel.showVideo = shouldShowVideo
		return this
	}

	/**
	 * Add video from resources
	 */
	fun videoResource(videoResource: Int): SplashScreenHelper {
		mSplashScreenHelperModel.videoResource = videoResource
		return this
	}

	/**
	 * Fit video to screen or keep aspect ratio
	 *
	 * Default is false (keep aspect ratio)
	 */
	fun fitVideoToScreen(shouldFitVideo: Boolean): SplashScreenHelper {
		mSplashScreenHelperModel.videoFitScreen = shouldFitVideo
		return this
	}

	fun fullscreen(showFullscreen: Boolean): SplashScreenHelper {
		mSplashScreenHelperModel.fullscreen = showFullscreen
		return this
	}

	/**
	 * Adds and option to end splash screen on click before animation duration
	 * time runs out
	 *
	 * Default is false
	 */
	fun finishOnClick(enableFinishOnClick: Boolean): SplashScreenHelper {
		mSplashScreenHelperModel.finishOnClick = enableFinishOnClick
		return this
	}

	/**
	 * Starts splash screen
	 */
	fun start(): SplashScreenHelper {
		mSplashScreenHelperIntent.putExtra(
			Constants.SERIALIZABLE_EXTRA_NAME,
			mSplashScreenHelperModel
		)

		mActivity.startActivity(mSplashScreenHelperIntent)
		return this
	}

	interface OnComplete {
		fun onComplete()
	}
}