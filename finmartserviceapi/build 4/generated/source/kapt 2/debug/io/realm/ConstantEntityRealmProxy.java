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
public class ConstantEntityRealmProxy extends magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ConstantEntity
    implements RealmObjectProxy, ConstantEntityRealmProxyInterface {

    static final class ConstantEntityColumnInfo extends ColumnInfo {
        long VersionCodeIndex;
        long IsForceUpdateIndex;
        long PBNoOfHitsIndex;
        long PBHitTimeIndex;
        long ROIHLBLIndex;
        long ROIPLBLIndex;
        long ROILABLIndex;
        long POSPNoIndex;
        long POSPStatIndex;
        long HelpNumberIndex;
        long healthappenableIndex;
        long POSPTrainingIndex;
        long MPSStatusIndex;
        long UpdateMasterIndex;
        long logtrackingIndex;
        long HorizonVersionIndex;
        long HealthThrowBrowserIndex;

        ConstantEntityColumnInfo(OsSchemaInfo schemaInfo) {
            super(17);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("ConstantEntity");
            this.VersionCodeIndex = addColumnDetails("VersionCode", objectSchemaInfo);
            this.IsForceUpdateIndex = addColumnDetails("IsForceUpdate", objectSchemaInfo);
            this.PBNoOfHitsIndex = addColumnDetails("PBNoOfHits", objectSchemaInfo);
            this.PBHitTimeIndex = addColumnDetails("PBHitTime", objectSchemaInfo);
            this.ROIHLBLIndex = addColumnDetails("ROIHLBL", objectSchemaInfo);
            this.ROIPLBLIndex = addColumnDetails("ROIPLBL", objectSchemaInfo);
            this.ROILABLIndex = addColumnDetails("ROILABL", objectSchemaInfo);
            this.POSPNoIndex = addColumnDetails("POSPNo", objectSchemaInfo);
            this.POSPStatIndex = addColumnDetails("POSPStat", objectSchemaInfo);
            this.HelpNumberIndex = addColumnDetails("HelpNumber", objectSchemaInfo);
            this.healthappenableIndex = addColumnDetails("healthappenable", objectSchemaInfo);
            this.POSPTrainingIndex = addColumnDetails("POSPTraining", objectSchemaInfo);
            this.MPSStatusIndex = addColumnDetails("MPSStatus", objectSchemaInfo);
            this.UpdateMasterIndex = addColumnDetails("UpdateMaster", objectSchemaInfo);
            this.logtrackingIndex = addColumnDetails("logtracking", objectSchemaInfo);
            this.HorizonVersionIndex = addColumnDetails("HorizonVersion", objectSchemaInfo);
            this.HealthThrowBrowserIndex = addColumnDetails("HealthThrowBrowser", objectSchemaInfo);
        }

        ConstantEntityColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new ConstantEntityColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final ConstantEntityColumnInfo src = (ConstantEntityColumnInfo) rawSrc;
            final ConstantEntityColumnInfo dst = (ConstantEntityColumnInfo) rawDst;
            dst.VersionCodeIndex = src.VersionCodeIndex;
            dst.IsForceUpdateIndex = src.IsForceUpdateIndex;
            dst.PBNoOfHitsIndex = src.PBNoOfHitsIndex;
            dst.PBHitTimeIndex = src.PBHitTimeIndex;
            dst.ROIHLBLIndex = src.ROIHLBLIndex;
            dst.ROIPLBLIndex = src.ROIPLBLIndex;
            dst.ROILABLIndex = src.ROILABLIndex;
            dst.POSPNoIndex = src.POSPNoIndex;
            dst.POSPStatIndex = src.POSPStatIndex;
            dst.HelpNumberIndex = src.HelpNumberIndex;
            dst.healthappenableIndex = src.healthappenableIndex;
            dst.POSPTrainingIndex = src.POSPTrainingIndex;
            dst.MPSStatusIndex = src.MPSStatusIndex;
            dst.UpdateMasterIndex = src.UpdateMasterIndex;
            dst.logtrackingIndex = src.logtrackingIndex;
            dst.HorizonVersionIndex = src.HorizonVersionIndex;
            dst.HealthThrowBrowserIndex = src.HealthThrowBrowserIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>(17);
        fieldNames.add("VersionCode");
        fieldNames.add("IsForceUpdate");
        fieldNames.add("PBNoOfHits");
        fieldNames.add("PBHitTime");
        fieldNames.add("ROIHLBL");
        fieldNames.add("ROIPLBL");
        fieldNames.add("ROILABL");
        fieldNames.add("POSPNo");
        fieldNames.add("POSPStat");
        fieldNames.add("HelpNumber");
        fieldNames.add("healthappenable");
        fieldNames.add("POSPTraining");
        fieldNames.add("MPSStatus");
        fieldNames.add("UpdateMaster");
        fieldNames.add("logtracking");
        fieldNames.add("HorizonVersion");
        fieldNames.add("HealthThrowBrowser");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    private ConstantEntityColumnInfo columnInfo;
    private ProxyState<magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ConstantEntity> proxyState;

    ConstantEntityRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (ConstantEntityColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ConstantEntity>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$VersionCode() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.VersionCodeIndex);
    }

    @Override
    public void realmSet$VersionCode(String value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'VersionCode' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$IsForceUpdate() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.IsForceUpdateIndex);
    }

    @Override
    public void realmSet$IsForceUpdate(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.IsForceUpdateIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.IsForceUpdateIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.IsForceUpdateIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.IsForceUpdateIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$PBNoOfHits() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.PBNoOfHitsIndex);
    }

    @Override
    public void realmSet$PBNoOfHits(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.PBNoOfHitsIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.PBNoOfHitsIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.PBNoOfHitsIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.PBNoOfHitsIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$PBHitTime() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.PBHitTimeIndex);
    }

    @Override
    public void realmSet$PBHitTime(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.PBHitTimeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.PBHitTimeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.PBHitTimeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.PBHitTimeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$ROIHLBL() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.ROIHLBLIndex);
    }

    @Override
    public void realmSet$ROIHLBL(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.ROIHLBLIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.ROIHLBLIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.ROIHLBLIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.ROIHLBLIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$ROIPLBL() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.ROIPLBLIndex);
    }

    @Override
    public void realmSet$ROIPLBL(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.ROIPLBLIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.ROIPLBLIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.ROIPLBLIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.ROIPLBLIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$ROILABL() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.ROILABLIndex);
    }

    @Override
    public void realmSet$ROILABL(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.ROILABLIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.ROILABLIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.ROILABLIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.ROILABLIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$POSPNo() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.POSPNoIndex);
    }

    @Override
    public void realmSet$POSPNo(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.POSPNoIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.POSPNoIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.POSPNoIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.POSPNoIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$POSPStat() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.POSPStatIndex);
    }

    @Override
    public void realmSet$POSPStat(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.POSPStatIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.POSPStatIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.POSPStatIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.POSPStatIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$HelpNumber() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.HelpNumberIndex);
    }

    @Override
    public void realmSet$HelpNumber(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.HelpNumberIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.HelpNumberIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.HelpNumberIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.HelpNumberIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$healthappenable() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.healthappenableIndex);
    }

    @Override
    public void realmSet$healthappenable(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.healthappenableIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.healthappenableIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.healthappenableIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.healthappenableIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$POSPTraining() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.POSPTrainingIndex);
    }

    @Override
    public void realmSet$POSPTraining(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.POSPTrainingIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.POSPTrainingIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.POSPTrainingIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.POSPTrainingIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$MPSStatus() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.MPSStatusIndex);
    }

    @Override
    public void realmSet$MPSStatus(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.MPSStatusIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.MPSStatusIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.MPSStatusIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.MPSStatusIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$UpdateMaster() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.UpdateMasterIndex);
    }

    @Override
    public void realmSet$UpdateMaster(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.UpdateMasterIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.UpdateMasterIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.UpdateMasterIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.UpdateMasterIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$logtracking() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.logtrackingIndex);
    }

    @Override
    public void realmSet$logtracking(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.logtrackingIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.logtrackingIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.logtrackingIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.logtrackingIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$HorizonVersion() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.HorizonVersionIndex);
    }

    @Override
    public void realmSet$HorizonVersion(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.HorizonVersionIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.HorizonVersionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.HorizonVersionIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.HorizonVersionIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$HealthThrowBrowser() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.HealthThrowBrowserIndex);
    }

    @Override
    public void realmSet$HealthThrowBrowser(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.HealthThrowBrowserIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.HealthThrowBrowserIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.HealthThrowBrowserIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.HealthThrowBrowserIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("ConstantEntity", 17, 0);
        builder.addPersistedProperty("VersionCode", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("IsForceUpdate", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("PBNoOfHits", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("PBHitTime", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("ROIHLBL", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("ROIPLBL", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("ROILABL", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("POSPNo", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("POSPStat", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("HelpNumber", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("healthappenable", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("POSPTraining", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("MPSStatus", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("UpdateMaster", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("logtracking", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("HorizonVersion", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("HealthThrowBrowser", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static ConstantEntityColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new ConstantEntityColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "ConstantEntity";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ConstantEntity createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ConstantEntity obj = null;
        if (update) {
            Table table = realm.getTable(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ConstantEntity.class);
            ConstantEntityColumnInfo columnInfo = (ConstantEntityColumnInfo) realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ConstantEntity.class);
            long pkColumnIndex = columnInfo.VersionCodeIndex;
            long rowIndex = Table.NO_MATCH;
            if (json.isNull("VersionCode")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("VersionCode"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ConstantEntity.class), false, Collections.<String> emptyList());
                    obj = new io.realm.ConstantEntityRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("VersionCode")) {
                if (json.isNull("VersionCode")) {
                    obj = (io.realm.ConstantEntityRealmProxy) realm.createObjectInternal(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ConstantEntity.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.ConstantEntityRealmProxy) realm.createObjectInternal(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ConstantEntity.class, json.getString("VersionCode"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'VersionCode'.");
            }
        }

        final ConstantEntityRealmProxyInterface objProxy = (ConstantEntityRealmProxyInterface) obj;
        if (json.has("IsForceUpdate")) {
            if (json.isNull("IsForceUpdate")) {
                objProxy.realmSet$IsForceUpdate(null);
            } else {
                objProxy.realmSet$IsForceUpdate((String) json.getString("IsForceUpdate"));
            }
        }
        if (json.has("PBNoOfHits")) {
            if (json.isNull("PBNoOfHits")) {
                objProxy.realmSet$PBNoOfHits(null);
            } else {
                objProxy.realmSet$PBNoOfHits((String) json.getString("PBNoOfHits"));
            }
        }
        if (json.has("PBHitTime")) {
            if (json.isNull("PBHitTime")) {
                objProxy.realmSet$PBHitTime(null);
            } else {
                objProxy.realmSet$PBHitTime((String) json.getString("PBHitTime"));
            }
        }
        if (json.has("ROIHLBL")) {
            if (json.isNull("ROIHLBL")) {
                objProxy.realmSet$ROIHLBL(null);
            } else {
                objProxy.realmSet$ROIHLBL((String) json.getString("ROIHLBL"));
            }
        }
        if (json.has("ROIPLBL")) {
            if (json.isNull("ROIPLBL")) {
                objProxy.realmSet$ROIPLBL(null);
            } else {
                objProxy.realmSet$ROIPLBL((String) json.getString("ROIPLBL"));
            }
        }
        if (json.has("ROILABL")) {
            if (json.isNull("ROILABL")) {
                objProxy.realmSet$ROILABL(null);
            } else {
                objProxy.realmSet$ROILABL((String) json.getString("ROILABL"));
            }
        }
        if (json.has("POSPNo")) {
            if (json.isNull("POSPNo")) {
                objProxy.realmSet$POSPNo(null);
            } else {
                objProxy.realmSet$POSPNo((String) json.getString("POSPNo"));
            }
        }
        if (json.has("POSPStat")) {
            if (json.isNull("POSPStat")) {
                objProxy.realmSet$POSPStat(null);
            } else {
                objProxy.realmSet$POSPStat((String) json.getString("POSPStat"));
            }
        }
        if (json.has("HelpNumber")) {
            if (json.isNull("HelpNumber")) {
                objProxy.realmSet$HelpNumber(null);
            } else {
                objProxy.realmSet$HelpNumber((String) json.getString("HelpNumber"));
            }
        }
        if (json.has("healthappenable")) {
            if (json.isNull("healthappenable")) {
                objProxy.realmSet$healthappenable(null);
            } else {
                objProxy.realmSet$healthappenable((String) json.getString("healthappenable"));
            }
        }
        if (json.has("POSPTraining")) {
            if (json.isNull("POSPTraining")) {
                objProxy.realmSet$POSPTraining(null);
            } else {
                objProxy.realmSet$POSPTraining((String) json.getString("POSPTraining"));
            }
        }
        if (json.has("MPSStatus")) {
            if (json.isNull("MPSStatus")) {
                objProxy.realmSet$MPSStatus(null);
            } else {
                objProxy.realmSet$MPSStatus((String) json.getString("MPSStatus"));
            }
        }
        if (json.has("UpdateMaster")) {
            if (json.isNull("UpdateMaster")) {
                objProxy.realmSet$UpdateMaster(null);
            } else {
                objProxy.realmSet$UpdateMaster((String) json.getString("UpdateMaster"));
            }
        }
        if (json.has("logtracking")) {
            if (json.isNull("logtracking")) {
                objProxy.realmSet$logtracking(null);
            } else {
                objProxy.realmSet$logtracking((String) json.getString("logtracking"));
            }
        }
        if (json.has("HorizonVersion")) {
            if (json.isNull("HorizonVersion")) {
                objProxy.realmSet$HorizonVersion(null);
            } else {
                objProxy.realmSet$HorizonVersion((String) json.getString("HorizonVersion"));
            }
        }
        if (json.has("HealthThrowBrowser")) {
            if (json.isNull("HealthThrowBrowser")) {
                objProxy.realmSet$HealthThrowBrowser(null);
            } else {
                objProxy.realmSet$HealthThrowBrowser((String) json.getString("HealthThrowBrowser"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ConstantEntity createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ConstantEntity obj = new magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ConstantEntity();
        final ConstantEntityRealmProxyInterface objProxy = (ConstantEntityRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("VersionCode")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$VersionCode((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$VersionCode(null);
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("IsForceUpdate")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$IsForceUpdate((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$IsForceUpdate(null);
                }
            } else if (name.equals("PBNoOfHits")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$PBNoOfHits((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$PBNoOfHits(null);
                }
            } else if (name.equals("PBHitTime")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$PBHitTime((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$PBHitTime(null);
                }
            } else if (name.equals("ROIHLBL")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$ROIHLBL((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$ROIHLBL(null);
                }
            } else if (name.equals("ROIPLBL")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$ROIPLBL((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$ROIPLBL(null);
                }
            } else if (name.equals("ROILABL")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$ROILABL((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$ROILABL(null);
                }
            } else if (name.equals("POSPNo")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$POSPNo((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$POSPNo(null);
                }
            } else if (name.equals("POSPStat")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$POSPStat((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$POSPStat(null);
                }
            } else if (name.equals("HelpNumber")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$HelpNumber((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$HelpNumber(null);
                }
            } else if (name.equals("healthappenable")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$healthappenable((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$healthappenable(null);
                }
            } else if (name.equals("POSPTraining")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$POSPTraining((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$POSPTraining(null);
                }
            } else if (name.equals("MPSStatus")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$MPSStatus((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$MPSStatus(null);
                }
            } else if (name.equals("UpdateMaster")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$UpdateMaster((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$UpdateMaster(null);
                }
            } else if (name.equals("logtracking")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$logtracking((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$logtracking(null);
                }
            } else if (name.equals("HorizonVersion")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$HorizonVersion((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$HorizonVersion(null);
                }
            } else if (name.equals("HealthThrowBrowser")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$HealthThrowBrowser((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$HealthThrowBrowser(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'VersionCode'.");
        }
        return realm.copyToRealm(obj);
    }

    public static magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ConstantEntity copyOrUpdate(Realm realm, magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ConstantEntity object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ConstantEntity) cachedRealmObject;
        }

        magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ConstantEntity realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ConstantEntity.class);
            ConstantEntityColumnInfo columnInfo = (ConstantEntityColumnInfo) realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ConstantEntity.class);
            long pkColumnIndex = columnInfo.VersionCodeIndex;
            String value = ((ConstantEntityRealmProxyInterface) object).realmGet$VersionCode();
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ConstantEntity.class), false, Collections.<String> emptyList());
                    realmObject = new io.realm.ConstantEntityRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, realmObject, object, cache) : copy(realm, object, update, cache);
    }

    public static magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ConstantEntity copy(Realm realm, magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ConstantEntity newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ConstantEntity) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ConstantEntity realmObject = realm.createObjectInternal(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ConstantEntity.class, ((ConstantEntityRealmProxyInterface) newObject).realmGet$VersionCode(), false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        ConstantEntityRealmProxyInterface realmObjectSource = (ConstantEntityRealmProxyInterface) newObject;
        ConstantEntityRealmProxyInterface realmObjectCopy = (ConstantEntityRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$IsForceUpdate(realmObjectSource.realmGet$IsForceUpdate());
        realmObjectCopy.realmSet$PBNoOfHits(realmObjectSource.realmGet$PBNoOfHits());
        realmObjectCopy.realmSet$PBHitTime(realmObjectSource.realmGet$PBHitTime());
        realmObjectCopy.realmSet$ROIHLBL(realmObjectSource.realmGet$ROIHLBL());
        realmObjectCopy.realmSet$ROIPLBL(realmObjectSource.realmGet$ROIPLBL());
        realmObjectCopy.realmSet$ROILABL(realmObjectSource.realmGet$ROILABL());
        realmObjectCopy.realmSet$POSPNo(realmObjectSource.realmGet$POSPNo());
        realmObjectCopy.realmSet$POSPStat(realmObjectSource.realmGet$POSPStat());
        realmObjectCopy.realmSet$HelpNumber(realmObjectSource.realmGet$HelpNumber());
        realmObjectCopy.realmSet$healthappenable(realmObjectSource.realmGet$healthappenable());
        realmObjectCopy.realmSet$POSPTraining(realmObjectSource.realmGet$POSPTraining());
        realmObjectCopy.realmSet$MPSStatus(realmObjectSource.realmGet$MPSStatus());
        realmObjectCopy.realmSet$UpdateMaster(realmObjectSource.realmGet$UpdateMaster());
        realmObjectCopy.realmSet$logtracking(realmObjectSource.realmGet$logtracking());
        realmObjectCopy.realmSet$HorizonVersion(realmObjectSource.realmGet$HorizonVersion());
        realmObjectCopy.realmSet$HealthThrowBrowser(realmObjectSource.realmGet$HealthThrowBrowser());
        return realmObject;
    }

    public static long insert(Realm realm, magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ConstantEntity object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ConstantEntity.class);
        long tableNativePtr = table.getNativePtr();
        ConstantEntityColumnInfo columnInfo = (ConstantEntityColumnInfo) realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ConstantEntity.class);
        long pkColumnIndex = columnInfo.VersionCodeIndex;
        String primaryKeyValue = ((ConstantEntityRealmProxyInterface) object).realmGet$VersionCode();
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
        String realmGet$IsForceUpdate = ((ConstantEntityRealmProxyInterface) object).realmGet$IsForceUpdate();
        if (realmGet$IsForceUpdate != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.IsForceUpdateIndex, rowIndex, realmGet$IsForceUpdate, false);
        }
        String realmGet$PBNoOfHits = ((ConstantEntityRealmProxyInterface) object).realmGet$PBNoOfHits();
        if (realmGet$PBNoOfHits != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.PBNoOfHitsIndex, rowIndex, realmGet$PBNoOfHits, false);
        }
        String realmGet$PBHitTime = ((ConstantEntityRealmProxyInterface) object).realmGet$PBHitTime();
        if (realmGet$PBHitTime != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.PBHitTimeIndex, rowIndex, realmGet$PBHitTime, false);
        }
        String realmGet$ROIHLBL = ((ConstantEntityRealmProxyInterface) object).realmGet$ROIHLBL();
        if (realmGet$ROIHLBL != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.ROIHLBLIndex, rowIndex, realmGet$ROIHLBL, false);
        }
        String realmGet$ROIPLBL = ((ConstantEntityRealmProxyInterface) object).realmGet$ROIPLBL();
        if (realmGet$ROIPLBL != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.ROIPLBLIndex, rowIndex, realmGet$ROIPLBL, false);
        }
        String realmGet$ROILABL = ((ConstantEntityRealmProxyInterface) object).realmGet$ROILABL();
        if (realmGet$ROILABL != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.ROILABLIndex, rowIndex, realmGet$ROILABL, false);
        }
        String realmGet$POSPNo = ((ConstantEntityRealmProxyInterface) object).realmGet$POSPNo();
        if (realmGet$POSPNo != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.POSPNoIndex, rowIndex, realmGet$POSPNo, false);
        }
        String realmGet$POSPStat = ((ConstantEntityRealmProxyInterface) object).realmGet$POSPStat();
        if (realmGet$POSPStat != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.POSPStatIndex, rowIndex, realmGet$POSPStat, false);
        }
        String realmGet$HelpNumber = ((ConstantEntityRealmProxyInterface) object).realmGet$HelpNumber();
        if (realmGet$HelpNumber != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.HelpNumberIndex, rowIndex, realmGet$HelpNumber, false);
        }
        String realmGet$healthappenable = ((ConstantEntityRealmProxyInterface) object).realmGet$healthappenable();
        if (realmGet$healthappenable != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.healthappenableIndex, rowIndex, realmGet$healthappenable, false);
        }
        String realmGet$POSPTraining = ((ConstantEntityRealmProxyInterface) object).realmGet$POSPTraining();
        if (realmGet$POSPTraining != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.POSPTrainingIndex, rowIndex, realmGet$POSPTraining, false);
        }
        String realmGet$MPSStatus = ((ConstantEntityRealmProxyInterface) object).realmGet$MPSStatus();
        if (realmGet$MPSStatus != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.MPSStatusIndex, rowIndex, realmGet$MPSStatus, false);
        }
        String realmGet$UpdateMaster = ((ConstantEntityRealmProxyInterface) object).realmGet$UpdateMaster();
        if (realmGet$UpdateMaster != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.UpdateMasterIndex, rowIndex, realmGet$UpdateMaster, false);
        }
        String realmGet$logtracking = ((ConstantEntityRealmProxyInterface) object).realmGet$logtracking();
        if (realmGet$logtracking != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.logtrackingIndex, rowIndex, realmGet$logtracking, false);
        }
        String realmGet$HorizonVersion = ((ConstantEntityRealmProxyInterface) object).realmGet$HorizonVersion();
        if (realmGet$HorizonVersion != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.HorizonVersionIndex, rowIndex, realmGet$HorizonVersion, false);
        }
        String realmGet$HealthThrowBrowser = ((ConstantEntityRealmProxyInterface) object).realmGet$HealthThrowBrowser();
        if (realmGet$HealthThrowBrowser != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.HealthThrowBrowserIndex, rowIndex, realmGet$HealthThrowBrowser, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ConstantEntity.class);
        long tableNativePtr = table.getNativePtr();
        ConstantEntityColumnInfo columnInfo = (ConstantEntityColumnInfo) realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ConstantEntity.class);
        long pkColumnIndex = columnInfo.VersionCodeIndex;
        magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ConstantEntity object = null;
        while (objects.hasNext()) {
            object = (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ConstantEntity) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((ConstantEntityRealmProxyInterface) object).realmGet$VersionCode();
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
            String realmGet$IsForceUpdate = ((ConstantEntityRealmProxyInterface) object).realmGet$IsForceUpdate();
            if (realmGet$IsForceUpdate != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.IsForceUpdateIndex, rowIndex, realmGet$IsForceUpdate, false);
            }
            String realmGet$PBNoOfHits = ((ConstantEntityRealmProxyInterface) object).realmGet$PBNoOfHits();
            if (realmGet$PBNoOfHits != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.PBNoOfHitsIndex, rowIndex, realmGet$PBNoOfHits, false);
            }
            String realmGet$PBHitTime = ((ConstantEntityRealmProxyInterface) object).realmGet$PBHitTime();
            if (realmGet$PBHitTime != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.PBHitTimeIndex, rowIndex, realmGet$PBHitTime, false);
            }
            String realmGet$ROIHLBL = ((ConstantEntityRealmProxyInterface) object).realmGet$ROIHLBL();
            if (realmGet$ROIHLBL != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.ROIHLBLIndex, rowIndex, realmGet$ROIHLBL, false);
            }
            String realmGet$ROIPLBL = ((ConstantEntityRealmProxyInterface) object).realmGet$ROIPLBL();
            if (realmGet$ROIPLBL != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.ROIPLBLIndex, rowIndex, realmGet$ROIPLBL, false);
            }
            String realmGet$ROILABL = ((ConstantEntityRealmProxyInterface) object).realmGet$ROILABL();
            if (realmGet$ROILABL != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.ROILABLIndex, rowIndex, realmGet$ROILABL, false);
            }
            String realmGet$POSPNo = ((ConstantEntityRealmProxyInterface) object).realmGet$POSPNo();
            if (realmGet$POSPNo != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.POSPNoIndex, rowIndex, realmGet$POSPNo, false);
            }
            String realmGet$POSPStat = ((ConstantEntityRealmProxyInterface) object).realmGet$POSPStat();
            if (realmGet$POSPStat != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.POSPStatIndex, rowIndex, realmGet$POSPStat, false);
            }
            String realmGet$HelpNumber = ((ConstantEntityRealmProxyInterface) object).realmGet$HelpNumber();
            if (realmGet$HelpNumber != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.HelpNumberIndex, rowIndex, realmGet$HelpNumber, false);
            }
            String realmGet$healthappenable = ((ConstantEntityRealmProxyInterface) object).realmGet$healthappenable();
            if (realmGet$healthappenable != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.healthappenableIndex, rowIndex, realmGet$healthappenable, false);
            }
            String realmGet$POSPTraining = ((ConstantEntityRealmProxyInterface) object).realmGet$POSPTraining();
            if (realmGet$POSPTraining != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.POSPTrainingIndex, rowIndex, realmGet$POSPTraining, false);
            }
            String realmGet$MPSStatus = ((ConstantEntityRealmProxyInterface) object).realmGet$MPSStatus();
            if (realmGet$MPSStatus != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.MPSStatusIndex, rowIndex, realmGet$MPSStatus, false);
            }
            String realmGet$UpdateMaster = ((ConstantEntityRealmProxyInterface) object).realmGet$UpdateMaster();
            if (realmGet$UpdateMaster != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.UpdateMasterIndex, rowIndex, realmGet$UpdateMaster, false);
            }
            String realmGet$logtracking = ((ConstantEntityRealmProxyInterface) object).realmGet$logtracking();
            if (realmGet$logtracking != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.logtrackingIndex, rowIndex, realmGet$logtracking, false);
            }
            String realmGet$HorizonVersion = ((ConstantEntityRealmProxyInterface) object).realmGet$HorizonVersion();
            if (realmGet$HorizonVersion != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.HorizonVersionIndex, rowIndex, realmGet$HorizonVersion, false);
            }
            String realmGet$HealthThrowBrowser = ((ConstantEntityRealmProxyInterface) object).realmGet$HealthThrowBrowser();
            if (realmGet$HealthThrowBrowser != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.HealthThrowBrowserIndex, rowIndex, realmGet$HealthThrowBrowser, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ConstantEntity object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ConstantEntity.class);
        long tableNativePtr = table.getNativePtr();
        ConstantEntityColumnInfo columnInfo = (ConstantEntityColumnInfo) realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ConstantEntity.class);
        long pkColumnIndex = columnInfo.VersionCodeIndex;
        String primaryKeyValue = ((ConstantEntityRealmProxyInterface) object).realmGet$VersionCode();
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
        String realmGet$IsForceUpdate = ((ConstantEntityRealmProxyInterface) object).realmGet$IsForceUpdate();
        if (realmGet$IsForceUpdate != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.IsForceUpdateIndex, rowIndex, realmGet$IsForceUpdate, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.IsForceUpdateIndex, rowIndex, false);
        }
        String realmGet$PBNoOfHits = ((ConstantEntityRealmProxyInterface) object).realmGet$PBNoOfHits();
        if (realmGet$PBNoOfHits != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.PBNoOfHitsIndex, rowIndex, realmGet$PBNoOfHits, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.PBNoOfHitsIndex, rowIndex, false);
        }
        String realmGet$PBHitTime = ((ConstantEntityRealmProxyInterface) object).realmGet$PBHitTime();
        if (realmGet$PBHitTime != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.PBHitTimeIndex, rowIndex, realmGet$PBHitTime, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.PBHitTimeIndex, rowIndex, false);
        }
        String realmGet$ROIHLBL = ((ConstantEntityRealmProxyInterface) object).realmGet$ROIHLBL();
        if (realmGet$ROIHLBL != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.ROIHLBLIndex, rowIndex, realmGet$ROIHLBL, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.ROIHLBLIndex, rowIndex, false);
        }
        String realmGet$ROIPLBL = ((ConstantEntityRealmProxyInterface) object).realmGet$ROIPLBL();
        if (realmGet$ROIPLBL != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.ROIPLBLIndex, rowIndex, realmGet$ROIPLBL, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.ROIPLBLIndex, rowIndex, false);
        }
        String realmGet$ROILABL = ((ConstantEntityRealmProxyInterface) object).realmGet$ROILABL();
        if (realmGet$ROILABL != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.ROILABLIndex, rowIndex, realmGet$ROILABL, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.ROILABLIndex, rowIndex, false);
        }
        String realmGet$POSPNo = ((ConstantEntityRealmProxyInterface) object).realmGet$POSPNo();
        if (realmGet$POSPNo != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.POSPNoIndex, rowIndex, realmGet$POSPNo, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.POSPNoIndex, rowIndex, false);
        }
        String realmGet$POSPStat = ((ConstantEntityRealmProxyInterface) object).realmGet$POSPStat();
        if (realmGet$POSPStat != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.POSPStatIndex, rowIndex, realmGet$POSPStat, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.POSPStatIndex, rowIndex, false);
        }
        String realmGet$HelpNumber = ((ConstantEntityRealmProxyInterface) object).realmGet$HelpNumber();
        if (realmGet$HelpNumber != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.HelpNumberIndex, rowIndex, realmGet$HelpNumber, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.HelpNumberIndex, rowIndex, false);
        }
        String realmGet$healthappenable = ((ConstantEntityRealmProxyInterface) object).realmGet$healthappenable();
        if (realmGet$healthappenable != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.healthappenableIndex, rowIndex, realmGet$healthappenable, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.healthappenableIndex, rowIndex, false);
        }
        String realmGet$POSPTraining = ((ConstantEntityRealmProxyInterface) object).realmGet$POSPTraining();
        if (realmGet$POSPTraining != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.POSPTrainingIndex, rowIndex, realmGet$POSPTraining, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.POSPTrainingIndex, rowIndex, false);
        }
        String realmGet$MPSStatus = ((ConstantEntityRealmProxyInterface) object).realmGet$MPSStatus();
        if (realmGet$MPSStatus != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.MPSStatusIndex, rowIndex, realmGet$MPSStatus, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.MPSStatusIndex, rowIndex, false);
        }
        String realmGet$UpdateMaster = ((ConstantEntityRealmProxyInterface) object).realmGet$UpdateMaster();
        if (realmGet$UpdateMaster != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.UpdateMasterIndex, rowIndex, realmGet$UpdateMaster, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.UpdateMasterIndex, rowIndex, false);
        }
        String realmGet$logtracking = ((ConstantEntityRealmProxyInterface) object).realmGet$logtracking();
        if (realmGet$logtracking != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.logtrackingIndex, rowIndex, realmGet$logtracking, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.logtrackingIndex, rowIndex, false);
        }
        String realmGet$HorizonVersion = ((ConstantEntityRealmProxyInterface) object).realmGet$HorizonVersion();
        if (realmGet$HorizonVersion != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.HorizonVersionIndex, rowIndex, realmGet$HorizonVersion, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.HorizonVersionIndex, rowIndex, false);
        }
        String realmGet$HealthThrowBrowser = ((ConstantEntityRealmProxyInterface) object).realmGet$HealthThrowBrowser();
        if (realmGet$HealthThrowBrowser != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.HealthThrowBrowserIndex, rowIndex, realmGet$HealthThrowBrowser, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.HealthThrowBrowserIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ConstantEntity.class);
        long tableNativePtr = table.getNativePtr();
        ConstantEntityColumnInfo columnInfo = (ConstantEntityColumnInfo) realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ConstantEntity.class);
        long pkColumnIndex = columnInfo.VersionCodeIndex;
        magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ConstantEntity object = null;
        while (objects.hasNext()) {
            object = (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ConstantEntity) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((ConstantEntityRealmProxyInterface) object).realmGet$VersionCode();
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
            String realmGet$IsForceUpdate = ((ConstantEntityRealmProxyInterface) object).realmGet$IsForceUpdate();
            if (realmGet$IsForceUpdate != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.IsForceUpdateIndex, rowIndex, realmGet$IsForceUpdate, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.IsForceUpdateIndex, rowIndex, false);
            }
            String realmGet$PBNoOfHits = ((ConstantEntityRealmProxyInterface) object).realmGet$PBNoOfHits();
            if (realmGet$PBNoOfHits != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.PBNoOfHitsIndex, rowIndex, realmGet$PBNoOfHits, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.PBNoOfHitsIndex, rowIndex, false);
            }
            String realmGet$PBHitTime = ((ConstantEntityRealmProxyInterface) object).realmGet$PBHitTime();
            if (realmGet$PBHitTime != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.PBHitTimeIndex, rowIndex, realmGet$PBHitTime, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.PBHitTimeIndex, rowIndex, false);
            }
            String realmGet$ROIHLBL = ((ConstantEntityRealmProxyInterface) object).realmGet$ROIHLBL();
            if (realmGet$ROIHLBL != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.ROIHLBLIndex, rowIndex, realmGet$ROIHLBL, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.ROIHLBLIndex, rowIndex, false);
            }
            String realmGet$ROIPLBL = ((ConstantEntityRealmProxyInterface) object).realmGet$ROIPLBL();
            if (realmGet$ROIPLBL != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.ROIPLBLIndex, rowIndex, realmGet$ROIPLBL, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.ROIPLBLIndex, rowIndex, false);
            }
            String realmGet$ROILABL = ((ConstantEntityRealmProxyInterface) object).realmGet$ROILABL();
            if (realmGet$ROILABL != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.ROILABLIndex, rowIndex, realmGet$ROILABL, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.ROILABLIndex, rowIndex, false);
            }
            String realmGet$POSPNo = ((ConstantEntityRealmProxyInterface) object).realmGet$POSPNo();
            if (realmGet$POSPNo != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.POSPNoIndex, rowIndex, realmGet$POSPNo, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.POSPNoIndex, rowIndex, false);
            }
            String realmGet$POSPStat = ((ConstantEntityRealmProxyInterface) object).realmGet$POSPStat();
            if (realmGet$POSPStat != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.POSPStatIndex, rowIndex, realmGet$POSPStat, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.POSPStatIndex, rowIndex, false);
            }
            String realmGet$HelpNumber = ((ConstantEntityRealmProxyInterface) object).realmGet$HelpNumber();
            if (realmGet$HelpNumber != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.HelpNumberIndex, rowIndex, realmGet$HelpNumber, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.HelpNumberIndex, rowIndex, false);
            }
            String realmGet$healthappenable = ((ConstantEntityRealmProxyInterface) object).realmGet$healthappenable();
            if (realmGet$healthappenable != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.healthappenableIndex, rowIndex, realmGet$healthappenable, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.healthappenableIndex, rowIndex, false);
            }
            String realmGet$POSPTraining = ((ConstantEntityRealmProxyInterface) object).realmGet$POSPTraining();
            if (realmGet$POSPTraining != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.POSPTrainingIndex, rowIndex, realmGet$POSPTraining, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.POSPTrainingIndex, rowIndex, false);
            }
            String realmGet$MPSStatus = ((ConstantEntityRealmProxyInterface) object).realmGet$MPSStatus();
            if (realmGet$MPSStatus != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.MPSStatusIndex, rowIndex, realmGet$MPSStatus, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.MPSStatusIndex, rowIndex, false);
            }
            String realmGet$UpdateMaster = ((ConstantEntityRealmProxyInterface) object).realmGet$UpdateMaster();
            if (realmGet$UpdateMaster != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.UpdateMasterIndex, rowIndex, realmGet$UpdateMaster, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.UpdateMasterIndex, rowIndex, false);
            }
            String realmGet$logtracking = ((ConstantEntityRealmProxyInterface) object).realmGet$logtracking();
            if (realmGet$logtracking != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.logtrackingIndex, rowIndex, realmGet$logtracking, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.logtrackingIndex, rowIndex, false);
            }
            String realmGet$HorizonVersion = ((ConstantEntityRealmProxyInterface) object).realmGet$HorizonVersion();
            if (realmGet$HorizonVersion != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.HorizonVersionIndex, rowIndex, realmGet$HorizonVersion, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.HorizonVersionIndex, rowIndex, false);
            }
            String realmGet$HealthThrowBrowser = ((ConstantEntityRealmProxyInterface) object).realmGet$HealthThrowBrowser();
            if (realmGet$HealthThrowBrowser != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.HealthThrowBrowserIndex, rowIndex, realmGet$HealthThrowBrowser, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.HealthThrowBrowserIndex, rowIndex, false);
            }
        }
    }

    public static magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ConstantEntity createDetachedCopy(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ConstantEntity realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ConstantEntity unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ConstantEntity();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ConstantEntity) cachedObject.object;
            }
            unmanagedObject = (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ConstantEntity) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        ConstantEntityRealmProxyInterface unmanagedCopy = (ConstantEntityRealmProxyInterface) unmanagedObject;
        ConstantEntityRealmProxyInterface realmSource = (ConstantEntityRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$VersionCode(realmSource.realmGet$VersionCode());
        unmanagedCopy.realmSet$IsForceUpdate(realmSource.realmGet$IsForceUpdate());
        unmanagedCopy.realmSet$PBNoOfHits(realmSource.realmGet$PBNoOfHits());
        unmanagedCopy.realmSet$PBHitTime(realmSource.realmGet$PBHitTime());
        unmanagedCopy.realmSet$ROIHLBL(realmSource.realmGet$ROIHLBL());
        unmanagedCopy.realmSet$ROIPLBL(realmSource.realmGet$ROIPLBL());
        unmanagedCopy.realmSet$ROILABL(realmSource.realmGet$ROILABL());
        unmanagedCopy.realmSet$POSPNo(realmSource.realmGet$POSPNo());
        unmanagedCopy.realmSet$POSPStat(realmSource.realmGet$POSPStat());
        unmanagedCopy.realmSet$HelpNumber(realmSource.realmGet$HelpNumber());
        unmanagedCopy.realmSet$healthappenable(realmSource.realmGet$healthappenable());
        unmanagedCopy.realmSet$POSPTraining(realmSource.realmGet$POSPTraining());
        unmanagedCopy.realmSet$MPSStatus(realmSource.realmGet$MPSStatus());
        unmanagedCopy.realmSet$UpdateMaster(realmSource.realmGet$UpdateMaster());
        unmanagedCopy.realmSet$logtracking(realmSource.realmGet$logtracking());
        unmanagedCopy.realmSet$HorizonVersion(realmSource.realmGet$HorizonVersion());
        unmanagedCopy.realmSet$HealthThrowBrowser(realmSource.realmGet$HealthThrowBrowser());

        return unmanagedObject;
    }

    static magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ConstantEntity update(Realm realm, magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ConstantEntity realmObject, magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ConstantEntity newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ConstantEntityRealmProxyInterface realmObjectTarget = (ConstantEntityRealmProxyInterface) realmObject;
        ConstantEntityRealmProxyInterface realmObjectSource = (ConstantEntityRealmProxyInterface) newObject;
        realmObjectTarget.realmSet$IsForceUpdate(realmObjectSource.realmGet$IsForceUpdate());
        realmObjectTarget.realmSet$PBNoOfHits(realmObjectSource.realmGet$PBNoOfHits());
        realmObjectTarget.realmSet$PBHitTime(realmObjectSource.realmGet$PBHitTime());
        realmObjectTarget.realmSet$ROIHLBL(realmObjectSource.realmGet$ROIHLBL());
        realmObjectTarget.realmSet$ROIPLBL(realmObjectSource.realmGet$ROIPLBL());
        realmObjectTarget.realmSet$ROILABL(realmObjectSource.realmGet$ROILABL());
        realmObjectTarget.realmSet$POSPNo(realmObjectSource.realmGet$POSPNo());
        realmObjectTarget.realmSet$POSPStat(realmObjectSource.realmGet$POSPStat());
        realmObjectTarget.realmSet$HelpNumber(realmObjectSource.realmGet$HelpNumber());
        realmObjectTarget.realmSet$healthappenable(realmObjectSource.realmGet$healthappenable());
        realmObjectTarget.realmSet$POSPTraining(realmObjectSource.realmGet$POSPTraining());
        realmObjectTarget.realmSet$MPSStatus(realmObjectSource.realmGet$MPSStatus());
        realmObjectTarget.realmSet$UpdateMaster(realmObjectSource.realmGet$UpdateMaster());
        realmObjectTarget.realmSet$logtracking(realmObjectSource.realmGet$logtracking());
        realmObjectTarget.realmSet$HorizonVersion(realmObjectSource.realmGet$HorizonVersion());
        realmObjectTarget.realmSet$HealthThrowBrowser(realmObjectSource.realmGet$HealthThrowBrowser());
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("ConstantEntity = proxy[");
        stringBuilder.append("{VersionCode:");
        stringBuilder.append(realmGet$VersionCode() != null ? realmGet$VersionCode() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{IsForceUpdate:");
        stringBuilder.append(realmGet$IsForceUpdate() != null ? realmGet$IsForceUpdate() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{PBNoOfHits:");
        stringBuilder.append(realmGet$PBNoOfHits() != null ? realmGet$PBNoOfHits() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{PBHitTime:");
        stringBuilder.append(realmGet$PBHitTime() != null ? realmGet$PBHitTime() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{ROIHLBL:");
        stringBuilder.append(realmGet$ROIHLBL() != null ? realmGet$ROIHLBL() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{ROIPLBL:");
        stringBuilder.append(realmGet$ROIPLBL() != null ? realmGet$ROIPLBL() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{ROILABL:");
        stringBuilder.append(realmGet$ROILABL() != null ? realmGet$ROILABL() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{POSPNo:");
        stringBuilder.append(realmGet$POSPNo() != null ? realmGet$POSPNo() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{POSPStat:");
        stringBuilder.append(realmGet$POSPStat() != null ? realmGet$POSPStat() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{HelpNumber:");
        stringBuilder.append(realmGet$HelpNumber() != null ? realmGet$HelpNumber() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{healthappenable:");
        stringBuilder.append(realmGet$healthappenable() != null ? realmGet$healthappenable() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{POSPTraining:");
        stringBuilder.append(realmGet$POSPTraining() != null ? realmGet$POSPTraining() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{MPSStatus:");
        stringBuilder.append(realmGet$MPSStatus() != null ? realmGet$MPSStatus() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{UpdateMaster:");
        stringBuilder.append(realmGet$UpdateMaster() != null ? realmGet$UpdateMaster() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{logtracking:");
        stringBuilder.append(realmGet$logtracking() != null ? realmGet$logtracking() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{HorizonVersion:");
        stringBuilder.append(realmGet$HorizonVersion() != null ? realmGet$HorizonVersion() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{HealthThrowBrowser:");
        stringBuilder.append(realmGet$HealthThrowBrowser() != null ? realmGet$HealthThrowBrowser() : "null");
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
        ConstantEntityRealmProxy aConstantEntity = (ConstantEntityRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aConstantEntity.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aConstantEntity.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aConstantEntity.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
