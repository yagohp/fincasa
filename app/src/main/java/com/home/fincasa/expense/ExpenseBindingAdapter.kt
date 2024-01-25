package com.home.fincasa.expense

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat.getColor
import androidx.core.widget.ImageViewCompat
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.home.fincasa.models.Expense
import java.text.NumberFormat
import java.text.SimpleDateFormat

@SuppressLint("ResourceAsColor")
@BindingAdapter("color")
fun bindColor(imgView: ImageView, @ColorRes color: Int) {
    ImageViewCompat.setImageTintList(imgView, ColorStateList.valueOf(getColor(imgView.context, color)));
}

// MMM yyyy
@SuppressLint("SimpleDateFormat")
@BindingAdapter("cat_acc_date")
fun bindCatAccDate(txtView: TextView, exp: Expense) {
    val fmt = SimpleDateFormat( "dd/MM/yyyy")

    val sb = StringBuilder()
    sb.append(exp.category)
    exp.paidWithAccount?.let {
        sb.append(" | ").append(exp.paidWithAccount)
    }
    exp.paid.let {
        sb.append(" | ").append(exp.paymentDate?.let { it1 -> fmt.format(it1) })
    } ?: run {
        sb.append(" | ").append(fmt.format(exp.dueDate))
    }

    txtView.text = sb.toString()
}

@BindingAdapter("currency")
fun bindCurrency(txtView: TextView, value: Float){
    val fmt : NumberFormat = NumberFormat.getCurrencyInstance()
    txtView.text = fmt.format(value)
}

@BindingAdapter("listExpensesFixed")
fun bindListExpensesFixed(recyclerView: RecyclerView, data: List<Expense>?) {
    val adapter = recyclerView.adapter as ExpenseAdapter
    adapter.submitList(data)
}

@BindingAdapter("listExpensesExtra")
fun bindListExpensesExtra(recyclerView: RecyclerView, data: List<Expense>?) {
    val adapter = recyclerView.adapter as ExpenseAdapter
    adapter.submitList(data)
}