package com.hanyangraon.kei.app_hnro.view.ff14;

import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.hanyangraon.kei.app_hnro.HnroActivity;
import com.hanyangraon.kei.app_hnro.R;
import com.hanyangraon.kei.hnro_libs.manager.LogManager;
import com.hanyangraon.kei.hnro_libs.util.ResourceUtil;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FF14_daily_lottery_Activity extends HnroActivity {

    private static final Map<String, Integer> REWORD_LIST; // 보상 정보 맵
    private static final ArrayList<Integer> REWORD_TOP_LIST; // 보상이 많은 순서대로 정렬된 배열

    static {
        REWORD_LIST = new HashMap<>();
        REWORD_LIST.put("6", 10000);
        REWORD_LIST.put("24", 3600);
        REWORD_LIST.put("23", 1800);
        REWORD_LIST.put("21", 1080);
        REWORD_LIST.put("8", 720);
        REWORD_LIST.put("9", 360);
        REWORD_LIST.put("20", 306);
        REWORD_LIST.put("11", 252);
        REWORD_LIST.put("15", 180);
        REWORD_LIST.put("17", 180);
        REWORD_LIST.put("22", 144);
        REWORD_LIST.put("18", 119);
        REWORD_LIST.put("12", 108);
        REWORD_LIST.put("10", 80);
        REWORD_LIST.put("13", 72);
        REWORD_LIST.put("16", 72);
        REWORD_LIST.put("14", 54);
        REWORD_LIST.put("7", 36);
        REWORD_LIST.put("19", 36);

        REWORD_TOP_LIST = new ArrayList<>();
        REWORD_TOP_LIST.add(6);
        REWORD_TOP_LIST.add(24);
        REWORD_TOP_LIST.add(23);
        REWORD_TOP_LIST.add(21);
        REWORD_TOP_LIST.add(8);
        REWORD_TOP_LIST.add(9);
        REWORD_TOP_LIST.add(20);
        REWORD_TOP_LIST.add(11);
        REWORD_TOP_LIST.add(15);
        REWORD_TOP_LIST.add(17);
        REWORD_TOP_LIST.add(22);
        REWORD_TOP_LIST.add(18);
        REWORD_TOP_LIST.add(12);
        REWORD_TOP_LIST.add(10);
        REWORD_TOP_LIST.add(13);
        REWORD_TOP_LIST.add(16);
        REWORD_TOP_LIST.add(14);
        REWORD_TOP_LIST.add(7);
        REWORD_TOP_LIST.add(19);
    }

    private RelativeLayout mPopupView;
    private NumberPicker mNumberPicker;
    private TextView mMinRewardView;
    private TextView mMaxRewardView;

    private ArrayList<List<Integer>> mProbList; // 조합가능한 숫자 목록
    private ArrayList<Integer> mUsingNumber; // 사용중인 숫자
    private Button mSelectButton; // 선택된 버튼

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ff14_daily_lottery);

        getProgList();
        mUsingNumber = new ArrayList<>();
        resetUsingNumberList();

        mMinRewardView = (TextView) findViewById(R.id.view_min_reward);
        mMaxRewardView = (TextView) findViewById(R.id.view_max_reward);

        mPopupView = (RelativeLayout) findViewById(R.id.pop_sel_number);
        mPopupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });

        mNumberPicker = (NumberPicker) findViewById(R.id.sel_number);
        if (mNumberPicker != null) {
            mNumberPicker.setMinValue(1);
            mNumberPicker.setMaxValue(9);
        }

        setOnClickListener(R.id.btn1);
        setOnClickListener(R.id.btn2);
        setOnClickListener(R.id.btn3);
        setOnClickListener(R.id.btn4);
        setOnClickListener(R.id.btn5);
        setOnClickListener(R.id.btn6);
        setOnClickListener(R.id.btn7);
        setOnClickListener(R.id.btn8);
        setOnClickListener(R.id.btn9);
        setOnClickListener(R.id.btn_sel_under1);
        setOnClickListener(R.id.btn_sel_under2);
        setOnClickListener(R.id.btn_sel_under3);
        setOnClickListener(R.id.btn_sel_right1);
        setOnClickListener(R.id.btn_sel_right2);
        setOnClickListener(R.id.btn_sel_right3);
        setOnClickListener(R.id.btn_sel_diagonal1);
        setOnClickListener(R.id.btn_sel_diagonal2);
        setOnClickListener(R.id.btn_clear);
        setOnClickListener(R.id.btn_pop_sel);
        setOnClickListener(R.id.btn_pop_cancel);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch (id) {
            case R.id.btn1:
            case R.id.btn2:
            case R.id.btn3:
            case R.id.btn4:
            case R.id.btn5:
            case R.id.btn6:
            case R.id.btn7:
            case R.id.btn8:
            case R.id.btn9:
                if (view instanceof Button) {
                    callSelectNumber((Button) view);
                }
                break;
            case R.id.btn_sel_under1:
                calculateMinMaxReward(1, 4, 7);
                break;
            case R.id.btn_sel_under2:
                calculateMinMaxReward(2, 5, 8);
                break;
            case R.id.btn_sel_under3:
                calculateMinMaxReward(3, 6, 9);
                break;
            case R.id.btn_sel_right1:
                calculateMinMaxReward(1, 2, 3);
                break;
            case R.id.btn_sel_right2:
                calculateMinMaxReward(4, 5, 6);
                break;
            case R.id.btn_sel_right3:
                calculateMinMaxReward(7, 8, 9);
                break;
            case R.id.btn_sel_diagonal1:
                calculateMinMaxReward(1, 5, 9);
                break;
            case R.id.btn_sel_diagonal2:
                calculateMinMaxReward(3, 5, 7);
                break;
            case R.id.btn_clear:
                resetView();
                break;
            case R.id.btn_pop_sel:
                setNumber();
                break;
            case R.id.btn_pop_cancel:
                hidePopup();
                break;
        }
    }

    private void calculateMinMaxReward(int idx1, int idx2, int idx3) {
        List<Integer> checkNums = new ArrayList<>();
        List<Integer> exceptNums = new ArrayList<>();

        resetButtonBackgroundColor();

        changeButtonBackgroundColor(idx1, R.drawable.button_sel);
        changeButtonBackgroundColor(idx2, R.drawable.button_sel);
        changeButtonBackgroundColor(idx3, R.drawable.button_sel);

        for (int i = 0, len = mUsingNumber.size(); i < len; i++) {
            int num = mUsingNumber.get(i);
            if (i == idx1 || i == idx2 || i == idx3) {
                if (num != 0) {
                    checkNums.add(num);
                }
            } else {
                if (num != 0) {
                    exceptNums.add(num);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        List<Integer> minCase = null;
        List<Integer> maxCase = null;
        int checkSize = checkNums.size();
        if (checkSize == 3) {
            String key = (checkNums.get(0) + checkNums.get(1) + checkNums.get(2)) + "";
            min = REWORD_LIST.get(key);
            max = REWORD_LIST.get(key);
            minCase = checkNums;
            maxCase = checkNums;
        } else {
            int exceptSize = exceptNums.size();
            for (List<Integer> child : mProbList) {
                boolean hasExceptNum = false;
                for (int i = 0; i < exceptSize; i++) {
                    if (child.contains(exceptNums.get(i))) {
                        hasExceptNum = true;
                        break;
                    }
                }

                if (hasExceptNum) {
                    continue;
                }

                boolean check = true;
                for (int i = 0; i < checkSize; i++) {
                    if (!child.contains(checkNums.get(i))) {
                        check = false;
                        break;
                    }
                }

                if (check) {
                    int sum = child.get(0) + child.get(1) + child.get(2);
                    int reward = REWORD_LIST.get(sum + "");
                    if (min > reward) {
                        min = reward;
                        minCase = child;
                    }
                    if (max < reward) {
                        max = reward;
                        maxCase = child;
                    }
                }
            }
        }

        mMinRewardView.setText(min + " " + (minCase == null ? "" : minCase.toString()));
        mMaxRewardView.setText(max + " " + (maxCase == null ? "" : maxCase.toString()));
    }

    private void resetButtonBackgroundColor() {
        changeButtonBackgroundColor(1, R.drawable.button);
        changeButtonBackgroundColor(2, R.drawable.button);
        changeButtonBackgroundColor(3, R.drawable.button);
        changeButtonBackgroundColor(4, R.drawable.button);
        changeButtonBackgroundColor(5, R.drawable.button);
        changeButtonBackgroundColor(6, R.drawable.button);
        changeButtonBackgroundColor(7, R.drawable.button);
        changeButtonBackgroundColor(8, R.drawable.button);
        changeButtonBackgroundColor(9, R.drawable.button);

    }

    private void changeButtonBackgroundColor(int index, int styleID) {
        int id = ResourceUtil.getResId(R.id.class, "btn" + index);

        Button btn = (Button) findViewById(id);
        if (btn != null) {
            btn.setBackgroundResource(styleID);
        }
    }

    private void callSelectNumber(Button button) {
        mSelectButton = button;
        mPopupView.setVisibility(View.VISIBLE);
    }

    private void setNumber() {
        if (mSelectButton != null) {
            int selNum = mNumberPicker.getValue();
            int btnIndex = Integer.parseInt(mSelectButton.getTag().toString());

            mUsingNumber.set(btnIndex, 0);

            if (mUsingNumber.contains(selNum)) {
                showConfirmAlert(-1, R.string.warn_selected_number);
            } else {
                mUsingNumber.set(btnIndex, selNum);
                mSelectButton.setText(String.valueOf(selNum));
                hidePopup();
            }
        } else {
            LogManager.getInstance().error(new Exception("selected button info is null!!!"));
        }
    }

    private void hidePopup() {
        mSelectButton = null;
        mPopupView.setVisibility(View.GONE);
    }

    private void resetView() {
        resetButton(R.id.btn1);
        resetButton(R.id.btn2);
        resetButton(R.id.btn3);
        resetButton(R.id.btn4);
        resetButton(R.id.btn5);
        resetButton(R.id.btn6);
        resetButton(R.id.btn7);
        resetButton(R.id.btn8);
        resetButton(R.id.btn9);
        resetButtonBackgroundColor();

        resetUsingNumberList();

        mMinRewardView.setText("");
        mMaxRewardView.setText("");
    }

    private void resetUsingNumberList() {
        mUsingNumber.clear();
        for (int i = 0; i < 10; i++) {
            mUsingNumber.add(0);
        }
    }

    private void resetButton(int id) {
        Button btn = (Button) findViewById(id);
        if (btn != null) {
            btn.setText("");
        }
    }

    private void getProgList() {
        mProbList = new ArrayList<>();

        for (int i = 1; i < 10; i++) {
            int startNum = i; // 시작값
            while (true) {
                ArrayList<Integer> item = new ArrayList<>();
                item.add(i);

                startNum += 1;
                if (startNum == 10) {
                    startNum = 1;
                }
                if (startNum == i) {
                    break;
                }

                int j = startNum;
                while (true) { // 9개 숫자 배열 생성
                    if (j != i) {
                        item.add(j);
                    }
                    if (j == 9) {
                        j = 1;
                    } else {
                        j += 1;
                    }
                    if (j == startNum) {
                        break;
                    }
                }

                int si = 0;
                while (true) {
                    List<Integer> sa = item.subList(si, si + 3);
                    Collections.sort(sa);
                    if (!mProbList.contains(sa)) {
                        mProbList.add(sa);
                    }
                    si += 3;
                    if (si == 9) {
                        break;
                    }
                }
            }
        }

        HashMap<String, ArrayList<List<Integer>>> sumGrouping = new HashMap<>();
        for (List<Integer> child : mProbList) {
            String sumKey = (child.get(0) + child.get(1) + child.get(2)) + "";
            if (sumGrouping.get(sumKey) == null) {
                sumGrouping.put(sumKey, new ArrayList<List<Integer>>());
            }
            sumGrouping.get(sumKey).add(child);
        }

        LinearLayout view = (LinearLayout) findViewById(R.id.ff14_daily_lottery);
        NumberFormat nf = NumberFormat.getInstance();
        if (view != null) {
            for (int i = 0, len = REWORD_TOP_LIST.size(); i < len; i++) {
                String sumValue = REWORD_TOP_LIST.get(i).toString();
                ArrayList<List<Integer>> child = sumGrouping.get(sumValue);
                if (child == null) {
                    continue;
                }

                TextView rewordView = new TextView(this);
                rewordView.setText(sumValue + " : " + nf.format(REWORD_LIST.get(sumValue)));
                rewordView.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                view.addView(rewordView);

                String text = "";
                for (int j = 0, jlen = child.size(); j < jlen; j++) {
                    List<Integer> item = child.get(j);
                    text += item.toString();
                    if (j < jlen - 1) {
                        text += ", ";
                    }
                }
                TextView tv = new TextView(this);
                tv.setText(text);
                view.addView(tv);
            }
        }

    }
}
