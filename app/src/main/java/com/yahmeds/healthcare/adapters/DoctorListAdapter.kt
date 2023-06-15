package com.yahmeds.healthcare.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.yahmeds.healthcare.R
import com.yahmeds.healthcare.activities.DoctorDetailActivity
import com.yahmeds.healthcare.dataclass.HospitalListModel
import com.yahmeds.healthcare.fragments.DoctorDetailFragment
import com.yahmeds.healthcare.fragments.HospitalFragment
import de.hdodenhof.circleimageview.CircleImageView

class DoctorListAdapter(
    activity: FragmentActivity?,
    private val mList: ArrayList<HospitalListModel>
) :
    RecyclerView.Adapter<DoctorListAdapter.ViewHolder>() {
    val activity = activity

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.doctor_list_adapter, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList[position]

        // sets the image to the imageview from our itemHolder class
        holder.imageView.setImageResource(ItemsViewModel.image)
        holder.linear_doctor_list.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity,DoctorDetailActivity::class.java)
            activity?.startActivity(intent)
        })

        // sets the text to the textview from our itemHolder class
        /* holder.hospitalName.text = ItemsViewModel.text
         holder.hospitalAddress.text = ItemsViewModel.text
         holder.hospitalType.text = ItemsViewModel.text
 */
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: CircleImageView = itemView.findViewById(R.id.hospital_image)
        val hospitalName: TextView = itemView.findViewById(R.id.hospital_name)
        val hospitalType: TextView = itemView.findViewById(R.id.hospital_type)
        val linear_doctor_list:LinearLayout= itemView.findViewById(R.id.linear_doctor_list)
    }

}