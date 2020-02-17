package com.example.canteen.ui.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.canteen.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnClient.setOnClickListener {
            val intent = Intent(this, MainClientActivity::class.java)
            startActivity(intent)
        }

        btnWorker.setOnClickListener {
            val intent = Intent(this, MainWorkerActivity::class.java)
            startActivity(intent)
        }
    }
}
