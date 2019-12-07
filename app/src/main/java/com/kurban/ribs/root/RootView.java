package com.kurban.ribs.root;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.jakewharton.rxbinding2.view.RxView;
import com.kurban.ribs.R;

import io.reactivex.Observable;

/**
 * Top level view for {@link RootBuilder.RootScope}.
 */
class RootView extends RelativeLayout implements RootInteractor.RootPresenter {

    private TextView textView;
    private Button button;

    public RootView(Context context) {
        this(context, null);
    }

    public RootView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RootView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
    }

    @Override
    public Observable<Object> click() {
        return RxView.clicks(button);
    }

    @Override
    public void setText(@NonNull String value) {
        textView.setText(value);
    }
}
