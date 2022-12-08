package com.example.posterity.ui.lookup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
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
        val lookupViewModel =
            ViewModelProvider(this).get(LookupViewModel::class.java)

        _binding = FragmentLookupBinding.inflate(inflater, container, false)

        childFragmentManager.commit {
            setReorderingAllowed(true)
            add<BinLookupFragment>(R.id.lookup_container_view)
        }

        binding.binLookupButton.setOnClickListener {
            childFragmentManager.commit {
                setReorderingAllowed(true)
                replace<BinLookupFragment>(R.id.lookup_container_view)
            }
        }

        binding.itemLookupButton.setOnClickListener {
            childFragmentManager.commit {
                setReorderingAllowed(true)
                replace<ItemLookupFragment>(R.id.lookup_container_view)
            }
        }
        
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}