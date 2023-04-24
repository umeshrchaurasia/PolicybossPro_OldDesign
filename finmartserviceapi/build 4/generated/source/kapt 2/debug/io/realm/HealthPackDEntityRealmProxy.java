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
public class HealthPackDEntityRealmProxy extends magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDEntity
    implements RealmObjectProxy, HealthPackDEntityRealmProxyInterface {

    static final class HealthPackDEntityColumnInfo extends ColumnInfo {
        long __typeIndex;
        long status_codeIndex;
        long statusIndex;
        long messageIndex;
        long lstPackageDetailsIndex;

        HealthPackDEntityColumnInfo(OsSchemaInfo schemaInfo) {
            super(5);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("HealthPackDEntity");
            this.__typeIndex = addColumnDetails("__type", objectSchemaInfo);
            this.status_codeIndex = addColumnDetails("status_code", objectSchemaInfo);
            this.statusIndex = addColumnDetails("status", objectSchemaInfo);
            this.messageIndex = addColumnDetails("message", objectSchemaInfo);
            this.lstPackageDetailsIndex = addColumnDetails("lstPackageDetails", objectSchemaInfo);
        }

        HealthPackDEntityColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new HealthPackDEntityColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final HealthPackDEntityColumnInfo src = (HealthPackDEntityColumnInfo) rawSrc;
            final HealthPackDEntityColumnInfo dst = (HealthPackDEntityColumnInfo) rawDst;
            dst.__typeIndex = src.__typeIndex;
            dst.status_codeIndex = src.status_codeIndex;
            dst.statusIndex = src.statusIndex;
            dst.messageIndex = src.messageIndex;
            dst.lstPackageDetailsIndex = src.lstPackageDetailsIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>(5);
        fieldNames.add("__type");
        fieldNames.add("status_code");
        fieldNames.add("status");
        fieldNames.add("message");
        fieldNames.add("lstPackageDetails");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    private HealthPackDEntityColumnInfo columnInfo;
    private ProxyState<magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDEntity> proxyState;
    private RealmList<magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity> lstPackageDetailsRealmList;

    HealthPackDEntityRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (HealthPackDEntityColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDEntity>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$__type() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.__typeIndex);
    }

    @Override
    public void realmSet$__type(String value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field '__type' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$status_code() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.status_codeIndex);
    }

    @Override
    public void realmSet$status_code(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.status_codeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.status_codeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$status() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.statusIndex);
    }

    @Override
    public void realmSet$status(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.statusIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.statusIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.statusIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.statusIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$message() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.messageIndex);
    }

    @Override
    public void realmSet$message(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.messageIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.messageIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.messageIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.messageIndex, value);
    }

    @Override
    public RealmList<magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity> realmGet$lstPackageDetails() {
        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (lstPackageDetailsRealmList != null) {
            return lstPackageDetailsRealmList;
        } else {
            OsList osList = proxyState.getRow$realm().getModelList(columnInfo.lstPackageDetailsIndex);
            lstPackageDetailsRealmList = new RealmList<magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity>(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity.class, osList, proxyState.getRealm$realm());
            return lstPackageDetailsRealmList;
        }
    }

    @Override
    public void realmSet$lstPackageDetails(RealmList<magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity> value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("lstPackageDetails")) {
                return;
            }
            // if the list contains unmanaged RealmObjects, convert them to managed.
            if (value != null && !value.isManaged()) {
                final Realm realm = (Realm) proxyState.getRealm$realm();
                final RealmList<magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity> original = value;
                value = new RealmList<magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity>();
                for (magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity item : original) {
                    if (item == null || RealmObject.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.copyToRealm(item));
                    }
                }
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        OsList osList = proxyState.getRow$realm().getModelList(columnInfo.lstPackageDetailsIndex);
        // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
        if (value != null && value.size() == osList.size()) {
            int objects = value.size();
            for (int i = 0; i < objects; i++) {
                magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity linkedObject = value.get(i);
                proxyState.checkValidObject(linkedObject);
                osList.setRow(i, ((RealmObjectProxy) linkedObject).realmGet$proxyState().getRow$realm().getIndex());
            }
        } else {
            osList.removeAll();
            if (value == null) {
                return;
            }
            int objects = value.size();
            for (int i = 0; i < objects; i++) {
                magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity linkedObject = value.get(i);
                proxyState.checkValidObject(linkedObject);
                osList.addRow(((RealmObjectProxy) linkedObject).realmGet$proxyState().getRow$realm().getIndex());
            }
        }
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("HealthPackDEntity", 5, 0);
        builder.addPersistedProperty("__type", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("status_code", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("status", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("message", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedLinkProperty("lstPackageDetails", RealmFieldType.LIST, "LstPackageDetailsEntity");
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static HealthPackDEntityColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new HealthPackDEntityColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "HealthPackDEntity";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDEntity createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(1);
        magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDEntity obj = null;
        if (update) {
            Table table = realm.getTable(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDEntity.class);
            HealthPackDEntityColumnInfo columnInfo = (HealthPackDEntityColumnInfo) realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDEntity.class);
            long pkColumnIndex = columnInfo.__typeIndex;
            long rowIndex = Table.NO_MATCH;
            if (json.isNull("__type")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("__type"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDEntity.class), false, Collections.<String> emptyList());
                    obj = new io.realm.HealthPackDEntityRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("lstPackageDetails")) {
                excludeFields.add("lstPackageDetails");
            }
            if (json.has("__type")) {
                if (json.isNull("__type")) {
                    obj = (io.realm.HealthPackDEntityRealmProxy) realm.createObjectInternal(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDEntity.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.HealthPackDEntityRealmProxy) realm.createObjectInternal(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDEntity.class, json.getString("__type"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field '__type'.");
            }
        }

        final HealthPackDEntityRealmProxyInterface objProxy = (HealthPackDEntityRealmProxyInterface) obj;
        if (json.has("status_code")) {
            if (json.isNull("status_code")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'status_code' to null.");
            } else {
                objProxy.realmSet$status_code((int) json.getInt("status_code"));
            }
        }
        if (json.has("status")) {
            if (json.isNull("status")) {
                objProxy.realmSet$status(null);
            } else {
                objProxy.realmSet$status((String) json.getString("status"));
            }
        }
        if (json.has("message")) {
            if (json.isNull("message")) {
                objProxy.realmSet$message(null);
            } else {
                objProxy.realmSet$message((String) json.getString("message"));
            }
        }
        if (json.has("lstPackageDetails")) {
            if (json.isNull("lstPackageDetails")) {
                objProxy.realmSet$lstPackageDetails(null);
            } else {
                objProxy.realmGet$lstPackageDetails().clear();
                JSONArray array = json.getJSONArray("lstPackageDetails");
                for (int i = 0; i < array.length(); i++) {
                    magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity item = LstPackageDetailsEntityRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    objProxy.realmGet$lstPackageDetails().add(item);
                }
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDEntity createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDEntity obj = new magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDEntity();
        final HealthPackDEntityRealmProxyInterface objProxy = (HealthPackDEntityRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("__type")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$__type((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$__type(null);
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("status_code")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$status_code((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'status_code' to null.");
                }
            } else if (name.equals("status")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$status((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$status(null);
                }
            } else if (name.equals("message")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$message((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$message(null);
                }
            } else if (name.equals("lstPackageDetails")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$lstPackageDetails(null);
                } else {
                    objProxy.realmSet$lstPackageDetails(new RealmList<magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity item = LstPackageDetailsEntityRealmProxy.createUsingJsonStream(realm, reader);
                        objProxy.realmGet$lstPackageDetails().add(item);
                    }
                    reader.endArray();
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field '__type'.");
        }
        return realm.copyToRealm(obj);
    }

    public static magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDEntity copyOrUpdate(Realm realm, magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDEntity object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDEntity) cachedRealmObject;
        }

        magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDEntity realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDEntity.class);
            HealthPackDEntityColumnInfo columnInfo = (HealthPackDEntityColumnInfo) realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDEntity.class);
            long pkColumnIndex = columnInfo.__typeIndex;
            String value = ((HealthPackDEntityRealmProxyInterface) object).realmGet$__type();
            long rowIndex = Table.NO_MATCH;
            if (value == null) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, value);
            }
            if (rowIndex == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDEntity.class), false, Collections.<String> emptyList());
                    realmObject = new io.realm.HealthPackDEntityRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, realmObject, object, cache) : copy(realm, object, update, cache);
    }

    public static magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDEntity copy(Realm realm, magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDEntity newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDEntity) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDEntity realmObject = realm.createObjectInternal(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDEntity.class, ((HealthPackDEntityRealmProxyInterface) newObject).realmGet$__type(), false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        HealthPackDEntityRealmProxyInterface realmObjectSource = (HealthPackDEntityRealmProxyInterface) newObject;
        HealthPackDEntityRealmProxyInterface realmObjectCopy = (HealthPackDEntityRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$status_code(realmObjectSource.realmGet$status_code());
        realmObjectCopy.realmSet$status(realmObjectSource.realmGet$status());
        realmObjectCopy.realmSet$message(realmObjectSource.realmGet$message());

        RealmList<magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity> lstPackageDetailsList = realmObjectSource.realmGet$lstPackageDetails();
        if (lstPackageDetailsList != null) {
            RealmList<magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity> lstPackageDetailsRealmList = realmObjectCopy.realmGet$lstPackageDetails();
            lstPackageDetailsRealmList.clear();
            for (int i = 0; i < lstPackageDetailsList.size(); i++) {
                magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity lstPackageDetailsItem = lstPackageDetailsList.get(i);
                magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity cachelstPackageDetails = (magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity) cache.get(lstPackageDetailsItem);
                if (cachelstPackageDetails != null) {
                    lstPackageDetailsRealmList.add(cachelstPackageDetails);
                } else {
                    lstPackageDetailsRealmList.add(LstPackageDetailsEntityRealmProxy.copyOrUpdate(realm, lstPackageDetailsItem, update, cache));
                }
            }
        }

        return realmObject;
    }

    public static long insert(Realm realm, magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDEntity object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDEntity.class);
        long tableNativePtr = table.getNativePtr();
        HealthPackDEntityColumnInfo columnInfo = (HealthPackDEntityColumnInfo) realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDEntity.class);
        long pkColumnIndex = columnInfo.__typeIndex;
        String primaryKeyValue = ((HealthPackDEntityRealmProxyInterface) object).realmGet$__type();
        long rowIndex = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.status_codeIndex, rowIndex, ((HealthPackDEntityRealmProxyInterface) object).realmGet$status_code(), false);
        String realmGet$status = ((HealthPackDEntityRealmProxyInterface) object).realmGet$status();
        if (realmGet$status != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.statusIndex, rowIndex, realmGet$status, false);
        }
        String realmGet$message = ((HealthPackDEntityRealmProxyInterface) object).realmGet$message();
        if (realmGet$message != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.messageIndex, rowIndex, realmGet$message, false);
        }

        RealmList<magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity> lstPackageDetailsList = ((HealthPackDEntityRealmProxyInterface) object).realmGet$lstPackageDetails();
        if (lstPackageDetailsList != null) {
            OsList lstPackageDetailsOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.lstPackageDetailsIndex);
            for (magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity lstPackageDetailsItem : lstPackageDetailsList) {
                Long cacheItemIndexlstPackageDetails = cache.get(lstPackageDetailsItem);
                if (cacheItemIndexlstPackageDetails == null) {
                    cacheItemIndexlstPackageDetails = LstPackageDetailsEntityRealmProxy.insert(realm, lstPackageDetailsItem, cache);
                }
                lstPackageDetailsOsList.addRow(cacheItemIndexlstPackageDetails);
            }
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDEntity.class);
        long tableNativePtr = table.getNativePtr();
        HealthPackDEntityColumnInfo columnInfo = (HealthPackDEntityColumnInfo) realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDEntity.class);
        long pkColumnIndex = columnInfo.__typeIndex;
        magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDEntity object = null;
        while (objects.hasNext()) {
            object = (magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDEntity) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((HealthPackDEntityRealmProxyInterface) object).realmGet$__type();
            long rowIndex = Table.NO_MATCH;
            if (primaryKeyValue == null) {
                rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
            } else {
                rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.status_codeIndex, rowIndex, ((HealthPackDEntityRealmProxyInterface) object).realmGet$status_code(), false);
            String realmGet$status = ((HealthPackDEntityRealmProxyInterface) object).realmGet$status();
            if (realmGet$status != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.statusIndex, rowIndex, realmGet$status, false);
            }
            String realmGet$message = ((HealthPackDEntityRealmProxyInterface) object).realmGet$message();
            if (realmGet$message != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.messageIndex, rowIndex, realmGet$message, false);
            }

            RealmList<magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity> lstPackageDetailsList = ((HealthPackDEntityRealmProxyInterface) object).realmGet$lstPackageDetails();
            if (lstPackageDetailsList != null) {
                OsList lstPackageDetailsOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.lstPackageDetailsIndex);
                for (magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity lstPackageDetailsItem : lstPackageDetailsList) {
                    Long cacheItemIndexlstPackageDetails = cache.get(lstPackageDetailsItem);
                    if (cacheItemIndexlstPackageDetails == null) {
                        cacheItemIndexlstPackageDetails = LstPackageDetailsEntityRealmProxy.insert(realm, lstPackageDetailsItem, cache);
                    }
                    lstPackageDetailsOsList.addRow(cacheItemIndexlstPackageDetails);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDEntity object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDEntity.class);
        long tableNativePtr = table.getNativePtr();
        HealthPackDEntityColumnInfo columnInfo = (HealthPackDEntityColumnInfo) realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDEntity.class);
        long pkColumnIndex = columnInfo.__typeIndex;
        String primaryKeyValue = ((HealthPackDEntityRealmProxyInterface) object).realmGet$__type();
        long rowIndex = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
        }
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.status_codeIndex, rowIndex, ((HealthPackDEntityRealmProxyInterface) object).realmGet$status_code(), false);
        String realmGet$status = ((HealthPackDEntityRealmProxyInterface) object).realmGet$status();
        if (realmGet$status != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.statusIndex, rowIndex, realmGet$status, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.statusIndex, rowIndex, false);
        }
        String realmGet$message = ((HealthPackDEntityRealmProxyInterface) object).realmGet$message();
        if (realmGet$message != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.messageIndex, rowIndex, realmGet$message, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.messageIndex, rowIndex, false);
        }

        OsList lstPackageDetailsOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.lstPackageDetailsIndex);
        RealmList<magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity> lstPackageDetailsList = ((HealthPackDEntityRealmProxyInterface) object).realmGet$lstPackageDetails();
        if (lstPackageDetailsList != null && lstPackageDetailsList.size() == lstPackageDetailsOsList.size()) {
            // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
            int objects = lstPackageDetailsList.size();
            for (int i = 0; i < objects; i++) {
                magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity lstPackageDetailsItem = lstPackageDetailsList.get(i);
                Long cacheItemIndexlstPackageDetails = cache.get(lstPackageDetailsItem);
                if (cacheItemIndexlstPackageDetails == null) {
                    cacheItemIndexlstPackageDetails = LstPackageDetailsEntityRealmProxy.insertOrUpdate(realm, lstPackageDetailsItem, cache);
                }
                lstPackageDetailsOsList.setRow(i, cacheItemIndexlstPackageDetails);
            }
        } else {
            lstPackageDetailsOsList.removeAll();
            if (lstPackageDetailsList != null) {
                for (magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity lstPackageDetailsItem : lstPackageDetailsList) {
                    Long cacheItemIndexlstPackageDetails = cache.get(lstPackageDetailsItem);
                    if (cacheItemIndexlstPackageDetails == null) {
                        cacheItemIndexlstPackageDetails = LstPackageDetailsEntityRealmProxy.insertOrUpdate(realm, lstPackageDetailsItem, cache);
                    }
                    lstPackageDetailsOsList.addRow(cacheItemIndexlstPackageDetails);
                }
            }
        }

        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDEntity.class);
        long tableNativePtr = table.getNativePtr();
        HealthPackDEntityColumnInfo columnInfo = (HealthPackDEntityColumnInfo) realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDEntity.class);
        long pkColumnIndex = columnInfo.__typeIndex;
        magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDEntity object = null;
        while (objects.hasNext()) {
            object = (magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDEntity) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((HealthPackDEntityRealmProxyInterface) object).realmGet$__type();
            long rowIndex = Table.NO_MATCH;
            if (primaryKeyValue == null) {
                rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
            } else {
                rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
            }
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.status_codeIndex, rowIndex, ((HealthPackDEntityRealmProxyInterface) object).realmGet$status_code(), false);
            String realmGet$status = ((HealthPackDEntityRealmProxyInterface) object).realmGet$status();
            if (realmGet$status != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.statusIndex, rowIndex, realmGet$status, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.statusIndex, rowIndex, false);
            }
            String realmGet$message = ((HealthPackDEntityRealmProxyInterface) object).realmGet$message();
            if (realmGet$message != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.messageIndex, rowIndex, realmGet$message, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.messageIndex, rowIndex, false);
            }

            OsList lstPackageDetailsOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.lstPackageDetailsIndex);
            RealmList<magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity> lstPackageDetailsList = ((HealthPackDEntityRealmProxyInterface) object).realmGet$lstPackageDetails();
            if (lstPackageDetailsList != null && lstPackageDetailsList.size() == lstPackageDetailsOsList.size()) {
                // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
                int objectCount = lstPackageDetailsList.size();
                for (int i = 0; i < objectCount; i++) {
                    magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity lstPackageDetailsItem = lstPackageDetailsList.get(i);
                    Long cacheItemIndexlstPackageDetails = cache.get(lstPackageDetailsItem);
                    if (cacheItemIndexlstPackageDetails == null) {
                        cacheItemIndexlstPackageDetails = LstPackageDetailsEntityRealmProxy.insertOrUpdate(realm, lstPackageDetailsItem, cache);
                    }
                    lstPackageDetailsOsList.setRow(i, cacheItemIndexlstPackageDetails);
                }
            } else {
                lstPackageDetailsOsList.removeAll();
                if (lstPackageDetailsList != null) {
                    for (magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity lstPackageDetailsItem : lstPackageDetailsList) {
                        Long cacheItemIndexlstPackageDetails = cache.get(lstPackageDetailsItem);
                        if (cacheItemIndexlstPackageDetails == null) {
                            cacheItemIndexlstPackageDetails = LstPackageDetailsEntityRealmProxy.insertOrUpdate(realm, lstPackageDetailsItem, cache);
                        }
                        lstPackageDetailsOsList.addRow(cacheItemIndexlstPackageDetails);
                    }
                }
            }

        }
    }

    public static magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDEntity createDetachedCopy(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDEntity realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDEntity unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDEntity();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDEntity) cachedObject.object;
            }
            unmanagedObject = (magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDEntity) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        HealthPackDEntityRealmProxyInterface unmanagedCopy = (HealthPackDEntityRealmProxyInterface) unmanagedObject;
        HealthPackDEntityRealmProxyInterface realmSource = (HealthPackDEntityRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$__type(realmSource.realmGet$__type());
        unmanagedCopy.realmSet$status_code(realmSource.realmGet$status_code());
        unmanagedCopy.realmSet$status(realmSource.realmGet$status());
        unmanagedCopy.realmSet$message(realmSource.realmGet$message());

        // Deep copy of lstPackageDetails
        if (currentDepth == maxDepth) {
            unmanagedCopy.realmSet$lstPackageDetails(null);
        } else {
            RealmList<magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity> managedlstPackageDetailsList = realmSource.realmGet$lstPackageDetails();
            RealmList<magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity> unmanagedlstPackageDetailsList = new RealmList<magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity>();
            unmanagedCopy.realmSet$lstPackageDetails(unmanagedlstPackageDetailsList);
            int nextDepth = currentDepth + 1;
            int size = managedlstPackageDetailsList.size();
            for (int i = 0; i < size; i++) {
                magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity item = LstPackageDetailsEntityRealmProxy.createDetachedCopy(managedlstPackageDetailsList.get(i), nextDepth, maxDepth, cache);
                unmanagedlstPackageDetailsList.add(item);
            }
        }

        return unmanagedObject;
    }

    static magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDEntity update(Realm realm, magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDEntity realmObject, magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDEntity newObject, Map<RealmModel, RealmObjectProxy> cache) {
        HealthPackDEntityRealmProxyInterface realmObjectTarget = (HealthPackDEntityRealmProxyInterface) realmObject;
        HealthPackDEntityRealmProxyInterface realmObjectSource = (HealthPackDEntityRealmProxyInterface) newObject;
        realmObjectTarget.realmSet$status_code(realmObjectSource.realmGet$status_code());
        realmObjectTarget.realmSet$status(realmObjectSource.realmGet$status());
        realmObjectTarget.realmSet$message(realmObjectSource.realmGet$message());
        RealmList<magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity> lstPackageDetailsList = realmObjectSource.realmGet$lstPackageDetails();
        RealmList<magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity> lstPackageDetailsRealmList = realmObjectTarget.realmGet$lstPackageDetails();
        if (lstPackageDetailsList != null && lstPackageDetailsList.size() == lstPackageDetailsRealmList.size()) {
            // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
            int objects = lstPackageDetailsList.size();
            for (int i = 0; i < objects; i++) {
                magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity lstPackageDetailsItem = lstPackageDetailsList.get(i);
                magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity cachelstPackageDetails = (magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity) cache.get(lstPackageDetailsItem);
                if (cachelstPackageDetails != null) {
                    lstPackageDetailsRealmList.set(i, cachelstPackageDetails);
                } else {
                    lstPackageDetailsRealmList.set(i, LstPackageDetailsEntityRealmProxy.copyOrUpdate(realm, lstPackageDetailsItem, true, cache));
                }
            }
        } else {
            lstPackageDetailsRealmList.clear();
            if (lstPackageDetailsList != null) {
                for (int i = 0; i < lstPackageDetailsList.size(); i++) {
                    magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity lstPackageDetailsItem = lstPackageDetailsList.get(i);
                    magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity cachelstPackageDetails = (magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity) cache.get(lstPackageDetailsItem);
                    if (cachelstPackageDetails != null) {
                        lstPackageDetailsRealmList.add(cachelstPackageDetails);
                    } else {
                        lstPackageDetailsRealmList.add(LstPackageDetailsEntityRealmProxy.copyOrUpdate(realm, lstPackageDetailsItem, true, cache));
                    }
                }
            }
        }
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("HealthPackDEntity = proxy[");
        stringBuilder.append("{__type:");
        stringBuilder.append(realmGet$__type() != null ? realmGet$__type() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{status_code:");
        stringBuilder.append(realmGet$status_code());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{status:");
        stringBuilder.append(realmGet$status() != null ? realmGet$status() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{message:");
        stringBuilder.append(realmGet$message() != null ? realmGet$message() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{lstPackageDetails:");
        stringBuilder.append("RealmList<LstPackageDetailsEntity>[").append(realmGet$lstPackageDetails().size()).append("]");
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
        HealthPackDEntityRealmProxy aHealthPackDEntity = (HealthPackDEntityRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aHealthPackDEntity.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aHealthPackDEntity.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aHealthPackDEntity.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
