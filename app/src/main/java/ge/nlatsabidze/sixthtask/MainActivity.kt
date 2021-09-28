package ge.nlatsabidze.sixthtask

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import ge.nlatsabidze.sixthtask.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val changeProfileId = binding.btnProfile

        val result = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val name = result.data!!.getStringExtra("newName")
                val surname = result.data!!.getStringExtra("newSurname")
                val email = result.data!!.getStringExtra("newEmail")
                val year = result.data!!.getStringExtra("newYear")
                val gender = result.data!!.getStringExtra("newGender")
                binding.txtName.text = name
                binding.txtSurname.text = surname
                binding.txtEmail.text = email
                binding.txtYear.text = year
                binding.txtGender.text = gender
            }
        }

        changeProfileId.setOnClickListener {
            val intent = Intent(this, InfoActivity::class.java)
            result.launch(intent)
        }

    }
}