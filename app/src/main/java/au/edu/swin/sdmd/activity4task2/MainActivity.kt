package au.edu.swin.sdmd.activity4task2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView



class MainActivity : AppCompatActivity() {

    companion object{
        private const val KEY_IMAGE = "IMAGE"
    }

    var state = R.drawable.ic_baseline_assignment_turned_in_24

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView = findViewById<ImageView>(R.id.imageView)

        savedInstanceState?.let {
            state = it.getInt(KEY_IMAGE)
            imageView.setImageDrawable(getDrawable(state))
        }

        imageView.setOnClickListener{
            state = when(state){
                R.drawable.ic_baseline_assignment_turned_in_24 -> R.drawable.ic_baseline_assignment_late_24
                R.drawable.ic_baseline_assignment_late_24 -> R.drawable.ic_baseline_assignment_turned_in_24
                else -> R.drawable.ic_baseline_assignment_turned_in_24
            }
            imageView.setImageDrawable(getDrawable(state))
        }
        imageView.setOnLongClickListener{
            state = when(state){
                R.drawable.ic_baseline_assignment_turned_in_24 -> R.drawable.ic_baseline_assignment_late_24
                R.drawable.ic_baseline_assignment_late_24 -> R.drawable.ic_baseline_assignment_turned_in_24
                else -> R.drawable.ic_baseline_assignment_turned_in_24
            }
            imageView.setImageDrawable(getDrawable(state))
            false
        }
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_IMAGE, state)
    }
}