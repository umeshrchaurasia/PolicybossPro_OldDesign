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
public class HealthPackDetailsDBeanRealmProxy extends magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDetailsDBean
    implements RealmObjectProxy, HealthPackDetailsDBeanRealmProxyInterface {

    static final class HealthPackDetailsDBeanColumnInfo extends ColumnInfo {
        long __typeIndex;
        long status_codeIndex;
        long statusIndex;
        long messageIndex;
        long lstPackParameterIndex;
        long packcodeIndex;

        HealthPackDetailsDBeanColumnInfo(OsSchemaInfo schemaInfo) {
            super(6);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("HealthPackDetailsDBean");
            this.__typeIndex = addColumnDetails("__type", objectSchemaInfo);
            this.status_codeIndex = addColumnDetails("status_code", objectSchemaInfo);
            this.statusIndex = addColumnDetails("status", objectSchemaInfo);
            this.messageIndex = addColumnDetails("message", objectSchemaInfo);
            this.lstPackParameterIndex = addColumnDetails("lstPackParameter", objectSchemaInfo);
            this.packcodeIndex = addColumnDetails("packcode", objectSchemaInfo);
        }

        HealthPackDetailsDBeanColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new HealthPackDetailsDBeanColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final HealthPackDetailsDBeanColumnInfo src = (HealthPackDetailsDBeanColumnInfo) rawSrc;
            final HealthPackDetailsDBeanColumnInfo dst = (HealthPackDetailsDBeanColumnInfo) rawDst;
            dst.__typeIndex = src.__typeIndex;
            dst.status_codeIndex = src.status_codeIndex;
            dst.statusIndex = src.statusIndex;
            dst.messageIndex = src.messageIndex;
            dst.lstPackParameterIndex = src.lstPackParameterIndex;
            dst.packcodeIndex = src.packcodeIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>(6);
        fieldNames.add("__type");
        fieldNames.add("status_code");
        fieldNames.add("status");
        fieldNames.add("message");
        fieldNames.add("lstPackParameter");
        fieldNames.add("packcode");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    private HealthPackDetailsDBeanColumnInfo columnInfo;
    private ProxyState<magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDetailsDBean> proxyState;
    private RealmList<magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackParameterEntity> lstPackParameterRealmList;

    HealthPackDetailsDBeanRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (HealthPackDetailsDBeanColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDetailsDBean>(this);
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
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.__typeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.__typeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.__typeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.__typeIndex, value);
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
    public RealmList<magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackParameterEntity> realmGet$lstPackParameter() {
        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (lstPackParameterRealmList != null) {
            return lstPackParameterRealmList;
        } else {
            OsList osList = proxyState.getRow$realm().getModelList(columnInfo.lstPackParameterIndex);
            lstPackParameterRealmList = new RealmList<magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackParameterEntity>(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackParameterEntity.class, osList, proxyState.getRealm$realm());
            return lstPackParameterRealmList;
        }
    }

    @Override
    public void realmSet$lstPackParameter(RealmList<magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackParameterEntity> value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("lstPackParameter")) {
                return;
            }
            // if the list contains unmanaged RealmObjects, convert them to managed.
            if (value != null && !value.isManaged()) {
                final Realm realm = (Realm) proxyState.getRealm$realm();
                final RealmList<magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackParameterEntity> original = value;
                value = new RealmList<magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackParameterEntity>();
                for (magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackParameterEntity item : original) {
                    if (item == null || RealmObject.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.copyToRealm(item));
                    }
                }
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        OsList osList = proxyState.getRow$realm().getModelList(columnInfo.lstPackParameterIndex);
        // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
        if (value != null && value.size() == osList.size()) {
            int objects = value.size();
            for (int i = 0; i < objects; i++) {
                magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackParameterEntity linkedObject = value.get(i);
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
                magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackParameterEntity linkedObject = value.get(i);
                proxyState.checkValidObject(linkedObject);
                osList.addRow(((RealmObjectProxy) linkedObject).realmGet$proxyState().getRow$realm().getIndex());
            }
        }
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$packcode() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.packcodeIndex);
    }

    @Override
    public void realmSet$packcode(int value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'packcode' cannot be changed after object was created.");
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("HealthPackDetailsDBean", 6, 0);
        builder.addPersistedProperty("__type", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("status_code", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("status", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("message", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedLinkProperty("lstPackParameter", RealmFieldType.LIST, "LstPackParameterEntity");
        builder.addPersistedProperty("packcode", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static HealthPackDetailsDBeanColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new HealthPackDetailsDBeanColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "HealthPackDetailsDBean";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDetailsDBean createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(1);
        magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDetailsDBean obj = null;
        if (update) {
            Table table = realm.getTable(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDetailsDBean.class);
            HealthPackDetailsDBeanColumnInfo columnInfo = (HealthPackDetailsDBeanColumnInfo) realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDetailsDBean.class);
            long pkColumnIndex = columnInfo.packcodeIndex;
            long rowIndex = Table.NO_MATCH;
            if (!json.isNull("packcode")) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("packcode"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDetailsDBean.class), false, Collections.<String> emptyList());
                    obj = new io.realm.HealthPackDetailsDBeanRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("lstPackParameter")) {
                excludeFields.add("lstPackParameter");
            }
            if (json.has("packcode")) {
                if (json.isNull("packcode")) {
                    obj = (io.realm.HealthPackDetailsDBeanRealmProxy) realm.createObjectInternal(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDetailsDBean.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.HealthPackDetailsDBeanRealmProxy) realm.createObjectInternal(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDetailsDBean.class, json.getInt("packcode"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'packcode'.");
            }
        }

        final HealthPackDetailsDBeanRealmProxyInterface objProxy = (HealthPackDetailsDBeanRealmProxyInterface) obj;
        if (json.has("__type")) {
            if (json.isNull("__type")) {
                objProxy.realmSet$__type(null);
            } else {
                objProxy.realmSet$__type((String) json.getString("__type"));
            }
        }
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
        if (json.has("lstPackParameter")) {
            if (json.isNull("lstPackParameter")) {
                objProxy.realmSet$lstPackParameter(null);
            } else {
                objProxy.realmGet$lstPackParameter().clear();
                JSONArray array = json.getJSONArray("lstPackParameter");
                for (int i = 0; i < array.length(); i++) {
                    magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackParameterEntity item = LstPackParameterEntityRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    objProxy.realmGet$lstPackParameter().add(item);
                }
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDetailsDBean createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDetailsDBean obj = new magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDetailsDBean();
        final HealthPackDetailsDBeanRealmProxyInterface objProxy = (HealthPackDetailsDBeanRealmProxyInterface) obj;
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
            } else if (name.equals("lstPackParameter")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$lstPackParameter(null);
                } else {
                    objProxy.realmSet$lstPackParameter(new RealmList<magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackParameterEntity>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackParameterEntity item = LstPackParameterEntityRealmProxy.createUsingJsonStream(realm, reader);
                        objProxy.realmGet$lstPackParameter().add(item);
                    }
                    reader.endArray();
                }
            } else if (name.equals("packcode")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$packcode((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'packcode' to null.");
                }
                jsonHasPrimaryKey = true;
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'packcode'.");
        }
        return realm.copyToRealm(obj);
    }

    public static magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDetailsDBean copyOrUpdate(Realm realm, magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDetailsDBean object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDetailsDBean) cachedRealmObject;
        }

        magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDetailsDBean realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDetailsDBean.class);
            HealthPackDetailsDBeanColumnInfo columnInfo = (HealthPackDetailsDBeanColumnInfo) realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDetailsDBean.class);
            long pkColumnIndex = columnInfo.packcodeIndex;
            long rowIndex = table.findFirstLong(pkColumnIndex, ((HealthPackDetailsDBeanRealmProxyInterface) object).realmGet$packcode());
            if (rowIndex == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDetailsDBean.class), false, Collections.<String> emptyList());
                    realmObject = new io.realm.HealthPackDetailsDBeanRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, realmObject, object, cache) : copy(realm, object, update, cache);
    }

    public static magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDetailsDBean copy(Realm realm, magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDetailsDBean newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDetailsDBean) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDetailsDBean realmObject = realm.createObjectInternal(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDetailsDBean.class, ((HealthPackDetailsDBeanRealmProxyInterface) newObject).realmGet$packcode(), false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        HealthPackDetailsDBeanRealmProxyInterface realmObjectSource = (HealthPackDetailsDBeanRealmProxyInterface) newObject;
        HealthPackDetailsDBeanRealmProxyInterface realmObjectCopy = (HealthPackDetailsDBeanRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$__type(realmObjectSource.realmGet$__type());
        realmObjectCopy.realmSet$status_code(realmObjectSource.realmGet$status_code());
        realmObjectCopy.realmSet$status(realmObjectSource.realmGet$status());
        realmObjectCopy.realmSet$message(realmObjectSource.realmGet$message());

        RealmList<magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackParameterEntity> lstPackParameterList = realmObjectSource.realmGet$lstPackParameter();
        if (lstPackParameterList != null) {
            RealmList<magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackParameterEntity> lstPackParameterRealmList = realmObjectCopy.realmGet$lstPackParameter();
            lstPackParameterRealmList.clear();
            for (int i = 0; i < lstPackParameterList.size(); i++) {
                magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackParameterEntity lstPackParameterItem = lstPackParameterList.get(i);
                magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackParameterEntity cachelstPackParameter = (magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackParameterEntity) cache.get(lstPackParameterItem);
                if (cachelstPackParameter != null) {
                    lstPackParameterRealmList.add(cachelstPackParameter);
                } else {
                    lstPackParameterRealmList.add(LstPackParameterEntityRealmProxy.copyOrUpdate(realm, lstPackParameterItem, update, cache));
                }
            }
        }

        return realmObject;
    }

    public static long insert(Realm realm, magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDetailsDBean object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDetailsDBean.class);
        long tableNativePtr = table.getNativePtr();
        HealthPackDetailsDBeanColumnInfo columnInfo = (HealthPackDetailsDBeanColumnInfo) realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDetailsDBean.class);
        long pkColumnIndex = columnInfo.packcodeIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((HealthPackDetailsDBeanRealmProxyInterface) object).realmGet$packcode();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((HealthPackDetailsDBeanRealmProxyInterface) object).realmGet$packcode());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((HealthPackDetailsDBeanRealmProxyInterface) object).realmGet$packcode());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$__type = ((HealthPackDetailsDBeanRealmProxyInterface) object).realmGet$__type();
        if (realmGet$__type != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.__typeIndex, rowIndex, realmGet$__type, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.status_codeIndex, rowIndex, ((HealthPackDetailsDBeanRealmProxyInterface) object).realmGet$status_code(), false);
        String realmGet$status = ((HealthPackDetailsDBeanRealmProxyInterface) object).realmGet$status();
        if (realmGet$status != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.statusIndex, rowIndex, realmGet$status, false);
        }
        String realmGet$message = ((HealthPackDetailsDBeanRealmProxyInterface) object).realmGet$message();
        if (realmGet$message != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.messageIndex, rowIndex, realmGet$message, false);
        }

        RealmList<magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackParameterEntity> lstPackParameterList = ((HealthPackDetailsDBeanRealmProxyInterface) object).realmGet$lstPackParameter();
        if (lstPackParameterList != null) {
            OsList lstPackParameterOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.lstPackParameterIndex);
            for (magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackParameterEntity lstPackParameterItem : lstPackParameterList) {
                Long cacheItemIndexlstPackParameter = cache.get(lstPackParameterItem);
                if (cacheItemIndexlstPackParameter == null) {
                    cacheItemIndexlstPackParameter = LstPackParameterEntityRealmProxy.insert(realm, lstPackParameterItem, cache);
                }
                lstPackParameterOsList.addRow(cacheItemIndexlstPackParameter);
            }
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDetailsDBean.class);
        long tableNativePtr = table.getNativePtr();
        HealthPackDetailsDBeanColumnInfo columnInfo = (HealthPackDetailsDBeanColumnInfo) realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDetailsDBean.class);
        long pkColumnIndex = columnInfo.packcodeIndex;
        magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDetailsDBean object = null;
        while (objects.hasNext()) {
            object = (magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDetailsDBean) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((HealthPackDetailsDBeanRealmProxyInterface) object).realmGet$packcode();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((HealthPackDetailsDBeanRealmProxyInterface) object).realmGet$packcode());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((HealthPackDetailsDBeanRealmProxyInterface) object).realmGet$packcode());
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, rowIndex);
            String realmGet$__type = ((HealthPackDetailsDBeanRealmProxyInterface) object).realmGet$__type();
            if (realmGet$__type != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.__typeIndex, rowIndex, realmGet$__type, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.status_codeIndex, rowIndex, ((HealthPackDetailsDBeanRealmProxyInterface) object).realmGet$status_code(), false);
            String realmGet$status = ((HealthPackDetailsDBeanRealmProxyInterface) object).realmGet$status();
            if (realmGet$status != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.statusIndex, rowIndex, realmGet$status, false);
            }
            String realmGet$message = ((HealthPackDetailsDBeanRealmProxyInterface) object).realmGet$message();
            if (realmGet$message != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.messageIndex, rowIndex, realmGet$message, false);
            }

            RealmList<magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackParameterEntity> lstPackParameterList = ((HealthPackDetailsDBeanRealmProxyInterface) object).realmGet$lstPackParameter();
            if (lstPackParameterList != null) {
                OsList lstPackParameterOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.lstPackParameterIndex);
                for (magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackParameterEntity lstPackParameterItem : lstPackParameterList) {
                    Long cacheItemIndexlstPackParameter = cache.get(lstPackParameterItem);
                    if (cacheItemIndexlstPackParameter == null) {
                        cacheItemIndexlstPackParameter = LstPackParameterEntityRealmProxy.insert(realm, lstPackParameterItem, cache);
                    }
                    lstPackParameterOsList.addRow(cacheItemIndexlstPackParameter);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDetailsDBean object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDetailsDBean.class);
        long tableNativePtr = table.getNativePtr();
        HealthPackDetailsDBeanColumnInfo columnInfo = (HealthPackDetailsDBeanColumnInfo) realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDetailsDBean.class);
        long pkColumnIndex = columnInfo.packcodeIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((HealthPackDetailsDBeanRealmProxyInterface) object).realmGet$packcode();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((HealthPackDetailsDBeanRealmProxyInterface) object).realmGet$packcode());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((HealthPackDetailsDBeanRealmProxyInterface) object).realmGet$packcode());
        }
        cache.put(object, rowIndex);
        String realmGet$__type = ((HealthPackDetailsDBeanRealmProxyInterface) object).realmGet$__type();
        if (realmGet$__type != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.__typeIndex, rowIndex, realmGet$__type, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.__typeIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.status_codeIndex, rowIndex, ((HealthPackDetailsDBeanRealmProxyInterface) object).realmGet$status_code(), false);
        String realmGet$status = ((HealthPackDetailsDBeanRealmProxyInterface) object).realmGet$status();
        if (realmGet$status != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.statusIndex, rowIndex, realmGet$status, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.statusIndex, rowIndex, false);
        }
        String realmGet$message = ((HealthPackDetailsDBeanRealmProxyInterface) object).realmGet$message();
        if (realmGet$message != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.messageIndex, rowIndex, realmGet$message, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.messageIndex, rowIndex, false);
        }

        OsList lstPackParameterOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.lstPackParameterIndex);
        RealmList<magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackParameterEntity> lstPackParameterList = ((HealthPackDetailsDBeanRealmProxyInterface) object).realmGet$lstPackParameter();
        if (lstPackParameterList != null && lstPackParameterList.size() == lstPackParameterOsList.size()) {
            // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
            int objects = lstPackParameterList.size();
            for (int i = 0; i < objects; i++) {
                magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackParameterEntity lstPackParameterItem = lstPackParameterList.get(i);
                Long cacheItemIndexlstPackParameter = cache.get(lstPackParameterItem);
                if (cacheItemIndexlstPackParameter == null) {
                    cacheItemIndexlstPackParameter = LstPackParameterEntityRealmProxy.insertOrUpdate(realm, lstPackParameterItem, cache);
                }
                lstPackParameterOsList.setRow(i, cacheItemIndexlstPackParameter);
            }
        } else {
            lstPackParameterOsList.removeAll();
            if (lstPackParameterList != null) {
                for (magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackParameterEntity lstPackParameterItem : lstPackParameterList) {
                    Long cacheItemIndexlstPackParameter = cache.get(lstPackParameterItem);
                    if (cacheItemIndexlstPackParameter == null) {
                        cacheItemIndexlstPackParameter = LstPackParameterEntityRealmProxy.insertOrUpdate(realm, lstPackParameterItem, cache);
                    }
                    lstPackParameterOsList.addRow(cacheItemIndexlstPackParameter);
                }
            }
        }

        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDetailsDBean.class);
        long tableNativePtr = table.getNativePtr();
        HealthPackDetailsDBeanColumnInfo columnInfo = (HealthPackDetailsDBeanColumnInfo) realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDetailsDBean.class);
        long pkColumnIndex = columnInfo.packcodeIndex;
        magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDetailsDBean object = null;
        while (objects.hasNext()) {
            object = (magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDetailsDBean) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((HealthPackDetailsDBeanRealmProxyInterface) object).realmGet$packcode();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((HealthPackDetailsDBeanRealmProxyInterface) object).realmGet$packcode());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((HealthPackDetailsDBeanRealmProxyInterface) object).realmGet$packcode());
            }
            cache.put(object, rowIndex);
            String realmGet$__type = ((HealthPackDetailsDBeanRealmProxyInterface) object).realmGet$__type();
            if (realmGet$__type != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.__typeIndex, rowIndex, realmGet$__type, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.__typeIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.status_codeIndex, rowIndex, ((HealthPackDetailsDBeanRealmProxyInterface) object).realmGet$status_code(), false);
            String realmGet$status = ((HealthPackDetailsDBeanRealmProxyInterface) object).realmGet$status();
            if (realmGet$status != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.statusIndex, rowIndex, realmGet$status, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.statusIndex, rowIndex, false);
            }
            String realmGet$message = ((HealthPackDetailsDBeanRealmProxyInterface) object).realmGet$message();
            if (realmGet$message != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.messageIndex, rowIndex, realmGet$message, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.messageIndex, rowIndex, false);
            }

            OsList lstPackParameterOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.lstPackParameterIndex);
            RealmList<magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackParameterEntity> lstPackParameterList = ((HealthPackDetailsDBeanRealmProxyInterface) object).realmGet$lstPackParameter();
            if (lstPackParameterList != null && lstPackParameterList.size() == lstPackParameterOsList.size()) {
                // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
                int objectCount = lstPackParameterList.size();
                for (int i = 0; i < objectCount; i++) {
                    magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackParameterEntity lstPackParameterItem = lstPackParameterList.get(i);
                    Long cacheItemIndexlstPackParameter = cache.get(lstPackParameterItem);
                    if (cacheItemIndexlstPackParameter == null) {
                        cacheItemIndexlstPackParameter = LstPackParameterEntityRealmProxy.insertOrUpdate(realm, lstPackParameterItem, cache);
                    }
                    lstPackParameterOsList.setRow(i, cacheItemIndexlstPackParameter);
                }
            } else {
                lstPackParameterOsList.removeAll();
                if (lstPackParameterList != null) {
                    for (magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackParameterEntity lstPackParameterItem : lstPackParameterList) {
                        Long cacheItemIndexlstPackParameter = cache.get(lstPackParameterItem);
                        if (cacheItemIndexlstPackParameter == null) {
                            cacheItemIndexlstPackParameter = LstPackParameterEntityRealmProxy.insertOrUpdate(realm, lstPackParameterItem, cache);
                        }
                        lstPackParameterOsList.addRow(cacheItemIndexlstPackParameter);
                    }
                }
            }

        }
    }

    public static magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDetailsDBean createDetachedCopy(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDetailsDBean realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDetailsDBean unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDetailsDBean();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDetailsDBean) cachedObject.object;
            }
            unmanagedObject = (magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDetailsDBean) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        HealthPackDetailsDBeanRealmProxyInterface unmanagedCopy = (HealthPackDetailsDBeanRealmProxyInterface) unmanagedObject;
        HealthPackDetailsDBeanRealmProxyInterface realmSource = (HealthPackDetailsDBeanRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$__type(realmSource.realmGet$__type());
        unmanagedCopy.realmSet$status_code(realmSource.realmGet$status_code());
        unmanagedCopy.realmSet$status(realmSource.realmGet$status());
        unmanagedCopy.realmSet$message(realmSource.realmGet$message());

        // Deep copy of lstPackParameter
        if (currentDepth == maxDepth) {
            unmanagedCopy.realmSet$lstPackParameter(null);
        } else {
            RealmList<magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackParameterEntity> managedlstPackParameterList = realmSource.realmGet$lstPackParameter();
            RealmList<magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackParameterEntity> unmanagedlstPackParameterList = new RealmList<magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackParameterEntity>();
            unmanagedCopy.realmSet$lstPackParameter(unmanagedlstPackParameterList);
            int nextDepth = currentDepth + 1;
            int size = managedlstPackParameterList.size();
            for (int i = 0; i < size; i++) {
                magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackParameterEntity item = LstPackParameterEntityRealmProxy.createDetachedCopy(managedlstPackParameterList.get(i), nextDepth, maxDepth, cache);
                unmanagedlstPackParameterList.add(item);
            }
        }
        unmanagedCopy.realmSet$packcode(realmSource.realmGet$packcode());

        return unmanagedObject;
    }

    static magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDetailsDBean update(Realm realm, magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDetailsDBean realmObject, magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDetailsDBean newObject, Map<RealmModel, RealmObjectProxy> cache) {
        HealthPackDetailsDBeanRealmProxyInterface realmObjectTarget = (HealthPackDetailsDBeanRealmProxyInterface) realmObject;
        HealthPackDetailsDBeanRealmProxyInterface realmObjectSource = (HealthPackDetailsDBeanRealmProxyInterface) newObject;
        realmObjectTarget.realmSet$__type(realmObjectSource.realmGet$__type());
        realmObjectTarget.realmSet$status_code(realmObjectSource.realmGet$status_code());
        realmObjectTarget.realmSet$status(realmObjectSource.realmGet$status());
        realmObjectTarget.realmSet$message(realmObjectSource.realmGet$message());
        RealmList<magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackParameterEntity> lstPackParameterList = realmObjectSource.realmGet$lstPackParameter();
        RealmList<magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackParameterEntity> lstPackParameterRealmList = realmObjectTarget.realmGet$lstPackParameter();
        if (lstPackParameterList != null && lstPackParameterList.size() == lstPackParameterRealmList.size()) {
            // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
            int objects = lstPackParameterList.size();
            for (int i = 0; i < objects; i++) {
                magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackParameterEntity lstPackParameterItem = lstPackParameterList.get(i);
                magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackParameterEntity cachelstPackParameter = (magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackParameterEntity) cache.get(lstPackParameterItem);
                if (cachelstPackParameter != null) {
                    lstPackParameterRealmList.set(i, cachelstPackParameter);
                } else {
                    lstPackParameterRealmList.set(i, LstPackParameterEntityRealmProxy.copyOrUpdate(realm, lstPackParameterItem, true, cache));
                }
            }
        } else {
            lstPackParameterRealmList.clear();
            if (lstPackParameterList != null) {
                for (int i = 0; i < lstPackParameterList.size(); i++) {
                    magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackParameterEntity lstPackParameterItem = lstPackParameterList.get(i);
                    magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackParameterEntity cachelstPackParameter = (magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackParameterEntity) cache.get(lstPackParameterItem);
                    if (cachelstPackParameter != null) {
                        lstPackParameterRealmList.add(cachelstPackParameter);
                    } else {
                        lstPackParameterRealmList.add(LstPackParameterEntityRealmProxy.copyOrUpdate(realm, lstPackParameterItem, true, cache));
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
        StringBuilder stringBuilder = new StringBuilder("HealthPackDetailsDBean = proxy[");
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
        stringBuilder.append("{lstPackParameter:");
        stringBuilder.append("RealmList<LstPackParameterEntity>[").append(realmGet$lstPackParameter().size()).append("]");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{packcode:");
        stringBuilder.append(realmGet$packcode());
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
        HealthPackDetailsDBeanRealmProxy aHealthPackDetailsDBean = (HealthPackDetailsDBeanRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aHealthPackDetailsDBean.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aHealthPackDetailsDBean.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aHealthPackDetailsDBean.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
