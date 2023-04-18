package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.ProxyUtils;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsList;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.Property;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class SalesProductEntityRealmProxy extends magicfinmart.datacomp.com.finmartserviceapi.finmart.model.SalesProductEntity
    implements RealmObjectProxy, SalesProductEntityRealmProxyInterface {

    static final class SalesProductEntityColumnInfo extends ColumnInfo {
        long Product_IdIndex;
        long Product_NameIndex;
        long Product_imageIndex;
        long CountIndex;
        long OldCountIndex;

        SalesProductEntityColumnInfo(OsSchemaInfo schemaInfo) {
            super(5);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("SalesProductEntity");
            this.Product_IdIndex = addColumnDetails("Product_Id", objectSchemaInfo);
            this.Product_NameIndex = addColumnDetails("Product_Name", objectSchemaInfo);
            this.Product_imageIndex = addColumnDetails("Product_image", objectSchemaInfo);
            this.CountIndex = addColumnDetails("Count", objectSchemaInfo);
            this.OldCountIndex = addColumnDetails("OldCount", objectSchemaInfo);
        }

        SalesProductEntityColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new SalesProductEntityColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final SalesProductEntityColumnInfo src = (SalesProductEntityColumnInfo) rawSrc;
            final SalesProductEntityColumnInfo dst = (SalesProductEntityColumnInfo) rawDst;
            dst.Product_IdIndex = src.Product_IdIndex;
            dst.Product_NameIndex = src.Product_NameIndex;
            dst.Product_imageIndex = src.Product_imageIndex;
            dst.CountIndex = src.CountIndex;
            dst.OldCountIndex = src.OldCountIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>(5);
        fieldNames.add("Product_Id");
        fieldNames.add("Product_Name");
        fieldNames.add("Product_image");
        fieldNames.add("Count");
        fieldNames.add("OldCount");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    private SalesProductEntityColumnInfo columnInfo;
    private ProxyState<magicfinmart.datacomp.com.finmartserviceapi.finmart.model.SalesProductEntity> proxyState;

    SalesProductEntityRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (SalesProductEntityColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<magicfinmart.datacomp.com.finmartserviceapi.finmart.model.SalesProductEntity>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$Product_Id() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.Product_IdIndex);
    }

    @Override
    public void realmSet$Product_Id(int value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'Product_Id' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$Product_Name() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.Product_NameIndex);
    }

    @Override
    public void realmSet$Product_Name(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.Product_NameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.Product_NameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.Product_NameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.Product_NameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$Product_image() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.Product_imageIndex);
    }

    @Override
    public void realmSet$Product_image(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.Product_imageIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.Product_imageIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.Product_imageIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.Product_imageIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$Count() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.CountIndex);
    }

    @Override
    public void realmSet$Count(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.CountIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.CountIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$OldCount() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.OldCountIndex);
    }

    @Override
    public void realmSet$OldCount(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.OldCountIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.OldCountIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("SalesProductEntity", 5, 0);
        builder.addPersistedProperty("Product_Id", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("Product_Name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("Product_image", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("Count", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("OldCount", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static SalesProductEntityColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new SalesProductEntityColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "SalesProductEntity";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static magicfinmart.datacomp.com.finmartserviceapi.finmart.model.SalesProductEntity createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        magicfinmart.datacomp.com.finmartserviceapi.finmart.model.SalesProductEntity obj = null;
        if (update) {
            Table table = realm.getTable(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.SalesProductEntity.class);
            SalesProductEntityColumnInfo columnInfo = (SalesProductEntityColumnInfo) realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.SalesProductEntity.class);
            long pkColumnIndex = columnInfo.Product_IdIndex;
            long rowIndex = Table.NO_MATCH;
            if (!json.isNull("Product_Id")) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("Product_Id"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.SalesProductEntity.class), false, Collections.<String> emptyList());
                    obj = new io.realm.SalesProductEntityRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("Product_Id")) {
                if (json.isNull("Product_Id")) {
                    obj = (io.realm.SalesProductEntityRealmProxy) realm.createObjectInternal(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.SalesProductEntity.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.SalesProductEntityRealmProxy) realm.createObjectInternal(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.SalesProductEntity.class, json.getInt("Product_Id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'Product_Id'.");
            }
        }

        final SalesProductEntityRealmProxyInterface objProxy = (SalesProductEntityRealmProxyInterface) obj;
        if (json.has("Product_Name")) {
            if (json.isNull("Product_Name")) {
                objProxy.realmSet$Product_Name(null);
            } else {
                objProxy.realmSet$Product_Name((String) json.getString("Product_Name"));
            }
        }
        if (json.has("Product_image")) {
            if (json.isNull("Product_image")) {
                objProxy.realmSet$Product_image(null);
            } else {
                objProxy.realmSet$Product_image((String) json.getString("Product_image"));
            }
        }
        if (json.has("Count")) {
            if (json.isNull("Count")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'Count' to null.");
            } else {
                objProxy.realmSet$Count((int) json.getInt("Count"));
            }
        }
        if (json.has("OldCount")) {
            if (json.isNull("OldCount")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'OldCount' to null.");
            } else {
                objProxy.realmSet$OldCount((int) json.getInt("OldCount"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static magicfinmart.datacomp.com.finmartserviceapi.finmart.model.SalesProductEntity createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final magicfinmart.datacomp.com.finmartserviceapi.finmart.model.SalesProductEntity obj = new magicfinmart.datacomp.com.finmartserviceapi.finmart.model.SalesProductEntity();
        final SalesProductEntityRealmProxyInterface objProxy = (SalesProductEntityRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("Product_Id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$Product_Id((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'Product_Id' to null.");
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("Product_Name")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$Product_Name((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$Product_Name(null);
                }
            } else if (name.equals("Product_image")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$Product_image((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$Product_image(null);
                }
            } else if (name.equals("Count")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$Count((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'Count' to null.");
                }
            } else if (name.equals("OldCount")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$OldCount((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'OldCount' to null.");
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'Product_Id'.");
        }
        return realm.copyToRealm(obj);
    }

    public static magicfinmart.datacomp.com.finmartserviceapi.finmart.model.SalesProductEntity copyOrUpdate(Realm realm, magicfinmart.datacomp.com.finmartserviceapi.finmart.model.SalesProductEntity object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null) {
            final BaseRealm otherRealm = ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm();
            if (otherRealm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            }
            if (otherRealm.getPath().equals(realm.getPath())) {
                return object;
            }
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.SalesProductEntity) cachedRealmObject;
        }

        magicfinmart.datacomp.com.finmartserviceapi.finmart.model.SalesProductEntity realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.SalesProductEntity.class);
            SalesProductEntityColumnInfo columnInfo = (SalesProductEntityColumnInfo) realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.SalesProductEntity.class);
            long pkColumnIndex = columnInfo.Product_IdIndex;
            long rowIndex = table.findFirstLong(pkColumnIndex, ((SalesProductEntityRealmProxyInterface) object).realmGet$Product_Id());
            if (rowIndex == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.SalesProductEntity.class), false, Collections.<String> emptyList());
                    realmObject = new io.realm.SalesProductEntityRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, realmObject, object, cache) : copy(realm, object, update, cache);
    }

    public static magicfinmart.datacomp.com.finmartserviceapi.finmart.model.SalesProductEntity copy(Realm realm, magicfinmart.datacomp.com.finmartserviceapi.finmart.model.SalesProductEntity newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.SalesProductEntity) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        magicfinmart.datacomp.com.finmartserviceapi.finmart.model.SalesProductEntity realmObject = realm.createObjectInternal(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.SalesProductEntity.class, ((SalesProductEntityRealmProxyInterface) newObject).realmGet$Product_Id(), false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        SalesProductEntityRealmProxyInterface realmObjectSource = (SalesProductEntityRealmProxyInterface) newObject;
        SalesProductEntityRealmProxyInterface realmObjectCopy = (SalesProductEntityRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$Product_Name(realmObjectSource.realmGet$Product_Name());
        realmObjectCopy.realmSet$Product_image(realmObjectSource.realmGet$Product_image());
        realmObjectCopy.realmSet$Count(realmObjectSource.realmGet$Count());
        realmObjectCopy.realmSet$OldCount(realmObjectSource.realmGet$OldCount());
        return realmObject;
    }

    public static long insert(Realm realm, magicfinmart.datacomp.com.finmartserviceapi.finmart.model.SalesProductEntity object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.SalesProductEntity.class);
        long tableNativePtr = table.getNativePtr();
        SalesProductEntityColumnInfo columnInfo = (SalesProductEntityColumnInfo) realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.SalesProductEntity.class);
        long pkColumnIndex = columnInfo.Product_IdIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((SalesProductEntityRealmProxyInterface) object).realmGet$Product_Id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((SalesProductEntityRealmProxyInterface) object).realmGet$Product_Id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((SalesProductEntityRealmProxyInterface) object).realmGet$Product_Id());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$Product_Name = ((SalesProductEntityRealmProxyInterface) object).realmGet$Product_Name();
        if (realmGet$Product_Name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.Product_NameIndex, rowIndex, realmGet$Product_Name, false);
        }
        String realmGet$Product_image = ((SalesProductEntityRealmProxyInterface) object).realmGet$Product_image();
        if (realmGet$Product_image != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.Product_imageIndex, rowIndex, realmGet$Product_image, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.CountIndex, rowIndex, ((SalesProductEntityRealmProxyInterface) object).realmGet$Count(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.OldCountIndex, rowIndex, ((SalesProductEntityRealmProxyInterface) object).realmGet$OldCount(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.SalesProductEntity.class);
        long tableNativePtr = table.getNativePtr();
        SalesProductEntityColumnInfo columnInfo = (SalesProductEntityColumnInfo) realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.SalesProductEntity.class);
        long pkColumnIndex = columnInfo.Product_IdIndex;
        magicfinmart.datacomp.com.finmartserviceapi.finmart.model.SalesProductEntity object = null;
        while (objects.hasNext()) {
            object = (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.SalesProductEntity) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((SalesProductEntityRealmProxyInterface) object).realmGet$Product_Id();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((SalesProductEntityRealmProxyInterface) object).realmGet$Product_Id());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((SalesProductEntityRealmProxyInterface) object).realmGet$Product_Id());
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, rowIndex);
            String realmGet$Product_Name = ((SalesProductEntityRealmProxyInterface) object).realmGet$Product_Name();
            if (realmGet$Product_Name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.Product_NameIndex, rowIndex, realmGet$Product_Name, false);
            }
            String realmGet$Product_image = ((SalesProductEntityRealmProxyInterface) object).realmGet$Product_image();
            if (realmGet$Product_image != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.Product_imageIndex, rowIndex, realmGet$Product_image, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.CountIndex, rowIndex, ((SalesProductEntityRealmProxyInterface) object).realmGet$Count(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.OldCountIndex, rowIndex, ((SalesProductEntityRealmProxyInterface) object).realmGet$OldCount(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, magicfinmart.datacomp.com.finmartserviceapi.finmart.model.SalesProductEntity object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.SalesProductEntity.class);
        long tableNativePtr = table.getNativePtr();
        SalesProductEntityColumnInfo columnInfo = (SalesProductEntityColumnInfo) realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.SalesProductEntity.class);
        long pkColumnIndex = columnInfo.Product_IdIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((SalesProductEntityRealmProxyInterface) object).realmGet$Product_Id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((SalesProductEntityRealmProxyInterface) object).realmGet$Product_Id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((SalesProductEntityRealmProxyInterface) object).realmGet$Product_Id());
        }
        cache.put(object, rowIndex);
        String realmGet$Product_Name = ((SalesProductEntityRealmProxyInterface) object).realmGet$Product_Name();
        if (realmGet$Product_Name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.Product_NameIndex, rowIndex, realmGet$Product_Name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.Product_NameIndex, rowIndex, false);
        }
        String realmGet$Product_image = ((SalesProductEntityRealmProxyInterface) object).realmGet$Product_image();
        if (realmGet$Product_image != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.Product_imageIndex, rowIndex, realmGet$Product_image, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.Product_imageIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.CountIndex, rowIndex, ((SalesProductEntityRealmProxyInterface) object).realmGet$Count(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.OldCountIndex, rowIndex, ((SalesProductEntityRealmProxyInterface) object).realmGet$OldCount(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.SalesProductEntity.class);
        long tableNativePtr = table.getNativePtr();
        SalesProductEntityColumnInfo columnInfo = (SalesProductEntityColumnInfo) realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.SalesProductEntity.class);
        long pkColumnIndex = columnInfo.Product_IdIndex;
        magicfinmart.datacomp.com.finmartserviceapi.finmart.model.SalesProductEntity object = null;
        while (objects.hasNext()) {
            object = (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.SalesProductEntity) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((SalesProductEntityRealmProxyInterface) object).realmGet$Product_Id();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((SalesProductEntityRealmProxyInterface) object).realmGet$Product_Id());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((SalesProductEntityRealmProxyInterface) object).realmGet$Product_Id());
            }
            cache.put(object, rowIndex);
            String realmGet$Product_Name = ((SalesProductEntityRealmProxyInterface) object).realmGet$Product_Name();
            if (realmGet$Product_Name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.Product_NameIndex, rowIndex, realmGet$Product_Name, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.Product_NameIndex, rowIndex, false);
            }
            String realmGet$Product_image = ((SalesProductEntityRealmProxyInterface) object).realmGet$Product_image();
            if (realmGet$Product_image != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.Product_imageIndex, rowIndex, realmGet$Product_image, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.Product_imageIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.CountIndex, rowIndex, ((SalesProductEntityRealmProxyInterface) object).realmGet$Count(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.OldCountIndex, rowIndex, ((SalesProductEntityRealmProxyInterface) object).realmGet$OldCount(), false);
        }
    }

    public static magicfinmart.datacomp.com.finmartserviceapi.finmart.model.SalesProductEntity createDetachedCopy(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.SalesProductEntity realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        magicfinmart.datacomp.com.finmartserviceapi.finmart.model.SalesProductEntity unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new magicfinmart.datacomp.com.finmartserviceapi.finmart.model.SalesProductEntity();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.SalesProductEntity) cachedObject.object;
            }
            unmanagedObject = (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.SalesProductEntity) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        SalesProductEntityRealmProxyInterface unmanagedCopy = (SalesProductEntityRealmProxyInterface) unmanagedObject;
        SalesProductEntityRealmProxyInterface realmSource = (SalesProductEntityRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$Product_Id(realmSource.realmGet$Product_Id());
        unmanagedCopy.realmSet$Product_Name(realmSource.realmGet$Product_Name());
        unmanagedCopy.realmSet$Product_image(realmSource.realmGet$Product_image());
        unmanagedCopy.realmSet$Count(realmSource.realmGet$Count());
        unmanagedCopy.realmSet$OldCount(realmSource.realmGet$OldCount());

        return unmanagedObject;
    }

    static magicfinmart.datacomp.com.finmartserviceapi.finmart.model.SalesProductEntity update(Realm realm, magicfinmart.datacomp.com.finmartserviceapi.finmart.model.SalesProductEntity realmObject, magicfinmart.datacomp.com.finmartserviceapi.finmart.model.SalesProductEntity newObject, Map<RealmModel, RealmObjectProxy> cache) {
        SalesProductEntityRealmProxyInterface realmObjectTarget = (SalesProductEntityRealmProxyInterface) realmObject;
        SalesProductEntityRealmProxyInterface realmObjectSource = (SalesProductEntityRealmProxyInterface) newObject;
        realmObjectTarget.realmSet$Product_Name(realmObjectSource.realmGet$Product_Name());
        realmObjectTarget.realmSet$Product_image(realmObjectSource.realmGet$Product_image());
        realmObjectTarget.realmSet$Count(realmObjectSource.realmGet$Count());
        realmObjectTarget.realmSet$OldCount(realmObjectSource.realmGet$OldCount());
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("SalesProductEntity = proxy[");
        stringBuilder.append("{Product_Id:");
        stringBuilder.append(realmGet$Product_Id());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{Product_Name:");
        stringBuilder.append(realmGet$Product_Name() != null ? realmGet$Product_Name() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{Product_image:");
        stringBuilder.append(realmGet$Product_image() != null ? realmGet$Product_image() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{Count:");
        stringBuilder.append(realmGet$Count());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{OldCount:");
        stringBuilder.append(realmGet$OldCount());
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalesProductEntityRealmProxy aSalesProductEntity = (SalesProductEntityRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aSalesProductEntity.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aSalesProductEntity.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aSalesProductEntity.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
