package com.jwhh.notekeeper

import android.content.Context
import android.graphics.Color
import android.support.annotation.StyleableRes
import android.util.AttributeSet
import android.widget.LinearLayout
import java.util.jar.Attributes

class ColorSelector  @JvmOverloads
constructor(context: Context, attributeSet: AttributeSet? = null, defStyle: Int = 0, defRes: Int = 0):
        LinearLayout(context, attributeSet, defStyle, defRes) {

    private val listOfColors = listOf<Int>(Color.BLUE, Color.RED, Color.GREEN)
    private var selectedColorIndex = 0
    init {
        orientation = HORIZONTAL
    }

}