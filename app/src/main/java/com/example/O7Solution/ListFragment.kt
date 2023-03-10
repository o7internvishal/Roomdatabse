package com.example.O7Solution

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.O7Solution.Adapter.UserAdapter
import com.example.O7Solution.data.User
import com.example.O7Solution.data.UserViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListFragment : Fragment(),ClickedInterface {
    lateinit var button: FloatingActionButton
    lateinit var recyclerView: RecyclerView
    lateinit var imgAdd: ImageButton
    lateinit var btnDelete: Button
    lateinit var btnUpdate:Button
    private var param1: String? = null
    private var param2: String? = null
    lateinit var userAdapter: UserAdapter
    lateinit var muserViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        muserViewModel= ViewModelProvider(this).get(UserViewModel::class.java)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        button = view.findViewById(R.id.floatingActionButton)
        recyclerView = view.findViewById(R.id.recyclerView)
         userAdapter = UserAdapter(this)
        recyclerView.adapter = userAdapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        muserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        muserViewModel.readAllData.observe(viewLifecycleOwner, Observer { user ->
            userAdapter.setData(user)
//
        })

        button.setOnClickListener {

            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }
        return view
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ListFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun deleteClicked(user: User) {
        muserViewModel.deleteuser(user)
    }

    override fun updateClicked(user: User) {
        val bundle= bundleOf("id" to user.id.toString(),"name" to user.firstname.toString(),
        "lname" to user.lastname.toString(),"age" to user.age.toString())



        muserViewModel.updateUser(user)

        findNavController().navigate(R.id.action_listFragment_to_addFragment, bundle)

    }
}