package ge.nlatsabidze.sixthtask

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ge.nlatsabidze.sixthtask.databinding.ActivityInfoBinding

class InfoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnProfile.setOnClickListener {
            val data = Intent()
            data.putExtra("newName", binding.editName.text.toString())
            data.putExtra("newSurname", binding.editSurname.text.toString())
            data.putExtra("newEmail", binding.editEmail.text.toString())
            data.putExtra("newYear", binding.editYear.text.toString())
            data.putExtra("newGender", binding.editGender.text.toString())
            setResult(Activity.RESULT_OK, data)
            finish()
        }
    }
}