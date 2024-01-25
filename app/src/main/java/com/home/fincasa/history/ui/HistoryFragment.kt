package com.home.fincasa.history.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.home.fincasa.databinding.FragmentHistoryBinding
import com.home.fincasa.databinding.ItemTransactionBinding
import com.home.fincasa.databinding.ItemTransactionHeaderBinding
import com.home.fincasa.models.Transaction

class HistoryFragment : Fragment() {

    private lateinit var viewModel: HistoryViewModel
    private var _binding: FragmentHistoryBinding? = null
    private lateinit var root : View

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val onBindItemTransactionViewHolder: (
        Transaction,
        ViewDataBinding
    ) -> Unit = { item: Transaction,
                  viewDataBinding: ViewDataBinding ->

        (viewDataBinding as ItemTransactionBinding).apply {
            transaction = item
//            ivThumb.setOnClickListener {
//                onVideoMediaClick(media)
//            }
        }
    }

    private val onBindItemTransactionHeaderViewHolder: (Transaction,
                                              ViewDataBinding) -> Unit = { item: Transaction,
                                                                           viewDataBinding: ViewDataBinding ->

        (viewDataBinding as ItemTransactionHeaderBinding).apply {
            transaction = item
            //onBindPlayerControlView(pcAudio, media)
        }
    }

//    private fun onVideoMediaClick(media: Media) {
//        if (viewModel.playerState.value?.currentPlayer != null) {
//            viewModel.playerState.value!!.currentPlayer!!.playWhenReady = false
//        }
//
//        val action = MediasFragmentDirections
//            .actionMediasFragmentToVideoPlayerActivity(media.videoCode!!)
//
//        findNavController().navigate(action)
//    }

//    private fun onBindPlayerControlView(playerControlView: PlayerControlView,
//                                        media: Media) {
//        playerControlView.player = if (viewModel.playerState.value?.currentMedia == media)
//            viewModel.playerState.value!!.currentPlayer!! else AudioPlayer(media,
//            requireContext(), onChangePlayingState).buildSimpleExoPlayer()
//    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel =
            ViewModelProvider(this, HistoryViewModelFactory()).get(HistoryViewModel::class.java)

        val binding = FragmentHistoryBinding.inflate(inflater)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        binding.rvHistory.adapter = HistoryAdapter(
            onBindItemTransactionViewHolder,
            onBindItemTransactionHeaderViewHolder
        )

        this.root = binding.root
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //this.main = root.context as MainActivity

        //val tabs: TabLayout = this.main!!.findViewById(R.id.tabs)
        //tabs.visibility = View.GONE
    }

    override fun onStart() {
        super.onStart()
        viewModel.getHistory()
    }
}