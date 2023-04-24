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
public class MultiLangEntityRealmProxy extends magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MultiLangEntity
    implements RealmObjectProxy, MultiLangEntityRealmProxyInterface {

    static final class MultiLangEntityColumnInfo extends ColumnInfo {
        long IdIndex;
        long KeynameIndex;
        long EnglishIndex;
        long HindiIndex;
        long MarathiIndex;
        long GujrathiIndex;

        MultiLangEntityColumnInfo(OsSchemaInfo schemaInfo) {
            super(6);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("MultiLangEntity");
            this.IdIndex = addColumnDetails("Id", objectSchemaInfo);
            this.KeynameIndex = addColumnDetails("Keyname", objectSchemaInfo);
            this.EnglishIndex = addColumnDetails("English", objectSchemaInfo);
            this.HindiIndex = addColumnDetails("Hindi", objectSchemaInfo);
            this.MarathiIndex = addColumnDetails("Marathi", objectSchemaInfo);
            this.GujrathiIndex = addColumnDetails("Gujrathi", objectSchemaInfo);
        }

        MultiLangEntityColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new MultiLangEntityColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final MultiLangEntityColumnInfo src = (MultiLangEntityColumnInfo) rawSrc;
            final MultiLangEntityColumnInfo dst = (MultiLangEntityColumnInfo) rawDst;
            dst.IdIndex = src.IdIndex;
            dst.KeynameIndex = src.KeynameIndex;
            dst.EnglishIndex = src.EnglishIndex;
            dst.HindiIndex = src.HindiIndex;
            dst.MarathiIndex = src.MarathiIndex;
            dst.GujrathiIndex = src.GujrathiIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>(6);
        fieldNames.add("Id");
        fieldNames.add("Keyname");
        fieldNames.add("English");
        fieldNames.add("Hindi");
        fieldNames.add("Marathi");
        fieldNames.add("Gujrathi");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    private MultiLangEntityColumnInfo columnInfo;
    private ProxyState<magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MultiLangEntity> proxyState;

    MultiLangEntityRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (MultiLangEntityColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MultiLangEntity>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$Id() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.IdIndex);
    }

    @Override
    public void realmSet$Id(int value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'Id' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$Keyname() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.KeynameIndex);
    }

    @Override
    public void realmSet$Keyname(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.KeynameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.KeynameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.KeynameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.KeynameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$English() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.EnglishIndex);
    }

    @Override
    public void realmSet$English(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.EnglishIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.EnglishIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.EnglishIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.EnglishIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$Hindi() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.HindiIndex);
    }

    @Override
    public void realmSet$Hindi(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.HindiIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.HindiIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.HindiIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.HindiIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$Marathi() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.MarathiIndex);
    }

    @Override
    public void realmSet$Marathi(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.MarathiIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.MarathiIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.MarathiIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.MarathiIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$Gujrathi() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.GujrathiIndex);
    }

    @Override
    public void realmSet$Gujrathi(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.GujrathiIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.GujrathiIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.GujrathiIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.GujrathiIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("MultiLangEntity", 6, 0);
        builder.addPersistedProperty("Id", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("Keyname", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("English", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("Hindi", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("Marathi", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("Gujrathi", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static MultiLangEntityColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new MultiLangEntityColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "MultiLangEntity";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MultiLangEntity createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MultiLangEntity obj = null;
        if (update) {
            Table table = realm.getTable(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MultiLangEntity.class);
            MultiLangEntityColumnInfo columnInfo = (MultiLangEntityColumnInfo) realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MultiLangEntity.class);
            long pkColumnIndex = columnInfo.IdIndex;
            long rowIndex = Table.NO_MATCH;
            if (!json.isNull("Id")) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("Id"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MultiLangEntity.class), false, Collections.<String> emptyList());
                    obj = new io.realm.MultiLangEntityRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("Id")) {
                if (json.isNull("Id")) {
                    obj = (io.realm.MultiLangEntityRealmProxy) realm.createObjectInternal(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MultiLangEntity.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.MultiLangEntityRealmProxy) realm.createObjectInternal(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MultiLangEntity.class, json.getInt("Id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'Id'.");
            }
        }

        final MultiLangEntityRealmProxyInterface objProxy = (MultiLangEntityRealmProxyInterface) obj;
        if (json.has("Keyname")) {
            if (json.isNull("Keyname")) {
                objProxy.realmSet$Keyname(null);
            } else {
                objProxy.realmSet$Keyname((String) json.getString("Keyname"));
            }
        }
        if (json.has("English")) {
            if (json.isNull("English")) {
                objProxy.realmSet$English(null);
            } else {
                objProxy.realmSet$English((String) json.getString("English"));
            }
        }
        if (json.has("Hindi")) {
            if (json.isNull("Hindi")) {
                objProxy.realmSet$Hindi(null);
            } else {
                objProxy.realmSet$Hindi((String) json.getString("Hindi"));
            }
        }
        if (json.has("Marathi")) {
            if (json.isNull("Marathi")) {
                objProxy.realmSet$Marathi(null);
            } else {
                objProxy.realmSet$Marathi((String) json.getString("Marathi"));
            }
        }
        if (json.has("Gujrathi")) {
            if (json.isNull("Gujrathi")) {
                objProxy.realmSet$Gujrathi(null);
            } else {
                objProxy.realmSet$Gujrathi((String) json.getString("Gujrathi"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MultiLangEntity createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MultiLangEntity obj = new magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MultiLangEntity();
        final MultiLangEntityRealmProxyInterface objProxy = (MultiLangEntityRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("Id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$Id((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'Id' to null.");
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("Keyname")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$Keyname((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$Keyname(null);
                }
            } else if (name.equals("English")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$English((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$English(null);
                }
            } else if (name.equals("Hindi")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$Hindi((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$Hindi(null);
                }
            } else if (name.equals("Marathi")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$Marathi((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$Marathi(null);
                }
            } else if (name.equals("Gujrathi")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$Gujrathi((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$Gujrathi(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'Id'.");
        }
        return realm.copyToRealm(obj);
    }

    public static magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MultiLangEntity copyOrUpdate(Realm realm, magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MultiLangEntity object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MultiLangEntity) cachedRealmObject;
        }

        magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MultiLangEntity realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MultiLangEntity.class);
            MultiLangEntityColumnInfo columnInfo = (MultiLangEntityColumnInfo) realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MultiLangEntity.class);
            long pkColumnIndex = columnInfo.IdIndex;
            long rowIndex = table.findFirstLong(pkColumnIndex, ((MultiLangEntityRealmProxyInterface) object).realmGet$Id());
            if (rowIndex == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MultiLangEntity.class), false, Collections.<String> emptyList());
                    realmObject = new io.realm.MultiLangEntityRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, realmObject, object, cache) : copy(realm, object, update, cache);
    }

    public static magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MultiLangEntity copy(Realm realm, magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MultiLangEntity newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MultiLangEntity) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MultiLangEntity realmObject = realm.createObjectInternal(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MultiLangEntity.class, ((MultiLangEntityRealmProxyInterface) newObject).realmGet$Id(), false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        MultiLangEntityRealmProxyInterface realmObjectSource = (MultiLangEntityRealmProxyInterface) newObject;
        MultiLangEntityRealmProxyInterface realmObjectCopy = (MultiLangEntityRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$Keyname(realmObjectSource.realmGet$Keyname());
        realmObjectCopy.realmSet$English(realmObjectSource.realmGet$English());
        realmObjectCopy.realmSet$Hindi(realmObjectSource.realmGet$Hindi());
        realmObjectCopy.realmSet$Marathi(realmObjectSource.realmGet$Marathi());
        realmObjectCopy.realmSet$Gujrathi(realmObjectSource.realmGet$Gujrathi());
        return realmObject;
    }

    public static long insert(Realm realm, magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MultiLangEntity object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MultiLangEntity.class);
        long tableNativePtr = table.getNativePtr();
        MultiLangEntityColumnInfo columnInfo = (MultiLangEntityColumnInfo) realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MultiLangEntity.class);
        long pkColumnIndex = columnInfo.IdIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((MultiLangEntityRealmProxyInterface) object).realmGet$Id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((MultiLangEntityRealmProxyInterface) object).realmGet$Id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((MultiLangEntityRealmProxyInterface) object).realmGet$Id());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$Keyname = ((MultiLangEntityRealmProxyInterface) object).realmGet$Keyname();
        if (realmGet$Keyname != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.KeynameIndex, rowIndex, realmGet$Keyname, false);
        }
        String realmGet$English = ((MultiLangEntityRealmProxyInterface) object).realmGet$English();
        if (realmGet$English != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.EnglishIndex, rowIndex, realmGet$English, false);
        }
        String realmGet$Hindi = ((MultiLangEntityRealmProxyInterface) object).realmGet$Hindi();
        if (realmGet$Hindi != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.HindiIndex, rowIndex, realmGet$Hindi, false);
        }
        String realmGet$Marathi = ((MultiLangEntityRealmProxyInterface) object).realmGet$Marathi();
        if (realmGet$Marathi != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.MarathiIndex, rowIndex, realmGet$Marathi, false);
        }
        String realmGet$Gujrathi = ((MultiLangEntityRealmProxyInterface) object).realmGet$Gujrathi();
        if (realmGet$Gujrathi != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.GujrathiIndex, rowIndex, realmGet$Gujrathi, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MultiLangEntity.class);
        long tableNativePtr = table.getNativePtr();
        MultiLangEntityColumnInfo columnInfo = (MultiLangEntityColumnInfo) realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MultiLangEntity.class);
        long pkColumnIndex = columnInfo.IdIndex;
        magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MultiLangEntity object = null;
        while (objects.hasNext()) {
            object = (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MultiLangEntity) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((MultiLangEntityRealmProxyInterface) object).realmGet$Id();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((MultiLangEntityRealmProxyInterface) object).realmGet$Id());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((MultiLangEntityRealmProxyInterface) object).realmGet$Id());
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, rowIndex);
            String realmGet$Keyname = ((MultiLangEntityRealmProxyInterface) object).realmGet$Keyname();
            if (realmGet$Keyname != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.KeynameIndex, rowIndex, realmGet$Keyname, false);
            }
            String realmGet$English = ((MultiLangEntityRealmProxyInterface) object).realmGet$English();
            if (realmGet$English != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.EnglishIndex, rowIndex, realmGet$English, false);
            }
            String realmGet$Hindi = ((MultiLangEntityRealmProxyInterface) object).realmGet$Hindi();
            if (realmGet$Hindi != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.HindiIndex, rowIndex, realmGet$Hindi, false);
            }
            String realmGet$Marathi = ((MultiLangEntityRealmProxyInterface) object).realmGet$Marathi();
            if (realmGet$Marathi != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.MarathiIndex, rowIndex, realmGet$Marathi, false);
            }
            String realmGet$Gujrathi = ((MultiLangEntityRealmProxyInterface) object).realmGet$Gujrathi();
            if (realmGet$Gujrathi != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.GujrathiIndex, rowIndex, realmGet$Gujrathi, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MultiLangEntity object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MultiLangEntity.class);
        long tableNativePtr = table.getNativePtr();
        MultiLangEntityColumnInfo columnInfo = (MultiLangEntityColumnInfo) realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MultiLangEntity.class);
        long pkColumnIndex = columnInfo.IdIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((MultiLangEntityRealmProxyInterface) object).realmGet$Id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((MultiLangEntityRealmProxyInterface) object).realmGet$Id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((MultiLangEntityRealmProxyInterface) object).realmGet$Id());
        }
        cache.put(object, rowIndex);
        String realmGet$Keyname = ((MultiLangEntityRealmProxyInterface) object).realmGet$Keyname();
        if (realmGet$Keyname != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.KeynameIndex, rowIndex, realmGet$Keyname, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.KeynameIndex, rowIndex, false);
        }
        String realmGet$English = ((MultiLangEntityRealmProxyInterface) object).realmGet$English();
        if (realmGet$English != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.EnglishIndex, rowIndex, realmGet$English, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.EnglishIndex, rowIndex, false);
        }
        String realmGet$Hindi = ((MultiLangEntityRealmProxyInterface) object).realmGet$Hindi();
        if (realmGet$Hindi != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.HindiIndex, rowIndex, realmGet$Hindi, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.HindiIndex, rowIndex, false);
        }
        String realmGet$Marathi = ((MultiLangEntityRealmProxyInterface) object).realmGet$Marathi();
        if (realmGet$Marathi != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.MarathiIndex, rowIndex, realmGet$Marathi, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.MarathiIndex, rowIndex, false);
        }
        String realmGet$Gujrathi = ((MultiLangEntityRealmProxyInterface) object).realmGet$Gujrathi();
        if (realmGet$Gujrathi != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.GujrathiIndex, rowIndex, realmGet$Gujrathi, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.GujrathiIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MultiLangEntity.class);
        long tableNativePtr = table.getNativePtr();
        MultiLangEntityColumnInfo columnInfo = (MultiLangEntityColumnInfo) realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MultiLangEntity.class);
        long pkColumnIndex = columnInfo.IdIndex;
        magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MultiLangEntity object = null;
        while (objects.hasNext()) {
            object = (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MultiLangEntity) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((MultiLangEntityRealmProxyInterface) object).realmGet$Id();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((MultiLangEntityRealmProxyInterface) object).realmGet$Id());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((MultiLangEntityRealmProxyInterface) object).realmGet$Id());
            }
            cache.put(object, rowIndex);
            String realmGet$Keyname = ((MultiLangEntityRealmProxyInterface) object).realmGet$Keyname();
            if (realmGet$Keyname != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.KeynameIndex, rowIndex, realmGet$Keyname, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.KeynameIndex, rowIndex, false);
            }
            String realmGet$English = ((MultiLangEntityRealmProxyInterface) object).realmGet$English();
            if (realmGet$English != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.EnglishIndex, rowIndex, realmGet$English, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.EnglishIndex, rowIndex, false);
            }
            String realmGet$Hindi = ((MultiLangEntityRealmProxyInterface) object).realmGet$Hindi();
            if (realmGet$Hindi != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.HindiIndex, rowIndex, realmGet$Hindi, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.HindiIndex, rowIndex, false);
            }
            String realmGet$Marathi = ((MultiLangEntityRealmProxyInterface) object).realmGet$Marathi();
            if (realmGet$Marathi != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.MarathiIndex, rowIndex, realmGet$Marathi, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.MarathiIndex, rowIndex, false);
            }
            String realmGet$Gujrathi = ((MultiLangEntityRealmProxyInterface) object).realmGet$Gujrathi();
            if (realmGet$Gujrathi != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.GujrathiIndex, rowIndex, realmGet$Gujrathi, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.GujrathiIndex, rowIndex, false);
            }
        }
    }

    public static magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MultiLangEntity createDetachedCopy(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MultiLangEntity realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MultiLangEntity unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MultiLangEntity();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MultiLangEntity) cachedObject.object;
            }
            unmanagedObject = (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MultiLangEntity) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        MultiLangEntityRealmProxyInterface unmanagedCopy = (MultiLangEntityRealmProxyInterface) unmanagedObject;
        MultiLangEntityRealmProxyInterface realmSource = (MultiLangEntityRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$Id(realmSource.realmGet$Id());
        unmanagedCopy.realmSet$Keyname(realmSource.realmGet$Keyname());
        unmanagedCopy.realmSet$English(realmSource.realmGet$English());
        unmanagedCopy.realmSet$Hindi(realmSource.realmGet$Hindi());
        unmanagedCopy.realmSet$Marathi(realmSource.realmGet$Marathi());
        unmanagedCopy.realmSet$Gujrathi(realmSource.realmGet$Gujrathi());

        return unmanagedObject;
    }

    static magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MultiLangEntity update(Realm realm, magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MultiLangEntity realmObject, magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MultiLangEntity newObject, Map<RealmModel, RealmObjectProxy> cache) {
        MultiLangEntityRealmProxyInterface realmObjectTarget = (MultiLangEntityRealmProxyInterface) realmObject;
        MultiLangEntityRealmProxyInterface realmObjectSource = (MultiLangEntityRealmProxyInterface) newObject;
        realmObjectTarget.realmSet$Keyname(realmObjectSource.realmGet$Keyname());
        realmObjectTarget.realmSet$English(realmObjectSource.realmGet$English());
        realmObjectTarget.realmSet$Hindi(realmObjectSource.realmGet$Hindi());
        realmObjectTarget.realmSet$Marathi(realmObjectSource.realmGet$Marathi());
        realmObjectTarget.realmSet$Gujrathi(realmObjectSource.realmGet$Gujrathi());
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("MultiLangEntity = proxy[");
        stringBuilder.append("{Id:");
        stringBuilder.append(realmGet$Id());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{Keyname:");
        stringBuilder.append(realmGet$Keyname() != null ? realmGet$Keyname() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{English:");
        stringBuilder.append(realmGet$English() != null ? realmGet$English() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{Hindi:");
        stringBuilder.append(realmGet$Hindi() != null ? realmGet$Hindi() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{Marathi:");
        stringBuilder.append(realmGet$Marathi() != null ? realmGet$Marathi() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{Gujrathi:");
        stringBuilder.append(realmGet$Gujrathi() != null ? realmGet$Gujrathi() : "null");
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
        MultiLangEntityRealmProxy aMultiLangEntity = (MultiLangEntityRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aMultiLangEntity.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aMultiLangEntity.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aMultiLangEntity.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
