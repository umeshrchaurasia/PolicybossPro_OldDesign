package com.datacomp.magicfinmart.pospapp.studymaterial;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


import com.datacomp.magicfinmart.R;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.pospapp.Constants;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.models.PracticeModuleEntity;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Rajeev Ranjan on 13/06/2017.
 */

public class ViewAnswerAdapter extends RecyclerView.Adapter<ViewAnswerAdapter.ModulePracticeItems> {
    Context mContext;
    List<PracticeModuleEntity> practiceModuleEntityList;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public ViewAnswerAdapter(Context context, List<PracticeModuleEntity> practiceModuleEntityList) {
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
    public ViewAnswerAdapter.ModulePracticeItems onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_question_item, parent, false);

        return new ViewAnswerAdapter.ModulePracticeItems(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewAnswerAdapter.ModulePracticeItems holder, int position) {

        final PracticeModuleEntity practiceModuleEntity = practiceModuleEntityList.get(position);
        /*holder.rgQuestion.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
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
        });*/
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

        if (practiceModuleEntity.getCorrectAnswer().contains("A")) {
            holder.rbOne.setTextColor(mContext.getResources().getColor(R.color.colorAccent));
        } else {
            holder.rbOne.setTextColor(Color.BLACK);
        }

        if (practiceModuleEntity.getCorrectAnswer().contains("B")) {
            holder.rbTwo.setTextColor(mContext.getResources().getColor(R.color.colorAccent));
        } else {
            holder.rbTwo.setTextColor(Color.BLACK);
        }
        if (practiceModuleEntity.getCorrectAnswer().contains("C")) {
            holder.rbThree.setTextColor(mContext.getResources().getColor(R.color.colorAccent));
        } else {
            holder.rbThree.setTextColor(Color.BLACK);
        }
        if (practiceModuleEntity.getCorrectAnswer().contains("D")) {
            holder.rbFour.setTextColor(mContext.getResources().getColor(R.color.colorAccent));
        } else {
            holder.rbFour.setTextColor(Color.BLACK);
        }
        if (practiceModuleEntity.getUserInput() != null) {
            if (!practiceModuleEntity.getUserInput().trim().matches(practiceModuleEntity.getCorrectAnswer().trim())) {
                if (practiceModuleEntity.getUserInput().contains("A")) {
                    holder.rbOne.setTextColor(mContext.getResources().getColor(R.color.colorPrimaryDark));
                } else if (practiceModuleEntity.getUserInput().contains("B")) {
                    holder.rbTwo.setTextColor(mContext.getResources().getColor(R.color.colorPrimaryDark));
                } else if (practiceModuleEntity.getUserInput().contains("C")) {
                    holder.rbThree.setTextColor(mContext.getResources().getColor(R.color.colorPrimaryDark));
                } else if (practiceModuleEntity.getUserInput().contains("D")) {
                    holder.rbFour.setTextColor(mContext.getResources().getColor(R.color.colorPrimaryDark));
                }
            }
        }


    }

    @Override
    public int getItemCount() {
        return practiceModuleEntityList.size();
    }
}
