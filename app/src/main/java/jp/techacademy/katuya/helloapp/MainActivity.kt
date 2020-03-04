package jp.techacademy.katuya.helloapp

import android.app.TimePickerDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.sql.Time


class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.button1 -> showTimePickerDialog()
        }
    }

    private fun showTimePickerDialog() {
        val timePickerDialog = TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener { view, hour, minute ->
              Log.d("UI_PARTS", "$hour:$minute")
                if (hour >= 2 && hour < 10) {
                textView.text = "おはよう"
            } else if (hour >= 10 && hour < 18) {
                textView.text = "こんにちは"
            } else if (hour >= 18 || hour < 2) {
                textView.text = "こんばんは"
            }
            },
            13, 0, true
        )

        timePickerDialog.show()

    }
}