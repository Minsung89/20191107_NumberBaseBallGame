package com.tjoeum.a20191107_numberbaseballgame.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.tjoeum.a20191107_numberbaseballgame.R
import com.tjoeum.a20191107_numberbaseballgame.datas.ChatData

class ChatAdapter(context: Context, res: Int, list: ArrayList<ChatData>) : ArrayAdapter<ChatData>(context, res, list) {

    var mContext = context
    var mList = list
    var inf = LayoutInflater.from(mContext)

    //생성자
    constructor(context: Context, list: ArrayList<ChatData>) : this(context, R.layout.chat_list_item, list){}


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView

        if (tempRow == null)
            tempRow = inf.inflate(R.layout.chat_list_item, null)

        var row = tempRow!!


        row.findViewById<TextView>(R.id.result).text = mList.get(position).message
//        row.findViewById<TextView>(R.id.myInput).text = mList.get(position).speaker





        return row
    }



}