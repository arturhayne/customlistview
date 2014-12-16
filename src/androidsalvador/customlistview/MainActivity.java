package androidsalvador.customlistview;

import java.util.ArrayList;


import android.support.v7.app.ActionBarActivity;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class MainActivity extends ActionBarActivity {
	
	int pictures[] = {
			R.drawable.frodo,
			R.drawable.aragorn,
			R.drawable.legolas,
			R.drawable.gimli,
			R.drawable.gandalf
	};
	
	String names[] = {
			"Frodo",
			"Aragorn",
			"Legolas",
			"Gmili",
			"Gandalf"
	};
	
	
	String classe[] = {
			"Hobit",
			"Humano",
			"Elfo",
			"Anão",
			"Mago"
	};
	
	ListView mListView;
	
	ArrayList<Personagem> personagens;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		this.populePersonagens();
		
		mListView = (ListView)findViewById(R.id.listView1);
		
		mListView.setAdapter(new Adapter(getApplication(),
				R.layout.item, personagens));

		mListView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {				
				    Personagem per =  (Personagem) parent.getItemAtPosition(position);
				
					Toast toast = Toast.makeText(v.getContext(), per.nome, Toast.LENGTH_LONG);
					toast.show();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	
	private void populePersonagens(){
		
		personagens = new ArrayList<Personagem>();
		
		for (int i = 0; i < pictures.length; i++) {
			Personagem p = new Personagem();
			
			p.pos = i;
			p.figuraID = pictures[i];
			p.classe = classe[i];
			p.nome = names[i];
			
			personagens.add(p);
			
		}
		
	
	}
}
