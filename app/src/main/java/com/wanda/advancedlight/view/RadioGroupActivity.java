package com.wanda.advancedlight.view;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.wanda.advancedlight.BaseActivity;
import com.wanda.advancedlight.R;
import com.wanda.advancedlight.presenter.ExampleHelper;

import java.io.File;
import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;

/**
 * Created by PC on 2018/8/9.
 */

public class RadioGroupActivity extends BaseActivity implements View.OnClickListener{

    @BindViews({R.id.rg_textView1})
    List<TextView> TextView;
    @BindView(R.id.rg_myRadioGroup)
    RadioGroup myRadioGroup;
    @BindViews({R.id.rg_myRadioButton1,R.id.rg_myRadioButton2})
    List<RadioButton> radioButtons;
    @BindViews({R.id.four_File_btn,R.id.four_save_btn,R.id.four_show_btn,R.id.four_remove_btn})
    List<Button> Button;
    @BindViews({R.id.four_File_et,R.id.four_ContentProvider_name_et,R.id.four_ContentProvider_password_et})
    List<EditText> EditText;

    public final static String COLUMN_NAME ="name";
    public final static String COLUMN_PASSWORD ="passWord";

    ExampleHelper sp;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four_radiogroup);
        ButterKnife.bind(this);
        initView();


    }

    @Override
    public void initView() {
        myRadioGroup.setOnCheckedChangeListener(mChangeRadio);
        Button.get(0).setOnClickListener(this);
        Button.get(1).setOnClickListener(this);
        Button.get(2).setOnClickListener(this);
        Button.get(3).setOnClickListener(this);
        sp = new ExampleHelper(this,"contacts");
    }
    RadioGroup.OnCheckedChangeListener mChangeRadio = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {

            if (checkedId == radioButtons.get(0).getId()){
                TextView.get(0).setText(radioButtons.get(0).getText());
            }else if (checkedId == radioButtons.get(1).getId()){
                TextView.get(0).setText(radioButtons.get(1).getText());
            }

        }
    };

    @Override
    public void initToolbar() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.four_File_btn:
                String keyWord = EditText.get(0).getText().toString();
                if (keyWord.equals("")){
                    Toast.makeText(this, "The keyword cannot be empty", Toast.LENGTH_SHORT).show();
                }else {

                    EditText.get(0).setText(searchFile(keyWord));
                }
                break;
            case R.id.four_save_btn:
                String name = EditText.get(1).getText().toString();
                String psd = EditText.get(2).getText().toString();
                sp.putValue(COLUMN_NAME,name);
                sp.putValue(COLUMN_PASSWORD,psd);

                break;
            case R.id.four_show_btn:
                Toast.makeText(this, "name=="+sp.getValue(COLUMN_NAME+",,,,psd===="+sp.getValue(COLUMN_PASSWORD)), Toast.LENGTH_SHORT).show();
                break;
            case R.id.four_remove_btn:

                sp.putValue(COLUMN_NAME,"");
                sp.putValue(COLUMN_PASSWORD,"");
                break;
        }
    }

    private String searchFile(String keyword){
        String result ="";

        File[] files = new File("/").listFiles();
        try {
            for (File f : files){
                if (f.getName().indexOf(keyword)>=0){
                    result+=f.getPath()+"\n";
                }
            }
        }catch (Exception e){

        }

        if (result.equals("")) result ="找不到文件";
        return result;
    }

}
