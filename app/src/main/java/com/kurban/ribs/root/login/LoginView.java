package com.kurban.ribs.root.login;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.kurban.ribs.R;

/**
 * Top level view for {@link LoginBuilder.LoginScope}.
 */
class LoginView extends RelativeLayout implements LoginInteractor.LoginPresenter {

    private TextView textView;

    public LoginView(Context context) {
        this(context, null);
    }

    public LoginView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LoginView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        textView = findViewById(R.id.textView);
    }

    @Override
    public void setText(@NonNull String value) {
        textView.setText(value);
    }
}
