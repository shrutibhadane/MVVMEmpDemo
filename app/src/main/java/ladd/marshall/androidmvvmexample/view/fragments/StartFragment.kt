package ladd.marshall.androidmvvmexample.view.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ladd.marshall.androidmvvmexample.databinding.StartFragmentBinding
import ladd.marshall.androidmvvmexample.R

/**
 * This is the first Fragment that is loaded by the NavController.  It implements a simple
 * navigation using the Navigation component.
 */
class StartFragment : Fragment(R.layout.start_fragment) {
    private lateinit var binding: StartFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize the binding object
        binding = StartFragmentBinding.bind(view)

        // Now you can access views using the binding object
        binding.buttonAllEmployees.setOnClickListener { findNavController().navigate(R.id.action_startFragment_to_listFragment) }
        binding.buttonEmployeeSearch.setOnClickListener { findNavController().navigate(R.id.action_startFragment_to_searchFragment) }
    }
}
