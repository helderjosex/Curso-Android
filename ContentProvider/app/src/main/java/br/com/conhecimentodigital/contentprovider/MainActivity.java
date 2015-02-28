package br.com.conhecimentodigital.contentprovider;

import android.app.ListActivity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;


public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String [] contacts = readContacts();

        setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,contacts));

    }

    private String[] readContacts(){
        String[] columns = new String[] {ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,ContactsContract.CommonDataKinds.Phone.NUMBER};
        Uri uriContacts = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;

        Cursor cur = this.getContentResolver().query(uriContacts, columns, null, null, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " ASC");

        String[] contacts = new String[cur.getCount()];

        int i=0;
        while(cur.moveToNext()){

            String name = cur.getString(cur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            String phone =  cur.getString(cur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

            contacts[i] = name + " ( " + phone + ")";

            i++;
        }

        return contacts;


    }

}
