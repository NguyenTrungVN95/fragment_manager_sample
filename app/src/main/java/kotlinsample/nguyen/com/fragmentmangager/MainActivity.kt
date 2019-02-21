package kotlinsample.nguyen.com.fragmentmangager

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.content.Intent
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(),Fragment1.SentData {
    override fun getData(value: String) {
        txt.setText(value)
    }

    private val arrFragment=ArrayList<Fragment>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent = intent
        val data = intent.data
//        Log.d("D<MMM",data.toString())

        initFragment()
    }

    private fun initFragment() {
        arrFragment.add(Fragment1())
        arrFragment.add(Fragment2())
        arrFragment.add(Fragment3())

        val  transition=supportFragmentManager.beginTransaction()
        for(fragment in arrFragment){
            transition.add(R.id.fragment,fragment)
        }
        transition.commit()
        showFragment(1)

    }

    private fun showFragment(possition:Int){
        val transition=supportFragmentManager.beginTransaction()
        for((indext,fragment) in arrFragment.withIndex()){
            if(indext==possition){
                transition.show(fragment)
            }else{
                transition.hide(fragment)
            }
        }
        transition.commit()

    }
}
