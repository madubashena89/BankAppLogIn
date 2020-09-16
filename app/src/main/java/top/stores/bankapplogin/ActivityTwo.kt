package top.stores.bankapplogin

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlin.math.log

class ActivityTwo : AppCompatActivity() {

    private lateinit var logoutbtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two)

        logoutbtn = findViewById(R.id.btn_logout)
        logoutbtn.setOnClickListener {
            val preferences = getSharedPreferences("Prefs", Context.MODE_PRIVATE)
            val editor = preferences.edit()
            editor.clear()
            editor.apply()
            Toast.makeText(this, "Logout Success", Toast.LENGTH_LONG).show()
            finish()
        }

        Toast.makeText(this, "Login Success", Toast.LENGTH_LONG).show()
    }
}