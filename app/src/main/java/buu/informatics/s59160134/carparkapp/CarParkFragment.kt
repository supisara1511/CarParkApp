package buu.informatics.s59160134.carparkapp


import android.graphics.Color
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import buu.informatics.s59160134.carparkapp.databinding.FragmentCarparkBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class CarParkFragment : Fragment() {
    private val car0 = Car(0)
    private val car1 = Car(1)
    private val car2 = Car(2)
    private val cars = arrayOf(car0, car1, car2)
    private var currentIndex = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentCarparkBinding>(inflater,R.layout.fragment_carpark,container,false)
        setHasOptionsMenu(true)
        binding.apply {
            this.cars = this@CarParkFragment.cars
            detailCarPark.visibility = View.GONE
            roomButton1.setOnClickListener { view ->
                clickRoom(view,binding,0)
            }
            roomButton2.setOnClickListener { view ->
                clickRoom(view,binding,1)
            }
            roomButton3.setOnClickListener { view ->
                clickRoom(view,binding,2)
            }
            saveButton.setOnClickListener { view ->
                saveRoom(view,binding)
            }
            delButton.setOnClickListener { view ->
                delRoom(view,binding)
            }
        }
        return binding.root
    }

    private fun clickRoom(view: View,binding: FragmentCarparkBinding,indexCar:Int) {
        binding.detailCarPark.visibility = view.visibility
        currentIndex = indexCar
        binding.car = cars?.get(currentIndex)
        binding.invalidateAll()
    }

    private fun saveRoom(view: View,binding: FragmentCarparkBinding) {
        val car = cars?.get(currentIndex)
        car.empty = false
        binding.invalidateAll()
    }

    private fun delRoom(view: View,binding: FragmentCarparkBinding) {
        val car = cars?.get(currentIndex)
        car.empty = true
        car.name = ""
        car.carId = ""
        car.brand = ""
        binding.invalidateAll()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.option_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!, view!!.findNavController()) || super.onOptionsItemSelected(item)
    }


}
