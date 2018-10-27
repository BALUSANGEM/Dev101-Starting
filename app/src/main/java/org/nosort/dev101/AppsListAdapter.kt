package org.nosort.dev101

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class AppsListAdapter : RecyclerView.Adapter<AppsListAdapter.AppsViewHolder>() {
    private val appsList = ArrayList<AppInfo>()

    init {
        appsList.clear()
        createData()
    }

    private fun createData() {
        appsList.add(AppInfo("AppOne", R.mipmap.ic_launcher))
        appsList.add(AppInfo("AppTwo", R.mipmap.ic_launcher))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            AppsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.apps_list_item, parent, false))

    override fun getItemCount() = appsList.size

    override fun onBindViewHolder(holder: AppsViewHolder, position: Int) {
        holder.onBind(appsList[position])
    }

    inner class AppsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val appIconIV by lazy {
            itemView.findViewById(R.id.appIcon) as ImageView
        }
        private val appNameTV by lazy {
            itemView.findViewById(R.id.appName) as TextView
        }

        fun onBind(company: AppInfo) {
            appIconIV.setImageResource(company.appIcon)
            appNameTV.text = company.appName

        }
    }
}
