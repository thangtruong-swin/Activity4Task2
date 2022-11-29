package au.edu.swin.sdmd.activity4task2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel

class MainActivity : AppCompatActivity() {

    val imageViewModel: ImageViewModel by viewModels()

    companion object{
        private const val KEY_IMAGE = "IMAGE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView = findViewById<ImageView>(R.id.imageView)
        imageView.setImageDrawable(getDrawable(imageViewModel.state))

//        savedInstanceState?.let {
//            state = it.getInt(KEY_IMAGE)
//            imageView.setImageDrawable(getDrawable(state))
//        }

        imageView.setOnClickListener{
//            state = when(state){
//                R.drawable.ic_baseline_assignment_turned_in_24 -> R.drawable.ic_baseline_assignment_late_24
//                R.drawable.ic_baseline_assignment_late_24 -> R.drawable.ic_baseline_assignment_turned_in_24
//                else -> R.drawable.ic_baseline_assignment_turned_in_24
//            }
            imageViewModel.nextImage()
            imageView.setImageDrawable(getDrawable(imageViewModel.state))
        }
        imageView.setOnLongClickListener{
//            Update the image state
            imageViewModel.nextImage()
            imageView.setImageDrawable(getDrawable(imageViewModel.state))
            false
        }
    }
//    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//        outState.putInt(KEY_IMAGE, state)
//    }
}

class ImageViewModel: ViewModel() {
//    this keeps track of the current image
    var state = R.drawable.ic_baseline_assignment_turned_in_24

    fun nextImage(){
        state = when(state){
            R.drawable.ic_baseline_assignment_turned_in_24 -> R.drawable.ic_baseline_assignment_late_24
            R.drawable.ic_baseline_assignment_late_24 -> R.drawable.ic_baseline_assignment_returned_24
            R.drawable.ic_baseline_assignment_returned_24 -> R.drawable.ic_baseline_assignment_turned_in_24
            else -> R.drawable.ic_baseline_assignment_turned_in_24
        }
    }
}