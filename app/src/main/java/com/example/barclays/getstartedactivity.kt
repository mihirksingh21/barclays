package com.example.barclays
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
class getstartedactivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_getstartedactivity)
        // Get a reference to the button
        val button = findViewById<Button>(R.id.button)
        // Set an OnClickListener on the button
        button.setOnClickListener {
            // Create a new Intent object for the target activity
            val intent = Intent(this, loginactivity::class.java)
            // Launch the target activity
            startActivity(intent)
        }
    }
}