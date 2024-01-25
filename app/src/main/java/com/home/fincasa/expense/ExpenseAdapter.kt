package com.home.fincasa.expense

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.home.fincasa.databinding.ItemOverviewExpenseBinding
import com.home.fincasa.models.Expense

class ExpenseAdapter(
    private val onBindItemExpenseViewHolder: (Expense, ViewDataBinding) -> Unit,
) : ListAdapter<Expense, RecyclerView.ViewHolder>(DiffCallback) {
    /**
     * ViewHolder for the VIDEO items
     *
     * @author Murilo Horacio Pereira da Cruz
     */
    class ItemExpenseViewHolder(private var binding: ViewDataBinding,
                                    private val onBindItemExpenseViewHolder: (
                                        Expense,
                                        ViewDataBinding
                                    ) -> Unit) :
        RecyclerView.ViewHolder(binding.root) {

        /**
         * Binds data to ViewHolder
         *
         * Binds item as media, sets a click listener to the video thumbnail image view
         * to pause the current player and navigate to the VideoPlayerActivity
         *
         * @param media The media
         * @author Murilo Horacio Pereira da Cruz
         */
        fun bind(expense: Expense) {
            onBindItemExpenseViewHolder(expense, binding)
            binding.executePendingBindings()
        }
    }

    /**
     * Gets the view type
     *
     * @param position The position of the item in the List
     * @return The view type for the element in position
     * @author Murilo Horacio Pereira da Cruz
     */
    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        return item.type
    }

    /**
     * Creates the ViewHolder according ot the viewType
     *
     * @param parent The parent ViewGroup
     * @param viewType The view type
     * @return A ViewHolder for the specific viewType
     * @author Murilo Horacio Pereira da Cruz
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemOverviewExpenseBinding.inflate(LayoutInflater.from(parent.context))
        return ItemExpenseViewHolder(binding, onBindItemExpenseViewHolder)
    }

    /**
     * Bind the ViewHolder according to the item type
     *
     * Checks if it is an audio or video item and binds the ViewHolder
     * according to the type
     *
     * @param holder The ViewHolder
     * @param position The position of the item in the List
     * @author Murilo Horacio Pereira da Cruz
     */
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        val holder: ItemExpenseViewHolder = holder as ItemExpenseViewHolder
        holder.bind(item)
    }

    /**
     * DiffCallback to tell wheter items are the same or has the same content
     *
     * @author Murilo Horacio Pereira da Cruz
     */
    companion object DiffCallback : DiffUtil.ItemCallback<Expense>() {
        override fun areItemsTheSame(oldItem: Expense, newItem: Expense): Boolean {
            return oldItem.uuid == newItem.uuid
        }

        override fun areContentsTheSame(oldItem: Expense, newItem: Expense): Boolean {
            return oldItem.title == newItem.title
                    && oldItem.type == newItem.type
        }
    }
}