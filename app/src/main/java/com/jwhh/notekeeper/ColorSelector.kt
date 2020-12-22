package com.jwhh.notekeeper

import android.content.Context
import android.support.annotation.StyleableRes
import android.util.AttributeSet
import android.widget.LinearLayout
import java.util.jar.Attributes

class ColorSelector: LinearLayout {

    constructor(context: Context)
            : super(context) {
        orientation = HORIZONTAL
    }

    constructor(context: Context, attributeSet: AttributeSet)
            : super(context, attributeSet) {
        orientation = HORIZONTAL
    }

    constructor(context: Context, attributeSet: AttributeSet, defStyleAttr: Int)
            : super(context, attributeSet, defStyleAttr){
        orientation = HORIZONTAL
    }

}