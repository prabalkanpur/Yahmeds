package com.yahmeds.healthcare.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.yahmeds.healthcare.R
import com.yahmeds.healthcare.dataclass.HospitalListModel
import de.hdodenhof.circleimageview.CircleImageView

class HospitalListAdapter(private val mList: List<HospitalListModel>) : RecyclerView.Adapter<HospitalListAdapter.ViewHolder>() {


    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.hospital_list_adapter, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList[position]

        // sets the image to the imageview from our itemHolder class
        holder.imageView.setImageResource(ItemsViewModel.image)

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
    }
}