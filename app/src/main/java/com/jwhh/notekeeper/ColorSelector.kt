package com.jwhh.notekeeper

import android.content.Context
import android.support.annotation.StyleableRes
import android.util.AttributeSet
import android.widget.LinearLayout
import java.util.jar.Attributes

class ColorSelector constructor(context: Context, attributeSet: AttributeSet? = null, defStyle: Int = 0, defRes: Int = 0):
        LinearLayout(context, attributeSet, defStyle, defRes) {

    init {
        orientation = HORIZONTAL
    }

}