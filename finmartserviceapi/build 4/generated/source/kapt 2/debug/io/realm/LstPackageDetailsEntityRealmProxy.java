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
public class LstPackageDetailsEntityRealmProxy extends magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity
    implements RealmObjectProxy, LstPackageDetailsEntityRealmProxyInterface {

    static final class LstPackageDetailsEntityColumnInfo extends ColumnInfo {
        long PackCodeIndex;
        long PackNameIndex;
        long MRPIndex;
        long OfferPriceIndex;
        long FastingIndex;
        long VisitTypeIndex;
        long cntIndex;
        long GenderIndex;
        long AgeIndex;
        long isVisibleIndex;

        LstPackageDetailsEntityColumnInfo(OsSchemaInfo schemaInfo) {
            super(10);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("LstPackageDetailsEntity");
            this.PackCodeIndex = addColumnDetails("PackCode", objectSchemaInfo);
            this.PackNameIndex = addColumnDetails("PackName", objectSchemaInfo);
            this.MRPIndex = addColumnDetails("MRP", objectSchemaInfo);
            this.OfferPriceIndex = addColumnDetails("OfferPrice", objectSchemaInfo);
            this.FastingIndex = addColumnDetails("Fasting", objectSchemaInfo);
            this.VisitTypeIndex = addColumnDetails("VisitType", objectSchemaInfo);
            this.cntIndex = addColumnDetails("cnt", objectSchemaInfo);
            this.GenderIndex = addColumnDetails("Gender", objectSchemaInfo);
            this.AgeIndex = addColumnDetails("Age", objectSchemaInfo);
            this.isVisibleIndex = addColumnDetails("isVisible", objectSchemaInfo);
        }

        LstPackageDetailsEntityColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new LstPackageDetailsEntityColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final LstPackageDetailsEntityColumnInfo src = (LstPackageDetailsEntityColumnInfo) rawSrc;
            final LstPackageDetailsEntityColumnInfo dst = (LstPackageDetailsEntityColumnInfo) rawDst;
            dst.PackCodeIndex = src.PackCodeIndex;
            dst.PackNameIndex = src.PackNameIndex;
            dst.MRPIndex = src.MRPIndex;
            dst.OfferPriceIndex = src.OfferPriceIndex;
            dst.FastingIndex = src.FastingIndex;
            dst.VisitTypeIndex = src.VisitTypeIndex;
            dst.cntIndex = src.cntIndex;
            dst.GenderIndex = src.GenderIndex;
            dst.AgeIndex = src.AgeIndex;
            dst.isVisibleIndex = src.isVisibleIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>(10);
        fieldNames.add("PackCode");
        fieldNames.add("PackName");
        fieldNames.add("MRP");
        fieldNames.add("OfferPrice");
        fieldNames.add("Fasting");
        fieldNames.add("VisitType");
        fieldNames.add("cnt");
        fieldNames.add("Gender");
        fieldNames.add("Age");
        fieldNames.add("isVisible");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    private LstPackageDetailsEntityColumnInfo columnInfo;
    private ProxyState<magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity> proxyState;

    LstPackageDetailsEntityRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (LstPackageDetailsEntityColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$PackCode() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.PackCodeIndex);
    }

    @Override
    public void realmSet$PackCode(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.PackCodeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.PackCodeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.PackCodeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.PackCodeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$PackName() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.PackNameIndex);
    }

    @Override
    public void realmSet$PackName(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.PackNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.PackNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.PackNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.PackNameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$MRP() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.MRPIndex);
    }

    @Override
    public void realmSet$MRP(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.MRPIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.MRPIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$OfferPrice() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.OfferPriceIndex);
    }

    @Override
    public void realmSet$OfferPrice(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.OfferPriceIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.OfferPriceIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$Fasting() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.FastingIndex);
    }

    @Override
    public void realmSet$Fasting(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.FastingIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.FastingIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.FastingIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.FastingIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$VisitType() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.VisitTypeIndex);
    }

    @Override
    public void realmSet$VisitType(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.VisitTypeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.VisitTypeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.VisitTypeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.VisitTypeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$cnt() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.cntIndex);
    }

    @Override
    public void realmSet$cnt(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.cntIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.cntIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.cntIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.cntIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$Gender() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.GenderIndex);
    }

    @Override
    public void realmSet$Gender(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.GenderIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.GenderIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.GenderIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.GenderIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$Age() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.AgeIndex);
    }

    @Override
    public void realmSet$Age(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.AgeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.AgeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.AgeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.AgeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$isVisible() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.isVisibleIndex);
    }

    @Override
    public void realmSet$isVisible(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.isVisibleIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.isVisibleIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("LstPackageDetailsEntity", 10, 0);
        builder.addPersistedProperty("PackCode", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("PackName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("MRP", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("OfferPrice", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("Fasting", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("VisitType", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("cnt", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("Gender", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("Age", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("isVisible", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static LstPackageDetailsEntityColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new LstPackageDetailsEntityColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "LstPackageDetailsEntity";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity obj = realm.createObjectInternal(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity.class, true, excludeFields);

        final LstPackageDetailsEntityRealmProxyInterface objProxy = (LstPackageDetailsEntityRealmProxyInterface) obj;
        if (json.has("PackCode")) {
            if (json.isNull("PackCode")) {
                objProxy.realmSet$PackCode(null);
            } else {
                objProxy.realmSet$PackCode((String) json.getString("PackCode"));
            }
        }
        if (json.has("PackName")) {
            if (json.isNull("PackName")) {
                objProxy.realmSet$PackName(null);
            } else {
                objProxy.realmSet$PackName((String) json.getString("PackName"));
            }
        }
        if (json.has("MRP")) {
            if (json.isNull("MRP")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'MRP' to null.");
            } else {
                objProxy.realmSet$MRP((int) json.getInt("MRP"));
            }
        }
        if (json.has("OfferPrice")) {
            if (json.isNull("OfferPrice")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'OfferPrice' to null.");
            } else {
                objProxy.realmSet$OfferPrice((int) json.getInt("OfferPrice"));
            }
        }
        if (json.has("Fasting")) {
            if (json.isNull("Fasting")) {
                objProxy.realmSet$Fasting(null);
            } else {
                objProxy.realmSet$Fasting((String) json.getString("Fasting"));
            }
        }
        if (json.has("VisitType")) {
            if (json.isNull("VisitType")) {
                objProxy.realmSet$VisitType(null);
            } else {
                objProxy.realmSet$VisitType((String) json.getString("VisitType"));
            }
        }
        if (json.has("cnt")) {
            if (json.isNull("cnt")) {
                objProxy.realmSet$cnt(null);
            } else {
                objProxy.realmSet$cnt((String) json.getString("cnt"));
            }
        }
        if (json.has("Gender")) {
            if (json.isNull("Gender")) {
                objProxy.realmSet$Gender(null);
            } else {
                objProxy.realmSet$Gender((String) json.getString("Gender"));
            }
        }
        if (json.has("Age")) {
            if (json.isNull("Age")) {
                objProxy.realmSet$Age(null);
            } else {
                objProxy.realmSet$Age((String) json.getString("Age"));
            }
        }
        if (json.has("isVisible")) {
            if (json.isNull("isVisible")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'isVisible' to null.");
            } else {
                objProxy.realmSet$isVisible((boolean) json.getBoolean("isVisible"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity obj = new magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity();
        final LstPackageDetailsEntityRealmProxyInterface objProxy = (LstPackageDetailsEntityRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("PackCode")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$PackCode((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$PackCode(null);
                }
            } else if (name.equals("PackName")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$PackName((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$PackName(null);
                }
            } else if (name.equals("MRP")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$MRP((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'MRP' to null.");
                }
            } else if (name.equals("OfferPrice")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$OfferPrice((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'OfferPrice' to null.");
                }
            } else if (name.equals("Fasting")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$Fasting((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$Fasting(null);
                }
            } else if (name.equals("VisitType")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$VisitType((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$VisitType(null);
                }
            } else if (name.equals("cnt")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$cnt((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$cnt(null);
                }
            } else if (name.equals("Gender")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$Gender((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$Gender(null);
                }
            } else if (name.equals("Age")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$Age((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$Age(null);
                }
            } else if (name.equals("isVisible")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$isVisible((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'isVisible' to null.");
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    public static magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity copyOrUpdate(Realm realm, magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity) cachedRealmObject;
        }

        return copy(realm, object, update, cache);
    }

    public static magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity copy(Realm realm, magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity realmObject = realm.createObjectInternal(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity.class, false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        LstPackageDetailsEntityRealmProxyInterface realmObjectSource = (LstPackageDetailsEntityRealmProxyInterface) newObject;
        LstPackageDetailsEntityRealmProxyInterface realmObjectCopy = (LstPackageDetailsEntityRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$PackCode(realmObjectSource.realmGet$PackCode());
        realmObjectCopy.realmSet$PackName(realmObjectSource.realmGet$PackName());
        realmObjectCopy.realmSet$MRP(realmObjectSource.realmGet$MRP());
        realmObjectCopy.realmSet$OfferPrice(realmObjectSource.realmGet$OfferPrice());
        realmObjectCopy.realmSet$Fasting(realmObjectSource.realmGet$Fasting());
        realmObjectCopy.realmSet$VisitType(realmObjectSource.realmGet$VisitType());
        realmObjectCopy.realmSet$cnt(realmObjectSource.realmGet$cnt());
        realmObjectCopy.realmSet$Gender(realmObjectSource.realmGet$Gender());
        realmObjectCopy.realmSet$Age(realmObjectSource.realmGet$Age());
        realmObjectCopy.realmSet$isVisible(realmObjectSource.realmGet$isVisible());
        return realmObject;
    }

    public static long insert(Realm realm, magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity.class);
        long tableNativePtr = table.getNativePtr();
        LstPackageDetailsEntityColumnInfo columnInfo = (LstPackageDetailsEntityColumnInfo) realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$PackCode = ((LstPackageDetailsEntityRealmProxyInterface) object).realmGet$PackCode();
        if (realmGet$PackCode != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.PackCodeIndex, rowIndex, realmGet$PackCode, false);
        }
        String realmGet$PackName = ((LstPackageDetailsEntityRealmProxyInterface) object).realmGet$PackName();
        if (realmGet$PackName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.PackNameIndex, rowIndex, realmGet$PackName, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.MRPIndex, rowIndex, ((LstPackageDetailsEntityRealmProxyInterface) object).realmGet$MRP(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.OfferPriceIndex, rowIndex, ((LstPackageDetailsEntityRealmProxyInterface) object).realmGet$OfferPrice(), false);
        String realmGet$Fasting = ((LstPackageDetailsEntityRealmProxyInterface) object).realmGet$Fasting();
        if (realmGet$Fasting != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.FastingIndex, rowIndex, realmGet$Fasting, false);
        }
        String realmGet$VisitType = ((LstPackageDetailsEntityRealmProxyInterface) object).realmGet$VisitType();
        if (realmGet$VisitType != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.VisitTypeIndex, rowIndex, realmGet$VisitType, false);
        }
        String realmGet$cnt = ((LstPackageDetailsEntityRealmProxyInterface) object).realmGet$cnt();
        if (realmGet$cnt != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.cntIndex, rowIndex, realmGet$cnt, false);
        }
        String realmGet$Gender = ((LstPackageDetailsEntityRealmProxyInterface) object).realmGet$Gender();
        if (realmGet$Gender != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.GenderIndex, rowIndex, realmGet$Gender, false);
        }
        String realmGet$Age = ((LstPackageDetailsEntityRealmProxyInterface) object).realmGet$Age();
        if (realmGet$Age != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.AgeIndex, rowIndex, realmGet$Age, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.isVisibleIndex, rowIndex, ((LstPackageDetailsEntityRealmProxyInterface) object).realmGet$isVisible(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity.class);
        long tableNativePtr = table.getNativePtr();
        LstPackageDetailsEntityColumnInfo columnInfo = (LstPackageDetailsEntityColumnInfo) realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity.class);
        magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity object = null;
        while (objects.hasNext()) {
            object = (magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$PackCode = ((LstPackageDetailsEntityRealmProxyInterface) object).realmGet$PackCode();
            if (realmGet$PackCode != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.PackCodeIndex, rowIndex, realmGet$PackCode, false);
            }
            String realmGet$PackName = ((LstPackageDetailsEntityRealmProxyInterface) object).realmGet$PackName();
            if (realmGet$PackName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.PackNameIndex, rowIndex, realmGet$PackName, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.MRPIndex, rowIndex, ((LstPackageDetailsEntityRealmProxyInterface) object).realmGet$MRP(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.OfferPriceIndex, rowIndex, ((LstPackageDetailsEntityRealmProxyInterface) object).realmGet$OfferPrice(), false);
            String realmGet$Fasting = ((LstPackageDetailsEntityRealmProxyInterface) object).realmGet$Fasting();
            if (realmGet$Fasting != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.FastingIndex, rowIndex, realmGet$Fasting, false);
            }
            String realmGet$VisitType = ((LstPackageDetailsEntityRealmProxyInterface) object).realmGet$VisitType();
            if (realmGet$VisitType != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.VisitTypeIndex, rowIndex, realmGet$VisitType, false);
            }
            String realmGet$cnt = ((LstPackageDetailsEntityRealmProxyInterface) object).realmGet$cnt();
            if (realmGet$cnt != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.cntIndex, rowIndex, realmGet$cnt, false);
            }
            String realmGet$Gender = ((LstPackageDetailsEntityRealmProxyInterface) object).realmGet$Gender();
            if (realmGet$Gender != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.GenderIndex, rowIndex, realmGet$Gender, false);
            }
            String realmGet$Age = ((LstPackageDetailsEntityRealmProxyInterface) object).realmGet$Age();
            if (realmGet$Age != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.AgeIndex, rowIndex, realmGet$Age, false);
            }
            Table.nativeSetBoolean(tableNativePtr, columnInfo.isVisibleIndex, rowIndex, ((LstPackageDetailsEntityRealmProxyInterface) object).realmGet$isVisible(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity.class);
        long tableNativePtr = table.getNativePtr();
        LstPackageDetailsEntityColumnInfo columnInfo = (LstPackageDetailsEntityColumnInfo) realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$PackCode = ((LstPackageDetailsEntityRealmProxyInterface) object).realmGet$PackCode();
        if (realmGet$PackCode != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.PackCodeIndex, rowIndex, realmGet$PackCode, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.PackCodeIndex, rowIndex, false);
        }
        String realmGet$PackName = ((LstPackageDetailsEntityRealmProxyInterface) object).realmGet$PackName();
        if (realmGet$PackName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.PackNameIndex, rowIndex, realmGet$PackName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.PackNameIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.MRPIndex, rowIndex, ((LstPackageDetailsEntityRealmProxyInterface) object).realmGet$MRP(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.OfferPriceIndex, rowIndex, ((LstPackageDetailsEntityRealmProxyInterface) object).realmGet$OfferPrice(), false);
        String realmGet$Fasting = ((LstPackageDetailsEntityRealmProxyInterface) object).realmGet$Fasting();
        if (realmGet$Fasting != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.FastingIndex, rowIndex, realmGet$Fasting, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.FastingIndex, rowIndex, false);
        }
        String realmGet$VisitType = ((LstPackageDetailsEntityRealmProxyInterface) object).realmGet$VisitType();
        if (realmGet$VisitType != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.VisitTypeIndex, rowIndex, realmGet$VisitType, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.VisitTypeIndex, rowIndex, false);
        }
        String realmGet$cnt = ((LstPackageDetailsEntityRealmProxyInterface) object).realmGet$cnt();
        if (realmGet$cnt != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.cntIndex, rowIndex, realmGet$cnt, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.cntIndex, rowIndex, false);
        }
        String realmGet$Gender = ((LstPackageDetailsEntityRealmProxyInterface) object).realmGet$Gender();
        if (realmGet$Gender != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.GenderIndex, rowIndex, realmGet$Gender, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.GenderIndex, rowIndex, false);
        }
        String realmGet$Age = ((LstPackageDetailsEntityRealmProxyInterface) object).realmGet$Age();
        if (realmGet$Age != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.AgeIndex, rowIndex, realmGet$Age, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.AgeIndex, rowIndex, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.isVisibleIndex, rowIndex, ((LstPackageDetailsEntityRealmProxyInterface) object).realmGet$isVisible(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity.class);
        long tableNativePtr = table.getNativePtr();
        LstPackageDetailsEntityColumnInfo columnInfo = (LstPackageDetailsEntityColumnInfo) realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity.class);
        magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity object = null;
        while (objects.hasNext()) {
            object = (magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$PackCode = ((LstPackageDetailsEntityRealmProxyInterface) object).realmGet$PackCode();
            if (realmGet$PackCode != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.PackCodeIndex, rowIndex, realmGet$PackCode, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.PackCodeIndex, rowIndex, false);
            }
            String realmGet$PackName = ((LstPackageDetailsEntityRealmProxyInterface) object).realmGet$PackName();
            if (realmGet$PackName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.PackNameIndex, rowIndex, realmGet$PackName, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.PackNameIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.MRPIndex, rowIndex, ((LstPackageDetailsEntityRealmProxyInterface) object).realmGet$MRP(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.OfferPriceIndex, rowIndex, ((LstPackageDetailsEntityRealmProxyInterface) object).realmGet$OfferPrice(), false);
            String realmGet$Fasting = ((LstPackageDetailsEntityRealmProxyInterface) object).realmGet$Fasting();
            if (realmGet$Fasting != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.FastingIndex, rowIndex, realmGet$Fasting, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.FastingIndex, rowIndex, false);
            }
            String realmGet$VisitType = ((LstPackageDetailsEntityRealmProxyInterface) object).realmGet$VisitType();
            if (realmGet$VisitType != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.VisitTypeIndex, rowIndex, realmGet$VisitType, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.VisitTypeIndex, rowIndex, false);
            }
            String realmGet$cnt = ((LstPackageDetailsEntityRealmProxyInterface) object).realmGet$cnt();
            if (realmGet$cnt != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.cntIndex, rowIndex, realmGet$cnt, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.cntIndex, rowIndex, false);
            }
            String realmGet$Gender = ((LstPackageDetailsEntityRealmProxyInterface) object).realmGet$Gender();
            if (realmGet$Gender != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.GenderIndex, rowIndex, realmGet$Gender, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.GenderIndex, rowIndex, false);
            }
            String realmGet$Age = ((LstPackageDetailsEntityRealmProxyInterface) object).realmGet$Age();
            if (realmGet$Age != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.AgeIndex, rowIndex, realmGet$Age, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.AgeIndex, rowIndex, false);
            }
            Table.nativeSetBoolean(tableNativePtr, columnInfo.isVisibleIndex, rowIndex, ((LstPackageDetailsEntityRealmProxyInterface) object).realmGet$isVisible(), false);
        }
    }

    public static magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity createDetachedCopy(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity) cachedObject.object;
            }
            unmanagedObject = (magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        LstPackageDetailsEntityRealmProxyInterface unmanagedCopy = (LstPackageDetailsEntityRealmProxyInterface) unmanagedObject;
        LstPackageDetailsEntityRealmProxyInterface realmSource = (LstPackageDetailsEntityRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$PackCode(realmSource.realmGet$PackCode());
        unmanagedCopy.realmSet$PackName(realmSource.realmGet$PackName());
        unmanagedCopy.realmSet$MRP(realmSource.realmGet$MRP());
        unmanagedCopy.realmSet$OfferPrice(realmSource.realmGet$OfferPrice());
        unmanagedCopy.realmSet$Fasting(realmSource.realmGet$Fasting());
        unmanagedCopy.realmSet$VisitType(realmSource.realmGet$VisitType());
        unmanagedCopy.realmSet$cnt(realmSource.realmGet$cnt());
        unmanagedCopy.realmSet$Gender(realmSource.realmGet$Gender());
        unmanagedCopy.realmSet$Age(realmSource.realmGet$Age());
        unmanagedCopy.realmSet$isVisible(realmSource.realmGet$isVisible());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("LstPackageDetailsEntity = proxy[");
        stringBuilder.append("{PackCode:");
        stringBuilder.append(realmGet$PackCode() != null ? realmGet$PackCode() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{PackName:");
        stringBuilder.append(realmGet$PackName() != null ? realmGet$PackName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{MRP:");
        stringBuilder.append(realmGet$MRP());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{OfferPrice:");
        stringBuilder.append(realmGet$OfferPrice());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{Fasting:");
        stringBuilder.append(realmGet$Fasting() != null ? realmGet$Fasting() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{VisitType:");
        stringBuilder.append(realmGet$VisitType() != null ? realmGet$VisitType() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{cnt:");
        stringBuilder.append(realmGet$cnt() != null ? realmGet$cnt() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{Gender:");
        stringBuilder.append(realmGet$Gender() != null ? realmGet$Gender() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{Age:");
        stringBuilder.append(realmGet$Age() != null ? realmGet$Age() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{isVisible:");
        stringBuilder.append(realmGet$isVisible());
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
        LstPackageDetailsEntityRealmProxy aLstPackageDetailsEntity = (LstPackageDetailsEntityRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aLstPackageDetailsEntity.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aLstPackageDetailsEntity.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aLstPackageDetailsEntity.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
