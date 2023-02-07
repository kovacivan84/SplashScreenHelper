package com.kovacivan.splashscreenhelper

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		SplashScreenHelper(this)
			.showLogo(true)
			.logoResource(R.mipmap.ic_launcher)
//			.logoDimensions(200, 200)
//			.logoSpin(false)
			.showText(true)
			.setText("Some text here")
			.textColor(Color.BLACK)
//			.textColorHex("#000000")
			.textTypeface(Typeface.BOLD_ITALIC)
			.textSize(10)
			.showSubText(true)
			.setSubText("Some other text")
//			.subTextColor(Color.RED)
//			.subTextColorHex("#ff0000")
//			.subTextSize(8)
			.subTextTypeface(Typeface.NORMAL)
//			.showBottomImage(false)
//			.bottomImageResource(R.mipmap.ic_launcher)
//			.bottomImageHeight(75)
//			.backgroundColor(Color.LTGRAY)
//			.setBackgroundColorHex("#333333")
//			.setBackgroundImageResource(R.mipmap.ic_launcher)
			.dividerHeight(20)
			.textDividerHeight(20)
//			.showProgressBar(false)
//			.progressBarType(ProgressBarType.HORIZONTAL)
//			.progressBarPosition(ProgressBarPosition.INSTEAD_OF_TEXT)
//			.progressBarColor(Color.RED)
//			.setProgressBarColorHex("#ff0000")
			.delay(1000)
			.duration(5000)
//			.pause(1000)
			.animationType(AnimationType.FLY_OUT)
//			.finishOnClick(true)
//			.showVideo(true)
//			.videoResource()
//			.fitVideoToScreen(false)
//			.loopVideo(false)
			.fullscreen(true)
			.start()

		SplashScreenHelper(this).onComplete(object : SplashScreenHelper.OnComplete {
			override fun onComplete() {
				Toast.makeText(
					applicationContext,
					"SplashScreenHelper finished",
					Toast.LENGTH_SHORT
				).show()
			}
		})

		setContentView(R.layout.activity_main)
	}
}