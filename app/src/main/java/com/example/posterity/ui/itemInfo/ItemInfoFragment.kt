package com.example.posterity.ui.itemInfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.posterity.data.Bin
import com.example.posterity.databinding.FragmentItemInfoBinding
import com.example.posterity.ui.lookup.bin.getBinIcon
import com.example.posterity.ui.lookup.bin.getBinName

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
            if(it.mainBinDesignation != null) {
                val bin = Bin.values()[it.mainBinDesignation]
                binding.primaryBinInstruction.preDisposalIcon.setImageResource(getBinIcon(bin))
                binding.primaryBinInstruction.preDisposalTitle.text = getBinName(bin, resources)
                binding.primaryBinInstruction.preDisposalInstructionText.text = it.mainBinInstruction
            } else {
                binding.primaryBinInstruction.root.visibility = View.GONE
            }

            if(it.secondaryBinDesignation != null) {
                val bin = Bin.values()[it.secondaryBinDesignation]
                binding.secondaryBinInstruction.preDisposalIcon.setImageResource(getBinIcon(bin))
                binding.secondaryBinInstruction.preDisposalTitle.text = getBinName(bin, resources)
                binding.secondaryBinInstruction.preDisposalInstructionText.text = it.mainBinInstruction
            } else {
                binding.secondaryBinInstruction.root.visibility = View.GONE
            }
        }



        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}