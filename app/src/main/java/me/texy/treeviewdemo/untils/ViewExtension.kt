package me.texy.treeviewdemo.extension

import android.view.View

fun View.showIf(value: Boolean) {
    visibility = if (value) View.VISIBLE else View.GONE
}