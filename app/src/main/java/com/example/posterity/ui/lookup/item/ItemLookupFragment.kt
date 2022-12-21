package com.example.posterity.ui.lookup.item

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.SearchView
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.posterity.R
import com.example.posterity.data.Bin
import com.example.posterity.databinding.FragmentItemLookupBinding
import com.example.posterity.ui.lookup.bin.getBinIcon
import com.example.posterity.ui.lookup.bin.getBinName

class ItemLookupFragment : Fragment() {
    private var _binding: FragmentItemLookupBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentItemLookupBinding.inflate(inflater, container, false)
        val itemLookupViewModel: ItemLookupViewModel by viewModels()

        // Display bin badges
        Bin.values().forEach { bin ->
            val viewToAdd = inflater.inflate(R.layout.bin_badge, binding.itemBadges, false)
            val badgeTextView = viewToAdd.findViewById<TextView>(R.id.name)
            val badgeIconImageView = viewToAdd.findViewById<ImageView>(R.id.icon)

            badgeTextView.text = getBinName(bin, resources)

            badgeIconImageView.setImageDrawable(ResourcesCompat.getDrawable(resources, getBinIcon(bin), null))
            binding.itemBadges.addView(viewToAdd)
        }

        val adapter = ItemAdapter(itemLookupViewModel.fullItemList)
        binding.itemRecyclerView.adapter = adapter

        binding.itemSearchView.setOnQueryTextListener ( object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                Log.d("ItemLookupFragment","onQueryTextSubmit")
                return false
            }

            override fun onQueryTextChange(filter: String?): Boolean {
                val newList = filter?.let{ itemLookupViewModel.fullItemList.filter { item -> item.name.lowercase().contains(it.lowercase()) }}
                newList?.run{adapter.setItemList(newList)}
                return false
            }
        })

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}