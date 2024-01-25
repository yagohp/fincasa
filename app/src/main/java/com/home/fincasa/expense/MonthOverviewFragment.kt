package com.home.fincasa.expense

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.home.fincasa.databinding.FragmentMonthOverviewBinding
import com.home.fincasa.databinding.ItemOverviewExpenseBinding
import com.home.fincasa.models.Expense

class MonthOverviewFragment : Fragment() {

    private lateinit var viewModel: MonthOverviewViewModel
    private var _binding: FragmentMonthOverviewBinding? = null
    private lateinit var root : View

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val onBindItemExpenseViewHolder: (
        Expense,
        ViewDataBinding
    ) -> Unit = { item: Expense,
                  viewDataBinding: ViewDataBinding ->

        (viewDataBinding as ItemOverviewExpenseBinding).apply {
            expense = item
//            ivThumb.setOnClickListener {
//                onVideoMediaClick(media)
//            }
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

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel =
            ViewModelProvider(this, MonthOverviewViewModelFactory()).get(MonthOverviewViewModel::class.java)

        val binding = FragmentMonthOverviewBinding.inflate(inflater)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.rvExpenseFixed.adapter = ExpenseAdapter(onBindItemExpenseViewHolder)
        binding.rvExpenseExtra.adapter = ExpenseAdapter(onBindItemExpenseViewHolder)

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
        viewModel.getMonthOverView()
        viewModel.getFixedExpenses()
        viewModel.getExtraExpenses()
    }
}