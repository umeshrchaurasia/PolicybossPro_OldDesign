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
public class CityMasterEntityRealmProxy extends magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CityMasterEntity
    implements RealmObjectProxy, CityMasterEntityRealmProxyInterface {

    static final class CityMasterEntityColumnInfo extends ColumnInfo {
        long VehicleCity_IdIndex;
        long State_IdIndex;
        long State_NameIndex;
        long RTO_CityIndex;
        long VehicleCity_RTOCodeIndex;
        long RTO_CodeDiscriptionIndex;
        long IsActiveIndex;
        long VehicleTariff_ZoneIndex;

        CityMasterEntityColumnInfo(OsSchemaInfo schemaInfo) {
            super(8);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("CityMasterEntity");
            this.VehicleCity_IdIndex = addColumnDetails("VehicleCity_Id", objectSchemaInfo);
            this.State_IdIndex = addColumnDetails("State_Id", objectSchemaInfo);
            this.State_NameIndex = addColumnDetails("State_Name", objectSchemaInfo);
            this.RTO_CityIndex = addColumnDetails("RTO_City", objectSchemaInfo);
            this.VehicleCity_RTOCodeIndex = addColumnDetails("VehicleCity_RTOCode", objectSchemaInfo);
            this.RTO_CodeDiscriptionIndex = addColumnDetails("RTO_CodeDiscription", objectSchemaInfo);
            this.IsActiveIndex = addColumnDetails("IsActive", objectSchemaInfo);
            this.VehicleTariff_ZoneIndex = addColumnDetails("VehicleTariff_Zone", objectSchemaInfo);
        }

        CityMasterEntityColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new CityMasterEntityColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final CityMasterEntityColumnInfo src = (CityMasterEntityColumnInfo) rawSrc;
            final CityMasterEntityColumnInfo dst = (CityMasterEntityColumnInfo) rawDst;
            dst.VehicleCity_IdIndex = src.VehicleCity_IdIndex;
            dst.State_IdIndex = src.State_IdIndex;
            dst.State_NameIndex = src.State_NameIndex;
            dst.RTO_CityIndex = src.RTO_CityIndex;
            dst.VehicleCity_RTOCodeIndex = src.VehicleCity_RTOCodeIndex;
            dst.RTO_CodeDiscriptionIndex = src.RTO_CodeDiscriptionIndex;
            dst.IsActiveIndex = src.IsActiveIndex;
            dst.VehicleTariff_ZoneIndex = src.VehicleTariff_ZoneIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>(8);
        fieldNames.add("VehicleCity_Id");
        fieldNames.add("State_Id");
        fieldNames.add("State_Name");
        fieldNames.add("RTO_City");
        fieldNames.add("VehicleCity_RTOCode");
        fieldNames.add("RTO_CodeDiscription");
        fieldNames.add("IsActive");
        fieldNames.add("VehicleTariff_Zone");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    private CityMasterEntityColumnInfo columnInfo;
    private ProxyState<magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CityMasterEntity> proxyState;

    CityMasterEntityRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (CityMasterEntityColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CityMasterEntity>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$VehicleCity_Id() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.VehicleCity_IdIndex);
    }

    @Override
    public void realmSet$VehicleCity_Id(String value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'VehicleCity_Id' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$State_Id() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.State_IdIndex);
    }

    @Override
    public void realmSet$State_Id(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.State_IdIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.State_IdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.State_IdIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.State_IdIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$State_Name() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.State_NameIndex);
    }

    @Override
    public void realmSet$State_Name(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.State_NameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.State_NameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.State_NameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.State_NameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$RTO_City() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.RTO_CityIndex);
    }

    @Override
    public void realmSet$RTO_City(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.RTO_CityIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.RTO_CityIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.RTO_CityIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.RTO_CityIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$VehicleCity_RTOCode() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.VehicleCity_RTOCodeIndex);
    }

    @Override
    public void realmSet$VehicleCity_RTOCode(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.VehicleCity_RTOCodeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.VehicleCity_RTOCodeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.VehicleCity_RTOCodeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.VehicleCity_RTOCodeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$RTO_CodeDiscription() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.RTO_CodeDiscriptionIndex);
    }

    @Override
    public void realmSet$RTO_CodeDiscription(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.RTO_CodeDiscriptionIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.RTO_CodeDiscriptionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.RTO_CodeDiscriptionIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.RTO_CodeDiscriptionIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$IsActive() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.IsActiveIndex);
    }

    @Override
    public void realmSet$IsActive(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.IsActiveIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.IsActiveIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.IsActiveIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.IsActiveIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$VehicleTariff_Zone() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.VehicleTariff_ZoneIndex);
    }

    @Override
    public void realmSet$VehicleTariff_Zone(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.VehicleTariff_ZoneIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.VehicleTariff_ZoneIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.VehicleTariff_ZoneIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.VehicleTariff_ZoneIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("CityMasterEntity", 8, 0);
        builder.addPersistedProperty("VehicleCity_Id", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("State_Id", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("State_Name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("RTO_City", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("VehicleCity_RTOCode", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("RTO_CodeDiscription", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("IsActive", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("VehicleTariff_Zone", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static CityMasterEntityColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new CityMasterEntityColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "CityMasterEntity";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CityMasterEntity createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CityMasterEntity obj = null;
        if (update) {
            Table table = realm.getTable(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CityMasterEntity.class);
            CityMasterEntityColumnInfo columnInfo = (CityMasterEntityColumnInfo) realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CityMasterEntity.class);
            long pkColumnIndex = columnInfo.VehicleCity_IdIndex;
            long rowIndex = Table.NO_MATCH;
            if (json.isNull("VehicleCity_Id")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("VehicleCity_Id"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CityMasterEntity.class), false, Collections.<String> emptyList());
                    obj = new io.realm.CityMasterEntityRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("VehicleCity_Id")) {
                if (json.isNull("VehicleCity_Id")) {
                    obj = (io.realm.CityMasterEntityRealmProxy) realm.createObjectInternal(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CityMasterEntity.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.CityMasterEntityRealmProxy) realm.createObjectInternal(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CityMasterEntity.class, json.getString("VehicleCity_Id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'VehicleCity_Id'.");
            }
        }

        final CityMasterEntityRealmProxyInterface objProxy = (CityMasterEntityRealmProxyInterface) obj;
        if (json.has("State_Id")) {
            if (json.isNull("State_Id")) {
                objProxy.realmSet$State_Id(null);
            } else {
                objProxy.realmSet$State_Id((String) json.getString("State_Id"));
            }
        }
        if (json.has("State_Name")) {
            if (json.isNull("State_Name")) {
                objProxy.realmSet$State_Name(null);
            } else {
                objProxy.realmSet$State_Name((String) json.getString("State_Name"));
            }
        }
        if (json.has("RTO_City")) {
            if (json.isNull("RTO_City")) {
                objProxy.realmSet$RTO_City(null);
            } else {
                objProxy.realmSet$RTO_City((String) json.getString("RTO_City"));
            }
        }
        if (json.has("VehicleCity_RTOCode")) {
            if (json.isNull("VehicleCity_RTOCode")) {
                objProxy.realmSet$VehicleCity_RTOCode(null);
            } else {
                objProxy.realmSet$VehicleCity_RTOCode((String) json.getString("VehicleCity_RTOCode"));
            }
        }
        if (json.has("RTO_CodeDiscription")) {
            if (json.isNull("RTO_CodeDiscription")) {
                objProxy.realmSet$RTO_CodeDiscription(null);
            } else {
                objProxy.realmSet$RTO_CodeDiscription((String) json.getString("RTO_CodeDiscription"));
            }
        }
        if (json.has("IsActive")) {
            if (json.isNull("IsActive")) {
                objProxy.realmSet$IsActive(null);
            } else {
                objProxy.realmSet$IsActive((String) json.getString("IsActive"));
            }
        }
        if (json.has("VehicleTariff_Zone")) {
            if (json.isNull("VehicleTariff_Zone")) {
                objProxy.realmSet$VehicleTariff_Zone(null);
            } else {
                objProxy.realmSet$VehicleTariff_Zone((String) json.getString("VehicleTariff_Zone"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CityMasterEntity createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CityMasterEntity obj = new magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CityMasterEntity();
        final CityMasterEntityRealmProxyInterface objProxy = (CityMasterEntityRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("VehicleCity_Id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$VehicleCity_Id((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$VehicleCity_Id(null);
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("State_Id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$State_Id((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$State_Id(null);
                }
            } else if (name.equals("State_Name")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$State_Name((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$State_Name(null);
                }
            } else if (name.equals("RTO_City")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$RTO_City((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$RTO_City(null);
                }
            } else if (name.equals("VehicleCity_RTOCode")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$VehicleCity_RTOCode((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$VehicleCity_RTOCode(null);
                }
            } else if (name.equals("RTO_CodeDiscription")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$RTO_CodeDiscription((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$RTO_CodeDiscription(null);
                }
            } else if (name.equals("IsActive")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$IsActive((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$IsActive(null);
                }
            } else if (name.equals("VehicleTariff_Zone")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$VehicleTariff_Zone((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$VehicleTariff_Zone(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'VehicleCity_Id'.");
        }
        return realm.copyToRealm(obj);
    }

    public static magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CityMasterEntity copyOrUpdate(Realm realm, magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CityMasterEntity object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CityMasterEntity) cachedRealmObject;
        }

        magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CityMasterEntity realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CityMasterEntity.class);
            CityMasterEntityColumnInfo columnInfo = (CityMasterEntityColumnInfo) realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CityMasterEntity.class);
            long pkColumnIndex = columnInfo.VehicleCity_IdIndex;
            String value = ((CityMasterEntityRealmProxyInterface) object).realmGet$VehicleCity_Id();
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CityMasterEntity.class), false, Collections.<String> emptyList());
                    realmObject = new io.realm.CityMasterEntityRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, realmObject, object, cache) : copy(realm, object, update, cache);
    }

    public static magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CityMasterEntity copy(Realm realm, magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CityMasterEntity newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CityMasterEntity) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CityMasterEntity realmObject = realm.createObjectInternal(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CityMasterEntity.class, ((CityMasterEntityRealmProxyInterface) newObject).realmGet$VehicleCity_Id(), false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        CityMasterEntityRealmProxyInterface realmObjectSource = (CityMasterEntityRealmProxyInterface) newObject;
        CityMasterEntityRealmProxyInterface realmObjectCopy = (CityMasterEntityRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$State_Id(realmObjectSource.realmGet$State_Id());
        realmObjectCopy.realmSet$State_Name(realmObjectSource.realmGet$State_Name());
        realmObjectCopy.realmSet$RTO_City(realmObjectSource.realmGet$RTO_City());
        realmObjectCopy.realmSet$VehicleCity_RTOCode(realmObjectSource.realmGet$VehicleCity_RTOCode());
        realmObjectCopy.realmSet$RTO_CodeDiscription(realmObjectSource.realmGet$RTO_CodeDiscription());
        realmObjectCopy.realmSet$IsActive(realmObjectSource.realmGet$IsActive());
        realmObjectCopy.realmSet$VehicleTariff_Zone(realmObjectSource.realmGet$VehicleTariff_Zone());
        return realmObject;
    }

    public static long insert(Realm realm, magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CityMasterEntity object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CityMasterEntity.class);
        long tableNativePtr = table.getNativePtr();
        CityMasterEntityColumnInfo columnInfo = (CityMasterEntityColumnInfo) realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CityMasterEntity.class);
        long pkColumnIndex = columnInfo.VehicleCity_IdIndex;
        String primaryKeyValue = ((CityMasterEntityRealmProxyInterface) object).realmGet$VehicleCity_Id();
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
        String realmGet$State_Id = ((CityMasterEntityRealmProxyInterface) object).realmGet$State_Id();
        if (realmGet$State_Id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.State_IdIndex, rowIndex, realmGet$State_Id, false);
        }
        String realmGet$State_Name = ((CityMasterEntityRealmProxyInterface) object).realmGet$State_Name();
        if (realmGet$State_Name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.State_NameIndex, rowIndex, realmGet$State_Name, false);
        }
        String realmGet$RTO_City = ((CityMasterEntityRealmProxyInterface) object).realmGet$RTO_City();
        if (realmGet$RTO_City != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.RTO_CityIndex, rowIndex, realmGet$RTO_City, false);
        }
        String realmGet$VehicleCity_RTOCode = ((CityMasterEntityRealmProxyInterface) object).realmGet$VehicleCity_RTOCode();
        if (realmGet$VehicleCity_RTOCode != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.VehicleCity_RTOCodeIndex, rowIndex, realmGet$VehicleCity_RTOCode, false);
        }
        String realmGet$RTO_CodeDiscription = ((CityMasterEntityRealmProxyInterface) object).realmGet$RTO_CodeDiscription();
        if (realmGet$RTO_CodeDiscription != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.RTO_CodeDiscriptionIndex, rowIndex, realmGet$RTO_CodeDiscription, false);
        }
        String realmGet$IsActive = ((CityMasterEntityRealmProxyInterface) object).realmGet$IsActive();
        if (realmGet$IsActive != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.IsActiveIndex, rowIndex, realmGet$IsActive, false);
        }
        String realmGet$VehicleTariff_Zone = ((CityMasterEntityRealmProxyInterface) object).realmGet$VehicleTariff_Zone();
        if (realmGet$VehicleTariff_Zone != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.VehicleTariff_ZoneIndex, rowIndex, realmGet$VehicleTariff_Zone, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CityMasterEntity.class);
        long tableNativePtr = table.getNativePtr();
        CityMasterEntityColumnInfo columnInfo = (CityMasterEntityColumnInfo) realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CityMasterEntity.class);
        long pkColumnIndex = columnInfo.VehicleCity_IdIndex;
        magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CityMasterEntity object = null;
        while (objects.hasNext()) {
            object = (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CityMasterEntity) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((CityMasterEntityRealmProxyInterface) object).realmGet$VehicleCity_Id();
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
            String realmGet$State_Id = ((CityMasterEntityRealmProxyInterface) object).realmGet$State_Id();
            if (realmGet$State_Id != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.State_IdIndex, rowIndex, realmGet$State_Id, false);
            }
            String realmGet$State_Name = ((CityMasterEntityRealmProxyInterface) object).realmGet$State_Name();
            if (realmGet$State_Name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.State_NameIndex, rowIndex, realmGet$State_Name, false);
            }
            String realmGet$RTO_City = ((CityMasterEntityRealmProxyInterface) object).realmGet$RTO_City();
            if (realmGet$RTO_City != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.RTO_CityIndex, rowIndex, realmGet$RTO_City, false);
            }
            String realmGet$VehicleCity_RTOCode = ((CityMasterEntityRealmProxyInterface) object).realmGet$VehicleCity_RTOCode();
            if (realmGet$VehicleCity_RTOCode != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.VehicleCity_RTOCodeIndex, rowIndex, realmGet$VehicleCity_RTOCode, false);
            }
            String realmGet$RTO_CodeDiscription = ((CityMasterEntityRealmProxyInterface) object).realmGet$RTO_CodeDiscription();
            if (realmGet$RTO_CodeDiscription != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.RTO_CodeDiscriptionIndex, rowIndex, realmGet$RTO_CodeDiscription, false);
            }
            String realmGet$IsActive = ((CityMasterEntityRealmProxyInterface) object).realmGet$IsActive();
            if (realmGet$IsActive != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.IsActiveIndex, rowIndex, realmGet$IsActive, false);
            }
            String realmGet$VehicleTariff_Zone = ((CityMasterEntityRealmProxyInterface) object).realmGet$VehicleTariff_Zone();
            if (realmGet$VehicleTariff_Zone != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.VehicleTariff_ZoneIndex, rowIndex, realmGet$VehicleTariff_Zone, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CityMasterEntity object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CityMasterEntity.class);
        long tableNativePtr = table.getNativePtr();
        CityMasterEntityColumnInfo columnInfo = (CityMasterEntityColumnInfo) realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CityMasterEntity.class);
        long pkColumnIndex = columnInfo.VehicleCity_IdIndex;
        String primaryKeyValue = ((CityMasterEntityRealmProxyInterface) object).realmGet$VehicleCity_Id();
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
        String realmGet$State_Id = ((CityMasterEntityRealmProxyInterface) object).realmGet$State_Id();
        if (realmGet$State_Id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.State_IdIndex, rowIndex, realmGet$State_Id, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.State_IdIndex, rowIndex, false);
        }
        String realmGet$State_Name = ((CityMasterEntityRealmProxyInterface) object).realmGet$State_Name();
        if (realmGet$State_Name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.State_NameIndex, rowIndex, realmGet$State_Name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.State_NameIndex, rowIndex, false);
        }
        String realmGet$RTO_City = ((CityMasterEntityRealmProxyInterface) object).realmGet$RTO_City();
        if (realmGet$RTO_City != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.RTO_CityIndex, rowIndex, realmGet$RTO_City, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.RTO_CityIndex, rowIndex, false);
        }
        String realmGet$VehicleCity_RTOCode = ((CityMasterEntityRealmProxyInterface) object).realmGet$VehicleCity_RTOCode();
        if (realmGet$VehicleCity_RTOCode != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.VehicleCity_RTOCodeIndex, rowIndex, realmGet$VehicleCity_RTOCode, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.VehicleCity_RTOCodeIndex, rowIndex, false);
        }
        String realmGet$RTO_CodeDiscription = ((CityMasterEntityRealmProxyInterface) object).realmGet$RTO_CodeDiscription();
        if (realmGet$RTO_CodeDiscription != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.RTO_CodeDiscriptionIndex, rowIndex, realmGet$RTO_CodeDiscription, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.RTO_CodeDiscriptionIndex, rowIndex, false);
        }
        String realmGet$IsActive = ((CityMasterEntityRealmProxyInterface) object).realmGet$IsActive();
        if (realmGet$IsActive != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.IsActiveIndex, rowIndex, realmGet$IsActive, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.IsActiveIndex, rowIndex, false);
        }
        String realmGet$VehicleTariff_Zone = ((CityMasterEntityRealmProxyInterface) object).realmGet$VehicleTariff_Zone();
        if (realmGet$VehicleTariff_Zone != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.VehicleTariff_ZoneIndex, rowIndex, realmGet$VehicleTariff_Zone, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.VehicleTariff_ZoneIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CityMasterEntity.class);
        long tableNativePtr = table.getNativePtr();
        CityMasterEntityColumnInfo columnInfo = (CityMasterEntityColumnInfo) realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CityMasterEntity.class);
        long pkColumnIndex = columnInfo.VehicleCity_IdIndex;
        magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CityMasterEntity object = null;
        while (objects.hasNext()) {
            object = (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CityMasterEntity) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((CityMasterEntityRealmProxyInterface) object).realmGet$VehicleCity_Id();
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
            String realmGet$State_Id = ((CityMasterEntityRealmProxyInterface) object).realmGet$State_Id();
            if (realmGet$State_Id != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.State_IdIndex, rowIndex, realmGet$State_Id, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.State_IdIndex, rowIndex, false);
            }
            String realmGet$State_Name = ((CityMasterEntityRealmProxyInterface) object).realmGet$State_Name();
            if (realmGet$State_Name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.State_NameIndex, rowIndex, realmGet$State_Name, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.State_NameIndex, rowIndex, false);
            }
            String realmGet$RTO_City = ((CityMasterEntityRealmProxyInterface) object).realmGet$RTO_City();
            if (realmGet$RTO_City != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.RTO_CityIndex, rowIndex, realmGet$RTO_City, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.RTO_CityIndex, rowIndex, false);
            }
            String realmGet$VehicleCity_RTOCode = ((CityMasterEntityRealmProxyInterface) object).realmGet$VehicleCity_RTOCode();
            if (realmGet$VehicleCity_RTOCode != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.VehicleCity_RTOCodeIndex, rowIndex, realmGet$VehicleCity_RTOCode, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.VehicleCity_RTOCodeIndex, rowIndex, false);
            }
            String realmGet$RTO_CodeDiscription = ((CityMasterEntityRealmProxyInterface) object).realmGet$RTO_CodeDiscription();
            if (realmGet$RTO_CodeDiscription != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.RTO_CodeDiscriptionIndex, rowIndex, realmGet$RTO_CodeDiscription, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.RTO_CodeDiscriptionIndex, rowIndex, false);
            }
            String realmGet$IsActive = ((CityMasterEntityRealmProxyInterface) object).realmGet$IsActive();
            if (realmGet$IsActive != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.IsActiveIndex, rowIndex, realmGet$IsActive, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.IsActiveIndex, rowIndex, false);
            }
            String realmGet$VehicleTariff_Zone = ((CityMasterEntityRealmProxyInterface) object).realmGet$VehicleTariff_Zone();
            if (realmGet$VehicleTariff_Zone != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.VehicleTariff_ZoneIndex, rowIndex, realmGet$VehicleTariff_Zone, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.VehicleTariff_ZoneIndex, rowIndex, false);
            }
        }
    }

    public static magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CityMasterEntity createDetachedCopy(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CityMasterEntity realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CityMasterEntity unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CityMasterEntity();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CityMasterEntity) cachedObject.object;
            }
            unmanagedObject = (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CityMasterEntity) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        CityMasterEntityRealmProxyInterface unmanagedCopy = (CityMasterEntityRealmProxyInterface) unmanagedObject;
        CityMasterEntityRealmProxyInterface realmSource = (CityMasterEntityRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$VehicleCity_Id(realmSource.realmGet$VehicleCity_Id());
        unmanagedCopy.realmSet$State_Id(realmSource.realmGet$State_Id());
        unmanagedCopy.realmSet$State_Name(realmSource.realmGet$State_Name());
        unmanagedCopy.realmSet$RTO_City(realmSource.realmGet$RTO_City());
        unmanagedCopy.realmSet$VehicleCity_RTOCode(realmSource.realmGet$VehicleCity_RTOCode());
        unmanagedCopy.realmSet$RTO_CodeDiscription(realmSource.realmGet$RTO_CodeDiscription());
        unmanagedCopy.realmSet$IsActive(realmSource.realmGet$IsActive());
        unmanagedCopy.realmSet$VehicleTariff_Zone(realmSource.realmGet$VehicleTariff_Zone());

        return unmanagedObject;
    }

    static magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CityMasterEntity update(Realm realm, magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CityMasterEntity realmObject, magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CityMasterEntity newObject, Map<RealmModel, RealmObjectProxy> cache) {
        CityMasterEntityRealmProxyInterface realmObjectTarget = (CityMasterEntityRealmProxyInterface) realmObject;
        CityMasterEntityRealmProxyInterface realmObjectSource = (CityMasterEntityRealmProxyInterface) newObject;
        realmObjectTarget.realmSet$State_Id(realmObjectSource.realmGet$State_Id());
        realmObjectTarget.realmSet$State_Name(realmObjectSource.realmGet$State_Name());
        realmObjectTarget.realmSet$RTO_City(realmObjectSource.realmGet$RTO_City());
        realmObjectTarget.realmSet$VehicleCity_RTOCode(realmObjectSource.realmGet$VehicleCity_RTOCode());
        realmObjectTarget.realmSet$RTO_CodeDiscription(realmObjectSource.realmGet$RTO_CodeDiscription());
        realmObjectTarget.realmSet$IsActive(realmObjectSource.realmGet$IsActive());
        realmObjectTarget.realmSet$VehicleTariff_Zone(realmObjectSource.realmGet$VehicleTariff_Zone());
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("CityMasterEntity = proxy[");
        stringBuilder.append("{VehicleCity_Id:");
        stringBuilder.append(realmGet$VehicleCity_Id() != null ? realmGet$VehicleCity_Id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{State_Id:");
        stringBuilder.append(realmGet$State_Id() != null ? realmGet$State_Id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{State_Name:");
        stringBuilder.append(realmGet$State_Name() != null ? realmGet$State_Name() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{RTO_City:");
        stringBuilder.append(realmGet$RTO_City() != null ? realmGet$RTO_City() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{VehicleCity_RTOCode:");
        stringBuilder.append(realmGet$VehicleCity_RTOCode() != null ? realmGet$VehicleCity_RTOCode() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{RTO_CodeDiscription:");
        stringBuilder.append(realmGet$RTO_CodeDiscription() != null ? realmGet$RTO_CodeDiscription() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{IsActive:");
        stringBuilder.append(realmGet$IsActive() != null ? realmGet$IsActive() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{VehicleTariff_Zone:");
        stringBuilder.append(realmGet$VehicleTariff_Zone() != null ? realmGet$VehicleTariff_Zone() : "null");
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
        CityMasterEntityRealmProxy aCityMasterEntity = (CityMasterEntityRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aCityMasterEntity.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aCityMasterEntity.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aCityMasterEntity.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
