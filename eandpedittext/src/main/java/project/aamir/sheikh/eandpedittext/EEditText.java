package project.aamir.sheikh.eandpedittext;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by Aamir on 10-02-2017.
 */

public class EEditText extends LinearLayout {

    EditText email;
    View rootView;
    ImageView tick;
    Drawable drawable;
    LinearLayout iconBackground;
    ImageView icon, arrow;

    public EEditText(Context context) {
        super(context);
        Model.setContext(context);
        init();
    }

    public EEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        Model.setContext(context);
        Model.setAttrs(attrs);
        init();
    }

    private void init() {

        TypedArray a = Model.getContext().obtainStyledAttributes(
                Model.getAttrs(),
                R.styleable.MyCustomView);
        rootView = inflate(Model.getContext(), R.layout.e_edittext_layout, this);
        //Main Linear Layout
        if (rootView != null) {

            //Initialize Layouts
            LinearLayout mLinearLayout = (LinearLayout) rootView.findViewById(R.id.linear_main);
            email = (EditText) rootView.findViewById(R.id.input_email);
            tick = (ImageView) rootView.findViewById(R.id.tick);
            iconBackground = (LinearLayout) rootView.findViewById(R.id.icon_bg);
            icon = (ImageView) rootView.findViewById(R.id.icon);
            arrow = (ImageView) rootView.findViewById(R.id.arrow);
            //End

            ////Linear Layout
            mLinearLayout.setOrientation(LinearLayout.HORIZONTAL);
            LayoutParams mParams = new LayoutParams
                    (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            mLinearLayout.setLayoutParams(mParams);
            /////

            //check email when out of focus
            email.setOnFocusChangeListener(new OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if (hasFocus) {
                        //don nothing when in focus
                    } else {
                        checkEmail(Model.getContext());
                    }

                }
            });

        } else {

            //if root e_edittext_layout returns null
            Toast.makeText(Model.getContext(), "Root View null", Toast.LENGTH_SHORT).show();
        }
    }

    private void checkEmail(final Context c) {
        if (!isValidEmail(email.getText().toString())) {
            //if email is incorrect
            showError(c);

        } else {
            //email is correct show tick
            Animate(c);
        }
    }

    private void showError(Context c) {
        if (tick.getVisibility() == View.VISIBLE) {
            tick.setBackgroundColor(getResources().getColor(R.color.transparent));
        }

        float scale = getResources().getDisplayMetrics().density;
        int errorPad = (int) (15 * scale + 0.5f);
        int padLeft = (int) (8 * scale + 0.5f);
        drawable = c.getResources().getDrawable(R.drawable.ic_error_red_800_18dp);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        email.setError(Model.getErrorMsg(), drawable);
        email.setPadding(padLeft, 0, errorPad, 0);
    }

    private void Animate(final Context c) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Animation fadeInAnimation = AnimationUtils.loadAnimation(
                        c, R.anim.fade_in_view);
                tick.startAnimation(fadeInAnimation);
                fadeInAnimation.setAnimationListener(new Animation.AnimationListener() {

                    @Override
                    public void onAnimationStart(Animation animation) {

                        tick.setVisibility(View.VISIBLE);
                        float scale = getResources().getDisplayMetrics().density;
                        int tickPad = (int) (36 * scale + 0.5f);
                        int padLeft = (int) (8 * scale + 0.5f);
                        tick.setImageResource(R.drawable.ic_check_circle_black_18dp);
                        email.setPadding(padLeft, 0, tickPad, 0);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {
                        // TODO Auto-generated method stub

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        // TODO Auto-generated method stub

                    }
                });
            }

        }, 60);


    }

    private final static boolean isValidEmail(CharSequence target) {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

    public void setText(String text) {
        this.email.setText(text);
    }

    public void setTextSize(float size) {
        this.email.setTextSize(size);
    }

    public void setTextColor(@ColorInt int color) {
        this.email.setTextColor(color);
    }

    public void setTextHintColor(@ColorInt int color) {
        this.email.setHintTextColor(color);
    }

    public void setIconBackgroundColor(@ColorInt int color) {
        this.iconBackground.setBackgroundColor(color);
        setDrawableBg(color, arrow);
    }

    public void setIcon(@DrawableRes int icon) {

        this.icon.setImageResource(icon);
    }

    public void setTickIconColor(int color) {
        setDrawableBg(color, tick);
    }

    public void setErrorMessage(String message) {
        Model.setErrorMsg(message);
        this.email.setError(message, drawable);
    }

    private void setDrawableBg(int color, ImageView img) {
        PorterDuffColorFilter porterDuffColorFilter = new PorterDuffColorFilter(color,
                PorterDuff.Mode.SRC_ATOP);
        img.setColorFilter(porterDuffColorFilter);
    }

    public void setHintText(String text) {
        this.email.setHint(text);
    }

    public void setTypeFace(Typeface tf) {
        this.email.setTypeface(tf);
    }

    public void setTypeFace(Typeface tf, int style) {
        this.email.setTypeface(tf, style);
    }

    public Editable getText(){
        return this.email.getText();
    }

    public int length(){
        return this.email.length();
    }

}
