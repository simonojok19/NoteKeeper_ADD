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
    private var colorSelectListener: ((Int) -> Unit)? = null

    var selectedColorValue: Int = android.R.color.transparent
        set(value) {
            var index = listOfColors.indexOf(value)
            if(index == -1) {
                colorEnabled.isChecked == false
                index = 0
            } else {
                colorEnabled.isChecked = true
            }
            selectedColorIndex = index
            colorSelector.setBackgroundColor(listOfColors[selectedColorIndex])
            field = index
        }
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


    private fun broadcastColor() {
        val color: Int = if (colorEnabled.isChecked)
            listOfColors[selectedColorIndex]
        else
            Color.TRANSPARENT

        colorSelectListener?.let { function -> function(color) }

    }

    fun setListener(color: (Int) -> Unit) {
        colorSelectListener = color
    }


}