package com.datacomp.magicfinmart.pospapp.exam;

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

import com.google.gson.Gson;
import com.datacomp.magicfinmart.R;

import magicfinmart.datacomp.com.finmartserviceapi.pospapp.Constants;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.requestmodels.AnswerSet;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.requestmodels.SubmitRequestEntity;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Rajeev Ranjan on 23/03/2017.
 */

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.QuestionItems> {

    Context mContext;
    SubmitRequestEntity submitRequestEntity;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public QuestionAdapter(Context context, SubmitRequestEntity submitRequestEntity) {
        this.mContext = context;
        this.submitRequestEntity = submitRequestEntity;
        sharedPreferences = mContext.getSharedPreferences(Constants.SHAREDPREFERENCE_TITLE, MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public class QuestionItems extends RecyclerView.ViewHolder {

        TextView tvQuestion;
        RadioGroup rgQuestion;
        RadioButton rbOne, rbTwo, rbThree, rbFour;

        public QuestionItems(View view) {
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
    public QuestionItems onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_question_item, parent, false);

        return new QuestionItems(itemView);
    }

    @Override
    public void onBindViewHolder(final QuestionItems holder, int position) {

        final AnswerSet answerSet = submitRequestEntity.getAnswerSet().get(position);
        holder.rgQuestion.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                int id = group.indexOfChild(group.findViewById(checkedId));
                switch (id) {
                    case 0:
                        answerSet.setUserInput("A");
                        break;
                    case 1:
                        answerSet.setUserInput("B");
                        break;
                    case 2:
                        answerSet.setUserInput("C");
                        break;
                    case 3:
                        answerSet.setUserInput("D");
                        break;
                }
                answerSet.setSelectedOption(checkedId);
                Gson gson = new Gson();
                editor.putString(Constants.QUESTION_FACADE, gson.toJson(submitRequestEntity));
                editor.commit();
            }
        });
        if (answerSet.getSelectedOption() != 0) {
            holder.rgQuestion.check(answerSet.getSelectedOption());
        } else {
            holder.rgQuestion.clearCheck();
        }


        holder.tvQuestion.setText(answerSet.getQuestion());
        holder.rbOne.setText(answerSet.getOptionA());
        holder.rbTwo.setText(answerSet.getOptionB());
        holder.rbThree.setText(answerSet.getOptionC());
        holder.rbFour.setText(answerSet.getOptionD());

    }

    @Override
    public int getItemCount() {
        return submitRequestEntity.getAnswerSet().size();
    }
}
