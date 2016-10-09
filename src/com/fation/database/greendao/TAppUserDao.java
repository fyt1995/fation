package com.fation.database.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import com.fation.database.greendao.TAppUser;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table TAPP_USER.
*/
public class TAppUserDao extends AbstractDao<TAppUser, Long> {

    public static final String TABLENAME = "TAPP_USER";

    /**
     * Properties of entity TAppUser.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Xm = new Property(1, String.class, "xm", false, "XM");
        public final static Property Zh = new Property(2, String.class, "zh", false, "ZH");
        public final static Property Mm = new Property(3, String.class, "mm", false, "MM");
        public final static Property Xb = new Property(4, Integer.class, "xb", false, "XB");
        public final static Property Csrq = new Property(5, java.util.Date.class, "csrq", false, "CSRQ");
        public final static Property Lxfs = new Property(6, String.class, "lxfs", false, "LXFS");
        public final static Property Cjsj = new Property(7, java.util.Date.class, "cjsj", false, "CJSJ");
        public final static Property Xgsj = new Property(8, java.util.Date.class, "xgsj", false, "XGSJ");
    };


    public TAppUserDao(DaoConfig config) {
        super(config);
    }
    
    public TAppUserDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'TAPP_USER' (" + //
                "'_id' INTEGER PRIMARY KEY ," + // 0: id
                "'XM' TEXT NOT NULL ," + // 1: xm
                "'ZH' TEXT NOT NULL ," + // 2: zh
                "'MM' TEXT NOT NULL ," + // 3: mm
                "'XB' INTEGER," + // 4: xb
                "'CSRQ' INTEGER," + // 5: csrq
                "'LXFS' TEXT," + // 6: lxfs
                "'CJSJ' INTEGER," + // 7: cjsj
                "'XGSJ' INTEGER);"); // 8: xgsj
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'TAPP_USER'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, TAppUser entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, entity.getXm());
        stmt.bindString(3, entity.getZh());
        stmt.bindString(4, entity.getMm());
 
        Integer xb = entity.getXb();
        if (xb != null) {
            stmt.bindLong(5, xb);
        }
 
        java.util.Date csrq = entity.getCsrq();
        if (csrq != null) {
            stmt.bindLong(6, csrq.getTime());
        }
 
        String lxfs = entity.getLxfs();
        if (lxfs != null) {
            stmt.bindString(7, lxfs);
        }
 
        java.util.Date cjsj = entity.getCjsj();
        if (cjsj != null) {
            stmt.bindLong(8, cjsj.getTime());
        }
 
        java.util.Date xgsj = entity.getXgsj();
        if (xgsj != null) {
            stmt.bindLong(9, xgsj.getTime());
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public TAppUser readEntity(Cursor cursor, int offset) {
        TAppUser entity = new TAppUser( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getString(offset + 1), // xm
            cursor.getString(offset + 2), // zh
            cursor.getString(offset + 3), // mm
            cursor.isNull(offset + 4) ? null : cursor.getInt(offset + 4), // xb
            cursor.isNull(offset + 5) ? null : new java.util.Date(cursor.getLong(offset + 5)), // csrq
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // lxfs
            cursor.isNull(offset + 7) ? null : new java.util.Date(cursor.getLong(offset + 7)), // cjsj
            cursor.isNull(offset + 8) ? null : new java.util.Date(cursor.getLong(offset + 8)) // xgsj
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, TAppUser entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setXm(cursor.getString(offset + 1));
        entity.setZh(cursor.getString(offset + 2));
        entity.setMm(cursor.getString(offset + 3));
        entity.setXb(cursor.isNull(offset + 4) ? null : cursor.getInt(offset + 4));
        entity.setCsrq(cursor.isNull(offset + 5) ? null : new java.util.Date(cursor.getLong(offset + 5)));
        entity.setLxfs(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setCjsj(cursor.isNull(offset + 7) ? null : new java.util.Date(cursor.getLong(offset + 7)));
        entity.setXgsj(cursor.isNull(offset + 8) ? null : new java.util.Date(cursor.getLong(offset + 8)));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(TAppUser entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(TAppUser entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}
