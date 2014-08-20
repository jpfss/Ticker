package com.earth.ticker;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.earth.ticker.assist.AlertDialog;

public class AddDeleteFolderActivity extends Activity{
	
	private ImageButton add_Button;
	private ListView mlistView;
	private List<String> folder_list=new ArrayList<String>();
	private String str;//��õ�EditText����
	protected Activity context;
	private  PopupWindow pop;
	private int pos=0;
	@Override
	public void onCreate(Bundle saveInstanceState)
	{
		super.onCreate(saveInstanceState);
		setContentView(R.layout.adddelete_folder_layout);
		
		add_Button=(ImageButton)findViewById(R.id.addfolder_button);
		mlistView=(ListView)findViewById(R.id.deletefolder_list);
		
		folder_list.add("����Ԫ");
		folder_list.add("ģ��TODO");
		folder_list.add("����Ԫ");
		FolderListAdapter adapter=new FolderListAdapter();
		//�ļ����б�ļ����������Զ���alertdialog
		mlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
			int position, long id) {
			// TODO Auto-generated method stub
			final AlertDialog ad=new AlertDialog(AddDeleteFolderActivity.this);
			ad.setTitle("�༭����");
			ad.setMessage("�������µ���������");
			ad.setNegativeButton("ȡ��", new OnClickListener() {
 
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						ad.dismiss();					
					}
				});
			
			ad.setPositiveButton("ȷ��", new OnClickListener() { 
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
					/*if(ad.getEditText()!="")
					{
					 str=ad.getEditText();
					 Toast.makeText(getApplication(),str, Toast.LENGTH_LONG).show();
					}else
					{*/
					ad.dismiss();
					//}
				}
			});
			
			}
			});
		
		
		mlistView.setAdapter(adapter);
		
		//����ļ��а�ť�����������Ի���
		add_Button.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				final AlertDialog ad=new AlertDialog(AddDeleteFolderActivity.this);						
				
				ad.setTitle("����ļ���");
				ad.setMessage("�������µ��ļ�������");				               
				ad.setNegativeButton("ȡ��", new OnClickListener() {
 
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						ad.dismiss();					
					}
				});

				ad.setPositiveButton("ȷ��", new OnClickListener() { 
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						
						/*if(ad.getEditText()!="")
						{
						 str=ad.getEditText();
						 //
						}else
						{*/
						ad.dismiss();
						//}
					}
				});
			}
		});
		
	}
	
	  //�ļ����б���ʾ������
	  class FolderListAdapter extends BaseAdapter{  
		  
	        @Override  
	        public int getCount() {  
	            // TODO Auto-generated method stub  
	            return folder_list.size();  
	        }  
	  
	        @Override  
	        public Object getItem(int position) {  
	            // TODO Auto-generated method stub  
	            return folder_list.get(position);  
	        }  
	  
	        @Override  
	        public long getItemId(int position) {  
	            // TODO Auto-generated method stub  
	            return position;  
	        }  
	        
	        @Override
	        public boolean areAllItemsEnabled()
	        {
	            // all items are separator
	            return true;
	        }

	        @Override
	        public boolean isEnabled(int position)
	        {
	            // all items are separator
	            return true; 
	        }
	        
	        @Override  
	        public View getView(final int position, View convertView, ViewGroup parent) {  
	            // TODO Auto-generated method stub \
	        	
	            View view=convertView;  
	            view=LayoutInflater.from(getApplicationContext()).inflate(R.layout.delete_folder_item, null);                          	            
	            TextView text=(TextView)view.findViewById(R.id.delete_folder);
	            text.setText((String)folder_list.get(position));
	            ImageButton button=(ImageButton)view.findViewById(R.id.deletefolder_button);
	            final Button deleteButton=(Button)view.findViewById(R.id.delete_button);
	            //ɾ���ļ��а�ť����������ɾ����ť
	            button.setOnClickListener(new View.OnClickListener() {	            	
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						
						if(deleteButton!=null)
						{
						
							if(deleteButton.getVisibility()==View.VISIBLE)
							{
								deleteButton.setVisibility(View.GONE);								
								Animation animation = AnimationUtils.loadAnimation(
										AddDeleteFolderActivity.this, R.anim.push_right_out);  			              
								deleteButton.startAnimation(animation);																
							}else
							{
								deleteButton.setVisibility(View.VISIBLE);					
								Animation animation = AnimationUtils.loadAnimation(
										AddDeleteFolderActivity.this, R.anim.push_right_in);  			              
								deleteButton.startAnimation(animation); 								
							}
							
							//ɾ����ť����������ɾ��ȷ�϶Ի���
							deleteButton.setOnClickListener(new View.OnClickListener() {
								
								@Override
								public void onClick(View arg0) {
									final AlertDialog ad=new AlertDialog(AddDeleteFolderActivity.this);						
									
									ad.setTitle("��ʾ");
									ad.setMessage("ȷ��ɾ�����ļ�����");	
									ad.setEdit(false);
									ad.setNegativeButton("ȡ��", new OnClickListener() {
					                
										@Override
										public void onClick(View v) {
											// TODO Auto-generated method stub
											ad.dismiss();					
										}
									});

									ad.setPositiveButton("ȷ��", new OnClickListener() { 
										@Override
										public void onClick(View v) {
											// TODO Auto-generated method stub
											
											deleteButton.setVisibility(View.GONE);																				
											Animation animation = AnimationUtils.loadAnimation(
													AddDeleteFolderActivity.this, R.anim.push_right_out);  			              
											deleteButton.startAnimation(animation);		
											ad.dismiss();
											
										}
									});
								}
							});
						}						
							
					}
				});
	            
	            return view;  										   	             
	     }     
	}
}
	  					
