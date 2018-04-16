package com.xudangui.imchat.activity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.qmuiteam.qmui.widget.QMUITabSegment;
import com.xudangui.imchat.R;
import com.xudangui.imchat.fragment.MessageFragment;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * Created by xudangui on 2018/4/12.
 */

@ContentView(R.layout.activity_main)
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentManager manager = getFragmentManager();
        MessageFragment messageFragment = new MessageFragment();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.mainFragment,messageFragment);
        transaction.commit();
        x.view().inject(this);

    }
}
