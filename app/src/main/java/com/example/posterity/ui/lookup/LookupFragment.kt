package com.example.posterity.ui.lookup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintSet
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
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

        //Programmatically set constraints based on what type of child fragment is being used
        val constraintSetItemLookup = ConstraintSet()
        val constraintSetBinLookup = ConstraintSet()
        constraintSetItemLookup.clone(binding.root)
        constraintSetBinLookup.clone(binding.root)
        constraintSetBinLookup.connect(binding.lookupContainerView.id,ConstraintSet.TOP, binding.divider.id, ConstraintSet.BOTTOM)
        constraintSetBinLookup.connect(binding.lookupContainerView.id,ConstraintSet.BOTTOM,binding.bottomGuide.id,ConstraintSet.BOTTOM)
        constraintSetItemLookup.connect(binding.lookupContainerView.id, ConstraintSet.TOP, binding.divider.id, ConstraintSet.BOTTOM)
        constraintSetItemLookup.setMargin(binding.lookupContainerView.id,ConstraintSet.TOP,resources.getDimensionPixelSize(R.dimen.activity_vertical_margin))

        childFragmentManager.commit {
            binding.binLookupButton.isSelected = true
            binding.itemLookupButton.isSelected = false
            setReorderingAllowed(true)
            add<BinLookupFragment>(R.id.lookup_container_view)
            constraintSetBinLookup.applyTo(binding.root)
        }

        binding.binLookupButton.setOnClickListener {
            binding.binLookupButton.isSelected = true
            binding.itemLookupButton.isSelected = false
            childFragmentManager.commit {
                setReorderingAllowed(true)
                replace<BinLookupFragment>(R.id.lookup_container_view)
            }
            constraintSetBinLookup.applyTo(binding.root)
        }

        binding.itemLookupButton.setOnClickListener {
            binding.binLookupButton.isSelected = false
            binding.itemLookupButton.isSelected = true
            childFragmentManager.commit {
                setReorderingAllowed(true)
                replace<ItemLookupFragment>(R.id.lookup_container_view)
            }
            constraintSetItemLookup.applyTo(binding.root)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}