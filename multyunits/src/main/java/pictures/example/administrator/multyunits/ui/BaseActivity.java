package pictures.example.administrator.multyunits.ui;

import android.app.Dialog;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import pictures.example.administrator.multyunits.R;

/**
 * Created by Administrator on 2016/3/2.
 */
public class BaseActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }


    public void showMyToast(String title,String content){
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.mytoast,
                (ViewGroup) findViewById(R.id.llToast));
        ImageView image = (ImageView) layout
                .findViewById(R.id.tvImageToast);

        TextView tv_title = (TextView) layout.findViewById(R.id.tvTitleToast);
        tv_title.setText(title);
        TextView text = (TextView) layout.findViewById(R.id.tvTextToast);
        text.setText(content);
        Toast toast = new Toast(getBaseContext());
        toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL, 12, 40);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }
private Dialog mProgressDialog;
    public void showLoadingDialog(){
        if (mProgressDialog == null) {
            mProgressDialog = new Dialog(this,R.style.dialog_tran);
            View view = LayoutInflater.from(this).inflate(R.layout.progress_dialog, null);
            WindowManager.LayoutParams params = getWindow().getAttributes();
            params.height = ViewGroup.LayoutParams.MATCH_PARENT;
            params.width = ViewGroup.LayoutParams.MATCH_PARENT;
            //getWindow().setAttributes((android.view.WindowManager.LayoutParams) params);
            mProgressDialog.setCanceledOnTouchOutside(true);
            mProgressDialog.setCancelable(false);
            mProgressDialog.addContentView(view, params);
        }
        if (!mProgressDialog.isShowing()) {
            mProgressDialog.show();
        }
    }

    /**
     * 判断进度条是否已显示
     * @return
     */
    public boolean isDialogShowing() {
        return mProgressDialog != null && mProgressDialog.isShowing();
    }
    /**
     * 隐藏进度条
     */
    public void hideLoadingDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
        mProgressDialog = null;
    }

    /**
     * 提示对话框，仅提示，无其他操作逻辑
     * @param title
     * @param message
     */
    public void showMaterialDialog(String title,String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title).setMessage(message).setPositiveButton("确定",null).setCancelable(false).create().show();
    }

    /**
     * 带自定义布局的对话框
     * @param title
     * @param message
     * @param resource
     */
    public void showMaterialDialog(String title,String message,int resource){

    }
}
