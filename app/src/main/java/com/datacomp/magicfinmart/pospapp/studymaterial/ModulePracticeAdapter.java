package com.datacomp.magicfinmart.pospapp.studymaterial;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.IdRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.datacomp.magicfinmart.R;
import com.google.gson.Gson;


import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.pospapp.Constants;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.models.PracticeModuleEntity;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Rajeev Ranjan on 17/04/2017.
 */

public class ModulePracticeAdapter extends RecyclerView.Adapter<ModulePracticeAdapter.ModulePracticeItems> {
    Context mContext;
    List<PracticeModuleEntity> practiceModuleEntityList;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public ModulePracticeAdapter(Context context, List<PracticeModuleEntity> practiceModuleEntityList) {
        this.mContext = context;
        this.practiceModuleEntityList = practiceModuleEntityList;
        sharedPreferences = mContext.getSharedPreferences(Constants.SHAREDPREFERENCE_TITLE, MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public class ModulePracticeItems extends RecyclerView.ViewHolder {

        TextView tvQuestion;
        RadioGroup rgQuestion;
        RadioButton rbOne, rbTwo, rbThree, rbFour;

        public ModulePracticeItems(View view) {
            super(view);
            tvQuestion = (TextView) view.findViewById(R.id.tvQuestion);
            rgQuestion = (RadioGroup) view.findViewById(R.id.rgQuestion);
            rbOne = (RadioButton) view.findViewById(R.id.rbOne);
            rbTwo = (RadioButton) view.findViewById(R.id.rbTwo);
            rbThree = (RadioButton) view.findViewById(R.id.rbThree);
            rbFour = (RadioButton) view.findViewById(R.id.rbFour);
        }


    }

    @Override
    public ModulePracticeAdapter.ModulePracticeItems onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_question_item, parent, false);

        return new ModulePracticeAdapter.ModulePracticeItems(itemView);
    }

    @Override
    public void onBindViewHolder(final ModulePracticeAdapter.ModulePracticeItems holder, int position) {

        final PracticeModuleEntity practiceModuleEntity = practiceModuleEntityList.get(position);
        holder.rgQuestion.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                int id = group.indexOfChild(group.findViewById(checkedId));
                switch (id) {
                    case 0:
                        practiceModuleEntity.setUserInput("A");
                        break;
                    case 1:
                        practiceModuleEntity.setUserInput("B");
                        break;
                    case 2:
                        practiceModuleEntity.setUserInput("C");
                        break;
                    case 3:
                        practiceModuleEntity.setUserInput("D");
                        break;
                }
                practiceModuleEntity.setSelectedOption(checkedId);
                Gson gson = new Gson();
                editor.putString(Constants.MODEL_PRACTICE, gson.toJson(practiceModuleEntityList));
                editor.commit();
            }
        });
        if (practiceModuleEntity.getSelectedOption() != 0) {
            holder.rgQuestion.check(practiceModuleEntity.getSelectedOption());
        } else {
            holder.rgQuestion.clearCheck();
        }


        holder.tvQuestion.setText(practiceModuleEntity.getQuestion());
        holder.rbOne.setText(practiceModuleEntity.getOptionA());
        holder.rbTwo.setText(practiceModuleEntity.getOptionB());
        holder.rbThree.setText(practiceModuleEntity.getOptionC());
        holder.rbFour.setText(practiceModuleEntity.getOptionD());

    }

    @Override
    public int getItemCount() {
        return practiceModuleEntityList.size();
    }
}
