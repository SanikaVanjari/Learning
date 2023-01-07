package com.app.learning.animation

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.app.learning.databinding.ActivityAnimationMainBinding

class AnimationMainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAnimationMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimationMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //TODO: Animated bitmaps - AVD preview for icons , example pause and play
        //TODO: Property Animation - for moving or displaying views on current page
        //TODO: Physics based Motion - Fling and Spring animation
        //TODO: Transition Animation for Navigation

        binding.moveBt.setOnClickListener {
//            move(binding.textView)
//            moveWithObjectAnimator(binding.textView)
            moveAndFade(binding.textView)
        }

        /**
         *  Property Animation has 5 parameters to define:
         *  1. Duration of animation, default:300ms
         *  2. Time interpolation - You can specify how the values for the property are calculated as a function of the animation's current elapsed time.
         *  3. Repeat Count and behaviour - how many times to repeat and how to repeat
         *  4. Animation set - You can group animations into logical sets that play together or sequentially or after specified delays.
         *  5. Frame refresh delay: how often to refresh frames of your animation. default is 10ms, but depends on system workload and performance.
         *  Types: ValueAnimator, ObjectAnimator, AnimatorSet
         *  */


    }

    fun move(view: TextView) {
        val va = ValueAnimator.ofFloat(0f, 300f)
        va.duration = 3000 //in millis
        va.addUpdateListener { animation -> view.translationX = animation.animatedValue as Float }
        va.repeatCount = 5
        va.start()
    }

    fun moveWithObjectAnimator(view: TextView) {
        ObjectAnimator.ofFloat(view, "translationX", 300f).apply {
            duration = 1000
            start()
        }
    }

    fun moveAndFade(view: TextView) {
        val fadeAnim = ObjectAnimator.ofFloat(view, "alpha", 1f, 0f).apply {
            duration = 250
        }
        val showAnim = ObjectAnimator.ofFloat(view, "alpha", 0f, 1f).apply {
            duration = 250
        }
        val move = ObjectAnimator.ofFloat(view, "translationX", 300f).apply {
            duration = 500
            start()
        }

        AnimatorSet().apply {
            play(move).with(fadeAnim).before(showAnim)
            start()
        }
    }
}