package com.xzh.kingtv.dao.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import com.xzh.kingtv.bean.LiveCategory;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;



public class LiveCategoryDao extends AbstractDao<LiveCategory, Long> {

    public static final String TABLENAME = "LIVE_CATEGORY";

    /**
     * Properties of entity LiveCategory.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, long.class, "id", true, "_id");
        public final static Property Name = new Property(1, String.class, "name", false, "NAME");
        public final static Property Is_default = new Property(2, int.class, "is_default", false, "IS_DEFAULT");
        public final static Property Sort = new Property(3, int.class, "sort", false, "SORT");
        public final static Property Icon_gray = new Property(4, String.class, "icon_gray", false, "ICON_GRAY");
        public final static Property Icon_red = new Property(5, String.class, "icon_red", false, "ICON_RED");
        public final static Property Icon_image = new Property(6, String.class, "icon_image", false, "ICON_IMAGE");
        public final static Property Slug = new Property(7, String.class, "slug", false, "SLUG");
        public final static Property Type = new Property(8, int.class, "type", false, "TYPE");
        public final static Property Screen = new Property(9, int.class, "screen", false, "SCREEN");
    }


    public LiveCategoryDao(DaoConfig config) {
        super(config);
    }
    
    public LiveCategoryDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"LIVE_CATEGORY\" (" + //
                "\"_id\" INTEGER PRIMARY KEY NOT NULL ," + // 0: id
                "\"NAME\" TEXT," + // 1: name
                "\"IS_DEFAULT\" INTEGER NOT NULL ," + // 2: is_default
                "\"SORT\" INTEGER NOT NULL ," + // 3: sort
                "\"ICON_GRAY\" TEXT," + // 4: icon_gray
                "\"ICON_RED\" TEXT," + // 5: icon_red
                "\"ICON_IMAGE\" TEXT," + // 6: icon_image
                "\"SLUG\" TEXT," + // 7: slug
                "\"TYPE\" INTEGER NOT NULL ," + // 8: type
                "\"SCREEN\" INTEGER NOT NULL );"); // 9: screen
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"LIVE_CATEGORY\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, LiveCategory entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
        stmt.bindLong(3, entity.getIs_default());
        stmt.bindLong(4, entity.getSort());
 
        String icon_gray = entity.getIcon_gray();
        if (icon_gray != null) {
            stmt.bindString(5, icon_gray);
        }
 
        String icon_red = entity.getIcon_red();
        if (icon_red != null) {
            stmt.bindString(6, icon_red);
        }
 
        String icon_image = entity.getIcon_image();
        if (icon_image != null) {
            stmt.bindString(7, icon_image);
        }
 
        String slug = entity.getSlug();
        if (slug != null) {
            stmt.bindString(8, slug);
        }
        stmt.bindLong(9, entity.getType());
        stmt.bindLong(10, entity.getScreen());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, LiveCategory entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
        stmt.bindLong(3, entity.getIs_default());
        stmt.bindLong(4, entity.getSort());
 
        String icon_gray = entity.getIcon_gray();
        if (icon_gray != null) {
            stmt.bindString(5, icon_gray);
        }
 
        String icon_red = entity.getIcon_red();
        if (icon_red != null) {
            stmt.bindString(6, icon_red);
        }
 
        String icon_image = entity.getIcon_image();
        if (icon_image != null) {
            stmt.bindString(7, icon_image);
        }
 
        String slug = entity.getSlug();
        if (slug != null) {
            stmt.bindString(8, slug);
        }
        stmt.bindLong(9, entity.getType());
        stmt.bindLong(10, entity.getScreen());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.getLong(offset + 0);
    }    

    @Override
    public LiveCategory readEntity(Cursor cursor, int offset) {
        LiveCategory entity = new LiveCategory( //
            cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // name
            cursor.getInt(offset + 2), // is_default
            cursor.getInt(offset + 3), // sort
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // icon_gray
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // icon_red
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // icon_image
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // slug
            cursor.getInt(offset + 8), // type
            cursor.getInt(offset + 9) // screen
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, LiveCategory entity, int offset) {
        entity.setId(cursor.getLong(offset + 0));
        entity.setName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setIs_default(cursor.getInt(offset + 2));
        entity.setSort(cursor.getInt(offset + 3));
        entity.setIcon_gray(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setIcon_red(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setIcon_image(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setSlug(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setType(cursor.getInt(offset + 8));
        entity.setScreen(cursor.getInt(offset + 9));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(LiveCategory entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(LiveCategory entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(LiveCategory entity) {
        throw new UnsupportedOperationException("Unsupported for entities with a non-null key");
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
