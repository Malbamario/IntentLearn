package com.malba.intentlearn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MoveWithDataActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_USERNAME = "extra_username"
        const val EXTRA_POSTAL_CODE = "extra_postal_code"
    }

    private lateinit var tvUsername: TextView
    private lateinit var tvPostalCode: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_data)

        tvUsername = findViewById(R.id.tv_username)
        tvPostalCode = findViewById(R.id.tv_postal_code)

        tvUsername.text = intent.getStringExtra(EXTRA_USERNAME)
        tvPostalCode.text = intent.getStringExtra(EXTRA_POSTAL_CODE)
    }
}
