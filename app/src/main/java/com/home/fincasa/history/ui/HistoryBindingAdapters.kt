package com.home.fincasa.history.ui

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.PorterDuff
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getColor
import androidx.core.widget.ImageViewCompat
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.home.fincasa.models.Transaction
import java.security.AccessController.getContext
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.Date

/*@BindingAdapter("mediaType", "videoId")
fun bindImage(imgView: ImageView, mediaType: Int, videoId: String?) {
    videoId?.let {
        if (mediaType == MediaType.VIDEO.value) {
            val thumbnailUri = "https://img.youtube.com/vi/$it/0.jpg".toUri().buildUpon()
                .scheme("https").build()
            imgView.load(thumbnailUri) {
                placeholder(R.drawable.ic_baseline_video_library_48)
                error(R.drawable.ic_baseline_broken_image_24)
            }
        }
    }
}*/

@SuppressLint("ResourceAsColor")
@BindingAdapter("color")
fun bindColor(imgView: ImageView, @ColorRes color: Int) {
    ImageViewCompat.setImageTintList(imgView, ColorStateList.valueOf(getColor(imgView.context, color)));
}

@SuppressLint("SimpleDateFormat")
@BindingAdapter("date")
fun bindDate(txtView: TextView, date: Date) {
    val fmt = SimpleDateFormat( "EEE, d MMM yyyy")
    txtView.text = fmt.format(date)
}

@BindingAdapter("currency")
fun bindCurrency(txtView: TextView, value: Float){
    val fmt : NumberFormat = NumberFormat.getCurrencyInstance()
    txtView.text = fmt.format(value)
}

@BindingAdapter("listTransactions")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Transaction>?) {
    val adapter = recyclerView.adapter as HistoryAdapter
    adapter.submitList(data)
}

/*@BindingAdapter("practiceMediasData")
fun bindPracticeRecyclerView(recyclerView: RecyclerView, data: List<Media>?) {
    val adapter = recyclerView.adapter as GenericPracticeAdapter
    adapter.submitList(data)
}

@BindingAdapter("mediaApiStatus")
fun bindStatus(statusImageView: ImageView, status: ScreenStatus?) {
    when(status) {
        ScreenStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.contentDescription = statusImageView.context
                .getString(R.string.loading)
            statusImageView.setImageResource(R.drawable.anim_loading)
        }
        ScreenStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.contentDescription = statusImageView.context
                .getString(R.string.connection_error)
            statusImageView.setImageResource(R.drawable.ic_conn_error)
        }
        ScreenStatus.DONE -> {
            statusImageView.visibility = View.GONE
            statusImageView.contentDescription = null
        }
    }
}*/
