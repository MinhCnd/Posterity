package com.example.posterity.ui.lookup.item

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import com.example.posterity.data.Item
import com.example.posterity.data.ItemList
import com.example.posterity.databinding.FragmentItemLookupBinding

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
        val fullItemList = ItemList(resources)
        val adapter = ItemAdapter(fullItemList)
        binding.itemRecyclerView.adapter = adapter

        binding.itemSearchView.setOnQueryTextListener ( object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                Log.d("ItemLookupFragment","onQueryTextSubmit")
                return false
            }

            override fun onQueryTextChange(filter: String?): Boolean {
                val newList = filter?.let{ fullItemList.filter { item -> item.name.lowercase().contains(it.lowercase()) }}
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