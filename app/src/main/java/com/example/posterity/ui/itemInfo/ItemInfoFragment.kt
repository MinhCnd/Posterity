package com.example.posterity.ui.itemInfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.posterity.databinding.FragmentItemInfoBinding

class ItemInfoFragment: Fragment() {
    private var _binding : FragmentItemInfoBinding? = null

    private val itemInfoViewModel: ItemInfoViewModel by activityViewModels()
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentItemInfoBinding.inflate(inflater, container, false)

        itemInfoViewModel.item.observe(this.viewLifecycleOwner) {

        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}