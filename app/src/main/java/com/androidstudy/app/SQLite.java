package com.androidstudy.app;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class SQLite extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.sqlite, menu);
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

    private class MySQLiteHelper extends SQLiteOpenHelper {

        private static final String DB_NAME = "android_study_db";
        private static final int DB_VERSION = 1;

        private static final String CREATE_TABLE_MONSTERS = "CREATE TABLE pokemon ( "
                + "id INTEGER PRIMARY KEY,"
                + "name TEXT, "
                + "H INTEGER NOT NULL, "
                + "A INTEGER NOT NULL, "
                + "B INTEGER NOT NULL, "
                + "C INTEGER NOT NULL, "
                + "D INTEGER NOT NULL, "
                + "S INTEGER NOT NULL)";
        private static final String CREATE_TABLE_SKILLS = "CREATE TABLE skills ( "
                + "id INTEGER PRIMARY KEY, "
                + "monster_id REFERENCES monster(_id), "
                + "name TEXT )";

        public MySQLiteHelper(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_TABLE_MONSTERS);
            db.execSQL(CREATE_TABLE_SKILLS);
            loadMasterData(db);
        }

        private void loadMasterData(SQLiteDatabase db) {
            // pokemon data
            String insertMonster = "INSERT INTO pokemon(id, name, h, a, b, c, d, s) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            db.execSQL(insertMonster, new Object[] {1, "フシギバナ", 80, 82, 83, 100, 100, 80});
            db.execSQL(insertMonster, new Object[] {2, "ミロカロス", 95, 60, 79, 100, 125, 81});
            db.execSQL(insertMonster, new Object[] {3, "グライオン", 75, 95, 125, 45, 75, 95});

            // skill data
            String insertSkill = "INSERT INTO skills(id, monster_id, name) VALUES (?, ?, ?)";
            db.execSQL(insertSkill, new Object[] {1, 1, "ギガドレイン"});
            db.execSQL(insertSkill, new Object[] {2, 1, "ヘドロばくだん"});
            db.execSQL(insertSkill, new Object[] {3, 1, "やどりぎのタネ"});;
            db.execSQL(insertSkill, new Object[] {4, 1, "ねむりごな"});

            db.execSQL(insertSkill, new Object[] {5, 2, "ハイドロポンプ"});
            db.execSQL(insertSkill, new Object[] {6, 2, "れいとうビーム"});
            db.execSQL(insertSkill, new Object[] {7, 2, "りゅうのはどう"});;
            db.execSQL(insertSkill, new Object[] {8, 2, "さいみんじゅつ"});

            db.execSQL(insertSkill, new Object[] {9, 3, "じしん"});
            db.execSQL(insertSkill, new Object[] {10, 3, "はさみギロチン"});
            db.execSQL(insertSkill, new Object[] {11, 3, "まもる"});
            db.execSQL(insertSkill, new Object[] {12, 3, "みがわり"});
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int i, int i2) {
            db.execSQL("DROP TABLE pokemon");
            db.execSQL("DROP TABLE skills");
            onCreate(db);
        }
    }
}
