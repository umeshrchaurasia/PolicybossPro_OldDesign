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
public class BikeMasterEntityRealmProxy extends magicfinmart.datacomp.com.finmartserviceapi.finmart.model.BikeMasterEntity
    implements RealmObjectProxy, BikeMasterEntityRealmProxyInterface {

    static final class BikeMasterEntityColumnInfo extends ColumnInfo {
        long Make_IDIndex;
        long Make_NameIndex;
        long Model_IDIndex;
        long Model_NameIndex;
        long Variant_IDIndex;
        long Variant_NameIndex;
        long Model_ID1Index;
        long Cubic_CapacityIndex;
        long Fuel_IDIndex;
        long Seating_CapacityIndex;
        long ExShoroomPriceIndex;
        long IsActiveIndex;
        long CreatedOnIndex;
        long Product_Id_NewIndex;
        long Make_Name1Index;
        long Model_Name1Index;
        long Fuel_NameIndex;
        long DescriptionIndex;
        long Make_ID1Index;
        long ModifyOnIndex;

        BikeMasterEntityColumnInfo(OsSchemaInfo schemaInfo) {
            super(20);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("BikeMasterEntity");
            this.Make_IDIndex = addColumnDetails("Make_ID", objectSchemaInfo);
            this.Make_NameIndex = addColumnDetails("Make_Name", objectSchemaInfo);
            this.Model_IDIndex = addColumnDetails("Model_ID", objectSchemaInfo);
            this.Model_NameIndex = addColumnDetails("Model_Name", objectSchemaInfo);
            this.Variant_IDIndex = addColumnDetails("Variant_ID", objectSchemaInfo);
            this.Variant_NameIndex = addColumnDetails("Variant_Name", objectSchemaInfo);
            this.Model_ID1Index = addColumnDetails("Model_ID1", objectSchemaInfo);
            this.Cubic_CapacityIndex = addColumnDetails("Cubic_Capacity", objectSchemaInfo);
            this.Fuel_IDIndex = addColumnDetails("Fuel_ID", objectSchemaInfo);
            this.Seating_CapacityIndex = addColumnDetails("Seating_Capacity", objectSchemaInfo);
            this.ExShoroomPriceIndex = addColumnDetails("ExShoroomPrice", objectSchemaInfo);
            this.IsActiveIndex = addColumnDetails("IsActive", objectSchemaInfo);
            this.CreatedOnIndex = addColumnDetails("CreatedOn", objectSchemaInfo);
            this.Product_Id_NewIndex = addColumnDetails("Product_Id_New", objectSchemaInfo);
            this.Make_Name1Index = addColumnDetails("Make_Name1", objectSchemaInfo);
            this.Model_Name1Index = addColumnDetails("Model_Name1", objectSchemaInfo);
            this.Fuel_NameIndex = addColumnDetails("Fuel_Name", objectSchemaInfo);
            this.DescriptionIndex = addColumnDetails("Description", objectSchemaInfo);
            this.Make_ID1Index = addColumnDetails("Make_ID1", objectSchemaInfo);
            this.ModifyOnIndex = addColumnDetails("ModifyOn", objectSchemaInfo);
        }

        BikeMasterEntityColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new BikeMasterEntityColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final BikeMasterEntityColumnInfo src = (BikeMasterEntityColumnInfo) rawSrc;
            final BikeMasterEntityColumnInfo dst = (BikeMasterEntityColumnInfo) rawDst;
            dst.Make_IDIndex = src.Make_IDIndex;
            dst.Make_NameIndex = src.Make_NameIndex;
            dst.Model_IDIndex = src.Model_IDIndex;
            dst.Model_NameIndex = src.Model_NameIndex;
            dst.Variant_IDIndex = src.Variant_IDIndex;
            dst.Variant_NameIndex = src.Variant_NameIndex;
            dst.Model_ID1Index = src.Model_ID1Index;
            dst.Cubic_CapacityIndex = src.Cubic_CapacityIndex;
            dst.Fuel_IDIndex = src.Fuel_IDIndex;
            dst.Seating_CapacityIndex = src.Seating_CapacityIndex;
            dst.ExShoroomPriceIndex = src.ExShoroomPriceIndex;
            dst.IsActiveIndex = src.IsActiveIndex;
            dst.CreatedOnIndex = src.CreatedOnIndex;
            dst.Product_Id_NewIndex = src.Product_Id_NewIndex;
            dst.Make_Name1Index = src.Make_Name1Index;
            dst.Model_Name1Index = src.Model_Name1Index;
            dst.Fuel_NameIndex = src.Fuel_NameIndex;
            dst.DescriptionIndex = src.DescriptionIndex;
            dst.Make_ID1Index = src.Make_ID1Index;
            dst.ModifyOnIndex = src.ModifyOnIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>(20);
        fieldNames.add("Make_ID");
        fieldNames.add("Make_Name");
        fieldNames.add("Model_ID");
        fieldNames.add("Model_Name");
        fieldNames.add("Variant_ID");
        fieldNames.add("Variant_Name");
        fieldNames.add("Model_ID1");
        fieldNames.add("Cubic_Capacity");
        fieldNames.add("Fuel_ID");
        fieldNames.add("Seating_Capacity");
        fieldNames.add("ExShoroomPrice");
        fieldNames.add("IsActive");
        fieldNames.add("CreatedOn");
        fieldNames.add("Product_Id_New");
        fieldNames.add("Make_Name1");
        fieldNames.add("Model_Name1");
        fieldNames.add("Fuel_Name");
        fieldNames.add("Description");
        fieldNames.add("Make_ID1");
        fieldNames.add("ModifyOn");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    private BikeMasterEntityColumnInfo columnInfo;
    private ProxyState<magicfinmart.datacomp.com.finmartserviceapi.finmart.model.BikeMasterEntity> proxyState;

    BikeMasterEntityRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (BikeMasterEntityColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<magicfinmart.datacomp.com.finmartserviceapi.finmart.model.BikeMasterEntity>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$Make_ID() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.Make_IDIndex);
    }

    @Override
    public void realmSet$Make_ID(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.Make_IDIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.Make_IDIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.Make_IDIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.Make_IDIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$Make_Name() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.Make_NameIndex);
    }

    @Override
    public void realmSet$Make_Name(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.Make_NameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.Make_NameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.Make_NameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.Make_NameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$Model_ID() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.Model_IDIndex);
    }

    @Override
    public void realmSet$Model_ID(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.Model_IDIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.Model_IDIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.Model_IDIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.Model_IDIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$Model_Name() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.Model_NameIndex);
    }

    @Override
    public void realmSet$Model_Name(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.Model_NameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.Model_NameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.Model_NameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.Model_NameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$Variant_ID() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.Variant_IDIndex);
    }

    @Override
    public void realmSet$Variant_ID(String value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'Variant_ID' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$Variant_Name() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.Variant_NameIndex);
    }

    @Override
    public void realmSet$Variant_Name(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.Variant_NameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.Variant_NameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.Variant_NameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.Variant_NameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$Model_ID1() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.Model_ID1Index);
    }

    @Override
    public void realmSet$Model_ID1(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.Model_ID1Index, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.Model_ID1Index, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.Model_ID1Index);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.Model_ID1Index, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$Cubic_Capacity() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.Cubic_CapacityIndex);
    }

    @Override
    public void realmSet$Cubic_Capacity(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.Cubic_CapacityIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.Cubic_CapacityIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.Cubic_CapacityIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.Cubic_CapacityIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$Fuel_ID() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.Fuel_IDIndex);
    }

    @Override
    public void realmSet$Fuel_ID(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.Fuel_IDIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.Fuel_IDIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.Fuel_IDIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.Fuel_IDIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$Seating_Capacity() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.Seating_CapacityIndex);
    }

    @Override
    public void realmSet$Seating_Capacity(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.Seating_CapacityIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.Seating_CapacityIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.Seating_CapacityIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.Seating_CapacityIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$ExShoroomPrice() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.ExShoroomPriceIndex);
    }

    @Override
    public void realmSet$ExShoroomPrice(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.ExShoroomPriceIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.ExShoroomPriceIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.ExShoroomPriceIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.ExShoroomPriceIndex, value);
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
    public String realmGet$CreatedOn() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.CreatedOnIndex);
    }

    @Override
    public void realmSet$CreatedOn(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.CreatedOnIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.CreatedOnIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.CreatedOnIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.CreatedOnIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$Product_Id_New() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.Product_Id_NewIndex);
    }

    @Override
    public void realmSet$Product_Id_New(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.Product_Id_NewIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.Product_Id_NewIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.Product_Id_NewIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.Product_Id_NewIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$Make_Name1() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.Make_Name1Index);
    }

    @Override
    public void realmSet$Make_Name1(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.Make_Name1Index, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.Make_Name1Index, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.Make_Name1Index);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.Make_Name1Index, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$Model_Name1() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.Model_Name1Index);
    }

    @Override
    public void realmSet$Model_Name1(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.Model_Name1Index, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.Model_Name1Index, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.Model_Name1Index);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.Model_Name1Index, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$Fuel_Name() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.Fuel_NameIndex);
    }

    @Override
    public void realmSet$Fuel_Name(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.Fuel_NameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.Fuel_NameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.Fuel_NameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.Fuel_NameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$Description() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.DescriptionIndex);
    }

    @Override
    public void realmSet$Description(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.DescriptionIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.DescriptionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.DescriptionIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.DescriptionIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$Make_ID1() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.Make_ID1Index);
    }

    @Override
    public void realmSet$Make_ID1(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.Make_ID1Index, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.Make_ID1Index, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.Make_ID1Index);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.Make_ID1Index, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$ModifyOn() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.ModifyOnIndex);
    }

    @Override
    public void realmSet$ModifyOn(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.ModifyOnIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.ModifyOnIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.ModifyOnIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.ModifyOnIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("BikeMasterEntity", 20, 0);
        builder.addPersistedProperty("Make_ID", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("Make_Name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("Model_ID", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("Model_Name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("Variant_ID", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("Variant_Name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("Model_ID1", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("Cubic_Capacity", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("Fuel_ID", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("Seating_Capacity", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("ExShoroomPrice", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("IsActive", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("CreatedOn", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("Product_Id_New", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("Make_Name1", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("Model_Name1", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("Fuel_Name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("Description", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("Make_ID1", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("ModifyOn", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static BikeMasterEntityColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new BikeMasterEntityColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "BikeMasterEntity";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static magicfinmart.datacomp.com.finmartserviceapi.finmart.model.BikeMasterEntity createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        magicfinmart.datacomp.com.finmartserviceapi.finmart.model.BikeMasterEntity obj = null;
        if (update) {
            Table table = realm.getTable(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.BikeMasterEntity.class);
            BikeMasterEntityColumnInfo columnInfo = (BikeMasterEntityColumnInfo) realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.BikeMasterEntity.class);
            long pkColumnIndex = columnInfo.Variant_IDIndex;
            long rowIndex = Table.NO_MATCH;
            if (json.isNull("Variant_ID")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("Variant_ID"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.BikeMasterEntity.class), false, Collections.<String> emptyList());
                    obj = new io.realm.BikeMasterEntityRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("Variant_ID")) {
                if (json.isNull("Variant_ID")) {
                    obj = (io.realm.BikeMasterEntityRealmProxy) realm.createObjectInternal(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.BikeMasterEntity.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.BikeMasterEntityRealmProxy) realm.createObjectInternal(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.BikeMasterEntity.class, json.getString("Variant_ID"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'Variant_ID'.");
            }
        }

        final BikeMasterEntityRealmProxyInterface objProxy = (BikeMasterEntityRealmProxyInterface) obj;
        if (json.has("Make_ID")) {
            if (json.isNull("Make_ID")) {
                objProxy.realmSet$Make_ID(null);
            } else {
                objProxy.realmSet$Make_ID((String) json.getString("Make_ID"));
            }
        }
        if (json.has("Make_Name")) {
            if (json.isNull("Make_Name")) {
                objProxy.realmSet$Make_Name(null);
            } else {
                objProxy.realmSet$Make_Name((String) json.getString("Make_Name"));
            }
        }
        if (json.has("Model_ID")) {
            if (json.isNull("Model_ID")) {
                objProxy.realmSet$Model_ID(null);
            } else {
                objProxy.realmSet$Model_ID((String) json.getString("Model_ID"));
            }
        }
        if (json.has("Model_Name")) {
            if (json.isNull("Model_Name")) {
                objProxy.realmSet$Model_Name(null);
            } else {
                objProxy.realmSet$Model_Name((String) json.getString("Model_Name"));
            }
        }
        if (json.has("Variant_Name")) {
            if (json.isNull("Variant_Name")) {
                objProxy.realmSet$Variant_Name(null);
            } else {
                objProxy.realmSet$Variant_Name((String) json.getString("Variant_Name"));
            }
        }
        if (json.has("Model_ID1")) {
            if (json.isNull("Model_ID1")) {
                objProxy.realmSet$Model_ID1(null);
            } else {
                objProxy.realmSet$Model_ID1((String) json.getString("Model_ID1"));
            }
        }
        if (json.has("Cubic_Capacity")) {
            if (json.isNull("Cubic_Capacity")) {
                objProxy.realmSet$Cubic_Capacity(null);
            } else {
                objProxy.realmSet$Cubic_Capacity((String) json.getString("Cubic_Capacity"));
            }
        }
        if (json.has("Fuel_ID")) {
            if (json.isNull("Fuel_ID")) {
                objProxy.realmSet$Fuel_ID(null);
            } else {
                objProxy.realmSet$Fuel_ID((String) json.getString("Fuel_ID"));
            }
        }
        if (json.has("Seating_Capacity")) {
            if (json.isNull("Seating_Capacity")) {
                objProxy.realmSet$Seating_Capacity(null);
            } else {
                objProxy.realmSet$Seating_Capacity((String) json.getString("Seating_Capacity"));
            }
        }
        if (json.has("ExShoroomPrice")) {
            if (json.isNull("ExShoroomPrice")) {
                objProxy.realmSet$ExShoroomPrice(null);
            } else {
                objProxy.realmSet$ExShoroomPrice((String) json.getString("ExShoroomPrice"));
            }
        }
        if (json.has("IsActive")) {
            if (json.isNull("IsActive")) {
                objProxy.realmSet$IsActive(null);
            } else {
                objProxy.realmSet$IsActive((String) json.getString("IsActive"));
            }
        }
        if (json.has("CreatedOn")) {
            if (json.isNull("CreatedOn")) {
                objProxy.realmSet$CreatedOn(null);
            } else {
                objProxy.realmSet$CreatedOn((String) json.getString("CreatedOn"));
            }
        }
        if (json.has("Product_Id_New")) {
            if (json.isNull("Product_Id_New")) {
                objProxy.realmSet$Product_Id_New(null);
            } else {
                objProxy.realmSet$Product_Id_New((String) json.getString("Product_Id_New"));
            }
        }
        if (json.has("Make_Name1")) {
            if (json.isNull("Make_Name1")) {
                objProxy.realmSet$Make_Name1(null);
            } else {
                objProxy.realmSet$Make_Name1((String) json.getString("Make_Name1"));
            }
        }
        if (json.has("Model_Name1")) {
            if (json.isNull("Model_Name1")) {
                objProxy.realmSet$Model_Name1(null);
            } else {
                objProxy.realmSet$Model_Name1((String) json.getString("Model_Name1"));
            }
        }
        if (json.has("Fuel_Name")) {
            if (json.isNull("Fuel_Name")) {
                objProxy.realmSet$Fuel_Name(null);
            } else {
                objProxy.realmSet$Fuel_Name((String) json.getString("Fuel_Name"));
            }
        }
        if (json.has("Description")) {
            if (json.isNull("Description")) {
                objProxy.realmSet$Description(null);
            } else {
                objProxy.realmSet$Description((String) json.getString("Description"));
            }
        }
        if (json.has("Make_ID1")) {
            if (json.isNull("Make_ID1")) {
                objProxy.realmSet$Make_ID1(null);
            } else {
                objProxy.realmSet$Make_ID1((String) json.getString("Make_ID1"));
            }
        }
        if (json.has("ModifyOn")) {
            if (json.isNull("ModifyOn")) {
                objProxy.realmSet$ModifyOn(null);
            } else {
                objProxy.realmSet$ModifyOn((String) json.getString("ModifyOn"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static magicfinmart.datacomp.com.finmartserviceapi.finmart.model.BikeMasterEntity createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final magicfinmart.datacomp.com.finmartserviceapi.finmart.model.BikeMasterEntity obj = new magicfinmart.datacomp.com.finmartserviceapi.finmart.model.BikeMasterEntity();
        final BikeMasterEntityRealmProxyInterface objProxy = (BikeMasterEntityRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("Make_ID")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$Make_ID((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$Make_ID(null);
                }
            } else if (name.equals("Make_Name")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$Make_Name((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$Make_Name(null);
                }
            } else if (name.equals("Model_ID")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$Model_ID((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$Model_ID(null);
                }
            } else if (name.equals("Model_Name")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$Model_Name((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$Model_Name(null);
                }
            } else if (name.equals("Variant_ID")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$Variant_ID((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$Variant_ID(null);
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("Variant_Name")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$Variant_Name((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$Variant_Name(null);
                }
            } else if (name.equals("Model_ID1")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$Model_ID1((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$Model_ID1(null);
                }
            } else if (name.equals("Cubic_Capacity")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$Cubic_Capacity((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$Cubic_Capacity(null);
                }
            } else if (name.equals("Fuel_ID")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$Fuel_ID((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$Fuel_ID(null);
                }
            } else if (name.equals("Seating_Capacity")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$Seating_Capacity((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$Seating_Capacity(null);
                }
            } else if (name.equals("ExShoroomPrice")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$ExShoroomPrice((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$ExShoroomPrice(null);
                }
            } else if (name.equals("IsActive")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$IsActive((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$IsActive(null);
                }
            } else if (name.equals("CreatedOn")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$CreatedOn((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$CreatedOn(null);
                }
            } else if (name.equals("Product_Id_New")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$Product_Id_New((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$Product_Id_New(null);
                }
            } else if (name.equals("Make_Name1")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$Make_Name1((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$Make_Name1(null);
                }
            } else if (name.equals("Model_Name1")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$Model_Name1((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$Model_Name1(null);
                }
            } else if (name.equals("Fuel_Name")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$Fuel_Name((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$Fuel_Name(null);
                }
            } else if (name.equals("Description")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$Description((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$Description(null);
                }
            } else if (name.equals("Make_ID1")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$Make_ID1((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$Make_ID1(null);
                }
            } else if (name.equals("ModifyOn")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$ModifyOn((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$ModifyOn(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'Variant_ID'.");
        }
        return realm.copyToRealm(obj);
    }

    public static magicfinmart.datacomp.com.finmartserviceapi.finmart.model.BikeMasterEntity copyOrUpdate(Realm realm, magicfinmart.datacomp.com.finmartserviceapi.finmart.model.BikeMasterEntity object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.BikeMasterEntity) cachedRealmObject;
        }

        magicfinmart.datacomp.com.finmartserviceapi.finmart.model.BikeMasterEntity realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.BikeMasterEntity.class);
            BikeMasterEntityColumnInfo columnInfo = (BikeMasterEntityColumnInfo) realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.BikeMasterEntity.class);
            long pkColumnIndex = columnInfo.Variant_IDIndex;
            String value = ((BikeMasterEntityRealmProxyInterface) object).realmGet$Variant_ID();
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.BikeMasterEntity.class), false, Collections.<String> emptyList());
                    realmObject = new io.realm.BikeMasterEntityRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, realmObject, object, cache) : copy(realm, object, update, cache);
    }

    public static magicfinmart.datacomp.com.finmartserviceapi.finmart.model.BikeMasterEntity copy(Realm realm, magicfinmart.datacomp.com.finmartserviceapi.finmart.model.BikeMasterEntity newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.BikeMasterEntity) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        magicfinmart.datacomp.com.finmartserviceapi.finmart.model.BikeMasterEntity realmObject = realm.createObjectInternal(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.BikeMasterEntity.class, ((BikeMasterEntityRealmProxyInterface) newObject).realmGet$Variant_ID(), false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        BikeMasterEntityRealmProxyInterface realmObjectSource = (BikeMasterEntityRealmProxyInterface) newObject;
        BikeMasterEntityRealmProxyInterface realmObjectCopy = (BikeMasterEntityRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$Make_ID(realmObjectSource.realmGet$Make_ID());
        realmObjectCopy.realmSet$Make_Name(realmObjectSource.realmGet$Make_Name());
        realmObjectCopy.realmSet$Model_ID(realmObjectSource.realmGet$Model_ID());
        realmObjectCopy.realmSet$Model_Name(realmObjectSource.realmGet$Model_Name());
        realmObjectCopy.realmSet$Variant_Name(realmObjectSource.realmGet$Variant_Name());
        realmObjectCopy.realmSet$Model_ID1(realmObjectSource.realmGet$Model_ID1());
        realmObjectCopy.realmSet$Cubic_Capacity(realmObjectSource.realmGet$Cubic_Capacity());
        realmObjectCopy.realmSet$Fuel_ID(realmObjectSource.realmGet$Fuel_ID());
        realmObjectCopy.realmSet$Seating_Capacity(realmObjectSource.realmGet$Seating_Capacity());
        realmObjectCopy.realmSet$ExShoroomPrice(realmObjectSource.realmGet$ExShoroomPrice());
        realmObjectCopy.realmSet$IsActive(realmObjectSource.realmGet$IsActive());
        realmObjectCopy.realmSet$CreatedOn(realmObjectSource.realmGet$CreatedOn());
        realmObjectCopy.realmSet$Product_Id_New(realmObjectSource.realmGet$Product_Id_New());
        realmObjectCopy.realmSet$Make_Name1(realmObjectSource.realmGet$Make_Name1());
        realmObjectCopy.realmSet$Model_Name1(realmObjectSource.realmGet$Model_Name1());
        realmObjectCopy.realmSet$Fuel_Name(realmObjectSource.realmGet$Fuel_Name());
        realmObjectCopy.realmSet$Description(realmObjectSource.realmGet$Description());
        realmObjectCopy.realmSet$Make_ID1(realmObjectSource.realmGet$Make_ID1());
        realmObjectCopy.realmSet$ModifyOn(realmObjectSource.realmGet$ModifyOn());
        return realmObject;
    }

    public static long insert(Realm realm, magicfinmart.datacomp.com.finmartserviceapi.finmart.model.BikeMasterEntity object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.BikeMasterEntity.class);
        long tableNativePtr = table.getNativePtr();
        BikeMasterEntityColumnInfo columnInfo = (BikeMasterEntityColumnInfo) realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.BikeMasterEntity.class);
        long pkColumnIndex = columnInfo.Variant_IDIndex;
        String primaryKeyValue = ((BikeMasterEntityRealmProxyInterface) object).realmGet$Variant_ID();
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
        String realmGet$Make_ID = ((BikeMasterEntityRealmProxyInterface) object).realmGet$Make_ID();
        if (realmGet$Make_ID != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.Make_IDIndex, rowIndex, realmGet$Make_ID, false);
        }
        String realmGet$Make_Name = ((BikeMasterEntityRealmProxyInterface) object).realmGet$Make_Name();
        if (realmGet$Make_Name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.Make_NameIndex, rowIndex, realmGet$Make_Name, false);
        }
        String realmGet$Model_ID = ((BikeMasterEntityRealmProxyInterface) object).realmGet$Model_ID();
        if (realmGet$Model_ID != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.Model_IDIndex, rowIndex, realmGet$Model_ID, false);
        }
        String realmGet$Model_Name = ((BikeMasterEntityRealmProxyInterface) object).realmGet$Model_Name();
        if (realmGet$Model_Name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.Model_NameIndex, rowIndex, realmGet$Model_Name, false);
        }
        String realmGet$Variant_Name = ((BikeMasterEntityRealmProxyInterface) object).realmGet$Variant_Name();
        if (realmGet$Variant_Name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.Variant_NameIndex, rowIndex, realmGet$Variant_Name, false);
        }
        String realmGet$Model_ID1 = ((BikeMasterEntityRealmProxyInterface) object).realmGet$Model_ID1();
        if (realmGet$Model_ID1 != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.Model_ID1Index, rowIndex, realmGet$Model_ID1, false);
        }
        String realmGet$Cubic_Capacity = ((BikeMasterEntityRealmProxyInterface) object).realmGet$Cubic_Capacity();
        if (realmGet$Cubic_Capacity != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.Cubic_CapacityIndex, rowIndex, realmGet$Cubic_Capacity, false);
        }
        String realmGet$Fuel_ID = ((BikeMasterEntityRealmProxyInterface) object).realmGet$Fuel_ID();
        if (realmGet$Fuel_ID != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.Fuel_IDIndex, rowIndex, realmGet$Fuel_ID, false);
        }
        String realmGet$Seating_Capacity = ((BikeMasterEntityRealmProxyInterface) object).realmGet$Seating_Capacity();
        if (realmGet$Seating_Capacity != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.Seating_CapacityIndex, rowIndex, realmGet$Seating_Capacity, false);
        }
        String realmGet$ExShoroomPrice = ((BikeMasterEntityRealmProxyInterface) object).realmGet$ExShoroomPrice();
        if (realmGet$ExShoroomPrice != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.ExShoroomPriceIndex, rowIndex, realmGet$ExShoroomPrice, false);
        }
        String realmGet$IsActive = ((BikeMasterEntityRealmProxyInterface) object).realmGet$IsActive();
        if (realmGet$IsActive != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.IsActiveIndex, rowIndex, realmGet$IsActive, false);
        }
        String realmGet$CreatedOn = ((BikeMasterEntityRealmProxyInterface) object).realmGet$CreatedOn();
        if (realmGet$CreatedOn != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.CreatedOnIndex, rowIndex, realmGet$CreatedOn, false);
        }
        String realmGet$Product_Id_New = ((BikeMasterEntityRealmProxyInterface) object).realmGet$Product_Id_New();
        if (realmGet$Product_Id_New != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.Product_Id_NewIndex, rowIndex, realmGet$Product_Id_New, false);
        }
        String realmGet$Make_Name1 = ((BikeMasterEntityRealmProxyInterface) object).realmGet$Make_Name1();
        if (realmGet$Make_Name1 != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.Make_Name1Index, rowIndex, realmGet$Make_Name1, false);
        }
        String realmGet$Model_Name1 = ((BikeMasterEntityRealmProxyInterface) object).realmGet$Model_Name1();
        if (realmGet$Model_Name1 != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.Model_Name1Index, rowIndex, realmGet$Model_Name1, false);
        }
        String realmGet$Fuel_Name = ((BikeMasterEntityRealmProxyInterface) object).realmGet$Fuel_Name();
        if (realmGet$Fuel_Name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.Fuel_NameIndex, rowIndex, realmGet$Fuel_Name, false);
        }
        String realmGet$Description = ((BikeMasterEntityRealmProxyInterface) object).realmGet$Description();
        if (realmGet$Description != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.DescriptionIndex, rowIndex, realmGet$Description, false);
        }
        String realmGet$Make_ID1 = ((BikeMasterEntityRealmProxyInterface) object).realmGet$Make_ID1();
        if (realmGet$Make_ID1 != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.Make_ID1Index, rowIndex, realmGet$Make_ID1, false);
        }
        String realmGet$ModifyOn = ((BikeMasterEntityRealmProxyInterface) object).realmGet$ModifyOn();
        if (realmGet$ModifyOn != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.ModifyOnIndex, rowIndex, realmGet$ModifyOn, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.BikeMasterEntity.class);
        long tableNativePtr = table.getNativePtr();
        BikeMasterEntityColumnInfo columnInfo = (BikeMasterEntityColumnInfo) realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.BikeMasterEntity.class);
        long pkColumnIndex = columnInfo.Variant_IDIndex;
        magicfinmart.datacomp.com.finmartserviceapi.finmart.model.BikeMasterEntity object = null;
        while (objects.hasNext()) {
            object = (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.BikeMasterEntity) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((BikeMasterEntityRealmProxyInterface) object).realmGet$Variant_ID();
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
            String realmGet$Make_ID = ((BikeMasterEntityRealmProxyInterface) object).realmGet$Make_ID();
            if (realmGet$Make_ID != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.Make_IDIndex, rowIndex, realmGet$Make_ID, false);
            }
            String realmGet$Make_Name = ((BikeMasterEntityRealmProxyInterface) object).realmGet$Make_Name();
            if (realmGet$Make_Name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.Make_NameIndex, rowIndex, realmGet$Make_Name, false);
            }
            String realmGet$Model_ID = ((BikeMasterEntityRealmProxyInterface) object).realmGet$Model_ID();
            if (realmGet$Model_ID != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.Model_IDIndex, rowIndex, realmGet$Model_ID, false);
            }
            String realmGet$Model_Name = ((BikeMasterEntityRealmProxyInterface) object).realmGet$Model_Name();
            if (realmGet$Model_Name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.Model_NameIndex, rowIndex, realmGet$Model_Name, false);
            }
            String realmGet$Variant_Name = ((BikeMasterEntityRealmProxyInterface) object).realmGet$Variant_Name();
            if (realmGet$Variant_Name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.Variant_NameIndex, rowIndex, realmGet$Variant_Name, false);
            }
            String realmGet$Model_ID1 = ((BikeMasterEntityRealmProxyInterface) object).realmGet$Model_ID1();
            if (realmGet$Model_ID1 != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.Model_ID1Index, rowIndex, realmGet$Model_ID1, false);
            }
            String realmGet$Cubic_Capacity = ((BikeMasterEntityRealmProxyInterface) object).realmGet$Cubic_Capacity();
            if (realmGet$Cubic_Capacity != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.Cubic_CapacityIndex, rowIndex, realmGet$Cubic_Capacity, false);
            }
            String realmGet$Fuel_ID = ((BikeMasterEntityRealmProxyInterface) object).realmGet$Fuel_ID();
            if (realmGet$Fuel_ID != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.Fuel_IDIndex, rowIndex, realmGet$Fuel_ID, false);
            }
            String realmGet$Seating_Capacity = ((BikeMasterEntityRealmProxyInterface) object).realmGet$Seating_Capacity();
            if (realmGet$Seating_Capacity != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.Seating_CapacityIndex, rowIndex, realmGet$Seating_Capacity, false);
            }
            String realmGet$ExShoroomPrice = ((BikeMasterEntityRealmProxyInterface) object).realmGet$ExShoroomPrice();
            if (realmGet$ExShoroomPrice != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.ExShoroomPriceIndex, rowIndex, realmGet$ExShoroomPrice, false);
            }
            String realmGet$IsActive = ((BikeMasterEntityRealmProxyInterface) object).realmGet$IsActive();
            if (realmGet$IsActive != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.IsActiveIndex, rowIndex, realmGet$IsActive, false);
            }
            String realmGet$CreatedOn = ((BikeMasterEntityRealmProxyInterface) object).realmGet$CreatedOn();
            if (realmGet$CreatedOn != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.CreatedOnIndex, rowIndex, realmGet$CreatedOn, false);
            }
            String realmGet$Product_Id_New = ((BikeMasterEntityRealmProxyInterface) object).realmGet$Product_Id_New();
            if (realmGet$Product_Id_New != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.Product_Id_NewIndex, rowIndex, realmGet$Product_Id_New, false);
            }
            String realmGet$Make_Name1 = ((BikeMasterEntityRealmProxyInterface) object).realmGet$Make_Name1();
            if (realmGet$Make_Name1 != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.Make_Name1Index, rowIndex, realmGet$Make_Name1, false);
            }
            String realmGet$Model_Name1 = ((BikeMasterEntityRealmProxyInterface) object).realmGet$Model_Name1();
            if (realmGet$Model_Name1 != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.Model_Name1Index, rowIndex, realmGet$Model_Name1, false);
            }
            String realmGet$Fuel_Name = ((BikeMasterEntityRealmProxyInterface) object).realmGet$Fuel_Name();
            if (realmGet$Fuel_Name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.Fuel_NameIndex, rowIndex, realmGet$Fuel_Name, false);
            }
            String realmGet$Description = ((BikeMasterEntityRealmProxyInterface) object).realmGet$Description();
            if (realmGet$Description != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.DescriptionIndex, rowIndex, realmGet$Description, false);
            }
            String realmGet$Make_ID1 = ((BikeMasterEntityRealmProxyInterface) object).realmGet$Make_ID1();
            if (realmGet$Make_ID1 != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.Make_ID1Index, rowIndex, realmGet$Make_ID1, false);
            }
            String realmGet$ModifyOn = ((BikeMasterEntityRealmProxyInterface) object).realmGet$ModifyOn();
            if (realmGet$ModifyOn != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.ModifyOnIndex, rowIndex, realmGet$ModifyOn, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, magicfinmart.datacomp.com.finmartserviceapi.finmart.model.BikeMasterEntity object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.BikeMasterEntity.class);
        long tableNativePtr = table.getNativePtr();
        BikeMasterEntityColumnInfo columnInfo = (BikeMasterEntityColumnInfo) realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.BikeMasterEntity.class);
        long pkColumnIndex = columnInfo.Variant_IDIndex;
        String primaryKeyValue = ((BikeMasterEntityRealmProxyInterface) object).realmGet$Variant_ID();
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
        String realmGet$Make_ID = ((BikeMasterEntityRealmProxyInterface) object).realmGet$Make_ID();
        if (realmGet$Make_ID != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.Make_IDIndex, rowIndex, realmGet$Make_ID, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.Make_IDIndex, rowIndex, false);
        }
        String realmGet$Make_Name = ((BikeMasterEntityRealmProxyInterface) object).realmGet$Make_Name();
        if (realmGet$Make_Name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.Make_NameIndex, rowIndex, realmGet$Make_Name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.Make_NameIndex, rowIndex, false);
        }
        String realmGet$Model_ID = ((BikeMasterEntityRealmProxyInterface) object).realmGet$Model_ID();
        if (realmGet$Model_ID != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.Model_IDIndex, rowIndex, realmGet$Model_ID, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.Model_IDIndex, rowIndex, false);
        }
        String realmGet$Model_Name = ((BikeMasterEntityRealmProxyInterface) object).realmGet$Model_Name();
        if (realmGet$Model_Name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.Model_NameIndex, rowIndex, realmGet$Model_Name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.Model_NameIndex, rowIndex, false);
        }
        String realmGet$Variant_Name = ((BikeMasterEntityRealmProxyInterface) object).realmGet$Variant_Name();
        if (realmGet$Variant_Name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.Variant_NameIndex, rowIndex, realmGet$Variant_Name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.Variant_NameIndex, rowIndex, false);
        }
        String realmGet$Model_ID1 = ((BikeMasterEntityRealmProxyInterface) object).realmGet$Model_ID1();
        if (realmGet$Model_ID1 != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.Model_ID1Index, rowIndex, realmGet$Model_ID1, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.Model_ID1Index, rowIndex, false);
        }
        String realmGet$Cubic_Capacity = ((BikeMasterEntityRealmProxyInterface) object).realmGet$Cubic_Capacity();
        if (realmGet$Cubic_Capacity != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.Cubic_CapacityIndex, rowIndex, realmGet$Cubic_Capacity, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.Cubic_CapacityIndex, rowIndex, false);
        }
        String realmGet$Fuel_ID = ((BikeMasterEntityRealmProxyInterface) object).realmGet$Fuel_ID();
        if (realmGet$Fuel_ID != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.Fuel_IDIndex, rowIndex, realmGet$Fuel_ID, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.Fuel_IDIndex, rowIndex, false);
        }
        String realmGet$Seating_Capacity = ((BikeMasterEntityRealmProxyInterface) object).realmGet$Seating_Capacity();
        if (realmGet$Seating_Capacity != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.Seating_CapacityIndex, rowIndex, realmGet$Seating_Capacity, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.Seating_CapacityIndex, rowIndex, false);
        }
        String realmGet$ExShoroomPrice = ((BikeMasterEntityRealmProxyInterface) object).realmGet$ExShoroomPrice();
        if (realmGet$ExShoroomPrice != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.ExShoroomPriceIndex, rowIndex, realmGet$ExShoroomPrice, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.ExShoroomPriceIndex, rowIndex, false);
        }
        String realmGet$IsActive = ((BikeMasterEntityRealmProxyInterface) object).realmGet$IsActive();
        if (realmGet$IsActive != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.IsActiveIndex, rowIndex, realmGet$IsActive, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.IsActiveIndex, rowIndex, false);
        }
        String realmGet$CreatedOn = ((BikeMasterEntityRealmProxyInterface) object).realmGet$CreatedOn();
        if (realmGet$CreatedOn != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.CreatedOnIndex, rowIndex, realmGet$CreatedOn, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.CreatedOnIndex, rowIndex, false);
        }
        String realmGet$Product_Id_New = ((BikeMasterEntityRealmProxyInterface) object).realmGet$Product_Id_New();
        if (realmGet$Product_Id_New != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.Product_Id_NewIndex, rowIndex, realmGet$Product_Id_New, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.Product_Id_NewIndex, rowIndex, false);
        }
        String realmGet$Make_Name1 = ((BikeMasterEntityRealmProxyInterface) object).realmGet$Make_Name1();
        if (realmGet$Make_Name1 != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.Make_Name1Index, rowIndex, realmGet$Make_Name1, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.Make_Name1Index, rowIndex, false);
        }
        String realmGet$Model_Name1 = ((BikeMasterEntityRealmProxyInterface) object).realmGet$Model_Name1();
        if (realmGet$Model_Name1 != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.Model_Name1Index, rowIndex, realmGet$Model_Name1, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.Model_Name1Index, rowIndex, false);
        }
        String realmGet$Fuel_Name = ((BikeMasterEntityRealmProxyInterface) object).realmGet$Fuel_Name();
        if (realmGet$Fuel_Name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.Fuel_NameIndex, rowIndex, realmGet$Fuel_Name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.Fuel_NameIndex, rowIndex, false);
        }
        String realmGet$Description = ((BikeMasterEntityRealmProxyInterface) object).realmGet$Description();
        if (realmGet$Description != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.DescriptionIndex, rowIndex, realmGet$Description, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.DescriptionIndex, rowIndex, false);
        }
        String realmGet$Make_ID1 = ((BikeMasterEntityRealmProxyInterface) object).realmGet$Make_ID1();
        if (realmGet$Make_ID1 != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.Make_ID1Index, rowIndex, realmGet$Make_ID1, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.Make_ID1Index, rowIndex, false);
        }
        String realmGet$ModifyOn = ((BikeMasterEntityRealmProxyInterface) object).realmGet$ModifyOn();
        if (realmGet$ModifyOn != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.ModifyOnIndex, rowIndex, realmGet$ModifyOn, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.ModifyOnIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.BikeMasterEntity.class);
        long tableNativePtr = table.getNativePtr();
        BikeMasterEntityColumnInfo columnInfo = (BikeMasterEntityColumnInfo) realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.BikeMasterEntity.class);
        long pkColumnIndex = columnInfo.Variant_IDIndex;
        magicfinmart.datacomp.com.finmartserviceapi.finmart.model.BikeMasterEntity object = null;
        while (objects.hasNext()) {
            object = (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.BikeMasterEntity) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((BikeMasterEntityRealmProxyInterface) object).realmGet$Variant_ID();
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
            String realmGet$Make_ID = ((BikeMasterEntityRealmProxyInterface) object).realmGet$Make_ID();
            if (realmGet$Make_ID != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.Make_IDIndex, rowIndex, realmGet$Make_ID, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.Make_IDIndex, rowIndex, false);
            }
            String realmGet$Make_Name = ((BikeMasterEntityRealmProxyInterface) object).realmGet$Make_Name();
            if (realmGet$Make_Name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.Make_NameIndex, rowIndex, realmGet$Make_Name, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.Make_NameIndex, rowIndex, false);
            }
            String realmGet$Model_ID = ((BikeMasterEntityRealmProxyInterface) object).realmGet$Model_ID();
            if (realmGet$Model_ID != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.Model_IDIndex, rowIndex, realmGet$Model_ID, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.Model_IDIndex, rowIndex, false);
            }
            String realmGet$Model_Name = ((BikeMasterEntityRealmProxyInterface) object).realmGet$Model_Name();
            if (realmGet$Model_Name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.Model_NameIndex, rowIndex, realmGet$Model_Name, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.Model_NameIndex, rowIndex, false);
            }
            String realmGet$Variant_Name = ((BikeMasterEntityRealmProxyInterface) object).realmGet$Variant_Name();
            if (realmGet$Variant_Name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.Variant_NameIndex, rowIndex, realmGet$Variant_Name, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.Variant_NameIndex, rowIndex, false);
            }
            String realmGet$Model_ID1 = ((BikeMasterEntityRealmProxyInterface) object).realmGet$Model_ID1();
            if (realmGet$Model_ID1 != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.Model_ID1Index, rowIndex, realmGet$Model_ID1, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.Model_ID1Index, rowIndex, false);
            }
            String realmGet$Cubic_Capacity = ((BikeMasterEntityRealmProxyInterface) object).realmGet$Cubic_Capacity();
            if (realmGet$Cubic_Capacity != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.Cubic_CapacityIndex, rowIndex, realmGet$Cubic_Capacity, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.Cubic_CapacityIndex, rowIndex, false);
            }
            String realmGet$Fuel_ID = ((BikeMasterEntityRealmProxyInterface) object).realmGet$Fuel_ID();
            if (realmGet$Fuel_ID != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.Fuel_IDIndex, rowIndex, realmGet$Fuel_ID, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.Fuel_IDIndex, rowIndex, false);
            }
            String realmGet$Seating_Capacity = ((BikeMasterEntityRealmProxyInterface) object).realmGet$Seating_Capacity();
            if (realmGet$Seating_Capacity != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.Seating_CapacityIndex, rowIndex, realmGet$Seating_Capacity, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.Seating_CapacityIndex, rowIndex, false);
            }
            String realmGet$ExShoroomPrice = ((BikeMasterEntityRealmProxyInterface) object).realmGet$ExShoroomPrice();
            if (realmGet$ExShoroomPrice != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.ExShoroomPriceIndex, rowIndex, realmGet$ExShoroomPrice, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.ExShoroomPriceIndex, rowIndex, false);
            }
            String realmGet$IsActive = ((BikeMasterEntityRealmProxyInterface) object).realmGet$IsActive();
            if (realmGet$IsActive != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.IsActiveIndex, rowIndex, realmGet$IsActive, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.IsActiveIndex, rowIndex, false);
            }
            String realmGet$CreatedOn = ((BikeMasterEntityRealmProxyInterface) object).realmGet$CreatedOn();
            if (realmGet$CreatedOn != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.CreatedOnIndex, rowIndex, realmGet$CreatedOn, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.CreatedOnIndex, rowIndex, false);
            }
            String realmGet$Product_Id_New = ((BikeMasterEntityRealmProxyInterface) object).realmGet$Product_Id_New();
            if (realmGet$Product_Id_New != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.Product_Id_NewIndex, rowIndex, realmGet$Product_Id_New, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.Product_Id_NewIndex, rowIndex, false);
            }
            String realmGet$Make_Name1 = ((BikeMasterEntityRealmProxyInterface) object).realmGet$Make_Name1();
            if (realmGet$Make_Name1 != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.Make_Name1Index, rowIndex, realmGet$Make_Name1, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.Make_Name1Index, rowIndex, false);
            }
            String realmGet$Model_Name1 = ((BikeMasterEntityRealmProxyInterface) object).realmGet$Model_Name1();
            if (realmGet$Model_Name1 != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.Model_Name1Index, rowIndex, realmGet$Model_Name1, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.Model_Name1Index, rowIndex, false);
            }
            String realmGet$Fuel_Name = ((BikeMasterEntityRealmProxyInterface) object).realmGet$Fuel_Name();
            if (realmGet$Fuel_Name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.Fuel_NameIndex, rowIndex, realmGet$Fuel_Name, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.Fuel_NameIndex, rowIndex, false);
            }
            String realmGet$Description = ((BikeMasterEntityRealmProxyInterface) object).realmGet$Description();
            if (realmGet$Description != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.DescriptionIndex, rowIndex, realmGet$Description, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.DescriptionIndex, rowIndex, false);
            }
            String realmGet$Make_ID1 = ((BikeMasterEntityRealmProxyInterface) object).realmGet$Make_ID1();
            if (realmGet$Make_ID1 != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.Make_ID1Index, rowIndex, realmGet$Make_ID1, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.Make_ID1Index, rowIndex, false);
            }
            String realmGet$ModifyOn = ((BikeMasterEntityRealmProxyInterface) object).realmGet$ModifyOn();
            if (realmGet$ModifyOn != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.ModifyOnIndex, rowIndex, realmGet$ModifyOn, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.ModifyOnIndex, rowIndex, false);
            }
        }
    }

    public static magicfinmart.datacomp.com.finmartserviceapi.finmart.model.BikeMasterEntity createDetachedCopy(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.BikeMasterEntity realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        magicfinmart.datacomp.com.finmartserviceapi.finmart.model.BikeMasterEntity unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new magicfinmart.datacomp.com.finmartserviceapi.finmart.model.BikeMasterEntity();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.BikeMasterEntity) cachedObject.object;
            }
            unmanagedObject = (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.BikeMasterEntity) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        BikeMasterEntityRealmProxyInterface unmanagedCopy = (BikeMasterEntityRealmProxyInterface) unmanagedObject;
        BikeMasterEntityRealmProxyInterface realmSource = (BikeMasterEntityRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$Make_ID(realmSource.realmGet$Make_ID());
        unmanagedCopy.realmSet$Make_Name(realmSource.realmGet$Make_Name());
        unmanagedCopy.realmSet$Model_ID(realmSource.realmGet$Model_ID());
        unmanagedCopy.realmSet$Model_Name(realmSource.realmGet$Model_Name());
        unmanagedCopy.realmSet$Variant_ID(realmSource.realmGet$Variant_ID());
        unmanagedCopy.realmSet$Variant_Name(realmSource.realmGet$Variant_Name());
        unmanagedCopy.realmSet$Model_ID1(realmSource.realmGet$Model_ID1());
        unmanagedCopy.realmSet$Cubic_Capacity(realmSource.realmGet$Cubic_Capacity());
        unmanagedCopy.realmSet$Fuel_ID(realmSource.realmGet$Fuel_ID());
        unmanagedCopy.realmSet$Seating_Capacity(realmSource.realmGet$Seating_Capacity());
        unmanagedCopy.realmSet$ExShoroomPrice(realmSource.realmGet$ExShoroomPrice());
        unmanagedCopy.realmSet$IsActive(realmSource.realmGet$IsActive());
        unmanagedCopy.realmSet$CreatedOn(realmSource.realmGet$CreatedOn());
        unmanagedCopy.realmSet$Product_Id_New(realmSource.realmGet$Product_Id_New());
        unmanagedCopy.realmSet$Make_Name1(realmSource.realmGet$Make_Name1());
        unmanagedCopy.realmSet$Model_Name1(realmSource.realmGet$Model_Name1());
        unmanagedCopy.realmSet$Fuel_Name(realmSource.realmGet$Fuel_Name());
        unmanagedCopy.realmSet$Description(realmSource.realmGet$Description());
        unmanagedCopy.realmSet$Make_ID1(realmSource.realmGet$Make_ID1());
        unmanagedCopy.realmSet$ModifyOn(realmSource.realmGet$ModifyOn());

        return unmanagedObject;
    }

    static magicfinmart.datacomp.com.finmartserviceapi.finmart.model.BikeMasterEntity update(Realm realm, magicfinmart.datacomp.com.finmartserviceapi.finmart.model.BikeMasterEntity realmObject, magicfinmart.datacomp.com.finmartserviceapi.finmart.model.BikeMasterEntity newObject, Map<RealmModel, RealmObjectProxy> cache) {
        BikeMasterEntityRealmProxyInterface realmObjectTarget = (BikeMasterEntityRealmProxyInterface) realmObject;
        BikeMasterEntityRealmProxyInterface realmObjectSource = (BikeMasterEntityRealmProxyInterface) newObject;
        realmObjectTarget.realmSet$Make_ID(realmObjectSource.realmGet$Make_ID());
        realmObjectTarget.realmSet$Make_Name(realmObjectSource.realmGet$Make_Name());
        realmObjectTarget.realmSet$Model_ID(realmObjectSource.realmGet$Model_ID());
        realmObjectTarget.realmSet$Model_Name(realmObjectSource.realmGet$Model_Name());
        realmObjectTarget.realmSet$Variant_Name(realmObjectSource.realmGet$Variant_Name());
        realmObjectTarget.realmSet$Model_ID1(realmObjectSource.realmGet$Model_ID1());
        realmObjectTarget.realmSet$Cubic_Capacity(realmObjectSource.realmGet$Cubic_Capacity());
        realmObjectTarget.realmSet$Fuel_ID(realmObjectSource.realmGet$Fuel_ID());
        realmObjectTarget.realmSet$Seating_Capacity(realmObjectSource.realmGet$Seating_Capacity());
        realmObjectTarget.realmSet$ExShoroomPrice(realmObjectSource.realmGet$ExShoroomPrice());
        realmObjectTarget.realmSet$IsActive(realmObjectSource.realmGet$IsActive());
        realmObjectTarget.realmSet$CreatedOn(realmObjectSource.realmGet$CreatedOn());
        realmObjectTarget.realmSet$Product_Id_New(realmObjectSource.realmGet$Product_Id_New());
        realmObjectTarget.realmSet$Make_Name1(realmObjectSource.realmGet$Make_Name1());
        realmObjectTarget.realmSet$Model_Name1(realmObjectSource.realmGet$Model_Name1());
        realmObjectTarget.realmSet$Fuel_Name(realmObjectSource.realmGet$Fuel_Name());
        realmObjectTarget.realmSet$Description(realmObjectSource.realmGet$Description());
        realmObjectTarget.realmSet$Make_ID1(realmObjectSource.realmGet$Make_ID1());
        realmObjectTarget.realmSet$ModifyOn(realmObjectSource.realmGet$ModifyOn());
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("BikeMasterEntity = proxy[");
        stringBuilder.append("{Make_ID:");
        stringBuilder.append(realmGet$Make_ID() != null ? realmGet$Make_ID() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{Make_Name:");
        stringBuilder.append(realmGet$Make_Name() != null ? realmGet$Make_Name() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{Model_ID:");
        stringBuilder.append(realmGet$Model_ID() != null ? realmGet$Model_ID() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{Model_Name:");
        stringBuilder.append(realmGet$Model_Name() != null ? realmGet$Model_Name() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{Variant_ID:");
        stringBuilder.append(realmGet$Variant_ID() != null ? realmGet$Variant_ID() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{Variant_Name:");
        stringBuilder.append(realmGet$Variant_Name() != null ? realmGet$Variant_Name() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{Model_ID1:");
        stringBuilder.append(realmGet$Model_ID1() != null ? realmGet$Model_ID1() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{Cubic_Capacity:");
        stringBuilder.append(realmGet$Cubic_Capacity() != null ? realmGet$Cubic_Capacity() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{Fuel_ID:");
        stringBuilder.append(realmGet$Fuel_ID() != null ? realmGet$Fuel_ID() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{Seating_Capacity:");
        stringBuilder.append(realmGet$Seating_Capacity() != null ? realmGet$Seating_Capacity() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{ExShoroomPrice:");
        stringBuilder.append(realmGet$ExShoroomPrice() != null ? realmGet$ExShoroomPrice() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{IsActive:");
        stringBuilder.append(realmGet$IsActive() != null ? realmGet$IsActive() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{CreatedOn:");
        stringBuilder.append(realmGet$CreatedOn() != null ? realmGet$CreatedOn() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{Product_Id_New:");
        stringBuilder.append(realmGet$Product_Id_New() != null ? realmGet$Product_Id_New() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{Make_Name1:");
        stringBuilder.append(realmGet$Make_Name1() != null ? realmGet$Make_Name1() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{Model_Name1:");
        stringBuilder.append(realmGet$Model_Name1() != null ? realmGet$Model_Name1() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{Fuel_Name:");
        stringBuilder.append(realmGet$Fuel_Name() != null ? realmGet$Fuel_Name() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{Description:");
        stringBuilder.append(realmGet$Description() != null ? realmGet$Description() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{Make_ID1:");
        stringBuilder.append(realmGet$Make_ID1() != null ? realmGet$Make_ID1() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{ModifyOn:");
        stringBuilder.append(realmGet$ModifyOn() != null ? realmGet$ModifyOn() : "null");
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
        BikeMasterEntityRealmProxy aBikeMasterEntity = (BikeMasterEntityRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aBikeMasterEntity.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aBikeMasterEntity.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aBikeMasterEntity.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
