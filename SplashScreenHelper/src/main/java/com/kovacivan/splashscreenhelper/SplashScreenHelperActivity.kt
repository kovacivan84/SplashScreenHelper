package com.kovacivan.splashscreenhelper

import android.content.res.ColorStateList
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.WindowManager
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.core.view.isVisible
import com.kovacivan.splashscreenhelper.AnimationHelper.fadeIn
import com.kovacivan.splashscreenhelper.AnimationHelper.fadeOut
import com.kovacivan.splashscreenhelper.AnimationHelper.flyIn
import com.kovacivan.splashscreenhelper.AnimationHelper.flyOut
import com.kovacivan.splashscreenhelper.databinding.ActivitySplashScreenHelperBinding


internal class SplashScreenHelperActivity : AppCompatActivity() {
	private lateinit var mBinding: ActivitySplashScreenHelperBinding
	private lateinit var mSplashScreenHelperModel: SplashScreenHelperModel

	private var mDuration: Long = Constants.DEFAULT_DURATION
	private var mDelay: Long = Constants.DEFAULT_DELAY
	private var mPauseAfterAnimation: Long = Constants.DEFAULT_PAUSE

	override fun onCreate(savedInstanceState: Bundle?) {

		mBinding = ActivitySplashScreenHelperBinding.inflate(layoutInflater)
		mSplashScreenHelperModel = intent.getSerializableExtra(Constants.SERIALIZABLE_EXTRA_NAME) as SplashScreenHelperModel

		super.onCreate(savedInstanceState)

		getDuration()
		getDelay()
		getPauseAfterAnimation()
		showText()
		showSubText()
		showLogo()
		showBottomImage()
		showProgressBar()
		getAnimationType()
		getBackgroundColor()
		getBackgroundImage()
		getDividerHeight()
		getTextDividerHeight()
		showVideo()
		getFullscreen()
		finishOnClick()
		showSplashScreen()

		setContentView(mBinding.root)
	}

	private fun showProgressBar() {
		if (mSplashScreenHelperModel.showProgressBar) {
			mBinding.progressBarCircular.visibility = View.VISIBLE
			mBinding.progressBarLinear.visibility = View.VISIBLE
			getProgressBar()
			getProgressBarColor()
		} else {
			mBinding.progressBarCircular.visibility = View.INVISIBLE
			mBinding.progressBarLinear.visibility = View.INVISIBLE
		}
	}

	private fun getProgressBar() {
		var progressBarView = ProgressBar(this)
		when (mSplashScreenHelperModel.progressBarType) {
			ProgressBarType.CIRCULAR -> {
				mBinding.progressBarCircular.visibility = View.VISIBLE
				mBinding.progressBarLinear.visibility = View.INVISIBLE
				progressBarView = mBinding.progressBarCircular
			}
			ProgressBarType.HORIZONTAL -> {
				mBinding.progressBarLinear.visibility = View.VISIBLE
				mBinding.progressBarCircular.visibility = View.INVISIBLE
				progressBarView = mBinding.progressBarLinear
			}
		}
		setProgressBarPosition(progressBarView, mSplashScreenHelperModel.progressBarPosition)
	}

	private fun setProgressBarPosition(progressBarView: ProgressBar, progressBarPosition: Int) {
		val bottomGuideline = if (progressBarView == mBinding.progressBarLinear) {
			mBinding.horizontalGuideline100
		} else {
			mBinding.horizontalGuideline90
		}

		val topGuideline = if (progressBarView == mBinding.progressBarLinear) {
			mBinding.horizontalGuideline0
		} else {
			mBinding.horizontalGuideline10
		}

		when (progressBarPosition) {
			ProgressBarPosition.INSTEAD_OF_TEXT -> {
				mBinding.textContainer.visibility = View.INVISIBLE
				mBinding.subTextContainer.visibility = View.INVISIBLE
				ProgressBarHelper.positionInsteadOfText(
					mBinding.parentContainer,
					progressBarView,
					mBinding.textContainer
				)
			}
			ProgressBarPosition.UNDER_TEXT -> {
				val textView = if (mBinding.subTextContainer.isVisible) {
					mBinding.subTextContainer
				} else {
					mBinding.textContainer
				}

				ProgressBarHelper.positionUnderText(
					mBinding.parentContainer,
					progressBarView,
					textView
				)
			}

			ProgressBarPosition.BOTTOM -> {
				ProgressBarHelper.positionToBottom(
					mBinding.parentContainer,
					progressBarView,
					bottomGuideline
				)
			}
			ProgressBarPosition.TOP -> {
				ProgressBarHelper.positionToTop(
					mBinding.parentContainer,
					progressBarView,
					topGuideline
				)
			}
		}
	}

