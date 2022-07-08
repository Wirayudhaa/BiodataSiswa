package com.Kelompok1.biodatasiswa.database;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;

@SuppressWarnings("unchecked")
public final class SiswaDatabase_Impl extends SiswaDatabase {
  private volatile KelasDao _kelasDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(2) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `kelas` (`id_kelas` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `nama_kelas` TEXT, `nama_wali` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `tb_siswa` (`id_siswa` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `id_kelas` INTEGER NOT NULL, `nama_siswa` TEXT, `umur` TEXT, `jenis_kelamin` TEXT, `asal` TEXT, `email` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"7f9764f2af03b7672084c705aefd3027\")");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `kelas`");
        _db.execSQL("DROP TABLE IF EXISTS `tb_siswa`");
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsKelas = new HashMap<String, TableInfo.Column>(3);
        _columnsKelas.put("id_kelas", new TableInfo.Column("id_kelas", "INTEGER", true, 1));
        _columnsKelas.put("nama_kelas", new TableInfo.Column("nama_kelas", "TEXT", false, 0));
        _columnsKelas.put("nama_wali", new TableInfo.Column("nama_wali", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysKelas = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesKelas = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoKelas = new TableInfo("kelas", _columnsKelas, _foreignKeysKelas, _indicesKelas);
        final TableInfo _existingKelas = TableInfo.read(_db, "kelas");
        if (! _infoKelas.equals(_existingKelas)) {
          throw new IllegalStateException("Migration didn't properly handle kelas(com.Kelompok1.biodatasiswa.model.KelasModel).\n"
                  + " Expected:\n" + _infoKelas + "\n"
                  + " Found:\n" + _existingKelas);
        }
        final HashMap<String, TableInfo.Column> _columnsTbSiswa = new HashMap<String, TableInfo.Column>(7);
        _columnsTbSiswa.put("id_siswa", new TableInfo.Column("id_siswa", "INTEGER", true, 1));
        _columnsTbSiswa.put("id_kelas", new TableInfo.Column("id_kelas", "INTEGER", true, 0));
        _columnsTbSiswa.put("nama_siswa", new TableInfo.Column("nama_siswa", "TEXT", false, 0));
        _columnsTbSiswa.put("umur", new TableInfo.Column("umur", "TEXT", false, 0));
        _columnsTbSiswa.put("jenis_kelamin", new TableInfo.Column("jenis_kelamin", "TEXT", false, 0));
        _columnsTbSiswa.put("asal", new TableInfo.Column("asal", "TEXT", false, 0));
        _columnsTbSiswa.put("email", new TableInfo.Column("email", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTbSiswa = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTbSiswa = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTbSiswa = new TableInfo("tb_siswa", _columnsTbSiswa, _foreignKeysTbSiswa, _indicesTbSiswa);
        final TableInfo _existingTbSiswa = TableInfo.read(_db, "tb_siswa");
        if (! _infoTbSiswa.equals(_existingTbSiswa)) {
          throw new IllegalStateException("Migration didn't properly handle tb_siswa(com.Kelompok1.biodatasiswa.model.SiswaModel).\n"
                  + " Expected:\n" + _infoTbSiswa + "\n"
                  + " Found:\n" + _existingTbSiswa);
        }
      }
    }, "7f9764f2af03b7672084c705aefd3027", "d17e775004afc9891d2bb0c87ac2c339");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "kelas","tb_siswa");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `kelas`");
      _db.execSQL("DELETE FROM `tb_siswa`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public KelasDao kelasDao() {
    if (_kelasDao != null) {
      return _kelasDao;
    } else {
      synchronized(this) {
        if(_kelasDao == null) {
          _kelasDao = new KelasDao_Impl(this);
        }
        return _kelasDao;
      }
    }
  }
}
