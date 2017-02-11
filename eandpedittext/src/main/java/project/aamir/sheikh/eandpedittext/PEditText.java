package project.aamir.sheikh.eandpedittext;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Typeface;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by Aamir on 10-02-2017.
 */

public class PEditText extends LinearLayout {
    View rootView;
    EditText password;
    ImageView eye, arrow, icon;
    boolean flag = false;
    LinearLayout iconBackground, lEye;

    public PEditText(Context context) {
        super(context);
    }

    public PEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        rootView = inflate(context, R.layout.p_edittext_layout, this);
        password = (EditText) rootView.findViewById(R.id.input_pass);
        iconBackground = (LinearLayout) rootView.findViewById(R.id.icon_bg2);
        lEye = (LinearLayout) rootView.findViewById(R.id.linear_eye);
        arrow = (ImageView) rootView.findViewById(R.id.arrow);
        icon = (ImageView) rootView.findViewById(R.id.icon);
        eye = (ImageView) findViewById(R.id.eye);

        //check if password EditText is Empty
        if (password.length() == 0) {
            eye.setVisibility(View.INVISIBLE);
        }
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (password.length() == 0) {
                    eye.setVisibility(View.INVISIBLE);
                    //Toast.makeText(LoginActivity.this, "Inside If", Toast.LENGTH_SHORT).show();
                } else {
                    //Toast.makeText(LoginActivity.this, "Inside else", Toast.LENGTH_SHORT).show();
                    eye.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (password.length() == 0) {
                    eye.setVisibility(View.INVISIBLE);
                }

            }
        });
        lEye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (password.getText().toString() == "") {


                } else if (flag == false) {

                    password.setInputType(InputType.TYPE_CLASS_TEXT);
                    if (Model.getEyeOnIcon() == -1) {
                        eye.setImageResource(R.drawable.ic_remove_red_eye2_black_18dp);
                        flag = true;
                    } else {
                        eye.setImageResource(Model.getEyeOnIcon());
                        flag = true;

                    }
                } else if (Model.getEyeOffIcon() == -1) {
                    {

                        password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                        eye.setImageResource(R.drawable.ic_remove_red_eye_black_18dp);
                        flag = false;
                    }
                } else {
                    eye.setImageResource(Model.getEyeOnIcon());
                    flag = false;
                }
                password.setSelection(password.getText().length());
            }
        });


    }

    public void setText(String text) {
        this.password.setText(text);
    }

    public void setTextSize(float size) {
        this.password.setTextSize(size);
    }

    public void setTextColor(@ColorInt int color) {
        this.password.setTextColor(color);
    }

    public void setTextHintColor(@ColorInt int color) {
        this.password.setHintTextColor(color);
    }

    public void setIconBackgroundColor(@ColorInt int color) {
        this.iconBackground.setBackgroundColor(color);
        setDrawableBg(color, arrow);
    }

    public void setIcon(@DrawableRes int icon) {

        this.icon.setImageResource(icon);
    }

    public void setEyeOnIcon(@DrawableRes int icon) {
        Model.setEyeOnIcon(icon);
    }

    public void setEyeOffIcon(@DrawableRes int icon) {
        Model.setEyeOffIcon(icon);
    }

    private void setDrawableBg(int color, ImageView img) {
        PorterDuffColorFilter porterDuffColorFilter = new PorterDuffColorFilter(color,
                PorterDuff.Mode.SRC_ATOP);
        img.setColorFilter(porterDuffColorFilter);
    }

    public void setHintText(String text) {
        this.password.setHint(text);
    }
    public void setTypeFace(Typeface tf){
        this.password.setTypeface(tf);
    }
    public void setTypeFace(Typeface tf,int style){
        this.password.setTypeface(tf,style);
    }
    public Editable getText(){
        return this.password.getText();
    }
    public int length(){
        return this.password.length();
    }
}
