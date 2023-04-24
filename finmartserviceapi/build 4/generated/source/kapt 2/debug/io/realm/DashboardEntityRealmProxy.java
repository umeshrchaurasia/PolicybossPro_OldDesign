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
public class DashboardEntityRealmProxy extends magicfinmart.datacomp.com.finmartserviceapi.model.DashboardEntity
    implements RealmObjectProxy, DashboardEntityRealmProxyInterface {

    static final class DashboardEntityColumnInfo extends ColumnInfo {
        long typeIndex;
        long productIdIndex;
        long productNameIndex;
        long productDetailsIndex;
        long linkIndex;
        long serverIconIndex;
        long IdIndex;
        long KnameIndex;
        long ETitleIndex;
        long HTitleIndex;
        long MTitleIndex;
        long GTitleIndex;
        long EDescIndex;
        long HDescIndex;
        long MDescIndex;
        long GDescIndex;
        long iconIndex;

        DashboardEntityColumnInfo(OsSchemaInfo schemaInfo) {
            super(17);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("DashboardEntity");
            this.typeIndex = addColumnDetails("type", objectSchemaInfo);
            this.productIdIndex = addColumnDetails("productId", objectSchemaInfo);
            this.productNameIndex = addColumnDetails("productName", objectSchemaInfo);
            this.productDetailsIndex = addColumnDetails("productDetails", objectSchemaInfo);
            this.linkIndex = addColumnDetails("link", objectSchemaInfo);
            this.serverIconIndex = addColumnDetails("serverIcon", objectSchemaInfo);
            this.IdIndex = addColumnDetails("Id", objectSchemaInfo);
            this.KnameIndex = addColumnDetails("Kname", objectSchemaInfo);
            this.ETitleIndex = addColumnDetails("ETitle", objectSchemaInfo);
            this.HTitleIndex = addColumnDetails("HTitle", objectSchemaInfo);
            this.MTitleIndex = addColumnDetails("MTitle", objectSchemaInfo);
            this.GTitleIndex = addColumnDetails("GTitle", objectSchemaInfo);
            this.EDescIndex = addColumnDetails("EDesc", objectSchemaInfo);
            this.HDescIndex = addColumnDetails("HDesc", objectSchemaInfo);
            this.MDescIndex = addColumnDetails("MDesc", objectSchemaInfo);
            this.GDescIndex = addColumnDetails("GDesc", objectSchemaInfo);
            this.iconIndex = addColumnDetails("icon", objectSchemaInfo);
        }

        DashboardEntityColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new DashboardEntityColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final DashboardEntityColumnInfo src = (DashboardEntityColumnInfo) rawSrc;
            final DashboardEntityColumnInfo dst = (DashboardEntityColumnInfo) rawDst;
            dst.typeIndex = src.typeIndex;
            dst.productIdIndex = src.productIdIndex;
            dst.productNameIndex = src.productNameIndex;
            dst.productDetailsIndex = src.productDetailsIndex;
            dst.linkIndex = src.linkIndex;
            dst.serverIconIndex = src.serverIconIndex;
            dst.IdIndex = src.IdIndex;
            dst.KnameIndex = src.KnameIndex;
            dst.ETitleIndex = src.ETitleIndex;
            dst.HTitleIndex = src.HTitleIndex;
            dst.MTitleIndex = src.MTitleIndex;
            dst.GTitleIndex = src.GTitleIndex;
            dst.EDescIndex = src.EDescIndex;
            dst.HDescIndex = src.HDescIndex;
            dst.MDescIndex = src.MDescIndex;
            dst.GDescIndex = src.GDescIndex;
            dst.iconIndex = src.iconIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>(17);
        fieldNames.add("type");
        fieldNames.add("productId");
        fieldNames.add("productName");
        fieldNames.add("productDetails");
        fieldNames.add("link");
        fieldNames.add("serverIcon");
        fieldNames.add("Id");
        fieldNames.add("Kname");
        fieldNames.add("ETitle");
        fieldNames.add("HTitle");
        fieldNames.add("MTitle");
        fieldNames.add("GTitle");
        fieldNames.add("EDesc");
        fieldNames.add("HDesc");
        fieldNames.add("MDesc");
        fieldNames.add("GDesc");
        fieldNames.add("icon");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    private DashboardEntityColumnInfo columnInfo;
    private ProxyState<magicfinmart.datacomp.com.finmartserviceapi.model.DashboardEntity> proxyState;

    DashboardEntityRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (DashboardEntityColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<magicfinmart.datacomp.com.finmartserviceapi.model.DashboardEntity>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$type() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.typeIndex);
    }

    @Override
    public void realmSet$type(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.typeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.typeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.typeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.typeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$productId() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.productIdIndex);
    }

    @Override
    public void realmSet$productId(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.productIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.productIdIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$productName() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.productNameIndex);
    }

    @Override
    public void realmSet$productName(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.productNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.productNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.productNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.productNameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$productDetails() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.productDetailsIndex);
    }

    @Override
    public void realmSet$productDetails(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.productDetailsIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.productDetailsIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.productDetailsIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.productDetailsIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$link() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.linkIndex);
    }

    @Override
    public void realmSet$link(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.linkIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.linkIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.linkIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.linkIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$serverIcon() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.serverIconIndex);
    }

    @Override
    public void realmSet$serverIcon(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.serverIconIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.serverIconIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.serverIconIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.serverIconIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$Id() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.IdIndex);
    }

    @Override
    public void realmSet$Id(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.IdIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.IdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.IdIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.IdIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$Kname() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.KnameIndex);
    }

    @Override
    public void realmSet$Kname(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.KnameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.KnameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.KnameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.KnameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$ETitle() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.ETitleIndex);
    }

    @Override
    public void realmSet$ETitle(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.ETitleIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.ETitleIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.ETitleIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.ETitleIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$HTitle() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.HTitleIndex);
    }

    @Override
    public void realmSet$HTitle(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.HTitleIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.HTitleIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.HTitleIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.HTitleIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$MTitle() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.MTitleIndex);
    }

    @Override
    public void realmSet$MTitle(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.MTitleIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.MTitleIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.MTitleIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.MTitleIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$GTitle() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.GTitleIndex);
    }

    @Override
    public void realmSet$GTitle(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.GTitleIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.GTitleIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.GTitleIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.GTitleIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$EDesc() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.EDescIndex);
    }

    @Override
    public void realmSet$EDesc(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.EDescIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.EDescIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.EDescIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.EDescIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$HDesc() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.HDescIndex);
    }

    @Override
    public void realmSet$HDesc(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.HDescIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.HDescIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.HDescIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.HDescIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$MDesc() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.MDescIndex);
    }

    @Override
    public void realmSet$MDesc(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.MDescIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.MDescIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.MDescIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.MDescIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$GDesc() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.GDescIndex);
    }

    @Override
    public void realmSet$GDesc(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.GDescIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.GDescIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.GDescIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.GDescIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$icon() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.iconIndex);
    }

    @Override
    public void realmSet$icon(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.iconIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.iconIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("DashboardEntity", 17, 0);
        builder.addPersistedProperty("type", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("productId", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("productName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("productDetails", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("link", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("serverIcon", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("Id", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("Kname", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("ETitle", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("HTitle", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("MTitle", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("GTitle", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("EDesc", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("HDesc", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("MDesc", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("GDesc", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("icon", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static DashboardEntityColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new DashboardEntityColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "DashboardEntity";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static magicfinmart.datacomp.com.finmartserviceapi.model.DashboardEntity createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        magicfinmart.datacomp.com.finmartserviceapi.model.DashboardEntity obj = realm.createObjectInternal(magicfinmart.datacomp.com.finmartserviceapi.model.DashboardEntity.class, true, excludeFields);

        final DashboardEntityRealmProxyInterface objProxy = (DashboardEntityRealmProxyInterface) obj;
        if (json.has("type")) {
            if (json.isNull("type")) {
                objProxy.realmSet$type(null);
            } else {
                objProxy.realmSet$type((String) json.getString("type"));
            }
        }
        if (json.has("productId")) {
            if (json.isNull("productId")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'productId' to null.");
            } else {
                objProxy.realmSet$productId((int) json.getInt("productId"));
            }
        }
        if (json.has("productName")) {
            if (json.isNull("productName")) {
                objProxy.realmSet$productName(null);
            } else {
                objProxy.realmSet$productName((String) json.getString("productName"));
            }
        }
        if (json.has("productDetails")) {
            if (json.isNull("productDetails")) {
                objProxy.realmSet$productDetails(null);
            } else {
                objProxy.realmSet$productDetails((String) json.getString("productDetails"));
            }
        }
        if (json.has("link")) {
            if (json.isNull("link")) {
                objProxy.realmSet$link(null);
            } else {
                objProxy.realmSet$link((String) json.getString("link"));
            }
        }
        if (json.has("serverIcon")) {
            if (json.isNull("serverIcon")) {
                objProxy.realmSet$serverIcon(null);
            } else {
                objProxy.realmSet$serverIcon((String) json.getString("serverIcon"));
            }
        }
        if (json.has("Id")) {
            if (json.isNull("Id")) {
                objProxy.realmSet$Id(null);
            } else {
                objProxy.realmSet$Id((String) json.getString("Id"));
            }
        }
        if (json.has("Kname")) {
            if (json.isNull("Kname")) {
                objProxy.realmSet$Kname(null);
            } else {
                objProxy.realmSet$Kname((String) json.getString("Kname"));
            }
        }
        if (json.has("ETitle")) {
            if (json.isNull("ETitle")) {
                objProxy.realmSet$ETitle(null);
            } else {
                objProxy.realmSet$ETitle((String) json.getString("ETitle"));
            }
        }
        if (json.has("HTitle")) {
            if (json.isNull("HTitle")) {
                objProxy.realmSet$HTitle(null);
            } else {
                objProxy.realmSet$HTitle((String) json.getString("HTitle"));
            }
        }
        if (json.has("MTitle")) {
            if (json.isNull("MTitle")) {
                objProxy.realmSet$MTitle(null);
            } else {
                objProxy.realmSet$MTitle((String) json.getString("MTitle"));
            }
        }
        if (json.has("GTitle")) {
            if (json.isNull("GTitle")) {
                objProxy.realmSet$GTitle(null);
            } else {
                objProxy.realmSet$GTitle((String) json.getString("GTitle"));
            }
        }
        if (json.has("EDesc")) {
            if (json.isNull("EDesc")) {
                objProxy.realmSet$EDesc(null);
            } else {
                objProxy.realmSet$EDesc((String) json.getString("EDesc"));
            }
        }
        if (json.has("HDesc")) {
            if (json.isNull("HDesc")) {
                objProxy.realmSet$HDesc(null);
            } else {
                objProxy.realmSet$HDesc((String) json.getString("HDesc"));
            }
        }
        if (json.has("MDesc")) {
            if (json.isNull("MDesc")) {
                objProxy.realmSet$MDesc(null);
            } else {
                objProxy.realmSet$MDesc((String) json.getString("MDesc"));
            }
        }
        if (json.has("GDesc")) {
            if (json.isNull("GDesc")) {
                objProxy.realmSet$GDesc(null);
            } else {
                objProxy.realmSet$GDesc((String) json.getString("GDesc"));
            }
        }
        if (json.has("icon")) {
            if (json.isNull("icon")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'icon' to null.");
            } else {
                objProxy.realmSet$icon((int) json.getInt("icon"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static magicfinmart.datacomp.com.finmartserviceapi.model.DashboardEntity createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final magicfinmart.datacomp.com.finmartserviceapi.model.DashboardEntity obj = new magicfinmart.datacomp.com.finmartserviceapi.model.DashboardEntity();
        final DashboardEntityRealmProxyInterface objProxy = (DashboardEntityRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("type")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$type((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$type(null);
                }
            } else if (name.equals("productId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$productId((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'productId' to null.");
                }
            } else if (name.equals("productName")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$productName((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$productName(null);
                }
            } else if (name.equals("productDetails")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$productDetails((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$productDetails(null);
                }
            } else if (name.equals("link")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$link((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$link(null);
                }
            } else if (name.equals("serverIcon")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$serverIcon((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$serverIcon(null);
                }
            } else if (name.equals("Id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$Id((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$Id(null);
                }
            } else if (name.equals("Kname")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$Kname((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$Kname(null);
                }
            } else if (name.equals("ETitle")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$ETitle((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$ETitle(null);
                }
            } else if (name.equals("HTitle")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$HTitle((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$HTitle(null);
                }
            } else if (name.equals("MTitle")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$MTitle((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$MTitle(null);
                }
            } else if (name.equals("GTitle")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$GTitle((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$GTitle(null);
                }
            } else if (name.equals("EDesc")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$EDesc((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$EDesc(null);
                }
            } else if (name.equals("HDesc")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$HDesc((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$HDesc(null);
                }
            } else if (name.equals("MDesc")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$MDesc((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$MDesc(null);
                }
            } else if (name.equals("GDesc")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$GDesc((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$GDesc(null);
                }
            } else if (name.equals("icon")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$icon((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'icon' to null.");
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    public static magicfinmart.datacomp.com.finmartserviceapi.model.DashboardEntity copyOrUpdate(Realm realm, magicfinmart.datacomp.com.finmartserviceapi.model.DashboardEntity object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (magicfinmart.datacomp.com.finmartserviceapi.model.DashboardEntity) cachedRealmObject;
        }

        return copy(realm, object, update, cache);
    }

    public static magicfinmart.datacomp.com.finmartserviceapi.model.DashboardEntity copy(Realm realm, magicfinmart.datacomp.com.finmartserviceapi.model.DashboardEntity newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (magicfinmart.datacomp.com.finmartserviceapi.model.DashboardEntity) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        magicfinmart.datacomp.com.finmartserviceapi.model.DashboardEntity realmObject = realm.createObjectInternal(magicfinmart.datacomp.com.finmartserviceapi.model.DashboardEntity.class, false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        DashboardEntityRealmProxyInterface realmObjectSource = (DashboardEntityRealmProxyInterface) newObject;
        DashboardEntityRealmProxyInterface realmObjectCopy = (DashboardEntityRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$type(realmObjectSource.realmGet$type());
        realmObjectCopy.realmSet$productId(realmObjectSource.realmGet$productId());
        realmObjectCopy.realmSet$productName(realmObjectSource.realmGet$productName());
        realmObjectCopy.realmSet$productDetails(realmObjectSource.realmGet$productDetails());
        realmObjectCopy.realmSet$link(realmObjectSource.realmGet$link());
        realmObjectCopy.realmSet$serverIcon(realmObjectSource.realmGet$serverIcon());
        realmObjectCopy.realmSet$Id(realmObjectSource.realmGet$Id());
        realmObjectCopy.realmSet$Kname(realmObjectSource.realmGet$Kname());
        realmObjectCopy.realmSet$ETitle(realmObjectSource.realmGet$ETitle());
        realmObjectCopy.realmSet$HTitle(realmObjectSource.realmGet$HTitle());
        realmObjectCopy.realmSet$MTitle(realmObjectSource.realmGet$MTitle());
        realmObjectCopy.realmSet$GTitle(realmObjectSource.realmGet$GTitle());
        realmObjectCopy.realmSet$EDesc(realmObjectSource.realmGet$EDesc());
        realmObjectCopy.realmSet$HDesc(realmObjectSource.realmGet$HDesc());
        realmObjectCopy.realmSet$MDesc(realmObjectSource.realmGet$MDesc());
        realmObjectCopy.realmSet$GDesc(realmObjectSource.realmGet$GDesc());
        realmObjectCopy.realmSet$icon(realmObjectSource.realmGet$icon());
        return realmObject;
    }

    public static long insert(Realm realm, magicfinmart.datacomp.com.finmartserviceapi.model.DashboardEntity object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(magicfinmart.datacomp.com.finmartserviceapi.model.DashboardEntity.class);
        long tableNativePtr = table.getNativePtr();
        DashboardEntityColumnInfo columnInfo = (DashboardEntityColumnInfo) realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.model.DashboardEntity.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$type = ((DashboardEntityRealmProxyInterface) object).realmGet$type();
        if (realmGet$type != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.typeIndex, rowIndex, realmGet$type, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.productIdIndex, rowIndex, ((DashboardEntityRealmProxyInterface) object).realmGet$productId(), false);
        String realmGet$productName = ((DashboardEntityRealmProxyInterface) object).realmGet$productName();
        if (realmGet$productName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.productNameIndex, rowIndex, realmGet$productName, false);
        }
        String realmGet$productDetails = ((DashboardEntityRealmProxyInterface) object).realmGet$productDetails();
        if (realmGet$productDetails != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.productDetailsIndex, rowIndex, realmGet$productDetails, false);
        }
        String realmGet$link = ((DashboardEntityRealmProxyInterface) object).realmGet$link();
        if (realmGet$link != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.linkIndex, rowIndex, realmGet$link, false);
        }
        String realmGet$serverIcon = ((DashboardEntityRealmProxyInterface) object).realmGet$serverIcon();
        if (realmGet$serverIcon != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.serverIconIndex, rowIndex, realmGet$serverIcon, false);
        }
        String realmGet$Id = ((DashboardEntityRealmProxyInterface) object).realmGet$Id();
        if (realmGet$Id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.IdIndex, rowIndex, realmGet$Id, false);
        }
        String realmGet$Kname = ((DashboardEntityRealmProxyInterface) object).realmGet$Kname();
        if (realmGet$Kname != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.KnameIndex, rowIndex, realmGet$Kname, false);
        }
        String realmGet$ETitle = ((DashboardEntityRealmProxyInterface) object).realmGet$ETitle();
        if (realmGet$ETitle != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.ETitleIndex, rowIndex, realmGet$ETitle, false);
        }
        String realmGet$HTitle = ((DashboardEntityRealmProxyInterface) object).realmGet$HTitle();
        if (realmGet$HTitle != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.HTitleIndex, rowIndex, realmGet$HTitle, false);
        }
        String realmGet$MTitle = ((DashboardEntityRealmProxyInterface) object).realmGet$MTitle();
        if (realmGet$MTitle != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.MTitleIndex, rowIndex, realmGet$MTitle, false);
        }
        String realmGet$GTitle = ((DashboardEntityRealmProxyInterface) object).realmGet$GTitle();
        if (realmGet$GTitle != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.GTitleIndex, rowIndex, realmGet$GTitle, false);
        }
        String realmGet$EDesc = ((DashboardEntityRealmProxyInterface) object).realmGet$EDesc();
        if (realmGet$EDesc != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.EDescIndex, rowIndex, realmGet$EDesc, false);
        }
        String realmGet$HDesc = ((DashboardEntityRealmProxyInterface) object).realmGet$HDesc();
        if (realmGet$HDesc != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.HDescIndex, rowIndex, realmGet$HDesc, false);
        }
        String realmGet$MDesc = ((DashboardEntityRealmProxyInterface) object).realmGet$MDesc();
        if (realmGet$MDesc != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.MDescIndex, rowIndex, realmGet$MDesc, false);
        }
        String realmGet$GDesc = ((DashboardEntityRealmProxyInterface) object).realmGet$GDesc();
        if (realmGet$GDesc != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.GDescIndex, rowIndex, realmGet$GDesc, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.iconIndex, rowIndex, ((DashboardEntityRealmProxyInterface) object).realmGet$icon(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(magicfinmart.datacomp.com.finmartserviceapi.model.DashboardEntity.class);
        long tableNativePtr = table.getNativePtr();
        DashboardEntityColumnInfo columnInfo = (DashboardEntityColumnInfo) realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.model.DashboardEntity.class);
        magicfinmart.datacomp.com.finmartserviceapi.model.DashboardEntity object = null;
        while (objects.hasNext()) {
            object = (magicfinmart.datacomp.com.finmartserviceapi.model.DashboardEntity) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$type = ((DashboardEntityRealmProxyInterface) object).realmGet$type();
            if (realmGet$type != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.typeIndex, rowIndex, realmGet$type, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.productIdIndex, rowIndex, ((DashboardEntityRealmProxyInterface) object).realmGet$productId(), false);
            String realmGet$productName = ((DashboardEntityRealmProxyInterface) object).realmGet$productName();
            if (realmGet$productName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.productNameIndex, rowIndex, realmGet$productName, false);
            }
            String realmGet$productDetails = ((DashboardEntityRealmProxyInterface) object).realmGet$productDetails();
            if (realmGet$productDetails != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.productDetailsIndex, rowIndex, realmGet$productDetails, false);
            }
            String realmGet$link = ((DashboardEntityRealmProxyInterface) object).realmGet$link();
            if (realmGet$link != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.linkIndex, rowIndex, realmGet$link, false);
            }
            String realmGet$serverIcon = ((DashboardEntityRealmProxyInterface) object).realmGet$serverIcon();
            if (realmGet$serverIcon != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.serverIconIndex, rowIndex, realmGet$serverIcon, false);
            }
            String realmGet$Id = ((DashboardEntityRealmProxyInterface) object).realmGet$Id();
            if (realmGet$Id != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.IdIndex, rowIndex, realmGet$Id, false);
            }
            String realmGet$Kname = ((DashboardEntityRealmProxyInterface) object).realmGet$Kname();
            if (realmGet$Kname != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.KnameIndex, rowIndex, realmGet$Kname, false);
            }
            String realmGet$ETitle = ((DashboardEntityRealmProxyInterface) object).realmGet$ETitle();
            if (realmGet$ETitle != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.ETitleIndex, rowIndex, realmGet$ETitle, false);
            }
            String realmGet$HTitle = ((DashboardEntityRealmProxyInterface) object).realmGet$HTitle();
            if (realmGet$HTitle != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.HTitleIndex, rowIndex, realmGet$HTitle, false);
            }
            String realmGet$MTitle = ((DashboardEntityRealmProxyInterface) object).realmGet$MTitle();
            if (realmGet$MTitle != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.MTitleIndex, rowIndex, realmGet$MTitle, false);
            }
            String realmGet$GTitle = ((DashboardEntityRealmProxyInterface) object).realmGet$GTitle();
            if (realmGet$GTitle != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.GTitleIndex, rowIndex, realmGet$GTitle, false);
            }
            String realmGet$EDesc = ((DashboardEntityRealmProxyInterface) object).realmGet$EDesc();
            if (realmGet$EDesc != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.EDescIndex, rowIndex, realmGet$EDesc, false);
            }
            String realmGet$HDesc = ((DashboardEntityRealmProxyInterface) object).realmGet$HDesc();
            if (realmGet$HDesc != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.HDescIndex, rowIndex, realmGet$HDesc, false);
            }
            String realmGet$MDesc = ((DashboardEntityRealmProxyInterface) object).realmGet$MDesc();
            if (realmGet$MDesc != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.MDescIndex, rowIndex, realmGet$MDesc, false);
            }
            String realmGet$GDesc = ((DashboardEntityRealmProxyInterface) object).realmGet$GDesc();
            if (realmGet$GDesc != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.GDescIndex, rowIndex, realmGet$GDesc, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.iconIndex, rowIndex, ((DashboardEntityRealmProxyInterface) object).realmGet$icon(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, magicfinmart.datacomp.com.finmartserviceapi.model.DashboardEntity object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(magicfinmart.datacomp.com.finmartserviceapi.model.DashboardEntity.class);
        long tableNativePtr = table.getNativePtr();
        DashboardEntityColumnInfo columnInfo = (DashboardEntityColumnInfo) realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.model.DashboardEntity.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$type = ((DashboardEntityRealmProxyInterface) object).realmGet$type();
        if (realmGet$type != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.typeIndex, rowIndex, realmGet$type, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.typeIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.productIdIndex, rowIndex, ((DashboardEntityRealmProxyInterface) object).realmGet$productId(), false);
        String realmGet$productName = ((DashboardEntityRealmProxyInterface) object).realmGet$productName();
        if (realmGet$productName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.productNameIndex, rowIndex, realmGet$productName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.productNameIndex, rowIndex, false);
        }
        String realmGet$productDetails = ((DashboardEntityRealmProxyInterface) object).realmGet$productDetails();
        if (realmGet$productDetails != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.productDetailsIndex, rowIndex, realmGet$productDetails, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.productDetailsIndex, rowIndex, false);
        }
        String realmGet$link = ((DashboardEntityRealmProxyInterface) object).realmGet$link();
        if (realmGet$link != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.linkIndex, rowIndex, realmGet$link, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.linkIndex, rowIndex, false);
        }
        String realmGet$serverIcon = ((DashboardEntityRealmProxyInterface) object).realmGet$serverIcon();
        if (realmGet$serverIcon != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.serverIconIndex, rowIndex, realmGet$serverIcon, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.serverIconIndex, rowIndex, false);
        }
        String realmGet$Id = ((DashboardEntityRealmProxyInterface) object).realmGet$Id();
        if (realmGet$Id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.IdIndex, rowIndex, realmGet$Id, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.IdIndex, rowIndex, false);
        }
        String realmGet$Kname = ((DashboardEntityRealmProxyInterface) object).realmGet$Kname();
        if (realmGet$Kname != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.KnameIndex, rowIndex, realmGet$Kname, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.KnameIndex, rowIndex, false);
        }
        String realmGet$ETitle = ((DashboardEntityRealmProxyInterface) object).realmGet$ETitle();
        if (realmGet$ETitle != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.ETitleIndex, rowIndex, realmGet$ETitle, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.ETitleIndex, rowIndex, false);
        }
        String realmGet$HTitle = ((DashboardEntityRealmProxyInterface) object).realmGet$HTitle();
        if (realmGet$HTitle != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.HTitleIndex, rowIndex, realmGet$HTitle, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.HTitleIndex, rowIndex, false);
        }
        String realmGet$MTitle = ((DashboardEntityRealmProxyInterface) object).realmGet$MTitle();
        if (realmGet$MTitle != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.MTitleIndex, rowIndex, realmGet$MTitle, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.MTitleIndex, rowIndex, false);
        }
        String realmGet$GTitle = ((DashboardEntityRealmProxyInterface) object).realmGet$GTitle();
        if (realmGet$GTitle != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.GTitleIndex, rowIndex, realmGet$GTitle, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.GTitleIndex, rowIndex, false);
        }
        String realmGet$EDesc = ((DashboardEntityRealmProxyInterface) object).realmGet$EDesc();
        if (realmGet$EDesc != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.EDescIndex, rowIndex, realmGet$EDesc, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.EDescIndex, rowIndex, false);
        }
        String realmGet$HDesc = ((DashboardEntityRealmProxyInterface) object).realmGet$HDesc();
        if (realmGet$HDesc != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.HDescIndex, rowIndex, realmGet$HDesc, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.HDescIndex, rowIndex, false);
        }
        String realmGet$MDesc = ((DashboardEntityRealmProxyInterface) object).realmGet$MDesc();
        if (realmGet$MDesc != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.MDescIndex, rowIndex, realmGet$MDesc, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.MDescIndex, rowIndex, false);
        }
        String realmGet$GDesc = ((DashboardEntityRealmProxyInterface) object).realmGet$GDesc();
        if (realmGet$GDesc != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.GDescIndex, rowIndex, realmGet$GDesc, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.GDescIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.iconIndex, rowIndex, ((DashboardEntityRealmProxyInterface) object).realmGet$icon(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(magicfinmart.datacomp.com.finmartserviceapi.model.DashboardEntity.class);
        long tableNativePtr = table.getNativePtr();
        DashboardEntityColumnInfo columnInfo = (DashboardEntityColumnInfo) realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.model.DashboardEntity.class);
        magicfinmart.datacomp.com.finmartserviceapi.model.DashboardEntity object = null;
        while (objects.hasNext()) {
            object = (magicfinmart.datacomp.com.finmartserviceapi.model.DashboardEntity) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$type = ((DashboardEntityRealmProxyInterface) object).realmGet$type();
            if (realmGet$type != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.typeIndex, rowIndex, realmGet$type, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.typeIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.productIdIndex, rowIndex, ((DashboardEntityRealmProxyInterface) object).realmGet$productId(), false);
            String realmGet$productName = ((DashboardEntityRealmProxyInterface) object).realmGet$productName();
            if (realmGet$productName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.productNameIndex, rowIndex, realmGet$productName, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.productNameIndex, rowIndex, false);
            }
            String realmGet$productDetails = ((DashboardEntityRealmProxyInterface) object).realmGet$productDetails();
            if (realmGet$productDetails != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.productDetailsIndex, rowIndex, realmGet$productDetails, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.productDetailsIndex, rowIndex, false);
            }
            String realmGet$link = ((DashboardEntityRealmProxyInterface) object).realmGet$link();
            if (realmGet$link != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.linkIndex, rowIndex, realmGet$link, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.linkIndex, rowIndex, false);
            }
            String realmGet$serverIcon = ((DashboardEntityRealmProxyInterface) object).realmGet$serverIcon();
            if (realmGet$serverIcon != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.serverIconIndex, rowIndex, realmGet$serverIcon, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.serverIconIndex, rowIndex, false);
            }
            String realmGet$Id = ((DashboardEntityRealmProxyInterface) object).realmGet$Id();
            if (realmGet$Id != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.IdIndex, rowIndex, realmGet$Id, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.IdIndex, rowIndex, false);
            }
            String realmGet$Kname = ((DashboardEntityRealmProxyInterface) object).realmGet$Kname();
            if (realmGet$Kname != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.KnameIndex, rowIndex, realmGet$Kname, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.KnameIndex, rowIndex, false);
            }
            String realmGet$ETitle = ((DashboardEntityRealmProxyInterface) object).realmGet$ETitle();
            if (realmGet$ETitle != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.ETitleIndex, rowIndex, realmGet$ETitle, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.ETitleIndex, rowIndex, false);
            }
            String realmGet$HTitle = ((DashboardEntityRealmProxyInterface) object).realmGet$HTitle();
            if (realmGet$HTitle != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.HTitleIndex, rowIndex, realmGet$HTitle, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.HTitleIndex, rowIndex, false);
            }
            String realmGet$MTitle = ((DashboardEntityRealmProxyInterface) object).realmGet$MTitle();
            if (realmGet$MTitle != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.MTitleIndex, rowIndex, realmGet$MTitle, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.MTitleIndex, rowIndex, false);
            }
            String realmGet$GTitle = ((DashboardEntityRealmProxyInterface) object).realmGet$GTitle();
            if (realmGet$GTitle != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.GTitleIndex, rowIndex, realmGet$GTitle, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.GTitleIndex, rowIndex, false);
            }
            String realmGet$EDesc = ((DashboardEntityRealmProxyInterface) object).realmGet$EDesc();
            if (realmGet$EDesc != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.EDescIndex, rowIndex, realmGet$EDesc, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.EDescIndex, rowIndex, false);
            }
            String realmGet$HDesc = ((DashboardEntityRealmProxyInterface) object).realmGet$HDesc();
            if (realmGet$HDesc != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.HDescIndex, rowIndex, realmGet$HDesc, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.HDescIndex, rowIndex, false);
            }
            String realmGet$MDesc = ((DashboardEntityRealmProxyInterface) object).realmGet$MDesc();
            if (realmGet$MDesc != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.MDescIndex, rowIndex, realmGet$MDesc, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.MDescIndex, rowIndex, false);
            }
            String realmGet$GDesc = ((DashboardEntityRealmProxyInterface) object).realmGet$GDesc();
            if (realmGet$GDesc != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.GDescIndex, rowIndex, realmGet$GDesc, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.GDescIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.iconIndex, rowIndex, ((DashboardEntityRealmProxyInterface) object).realmGet$icon(), false);
        }
    }

    public static magicfinmart.datacomp.com.finmartserviceapi.model.DashboardEntity createDetachedCopy(magicfinmart.datacomp.com.finmartserviceapi.model.DashboardEntity realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        magicfinmart.datacomp.com.finmartserviceapi.model.DashboardEntity unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new magicfinmart.datacomp.com.finmartserviceapi.model.DashboardEntity();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (magicfinmart.datacomp.com.finmartserviceapi.model.DashboardEntity) cachedObject.object;
            }
            unmanagedObject = (magicfinmart.datacomp.com.finmartserviceapi.model.DashboardEntity) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        DashboardEntityRealmProxyInterface unmanagedCopy = (DashboardEntityRealmProxyInterface) unmanagedObject;
        DashboardEntityRealmProxyInterface realmSource = (DashboardEntityRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$type(realmSource.realmGet$type());
        unmanagedCopy.realmSet$productId(realmSource.realmGet$productId());
        unmanagedCopy.realmSet$productName(realmSource.realmGet$productName());
        unmanagedCopy.realmSet$productDetails(realmSource.realmGet$productDetails());
        unmanagedCopy.realmSet$link(realmSource.realmGet$link());
        unmanagedCopy.realmSet$serverIcon(realmSource.realmGet$serverIcon());
        unmanagedCopy.realmSet$Id(realmSource.realmGet$Id());
        unmanagedCopy.realmSet$Kname(realmSource.realmGet$Kname());
        unmanagedCopy.realmSet$ETitle(realmSource.realmGet$ETitle());
        unmanagedCopy.realmSet$HTitle(realmSource.realmGet$HTitle());
        unmanagedCopy.realmSet$MTitle(realmSource.realmGet$MTitle());
        unmanagedCopy.realmSet$GTitle(realmSource.realmGet$GTitle());
        unmanagedCopy.realmSet$EDesc(realmSource.realmGet$EDesc());
        unmanagedCopy.realmSet$HDesc(realmSource.realmGet$HDesc());
        unmanagedCopy.realmSet$MDesc(realmSource.realmGet$MDesc());
        unmanagedCopy.realmSet$GDesc(realmSource.realmGet$GDesc());
        unmanagedCopy.realmSet$icon(realmSource.realmGet$icon());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("DashboardEntity = proxy[");
        stringBuilder.append("{type:");
        stringBuilder.append(realmGet$type() != null ? realmGet$type() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{productId:");
        stringBuilder.append(realmGet$productId());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{productName:");
        stringBuilder.append(realmGet$productName() != null ? realmGet$productName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{productDetails:");
        stringBuilder.append(realmGet$productDetails() != null ? realmGet$productDetails() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{link:");
        stringBuilder.append(realmGet$link() != null ? realmGet$link() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{serverIcon:");
        stringBuilder.append(realmGet$serverIcon() != null ? realmGet$serverIcon() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{Id:");
        stringBuilder.append(realmGet$Id() != null ? realmGet$Id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{Kname:");
        stringBuilder.append(realmGet$Kname() != null ? realmGet$Kname() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{ETitle:");
        stringBuilder.append(realmGet$ETitle() != null ? realmGet$ETitle() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{HTitle:");
        stringBuilder.append(realmGet$HTitle() != null ? realmGet$HTitle() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{MTitle:");
        stringBuilder.append(realmGet$MTitle() != null ? realmGet$MTitle() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{GTitle:");
        stringBuilder.append(realmGet$GTitle() != null ? realmGet$GTitle() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{EDesc:");
        stringBuilder.append(realmGet$EDesc() != null ? realmGet$EDesc() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{HDesc:");
        stringBuilder.append(realmGet$HDesc() != null ? realmGet$HDesc() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{MDesc:");
        stringBuilder.append(realmGet$MDesc() != null ? realmGet$MDesc() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{GDesc:");
        stringBuilder.append(realmGet$GDesc() != null ? realmGet$GDesc() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{icon:");
        stringBuilder.append(realmGet$icon());
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
        DashboardEntityRealmProxy aDashboardEntity = (DashboardEntityRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aDashboardEntity.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aDashboardEntity.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aDashboardEntity.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
