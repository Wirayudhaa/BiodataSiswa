package com.Kelompok1.biodatasiswa.database;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.Kelompok1.biodatasiswa.model.KelasModel;
import com.Kelompok1.biodatasiswa.model.SiswaModel;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public final class KelasDao_Impl implements KelasDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfKelasModel;

  private final EntityInsertionAdapter __insertionAdapterOfSiswaModel;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfKelasModel;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfSiswaModel;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfKelasModel;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfSiswaModel;

  public KelasDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfKelasModel = new EntityInsertionAdapter<KelasModel>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `kelas`(`id_kelas`,`nama_kelas`,`nama_wali`) VALUES (nullif(?, 0),?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, KelasModel value) {
        stmt.bindLong(1, value.getId_kelas());
        if (value.getNama_kelas() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNama_kelas());
        }
        if (value.getNama_wali() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getNama_wali());
        }
      }
    };
    this.__insertionAdapterOfSiswaModel = new EntityInsertionAdapter<SiswaModel>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `tb_siswa`(`id_siswa`,`id_kelas`,`nama_siswa`,`umur`,`jenis_kelamin`,`asal`,`email`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SiswaModel value) {
        stmt.bindLong(1, value.getId_siswa());
        stmt.bindLong(2, value.getId_kelas());
        if (value.getNama_siswa() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getNama_siswa());
        }
        if (value.getUmur() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getUmur());
        }
        if (value.getJenis_kelamin() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getJenis_kelamin());
        }
        if (value.getAsal() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getAsal());
        }
        if (value.getEmail() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getEmail());
        }
      }
    };
    this.__deletionAdapterOfKelasModel = new EntityDeletionOrUpdateAdapter<KelasModel>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `kelas` WHERE `id_kelas` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, KelasModel value) {
        stmt.bindLong(1, value.getId_kelas());
      }
    };
    this.__deletionAdapterOfSiswaModel = new EntityDeletionOrUpdateAdapter<SiswaModel>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `tb_siswa` WHERE `id_siswa` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SiswaModel value) {
        stmt.bindLong(1, value.getId_siswa());
      }
    };
    this.__updateAdapterOfKelasModel = new EntityDeletionOrUpdateAdapter<KelasModel>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `kelas` SET `id_kelas` = ?,`nama_kelas` = ?,`nama_wali` = ? WHERE `id_kelas` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, KelasModel value) {
        stmt.bindLong(1, value.getId_kelas());
        if (value.getNama_kelas() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNama_kelas());
        }
        if (value.getNama_wali() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getNama_wali());
        }
        stmt.bindLong(4, value.getId_kelas());
      }
    };
    this.__updateAdapterOfSiswaModel = new EntityDeletionOrUpdateAdapter<SiswaModel>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `tb_siswa` SET `id_siswa` = ?,`id_kelas` = ?,`nama_siswa` = ?,`umur` = ?,`jenis_kelamin` = ?,`asal` = ?,`email` = ? WHERE `id_siswa` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SiswaModel value) {
        stmt.bindLong(1, value.getId_siswa());
        stmt.bindLong(2, value.getId_kelas());
        if (value.getNama_siswa() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getNama_siswa());
        }
        if (value.getUmur() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getUmur());
        }
        if (value.getJenis_kelamin() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getJenis_kelamin());
        }
        if (value.getAsal() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getAsal());
        }
        if (value.getEmail() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getEmail());
        }
        stmt.bindLong(8, value.getId_siswa());
      }
    };
  }

  @Override
  public void insert(KelasModel kelasModel) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfKelasModel.insert(kelasModel);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertSiswa(SiswaModel siswaModel) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfSiswaModel.insert(siswaModel);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(KelasModel kelasModel) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfKelasModel.handle(kelasModel);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteSiswa(SiswaModel siswaModel) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfSiswaModel.handle(siswaModel);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(KelasModel kelasModel) {
    __db.beginTransaction();
    try {
      __updateAdapterOfKelasModel.handle(kelasModel);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateSiswa(SiswaModel siswaModel) {
    __db.beginTransaction();
    try {
      __updateAdapterOfSiswaModel.handle(siswaModel);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<KelasModel> select() {
    final String _sql = "SELECT * FROM KELAS ORDER BY nama_kelas ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfIdKelas = _cursor.getColumnIndexOrThrow("id_kelas");
      final int _cursorIndexOfNamaKelas = _cursor.getColumnIndexOrThrow("nama_kelas");
      final int _cursorIndexOfNamaWali = _cursor.getColumnIndexOrThrow("nama_wali");
      final List<KelasModel> _result = new ArrayList<KelasModel>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final KelasModel _item;
        _item = new KelasModel();
        final int _tmpId_kelas;
        _tmpId_kelas = _cursor.getInt(_cursorIndexOfIdKelas);
        _item.setId_kelas(_tmpId_kelas);
        final String _tmpNama_kelas;
        _tmpNama_kelas = _cursor.getString(_cursorIndexOfNamaKelas);
        _item.setNama_kelas(_tmpNama_kelas);
        final String _tmpNama_wali;
        _tmpNama_wali = _cursor.getString(_cursorIndexOfNamaWali);
        _item.setNama_wali(_tmpNama_wali);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<SiswaModel> selectSiswa(int id_kelas) {
    final String _sql = "SELECT * FROM TB_SISWA WHERE id_kelas = ? ORDER BY nama_siswa ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id_kelas);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfIdSiswa = _cursor.getColumnIndexOrThrow("id_siswa");
      final int _cursorIndexOfIdKelas = _cursor.getColumnIndexOrThrow("id_kelas");
      final int _cursorIndexOfNamaSiswa = _cursor.getColumnIndexOrThrow("nama_siswa");
      final int _cursorIndexOfUmur = _cursor.getColumnIndexOrThrow("umur");
      final int _cursorIndexOfJenisKelamin = _cursor.getColumnIndexOrThrow("jenis_kelamin");
      final int _cursorIndexOfAsal = _cursor.getColumnIndexOrThrow("asal");
      final int _cursorIndexOfEmail = _cursor.getColumnIndexOrThrow("email");
      final List<SiswaModel> _result = new ArrayList<SiswaModel>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final SiswaModel _item;
        _item = new SiswaModel();
        final int _tmpId_siswa;
        _tmpId_siswa = _cursor.getInt(_cursorIndexOfIdSiswa);
        _item.setId_siswa(_tmpId_siswa);
        final int _tmpId_kelas;
        _tmpId_kelas = _cursor.getInt(_cursorIndexOfIdKelas);
        _item.setId_kelas(_tmpId_kelas);
        final String _tmpNama_siswa;
        _tmpNama_siswa = _cursor.getString(_cursorIndexOfNamaSiswa);
        _item.setNama_siswa(_tmpNama_siswa);
        final String _tmpUmur;
        _tmpUmur = _cursor.getString(_cursorIndexOfUmur);
        _item.setUmur(_tmpUmur);
        final String _tmpJenis_kelamin;
        _tmpJenis_kelamin = _cursor.getString(_cursorIndexOfJenisKelamin);
        _item.setJenis_kelamin(_tmpJenis_kelamin);
        final String _tmpAsal;
        _tmpAsal = _cursor.getString(_cursorIndexOfAsal);
        _item.setAsal(_tmpAsal);
        final String _tmpEmail;
        _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
        _item.setEmail(_tmpEmail);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
