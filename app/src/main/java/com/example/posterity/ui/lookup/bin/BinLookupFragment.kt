package com.example.posterity.ui.lookup.bin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.posterity.data.Bin
import com.example.posterity.databinding.FragmentBinLookupBinding

class BinLookupFragment : Fragment() {
    private var _binding: FragmentBinLookupBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBinLookupBinding.inflate(inflater, container, false)

        binding.binRecyclerView.adapter = BinAdapter(Bin.values().toList())

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}