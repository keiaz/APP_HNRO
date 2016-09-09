package com.hanyangraon.kei.app_hnro.appbase;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import com.hanyangraon.kei.app_hnro.R;
import com.hanyangraon.kei.hnro_libs.manager.ActivityManager;

/**
 * {@link AppCompatActivity}를 상속받은 activity
 * Copyright (c) HanyangRaon. All Rights Reserved.
 *
 * @author Kei
 * @version 1.0
 * @since 16. 8. 25.
 */
public class HnroActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 모든 프래그먼트, 로더의 초기화 수행
     *
     * @param savedInstanceState 액티비티 종료 후 다시 초기화될 때, 가장 최근에 onSaveInstanceState(Bundle)로 저장된 데이터. 없으면 null
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
    }

    /**
     * 액티비티가 백그라운드로 갈 때 호출
     */
    @Override
    protected void onPause() {
        super.onPause();
    }

    /**
     * 액티비티가 파괴되기 전에 최종 작업을 수행
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityManager.getInstance().removeActivity(this);
    }

    /**
     * ActionBar의 옵션 메뉴 선택시 호출
     *
     * @param item 선택된 옵션 메뉴 아이템
     * @return false 반환시, 일반 메뉴 프로세싱의 진행을 허용. true 반환시 중지.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean result = super.onOptionsItemSelected(item);

        /*
        // TODO set custom action for actionbar's 'home as up' button selected
        if (android.R.id.home == item.getItemId()) {
        }
        */

        return result;
    }

    /**
     * 다른 액티비티로 이동할 때 requestCode를 제공하고, 다시 돌아올 때 resultCode 및 추가 데이터를 넘겨받으면 호출
     *
     * @param requestCode startActivityForResult()를 사용하여 다른 액티비티로 이동할 때 제공한 requestCode.
     * @param resultCode  다른 액티비티에서 setResult()를 통해 넘겨받은 resultCode.
     * @param data        다른 액티비티에서 넘겨받은 데이터
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    /**
     * view가 클릭되었을 때 호출
     *
     * @param view 클릭된 view
     */
    @Override
    public void onClick(View view) {
        // nothing...
    }

    /**
     * {@link HnroApplication} 획득
     *
     * @return HnroApplication
     */
    public HnroApplication getHnroApplication() {
        return (HnroApplication) getApplication();
    }

    /**
     * View에 클릭 이벤트 리스너를 부착
     *
     * @param viewid 부착할 대상 View의 id
     */
    protected void setOnClickListener(int viewid) {
        View view = findViewById(viewid);
        if (view != null) {
            view.setOnClickListener(this);
        }
    }

    /**
     * View를 화면에 보여주거나 감춘다.
     *
     * @param viewid 보여주거나 감출 화면 id
     * @param isShow 보여줄 경우 true. 감출 경우 false. 감출 경우 해당 View가 차지하고 있던 영역도 사라진다
     */
    public void setVisibility(int viewid, boolean isShow) {
        View view = findViewById(viewid);
        if (view != null) {
            view.setVisibility(isShow ? View.VISIBLE : View.GONE);
        }
    }

    /**
     * 화면 이동
     *
     * @param activityClass 이동할, {@link HnroActivity}를 상속받은 Activity의 클래스
     * @param flags         Intent에 추가할 플래그들
     */
    protected void moveActivity(Class<? extends HnroActivity> activityClass, int... flags) {
        Intent intent = new Intent(this, activityClass);
        for (int flag : flags) {
            intent.addFlags(flag);
        }
        startActivity(intent);
    }

    /**
     * 화면 이동
     *
     * @param activityClass 이동할, {@link HnroActivity}를 상속받은 Activity의 클래스
     */
    protected void moveActivity(Class<? extends HnroActivity> activityClass) {
        startActivity(new Intent(this, activityClass));
    }

    /**
     * 내용 확인용 알림창을 출력한다
     *
     * @param titleResid   알림창 타이틀. -1일경우 타이틀을 출력하지 않는다.
     * @param messageResid 알림창에 출력할 메시지
     */
    public void showConfirmAlert(int titleResid, int messageResid) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        if (titleResid != -1) {
            builder.setTitle(titleResid);
        }

        builder.setMessage(messageResid);

        builder.setPositiveButton(R.string.confirm, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss(); // 팝업을 닫는다.
            }
        });

        builder.create().show();
    }

    /**
     * Custom Action bar를 세팅하고 타이틀을 적용합니다
     *
     * @param title       타이틀
     * @param isInputForm true일 경우 Actionbar를 터치하여 키보드 제거.
    protected void setCustomActionBar(String title, boolean isInputForm) {
    this.isInputForm = isInputForm;

    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null) {
    actionBar.setDisplayShowCustomEnabled(true); // Custom actionbar를 사용하기 위해 CustomEnabled true 변경.
    actionBar.setDisplayShowTitleEnabled(false); // 액션바 제목 표시

    // set Custom view layout
    LayoutInflater inflater = LayoutInflater.from(this);
    int layoutid = R.layout.layout_actionbar;
    View mCustomBar = inflater.inflate(layoutid, null);
    actionBar.setCustomView(mCustomBar, new ActionBar.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.MATCH_PARENT, Gravity.CENTER));

    TextView titleView = (TextView) mCustomBar.findViewById(R.id.action_bar_title);
    titleView.setText(title);

    if (isInputForm) {
    mCustomBar.setOnClickListener(new View.OnClickListener() {
    @Override public void onClick(View view) {
    hideKeyboard();
    }
    });
    }
    }
    }

    /**
     * View에 포커스를 주고 키보드를 화면에 등장시킨다.
     *
     * @param view 포커스 대상 View
    protected void showKeyboard(View view) {
    if (view != null) {
    view.requestFocus();
    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
    imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
    }
    }

    /**
     * View에 포커스를 주고 키보드를 화면에 등장시킨다.
     *
     * @param viewid 포커스 대상이 될 view id
    protected void showKeyboard(int viewid) {
    showKeyboard(findViewById(viewid));
    }

    /**
     * 키보드를 화면에서 감춘다.
    protected void hideKeyboard() {
    View view = getCurrentFocus();
    if (view != null) {
    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

    ViewGroup viewGroup = (ViewGroup) findViewById(android.R.id.content);
    if (viewGroup != null) {
    viewGroup.getChildAt(0).clearFocus();
    }
    }
    }
     */
}
