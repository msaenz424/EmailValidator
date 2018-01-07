package com.migcavero.emailvalidator

import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class MainActivityUI : AnkoComponent<MainActivity>{

    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {

        verticalLayout{
            val email = editText()
            button("Verify Email"){
                onClick {  }
            }
        }
    }
}