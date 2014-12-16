package androidsalvador.customlistview;

import java.util.ArrayList;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Adapter extends ArrayAdapter<Personagem>{
	
	
	private LayoutInflater mInflater;
	
	private ArrayList<Personagem> personagens;

	private int mViewResourceId;
	
	public Adapter(Context ctx, int viewResourceId,
			ArrayList<Personagem> personagens  ) {
		
		super(ctx, viewResourceId);
		
		mInflater = (LayoutInflater)ctx.getSystemService(
				Context.LAYOUT_INFLATER_SERVICE);
				
		mViewResourceId = viewResourceId;
		
		this.personagens = personagens;

	}
	
	@Override
	public int getCount() {
		return personagens.size();
	}

	@Override
	public Personagem getItem(int index) {
		return personagens.get(index);
	}

	@Override
	public long getItemId(int index) {
		return personagens.get(index).pos;
	}

	@Override
	public View getView(int index, View convertView, ViewGroup parent) {		
	    if (convertView == null) {
	    	convertView = mInflater.inflate(mViewResourceId, null);
	    }
		

		TextView tv = (TextView)convertView.findViewById(R.id.nome);
		tv.setText(personagens.get(index).nome);
		
		TextView tv1 = (TextView)convertView.findViewById(R.id.classe);
		tv1.setText(personagens.get(index).classe);
		
		ImageView image = (ImageView)convertView.findViewById(R.id.figura);					
		image.setImageResource(personagens.get(index).figuraID);

		
		return convertView;
	}

}
