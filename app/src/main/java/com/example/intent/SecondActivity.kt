package com.example.intent

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        //Retrieve the extra value
        val message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE)
        val lucky = intent.getIntExtra(MainActivity.EXTRA_LUCKY,0)

        textViewMessage.text = String.format("%s %s", getString(R.string.message), message)
        textViewLucky.text = String.format("%s %s", getString(R.string.lucky_number), lucky)

        buttonDone.setOnClickListener{
            val intent = getIntent()

            if(!editTextLucky.text.isEmpty()){
                val reply = editTextReply.text.toString()
                intent.putExtra(MainActivity.EXTRA_LUCKY, reply)
                setResult(Activity.RESULT_OK, intent)
            }else{
                setResult(Activity.RESULT_CANCELED)  //cancel already. no need intent anymore
            }
            //terminate the Activity
            finish()
        }
    }
}
