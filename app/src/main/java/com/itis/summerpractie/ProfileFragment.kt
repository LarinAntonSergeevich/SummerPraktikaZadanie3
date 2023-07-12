package com.itis.summerpractie

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.itis.summerpractie.databinding.FragmentProfileBinding
import com.itis.summerpractie.utils.showSnackbar
import kotlin.random.Random

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private var binding: FragmentProfileBinding? = null
    private var adapter: CityAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProfileBinding.bind(view)

        val name = arguments?.getString(ARG_NAME)
        Log.e("ProfileFragment", name.orEmpty())

        val pref: SharedPreferences = requireContext().getSharedPreferences("Default", MODE_PRIVATE)

        requireContext().getColor(R.color.accent)

        initAdapter()

        binding?.tvTitle?.setOnClickListener {
            adapter?.updateDataset(
                CityRepository.list.subList(0, Random.nextInt(8))
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun initAdapter() {
        adapter = CityAdapter(
            list = CityRepository.list,
            glide = Glide.with(this),
            onItemClick = { city ->
                binding?.root?.showSnackbar(city.name)
            }
        )
        binding?.rvCity?.adapter = adapter
        binding?.rvCity?.layoutManager = GridLayoutManager(requireContext(), 2)
    }

    companion object {

        private const val ARG_NAME = "ARG_NAME"
        private const val ARG_AGE = "ARG_AGE"

        fun createBundle(name: String, age: Int): Bundle {
            val bundle = Bundle()
            bundle.putString(ARG_NAME, name)
            bundle.putInt(ARG_AGE, age)
            return bundle
        }
    }
}
