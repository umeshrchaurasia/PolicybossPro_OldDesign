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
public class DashboardMultiLangEntityRealmProxy extends magicfinmart.datacomp.com.finmartserviceapi.model.DashboardMultiLangEntity
    implements RealmObjectProxy, DashboardMultiLangEntityRealmProxyInterface {

    static final class DashboardMultiLangEntityColumnInfo extends ColumnInfo {
        long typeIndex;
        long productIdIndex;
        long productNameIndex;
        long productDetailsIndex;
        long linkIndex;
        long serverIconIndex;
        long productNameKeyIndex;
        long productDetailsKeyIndex;
        long ProductNameFontColorIndex;
        long ProductDetailsFontColorIndex;
        long ProductBackgroundColorIndex;
        long IsExclusiveIndex;
        long IsNewprdClickableIndex;
        long IsSharableIndex;
        long popupmsgIndex;
        long titleIndex;
        long infoIndex;
        long iconIndex;

        DashboardMultiLangEntityColumnInfo(OsSchemaInfo schemaInfo) {
            super(18);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("DashboardMultiLangEntity");
            this.typeIndex = addColumnDetails("type", objectSchemaInfo);
            this.productIdIndex = addColumnDetails("productId", objectSchemaInfo);
            this.productNameIndex = addColumnDetails("productName", objectSchemaInfo);
            this.productDetailsIndex = addColumnDetails("productDetails", objectSchemaInfo);
            this.linkIndex = addColumnDetails("link", objectSchemaInfo);
            this.serverIconIndex = addColumnDetails("serverIcon", objectSchemaInfo);
            this.productNameKeyIndex = addColumnDetails("productNameKey", objectSchemaInfo);
            this.productDetailsKeyIndex = addColumnDetails("productDetailsKey", objectSchemaInfo);
            this.ProductNameFontColorIndex = addColumnDetails("ProductNameFontColor", objectSchemaInfo);
            this.ProductDetailsFontColorIndex = addColumnDetails("ProductDetailsFontColor", objectSchemaInfo);
            this.ProductBackgroundColorIndex = addColumnDetails("ProductBackgroundColor", objectSchemaInfo);
            this.IsExclusiveIndex = addColumnDetails("IsExclusive", objectSchemaInfo);
            this.IsNewprdClickableIndex = addColumnDetails("IsNewprdClickable", objectSchemaInfo);
            this.IsSharableIndex = addColumnDetails("IsSharable", objectSchemaInfo);
            this.popupmsgIndex = addColumnDetails("popupmsg", objectSchemaInfo);
            this.titleIndex = addColumnDetails("title", objectSchemaInfo);
            this.infoIndex = addColumnDetails("info", objectSchemaInfo);
            this.iconIndex = addColumnDetails("icon", objectSchemaInfo);
        }

        DashboardMultiLangEntityColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new DashboardMultiLangEntityColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final DashboardMultiLangEntityColumnInfo src = (DashboardMultiLangEntityColumnInfo) rawSrc;
            final DashboardMultiLangEntityColumnInfo dst = (DashboardMultiLangEntityColumnInfo) rawDst;
            dst.typeIndex = src.typeIndex;
            dst.productIdIndex = src.productIdIndex;
            dst.productNameIndex = src.productNameIndex;
            dst.productDetailsIndex = src.productDetailsIndex;
            dst.linkIndex = src.linkIndex;
            dst.serverIconIndex = src.serverIconIndex;
            dst.productNameKeyIndex = src.productNameKeyIndex;
            dst.productDetailsKeyIndex = src.productDetailsKeyIndex;
            dst.ProductNameFontColorIndex = src.ProductNameFontColorIndex;
            dst.ProductDetailsFontColorIndex = src.ProductDetailsFontColorIndex;
            dst.ProductBackgroundColorIndex = src.ProductBackgroundColorIndex;
            dst.IsExclusiveIndex = src.IsExclusiveIndex;
            dst.IsNewprdClickableIndex = src.IsNewprdClickableIndex;
            dst.IsSharableIndex = src.IsSharableIndex;
            dst.popupmsgIndex = src.popupmsgIndex;
            dst.titleIndex = src.titleIndex;
            dst.infoIndex = src.infoIndex;
            dst.iconIndex = src.iconIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>(18);
        fieldNames.add("type");
        fieldNames.add("productId");
        fieldNames.add("productName");
        fieldNames.add("productDetails");
        fieldNames.add("link");
        fieldNames.add("serverIcon");
        fieldNames.add("productNameKey");
        fieldNames.add("productDetailsKey");
        fieldNames.add("ProductNameFontColor");
        fieldNames.add("ProductDetailsFontColor");
        fieldNames.add("ProductBackgroundColor");
        fieldNames.add("IsExclusive");
        fieldNames.add("IsNewprdClickable");
        fieldNames.add("IsSharable");
        fieldNames.add("popupmsg");
        fieldNames.add("title");
        fieldNames.add("info");
        fieldNames.add("icon");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    private DashboardMultiLangEntityColumnInfo columnInfo;
    private ProxyState<magicfinmart.datacomp.com.finmartserviceapi.model.DashboardMultiLangEntity> proxyState;

    DashboardMultiLangEntityRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (DashboardMultiLangEntityColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<magicfinmart.datacomp.com.finmartserviceapi.model.DashboardMultiLangEntity>(this);
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
    public String realmGet$productNameKey() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.productNameKeyIndex);
    }

    @Override
    public void realmSet$productNameKey(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.productNameKeyIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.productNameKeyIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.productNameKeyIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.productNameKeyIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$productDetailsKey() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.productDetailsKeyIndex);
    }

    @Override
    public void realmSet$productDetailsKey(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.productDetailsKeyIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.productDetailsKeyIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.productDetailsKeyIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.productDetailsKeyIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$ProductNameFontColor() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.ProductNameFontColorIndex);
    }

    @Override
    public void realmSet$ProductNameFontColor(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.ProductNameFontColorIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.ProductNameFontColorIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.ProductNameFontColorIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.ProductNameFontColorIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$ProductDetailsFontColor() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.ProductDetailsFontColorIndex);
    }

    @Override
    public void realmSet$ProductDetailsFontColor(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.ProductDetailsFontColorIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.ProductDetailsFontColorIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.ProductDetailsFontColorIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.ProductDetailsFontColorIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$ProductBackgroundColor() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.ProductBackgroundColorIndex);
    }

    @Override
    public void realmSet$ProductBackgroundColor(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.ProductBackgroundColorIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.ProductBackgroundColorIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.ProductBackgroundColorIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.ProductBackgroundColorIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$IsExclusive() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.IsExclusiveIndex);
    }

    @Override
    public void realmSet$IsExclusive(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.IsExclusiveIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.IsExclusiveIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.IsExclusiveIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.IsExclusiveIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$IsNewprdClickable() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.IsNewprdClickableIndex);
    }

    @Override
    public void realmSet$IsNewprdClickable(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.IsNewprdClickableIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.IsNewprdClickableIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.IsNewprdClickableIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.IsNewprdClickableIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$IsSharable() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.IsSharableIndex);
    }

    @Override
    public void realmSet$IsSharable(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.IsSharableIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.IsSharableIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.IsSharableIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.IsSharableIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$popupmsg() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.popupmsgIndex);
    }

    @Override
    public void realmSet$popupmsg(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.popupmsgIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.popupmsgIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.popupmsgIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.popupmsgIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$title() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.titleIndex);
    }

    @Override
    public void realmSet$title(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.titleIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.titleIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.titleIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.titleIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$info() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.infoIndex);
    }

    @Override
    public void realmSet$info(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.infoIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.infoIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.infoIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.infoIndex, value);
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
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("DashboardMultiLangEntity", 18, 0);
        builder.addPersistedProperty("type", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("productId", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("productName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("productDetails", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("link", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("serverIcon", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("productNameKey", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("productDetailsKey", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("ProductNameFontColor", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("ProductDetailsFontColor", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("ProductBackgroundColor", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("IsExclusive", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("IsNewprdClickable", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("IsSharable", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("popupmsg", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("title", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("info", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("icon", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static DashboardMultiLangEntityColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new DashboardMultiLangEntityColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "DashboardMultiLangEntity";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static magicfinmart.datacomp.com.finmartserviceapi.model.DashboardMultiLangEntity createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        magicfinmart.datacomp.com.finmartserviceapi.model.DashboardMultiLangEntity obj = realm.createObjectInternal(magicfinmart.datacomp.com.finmartserviceapi.model.DashboardMultiLangEntity.class, true, excludeFields);

        final DashboardMultiLangEntityRealmProxyInterface objProxy = (DashboardMultiLangEntityRealmProxyInterface) obj;
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
        if (json.has("productNameKey")) {
            if (json.isNull("productNameKey")) {
                objProxy.realmSet$productNameKey(null);
            } else {
                objProxy.realmSet$productNameKey((String) json.getString("productNameKey"));
            }
        }
        if (json.has("productDetailsKey")) {
            if (json.isNull("productDetailsKey")) {
                objProxy.realmSet$productDetailsKey(null);
            } else {
                objProxy.realmSet$productDetailsKey((String) json.getString("productDetailsKey"));
            }
        }
        if (json.has("ProductNameFontColor")) {
            if (json.isNull("ProductNameFontColor")) {
                objProxy.realmSet$ProductNameFontColor(null);
            } else {
                objProxy.realmSet$ProductNameFontColor((String) json.getString("ProductNameFontColor"));
            }
        }
        if (json.has("ProductDetailsFontColor")) {
            if (json.isNull("ProductDetailsFontColor")) {
                objProxy.realmSet$ProductDetailsFontColor(null);
            } else {
                objProxy.realmSet$ProductDetailsFontColor((String) json.getString("ProductDetailsFontColor"));
            }
        }
        if (json.has("ProductBackgroundColor")) {
            if (json.isNull("ProductBackgroundColor")) {
                objProxy.realmSet$ProductBackgroundColor(null);
            } else {
                objProxy.realmSet$ProductBackgroundColor((String) json.getString("ProductBackgroundColor"));
            }
        }
        if (json.has("IsExclusive")) {
            if (json.isNull("IsExclusive")) {
                objProxy.realmSet$IsExclusive(null);
            } else {
                objProxy.realmSet$IsExclusive((String) json.getString("IsExclusive"));
            }
        }
        if (json.has("IsNewprdClickable")) {
            if (json.isNull("IsNewprdClickable")) {
                objProxy.realmSet$IsNewprdClickable(null);
            } else {
                objProxy.realmSet$IsNewprdClickable((String) json.getString("IsNewprdClickable"));
            }
        }
        if (json.has("IsSharable")) {
            if (json.isNull("IsSharable")) {
                objProxy.realmSet$IsSharable(null);
            } else {
                objProxy.realmSet$IsSharable((String) json.getString("IsSharable"));
            }
        }
        if (json.has("popupmsg")) {
            if (json.isNull("popupmsg")) {
                objProxy.realmSet$popupmsg(null);
            } else {
                objProxy.realmSet$popupmsg((String) json.getString("popupmsg"));
            }
        }
        if (json.has("title")) {
            if (json.isNull("title")) {
                objProxy.realmSet$title(null);
            } else {
                objProxy.realmSet$title((String) json.getString("title"));
            }
        }
        if (json.has("info")) {
            if (json.isNull("info")) {
                objProxy.realmSet$info(null);
            } else {
                objProxy.realmSet$info((String) json.getString("info"));
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
    public static magicfinmart.datacomp.com.finmartserviceapi.model.DashboardMultiLangEntity createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final magicfinmart.datacomp.com.finmartserviceapi.model.DashboardMultiLangEntity obj = new magicfinmart.datacomp.com.finmartserviceapi.model.DashboardMultiLangEntity();
        final DashboardMultiLangEntityRealmProxyInterface objProxy = (DashboardMultiLangEntityRealmProxyInterface) obj;
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
            } else if (name.equals("productNameKey")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$productNameKey((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$productNameKey(null);
                }
            } else if (name.equals("productDetailsKey")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$productDetailsKey((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$productDetailsKey(null);
                }
            } else if (name.equals("ProductNameFontColor")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$ProductNameFontColor((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$ProductNameFontColor(null);
                }
            } else if (name.equals("ProductDetailsFontColor")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$ProductDetailsFontColor((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$ProductDetailsFontColor(null);
                }
            } else if (name.equals("ProductBackgroundColor")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$ProductBackgroundColor((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$ProductBackgroundColor(null);
                }
            } else if (name.equals("IsExclusive")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$IsExclusive((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$IsExclusive(null);
                }
            } else if (name.equals("IsNewprdClickable")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$IsNewprdClickable((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$IsNewprdClickable(null);
                }
            } else if (name.equals("IsSharable")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$IsSharable((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$IsSharable(null);
                }
            } else if (name.equals("popupmsg")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$popupmsg((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$popupmsg(null);
                }
            } else if (name.equals("title")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$title((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$title(null);
                }
            } else if (name.equals("info")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$info((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$info(null);
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

    public static magicfinmart.datacomp.com.finmartserviceapi.model.DashboardMultiLangEntity copyOrUpdate(Realm realm, magicfinmart.datacomp.com.finmartserviceapi.model.DashboardMultiLangEntity object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (magicfinmart.datacomp.com.finmartserviceapi.model.DashboardMultiLangEntity) cachedRealmObject;
        }

        return copy(realm, object, update, cache);
    }

    public static magicfinmart.datacomp.com.finmartserviceapi.model.DashboardMultiLangEntity copy(Realm realm, magicfinmart.datacomp.com.finmartserviceapi.model.DashboardMultiLangEntity newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (magicfinmart.datacomp.com.finmartserviceapi.model.DashboardMultiLangEntity) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        magicfinmart.datacomp.com.finmartserviceapi.model.DashboardMultiLangEntity realmObject = realm.createObjectInternal(magicfinmart.datacomp.com.finmartserviceapi.model.DashboardMultiLangEntity.class, false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        DashboardMultiLangEntityRealmProxyInterface realmObjectSource = (DashboardMultiLangEntityRealmProxyInterface) newObject;
        DashboardMultiLangEntityRealmProxyInterface realmObjectCopy = (DashboardMultiLangEntityRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$type(realmObjectSource.realmGet$type());
        realmObjectCopy.realmSet$productId(realmObjectSource.realmGet$productId());
        realmObjectCopy.realmSet$productName(realmObjectSource.realmGet$productName());
        realmObjectCopy.realmSet$productDetails(realmObjectSource.realmGet$productDetails());
        realmObjectCopy.realmSet$link(realmObjectSource.realmGet$link());
        realmObjectCopy.realmSet$serverIcon(realmObjectSource.realmGet$serverIcon());
        realmObjectCopy.realmSet$productNameKey(realmObjectSource.realmGet$productNameKey());
        realmObjectCopy.realmSet$productDetailsKey(realmObjectSource.realmGet$productDetailsKey());
        realmObjectCopy.realmSet$ProductNameFontColor(realmObjectSource.realmGet$ProductNameFontColor());
        realmObjectCopy.realmSet$ProductDetailsFontColor(realmObjectSource.realmGet$ProductDetailsFontColor());
        realmObjectCopy.realmSet$ProductBackgroundColor(realmObjectSource.realmGet$ProductBackgroundColor());
        realmObjectCopy.realmSet$IsExclusive(realmObjectSource.realmGet$IsExclusive());
        realmObjectCopy.realmSet$IsNewprdClickable(realmObjectSource.realmGet$IsNewprdClickable());
        realmObjectCopy.realmSet$IsSharable(realmObjectSource.realmGet$IsSharable());
        realmObjectCopy.realmSet$popupmsg(realmObjectSource.realmGet$popupmsg());
        realmObjectCopy.realmSet$title(realmObjectSource.realmGet$title());
        realmObjectCopy.realmSet$info(realmObjectSource.realmGet$info());
        realmObjectCopy.realmSet$icon(realmObjectSource.realmGet$icon());
        return realmObject;
    }

    public static long insert(Realm realm, magicfinmart.datacomp.com.finmartserviceapi.model.DashboardMultiLangEntity object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(magicfinmart.datacomp.com.finmartserviceapi.model.DashboardMultiLangEntity.class);
        long tableNativePtr = table.getNativePtr();
        DashboardMultiLangEntityColumnInfo columnInfo = (DashboardMultiLangEntityColumnInfo) realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.model.DashboardMultiLangEntity.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$type = ((DashboardMultiLangEntityRealmProxyInterface) object).realmGet$type();
        if (realmGet$type != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.typeIndex, rowIndex, realmGet$type, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.productIdIndex, rowIndex, ((DashboardMultiLangEntityRealmProxyInterface) object).realmGet$productId(), false);
        String realmGet$productName = ((DashboardMultiLangEntityRealmProxyInterface) object).realmGet$productName();
        if (realmGet$productName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.productNameIndex, rowIndex, realmGet$productName, false);
        }
        String realmGet$productDetails = ((DashboardMultiLangEntityRealmProxyInterface) object).realmGet$productDetails();
        if (realmGet$productDetails != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.productDetailsIndex, rowIndex, realmGet$productDetails, false);
        }
        String realmGet$link = ((DashboardMultiLangEntityRealmProxyInterface) object).realmGet$link();
        if (realmGet$link != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.linkIndex, rowIndex, realmGet$link, false);
        }
        String realmGet$serverIcon = ((DashboardMultiLangEntityRealmProxyInterface) object).realmGet$serverIcon();
        if (realmGet$serverIcon != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.serverIconIndex, rowIndex, realmGet$serverIcon, false);
        }
        String realmGet$productNameKey = ((DashboardMultiLangEntityRealmProxyInterface) object).realmGet$productNameKey();
        if (realmGet$productNameKey != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.productNameKeyIndex, rowIndex, realmGet$productNameKey, false);
        }
        String realmGet$productDetailsKey = ((DashboardMultiLangEntityRealmProxyInterface) object).realmGet$productDetailsKey();
        if (realmGet$productDetailsKey != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.productDetailsKeyIndex, rowIndex, realmGet$productDetailsKey, false);
        }
        String realmGet$ProductNameFontColor = ((DashboardMultiLangEntityRealmProxyInterface) object).realmGet$ProductNameFontColor();
        if (realmGet$ProductNameFontColor != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.ProductNameFontColorIndex, rowIndex, realmGet$ProductNameFontColor, false);
        }
        String realmGet$ProductDetailsFontColor = ((DashboardMultiLangEntityRealmProxyInterface) object).realmGet$ProductDetailsFontColor();
        if (realmGet$ProductDetailsFontColor != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.ProductDetailsFontColorIndex, rowIndex, realmGet$ProductDetailsFontColor, false);
        }
        String realmGet$ProductBackgroundColor = ((DashboardMultiLangEntityRealmProxyInterface) object).realmGet$ProductBackgroundColor();
        if (realmGet$ProductBackgroundColor != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.ProductBackgroundColorIndex, rowIndex, realmGet$ProductBackgroundColor, false);
        }
        String realmGet$IsExclusive = ((DashboardMultiLangEntityRealmProxyInterface) object).realmGet$IsExclusive();
        if (realmGet$IsExclusive != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.IsExclusiveIndex, rowIndex, realmGet$IsExclusive, false);
        }
        String realmGet$IsNewprdClickable = ((DashboardMultiLangEntityRealmProxyInterface) object).realmGet$IsNewprdClickable();
        if (realmGet$IsNewprdClickable != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.IsNewprdClickableIndex, rowIndex, realmGet$IsNewprdClickable, false);
        }
        String realmGet$IsSharable = ((DashboardMultiLangEntityRealmProxyInterface) object).realmGet$IsSharable();
        if (realmGet$IsSharable != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.IsSharableIndex, rowIndex, realmGet$IsSharable, false);
        }
        String realmGet$popupmsg = ((DashboardMultiLangEntityRealmProxyInterface) object).realmGet$popupmsg();
        if (realmGet$popupmsg != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.popupmsgIndex, rowIndex, realmGet$popupmsg, false);
        }
        String realmGet$title = ((DashboardMultiLangEntityRealmProxyInterface) object).realmGet$title();
        if (realmGet$title != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
        }
        String realmGet$info = ((DashboardMultiLangEntityRealmProxyInterface) object).realmGet$info();
        if (realmGet$info != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.infoIndex, rowIndex, realmGet$info, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.iconIndex, rowIndex, ((DashboardMultiLangEntityRealmProxyInterface) object).realmGet$icon(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(magicfinmart.datacomp.com.finmartserviceapi.model.DashboardMultiLangEntity.class);
        long tableNativePtr = table.getNativePtr();
        DashboardMultiLangEntityColumnInfo columnInfo = (DashboardMultiLangEntityColumnInfo) realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.model.DashboardMultiLangEntity.class);
        magicfinmart.datacomp.com.finmartserviceapi.model.DashboardMultiLangEntity object = null;
        while (objects.hasNext()) {
            object = (magicfinmart.datacomp.com.finmartserviceapi.model.DashboardMultiLangEntity) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$type = ((DashboardMultiLangEntityRealmProxyInterface) object).realmGet$type();
            if (realmGet$type != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.typeIndex, rowIndex, realmGet$type, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.productIdIndex, rowIndex, ((DashboardMultiLangEntityRealmProxyInterface) object).realmGet$productId(), false);
            String realmGet$productName = ((DashboardMultiLangEntityRealmProxyInterface) object).realmGet$productName();
            if (realmGet$productName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.productNameIndex, rowIndex, realmGet$productName, false);
            }
            String realmGet$productDetails = ((DashboardMultiLangEntityRealmProxyInterface) object).realmGet$productDetails();
            if (realmGet$productDetails != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.productDetailsIndex, rowIndex, realmGet$productDetails, false);
            }
            String realmGet$link = ((DashboardMultiLangEntityRealmProxyInterface) object).realmGet$link();
            if (realmGet$link != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.linkIndex, rowIndex, realmGet$link, false);
            }
            String realmGet$serverIcon = ((DashboardMultiLangEntityRealmProxyInterface) object).realmGet$serverIcon();
            if (realmGet$serverIcon != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.serverIconIndex, rowIndex, realmGet$serverIcon, false);
            }
            String realmGet$productNameKey = ((DashboardMultiLangEntityRealmProxyInterface) object).realmGet$productNameKey();
            if (realmGet$productNameKey != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.productNameKeyIndex, rowIndex, realmGet$productNameKey, false);
            }
            String realmGet$productDetailsKey = ((DashboardMultiLangEntityRealmProxyInterface) object).realmGet$productDetailsKey();
            if (realmGet$productDetailsKey != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.productDetailsKeyIndex, rowIndex, realmGet$productDetailsKey, false);
            }
            String realmGet$ProductNameFontColor = ((DashboardMultiLangEntityRealmProxyInterface) object).realmGet$ProductNameFontColor();
            if (realmGet$ProductNameFontColor != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.ProductNameFontColorIndex, rowIndex, realmGet$ProductNameFontColor, false);
            }
            String realmGet$ProductDetailsFontColor = ((DashboardMultiLangEntityRealmProxyInterface) object).realmGet$ProductDetailsFontColor();
            if (realmGet$ProductDetailsFontColor != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.ProductDetailsFontColorIndex, rowIndex, realmGet$ProductDetailsFontColor, false);
            }
            String realmGet$ProductBackgroundColor = ((DashboardMultiLangEntityRealmProxyInterface) object).realmGet$ProductBackgroundColor();
            if (realmGet$ProductBackgroundColor != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.ProductBackgroundColorIndex, rowIndex, realmGet$ProductBackgroundColor, false);
            }
            String realmGet$IsExclusive = ((DashboardMultiLangEntityRealmProxyInterface) object).realmGet$IsExclusive();
            if (realmGet$IsExclusive != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.IsExclusiveIndex, rowIndex, realmGet$IsExclusive, false);
            }
            String realmGet$IsNewprdClickable = ((DashboardMultiLangEntityRealmProxyInterface) object).realmGet$IsNewprdClickable();
            if (realmGet$IsNewprdClickable != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.IsNewprdClickableIndex, rowIndex, realmGet$IsNewprdClickable, false);
            }
            String realmGet$IsSharable = ((DashboardMultiLangEntityRealmProxyInterface) object).realmGet$IsSharable();
            if (realmGet$IsSharable != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.IsSharableIndex, rowIndex, realmGet$IsSharable, false);
            }
            String realmGet$popupmsg = ((DashboardMultiLangEntityRealmProxyInterface) object).realmGet$popupmsg();
            if (realmGet$popupmsg != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.popupmsgIndex, rowIndex, realmGet$popupmsg, false);
            }
            String realmGet$title = ((DashboardMultiLangEntityRealmProxyInterface) object).realmGet$title();
            if (realmGet$title != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
            }
            String realmGet$info = ((DashboardMultiLangEntityRealmProxyInterface) object).realmGet$info();
            if (realmGet$info != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.infoIndex, rowIndex, realmGet$info, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.iconIndex, rowIndex, ((DashboardMultiLangEntityRealmProxyInterface) object).realmGet$icon(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, magicfinmart.datacomp.com.finmartserviceapi.model.DashboardMultiLangEntity object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(magicfinmart.datacomp.com.finmartserviceapi.model.DashboardMultiLangEntity.class);
        long tableNativePtr = table.getNativePtr();
        DashboardMultiLangEntityColumnInfo columnInfo = (DashboardMultiLangEntityColumnInfo) realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.model.DashboardMultiLangEntity.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$type = ((DashboardMultiLangEntityRealmProxyInterface) object).realmGet$type();
        if (realmGet$type != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.typeIndex, rowIndex, realmGet$type, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.typeIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.productIdIndex, rowIndex, ((DashboardMultiLangEntityRealmProxyInterface) object).realmGet$productId(), false);
        String realmGet$productName = ((DashboardMultiLangEntityRealmProxyInterface) object).realmGet$productName();
        if (realmGet$productName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.productNameIndex, rowIndex, realmGet$productName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.productNameIndex, rowIndex, false);
        }
        String realmGet$productDetails = ((DashboardMultiLangEntityRealmProxyInterface) object).realmGet$productDetails();
        if (realmGet$productDetails != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.productDetailsIndex, rowIndex, realmGet$productDetails, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.productDetailsIndex, rowIndex, false);
        }
        String realmGet$link = ((DashboardMultiLangEntityRealmProxyInterface) object).realmGet$link();
        if (realmGet$link != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.linkIndex, rowIndex, realmGet$link, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.linkIndex, rowIndex, false);
        }
        String realmGet$serverIcon = ((DashboardMultiLangEntityRealmProxyInterface) object).realmGet$serverIcon();
        if (realmGet$serverIcon != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.serverIconIndex, rowIndex, realmGet$serverIcon, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.serverIconIndex, rowIndex, false);
        }
        String realmGet$productNameKey = ((DashboardMultiLangEntityRealmProxyInterface) object).realmGet$productNameKey();
        if (realmGet$productNameKey != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.productNameKeyIndex, rowIndex, realmGet$productNameKey, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.productNameKeyIndex, rowIndex, false);
        }
        String realmGet$productDetailsKey = ((DashboardMultiLangEntityRealmProxyInterface) object).realmGet$productDetailsKey();
        if (realmGet$productDetailsKey != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.productDetailsKeyIndex, rowIndex, realmGet$productDetailsKey, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.productDetailsKeyIndex, rowIndex, false);
        }
        String realmGet$ProductNameFontColor = ((DashboardMultiLangEntityRealmProxyInterface) object).realmGet$ProductNameFontColor();
        if (realmGet$ProductNameFontColor != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.ProductNameFontColorIndex, rowIndex, realmGet$ProductNameFontColor, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.ProductNameFontColorIndex, rowIndex, false);
        }
        String realmGet$ProductDetailsFontColor = ((DashboardMultiLangEntityRealmProxyInterface) object).realmGet$ProductDetailsFontColor();
        if (realmGet$ProductDetailsFontColor != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.ProductDetailsFontColorIndex, rowIndex, realmGet$ProductDetailsFontColor, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.ProductDetailsFontColorIndex, rowIndex, false);
        }
        String realmGet$ProductBackgroundColor = ((DashboardMultiLangEntityRealmProxyInterface) object).realmGet$ProductBackgroundColor();
        if (realmGet$ProductBackgroundColor != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.ProductBackgroundColorIndex, rowIndex, realmGet$ProductBackgroundColor, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.ProductBackgroundColorIndex, rowIndex, false);
        }
        String realmGet$IsExclusive = ((DashboardMultiLangEntityRealmProxyInterface) object).realmGet$IsExclusive();
        if (realmGet$IsExclusive != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.IsExclusiveIndex, rowIndex, realmGet$IsExclusive, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.IsExclusiveIndex, rowIndex, false);
        }
        String realmGet$IsNewprdClickable = ((DashboardMultiLangEntityRealmProxyInterface) object).realmGet$IsNewprdClickable();
        if (realmGet$IsNewprdClickable != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.IsNewprdClickableIndex, rowIndex, realmGet$IsNewprdClickable, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.IsNewprdClickableIndex, rowIndex, false);
        }
        String realmGet$IsSharable = ((DashboardMultiLangEntityRealmProxyInterface) object).realmGet$IsSharable();
        if (realmGet$IsSharable != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.IsSharableIndex, rowIndex, realmGet$IsSharable, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.IsSharableIndex, rowIndex, false);
        }
        String realmGet$popupmsg = ((DashboardMultiLangEntityRealmProxyInterface) object).realmGet$popupmsg();
        if (realmGet$popupmsg != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.popupmsgIndex, rowIndex, realmGet$popupmsg, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.popupmsgIndex, rowIndex, false);
        }
        String realmGet$title = ((DashboardMultiLangEntityRealmProxyInterface) object).realmGet$title();
        if (realmGet$title != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.titleIndex, rowIndex, false);
        }
        String realmGet$info = ((DashboardMultiLangEntityRealmProxyInterface) object).realmGet$info();
        if (realmGet$info != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.infoIndex, rowIndex, realmGet$info, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.infoIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.iconIndex, rowIndex, ((DashboardMultiLangEntityRealmProxyInterface) object).realmGet$icon(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(magicfinmart.datacomp.com.finmartserviceapi.model.DashboardMultiLangEntity.class);
        long tableNativePtr = table.getNativePtr();
        DashboardMultiLangEntityColumnInfo columnInfo = (DashboardMultiLangEntityColumnInfo) realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.model.DashboardMultiLangEntity.class);
        magicfinmart.datacomp.com.finmartserviceapi.model.DashboardMultiLangEntity object = null;
        while (objects.hasNext()) {
            object = (magicfinmart.datacomp.com.finmartserviceapi.model.DashboardMultiLangEntity) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$type = ((DashboardMultiLangEntityRealmProxyInterface) object).realmGet$type();
            if (realmGet$type != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.typeIndex, rowIndex, realmGet$type, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.typeIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.productIdIndex, rowIndex, ((DashboardMultiLangEntityRealmProxyInterface) object).realmGet$productId(), false);
            String realmGet$productName = ((DashboardMultiLangEntityRealmProxyInterface) object).realmGet$productName();
            if (realmGet$productName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.productNameIndex, rowIndex, realmGet$productName, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.productNameIndex, rowIndex, false);
            }
            String realmGet$productDetails = ((DashboardMultiLangEntityRealmProxyInterface) object).realmGet$productDetails();
            if (realmGet$productDetails != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.productDetailsIndex, rowIndex, realmGet$productDetails, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.productDetailsIndex, rowIndex, false);
            }
            String realmGet$link = ((DashboardMultiLangEntityRealmProxyInterface) object).realmGet$link();
            if (realmGet$link != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.linkIndex, rowIndex, realmGet$link, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.linkIndex, rowIndex, false);
            }
            String realmGet$serverIcon = ((DashboardMultiLangEntityRealmProxyInterface) object).realmGet$serverIcon();
            if (realmGet$serverIcon != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.serverIconIndex, rowIndex, realmGet$serverIcon, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.serverIconIndex, rowIndex, false);
            }
            String realmGet$productNameKey = ((DashboardMultiLangEntityRealmProxyInterface) object).realmGet$productNameKey();
            if (realmGet$productNameKey != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.productNameKeyIndex, rowIndex, realmGet$productNameKey, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.productNameKeyIndex, rowIndex, false);
            }
            String realmGet$productDetailsKey = ((DashboardMultiLangEntityRealmProxyInterface) object).realmGet$productDetailsKey();
            if (realmGet$productDetailsKey != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.productDetailsKeyIndex, rowIndex, realmGet$productDetailsKey, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.productDetailsKeyIndex, rowIndex, false);
            }
            String realmGet$ProductNameFontColor = ((DashboardMultiLangEntityRealmProxyInterface) object).realmGet$ProductNameFontColor();
            if (realmGet$ProductNameFontColor != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.ProductNameFontColorIndex, rowIndex, realmGet$ProductNameFontColor, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.ProductNameFontColorIndex, rowIndex, false);
            }
            String realmGet$ProductDetailsFontColor = ((DashboardMultiLangEntityRealmProxyInterface) object).realmGet$ProductDetailsFontColor();
            if (realmGet$ProductDetailsFontColor != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.ProductDetailsFontColorIndex, rowIndex, realmGet$ProductDetailsFontColor, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.ProductDetailsFontColorIndex, rowIndex, false);
            }
            String realmGet$ProductBackgroundColor = ((DashboardMultiLangEntityRealmProxyInterface) object).realmGet$ProductBackgroundColor();
            if (realmGet$ProductBackgroundColor != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.ProductBackgroundColorIndex, rowIndex, realmGet$ProductBackgroundColor, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.ProductBackgroundColorIndex, rowIndex, false);
            }
            String realmGet$IsExclusive = ((DashboardMultiLangEntityRealmProxyInterface) object).realmGet$IsExclusive();
            if (realmGet$IsExclusive != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.IsExclusiveIndex, rowIndex, realmGet$IsExclusive, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.IsExclusiveIndex, rowIndex, false);
            }
            String realmGet$IsNewprdClickable = ((DashboardMultiLangEntityRealmProxyInterface) object).realmGet$IsNewprdClickable();
            if (realmGet$IsNewprdClickable != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.IsNewprdClickableIndex, rowIndex, realmGet$IsNewprdClickable, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.IsNewprdClickableIndex, rowIndex, false);
            }
            String realmGet$IsSharable = ((DashboardMultiLangEntityRealmProxyInterface) object).realmGet$IsSharable();
            if (realmGet$IsSharable != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.IsSharableIndex, rowIndex, realmGet$IsSharable, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.IsSharableIndex, rowIndex, false);
            }
            String realmGet$popupmsg = ((DashboardMultiLangEntityRealmProxyInterface) object).realmGet$popupmsg();
            if (realmGet$popupmsg != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.popupmsgIndex, rowIndex, realmGet$popupmsg, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.popupmsgIndex, rowIndex, false);
            }
            String realmGet$title = ((DashboardMultiLangEntityRealmProxyInterface) object).realmGet$title();
            if (realmGet$title != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.titleIndex, rowIndex, false);
            }
            String realmGet$info = ((DashboardMultiLangEntityRealmProxyInterface) object).realmGet$info();
            if (realmGet$info != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.infoIndex, rowIndex, realmGet$info, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.infoIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.iconIndex, rowIndex, ((DashboardMultiLangEntityRealmProxyInterface) object).realmGet$icon(), false);
        }
    }

    public static magicfinmart.datacomp.com.finmartserviceapi.model.DashboardMultiLangEntity createDetachedCopy(magicfinmart.datacomp.com.finmartserviceapi.model.DashboardMultiLangEntity realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        magicfinmart.datacomp.com.finmartserviceapi.model.DashboardMultiLangEntity unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new magicfinmart.datacomp.com.finmartserviceapi.model.DashboardMultiLangEntity();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (magicfinmart.datacomp.com.finmartserviceapi.model.DashboardMultiLangEntity) cachedObject.object;
            }
            unmanagedObject = (magicfinmart.datacomp.com.finmartserviceapi.model.DashboardMultiLangEntity) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        DashboardMultiLangEntityRealmProxyInterface unmanagedCopy = (DashboardMultiLangEntityRealmProxyInterface) unmanagedObject;
        DashboardMultiLangEntityRealmProxyInterface realmSource = (DashboardMultiLangEntityRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$type(realmSource.realmGet$type());
        unmanagedCopy.realmSet$productId(realmSource.realmGet$productId());
        unmanagedCopy.realmSet$productName(realmSource.realmGet$productName());
        unmanagedCopy.realmSet$productDetails(realmSource.realmGet$productDetails());
        unmanagedCopy.realmSet$link(realmSource.realmGet$link());
        unmanagedCopy.realmSet$serverIcon(realmSource.realmGet$serverIcon());
        unmanagedCopy.realmSet$productNameKey(realmSource.realmGet$productNameKey());
        unmanagedCopy.realmSet$productDetailsKey(realmSource.realmGet$productDetailsKey());
        unmanagedCopy.realmSet$ProductNameFontColor(realmSource.realmGet$ProductNameFontColor());
        unmanagedCopy.realmSet$ProductDetailsFontColor(realmSource.realmGet$ProductDetailsFontColor());
        unmanagedCopy.realmSet$ProductBackgroundColor(realmSource.realmGet$ProductBackgroundColor());
        unmanagedCopy.realmSet$IsExclusive(realmSource.realmGet$IsExclusive());
        unmanagedCopy.realmSet$IsNewprdClickable(realmSource.realmGet$IsNewprdClickable());
        unmanagedCopy.realmSet$IsSharable(realmSource.realmGet$IsSharable());
        unmanagedCopy.realmSet$popupmsg(realmSource.realmGet$popupmsg());
        unmanagedCopy.realmSet$title(realmSource.realmGet$title());
        unmanagedCopy.realmSet$info(realmSource.realmGet$info());
        unmanagedCopy.realmSet$icon(realmSource.realmGet$icon());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("DashboardMultiLangEntity = proxy[");
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
        stringBuilder.append("{productNameKey:");
        stringBuilder.append(realmGet$productNameKey() != null ? realmGet$productNameKey() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{productDetailsKey:");
        stringBuilder.append(realmGet$productDetailsKey() != null ? realmGet$productDetailsKey() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{ProductNameFontColor:");
        stringBuilder.append(realmGet$ProductNameFontColor() != null ? realmGet$ProductNameFontColor() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{ProductDetailsFontColor:");
        stringBuilder.append(realmGet$ProductDetailsFontColor() != null ? realmGet$ProductDetailsFontColor() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{ProductBackgroundColor:");
        stringBuilder.append(realmGet$ProductBackgroundColor() != null ? realmGet$ProductBackgroundColor() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{IsExclusive:");
        stringBuilder.append(realmGet$IsExclusive() != null ? realmGet$IsExclusive() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{IsNewprdClickable:");
        stringBuilder.append(realmGet$IsNewprdClickable() != null ? realmGet$IsNewprdClickable() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{IsSharable:");
        stringBuilder.append(realmGet$IsSharable() != null ? realmGet$IsSharable() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{popupmsg:");
        stringBuilder.append(realmGet$popupmsg() != null ? realmGet$popupmsg() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{title:");
        stringBuilder.append(realmGet$title() != null ? realmGet$title() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{info:");
        stringBuilder.append(realmGet$info() != null ? realmGet$info() : "null");
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
        DashboardMultiLangEntityRealmProxy aDashboardMultiLangEntity = (DashboardMultiLangEntityRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aDashboardMultiLangEntity.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aDashboardMultiLangEntity.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aDashboardMultiLangEntity.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
