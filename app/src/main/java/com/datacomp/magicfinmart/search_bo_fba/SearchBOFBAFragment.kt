package com.datacomp.magicfinmart.search_bo_fba


import android.app.ProgressDialog
import android.os.Bundle
import android.support.design.widget.BottomSheetDialogFragment
import android.support.v7.widget.LinearLayoutManager
import android.view.ContextThemeWrapper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.datacomp.magicfinmart.R
import com.datacomp.magicfinmart.utility.Constants
import kotlinx.android.synthetic.main.fragment_search_bofba.*
import magicfinmart.datacomp.com.finmartserviceapi.database.DBPersistanceController
import magicfinmart.datacomp.com.finmartserviceapi.finmart.IResponseSubcriber
import magicfinmart.datacomp.com.finmartserviceapi.finmart.controller.quoteapplication.QuoteApplicationController
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.BOFbaEntity
import magicfinmart.datacomp.com.finmartserviceapi.finmart.response.BOFbaListResponse


class SearchBOFBAFragment() : BottomSheetDialogFragment(), IResponseSubcriber, IBOFbaCallback, View.OnClickListener {

    var iboFbaCallback: IBOFbaCallback? = null
    internal var dialog: ProgressDialog? = null

    var mAdapter: FBASearchAdapter? = null
    var mList = mutableListOf<BOFbaEntity>()

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

        rvFBAList.layoutManager = LinearLayoutManager(activity)

        var boFbaEntity = BOFbaEntity()
        boFbaEntity.fullName = "Self"
        mList.add(0, boFbaEntity)
        mAdapter = FBASearchAdapter(mList, this, activity)
        rvFBAList.adapter = mAdapter
        imgSearch.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        when (v?.id) {

            R.id.imgSearch -> {

                Constants.hideKeyBoard(etSearch, activity)
                //service hit fetch data


                if (etSearch.text.toString().isEmpty()) {
                    etSearch.isFocusable = true
                    Toast.makeText(context, "Invalid Input", Toast.LENGTH_SHORT).show()
                    return
                }

                showDialog("loading...")
                QuoteApplicationController(activity).getBOFbaList(DBPersistanceController(activity).userConstantsData.fbaId,
                        etSearch.text.toString(), this)


            }

            R.id.txtFBAName -> {
                Toast.makeText(context, "Self Clicked", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun getBOFBA(entity: BOFbaEntity?) {
        iboFbaCallback?.getBOFBA(entity)
        dismiss()

    }

    override fun OnSuccess(response: magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse?, message: String?) {
        cancelDialog()

        if (response is BOFbaListResponse) {

            if (response.masterData != null) {
                mList.clear()
                mList.addAll(response.masterData)
            }
            var boFbaEntity = BOFbaEntity()
            boFbaEntity.fullName = "Self"
            mList.add(0, boFbaEntity)

            mAdapter?.notifyDataSetChanged()

        }

    }

    override fun OnFailure(t: Throwable?) {
        cancelDialog()
        Toast.makeText(activity, t?.message, Toast.LENGTH_SHORT).show()
    }

    //region progress dialog

    fun showDialog() {
        showDialog("Loading...")
    }

    fun showDialog(msg: String) {
        if (dialog == null)
            dialog = ProgressDialog.show(activity, "", msg, true)
        else {
            if (!dialog!!.isShowing)
                dialog = ProgressDialog.show(activity, "", msg, true)
        }

    }

    fun cancelDialog() {
        if (dialog != null && dialog!!.isShowing()) {
            dialog!!.dismiss()
        }
    }

    //endregion
}
