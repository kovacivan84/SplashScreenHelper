package com.kovacivan.splashscreenhelper

import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.constraintlayout.widget.Guideline

internal object ProgressBarHelper {

	fun positionInsteadOfText(parentContainer: ConstraintLayout, progressBar: View, textView: View) {
		val constraintSet = ConstraintSet()
		constraintSet.clone(parentContainer)
		constraintSet.connect(
			progressBar.id,
			ConstraintSet.START,
			textView.id,
			ConstraintSet.START,
			0
		)
		constraintSet.connect(
			progressBar.id,
			ConstraintSet.END,
			textView.id,
			ConstraintSet.END,
			0
		)
		constraintSet.connect(
			progressBar.id,
			ConstraintSet.TOP,
			textView.id,
			ConstraintSet.TOP,
			0
		)
		constraintSet.connect(
			progressBar.id,
			ConstraintSet.BOTTOM,
			textView.id,
			ConstraintSet.BOTTOM,
			0
		)

		constraintSet.applyTo(parentContainer)
	}

	fun positionUnderText(parentContainer: ConstraintLayout, progressBar: View, textView: View) {
		val constraintSet = ConstraintSet()
		constraintSet.clone(parentContainer)
		constraintSet.connect(
			progressBar.id,
			ConstraintSet.START,
			textView.id,
			ConstraintSet.START,
			0
		)
		constraintSet.connect(
			progressBar.id,
			ConstraintSet.END,
			textView.id,
			ConstraintSet.END,
			0
		)
		constraintSet.connect(
			progressBar.id,
			ConstraintSet.TOP,
			textView.id,
			ConstraintSet.BOTTOM,
			0
		)

		constraintSet.applyTo(parentContainer)
	}

	fun positionToTop(parentContainer: ConstraintLayout, progressBar: View, guideline: Guideline) {
		val constraintSet = ConstraintSet()
		constraintSet.clone(parentContainer)
		constraintSet.connect(
			progressBar.id,
			ConstraintSet.START,
			parentContainer.id,
			ConstraintSet.START,
			0
		)
		constraintSet.connect(
			progressBar.id,
			ConstraintSet.END,
			parentContainer.id,
			ConstraintSet.END,
			0
		)
		constraintSet.connect(
			progressBar.id,
			ConstraintSet.TOP,
			guideline.id,
			ConstraintSet.TOP,
			0
		)
		constraintSet.connect(
			progressBar.id,
			ConstraintSet.BOTTOM,
			guideline.id,
			ConstraintSet.BOTTOM,
			0
		)

		constraintSet.applyTo(parentContainer)
	}

	fun positionToBottom(parentContainer: ConstraintLayout, progressBar: View, guideline: Guideline) {
		val constraintSet = ConstraintSet()
		constraintSet.clone(parentContainer)
		constraintSet.connect(
			progressBar.id,
			ConstraintSet.START,
			parentContainer.id,
			ConstraintSet.START,
			0
		)
		constraintSet.connect(
			progressBar.id,
			ConstraintSet.END,
			parentContainer.id,
			ConstraintSet.END,
			0
		)
		constraintSet.connect(
			progressBar.id,
			ConstraintSet.TOP,
			guideline.id,
			ConstraintSet.TOP,
			0
		)
		constraintSet.connect(
			progressBar.id,
			ConstraintSet.BOTTOM,
			guideline.id,
			ConstraintSet.BOTTOM,
			0
		)

		constraintSet.applyTo(parentContainer)
	}
}