	private fun getProgressBarColor() {
		val progressBarColor = mSplashScreenHelperModel.progressBarColor
		val progressBarColorHex = mSplashScreenHelperModel.progressBarColorHex

		if (progressBarColor != Constants.DEFAULT_PROGRESS_BAR_COLOR) {
			mBinding.progressBarCircular.indeterminateTintList = ColorStateList.valueOf(progressBarColor)
			mBinding.progressBarLinear.indeterminateTintList = ColorStateList.valueOf(progressBarColor)
		} else if (progressBarColorHex != Constants.DEFAULT_PROGRESS_BAR_COLOR_HEX) {
			mBinding.progressBarCircular.indeterminateTintList = ColorStateList.valueOf(Color.parseColor(progressBarColorHex))
			mBinding.progressBarLinear.indeterminateTintList = ColorStateList.valueOf(Color.parseColor(progressBarColorHex))
		}
	}

	private fun getFullscreen() {
		if (mSplashScreenHelperModel.fullscreen) {
			supportActionBar?.hide()

			window.setFlags(
				WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
				WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN
			)

			val windowInsetsController =
				WindowCompat.getInsetsController(window, window.decorView)
			windowInsetsController.systemBarsBehavior =
				WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
			windowInsetsController.hide(WindowInsetsCompat.Type.statusBars())

			supportActionBar?.hide()

			val windowInsetsController2 =
				WindowCompat.getInsetsController(window, window.decorView)
			windowInsetsController2.systemBarsBehavior =
				WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
			windowInsetsController2.hide(WindowInsetsCompat.Type.systemBars())
		}
	}

	private fun getDuration() {
		mDuration = mSplashScreenHelperModel.animationDuration
	}

	private fun getDelay() {
		mDelay = mSplashScreenHelperModel.animationDelay
	}

	private fun getPauseAfterAnimation() {
		mPauseAfterAnimation = mSplashScreenHelperModel.afterAnimationPause
	}

	private fun showLogo() {
		if (mSplashScreenHelperModel.showLogo) {
			mBinding.logoContainer.visibility = View.VISIBLE
			getLogoImage()
			getLogoDimensions()
			getLogoSpin()
			getScaleType()
		} else {
			mBinding.logoContainer.visibility = View.INVISIBLE
		}
	}

	private fun getLogoImage() {
		mBinding.logoContainer.setImageResource(
			mSplashScreenHelperModel.logoResource
		)
	}

	private fun getLogoDimensions() {
		val width = mSplashScreenHelperModel.logoWidth
		val height = mSplashScreenHelperModel.logoHeight

		mBinding.logoContainer.apply {
			layoutParams.width = GlobalUtils.intToDp(width, resources.displayMetrics)
			layoutParams.height = GlobalUtils.intToDp(height, resources.displayMetrics)
			requestLayout()
		}
	}

	private fun getLogoSpin() {
		if (mSplashScreenHelperModel.logoSpin) {
			AnimationHelper.spinView(
				mBinding.logoContainer,
				mDuration,
				mDelay
			)
		}
	}

	private fun getScaleType() {
		mBinding.logoContainer.scaleType = mSplashScreenHelperModel.logoScaleType
		mBinding.logoContainer.requestLayout()
	}

	private fun showText() {
		if (mSplashScreenHelperModel.showText && !mSplashScreenHelperModel.showBottomImage) {
			mBinding.textContainer.visibility = View.VISIBLE
			getText()
			getTextColor()
			getTextSize()
			getTypeface()
		} else if (mSplashScreenHelperModel.showProgressBar && mSplashScreenHelperModel.progressBarPosition != ProgressBarPosition.INSTEAD_OF_TEXT) {
			mBinding.textContainer.visibility = View.INVISIBLE
		} else {
			mBinding.textContainer.visibility = View.INVISIBLE
		}
	}

	private fun getText() {
		val text = mSplashScreenHelperModel.text
		if (text != "" || text.isNotEmpty()) {
			mBinding.textContainer.apply {
				visibility = View.VISIBLE
				setText(text)
			}
			getTextColor()
		} else {
			mBinding.textContainer.visibility = View.GONE
		}
	}

