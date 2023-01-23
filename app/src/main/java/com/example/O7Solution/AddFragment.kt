package com.example.O7Solution

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.O7Solution.data.User
import com.example.O7Solution.data.UserViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AddFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddFragment : Fragment() {
    lateinit var muserViewModel: UserViewModel
    lateinit var etfirstname:EditText
    lateinit var etlastname:EditText
    lateinit var etage:EditText
    lateinit var btnAdd: Button
    private var param1: String? = null
    private var param2: String? = null

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
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_add, container, false)
        etfirstname=view.findViewById(R.id.etFirstName)
        etlastname=view.findViewById(R.id.etLastName)
        etage=view.findViewById(R.id.etAge)
        btnAdd=view.findViewById(R.id.btnAdd)
        muserViewModel=ViewModelProvider(this).get(UserViewModel::class.java)
        btnAdd.setOnClickListener{
            inseartDatatoDatabase()
        }
        return view
    }

    private fun inseartDatatoDatabase() {
        val firstname=etfirstname.text.toString()
        val lastname=etlastname.text.toString()
        val age=etage.text

        if (inpucheck(firstname,lastname,age)) {
            val user = User(0, firstname, lastname, Integer.parseInt(age.toString()))

            muserViewModel.addUser(user)
            Toast.makeText(requireContext(),"Successfully Added",Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }else{
            Toast.makeText(requireContext(),"Please fill out all field",Toast.LENGTH_SHORT).show()
        }
    }

    private fun inpucheck(firstname: String, lastname: String, age: Editable?): Boolean {

            return !(TextUtils.isEmpty(firstname)&& TextUtils.isEmpty(lastname)&& TextUtils.isEmpty(age))
        }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AddFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AddFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}