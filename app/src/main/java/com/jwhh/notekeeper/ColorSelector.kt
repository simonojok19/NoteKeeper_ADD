package com.jwhh.notekeeper

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.color_selector.view.*


class ColorSelector  @JvmOverloads
constructor(context: Context, attributeSet: AttributeSet? = null, defStyle: Int = 0, defRes: Int = 0):
        LinearLayout(context, attributeSet, defStyle, defRes) {

    private val listOfColors = listOf<Int>(Color.BLUE, Color.RED, Color.GREEN)
    private var selectedColorIndex = 0
    private var colorSelectListener: ColorSelectListener? = null
    init {
        orientation = HORIZONTAL
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.color_selector, this)
        colorSelector.setBackgroundColor(listOfColors[selectedColorIndex])

        colorSelectorArrowLeft.setOnClickListener {
            selectPreviousColor()
        }

        colorSelectorArrowRight.setOnClickListener {
            selectNextColor()
        }

        colorEnabled.setOnCheckedChangeListener {_, _ ->
            broadcastColor()
        }
    }

    private fun selectNextColor() {
        if (selectedColorIndex == listOfColors.lastIndex) {
            selectedColorIndex = 0
        } else {
            selectedColorIndex++
        }
        colorSelector.setBackgroundColor(listOfColors[selectedColorIndex])
        broadcastColor()
    }

    private fun selectPreviousColor() {
        if (selectedColorIndex == 0) {
            selectedColorIndex = listOfColors.lastIndex
        } else {
            selectedColorIndex--
        }
        colorSelector.setBackgroundColor(listOfColors[selectedColorIndex])
        broadcastColor()
    }

    interface ColorSelectListener {
        fun onColorSelected(color: Int)
    }

    private fun broadcastColor() {
        if (colorEnabled.isChecked) {
            colorSelectListener?.onColorSelected(listOfColors[selectedColorIndex])
        }
        else {
            colorSelectListener?.onColorSelected(Color.TRANSPARENT)
        }

    }

    fun setColorSelectListener(listener: ColorSelectListener) {
        colorSelectListener = listener
    }

    fun setSelectedColor(color: Int) {
        var index = listOfColors.indexOf(color)
        if(index == -1) {
            colorEnabled.isChecked == false
            index = 0
        } else {
            colorEnabled.isChecked = true
        }
        selectedColorIndex = index
        colorSelector.setBackgroundColor(listOfColors[selectedColorIndex])
    }

}