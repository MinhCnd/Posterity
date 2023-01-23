package com.example.posterity.ui.lookup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.lifecycle.ViewModelProvider
import com.example.posterity.R
import com.example.posterity.databinding.FragmentLookupBinding
import com.example.posterity.ui.lookup.bin.BinLookupFragment
import com.example.posterity.ui.lookup.item.ItemLookupFragment

class LookupFragment : Fragment() {

    private var _binding: FragmentLookupBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentLookupBinding.inflate(inflater, container, false)

        val lookupViewModel =
            ViewModelProvider(this)[LookupViewModel::class.java]

        childFragmentManager.commit {
            binding.binLookupButton.isSelected = true
            binding.itemLookupButton.isSelected = false
            setReorderingAllowed(true)

            when(lookupViewModel.lastLookupFragmentType.value) {
                LookupViewModel.Companion.LOOKUP.BIN -> replace<BinLookupFragment>(R.id.lookup_container_view)
                LookupViewModel.Companion.LOOKUP.ITEM -> replace<ItemLookupFragment>(R.id.lookup_container_view)
                else -> {replace<BinLookupFragment>(R.id.lookup_container_view)}
            }

        }

        binding.binLookupButton.setOnClickListener {
            binding.binLookupButton.isSelected = true
            binding.itemLookupButton.isSelected = false
            childFragmentManager.commit {
                setReorderingAllowed(true)
                replace<BinLookupFragment>(R.id.lookup_container_view)
                lookupViewModel.lastLookupFragmentType.value = LookupViewModel.Companion.LOOKUP.BIN
            }
        }

        binding.itemLookupButton.setOnClickListener {
            binding.binLookupButton.isSelected = false
            binding.itemLookupButton.isSelected = true
            childFragmentManager.commit {
                setReorderingAllowed(true)
                replace<ItemLookupFragment>(R.id.lookup_container_view)
                lookupViewModel.lastLookupFragmentType.value = LookupViewModel.Companion.LOOKUP.ITEM
            }
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}