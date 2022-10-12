package com.example.jaldiapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var deliveryAddress : EditText
    private lateinit var deliveryAddressOpt : EditText
    private lateinit var city : EditText
    private lateinit var state : EditText
    private lateinit var zipCode : EditText
    private lateinit var confirmButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var isAllFieldsChecked = false

            confirmButton = findViewById(R.id.btnConfirm)

            // register all the EditText fields with their IDs.
            deliveryAddress = findViewById(R.id.etDeliveryAddress)
            deliveryAddressOpt = findViewById(R.id.etDeliveryAddressOpt)
            city = findViewById(R.id.etCity)
            state = findViewById(R.id.etState)
            zipCode = findViewById(R.id.etZipcode)

            // handle the confirm button
            confirmButton.setOnClickListener {

                    // store the returned value of the dedicated function which checks
                    // whether the entered data is valid or if any fields are left blank.
                    isAllFieldsChecked = CheckAllFields()

                    // the boolean variable turns to be true then
                    // only the user must be proceed to the activity2
                    if (isAllFieldsChecked) {

                        Toast.makeText(this,"Confirmed Address", Toast.LENGTH_SHORT).show()
                }
            }

        }


    /* function which checks all the text fields
     are filled or not by the user.
     when user clicks on the PROCEED button
     this function is triggered. */
    private fun CheckAllFields(): Boolean {
        if (deliveryAddress!!.length() == 0) {
            deliveryAddress!!.error = "Delivery address is required"
            return false
        }
        if (city!!.length() == 0) {
            city!!.error = "City is required"
            return false
        }
        if (state!!.length() == 0) {
            state!!.error = "State is required"
            return false
        } else if (zipCode!!.length() < 6) {
            zipCode!!.error = "Zipcode is required and must be 6 digit"
            return false
        }
        // after all validation return true.
        return true
    }
}