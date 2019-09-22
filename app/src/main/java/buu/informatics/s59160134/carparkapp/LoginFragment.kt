package buu.informatics.s59160134.carparkapp


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.*
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import buu.informatics.s59160134.carparkapp.databinding.FragmentLoginBinding
import kotlinx.android.synthetic.main.fragment_login.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class LoginFragment : Fragment() {
    private val username = "admin"
    private val password = "1234"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentLoginBinding>(inflater,R.layout.fragment_login,container,false)
        binding.errorText.visibility = View.GONE
        binding.loginButton.setOnClickListener { view : View ->
            val usernameInput = username_input.text.toString()
            val passwordInput = password_input.text.toString()
            if(verifyLogin(usernameInput,passwordInput)){
                view.findNavController().navigate(R.id.action_loginFragment_to_carParkFragment)
            }else{
                error_text.visibility = View.VISIBLE
                Toast.makeText(activity, "username is : $username , password is : $password", Toast.LENGTH_LONG).show()
            }

        }
        return binding.root
    }
    private fun verifyLogin(usernameInput:String,passwordInput:String):Boolean{
        return usernameInput == username && passwordInput == password
    }



}
