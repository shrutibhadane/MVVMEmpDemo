package ladd.marshall.androidmvvmexample.view.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
//import kotlinx.android.synthetic.main.detail_fragment.*
import ladd.marshall.androidmvvmexample.R
import ladd.marshall.androidmvvmexample.databinding.DetailFragmentBinding
import ladd.marshall.androidmvvmexample.databinding.SearchFragmentBinding
import ladd.marshall.androidmvvmexample.utils.EMPLOYEE_ID
import ladd.marshall.androidmvvmexample.viewModel.viewModels.DetailViewModel

class DetailFragment : Fragment(R.layout.detail_fragment) {
    private lateinit var binding: DetailFragmentBinding
    private val viewModel by viewModels<DetailViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DetailFragmentBinding.bind(view)
        // Retrieves the bundle passed to it from the previous Fragment and checks if it is null
        arguments?.let { bundle ->
            // If not null, get the data passed to it, using the constant, and observe the LiveData
            viewModel.employeeLiveData(bundle.getInt(EMPLOYEE_ID)).observe(viewLifecycleOwner) { employeeOrNull ->
                // Check if the result of the search is null or not
                employeeOrNull?.let { employee ->
                    // if not null, update the UI with the update data
                    binding.textViewName.text = employee.employeeName
                    binding.textViewId.text = "ID: "+employee.id.toString()
                    binding.textViewAge.text = "Age: "+employee.employeeAge.toString()
                    binding.textViewImageLink.text = employee.profileImage
                    binding.textViewSalary.text = "Salary: "+employee.employeeSalary.toString()


                }   
            }
        }
    }
}
