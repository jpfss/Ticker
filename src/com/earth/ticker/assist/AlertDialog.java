package com.earth.ticker.assist;

import android.R.string;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.earth.ticker.R;


public class AlertDialog {
	Context context;
	android.app.AlertDialog ad;
	TextView titleView;
	TextView messageView;
	EditText folderName;
	LinearLayout buttonLayout;
	
	public AlertDialog(Context context) {
		// TODO Auto-generated constructor stub
		this.context=context;
		ad=new android.app.AlertDialog.Builder(context).create();
		//���dialog����ʧ
		ad.setCanceledOnTouchOutside(true);
		ad.show();
		//�ؼ������������,ʹ��window.setContentView,�滻�����Ի��򴰿ڵĲ���
		Window window = ad.getWindow();
		window.setContentView(R.layout.addfolder_alertdialog);
		//���������
		window.clearFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
		titleView=(TextView)window.findViewById(R.id.title);
		messageView=(TextView)window.findViewById(R.id.message);
		
		folderName=(EditText)window.findViewById(R.id.dialog_folder_name);
		
		buttonLayout=(LinearLayout)window.findViewById(R.id.buttonLayout);
		
		//String folder_name=folderName.getText().toString();
	}
			
	public void setTitle(String title) {
		titleView.setText(title);
	}
	
	public void setMessage(String message)
	{
		messageView.setText(message);
	}
		
	public void setEdit(boolean visible) {
		// TODO Auto-generated method stub
		if(visible)
		{
			folderName.setVisibility(View.VISIBLE);
		}else
		{
			folderName.setVisibility(View.GONE);
		}
	}
	public String getEditText()
	{
		return folderName.getText().toString();
	}
	/**
	 * ���ð�ť
	 * @param text
	 * @param listener
	 */
	public void setPositiveButton(String text,final View.OnClickListener listener)
	{
		Button button=(Button)buttonLayout.findViewById(R.id.position_button);			
		button.setText(text);
		button.setTextColor(Color.parseColor("#3CB6E3"));
		button.setTextSize(20);
		button.setOnClickListener(listener);		
	}
 
	/**
	 * ���ð�ť
	 * @param text
	 * @param listener
	 */
	public void setNegativeButton(String text,final View.OnClickListener listener)
	{
		
		Button button=(Button)buttonLayout.findViewById(R.id.negtive_button);		
		button.setText(text);
		button.setTextColor(Color.parseColor("#3CB6E3"));
		button.setTextSize(20);
		button.setOnClickListener(listener);				
 
	}
	/**
	 * �رնԻ���
	 */
	public void dismiss() {
		ad.dismiss();
	}

	
	
}