package com.padcmyanmar.mm_healthcare_kotlin_assignment_pkk.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import com.padcmyanmar.mm_healthcare_kotlin_assignment_pkk.R
import com.padcmyanmar.mm_healthcare_kotlin_assignment_pkk.adapters.HealthCareAdapter
import com.padcmyanmar.mm_healthcare_kotlin_assignment_pkk.data.models.HealthCareModel
import com.padcmyanmar.mm_healthcare_kotlin_assignment_pkk.data.vos.HealthCareInfoVO
import com.padcmyanmar.mm_healthcare_kotlin_assignment_pkk.delegates.HealthCareDelegate
import com.padcmyanmar.mm_healthcare_kotlin_assignment_pkk.events.DataEvent
import com.padcmyanmar.mm_healthcare_kotlin_assignment_pkk.events.ErrorEvent
import kotlinx.android.synthetic.main.activity_main.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class MainActivity : AppCompatActivity(),HealthCareDelegate{

    private var healthCareAdapter:HealthCareAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvHealthCareInfos.layoutManager=LinearLayoutManager(applicationContext)
        healthCareAdapter=HealthCareAdapter(applicationContext,this)
        rvHealthCareInfos.adapter=healthCareAdapter

        swipeRefreshLayout!!.isRefreshing=true
        HealthCareModel.getInstance().loadHealthCareInfos()

        swipeRefreshLayout!!.setOnRefreshListener {
            HealthCareModel.getInstance().loadHealthCareInfos()
        }
    }

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

    /**
     * Tap View and Change another Form
     */
    override fun onTapView() {

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onHealthCareInfosLoadedEvent(healthCareInfosLoadedEvent: DataEvent.HealthCareInfosLoadedEvent){
        healthCareAdapter!!.setNewData(healthCareInfosLoadedEvent.mHealthCareInfos as MutableList<HealthCareInfoVO>)
        swipeRefreshLayout!!.isRefreshing=false
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onErrorEvent(errorEvent: ErrorEvent.ApiErrorEvent){
        Snackbar.make(relativeLayout, errorEvent.getMsg()!!,Snackbar.LENGTH_INDEFINITE)
        swipeRefreshLayout!!.isRefreshing=false
    }


}
