package com.home.fincasa.history.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.home.fincasa.databinding.ItemTransactionBinding
import com.home.fincasa.databinding.ItemTransactionHeaderBinding
import com.home.fincasa.models.Transaction


class HistoryAdapter(
    private val onBindItemTransactionViewHolder: (Transaction, ViewDataBinding) -> Unit,
    private val onBindItemTransactionHeaderViewHolder: (Transaction, ViewDataBinding) -> Unit,
) : ListAdapter<Transaction, RecyclerView.ViewHolder>(DiffCallback) {
    /**
     * ViewHolder for the VIDEO items
     *
     * @author Murilo Horacio Pereira da Cruz
     */
    class ItemTransactionViewHolder(private var binding: ViewDataBinding,
                                private val onBindItemTransactionViewHolder: (
                                    Transaction,
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
        fun bind(transaction: Transaction) {
            onBindItemTransactionViewHolder(transaction, binding)
            binding.executePendingBindings()
        }
    }

    /**
     * ViewHolder for the AUDIO items
     *
     * @author Murilo Horacio Pereira da Cruz
     */
    class ItemTransactionHeaderViewHolder(private var binding: ViewDataBinding,
                               private val onBindItemTransactionHeaderViewHolder: (
                                   Transaction,
                                   ViewDataBinding
                               ) -> Unit) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(transaction: Transaction) {
            onBindItemTransactionHeaderViewHolder(transaction, binding)
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
        return when (viewType) {
            1 -> {
                val bindingHeaderFirst = ItemTransactionHeaderBinding.inflate(LayoutInflater.from(parent.context))
                bindingHeaderFirst.vwTimelineBarFirst.visibility = View.VISIBLE
                bindingHeaderFirst.vwTimelineBar.visibility = View.INVISIBLE
                ItemTransactionHeaderViewHolder(bindingHeaderFirst, onBindItemTransactionHeaderViewHolder)
            }
            2 -> {
                val bindingHeader = ItemTransactionHeaderBinding.inflate(LayoutInflater.from(parent.context))
                ItemTransactionHeaderViewHolder(bindingHeader, onBindItemTransactionHeaderViewHolder)
            }
            4 -> {
                val bindingItemLast = ItemTransactionBinding.inflate(LayoutInflater.from(parent.context))
                bindingItemLast.vwTimelineBar.visibility = View.INVISIBLE
                bindingItemLast.vwTimelineBarLast.visibility = View.VISIBLE
                ItemTransactionViewHolder(bindingItemLast, onBindItemTransactionViewHolder)
            }
            else -> {
                val bindingItem = ItemTransactionBinding.inflate(LayoutInflater.from(parent.context))
                ItemTransactionViewHolder(bindingItem, onBindItemTransactionViewHolder)
            }
            /*MediaType.VIDEO.value -> {
                val binding = ListItemVideoBinding.inflate(LayoutInflater.from(parent.context))

                VideoItemViewHolder(binding, onBindVideoItemViewHolder)
            }
            else -> {
                val binding = ListItemAudioBinding.inflate(LayoutInflater.from(parent.context))

                AudioItemViewHolder(binding, onBindAudioItemViewHolder)
            }*/
        }
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

        when (holder.itemViewType) {
            1 -> {
                val headerHolder: ItemTransactionHeaderViewHolder = holder as ItemTransactionHeaderViewHolder
                headerHolder.bind(item)
            }
            2 -> {
                val headerHolder: ItemTransactionHeaderViewHolder = holder as ItemTransactionHeaderViewHolder
                headerHolder.bind(item)
            }
            else -> {
                val itemHolder: ItemTransactionViewHolder = holder as ItemTransactionViewHolder
                itemHolder.bind(item)
            }
            /*MediaType.VIDEO.value -> {
                val videoHolder: VideoItemViewHolder = holder as VideoItemViewHolder
                videoHolder.bind(media)
            }
            MediaType.AUDIO.value -> {
                val audioHolder: AudioItemViewHolder = holder as AudioItemViewHolder
                audioHolder.bind(media)
            }*/
        }
    }

    /**
     * DiffCallback to tell wheter items are the same or has the same content
     *
     * @author Murilo Horacio Pereira da Cruz
     */
    companion object DiffCallback : DiffUtil.ItemCallback<Transaction>() {
        override fun areItemsTheSame(oldItem: Transaction, newItem: Transaction): Boolean {
            return oldItem.uuid == newItem.uuid
        }

        override fun areContentsTheSame(oldItem: Transaction, newItem: Transaction): Boolean {
            return oldItem.title == newItem.title
                    && oldItem.type == newItem.type
        }
    }
}