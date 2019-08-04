package io.github.maikotrindade.animationsamples.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import io.github.maikotrindade.animationsamples.R
import kotlinx.coroutines.*
import java.util.concurrent.TimeUnit

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val randomEnterAnim = getRandomEnterAnim()
        val randomExitAnim = getRandomExitAnim()
        showAnimations(randomEnterAnim, randomExitAnim)

        //Show splash screen and choose a transition animation randomly
        //Never delay your activity
        CoroutineScope(Dispatchers.IO).launch {
            delay(TimeUnit.MILLISECONDS.toMillis(700))
            withContext(Dispatchers.Main) {
                val intent = Intent(this@SplashActivity, HomeActivity::class.java)
                startActivity(intent)
                overridePendingTransition(randomEnterAnim, randomExitAnim)
            }
        }
    }

    private fun getRandomEnterAnim() = listOf(
        R.anim.blink,
        R.anim.bounce,
        R.anim.fade_in,
        R.anim.slide_up,
        R.anim.zoom_out,
        R.anim.rotate
    ).random()


    private fun getRandomExitAnim() = listOf(
        R.anim.blink,
        R.anim.fade_out,
        R.anim.slide_up,
        R.anim.slide_left,
        R.anim.slide_down,
        R.anim.zoom_in
    ).random()

    private fun showAnimations(resourceIdEnter: Int, resourceIdExit: Int) {
        val resourceEnterName = resources.getResourceEntryName(resourceIdEnter)
        val resourceExitName = resources.getResourceEntryName(resourceIdExit)
        val message = "Random Animations: Enter: $resourceEnterName | Exit: $resourceExitName"
        Toast.makeText(this, "Enter: $resourceEnterName | Exit: $resourceExitName", Toast.LENGTH_LONG).show()
        Log.d(SplashActivity::class.java.simpleName, message)
    }
}
