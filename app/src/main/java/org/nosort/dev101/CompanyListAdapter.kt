package org.nosort.dev101

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CompanyListAdapter : RecyclerView.Adapter<CompanyListAdapter.CompanyViewHolder>() {
    private val companyList = ArrayList<Company>()

    init {
        companyList.clear()
        createData()
    }

    private fun createData() {
        companyList.add(Company("Company Name One", "From April2017 to Now"))
        companyList.add(Company("Company Name Two", "From September2015 to January2017"))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            CompanyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.company_list_item, parent, false))

    override fun getItemCount() = companyList.size

    override fun onBindViewHolder(holder: CompanyViewHolder, position: Int) {
        holder.onBind(companyList[position])
    }

    inner class CompanyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val companyNameTV by lazy {
            itemView.findViewById(R.id.companyName) as TextView
        }
        private val durationTV by lazy {
            itemView.findViewById(R.id.workingTime) as TextView
        }

        fun onBind(company: Company) {
            companyNameTV.text = company.companyName
            durationTV.text = company.durationInCompany

        }
    }
}
