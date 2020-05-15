package com.malba.intentlearn

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnJustMove: Button
    private lateinit var btnMoveWithData: Button
    private lateinit var btnDialANumber: Button
    private lateinit var edtUsername: EditText
    private lateinit var edtPostalCode: EditText
    private lateinit var edtDialNumber: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnJustMove = findViewById(R.id.btn_just_move)
        btnMoveWithData = findViewById(R.id.btn_move_with_data)
        btnDialANumber = findViewById(R.id.btn_dial_a_number)
        edtUsername = findViewById(R.id.edt_username)
        edtPostalCode = findViewById(R.id.edt_postal_code)
        edtDialNumber = findViewById(R.id.edt_dial_number)

        btnJustMove.setOnClickListener(this)
        btnMoveWithData.setOnClickListener(this)
        btnDialANumber.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_just_move ->{
                val moveIntent = Intent(this@MainActivity, JustMoveActivity::class.java)
                startActivity(moveIntent)
            }
            R.id.btn_move_with_data ->{
                val moveIntent = Intent(this@MainActivity, MoveWithDataActivity::class.java)
                moveIntent.putExtra(MoveWithDataActivity.EXTRA_USERNAME, edtUsername.text.toString())
                moveIntent.putExtra(MoveWithDataActivity.EXTRA_POSTAL_CODE, edtPostalCode.text.toString())
                startActivity(moveIntent)
            }
            R.id.btn_dial_a_number ->{
                val moveIntent = Intent(Intent.ACTION_CALL, Uri.parse("tel:${edtDialNumber.text}"))

                if (ActivityCompat.checkSelfPermission(
                        this,
                        Manifest.permission.CALL_PHONE
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return
                }
                startActivity(moveIntent)
            }
        }
    }
}
