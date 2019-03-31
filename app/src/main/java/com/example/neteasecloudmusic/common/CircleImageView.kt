package com.example.neteasecloudmusic.common

import android.content.Context
import android.graphics.*
import android.support.v7.widget.AppCompatImageView
import android.util.AttributeSet
import android.graphics.drawable.BitmapDrawable
import android.support.annotation.Nullable
import android.util.Log


class CircleImageView @JvmOverloads constructor(
    context: Context, @Nullable attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatImageView(context, attrs, defStyleAttr) {
    private var radius: Float = 0.toFloat()
    private val paint: Paint = Paint()

    init {
        paint.isAntiAlias = true
    }


    override fun onDraw(canvas: Canvas) {
        val drawable = drawable
        if (drawable == null) {
            super.onDraw(canvas)
            return
        }
        radius = (Math.max(width, height) / 2).toFloat()
        if (drawable is BitmapDrawable) {
            paint.shader = initBitmapShader(drawable)
            canvas.drawCircle(width / 2f, height / 2f, radius, paint)
            return
        }
        super.onDraw(canvas)
    }


    private fun initBitmapShader(drawable: BitmapDrawable): BitmapShader {
        val bitmap = drawable.bitmap
        val scale = Math.max(width.toFloat() / bitmap.width.toFloat(), height.toFloat() / bitmap.height.toFloat())
        val matrix = Matrix()
        matrix.postScale(scale, scale)
        val newBitMap = Bitmap.createBitmap(
            bitmap, 0, 0, bitmap.width,
            bitmap.height, matrix, true
        )
        return BitmapShader(newBitMap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
    }
}
