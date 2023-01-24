package com.kovacivan.splashscreenhelper

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.view.animation.DecelerateInterpolator
import android.view.animation.LinearInterpolator
import androidx.core.view.isVisible

internal object AnimationHelper {

	fun fadeIn(view: View, animationDuration: Long, animationDelay: Long) {
		view.alpha = 0f
		val fadeIn = ObjectAnimator.ofFloat(view, "alpha", 0f, 1f).apply {
			duration = animationDuration
			startDelay = animationDelay
		}
		AnimatorSet().apply {
			play(fadeIn)
			start()
		}
	}

	fun fadeOut(view: View, animationDuration: Long, animationDelay: Long) {
		view.alpha = 1f
		val fadeOut = ObjectAnimator.ofFloat(view, "alpha", 1f, 0f).apply {
			duration = animationDuration
			startDelay = animationDelay
		}
		AnimatorSet().apply {
			play(fadeOut)
			start()
		}
	}

	fun flyInFromTop(view: View, animationDuration: Long, animationDelay: Long) {
		view.translationY = -2000f
		val flyIn = ValueAnimator.ofFloat(-2000f, 0f).apply {
			interpolator = DecelerateInterpolator()
			duration = animationDuration
			startDelay = animationDelay
		}

		flyIn.addUpdateListener {
			val value = it.animatedValue as Float

			view.translationY = value
		}

		AnimatorSet().apply {
			play(flyIn)
			start()
		}
	}

	fun flyInFromBottom(view: View, animationDuration: Long, animationDelay: Long) {
		view.translationY = 2000f
		val flyIn = ValueAnimator.ofFloat(2000f, 0f).apply {
			interpolator = DecelerateInterpolator()
			duration = animationDuration
			startDelay = animationDelay
		}

		flyIn.addUpdateListener {
			val value = it.animatedValue as Float

			view.translationY = value
		}

		AnimatorSet().apply {
			play(flyIn)
			start()
		}
	}

	fun flyOutToTop(view: View, animationDuration: Long, animationDelay: Long) {
		val flyOut = ValueAnimator.ofFloat(0f, -2000f).apply {
			interpolator = AccelerateInterpolator()
			duration = animationDuration
			startDelay = animationDelay
		}

		flyOut.addUpdateListener {
			val value = it.animatedValue as Float

			view.translationY = value
		}

		AnimatorSet().apply {
			play(flyOut)
			start()
		}
	}

	fun flyOutToBottom(view: View, animationDuration: Long, animationDelay: Long) {
		val flyOut = ValueAnimator.ofFloat(0f, 2000f).apply {
			interpolator = AccelerateInterpolator()
			duration = animationDuration
			startDelay = animationDelay
		}

		flyOut.addUpdateListener {
			val value = it.animatedValue as Float

			view.translationY = value
		}

		AnimatorSet().apply {
			play(flyOut)
			start()
		}
	}

	fun spinView(view: View, animationDuration: Long, animationDelay: Long) {
		val spin = ValueAnimator.ofFloat(0f, 360f).apply {
			interpolator = LinearInterpolator()
			duration = animationDuration
			startDelay = animationDelay
		}

		spin.addUpdateListener {
			val value = it.animatedValue as Float
			view.rotation = value
		}

		AnimatorSet().apply {
			play(spin)
			start()
		}
	}

	fun flyIn(logoContainer: View, imageContainer: View, textContainer: View, subTextContainer: View, duration: Long, delay: Long) {
		flyInFromTop(
			logoContainer,
			duration,
			delay
		)

		if (imageContainer.isVisible) {
			flyInFromBottom(
				imageContainer,
				duration,
				delay
			)
		} else {
			flyInFromBottom(
				textContainer,
				duration,
				delay
			)

			if (subTextContainer.isVisible) {
				flyInFromBottom(
					subTextContainer,
					duration,
					delay
				)
			}
		}
	}

	fun flyOut(logoContainer: View, imageContainer: View, textContainer: View, subTextContainer: View, duration: Long, delay: Long) {
		flyOutToTop(
			logoContainer,
			duration,
			delay
		)

		if (imageContainer.isVisible) {
			flyOutToBottom(
				imageContainer,
				duration,
				delay
			)
		} else {
			flyOutToBottom(
				textContainer,
				duration,
				delay
			)

			if (subTextContainer.isVisible) {
				flyOutToBottom(
					subTextContainer,
					duration,
					delay
				)
			}
		}
	}
}