	private fun getTextColor() {
		val textColor = mSplashScreenHelperModel.textColor
		val textColorHex = mSplashScreenHelperModel.textColorHex

		if (textColor != Constants.DEFAULT_TEXT_COLOR) {
			mBinding.textContainer.setTextColor(textColor)
		} else if (textColorHex != Constants.DEFAULT_TEXT_COLOR_HEX) {
			mBinding.textContainer.setTextColor(
				Color.parseColor(textColorHex)
			)
		}
	}

	private fun getTypeface() {
		mBinding.textContainer.setTypeface(
			mBinding.textContainer.typeface,
			mSplashScreenHelperModel.textTypeface
		)
	}

	private fun getTextSize() {
		mBinding.textContainer.textSize = GlobalUtils.intToSp(
			mSplashScreenHelperModel.textSize,
			resources.displayMetrics
		)
		mBinding.textContainer.requestLayout()
	}

	private fun showSubText() {
		if (mSplashScreenHelperModel.showSubText && !mSplashScreenHelperModel.showBottomImage) {
			mBinding.subTextContainer.visibility = View.VISIBLE
			getSubText()
			getSubTextSize()
			getSubTextColor()
			getSubTextTypeface()
		} else if (mSplashScreenHelperModel.showProgressBar && mSplashScreenHelperModel.progressBarPosition != ProgressBarPosition.INSTEAD_OF_TEXT) {
			mBinding.textContainer.visibility = View.INVISIBLE
		} else {
			mBinding.subTextContainer.visibility = View.INVISIBLE
		}
	}

	private fun getSubText() {
		val subText = mSplashScreenHelperModel.subText
		if (subText != "" || subText.isNotEmpty()) {
			mBinding.subTextContainer.apply {
				visibility = View.VISIBLE
				text = subText
			}
			getSubTextColor()
		} else {
			mBinding.subTextContainer.visibility = View.GONE
		}
	}

	private fun getSubTextColor() {
		val subTextColor = mSplashScreenHelperModel.subTextColor
		val subTextColorHex = mSplashScreenHelperModel.subTextColorHex

		if (subTextColor != Constants.DEFAULT_SUB_TEXT_COLOR) {
			mBinding.subTextContainer.setTextColor(subTextColor)
		} else if (subTextColorHex != Constants.DEFAULT_SUB_TEXT_COLOR_HEX) {
			mBinding.subTextContainer.setTextColor(
				Color.parseColor(subTextColorHex)
			)
		}
	}

	private fun getSubTextTypeface() {
		mBinding.subTextContainer.setTypeface(
			mBinding.subTextContainer.typeface,
			mSplashScreenHelperModel.subTextColor
		)
	}

	private fun getSubTextSize() {
		mBinding.subTextContainer.textSize = GlobalUtils.intToSp(
			mSplashScreenHelperModel.subTextColor,
			resources.displayMetrics
		)
		mBinding.subTextContainer.requestLayout()
	}

	private fun showBottomImage() {
		if (mSplashScreenHelperModel.showBottomImage) {
			mBinding.imageContainer.visibility = View.VISIBLE
			getBottomImage()
			getBottomImageHeight()
			getBottomImageScaleType()
		} else {
			mBinding.imageContainer.visibility = View.INVISIBLE
		}
	}

	private fun getBottomImage() {
		val imageResource = mSplashScreenHelperModel.bottomImageResource

		if (imageResource != 0) {
			mBinding.textContainer.visibility = View.GONE
			mBinding.subTextContainer.visibility = View.GONE
			mBinding.imageContainer.apply {
				visibility = View.VISIBLE
				setImageResource(imageResource)
			}
		} else {
			if (mSplashScreenHelperModel.progressBarPosition != ProgressBarPosition.INSTEAD_OF_TEXT) {
				mBinding.textContainer.visibility = View.VISIBLE
			}
			mBinding.imageContainer.visibility = View.INVISIBLE
		}
	}

	private fun getBottomImageHeight() {
		val bottomImageHeight = mSplashScreenHelperModel.bottomImageHeight

		mBinding.imageContainer.layoutParams.height = GlobalUtils.intToDp(
			bottomImageHeight,
			resources.displayMetrics
		)
	}

	private fun getBottomImageScaleType() {
		mBinding.imageContainer.scaleType = mSplashScreenHelperModel.bottomImageScaleType
		mBinding.imageContainer.requestLayout()
	}

