package com.project.draftapplicationdi.view.activity

import com.project.draftapplicationdi.MainApplication
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.project.draftapplicationdi.R
import com.project.draftapplicationdi.model.Technology
import com.project.draftapplicationdi.presenter.XanoPresenter
import javax.inject.Inject

class MainActivity : AppCompatActivity(), XanoPresenter.View {

    @Inject
    lateinit var presenter: XanoPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as MainApplication).component.inject(this@MainActivity)

        presenter.injectView(this)
    }

    override fun onResume() {
        super.onResume()
        presenter.getXanoData()
    }

    override fun showData(technologiesList: List<Technology>) {
        var text = StringBuilder()
        for (technology in technologiesList) {
            text = text.append("ID: " + technology.id.toString()).append(", ").append(technology.name)
            text.appendLine()
        }
        findViewById<TextView>(R.id.tech_text_view).text = text
    }
}