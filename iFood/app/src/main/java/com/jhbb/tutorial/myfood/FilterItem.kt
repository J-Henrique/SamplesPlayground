package com.jhbb.tutorial.myfood

import android.content.Context
import android.view.ContextThemeWrapper
import android.view.LayoutInflater
import androidx.annotation.DrawableRes
import co.tiagoaguiar.tutorial.myfood.R
import com.google.android.material.chip.Chip

data class FilterItem(
    val id: Int,
    val text: String,
    @DrawableRes val icon: Int? = null,
    val iconSize: Float = 36.0f,
    @DrawableRes val closeIcon: Int? = null
)

fun FilterItem.toChip(context: Context): Chip {
    val chip = if (closeIcon == null) {
        LayoutInflater.from(context).inflate(R.layout.chip_choice, null, false) as Chip
    } else {
        Chip(ContextThemeWrapper(context, R.style.Widget_MaterialComponents_Chip_Choice)).apply {
            setChipBackgroundColorResource(R.color.white)
            setCloseIconResource(this@toChip.closeIcon)
            isCloseIconVisible = true
        }
    }
    chip.setChipStrokeColorResource(R.color.gray)
    chip.chipStrokeWidth = 2f
    if (icon != null) {
        chip.chipIconSize = iconSize
        chip.setChipIconResource(icon)
        chip.chipStartPadding = 20f
    } else {
        chip.chipIcon = null
    }
    chip.text = text
    return chip
}