	private fun getAnimationType() {
		when(mSplashScreenHelperModel.animationType) {
			Constants.FLY_IN_INT_EXTRA -> {
				flyIn(
					mBinding.logoContainer,
					mBinding.imageContainer,
					mBinding.textContainer,
					mBinding.subTextContainer,
					mDuration,
					mDelay
				)
			}
			Constants.FLY_OUT_INT_EXTRA -> {
				flyOut(
					mBinding.logoContainer,
					mBinding.imageContainer,
					mBinding.textContainer,
					mBinding.subTextContainer,
					mDuration,
					mDelay
				)
			}
			Constants.FADE_IN_INT_EXTRA -> {
				mBinding.parentContainer.alpha = 0f
				fadeIn(
					mBinding.parentContainer,
					mDuration,
					mDelay
				)
			}
			Constants.FADE_OUT_INT_EXTRA -> {
				fadeOut(
					mBinding.parentContainer,
					mDuration,
					mDelay
				)
			}
		}
	}

	private fun getBackgroundColor() {
		val backgroundColor = mSplashScreenHelperModel.backgroundColor
		val backgroundColorHex = mSplashScreenHelperModel.backgroundColorHex

		if (backgroundColor != Constants.DEFAULT_BACKGROUND_COLOR) {
			mBinding.parentContainer.setBackgroundColor(backgroundColor)
		} else if (backgroundColorHex != Constants.DEFAULT_BACKGROUND_COLOR_HEX) {
			mBinding.parentContainer.setBackgroundColor(
				Color.parseColor(backgroundColorHex)
			)
		}
	}

	private fun getBackgroundImage() {
		val backgroundImage = mSplashScreenHelperModel.backgroundImageResource

		if (backgroundImage != 0) {
			mBinding.backgroundImageContainer.apply {
				visibility = View.VISIBLE
				setImageResource(backgroundImage)
			}
		} else {
			mBinding.backgroundImageContainer.visibility = View.GONE
		}
	}

	private fun getDividerHeight() {
		mBinding.divider1.layoutParams.height = GlobalUtils.intToDp(
			mSplashScreenHelperModel.divider1Height,
			resources.displayMetrics
		)
		mBinding.divider1.requestLayout()
	}

	private fun getTextDividerHeight() {
		mBinding.divider2.layoutParams.height = GlobalUtils.intToDp(
			mSplashScreenHelperModel.divider2Height,
			resources.displayMetrics
		)
		mBinding.divider2.requestLayout()
	}

	private fun showSplashScreen() {
		Handler(Looper.getMainLooper()).postDelayed({
			if (onComplete != null) {
				onComplete?.onComplete()
			}
			finishActivity()
		}, mDuration + mDelay)
	}

	private fun showVideo() {
		if (mSplashScreenHelperModel.showVideo) {
			mBinding.videoContainer.visibility = View.VISIBLE
			mBinding.parentContainer.visibility = View.GONE
			val videoResource = mSplashScreenHelperModel.videoResource
			mBinding.videoContainer.apply {
				setVideoURI(
					Uri.parse("android.resource://${this@SplashScreenHelperActivity.packageName}/$videoResource")
				)
				setOnPreparedListener { mediaPlayer ->
					if (!mSplashScreenHelperModel.videoFitScreen) {
						val videoRatio = mediaPlayer.videoWidth / mediaPlayer.videoHeight.toFloat()
						val screenRatio =
							mBinding.videoContainer.width / mBinding.videoContainer.height.toFloat()
						val scaleX = videoRatio / screenRatio
						if (scaleX >= 1f) {
							mBinding.videoContainer.scaleX = scaleX
						} else {
							mBinding.videoContainer.scaleY = 1f / scaleX
						}
					}
				}
				setOnTouchListener { v, event ->
					v.performClick()
					this@SplashScreenHelperActivity.finish()
					false
				}
				setOnCompletionListener {
					finish()
				}
				start()
			}
		} else {
			mBinding.videoContainer.visibility = View.GONE
			mBinding.parentContainer.visibility = View.VISIBLE
		}
	}

	private fun finishOnClick() {
		if (mSplashScreenHelperModel.finishOnClick) {
			if (mBinding.parentContainer.isVisible) {
				mBinding.parentContainer.setOnClickListener {
					finish()
				}
			}
		}
	}

	private fun finishActivity() {
		Handler(Looper.getMainLooper()).postDelayed({
			finish()
		}, mPauseAfterAnimation)
	}

	companion object {
		private const val TAG = "SplashScreenHelperActivity"

		var onComplete: SplashScreenHelper.OnComplete? = null
	}
}