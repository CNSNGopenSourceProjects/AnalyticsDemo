package br.com.conseng.analyticsdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class Main2Activity : AppCompatActivity() {

    /**
     * Identifica o estado desta atividade no log.
     */
    private val STATE_TAG2 = "Activity 2"

    /**
     * Nome da tela a ser utilizado nos Hit do rastreio.
     */
    private val SCREEN_NAME = "Tela Secundária"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        printCurrentState("onCreate")
    }

    override fun onStart() {
        super.onStart()
        printCurrentState("onStart")
    }

    override fun onResume() {
        super.onResume()
        printCurrentState("onResume")
    }

    override fun onPause() {
        super.onPause()
        printCurrentState("onPause")
    }

    override fun onStop() {
        super.onStop()
        printCurrentState("onStop")
    }

    override fun onRestart() {
        super.onRestart()
        printCurrentState("onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        printCurrentState("onDestroy")
    }

    private fun printCurrentState(estado:String) {
        Log.d(STATE_TAG2, "state=$estado")
//        println("$STATE_TAG2 : state=$estado")
    }
}
