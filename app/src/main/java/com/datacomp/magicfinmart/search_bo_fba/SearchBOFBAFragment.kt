package com.datacomp.magicfinmart.search_bo_fba


import android.os.Bundle
import android.support.design.widget.BottomSheetDialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.datacomp.magicfinmart.R
import kotlinx.android.synthetic.main.fragment_search_bofba.*


class SearchBOFBAFragment() : BottomSheetDialogFragment() {

    var iboFbaCallback: IBOFbaCallback? = null

    companion object {
        fun newInstance(iboFbaCallback: IBOFbaCallback): SearchBOFBAFragment =
                SearchBOFBAFragment().apply {
                    this.iboFbaCallback = iboFbaCallback
                }

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_search_bofba, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imgSearch.setOnClickListener {
            iboFbaCallback?.getBOFBA()
        }
    }


}
