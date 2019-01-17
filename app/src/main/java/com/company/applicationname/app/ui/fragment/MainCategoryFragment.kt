package com.company.applicationname.app.ui.fragment

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.company.applicationname.app.di.DaggerViewModelFactory
import com.company.applicationname.app.domain.Category
import com.company.applicationname.app.repo.CategoryRepository
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class CategoryFragment : androidx.fragment.app.Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listenerCategory: OnCategoryFragmentInteractionListener? = null

    private  var allCategories = ArrayList<Category>()


    @Inject
    lateinit var categoryRepository: CategoryRepository
    private lateinit var categoryFragmentView: View
    private lateinit var categoryRecycleView: RecyclerView
    @Inject
    lateinit var daggerViewModelFactory: DaggerViewModelFactory


    init {

        allCategories.add(Category(100000, "Getränke", "a7a7a7", 100000, 100000))
        allCategories.add(Category(200000, "Lebensmittel / Nährstoffe", "f3ad87", 100000, 100000))
        allCategories.add(Category(300000, "Obst & Gemüse", "a2d99b", 100000, 100000))
        allCategories.add(Category(400000, "Frischetheke / Kühlregal", "8bcbe3", 100000, 100000))
        allCategories.add(Category(500000, "Tiefkühlware", "6a89b9", 100000, 100000))
        allCategories.add(Category(600000, "Haushalt & Kosmetik", "e2ec83", 100000, 100000))
        allCategories.add(Category(700000, "Sonstiges", "e689a6", 100000, 100000))
        allCategories.add(Category(800000, "800000", "e689a6", 100000, 100000))
        allCategories.add(Category(100000, "Getränke", "a7a7a7", 100000, 100000))
        allCategories.add(Category(200000, "Lebensmittel / Nährstoffe", "f3ad87", 100000, 100000))
        allCategories.add(Category(300000, "Obst & Gemüse", "a2d99b", 100000, 100000))
        allCategories.add(Category(400000, "Frischetheke / Kühlregal", "8bcbe3", 100000, 100000))
        allCategories.add(Category(500000, "Tiefkühlware", "6a89b9", 100000, 100000))
        allCategories.add(Category(600000, "Haushalt & Kosmetik", "e2ec83", 100000, 100000))
        allCategories.add(Category(700000, "Sonstiges", "e689a6", 100000, 100000))
        allCategories.add(Category(800000, "800000", "e689a6", 100000, 100000))
        allCategories.add(Category(100000, "Getränke", "a7a7a7", 100000, 100000))
        allCategories.add(Category(200000, "Lebensmittel / Nährstoffe", "f3ad87", 100000, 100000))
        allCategories.add(Category(300000, "Obst & Gemüse", "a2d99b", 100000, 100000))
        allCategories.add(Category(400000, "Frischetheke / Kühlregal", "8bcbe3", 100000, 100000))
        allCategories.add(Category(500000, "Tiefkühlware", "6a89b9", 100000, 100000))
        allCategories.add(Category(600000, "Haushalt & Kosmetik", "e2ec83", 100000, 100000))
        allCategories.add(Category(700000, "Sonstiges", "e689a6", 100000, 100000))
        allCategories.add(Category(800000, "800000", "e689a6", 100000, 100000))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        AndroidSupportInjection.inject(this)
        initializeRecycler()
        return categoryFragmentView

    }


    private fun initializeRecycler() {
         val mLayoutManager: LinearLayoutManager
        mLayoutManager = LinearLayoutManager(activity)
        mLayoutManager.orientation = RecyclerView.HORIZONTAL

        categoryRecycleView.apply {
            setHasFixedSize(true)
            layoutManager = mLayoutManager
        }

        categoryRecycleView.smoothScrollToPosition(13)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnCategoryFragmentInteractionListener) {
            listenerCategory = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnCategoryFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listenerCategory = null
    }



    interface OnCategoryFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CategoryFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

}
