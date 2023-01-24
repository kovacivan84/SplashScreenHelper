package com.kovacivan.splashscreenhelper

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		SplashScreenHelper(this)
			.showLogo(true)
			.logoResource(R.mipmap.ic_launcher)
			.logoDimensions(200, 200)
			.logoSpin(false)
//			.showText(true)
			.setText("Some text here")
			.textColor(Color.BLACK)
//			.setTextColorHex("#000000")
			.textTypeface(Typeface.BOLD_ITALIC)
			.textSize(10)
			.showSubText(true)
			.setSubText("Some other text")
			.subTextColor(Color.RED)
//			.setSubTextColorHex("#ff0000")
			.subTextTypeface(Typeface.NORMAL)
//			.showBottomImage(false)
//			.bottomImageResource(R.mipmap.ic_launcher)
//			.bottomImageHeight(75)
//			.backgroundColor(Color.LTGRAY)
//			.setBackgroundColorHex("#333333")
//			.setBackgroundImageResource(R.mipmap.ic_launcher)
			.subTextSize(8)
			.dividerHeight(20)
			.textDividerHeight(20)
			.showProgressBar(false)
			.progressBarType(ProgressBarType.HORIZONTAL)
			.progressBarPosition(ProgressBarPosition.INSTEAD_OF_TEXT)
			.progressBarColor(Color.RED)
//			.setProgressBarColorHex("#ff0000")
			.delay(1000)
			.duration(5000)
			.pause(1000)
			.animationType(AnimationType.FLY_IN)
			.finishOnClick(true)
			.showVideo(false)
//			.videoResource()
			.fullscreen(true)
			.fitVideoToScreen(true)
			.start()

		setContentView(R.layout.activity_main)
	}
}