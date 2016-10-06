package me.locolo.common.extension

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.squareup.picasso.Picasso

/**
 * Created by ilyazorin on 15/09/16.
 */

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.GONE
}

fun ViewGroup.show() {
    visibility = View.VISIBLE
}

fun ViewGroup.hide() {
    visibility = View.GONE
}

fun ImageView.load(url: String) {
    Picasso.with(context).load(url).into(this)
}

fun Context.inflateLayout(layoutResId: Int): View {
    return inflateView(this, layoutResId, null, false)
}

fun Context.inflateLayout(layoutResId: Int, parent: ViewGroup): View {
    return inflateLayout(layoutResId, parent, true)
}

fun Context.inflateLayout(layoutResId: Int, parent: ViewGroup, attachToRoot: Boolean): View {
    return inflateView(this, layoutResId, parent, attachToRoot)
}

private fun inflateView(context: Context, layoutResId: Int, parent: ViewGroup?, attachToRoot: Boolean): View {
    return LayoutInflater.from(context).inflate(layoutResId, parent, attachToRoot)
}
