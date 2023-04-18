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
public class LoginResponseEntityRealmProxy extends magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity
    implements RealmObjectProxy, LoginResponseEntityRealmProxyInterface {

    static final class LoginResponseEntityColumnInfo extends ColumnInfo {
        long FBAIdIndex;
        long FullNameIndex;
        long UserNameIndex;
        long EmailIDIndex;
        long MobiNumb1Index;
        long LiveURLIndex;
        long LastloginDateIndex;
        long ValidfromIndex;
        long RewardPointIndex;
        long IsFirstLoginIndex;
        long IsDemoIndex;
        long FSMFullnameIndex;
        long FSMEmailIndex;
        long FSMMobileIndex;
        long FBACodeIndex;
        long DesignationIndex;
        long ProfPictNameIndex;
        long FSMDesigIndex;
        long RegMACAddrIndex;
        long SuppMobiNumbIndex;
        long SuppEmailIdIndex;
        long FBAStatusIndex;
        long POSPStatusIndex;
        long UserTypeIndex;
        long SuppAgenIdIndex;
        long EditEmailIdIndex;
        long EditMobiNumbIndex;
        long EditDesigIndex;
        long EditProfPictNameIndex;
        long LoanIdIndex;
        long PayStatusIndex;
        long CustIDIndex;
        long PaymentUrlIndex;
        long IsFocIndex;
        long POSPNameIndex;
        long POSEmailIndex;
        long POSPMobileIndex;
        long SuccessStatusIndex;
        long POSPInfoIndex;
        long FSMIndex;
        long rm_idIndex;
        long referraidIndex;
        long POSPNoIndex;
        long POSPProfileUrlIndex;
        long FBAProfileUrlIndex;
        long referer_codeIndex;
        long IsUidLoginIndex;

        LoginResponseEntityColumnInfo(OsSchemaInfo schemaInfo) {
            super(47);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("LoginResponseEntity");
            this.FBAIdIndex = addColumnDetails("FBAId", objectSchemaInfo);
            this.FullNameIndex = addColumnDetails("FullName", objectSchemaInfo);
            this.UserNameIndex = addColumnDetails("UserName", objectSchemaInfo);
            this.EmailIDIndex = addColumnDetails("EmailID", objectSchemaInfo);
            this.MobiNumb1Index = addColumnDetails("MobiNumb1", objectSchemaInfo);
            this.LiveURLIndex = addColumnDetails("LiveURL", objectSchemaInfo);
            this.LastloginDateIndex = addColumnDetails("LastloginDate", objectSchemaInfo);
            this.ValidfromIndex = addColumnDetails("Validfrom", objectSchemaInfo);
            this.RewardPointIndex = addColumnDetails("RewardPoint", objectSchemaInfo);
            this.IsFirstLoginIndex = addColumnDetails("IsFirstLogin", objectSchemaInfo);
            this.IsDemoIndex = addColumnDetails("IsDemo", objectSchemaInfo);
            this.FSMFullnameIndex = addColumnDetails("FSMFullname", objectSchemaInfo);
            this.FSMEmailIndex = addColumnDetails("FSMEmail", objectSchemaInfo);
            this.FSMMobileIndex = addColumnDetails("FSMMobile", objectSchemaInfo);
            this.FBACodeIndex = addColumnDetails("FBACode", objectSchemaInfo);
            this.DesignationIndex = addColumnDetails("Designation", objectSchemaInfo);
            this.ProfPictNameIndex = addColumnDetails("ProfPictName", objectSchemaInfo);
            this.FSMDesigIndex = addColumnDetails("FSMDesig", objectSchemaInfo);
            this.RegMACAddrIndex = addColumnDetails("RegMACAddr", objectSchemaInfo);
            this.SuppMobiNumbIndex = addColumnDetails("SuppMobiNumb", objectSchemaInfo);
            this.SuppEmailIdIndex = addColumnDetails("SuppEmailId", objectSchemaInfo);
            this.FBAStatusIndex = addColumnDetails("FBAStatus", objectSchemaInfo);
            this.POSPStatusIndex = addColumnDetails("POSPStatus", objectSchemaInfo);
            this.UserTypeIndex = addColumnDetails("UserType", objectSchemaInfo);
            this.SuppAgenIdIndex = addColumnDetails("SuppAgenId", objectSchemaInfo);
            this.EditEmailIdIndex = addColumnDetails("EditEmailId", objectSchemaInfo);
            this.EditMobiNumbIndex = addColumnDetails("EditMobiNumb", objectSchemaInfo);
            this.EditDesigIndex = addColumnDetails("EditDesig", objectSchemaInfo);
            this.EditProfPictNameIndex = addColumnDetails("EditProfPictName", objectSchemaInfo);
            this.LoanIdIndex = addColumnDetails("LoanId", objectSchemaInfo);
            this.PayStatusIndex = addColumnDetails("PayStatus", objectSchemaInfo);
            this.CustIDIndex = addColumnDetails("CustID", objectSchemaInfo);
            this.PaymentUrlIndex = addColumnDetails("PaymentUrl", objectSchemaInfo);
            this.IsFocIndex = addColumnDetails("IsFoc", objectSchemaInfo);
            this.POSPNameIndex = addColumnDetails("POSPName", objectSchemaInfo);
            this.POSEmailIndex = addColumnDetails("POSEmail", objectSchemaInfo);
            this.POSPMobileIndex = addColumnDetails("POSPMobile", objectSchemaInfo);
            this.SuccessStatusIndex = addColumnDetails("SuccessStatus", objectSchemaInfo);
            this.POSPInfoIndex = addColumnDetails("POSPInfo", objectSchemaInfo);
            this.FSMIndex = addColumnDetails("FSM", objectSchemaInfo);
            this.rm_idIndex = addColumnDetails("rm_id", objectSchemaInfo);
            this.referraidIndex = addColumnDetails("referraid", objectSchemaInfo);
            this.POSPNoIndex = addColumnDetails("POSPNo", objectSchemaInfo);
            this.POSPProfileUrlIndex = addColumnDetails("POSPProfileUrl", objectSchemaInfo);
            this.FBAProfileUrlIndex = addColumnDetails("FBAProfileUrl", objectSchemaInfo);
            this.referer_codeIndex = addColumnDetails("referer_code", objectSchemaInfo);
            this.IsUidLoginIndex = addColumnDetails("IsUidLogin", objectSchemaInfo);
        }

        LoginResponseEntityColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new LoginResponseEntityColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final LoginResponseEntityColumnInfo src = (LoginResponseEntityColumnInfo) rawSrc;
            final LoginResponseEntityColumnInfo dst = (LoginResponseEntityColumnInfo) rawDst;
            dst.FBAIdIndex = src.FBAIdIndex;
            dst.FullNameIndex = src.FullNameIndex;
            dst.UserNameIndex = src.UserNameIndex;
            dst.EmailIDIndex = src.EmailIDIndex;
            dst.MobiNumb1Index = src.MobiNumb1Index;
            dst.LiveURLIndex = src.LiveURLIndex;
            dst.LastloginDateIndex = src.LastloginDateIndex;
            dst.ValidfromIndex = src.ValidfromIndex;
            dst.RewardPointIndex = src.RewardPointIndex;
            dst.IsFirstLoginIndex = src.IsFirstLoginIndex;
            dst.IsDemoIndex = src.IsDemoIndex;
            dst.FSMFullnameIndex = src.FSMFullnameIndex;
            dst.FSMEmailIndex = src.FSMEmailIndex;
            dst.FSMMobileIndex = src.FSMMobileIndex;
            dst.FBACodeIndex = src.FBACodeIndex;
            dst.DesignationIndex = src.DesignationIndex;
            dst.ProfPictNameIndex = src.ProfPictNameIndex;
            dst.FSMDesigIndex = src.FSMDesigIndex;
            dst.RegMACAddrIndex = src.RegMACAddrIndex;
            dst.SuppMobiNumbIndex = src.SuppMobiNumbIndex;
            dst.SuppEmailIdIndex = src.SuppEmailIdIndex;
            dst.FBAStatusIndex = src.FBAStatusIndex;
            dst.POSPStatusIndex = src.POSPStatusIndex;
            dst.UserTypeIndex = src.UserTypeIndex;
            dst.SuppAgenIdIndex = src.SuppAgenIdIndex;
            dst.EditEmailIdIndex = src.EditEmailIdIndex;
            dst.EditMobiNumbIndex = src.EditMobiNumbIndex;
            dst.EditDesigIndex = src.EditDesigIndex;
            dst.EditProfPictNameIndex = src.EditProfPictNameIndex;
            dst.LoanIdIndex = src.LoanIdIndex;
            dst.PayStatusIndex = src.PayStatusIndex;
            dst.CustIDIndex = src.CustIDIndex;
            dst.PaymentUrlIndex = src.PaymentUrlIndex;
            dst.IsFocIndex = src.IsFocIndex;
            dst.POSPNameIndex = src.POSPNameIndex;
            dst.POSEmailIndex = src.POSEmailIndex;
            dst.POSPMobileIndex = src.POSPMobileIndex;
            dst.SuccessStatusIndex = src.SuccessStatusIndex;
            dst.POSPInfoIndex = src.POSPInfoIndex;
            dst.FSMIndex = src.FSMIndex;
            dst.rm_idIndex = src.rm_idIndex;
            dst.referraidIndex = src.referraidIndex;
            dst.POSPNoIndex = src.POSPNoIndex;
            dst.POSPProfileUrlIndex = src.POSPProfileUrlIndex;
            dst.FBAProfileUrlIndex = src.FBAProfileUrlIndex;
            dst.referer_codeIndex = src.referer_codeIndex;
            dst.IsUidLoginIndex = src.IsUidLoginIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>(47);
        fieldNames.add("FBAId");
        fieldNames.add("FullName");
        fieldNames.add("UserName");
        fieldNames.add("EmailID");
        fieldNames.add("MobiNumb1");
        fieldNames.add("LiveURL");
        fieldNames.add("LastloginDate");
        fieldNames.add("Validfrom");
        fieldNames.add("RewardPoint");
        fieldNames.add("IsFirstLogin");
        fieldNames.add("IsDemo");
        fieldNames.add("FSMFullname");
        fieldNames.add("FSMEmail");
        fieldNames.add("FSMMobile");
        fieldNames.add("FBACode");
        fieldNames.add("Designation");
        fieldNames.add("ProfPictName");
        fieldNames.add("FSMDesig");
        fieldNames.add("RegMACAddr");
        fieldNames.add("SuppMobiNumb");
        fieldNames.add("SuppEmailId");
        fieldNames.add("FBAStatus");
        fieldNames.add("POSPStatus");
        fieldNames.add("UserType");
        fieldNames.add("SuppAgenId");
        fieldNames.add("EditEmailId");
        fieldNames.add("EditMobiNumb");
        fieldNames.add("EditDesig");
        fieldNames.add("EditProfPictName");
        fieldNames.add("LoanId");
        fieldNames.add("PayStatus");
        fieldNames.add("CustID");
        fieldNames.add("PaymentUrl");
        fieldNames.add("IsFoc");
        fieldNames.add("POSPName");
        fieldNames.add("POSEmail");
        fieldNames.add("POSPMobile");
        fieldNames.add("SuccessStatus");
        fieldNames.add("POSPInfo");
        fieldNames.add("FSM");
        fieldNames.add("rm_id");
        fieldNames.add("referraid");
        fieldNames.add("POSPNo");
        fieldNames.add("POSPProfileUrl");
        fieldNames.add("FBAProfileUrl");
        fieldNames.add("referer_code");
        fieldNames.add("IsUidLogin");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    private LoginResponseEntityColumnInfo columnInfo;
    private ProxyState<magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity> proxyState;

    LoginResponseEntityRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (LoginResponseEntityColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$FBAId() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.FBAIdIndex);
    }

    @Override
    public void realmSet$FBAId(int value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'FBAId' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$FullName() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.FullNameIndex);
    }

    @Override
    public void realmSet$FullName(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.FullNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.FullNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.FullNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.FullNameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$UserName() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.UserNameIndex);
    }

    @Override
    public void realmSet$UserName(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.UserNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.UserNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.UserNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.UserNameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$EmailID() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.EmailIDIndex);
    }

    @Override
    public void realmSet$EmailID(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.EmailIDIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.EmailIDIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.EmailIDIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.EmailIDIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$MobiNumb1() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.MobiNumb1Index);
    }

    @Override
    public void realmSet$MobiNumb1(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.MobiNumb1Index, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.MobiNumb1Index, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.MobiNumb1Index);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.MobiNumb1Index, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$LiveURL() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.LiveURLIndex);
    }

    @Override
    public void realmSet$LiveURL(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.LiveURLIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.LiveURLIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.LiveURLIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.LiveURLIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$LastloginDate() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.LastloginDateIndex);
    }

    @Override
    public void realmSet$LastloginDate(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.LastloginDateIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.LastloginDateIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.LastloginDateIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.LastloginDateIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$Validfrom() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.ValidfromIndex);
    }

    @Override
    public void realmSet$Validfrom(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.ValidfromIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.ValidfromIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.ValidfromIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.ValidfromIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$RewardPoint() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.RewardPointIndex);
    }

    @Override
    public void realmSet$RewardPoint(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.RewardPointIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.RewardPointIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.RewardPointIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.RewardPointIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$IsFirstLogin() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.IsFirstLoginIndex);
    }

    @Override
    public void realmSet$IsFirstLogin(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.IsFirstLoginIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.IsFirstLoginIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$IsDemo() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.IsDemoIndex);
    }

    @Override
    public void realmSet$IsDemo(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.IsDemoIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.IsDemoIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$FSMFullname() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.FSMFullnameIndex);
    }

    @Override
    public void realmSet$FSMFullname(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.FSMFullnameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.FSMFullnameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.FSMFullnameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.FSMFullnameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$FSMEmail() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.FSMEmailIndex);
    }

    @Override
    public void realmSet$FSMEmail(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.FSMEmailIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.FSMEmailIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.FSMEmailIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.FSMEmailIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$FSMMobile() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.FSMMobileIndex);
    }

    @Override
    public void realmSet$FSMMobile(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.FSMMobileIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.FSMMobileIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.FSMMobileIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.FSMMobileIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$FBACode() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.FBACodeIndex);
    }

    @Override
    public void realmSet$FBACode(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.FBACodeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.FBACodeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.FBACodeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.FBACodeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$Designation() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.DesignationIndex);
    }

    @Override
    public void realmSet$Designation(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.DesignationIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.DesignationIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.DesignationIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.DesignationIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$ProfPictName() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.ProfPictNameIndex);
    }

    @Override
    public void realmSet$ProfPictName(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.ProfPictNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.ProfPictNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.ProfPictNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.ProfPictNameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$FSMDesig() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.FSMDesigIndex);
    }

    @Override
    public void realmSet$FSMDesig(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.FSMDesigIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.FSMDesigIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.FSMDesigIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.FSMDesigIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$RegMACAddr() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.RegMACAddrIndex);
    }

    @Override
    public void realmSet$RegMACAddr(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.RegMACAddrIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.RegMACAddrIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.RegMACAddrIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.RegMACAddrIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$SuppMobiNumb() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.SuppMobiNumbIndex);
    }

    @Override
    public void realmSet$SuppMobiNumb(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.SuppMobiNumbIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.SuppMobiNumbIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.SuppMobiNumbIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.SuppMobiNumbIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$SuppEmailId() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.SuppEmailIdIndex);
    }

    @Override
    public void realmSet$SuppEmailId(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.SuppEmailIdIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.SuppEmailIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.SuppEmailIdIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.SuppEmailIdIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$FBAStatus() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.FBAStatusIndex);
    }

    @Override
    public void realmSet$FBAStatus(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.FBAStatusIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.FBAStatusIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.FBAStatusIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.FBAStatusIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$POSPStatus() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.POSPStatusIndex);
    }

    @Override
    public void realmSet$POSPStatus(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.POSPStatusIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.POSPStatusIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.POSPStatusIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.POSPStatusIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$UserType() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.UserTypeIndex);
    }

    @Override
    public void realmSet$UserType(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.UserTypeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.UserTypeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.UserTypeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.UserTypeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$SuppAgenId() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.SuppAgenIdIndex);
    }

    @Override
    public void realmSet$SuppAgenId(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.SuppAgenIdIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.SuppAgenIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.SuppAgenIdIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.SuppAgenIdIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$EditEmailId() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.EditEmailIdIndex);
    }

    @Override
    public void realmSet$EditEmailId(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.EditEmailIdIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.EditEmailIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.EditEmailIdIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.EditEmailIdIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$EditMobiNumb() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.EditMobiNumbIndex);
    }

    @Override
    public void realmSet$EditMobiNumb(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.EditMobiNumbIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.EditMobiNumbIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.EditMobiNumbIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.EditMobiNumbIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$EditDesig() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.EditDesigIndex);
    }

    @Override
    public void realmSet$EditDesig(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.EditDesigIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.EditDesigIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.EditDesigIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.EditDesigIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$EditProfPictName() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.EditProfPictNameIndex);
    }

    @Override
    public void realmSet$EditProfPictName(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.EditProfPictNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.EditProfPictNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.EditProfPictNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.EditProfPictNameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$LoanId() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.LoanIdIndex);
    }

    @Override
    public void realmSet$LoanId(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.LoanIdIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.LoanIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.LoanIdIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.LoanIdIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$PayStatus() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.PayStatusIndex);
    }

    @Override
    public void realmSet$PayStatus(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.PayStatusIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.PayStatusIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.PayStatusIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.PayStatusIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$CustID() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.CustIDIndex);
    }

    @Override
    public void realmSet$CustID(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.CustIDIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.CustIDIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.CustIDIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.CustIDIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$PaymentUrl() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.PaymentUrlIndex);
    }

    @Override
    public void realmSet$PaymentUrl(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.PaymentUrlIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.PaymentUrlIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.PaymentUrlIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.PaymentUrlIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$IsFoc() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.IsFocIndex);
    }

    @Override
    public void realmSet$IsFoc(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.IsFocIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.IsFocIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.IsFocIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.IsFocIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$POSPName() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.POSPNameIndex);
    }

    @Override
    public void realmSet$POSPName(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.POSPNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.POSPNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.POSPNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.POSPNameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$POSEmail() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.POSEmailIndex);
    }

    @Override
    public void realmSet$POSEmail(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.POSEmailIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.POSEmailIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.POSEmailIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.POSEmailIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$POSPMobile() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.POSPMobileIndex);
    }

    @Override
    public void realmSet$POSPMobile(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.POSPMobileIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.POSPMobileIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.POSPMobileIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.POSPMobileIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$SuccessStatus() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.SuccessStatusIndex);
    }

    @Override
    public void realmSet$SuccessStatus(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.SuccessStatusIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.SuccessStatusIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.SuccessStatusIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.SuccessStatusIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$POSPInfo() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.POSPInfoIndex);
    }

    @Override
    public void realmSet$POSPInfo(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.POSPInfoIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.POSPInfoIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.POSPInfoIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.POSPInfoIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$FSM() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.FSMIndex);
    }

    @Override
    public void realmSet$FSM(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.FSMIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.FSMIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.FSMIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.FSMIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$rm_id() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.rm_idIndex);
    }

    @Override
    public void realmSet$rm_id(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.rm_idIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.rm_idIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$referraid() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.referraidIndex);
    }

    @Override
    public void realmSet$referraid(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.referraidIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.referraidIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.referraidIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.referraidIndex, value);
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
    public String realmGet$POSPProfileUrl() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.POSPProfileUrlIndex);
    }

    @Override
    public void realmSet$POSPProfileUrl(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.POSPProfileUrlIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.POSPProfileUrlIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.POSPProfileUrlIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.POSPProfileUrlIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$FBAProfileUrl() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.FBAProfileUrlIndex);
    }

    @Override
    public void realmSet$FBAProfileUrl(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.FBAProfileUrlIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.FBAProfileUrlIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.FBAProfileUrlIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.FBAProfileUrlIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$referer_code() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.referer_codeIndex);
    }

    @Override
    public void realmSet$referer_code(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.referer_codeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.referer_codeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.referer_codeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.referer_codeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$IsUidLogin() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.IsUidLoginIndex);
    }

    @Override
    public void realmSet$IsUidLogin(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.IsUidLoginIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.IsUidLoginIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.IsUidLoginIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.IsUidLoginIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("LoginResponseEntity", 47, 0);
        builder.addPersistedProperty("FBAId", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("FullName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("UserName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("EmailID", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("MobiNumb1", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("LiveURL", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("LastloginDate", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("Validfrom", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("RewardPoint", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("IsFirstLogin", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("IsDemo", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("FSMFullname", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("FSMEmail", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("FSMMobile", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("FBACode", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("Designation", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("ProfPictName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("FSMDesig", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("RegMACAddr", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("SuppMobiNumb", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("SuppEmailId", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("FBAStatus", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("POSPStatus", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("UserType", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("SuppAgenId", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("EditEmailId", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("EditMobiNumb", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("EditDesig", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("EditProfPictName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("LoanId", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("PayStatus", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("CustID", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("PaymentUrl", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("IsFoc", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("POSPName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("POSEmail", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("POSPMobile", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("SuccessStatus", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("POSPInfo", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("FSM", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("rm_id", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("referraid", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("POSPNo", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("POSPProfileUrl", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("FBAProfileUrl", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("referer_code", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("IsUidLogin", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static LoginResponseEntityColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new LoginResponseEntityColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "LoginResponseEntity";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity obj = null;
        if (update) {
            Table table = realm.getTable(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity.class);
            LoginResponseEntityColumnInfo columnInfo = (LoginResponseEntityColumnInfo) realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity.class);
            long pkColumnIndex = columnInfo.FBAIdIndex;
            long rowIndex = Table.NO_MATCH;
            if (!json.isNull("FBAId")) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("FBAId"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity.class), false, Collections.<String> emptyList());
                    obj = new io.realm.LoginResponseEntityRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("FBAId")) {
                if (json.isNull("FBAId")) {
                    obj = (io.realm.LoginResponseEntityRealmProxy) realm.createObjectInternal(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.LoginResponseEntityRealmProxy) realm.createObjectInternal(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity.class, json.getInt("FBAId"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'FBAId'.");
            }
        }

        final LoginResponseEntityRealmProxyInterface objProxy = (LoginResponseEntityRealmProxyInterface) obj;
        if (json.has("FullName")) {
            if (json.isNull("FullName")) {
                objProxy.realmSet$FullName(null);
            } else {
                objProxy.realmSet$FullName((String) json.getString("FullName"));
            }
        }
        if (json.has("UserName")) {
            if (json.isNull("UserName")) {
                objProxy.realmSet$UserName(null);
            } else {
                objProxy.realmSet$UserName((String) json.getString("UserName"));
            }
        }
        if (json.has("EmailID")) {
            if (json.isNull("EmailID")) {
                objProxy.realmSet$EmailID(null);
            } else {
                objProxy.realmSet$EmailID((String) json.getString("EmailID"));
            }
        }
        if (json.has("MobiNumb1")) {
            if (json.isNull("MobiNumb1")) {
                objProxy.realmSet$MobiNumb1(null);
            } else {
                objProxy.realmSet$MobiNumb1((String) json.getString("MobiNumb1"));
            }
        }
        if (json.has("LiveURL")) {
            if (json.isNull("LiveURL")) {
                objProxy.realmSet$LiveURL(null);
            } else {
                objProxy.realmSet$LiveURL((String) json.getString("LiveURL"));
            }
        }
        if (json.has("LastloginDate")) {
            if (json.isNull("LastloginDate")) {
                objProxy.realmSet$LastloginDate(null);
            } else {
                objProxy.realmSet$LastloginDate((String) json.getString("LastloginDate"));
            }
        }
        if (json.has("Validfrom")) {
            if (json.isNull("Validfrom")) {
                objProxy.realmSet$Validfrom(null);
            } else {
                objProxy.realmSet$Validfrom((String) json.getString("Validfrom"));
            }
        }
        if (json.has("RewardPoint")) {
            if (json.isNull("RewardPoint")) {
                objProxy.realmSet$RewardPoint(null);
            } else {
                objProxy.realmSet$RewardPoint((String) json.getString("RewardPoint"));
            }
        }
        if (json.has("IsFirstLogin")) {
            if (json.isNull("IsFirstLogin")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'IsFirstLogin' to null.");
            } else {
                objProxy.realmSet$IsFirstLogin((int) json.getInt("IsFirstLogin"));
            }
        }
        if (json.has("IsDemo")) {
            if (json.isNull("IsDemo")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'IsDemo' to null.");
            } else {
                objProxy.realmSet$IsDemo((int) json.getInt("IsDemo"));
            }
        }
        if (json.has("FSMFullname")) {
            if (json.isNull("FSMFullname")) {
                objProxy.realmSet$FSMFullname(null);
            } else {
                objProxy.realmSet$FSMFullname((String) json.getString("FSMFullname"));
            }
        }
        if (json.has("FSMEmail")) {
            if (json.isNull("FSMEmail")) {
                objProxy.realmSet$FSMEmail(null);
            } else {
                objProxy.realmSet$FSMEmail((String) json.getString("FSMEmail"));
            }
        }
        if (json.has("FSMMobile")) {
            if (json.isNull("FSMMobile")) {
                objProxy.realmSet$FSMMobile(null);
            } else {
                objProxy.realmSet$FSMMobile((String) json.getString("FSMMobile"));
            }
        }
        if (json.has("FBACode")) {
            if (json.isNull("FBACode")) {
                objProxy.realmSet$FBACode(null);
            } else {
                objProxy.realmSet$FBACode((String) json.getString("FBACode"));
            }
        }
        if (json.has("Designation")) {
            if (json.isNull("Designation")) {
                objProxy.realmSet$Designation(null);
            } else {
                objProxy.realmSet$Designation((String) json.getString("Designation"));
            }
        }
        if (json.has("ProfPictName")) {
            if (json.isNull("ProfPictName")) {
                objProxy.realmSet$ProfPictName(null);
            } else {
                objProxy.realmSet$ProfPictName((String) json.getString("ProfPictName"));
            }
        }
        if (json.has("FSMDesig")) {
            if (json.isNull("FSMDesig")) {
                objProxy.realmSet$FSMDesig(null);
            } else {
                objProxy.realmSet$FSMDesig((String) json.getString("FSMDesig"));
            }
        }
        if (json.has("RegMACAddr")) {
            if (json.isNull("RegMACAddr")) {
                objProxy.realmSet$RegMACAddr(null);
            } else {
                objProxy.realmSet$RegMACAddr((String) json.getString("RegMACAddr"));
            }
        }
        if (json.has("SuppMobiNumb")) {
            if (json.isNull("SuppMobiNumb")) {
                objProxy.realmSet$SuppMobiNumb(null);
            } else {
                objProxy.realmSet$SuppMobiNumb((String) json.getString("SuppMobiNumb"));
            }
        }
        if (json.has("SuppEmailId")) {
            if (json.isNull("SuppEmailId")) {
                objProxy.realmSet$SuppEmailId(null);
            } else {
                objProxy.realmSet$SuppEmailId((String) json.getString("SuppEmailId"));
            }
        }
        if (json.has("FBAStatus")) {
            if (json.isNull("FBAStatus")) {
                objProxy.realmSet$FBAStatus(null);
            } else {
                objProxy.realmSet$FBAStatus((String) json.getString("FBAStatus"));
            }
        }
        if (json.has("POSPStatus")) {
            if (json.isNull("POSPStatus")) {
                objProxy.realmSet$POSPStatus(null);
            } else {
                objProxy.realmSet$POSPStatus((String) json.getString("POSPStatus"));
            }
        }
        if (json.has("UserType")) {
            if (json.isNull("UserType")) {
                objProxy.realmSet$UserType(null);
            } else {
                objProxy.realmSet$UserType((String) json.getString("UserType"));
            }
        }
        if (json.has("SuppAgenId")) {
            if (json.isNull("SuppAgenId")) {
                objProxy.realmSet$SuppAgenId(null);
            } else {
                objProxy.realmSet$SuppAgenId((String) json.getString("SuppAgenId"));
            }
        }
        if (json.has("EditEmailId")) {
            if (json.isNull("EditEmailId")) {
                objProxy.realmSet$EditEmailId(null);
            } else {
                objProxy.realmSet$EditEmailId((String) json.getString("EditEmailId"));
            }
        }
        if (json.has("EditMobiNumb")) {
            if (json.isNull("EditMobiNumb")) {
                objProxy.realmSet$EditMobiNumb(null);
            } else {
                objProxy.realmSet$EditMobiNumb((String) json.getString("EditMobiNumb"));
            }
        }
        if (json.has("EditDesig")) {
            if (json.isNull("EditDesig")) {
                objProxy.realmSet$EditDesig(null);
            } else {
                objProxy.realmSet$EditDesig((String) json.getString("EditDesig"));
            }
        }
        if (json.has("EditProfPictName")) {
            if (json.isNull("EditProfPictName")) {
                objProxy.realmSet$EditProfPictName(null);
            } else {
                objProxy.realmSet$EditProfPictName((String) json.getString("EditProfPictName"));
            }
        }
        if (json.has("LoanId")) {
            if (json.isNull("LoanId")) {
                objProxy.realmSet$LoanId(null);
            } else {
                objProxy.realmSet$LoanId((String) json.getString("LoanId"));
            }
        }
        if (json.has("PayStatus")) {
            if (json.isNull("PayStatus")) {
                objProxy.realmSet$PayStatus(null);
            } else {
                objProxy.realmSet$PayStatus((String) json.getString("PayStatus"));
            }
        }
        if (json.has("CustID")) {
            if (json.isNull("CustID")) {
                objProxy.realmSet$CustID(null);
            } else {
                objProxy.realmSet$CustID((String) json.getString("CustID"));
            }
        }
        if (json.has("PaymentUrl")) {
            if (json.isNull("PaymentUrl")) {
                objProxy.realmSet$PaymentUrl(null);
            } else {
                objProxy.realmSet$PaymentUrl((String) json.getString("PaymentUrl"));
            }
        }
        if (json.has("IsFoc")) {
            if (json.isNull("IsFoc")) {
                objProxy.realmSet$IsFoc(null);
            } else {
                objProxy.realmSet$IsFoc((String) json.getString("IsFoc"));
            }
        }
        if (json.has("POSPName")) {
            if (json.isNull("POSPName")) {
                objProxy.realmSet$POSPName(null);
            } else {
                objProxy.realmSet$POSPName((String) json.getString("POSPName"));
            }
        }
        if (json.has("POSEmail")) {
            if (json.isNull("POSEmail")) {
                objProxy.realmSet$POSEmail(null);
            } else {
                objProxy.realmSet$POSEmail((String) json.getString("POSEmail"));
            }
        }
        if (json.has("POSPMobile")) {
            if (json.isNull("POSPMobile")) {
                objProxy.realmSet$POSPMobile(null);
            } else {
                objProxy.realmSet$POSPMobile((String) json.getString("POSPMobile"));
            }
        }
        if (json.has("SuccessStatus")) {
            if (json.isNull("SuccessStatus")) {
                objProxy.realmSet$SuccessStatus(null);
            } else {
                objProxy.realmSet$SuccessStatus((String) json.getString("SuccessStatus"));
            }
        }
        if (json.has("POSPInfo")) {
            if (json.isNull("POSPInfo")) {
                objProxy.realmSet$POSPInfo(null);
            } else {
                objProxy.realmSet$POSPInfo((String) json.getString("POSPInfo"));
            }
        }
        if (json.has("FSM")) {
            if (json.isNull("FSM")) {
                objProxy.realmSet$FSM(null);
            } else {
                objProxy.realmSet$FSM((String) json.getString("FSM"));
            }
        }
        if (json.has("rm_id")) {
            if (json.isNull("rm_id")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'rm_id' to null.");
            } else {
                objProxy.realmSet$rm_id((int) json.getInt("rm_id"));
            }
        }
        if (json.has("referraid")) {
            if (json.isNull("referraid")) {
                objProxy.realmSet$referraid(null);
            } else {
                objProxy.realmSet$referraid((String) json.getString("referraid"));
            }
        }
        if (json.has("POSPNo")) {
            if (json.isNull("POSPNo")) {
                objProxy.realmSet$POSPNo(null);
            } else {
                objProxy.realmSet$POSPNo((String) json.getString("POSPNo"));
            }
        }
        if (json.has("POSPProfileUrl")) {
            if (json.isNull("POSPProfileUrl")) {
                objProxy.realmSet$POSPProfileUrl(null);
            } else {
                objProxy.realmSet$POSPProfileUrl((String) json.getString("POSPProfileUrl"));
            }
        }
        if (json.has("FBAProfileUrl")) {
            if (json.isNull("FBAProfileUrl")) {
                objProxy.realmSet$FBAProfileUrl(null);
            } else {
                objProxy.realmSet$FBAProfileUrl((String) json.getString("FBAProfileUrl"));
            }
        }
        if (json.has("referer_code")) {
            if (json.isNull("referer_code")) {
                objProxy.realmSet$referer_code(null);
            } else {
                objProxy.realmSet$referer_code((String) json.getString("referer_code"));
            }
        }
        if (json.has("IsUidLogin")) {
            if (json.isNull("IsUidLogin")) {
                objProxy.realmSet$IsUidLogin(null);
            } else {
                objProxy.realmSet$IsUidLogin((String) json.getString("IsUidLogin"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity obj = new magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity();
        final LoginResponseEntityRealmProxyInterface objProxy = (LoginResponseEntityRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("FBAId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$FBAId((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'FBAId' to null.");
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("FullName")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$FullName((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$FullName(null);
                }
            } else if (name.equals("UserName")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$UserName((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$UserName(null);
                }
            } else if (name.equals("EmailID")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$EmailID((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$EmailID(null);
                }
            } else if (name.equals("MobiNumb1")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$MobiNumb1((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$MobiNumb1(null);
                }
            } else if (name.equals("LiveURL")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$LiveURL((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$LiveURL(null);
                }
            } else if (name.equals("LastloginDate")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$LastloginDate((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$LastloginDate(null);
                }
            } else if (name.equals("Validfrom")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$Validfrom((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$Validfrom(null);
                }
            } else if (name.equals("RewardPoint")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$RewardPoint((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$RewardPoint(null);
                }
            } else if (name.equals("IsFirstLogin")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$IsFirstLogin((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'IsFirstLogin' to null.");
                }
            } else if (name.equals("IsDemo")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$IsDemo((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'IsDemo' to null.");
                }
            } else if (name.equals("FSMFullname")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$FSMFullname((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$FSMFullname(null);
                }
            } else if (name.equals("FSMEmail")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$FSMEmail((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$FSMEmail(null);
                }
            } else if (name.equals("FSMMobile")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$FSMMobile((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$FSMMobile(null);
                }
            } else if (name.equals("FBACode")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$FBACode((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$FBACode(null);
                }
            } else if (name.equals("Designation")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$Designation((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$Designation(null);
                }
            } else if (name.equals("ProfPictName")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$ProfPictName((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$ProfPictName(null);
                }
            } else if (name.equals("FSMDesig")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$FSMDesig((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$FSMDesig(null);
                }
            } else if (name.equals("RegMACAddr")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$RegMACAddr((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$RegMACAddr(null);
                }
            } else if (name.equals("SuppMobiNumb")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$SuppMobiNumb((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$SuppMobiNumb(null);
                }
            } else if (name.equals("SuppEmailId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$SuppEmailId((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$SuppEmailId(null);
                }
            } else if (name.equals("FBAStatus")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$FBAStatus((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$FBAStatus(null);
                }
            } else if (name.equals("POSPStatus")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$POSPStatus((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$POSPStatus(null);
                }
            } else if (name.equals("UserType")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$UserType((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$UserType(null);
                }
            } else if (name.equals("SuppAgenId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$SuppAgenId((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$SuppAgenId(null);
                }
            } else if (name.equals("EditEmailId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$EditEmailId((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$EditEmailId(null);
                }
            } else if (name.equals("EditMobiNumb")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$EditMobiNumb((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$EditMobiNumb(null);
                }
            } else if (name.equals("EditDesig")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$EditDesig((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$EditDesig(null);
                }
            } else if (name.equals("EditProfPictName")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$EditProfPictName((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$EditProfPictName(null);
                }
            } else if (name.equals("LoanId")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$LoanId((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$LoanId(null);
                }
            } else if (name.equals("PayStatus")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$PayStatus((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$PayStatus(null);
                }
            } else if (name.equals("CustID")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$CustID((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$CustID(null);
                }
            } else if (name.equals("PaymentUrl")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$PaymentUrl((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$PaymentUrl(null);
                }
            } else if (name.equals("IsFoc")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$IsFoc((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$IsFoc(null);
                }
            } else if (name.equals("POSPName")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$POSPName((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$POSPName(null);
                }
            } else if (name.equals("POSEmail")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$POSEmail((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$POSEmail(null);
                }
            } else if (name.equals("POSPMobile")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$POSPMobile((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$POSPMobile(null);
                }
            } else if (name.equals("SuccessStatus")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$SuccessStatus((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$SuccessStatus(null);
                }
            } else if (name.equals("POSPInfo")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$POSPInfo((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$POSPInfo(null);
                }
            } else if (name.equals("FSM")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$FSM((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$FSM(null);
                }
            } else if (name.equals("rm_id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$rm_id((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'rm_id' to null.");
                }
            } else if (name.equals("referraid")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$referraid((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$referraid(null);
                }
            } else if (name.equals("POSPNo")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$POSPNo((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$POSPNo(null);
                }
            } else if (name.equals("POSPProfileUrl")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$POSPProfileUrl((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$POSPProfileUrl(null);
                }
            } else if (name.equals("FBAProfileUrl")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$FBAProfileUrl((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$FBAProfileUrl(null);
                }
            } else if (name.equals("referer_code")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$referer_code((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$referer_code(null);
                }
            } else if (name.equals("IsUidLogin")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$IsUidLogin((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$IsUidLogin(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'FBAId'.");
        }
        return realm.copyToRealm(obj);
    }

    public static magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity copyOrUpdate(Realm realm, magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity) cachedRealmObject;
        }

        magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity.class);
            LoginResponseEntityColumnInfo columnInfo = (LoginResponseEntityColumnInfo) realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity.class);
            long pkColumnIndex = columnInfo.FBAIdIndex;
            long rowIndex = table.findFirstLong(pkColumnIndex, ((LoginResponseEntityRealmProxyInterface) object).realmGet$FBAId());
            if (rowIndex == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity.class), false, Collections.<String> emptyList());
                    realmObject = new io.realm.LoginResponseEntityRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, realmObject, object, cache) : copy(realm, object, update, cache);
    }

    public static magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity copy(Realm realm, magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity realmObject = realm.createObjectInternal(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity.class, ((LoginResponseEntityRealmProxyInterface) newObject).realmGet$FBAId(), false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        LoginResponseEntityRealmProxyInterface realmObjectSource = (LoginResponseEntityRealmProxyInterface) newObject;
        LoginResponseEntityRealmProxyInterface realmObjectCopy = (LoginResponseEntityRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$FullName(realmObjectSource.realmGet$FullName());
        realmObjectCopy.realmSet$UserName(realmObjectSource.realmGet$UserName());
        realmObjectCopy.realmSet$EmailID(realmObjectSource.realmGet$EmailID());
        realmObjectCopy.realmSet$MobiNumb1(realmObjectSource.realmGet$MobiNumb1());
        realmObjectCopy.realmSet$LiveURL(realmObjectSource.realmGet$LiveURL());
        realmObjectCopy.realmSet$LastloginDate(realmObjectSource.realmGet$LastloginDate());
        realmObjectCopy.realmSet$Validfrom(realmObjectSource.realmGet$Validfrom());
        realmObjectCopy.realmSet$RewardPoint(realmObjectSource.realmGet$RewardPoint());
        realmObjectCopy.realmSet$IsFirstLogin(realmObjectSource.realmGet$IsFirstLogin());
        realmObjectCopy.realmSet$IsDemo(realmObjectSource.realmGet$IsDemo());
        realmObjectCopy.realmSet$FSMFullname(realmObjectSource.realmGet$FSMFullname());
        realmObjectCopy.realmSet$FSMEmail(realmObjectSource.realmGet$FSMEmail());
        realmObjectCopy.realmSet$FSMMobile(realmObjectSource.realmGet$FSMMobile());
        realmObjectCopy.realmSet$FBACode(realmObjectSource.realmGet$FBACode());
        realmObjectCopy.realmSet$Designation(realmObjectSource.realmGet$Designation());
        realmObjectCopy.realmSet$ProfPictName(realmObjectSource.realmGet$ProfPictName());
        realmObjectCopy.realmSet$FSMDesig(realmObjectSource.realmGet$FSMDesig());
        realmObjectCopy.realmSet$RegMACAddr(realmObjectSource.realmGet$RegMACAddr());
        realmObjectCopy.realmSet$SuppMobiNumb(realmObjectSource.realmGet$SuppMobiNumb());
        realmObjectCopy.realmSet$SuppEmailId(realmObjectSource.realmGet$SuppEmailId());
        realmObjectCopy.realmSet$FBAStatus(realmObjectSource.realmGet$FBAStatus());
        realmObjectCopy.realmSet$POSPStatus(realmObjectSource.realmGet$POSPStatus());
        realmObjectCopy.realmSet$UserType(realmObjectSource.realmGet$UserType());
        realmObjectCopy.realmSet$SuppAgenId(realmObjectSource.realmGet$SuppAgenId());
        realmObjectCopy.realmSet$EditEmailId(realmObjectSource.realmGet$EditEmailId());
        realmObjectCopy.realmSet$EditMobiNumb(realmObjectSource.realmGet$EditMobiNumb());
        realmObjectCopy.realmSet$EditDesig(realmObjectSource.realmGet$EditDesig());
        realmObjectCopy.realmSet$EditProfPictName(realmObjectSource.realmGet$EditProfPictName());
        realmObjectCopy.realmSet$LoanId(realmObjectSource.realmGet$LoanId());
        realmObjectCopy.realmSet$PayStatus(realmObjectSource.realmGet$PayStatus());
        realmObjectCopy.realmSet$CustID(realmObjectSource.realmGet$CustID());
        realmObjectCopy.realmSet$PaymentUrl(realmObjectSource.realmGet$PaymentUrl());
        realmObjectCopy.realmSet$IsFoc(realmObjectSource.realmGet$IsFoc());
        realmObjectCopy.realmSet$POSPName(realmObjectSource.realmGet$POSPName());
        realmObjectCopy.realmSet$POSEmail(realmObjectSource.realmGet$POSEmail());
        realmObjectCopy.realmSet$POSPMobile(realmObjectSource.realmGet$POSPMobile());
        realmObjectCopy.realmSet$SuccessStatus(realmObjectSource.realmGet$SuccessStatus());
        realmObjectCopy.realmSet$POSPInfo(realmObjectSource.realmGet$POSPInfo());
        realmObjectCopy.realmSet$FSM(realmObjectSource.realmGet$FSM());
        realmObjectCopy.realmSet$rm_id(realmObjectSource.realmGet$rm_id());
        realmObjectCopy.realmSet$referraid(realmObjectSource.realmGet$referraid());
        realmObjectCopy.realmSet$POSPNo(realmObjectSource.realmGet$POSPNo());
        realmObjectCopy.realmSet$POSPProfileUrl(realmObjectSource.realmGet$POSPProfileUrl());
        realmObjectCopy.realmSet$FBAProfileUrl(realmObjectSource.realmGet$FBAProfileUrl());
        realmObjectCopy.realmSet$referer_code(realmObjectSource.realmGet$referer_code());
        realmObjectCopy.realmSet$IsUidLogin(realmObjectSource.realmGet$IsUidLogin());
        return realmObject;
    }

    public static long insert(Realm realm, magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity.class);
        long tableNativePtr = table.getNativePtr();
        LoginResponseEntityColumnInfo columnInfo = (LoginResponseEntityColumnInfo) realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity.class);
        long pkColumnIndex = columnInfo.FBAIdIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((LoginResponseEntityRealmProxyInterface) object).realmGet$FBAId();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((LoginResponseEntityRealmProxyInterface) object).realmGet$FBAId());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((LoginResponseEntityRealmProxyInterface) object).realmGet$FBAId());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$FullName = ((LoginResponseEntityRealmProxyInterface) object).realmGet$FullName();
        if (realmGet$FullName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.FullNameIndex, rowIndex, realmGet$FullName, false);
        }
        String realmGet$UserName = ((LoginResponseEntityRealmProxyInterface) object).realmGet$UserName();
        if (realmGet$UserName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.UserNameIndex, rowIndex, realmGet$UserName, false);
        }
        String realmGet$EmailID = ((LoginResponseEntityRealmProxyInterface) object).realmGet$EmailID();
        if (realmGet$EmailID != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.EmailIDIndex, rowIndex, realmGet$EmailID, false);
        }
        String realmGet$MobiNumb1 = ((LoginResponseEntityRealmProxyInterface) object).realmGet$MobiNumb1();
        if (realmGet$MobiNumb1 != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.MobiNumb1Index, rowIndex, realmGet$MobiNumb1, false);
        }
        String realmGet$LiveURL = ((LoginResponseEntityRealmProxyInterface) object).realmGet$LiveURL();
        if (realmGet$LiveURL != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.LiveURLIndex, rowIndex, realmGet$LiveURL, false);
        }
        String realmGet$LastloginDate = ((LoginResponseEntityRealmProxyInterface) object).realmGet$LastloginDate();
        if (realmGet$LastloginDate != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.LastloginDateIndex, rowIndex, realmGet$LastloginDate, false);
        }
        String realmGet$Validfrom = ((LoginResponseEntityRealmProxyInterface) object).realmGet$Validfrom();
        if (realmGet$Validfrom != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.ValidfromIndex, rowIndex, realmGet$Validfrom, false);
        }
        String realmGet$RewardPoint = ((LoginResponseEntityRealmProxyInterface) object).realmGet$RewardPoint();
        if (realmGet$RewardPoint != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.RewardPointIndex, rowIndex, realmGet$RewardPoint, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.IsFirstLoginIndex, rowIndex, ((LoginResponseEntityRealmProxyInterface) object).realmGet$IsFirstLogin(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.IsDemoIndex, rowIndex, ((LoginResponseEntityRealmProxyInterface) object).realmGet$IsDemo(), false);
        String realmGet$FSMFullname = ((LoginResponseEntityRealmProxyInterface) object).realmGet$FSMFullname();
        if (realmGet$FSMFullname != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.FSMFullnameIndex, rowIndex, realmGet$FSMFullname, false);
        }
        String realmGet$FSMEmail = ((LoginResponseEntityRealmProxyInterface) object).realmGet$FSMEmail();
        if (realmGet$FSMEmail != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.FSMEmailIndex, rowIndex, realmGet$FSMEmail, false);
        }
        String realmGet$FSMMobile = ((LoginResponseEntityRealmProxyInterface) object).realmGet$FSMMobile();
        if (realmGet$FSMMobile != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.FSMMobileIndex, rowIndex, realmGet$FSMMobile, false);
        }
        String realmGet$FBACode = ((LoginResponseEntityRealmProxyInterface) object).realmGet$FBACode();
        if (realmGet$FBACode != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.FBACodeIndex, rowIndex, realmGet$FBACode, false);
        }
        String realmGet$Designation = ((LoginResponseEntityRealmProxyInterface) object).realmGet$Designation();
        if (realmGet$Designation != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.DesignationIndex, rowIndex, realmGet$Designation, false);
        }
        String realmGet$ProfPictName = ((LoginResponseEntityRealmProxyInterface) object).realmGet$ProfPictName();
        if (realmGet$ProfPictName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.ProfPictNameIndex, rowIndex, realmGet$ProfPictName, false);
        }
        String realmGet$FSMDesig = ((LoginResponseEntityRealmProxyInterface) object).realmGet$FSMDesig();
        if (realmGet$FSMDesig != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.FSMDesigIndex, rowIndex, realmGet$FSMDesig, false);
        }
        String realmGet$RegMACAddr = ((LoginResponseEntityRealmProxyInterface) object).realmGet$RegMACAddr();
        if (realmGet$RegMACAddr != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.RegMACAddrIndex, rowIndex, realmGet$RegMACAddr, false);
        }
        String realmGet$SuppMobiNumb = ((LoginResponseEntityRealmProxyInterface) object).realmGet$SuppMobiNumb();
        if (realmGet$SuppMobiNumb != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.SuppMobiNumbIndex, rowIndex, realmGet$SuppMobiNumb, false);
        }
        String realmGet$SuppEmailId = ((LoginResponseEntityRealmProxyInterface) object).realmGet$SuppEmailId();
        if (realmGet$SuppEmailId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.SuppEmailIdIndex, rowIndex, realmGet$SuppEmailId, false);
        }
        String realmGet$FBAStatus = ((LoginResponseEntityRealmProxyInterface) object).realmGet$FBAStatus();
        if (realmGet$FBAStatus != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.FBAStatusIndex, rowIndex, realmGet$FBAStatus, false);
        }
        String realmGet$POSPStatus = ((LoginResponseEntityRealmProxyInterface) object).realmGet$POSPStatus();
        if (realmGet$POSPStatus != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.POSPStatusIndex, rowIndex, realmGet$POSPStatus, false);
        }
        String realmGet$UserType = ((LoginResponseEntityRealmProxyInterface) object).realmGet$UserType();
        if (realmGet$UserType != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.UserTypeIndex, rowIndex, realmGet$UserType, false);
        }
        String realmGet$SuppAgenId = ((LoginResponseEntityRealmProxyInterface) object).realmGet$SuppAgenId();
        if (realmGet$SuppAgenId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.SuppAgenIdIndex, rowIndex, realmGet$SuppAgenId, false);
        }
        String realmGet$EditEmailId = ((LoginResponseEntityRealmProxyInterface) object).realmGet$EditEmailId();
        if (realmGet$EditEmailId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.EditEmailIdIndex, rowIndex, realmGet$EditEmailId, false);
        }
        String realmGet$EditMobiNumb = ((LoginResponseEntityRealmProxyInterface) object).realmGet$EditMobiNumb();
        if (realmGet$EditMobiNumb != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.EditMobiNumbIndex, rowIndex, realmGet$EditMobiNumb, false);
        }
        String realmGet$EditDesig = ((LoginResponseEntityRealmProxyInterface) object).realmGet$EditDesig();
        if (realmGet$EditDesig != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.EditDesigIndex, rowIndex, realmGet$EditDesig, false);
        }
        String realmGet$EditProfPictName = ((LoginResponseEntityRealmProxyInterface) object).realmGet$EditProfPictName();
        if (realmGet$EditProfPictName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.EditProfPictNameIndex, rowIndex, realmGet$EditProfPictName, false);
        }
        String realmGet$LoanId = ((LoginResponseEntityRealmProxyInterface) object).realmGet$LoanId();
        if (realmGet$LoanId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.LoanIdIndex, rowIndex, realmGet$LoanId, false);
        }
        String realmGet$PayStatus = ((LoginResponseEntityRealmProxyInterface) object).realmGet$PayStatus();
        if (realmGet$PayStatus != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.PayStatusIndex, rowIndex, realmGet$PayStatus, false);
        }
        String realmGet$CustID = ((LoginResponseEntityRealmProxyInterface) object).realmGet$CustID();
        if (realmGet$CustID != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.CustIDIndex, rowIndex, realmGet$CustID, false);
        }
        String realmGet$PaymentUrl = ((LoginResponseEntityRealmProxyInterface) object).realmGet$PaymentUrl();
        if (realmGet$PaymentUrl != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.PaymentUrlIndex, rowIndex, realmGet$PaymentUrl, false);
        }
        String realmGet$IsFoc = ((LoginResponseEntityRealmProxyInterface) object).realmGet$IsFoc();
        if (realmGet$IsFoc != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.IsFocIndex, rowIndex, realmGet$IsFoc, false);
        }
        String realmGet$POSPName = ((LoginResponseEntityRealmProxyInterface) object).realmGet$POSPName();
        if (realmGet$POSPName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.POSPNameIndex, rowIndex, realmGet$POSPName, false);
        }
        String realmGet$POSEmail = ((LoginResponseEntityRealmProxyInterface) object).realmGet$POSEmail();
        if (realmGet$POSEmail != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.POSEmailIndex, rowIndex, realmGet$POSEmail, false);
        }
        String realmGet$POSPMobile = ((LoginResponseEntityRealmProxyInterface) object).realmGet$POSPMobile();
        if (realmGet$POSPMobile != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.POSPMobileIndex, rowIndex, realmGet$POSPMobile, false);
        }
        String realmGet$SuccessStatus = ((LoginResponseEntityRealmProxyInterface) object).realmGet$SuccessStatus();
        if (realmGet$SuccessStatus != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.SuccessStatusIndex, rowIndex, realmGet$SuccessStatus, false);
        }
        String realmGet$POSPInfo = ((LoginResponseEntityRealmProxyInterface) object).realmGet$POSPInfo();
        if (realmGet$POSPInfo != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.POSPInfoIndex, rowIndex, realmGet$POSPInfo, false);
        }
        String realmGet$FSM = ((LoginResponseEntityRealmProxyInterface) object).realmGet$FSM();
        if (realmGet$FSM != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.FSMIndex, rowIndex, realmGet$FSM, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.rm_idIndex, rowIndex, ((LoginResponseEntityRealmProxyInterface) object).realmGet$rm_id(), false);
        String realmGet$referraid = ((LoginResponseEntityRealmProxyInterface) object).realmGet$referraid();
        if (realmGet$referraid != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.referraidIndex, rowIndex, realmGet$referraid, false);
        }
        String realmGet$POSPNo = ((LoginResponseEntityRealmProxyInterface) object).realmGet$POSPNo();
        if (realmGet$POSPNo != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.POSPNoIndex, rowIndex, realmGet$POSPNo, false);
        }
        String realmGet$POSPProfileUrl = ((LoginResponseEntityRealmProxyInterface) object).realmGet$POSPProfileUrl();
        if (realmGet$POSPProfileUrl != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.POSPProfileUrlIndex, rowIndex, realmGet$POSPProfileUrl, false);
        }
        String realmGet$FBAProfileUrl = ((LoginResponseEntityRealmProxyInterface) object).realmGet$FBAProfileUrl();
        if (realmGet$FBAProfileUrl != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.FBAProfileUrlIndex, rowIndex, realmGet$FBAProfileUrl, false);
        }
        String realmGet$referer_code = ((LoginResponseEntityRealmProxyInterface) object).realmGet$referer_code();
        if (realmGet$referer_code != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.referer_codeIndex, rowIndex, realmGet$referer_code, false);
        }
        String realmGet$IsUidLogin = ((LoginResponseEntityRealmProxyInterface) object).realmGet$IsUidLogin();
        if (realmGet$IsUidLogin != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.IsUidLoginIndex, rowIndex, realmGet$IsUidLogin, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity.class);
        long tableNativePtr = table.getNativePtr();
        LoginResponseEntityColumnInfo columnInfo = (LoginResponseEntityColumnInfo) realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity.class);
        long pkColumnIndex = columnInfo.FBAIdIndex;
        magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity object = null;
        while (objects.hasNext()) {
            object = (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((LoginResponseEntityRealmProxyInterface) object).realmGet$FBAId();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((LoginResponseEntityRealmProxyInterface) object).realmGet$FBAId());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((LoginResponseEntityRealmProxyInterface) object).realmGet$FBAId());
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, rowIndex);
            String realmGet$FullName = ((LoginResponseEntityRealmProxyInterface) object).realmGet$FullName();
            if (realmGet$FullName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.FullNameIndex, rowIndex, realmGet$FullName, false);
            }
            String realmGet$UserName = ((LoginResponseEntityRealmProxyInterface) object).realmGet$UserName();
            if (realmGet$UserName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.UserNameIndex, rowIndex, realmGet$UserName, false);
            }
            String realmGet$EmailID = ((LoginResponseEntityRealmProxyInterface) object).realmGet$EmailID();
            if (realmGet$EmailID != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.EmailIDIndex, rowIndex, realmGet$EmailID, false);
            }
            String realmGet$MobiNumb1 = ((LoginResponseEntityRealmProxyInterface) object).realmGet$MobiNumb1();
            if (realmGet$MobiNumb1 != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.MobiNumb1Index, rowIndex, realmGet$MobiNumb1, false);
            }
            String realmGet$LiveURL = ((LoginResponseEntityRealmProxyInterface) object).realmGet$LiveURL();
            if (realmGet$LiveURL != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.LiveURLIndex, rowIndex, realmGet$LiveURL, false);
            }
            String realmGet$LastloginDate = ((LoginResponseEntityRealmProxyInterface) object).realmGet$LastloginDate();
            if (realmGet$LastloginDate != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.LastloginDateIndex, rowIndex, realmGet$LastloginDate, false);
            }
            String realmGet$Validfrom = ((LoginResponseEntityRealmProxyInterface) object).realmGet$Validfrom();
            if (realmGet$Validfrom != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.ValidfromIndex, rowIndex, realmGet$Validfrom, false);
            }
            String realmGet$RewardPoint = ((LoginResponseEntityRealmProxyInterface) object).realmGet$RewardPoint();
            if (realmGet$RewardPoint != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.RewardPointIndex, rowIndex, realmGet$RewardPoint, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.IsFirstLoginIndex, rowIndex, ((LoginResponseEntityRealmProxyInterface) object).realmGet$IsFirstLogin(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.IsDemoIndex, rowIndex, ((LoginResponseEntityRealmProxyInterface) object).realmGet$IsDemo(), false);
            String realmGet$FSMFullname = ((LoginResponseEntityRealmProxyInterface) object).realmGet$FSMFullname();
            if (realmGet$FSMFullname != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.FSMFullnameIndex, rowIndex, realmGet$FSMFullname, false);
            }
            String realmGet$FSMEmail = ((LoginResponseEntityRealmProxyInterface) object).realmGet$FSMEmail();
            if (realmGet$FSMEmail != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.FSMEmailIndex, rowIndex, realmGet$FSMEmail, false);
            }
            String realmGet$FSMMobile = ((LoginResponseEntityRealmProxyInterface) object).realmGet$FSMMobile();
            if (realmGet$FSMMobile != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.FSMMobileIndex, rowIndex, realmGet$FSMMobile, false);
            }
            String realmGet$FBACode = ((LoginResponseEntityRealmProxyInterface) object).realmGet$FBACode();
            if (realmGet$FBACode != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.FBACodeIndex, rowIndex, realmGet$FBACode, false);
            }
            String realmGet$Designation = ((LoginResponseEntityRealmProxyInterface) object).realmGet$Designation();
            if (realmGet$Designation != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.DesignationIndex, rowIndex, realmGet$Designation, false);
            }
            String realmGet$ProfPictName = ((LoginResponseEntityRealmProxyInterface) object).realmGet$ProfPictName();
            if (realmGet$ProfPictName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.ProfPictNameIndex, rowIndex, realmGet$ProfPictName, false);
            }
            String realmGet$FSMDesig = ((LoginResponseEntityRealmProxyInterface) object).realmGet$FSMDesig();
            if (realmGet$FSMDesig != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.FSMDesigIndex, rowIndex, realmGet$FSMDesig, false);
            }
            String realmGet$RegMACAddr = ((LoginResponseEntityRealmProxyInterface) object).realmGet$RegMACAddr();
            if (realmGet$RegMACAddr != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.RegMACAddrIndex, rowIndex, realmGet$RegMACAddr, false);
            }
            String realmGet$SuppMobiNumb = ((LoginResponseEntityRealmProxyInterface) object).realmGet$SuppMobiNumb();
            if (realmGet$SuppMobiNumb != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.SuppMobiNumbIndex, rowIndex, realmGet$SuppMobiNumb, false);
            }
            String realmGet$SuppEmailId = ((LoginResponseEntityRealmProxyInterface) object).realmGet$SuppEmailId();
            if (realmGet$SuppEmailId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.SuppEmailIdIndex, rowIndex, realmGet$SuppEmailId, false);
            }
            String realmGet$FBAStatus = ((LoginResponseEntityRealmProxyInterface) object).realmGet$FBAStatus();
            if (realmGet$FBAStatus != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.FBAStatusIndex, rowIndex, realmGet$FBAStatus, false);
            }
            String realmGet$POSPStatus = ((LoginResponseEntityRealmProxyInterface) object).realmGet$POSPStatus();
            if (realmGet$POSPStatus != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.POSPStatusIndex, rowIndex, realmGet$POSPStatus, false);
            }
            String realmGet$UserType = ((LoginResponseEntityRealmProxyInterface) object).realmGet$UserType();
            if (realmGet$UserType != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.UserTypeIndex, rowIndex, realmGet$UserType, false);
            }
            String realmGet$SuppAgenId = ((LoginResponseEntityRealmProxyInterface) object).realmGet$SuppAgenId();
            if (realmGet$SuppAgenId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.SuppAgenIdIndex, rowIndex, realmGet$SuppAgenId, false);
            }
            String realmGet$EditEmailId = ((LoginResponseEntityRealmProxyInterface) object).realmGet$EditEmailId();
            if (realmGet$EditEmailId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.EditEmailIdIndex, rowIndex, realmGet$EditEmailId, false);
            }
            String realmGet$EditMobiNumb = ((LoginResponseEntityRealmProxyInterface) object).realmGet$EditMobiNumb();
            if (realmGet$EditMobiNumb != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.EditMobiNumbIndex, rowIndex, realmGet$EditMobiNumb, false);
            }
            String realmGet$EditDesig = ((LoginResponseEntityRealmProxyInterface) object).realmGet$EditDesig();
            if (realmGet$EditDesig != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.EditDesigIndex, rowIndex, realmGet$EditDesig, false);
            }
            String realmGet$EditProfPictName = ((LoginResponseEntityRealmProxyInterface) object).realmGet$EditProfPictName();
            if (realmGet$EditProfPictName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.EditProfPictNameIndex, rowIndex, realmGet$EditProfPictName, false);
            }
            String realmGet$LoanId = ((LoginResponseEntityRealmProxyInterface) object).realmGet$LoanId();
            if (realmGet$LoanId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.LoanIdIndex, rowIndex, realmGet$LoanId, false);
            }
            String realmGet$PayStatus = ((LoginResponseEntityRealmProxyInterface) object).realmGet$PayStatus();
            if (realmGet$PayStatus != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.PayStatusIndex, rowIndex, realmGet$PayStatus, false);
            }
            String realmGet$CustID = ((LoginResponseEntityRealmProxyInterface) object).realmGet$CustID();
            if (realmGet$CustID != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.CustIDIndex, rowIndex, realmGet$CustID, false);
            }
            String realmGet$PaymentUrl = ((LoginResponseEntityRealmProxyInterface) object).realmGet$PaymentUrl();
            if (realmGet$PaymentUrl != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.PaymentUrlIndex, rowIndex, realmGet$PaymentUrl, false);
            }
            String realmGet$IsFoc = ((LoginResponseEntityRealmProxyInterface) object).realmGet$IsFoc();
            if (realmGet$IsFoc != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.IsFocIndex, rowIndex, realmGet$IsFoc, false);
            }
            String realmGet$POSPName = ((LoginResponseEntityRealmProxyInterface) object).realmGet$POSPName();
            if (realmGet$POSPName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.POSPNameIndex, rowIndex, realmGet$POSPName, false);
            }
            String realmGet$POSEmail = ((LoginResponseEntityRealmProxyInterface) object).realmGet$POSEmail();
            if (realmGet$POSEmail != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.POSEmailIndex, rowIndex, realmGet$POSEmail, false);
            }
            String realmGet$POSPMobile = ((LoginResponseEntityRealmProxyInterface) object).realmGet$POSPMobile();
            if (realmGet$POSPMobile != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.POSPMobileIndex, rowIndex, realmGet$POSPMobile, false);
            }
            String realmGet$SuccessStatus = ((LoginResponseEntityRealmProxyInterface) object).realmGet$SuccessStatus();
            if (realmGet$SuccessStatus != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.SuccessStatusIndex, rowIndex, realmGet$SuccessStatus, false);
            }
            String realmGet$POSPInfo = ((LoginResponseEntityRealmProxyInterface) object).realmGet$POSPInfo();
            if (realmGet$POSPInfo != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.POSPInfoIndex, rowIndex, realmGet$POSPInfo, false);
            }
            String realmGet$FSM = ((LoginResponseEntityRealmProxyInterface) object).realmGet$FSM();
            if (realmGet$FSM != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.FSMIndex, rowIndex, realmGet$FSM, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.rm_idIndex, rowIndex, ((LoginResponseEntityRealmProxyInterface) object).realmGet$rm_id(), false);
            String realmGet$referraid = ((LoginResponseEntityRealmProxyInterface) object).realmGet$referraid();
            if (realmGet$referraid != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.referraidIndex, rowIndex, realmGet$referraid, false);
            }
            String realmGet$POSPNo = ((LoginResponseEntityRealmProxyInterface) object).realmGet$POSPNo();
            if (realmGet$POSPNo != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.POSPNoIndex, rowIndex, realmGet$POSPNo, false);
            }
            String realmGet$POSPProfileUrl = ((LoginResponseEntityRealmProxyInterface) object).realmGet$POSPProfileUrl();
            if (realmGet$POSPProfileUrl != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.POSPProfileUrlIndex, rowIndex, realmGet$POSPProfileUrl, false);
            }
            String realmGet$FBAProfileUrl = ((LoginResponseEntityRealmProxyInterface) object).realmGet$FBAProfileUrl();
            if (realmGet$FBAProfileUrl != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.FBAProfileUrlIndex, rowIndex, realmGet$FBAProfileUrl, false);
            }
            String realmGet$referer_code = ((LoginResponseEntityRealmProxyInterface) object).realmGet$referer_code();
            if (realmGet$referer_code != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.referer_codeIndex, rowIndex, realmGet$referer_code, false);
            }
            String realmGet$IsUidLogin = ((LoginResponseEntityRealmProxyInterface) object).realmGet$IsUidLogin();
            if (realmGet$IsUidLogin != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.IsUidLoginIndex, rowIndex, realmGet$IsUidLogin, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity.class);
        long tableNativePtr = table.getNativePtr();
        LoginResponseEntityColumnInfo columnInfo = (LoginResponseEntityColumnInfo) realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity.class);
        long pkColumnIndex = columnInfo.FBAIdIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((LoginResponseEntityRealmProxyInterface) object).realmGet$FBAId();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((LoginResponseEntityRealmProxyInterface) object).realmGet$FBAId());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((LoginResponseEntityRealmProxyInterface) object).realmGet$FBAId());
        }
        cache.put(object, rowIndex);
        String realmGet$FullName = ((LoginResponseEntityRealmProxyInterface) object).realmGet$FullName();
        if (realmGet$FullName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.FullNameIndex, rowIndex, realmGet$FullName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.FullNameIndex, rowIndex, false);
        }
        String realmGet$UserName = ((LoginResponseEntityRealmProxyInterface) object).realmGet$UserName();
        if (realmGet$UserName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.UserNameIndex, rowIndex, realmGet$UserName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.UserNameIndex, rowIndex, false);
        }
        String realmGet$EmailID = ((LoginResponseEntityRealmProxyInterface) object).realmGet$EmailID();
        if (realmGet$EmailID != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.EmailIDIndex, rowIndex, realmGet$EmailID, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.EmailIDIndex, rowIndex, false);
        }
        String realmGet$MobiNumb1 = ((LoginResponseEntityRealmProxyInterface) object).realmGet$MobiNumb1();
        if (realmGet$MobiNumb1 != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.MobiNumb1Index, rowIndex, realmGet$MobiNumb1, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.MobiNumb1Index, rowIndex, false);
        }
        String realmGet$LiveURL = ((LoginResponseEntityRealmProxyInterface) object).realmGet$LiveURL();
        if (realmGet$LiveURL != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.LiveURLIndex, rowIndex, realmGet$LiveURL, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.LiveURLIndex, rowIndex, false);
        }
        String realmGet$LastloginDate = ((LoginResponseEntityRealmProxyInterface) object).realmGet$LastloginDate();
        if (realmGet$LastloginDate != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.LastloginDateIndex, rowIndex, realmGet$LastloginDate, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.LastloginDateIndex, rowIndex, false);
        }
        String realmGet$Validfrom = ((LoginResponseEntityRealmProxyInterface) object).realmGet$Validfrom();
        if (realmGet$Validfrom != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.ValidfromIndex, rowIndex, realmGet$Validfrom, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.ValidfromIndex, rowIndex, false);
        }
        String realmGet$RewardPoint = ((LoginResponseEntityRealmProxyInterface) object).realmGet$RewardPoint();
        if (realmGet$RewardPoint != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.RewardPointIndex, rowIndex, realmGet$RewardPoint, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.RewardPointIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.IsFirstLoginIndex, rowIndex, ((LoginResponseEntityRealmProxyInterface) object).realmGet$IsFirstLogin(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.IsDemoIndex, rowIndex, ((LoginResponseEntityRealmProxyInterface) object).realmGet$IsDemo(), false);
        String realmGet$FSMFullname = ((LoginResponseEntityRealmProxyInterface) object).realmGet$FSMFullname();
        if (realmGet$FSMFullname != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.FSMFullnameIndex, rowIndex, realmGet$FSMFullname, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.FSMFullnameIndex, rowIndex, false);
        }
        String realmGet$FSMEmail = ((LoginResponseEntityRealmProxyInterface) object).realmGet$FSMEmail();
        if (realmGet$FSMEmail != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.FSMEmailIndex, rowIndex, realmGet$FSMEmail, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.FSMEmailIndex, rowIndex, false);
        }
        String realmGet$FSMMobile = ((LoginResponseEntityRealmProxyInterface) object).realmGet$FSMMobile();
        if (realmGet$FSMMobile != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.FSMMobileIndex, rowIndex, realmGet$FSMMobile, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.FSMMobileIndex, rowIndex, false);
        }
        String realmGet$FBACode = ((LoginResponseEntityRealmProxyInterface) object).realmGet$FBACode();
        if (realmGet$FBACode != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.FBACodeIndex, rowIndex, realmGet$FBACode, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.FBACodeIndex, rowIndex, false);
        }
        String realmGet$Designation = ((LoginResponseEntityRealmProxyInterface) object).realmGet$Designation();
        if (realmGet$Designation != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.DesignationIndex, rowIndex, realmGet$Designation, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.DesignationIndex, rowIndex, false);
        }
        String realmGet$ProfPictName = ((LoginResponseEntityRealmProxyInterface) object).realmGet$ProfPictName();
        if (realmGet$ProfPictName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.ProfPictNameIndex, rowIndex, realmGet$ProfPictName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.ProfPictNameIndex, rowIndex, false);
        }
        String realmGet$FSMDesig = ((LoginResponseEntityRealmProxyInterface) object).realmGet$FSMDesig();
        if (realmGet$FSMDesig != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.FSMDesigIndex, rowIndex, realmGet$FSMDesig, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.FSMDesigIndex, rowIndex, false);
        }
        String realmGet$RegMACAddr = ((LoginResponseEntityRealmProxyInterface) object).realmGet$RegMACAddr();
        if (realmGet$RegMACAddr != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.RegMACAddrIndex, rowIndex, realmGet$RegMACAddr, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.RegMACAddrIndex, rowIndex, false);
        }
        String realmGet$SuppMobiNumb = ((LoginResponseEntityRealmProxyInterface) object).realmGet$SuppMobiNumb();
        if (realmGet$SuppMobiNumb != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.SuppMobiNumbIndex, rowIndex, realmGet$SuppMobiNumb, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.SuppMobiNumbIndex, rowIndex, false);
        }
        String realmGet$SuppEmailId = ((LoginResponseEntityRealmProxyInterface) object).realmGet$SuppEmailId();
        if (realmGet$SuppEmailId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.SuppEmailIdIndex, rowIndex, realmGet$SuppEmailId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.SuppEmailIdIndex, rowIndex, false);
        }
        String realmGet$FBAStatus = ((LoginResponseEntityRealmProxyInterface) object).realmGet$FBAStatus();
        if (realmGet$FBAStatus != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.FBAStatusIndex, rowIndex, realmGet$FBAStatus, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.FBAStatusIndex, rowIndex, false);
        }
        String realmGet$POSPStatus = ((LoginResponseEntityRealmProxyInterface) object).realmGet$POSPStatus();
        if (realmGet$POSPStatus != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.POSPStatusIndex, rowIndex, realmGet$POSPStatus, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.POSPStatusIndex, rowIndex, false);
        }
        String realmGet$UserType = ((LoginResponseEntityRealmProxyInterface) object).realmGet$UserType();
        if (realmGet$UserType != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.UserTypeIndex, rowIndex, realmGet$UserType, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.UserTypeIndex, rowIndex, false);
        }
        String realmGet$SuppAgenId = ((LoginResponseEntityRealmProxyInterface) object).realmGet$SuppAgenId();
        if (realmGet$SuppAgenId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.SuppAgenIdIndex, rowIndex, realmGet$SuppAgenId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.SuppAgenIdIndex, rowIndex, false);
        }
        String realmGet$EditEmailId = ((LoginResponseEntityRealmProxyInterface) object).realmGet$EditEmailId();
        if (realmGet$EditEmailId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.EditEmailIdIndex, rowIndex, realmGet$EditEmailId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.EditEmailIdIndex, rowIndex, false);
        }
        String realmGet$EditMobiNumb = ((LoginResponseEntityRealmProxyInterface) object).realmGet$EditMobiNumb();
        if (realmGet$EditMobiNumb != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.EditMobiNumbIndex, rowIndex, realmGet$EditMobiNumb, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.EditMobiNumbIndex, rowIndex, false);
        }
        String realmGet$EditDesig = ((LoginResponseEntityRealmProxyInterface) object).realmGet$EditDesig();
        if (realmGet$EditDesig != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.EditDesigIndex, rowIndex, realmGet$EditDesig, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.EditDesigIndex, rowIndex, false);
        }
        String realmGet$EditProfPictName = ((LoginResponseEntityRealmProxyInterface) object).realmGet$EditProfPictName();
        if (realmGet$EditProfPictName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.EditProfPictNameIndex, rowIndex, realmGet$EditProfPictName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.EditProfPictNameIndex, rowIndex, false);
        }
        String realmGet$LoanId = ((LoginResponseEntityRealmProxyInterface) object).realmGet$LoanId();
        if (realmGet$LoanId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.LoanIdIndex, rowIndex, realmGet$LoanId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.LoanIdIndex, rowIndex, false);
        }
        String realmGet$PayStatus = ((LoginResponseEntityRealmProxyInterface) object).realmGet$PayStatus();
        if (realmGet$PayStatus != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.PayStatusIndex, rowIndex, realmGet$PayStatus, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.PayStatusIndex, rowIndex, false);
        }
        String realmGet$CustID = ((LoginResponseEntityRealmProxyInterface) object).realmGet$CustID();
        if (realmGet$CustID != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.CustIDIndex, rowIndex, realmGet$CustID, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.CustIDIndex, rowIndex, false);
        }
        String realmGet$PaymentUrl = ((LoginResponseEntityRealmProxyInterface) object).realmGet$PaymentUrl();
        if (realmGet$PaymentUrl != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.PaymentUrlIndex, rowIndex, realmGet$PaymentUrl, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.PaymentUrlIndex, rowIndex, false);
        }
        String realmGet$IsFoc = ((LoginResponseEntityRealmProxyInterface) object).realmGet$IsFoc();
        if (realmGet$IsFoc != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.IsFocIndex, rowIndex, realmGet$IsFoc, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.IsFocIndex, rowIndex, false);
        }
        String realmGet$POSPName = ((LoginResponseEntityRealmProxyInterface) object).realmGet$POSPName();
        if (realmGet$POSPName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.POSPNameIndex, rowIndex, realmGet$POSPName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.POSPNameIndex, rowIndex, false);
        }
        String realmGet$POSEmail = ((LoginResponseEntityRealmProxyInterface) object).realmGet$POSEmail();
        if (realmGet$POSEmail != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.POSEmailIndex, rowIndex, realmGet$POSEmail, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.POSEmailIndex, rowIndex, false);
        }
        String realmGet$POSPMobile = ((LoginResponseEntityRealmProxyInterface) object).realmGet$POSPMobile();
        if (realmGet$POSPMobile != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.POSPMobileIndex, rowIndex, realmGet$POSPMobile, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.POSPMobileIndex, rowIndex, false);
        }
        String realmGet$SuccessStatus = ((LoginResponseEntityRealmProxyInterface) object).realmGet$SuccessStatus();
        if (realmGet$SuccessStatus != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.SuccessStatusIndex, rowIndex, realmGet$SuccessStatus, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.SuccessStatusIndex, rowIndex, false);
        }
        String realmGet$POSPInfo = ((LoginResponseEntityRealmProxyInterface) object).realmGet$POSPInfo();
        if (realmGet$POSPInfo != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.POSPInfoIndex, rowIndex, realmGet$POSPInfo, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.POSPInfoIndex, rowIndex, false);
        }
        String realmGet$FSM = ((LoginResponseEntityRealmProxyInterface) object).realmGet$FSM();
        if (realmGet$FSM != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.FSMIndex, rowIndex, realmGet$FSM, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.FSMIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.rm_idIndex, rowIndex, ((LoginResponseEntityRealmProxyInterface) object).realmGet$rm_id(), false);
        String realmGet$referraid = ((LoginResponseEntityRealmProxyInterface) object).realmGet$referraid();
        if (realmGet$referraid != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.referraidIndex, rowIndex, realmGet$referraid, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.referraidIndex, rowIndex, false);
        }
        String realmGet$POSPNo = ((LoginResponseEntityRealmProxyInterface) object).realmGet$POSPNo();
        if (realmGet$POSPNo != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.POSPNoIndex, rowIndex, realmGet$POSPNo, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.POSPNoIndex, rowIndex, false);
        }
        String realmGet$POSPProfileUrl = ((LoginResponseEntityRealmProxyInterface) object).realmGet$POSPProfileUrl();
        if (realmGet$POSPProfileUrl != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.POSPProfileUrlIndex, rowIndex, realmGet$POSPProfileUrl, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.POSPProfileUrlIndex, rowIndex, false);
        }
        String realmGet$FBAProfileUrl = ((LoginResponseEntityRealmProxyInterface) object).realmGet$FBAProfileUrl();
        if (realmGet$FBAProfileUrl != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.FBAProfileUrlIndex, rowIndex, realmGet$FBAProfileUrl, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.FBAProfileUrlIndex, rowIndex, false);
        }
        String realmGet$referer_code = ((LoginResponseEntityRealmProxyInterface) object).realmGet$referer_code();
        if (realmGet$referer_code != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.referer_codeIndex, rowIndex, realmGet$referer_code, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.referer_codeIndex, rowIndex, false);
        }
        String realmGet$IsUidLogin = ((LoginResponseEntityRealmProxyInterface) object).realmGet$IsUidLogin();
        if (realmGet$IsUidLogin != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.IsUidLoginIndex, rowIndex, realmGet$IsUidLogin, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.IsUidLoginIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity.class);
        long tableNativePtr = table.getNativePtr();
        LoginResponseEntityColumnInfo columnInfo = (LoginResponseEntityColumnInfo) realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity.class);
        long pkColumnIndex = columnInfo.FBAIdIndex;
        magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity object = null;
        while (objects.hasNext()) {
            object = (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((LoginResponseEntityRealmProxyInterface) object).realmGet$FBAId();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((LoginResponseEntityRealmProxyInterface) object).realmGet$FBAId());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((LoginResponseEntityRealmProxyInterface) object).realmGet$FBAId());
            }
            cache.put(object, rowIndex);
            String realmGet$FullName = ((LoginResponseEntityRealmProxyInterface) object).realmGet$FullName();
            if (realmGet$FullName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.FullNameIndex, rowIndex, realmGet$FullName, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.FullNameIndex, rowIndex, false);
            }
            String realmGet$UserName = ((LoginResponseEntityRealmProxyInterface) object).realmGet$UserName();
            if (realmGet$UserName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.UserNameIndex, rowIndex, realmGet$UserName, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.UserNameIndex, rowIndex, false);
            }
            String realmGet$EmailID = ((LoginResponseEntityRealmProxyInterface) object).realmGet$EmailID();
            if (realmGet$EmailID != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.EmailIDIndex, rowIndex, realmGet$EmailID, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.EmailIDIndex, rowIndex, false);
            }
            String realmGet$MobiNumb1 = ((LoginResponseEntityRealmProxyInterface) object).realmGet$MobiNumb1();
            if (realmGet$MobiNumb1 != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.MobiNumb1Index, rowIndex, realmGet$MobiNumb1, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.MobiNumb1Index, rowIndex, false);
            }
            String realmGet$LiveURL = ((LoginResponseEntityRealmProxyInterface) object).realmGet$LiveURL();
            if (realmGet$LiveURL != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.LiveURLIndex, rowIndex, realmGet$LiveURL, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.LiveURLIndex, rowIndex, false);
            }
            String realmGet$LastloginDate = ((LoginResponseEntityRealmProxyInterface) object).realmGet$LastloginDate();
            if (realmGet$LastloginDate != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.LastloginDateIndex, rowIndex, realmGet$LastloginDate, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.LastloginDateIndex, rowIndex, false);
            }
            String realmGet$Validfrom = ((LoginResponseEntityRealmProxyInterface) object).realmGet$Validfrom();
            if (realmGet$Validfrom != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.ValidfromIndex, rowIndex, realmGet$Validfrom, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.ValidfromIndex, rowIndex, false);
            }
            String realmGet$RewardPoint = ((LoginResponseEntityRealmProxyInterface) object).realmGet$RewardPoint();
            if (realmGet$RewardPoint != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.RewardPointIndex, rowIndex, realmGet$RewardPoint, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.RewardPointIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.IsFirstLoginIndex, rowIndex, ((LoginResponseEntityRealmProxyInterface) object).realmGet$IsFirstLogin(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.IsDemoIndex, rowIndex, ((LoginResponseEntityRealmProxyInterface) object).realmGet$IsDemo(), false);
            String realmGet$FSMFullname = ((LoginResponseEntityRealmProxyInterface) object).realmGet$FSMFullname();
            if (realmGet$FSMFullname != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.FSMFullnameIndex, rowIndex, realmGet$FSMFullname, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.FSMFullnameIndex, rowIndex, false);
            }
            String realmGet$FSMEmail = ((LoginResponseEntityRealmProxyInterface) object).realmGet$FSMEmail();
            if (realmGet$FSMEmail != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.FSMEmailIndex, rowIndex, realmGet$FSMEmail, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.FSMEmailIndex, rowIndex, false);
            }
            String realmGet$FSMMobile = ((LoginResponseEntityRealmProxyInterface) object).realmGet$FSMMobile();
            if (realmGet$FSMMobile != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.FSMMobileIndex, rowIndex, realmGet$FSMMobile, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.FSMMobileIndex, rowIndex, false);
            }
            String realmGet$FBACode = ((LoginResponseEntityRealmProxyInterface) object).realmGet$FBACode();
            if (realmGet$FBACode != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.FBACodeIndex, rowIndex, realmGet$FBACode, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.FBACodeIndex, rowIndex, false);
            }
            String realmGet$Designation = ((LoginResponseEntityRealmProxyInterface) object).realmGet$Designation();
            if (realmGet$Designation != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.DesignationIndex, rowIndex, realmGet$Designation, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.DesignationIndex, rowIndex, false);
            }
            String realmGet$ProfPictName = ((LoginResponseEntityRealmProxyInterface) object).realmGet$ProfPictName();
            if (realmGet$ProfPictName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.ProfPictNameIndex, rowIndex, realmGet$ProfPictName, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.ProfPictNameIndex, rowIndex, false);
            }
            String realmGet$FSMDesig = ((LoginResponseEntityRealmProxyInterface) object).realmGet$FSMDesig();
            if (realmGet$FSMDesig != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.FSMDesigIndex, rowIndex, realmGet$FSMDesig, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.FSMDesigIndex, rowIndex, false);
            }
            String realmGet$RegMACAddr = ((LoginResponseEntityRealmProxyInterface) object).realmGet$RegMACAddr();
            if (realmGet$RegMACAddr != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.RegMACAddrIndex, rowIndex, realmGet$RegMACAddr, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.RegMACAddrIndex, rowIndex, false);
            }
            String realmGet$SuppMobiNumb = ((LoginResponseEntityRealmProxyInterface) object).realmGet$SuppMobiNumb();
            if (realmGet$SuppMobiNumb != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.SuppMobiNumbIndex, rowIndex, realmGet$SuppMobiNumb, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.SuppMobiNumbIndex, rowIndex, false);
            }
            String realmGet$SuppEmailId = ((LoginResponseEntityRealmProxyInterface) object).realmGet$SuppEmailId();
            if (realmGet$SuppEmailId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.SuppEmailIdIndex, rowIndex, realmGet$SuppEmailId, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.SuppEmailIdIndex, rowIndex, false);
            }
            String realmGet$FBAStatus = ((LoginResponseEntityRealmProxyInterface) object).realmGet$FBAStatus();
            if (realmGet$FBAStatus != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.FBAStatusIndex, rowIndex, realmGet$FBAStatus, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.FBAStatusIndex, rowIndex, false);
            }
            String realmGet$POSPStatus = ((LoginResponseEntityRealmProxyInterface) object).realmGet$POSPStatus();
            if (realmGet$POSPStatus != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.POSPStatusIndex, rowIndex, realmGet$POSPStatus, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.POSPStatusIndex, rowIndex, false);
            }
            String realmGet$UserType = ((LoginResponseEntityRealmProxyInterface) object).realmGet$UserType();
            if (realmGet$UserType != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.UserTypeIndex, rowIndex, realmGet$UserType, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.UserTypeIndex, rowIndex, false);
            }
            String realmGet$SuppAgenId = ((LoginResponseEntityRealmProxyInterface) object).realmGet$SuppAgenId();
            if (realmGet$SuppAgenId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.SuppAgenIdIndex, rowIndex, realmGet$SuppAgenId, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.SuppAgenIdIndex, rowIndex, false);
            }
            String realmGet$EditEmailId = ((LoginResponseEntityRealmProxyInterface) object).realmGet$EditEmailId();
            if (realmGet$EditEmailId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.EditEmailIdIndex, rowIndex, realmGet$EditEmailId, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.EditEmailIdIndex, rowIndex, false);
            }
            String realmGet$EditMobiNumb = ((LoginResponseEntityRealmProxyInterface) object).realmGet$EditMobiNumb();
            if (realmGet$EditMobiNumb != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.EditMobiNumbIndex, rowIndex, realmGet$EditMobiNumb, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.EditMobiNumbIndex, rowIndex, false);
            }
            String realmGet$EditDesig = ((LoginResponseEntityRealmProxyInterface) object).realmGet$EditDesig();
            if (realmGet$EditDesig != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.EditDesigIndex, rowIndex, realmGet$EditDesig, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.EditDesigIndex, rowIndex, false);
            }
            String realmGet$EditProfPictName = ((LoginResponseEntityRealmProxyInterface) object).realmGet$EditProfPictName();
            if (realmGet$EditProfPictName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.EditProfPictNameIndex, rowIndex, realmGet$EditProfPictName, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.EditProfPictNameIndex, rowIndex, false);
            }
            String realmGet$LoanId = ((LoginResponseEntityRealmProxyInterface) object).realmGet$LoanId();
            if (realmGet$LoanId != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.LoanIdIndex, rowIndex, realmGet$LoanId, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.LoanIdIndex, rowIndex, false);
            }
            String realmGet$PayStatus = ((LoginResponseEntityRealmProxyInterface) object).realmGet$PayStatus();
            if (realmGet$PayStatus != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.PayStatusIndex, rowIndex, realmGet$PayStatus, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.PayStatusIndex, rowIndex, false);
            }
            String realmGet$CustID = ((LoginResponseEntityRealmProxyInterface) object).realmGet$CustID();
            if (realmGet$CustID != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.CustIDIndex, rowIndex, realmGet$CustID, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.CustIDIndex, rowIndex, false);
            }
            String realmGet$PaymentUrl = ((LoginResponseEntityRealmProxyInterface) object).realmGet$PaymentUrl();
            if (realmGet$PaymentUrl != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.PaymentUrlIndex, rowIndex, realmGet$PaymentUrl, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.PaymentUrlIndex, rowIndex, false);
            }
            String realmGet$IsFoc = ((LoginResponseEntityRealmProxyInterface) object).realmGet$IsFoc();
            if (realmGet$IsFoc != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.IsFocIndex, rowIndex, realmGet$IsFoc, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.IsFocIndex, rowIndex, false);
            }
            String realmGet$POSPName = ((LoginResponseEntityRealmProxyInterface) object).realmGet$POSPName();
            if (realmGet$POSPName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.POSPNameIndex, rowIndex, realmGet$POSPName, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.POSPNameIndex, rowIndex, false);
            }
            String realmGet$POSEmail = ((LoginResponseEntityRealmProxyInterface) object).realmGet$POSEmail();
            if (realmGet$POSEmail != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.POSEmailIndex, rowIndex, realmGet$POSEmail, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.POSEmailIndex, rowIndex, false);
            }
            String realmGet$POSPMobile = ((LoginResponseEntityRealmProxyInterface) object).realmGet$POSPMobile();
            if (realmGet$POSPMobile != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.POSPMobileIndex, rowIndex, realmGet$POSPMobile, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.POSPMobileIndex, rowIndex, false);
            }
            String realmGet$SuccessStatus = ((LoginResponseEntityRealmProxyInterface) object).realmGet$SuccessStatus();
            if (realmGet$SuccessStatus != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.SuccessStatusIndex, rowIndex, realmGet$SuccessStatus, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.SuccessStatusIndex, rowIndex, false);
            }
            String realmGet$POSPInfo = ((LoginResponseEntityRealmProxyInterface) object).realmGet$POSPInfo();
            if (realmGet$POSPInfo != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.POSPInfoIndex, rowIndex, realmGet$POSPInfo, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.POSPInfoIndex, rowIndex, false);
            }
            String realmGet$FSM = ((LoginResponseEntityRealmProxyInterface) object).realmGet$FSM();
            if (realmGet$FSM != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.FSMIndex, rowIndex, realmGet$FSM, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.FSMIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.rm_idIndex, rowIndex, ((LoginResponseEntityRealmProxyInterface) object).realmGet$rm_id(), false);
            String realmGet$referraid = ((LoginResponseEntityRealmProxyInterface) object).realmGet$referraid();
            if (realmGet$referraid != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.referraidIndex, rowIndex, realmGet$referraid, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.referraidIndex, rowIndex, false);
            }
            String realmGet$POSPNo = ((LoginResponseEntityRealmProxyInterface) object).realmGet$POSPNo();
            if (realmGet$POSPNo != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.POSPNoIndex, rowIndex, realmGet$POSPNo, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.POSPNoIndex, rowIndex, false);
            }
            String realmGet$POSPProfileUrl = ((LoginResponseEntityRealmProxyInterface) object).realmGet$POSPProfileUrl();
            if (realmGet$POSPProfileUrl != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.POSPProfileUrlIndex, rowIndex, realmGet$POSPProfileUrl, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.POSPProfileUrlIndex, rowIndex, false);
            }
            String realmGet$FBAProfileUrl = ((LoginResponseEntityRealmProxyInterface) object).realmGet$FBAProfileUrl();
            if (realmGet$FBAProfileUrl != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.FBAProfileUrlIndex, rowIndex, realmGet$FBAProfileUrl, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.FBAProfileUrlIndex, rowIndex, false);
            }
            String realmGet$referer_code = ((LoginResponseEntityRealmProxyInterface) object).realmGet$referer_code();
            if (realmGet$referer_code != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.referer_codeIndex, rowIndex, realmGet$referer_code, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.referer_codeIndex, rowIndex, false);
            }
            String realmGet$IsUidLogin = ((LoginResponseEntityRealmProxyInterface) object).realmGet$IsUidLogin();
            if (realmGet$IsUidLogin != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.IsUidLoginIndex, rowIndex, realmGet$IsUidLogin, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.IsUidLoginIndex, rowIndex, false);
            }
        }
    }

    public static magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity createDetachedCopy(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity) cachedObject.object;
            }
            unmanagedObject = (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        LoginResponseEntityRealmProxyInterface unmanagedCopy = (LoginResponseEntityRealmProxyInterface) unmanagedObject;
        LoginResponseEntityRealmProxyInterface realmSource = (LoginResponseEntityRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$FBAId(realmSource.realmGet$FBAId());
        unmanagedCopy.realmSet$FullName(realmSource.realmGet$FullName());
        unmanagedCopy.realmSet$UserName(realmSource.realmGet$UserName());
        unmanagedCopy.realmSet$EmailID(realmSource.realmGet$EmailID());
        unmanagedCopy.realmSet$MobiNumb1(realmSource.realmGet$MobiNumb1());
        unmanagedCopy.realmSet$LiveURL(realmSource.realmGet$LiveURL());
        unmanagedCopy.realmSet$LastloginDate(realmSource.realmGet$LastloginDate());
        unmanagedCopy.realmSet$Validfrom(realmSource.realmGet$Validfrom());
        unmanagedCopy.realmSet$RewardPoint(realmSource.realmGet$RewardPoint());
        unmanagedCopy.realmSet$IsFirstLogin(realmSource.realmGet$IsFirstLogin());
        unmanagedCopy.realmSet$IsDemo(realmSource.realmGet$IsDemo());
        unmanagedCopy.realmSet$FSMFullname(realmSource.realmGet$FSMFullname());
        unmanagedCopy.realmSet$FSMEmail(realmSource.realmGet$FSMEmail());
        unmanagedCopy.realmSet$FSMMobile(realmSource.realmGet$FSMMobile());
        unmanagedCopy.realmSet$FBACode(realmSource.realmGet$FBACode());
        unmanagedCopy.realmSet$Designation(realmSource.realmGet$Designation());
        unmanagedCopy.realmSet$ProfPictName(realmSource.realmGet$ProfPictName());
        unmanagedCopy.realmSet$FSMDesig(realmSource.realmGet$FSMDesig());
        unmanagedCopy.realmSet$RegMACAddr(realmSource.realmGet$RegMACAddr());
        unmanagedCopy.realmSet$SuppMobiNumb(realmSource.realmGet$SuppMobiNumb());
        unmanagedCopy.realmSet$SuppEmailId(realmSource.realmGet$SuppEmailId());
        unmanagedCopy.realmSet$FBAStatus(realmSource.realmGet$FBAStatus());
        unmanagedCopy.realmSet$POSPStatus(realmSource.realmGet$POSPStatus());
        unmanagedCopy.realmSet$UserType(realmSource.realmGet$UserType());
        unmanagedCopy.realmSet$SuppAgenId(realmSource.realmGet$SuppAgenId());
        unmanagedCopy.realmSet$EditEmailId(realmSource.realmGet$EditEmailId());
        unmanagedCopy.realmSet$EditMobiNumb(realmSource.realmGet$EditMobiNumb());
        unmanagedCopy.realmSet$EditDesig(realmSource.realmGet$EditDesig());
        unmanagedCopy.realmSet$EditProfPictName(realmSource.realmGet$EditProfPictName());
        unmanagedCopy.realmSet$LoanId(realmSource.realmGet$LoanId());
        unmanagedCopy.realmSet$PayStatus(realmSource.realmGet$PayStatus());
        unmanagedCopy.realmSet$CustID(realmSource.realmGet$CustID());
        unmanagedCopy.realmSet$PaymentUrl(realmSource.realmGet$PaymentUrl());
        unmanagedCopy.realmSet$IsFoc(realmSource.realmGet$IsFoc());
        unmanagedCopy.realmSet$POSPName(realmSource.realmGet$POSPName());
        unmanagedCopy.realmSet$POSEmail(realmSource.realmGet$POSEmail());
        unmanagedCopy.realmSet$POSPMobile(realmSource.realmGet$POSPMobile());
        unmanagedCopy.realmSet$SuccessStatus(realmSource.realmGet$SuccessStatus());
        unmanagedCopy.realmSet$POSPInfo(realmSource.realmGet$POSPInfo());
        unmanagedCopy.realmSet$FSM(realmSource.realmGet$FSM());
        unmanagedCopy.realmSet$rm_id(realmSource.realmGet$rm_id());
        unmanagedCopy.realmSet$referraid(realmSource.realmGet$referraid());
        unmanagedCopy.realmSet$POSPNo(realmSource.realmGet$POSPNo());
        unmanagedCopy.realmSet$POSPProfileUrl(realmSource.realmGet$POSPProfileUrl());
        unmanagedCopy.realmSet$FBAProfileUrl(realmSource.realmGet$FBAProfileUrl());
        unmanagedCopy.realmSet$referer_code(realmSource.realmGet$referer_code());
        unmanagedCopy.realmSet$IsUidLogin(realmSource.realmGet$IsUidLogin());

        return unmanagedObject;
    }

    static magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity update(Realm realm, magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity realmObject, magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity newObject, Map<RealmModel, RealmObjectProxy> cache) {
        LoginResponseEntityRealmProxyInterface realmObjectTarget = (LoginResponseEntityRealmProxyInterface) realmObject;
        LoginResponseEntityRealmProxyInterface realmObjectSource = (LoginResponseEntityRealmProxyInterface) newObject;
        realmObjectTarget.realmSet$FullName(realmObjectSource.realmGet$FullName());
        realmObjectTarget.realmSet$UserName(realmObjectSource.realmGet$UserName());
        realmObjectTarget.realmSet$EmailID(realmObjectSource.realmGet$EmailID());
        realmObjectTarget.realmSet$MobiNumb1(realmObjectSource.realmGet$MobiNumb1());
        realmObjectTarget.realmSet$LiveURL(realmObjectSource.realmGet$LiveURL());
        realmObjectTarget.realmSet$LastloginDate(realmObjectSource.realmGet$LastloginDate());
        realmObjectTarget.realmSet$Validfrom(realmObjectSource.realmGet$Validfrom());
        realmObjectTarget.realmSet$RewardPoint(realmObjectSource.realmGet$RewardPoint());
        realmObjectTarget.realmSet$IsFirstLogin(realmObjectSource.realmGet$IsFirstLogin());
        realmObjectTarget.realmSet$IsDemo(realmObjectSource.realmGet$IsDemo());
        realmObjectTarget.realmSet$FSMFullname(realmObjectSource.realmGet$FSMFullname());
        realmObjectTarget.realmSet$FSMEmail(realmObjectSource.realmGet$FSMEmail());
        realmObjectTarget.realmSet$FSMMobile(realmObjectSource.realmGet$FSMMobile());
        realmObjectTarget.realmSet$FBACode(realmObjectSource.realmGet$FBACode());
        realmObjectTarget.realmSet$Designation(realmObjectSource.realmGet$Designation());
        realmObjectTarget.realmSet$ProfPictName(realmObjectSource.realmGet$ProfPictName());
        realmObjectTarget.realmSet$FSMDesig(realmObjectSource.realmGet$FSMDesig());
        realmObjectTarget.realmSet$RegMACAddr(realmObjectSource.realmGet$RegMACAddr());
        realmObjectTarget.realmSet$SuppMobiNumb(realmObjectSource.realmGet$SuppMobiNumb());
        realmObjectTarget.realmSet$SuppEmailId(realmObjectSource.realmGet$SuppEmailId());
        realmObjectTarget.realmSet$FBAStatus(realmObjectSource.realmGet$FBAStatus());
        realmObjectTarget.realmSet$POSPStatus(realmObjectSource.realmGet$POSPStatus());
        realmObjectTarget.realmSet$UserType(realmObjectSource.realmGet$UserType());
        realmObjectTarget.realmSet$SuppAgenId(realmObjectSource.realmGet$SuppAgenId());
        realmObjectTarget.realmSet$EditEmailId(realmObjectSource.realmGet$EditEmailId());
        realmObjectTarget.realmSet$EditMobiNumb(realmObjectSource.realmGet$EditMobiNumb());
        realmObjectTarget.realmSet$EditDesig(realmObjectSource.realmGet$EditDesig());
        realmObjectTarget.realmSet$EditProfPictName(realmObjectSource.realmGet$EditProfPictName());
        realmObjectTarget.realmSet$LoanId(realmObjectSource.realmGet$LoanId());
        realmObjectTarget.realmSet$PayStatus(realmObjectSource.realmGet$PayStatus());
        realmObjectTarget.realmSet$CustID(realmObjectSource.realmGet$CustID());
        realmObjectTarget.realmSet$PaymentUrl(realmObjectSource.realmGet$PaymentUrl());
        realmObjectTarget.realmSet$IsFoc(realmObjectSource.realmGet$IsFoc());
        realmObjectTarget.realmSet$POSPName(realmObjectSource.realmGet$POSPName());
        realmObjectTarget.realmSet$POSEmail(realmObjectSource.realmGet$POSEmail());
        realmObjectTarget.realmSet$POSPMobile(realmObjectSource.realmGet$POSPMobile());
        realmObjectTarget.realmSet$SuccessStatus(realmObjectSource.realmGet$SuccessStatus());
        realmObjectTarget.realmSet$POSPInfo(realmObjectSource.realmGet$POSPInfo());
        realmObjectTarget.realmSet$FSM(realmObjectSource.realmGet$FSM());
        realmObjectTarget.realmSet$rm_id(realmObjectSource.realmGet$rm_id());
        realmObjectTarget.realmSet$referraid(realmObjectSource.realmGet$referraid());
        realmObjectTarget.realmSet$POSPNo(realmObjectSource.realmGet$POSPNo());
        realmObjectTarget.realmSet$POSPProfileUrl(realmObjectSource.realmGet$POSPProfileUrl());
        realmObjectTarget.realmSet$FBAProfileUrl(realmObjectSource.realmGet$FBAProfileUrl());
        realmObjectTarget.realmSet$referer_code(realmObjectSource.realmGet$referer_code());
        realmObjectTarget.realmSet$IsUidLogin(realmObjectSource.realmGet$IsUidLogin());
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("LoginResponseEntity = proxy[");
        stringBuilder.append("{FBAId:");
        stringBuilder.append(realmGet$FBAId());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{FullName:");
        stringBuilder.append(realmGet$FullName() != null ? realmGet$FullName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{UserName:");
        stringBuilder.append(realmGet$UserName() != null ? realmGet$UserName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{EmailID:");
        stringBuilder.append(realmGet$EmailID() != null ? realmGet$EmailID() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{MobiNumb1:");
        stringBuilder.append(realmGet$MobiNumb1() != null ? realmGet$MobiNumb1() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{LiveURL:");
        stringBuilder.append(realmGet$LiveURL() != null ? realmGet$LiveURL() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{LastloginDate:");
        stringBuilder.append(realmGet$LastloginDate() != null ? realmGet$LastloginDate() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{Validfrom:");
        stringBuilder.append(realmGet$Validfrom() != null ? realmGet$Validfrom() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{RewardPoint:");
        stringBuilder.append(realmGet$RewardPoint() != null ? realmGet$RewardPoint() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{IsFirstLogin:");
        stringBuilder.append(realmGet$IsFirstLogin());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{IsDemo:");
        stringBuilder.append(realmGet$IsDemo());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{FSMFullname:");
        stringBuilder.append(realmGet$FSMFullname() != null ? realmGet$FSMFullname() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{FSMEmail:");
        stringBuilder.append(realmGet$FSMEmail() != null ? realmGet$FSMEmail() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{FSMMobile:");
        stringBuilder.append(realmGet$FSMMobile() != null ? realmGet$FSMMobile() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{FBACode:");
        stringBuilder.append(realmGet$FBACode() != null ? realmGet$FBACode() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{Designation:");
        stringBuilder.append(realmGet$Designation() != null ? realmGet$Designation() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{ProfPictName:");
        stringBuilder.append(realmGet$ProfPictName() != null ? realmGet$ProfPictName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{FSMDesig:");
        stringBuilder.append(realmGet$FSMDesig() != null ? realmGet$FSMDesig() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{RegMACAddr:");
        stringBuilder.append(realmGet$RegMACAddr() != null ? realmGet$RegMACAddr() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{SuppMobiNumb:");
        stringBuilder.append(realmGet$SuppMobiNumb() != null ? realmGet$SuppMobiNumb() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{SuppEmailId:");
        stringBuilder.append(realmGet$SuppEmailId() != null ? realmGet$SuppEmailId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{FBAStatus:");
        stringBuilder.append(realmGet$FBAStatus() != null ? realmGet$FBAStatus() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{POSPStatus:");
        stringBuilder.append(realmGet$POSPStatus() != null ? realmGet$POSPStatus() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{UserType:");
        stringBuilder.append(realmGet$UserType() != null ? realmGet$UserType() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{SuppAgenId:");
        stringBuilder.append(realmGet$SuppAgenId() != null ? realmGet$SuppAgenId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{EditEmailId:");
        stringBuilder.append(realmGet$EditEmailId() != null ? realmGet$EditEmailId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{EditMobiNumb:");
        stringBuilder.append(realmGet$EditMobiNumb() != null ? realmGet$EditMobiNumb() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{EditDesig:");
        stringBuilder.append(realmGet$EditDesig() != null ? realmGet$EditDesig() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{EditProfPictName:");
        stringBuilder.append(realmGet$EditProfPictName() != null ? realmGet$EditProfPictName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{LoanId:");
        stringBuilder.append(realmGet$LoanId() != null ? realmGet$LoanId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{PayStatus:");
        stringBuilder.append(realmGet$PayStatus() != null ? realmGet$PayStatus() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{CustID:");
        stringBuilder.append(realmGet$CustID() != null ? realmGet$CustID() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{PaymentUrl:");
        stringBuilder.append(realmGet$PaymentUrl() != null ? realmGet$PaymentUrl() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{IsFoc:");
        stringBuilder.append(realmGet$IsFoc() != null ? realmGet$IsFoc() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{POSPName:");
        stringBuilder.append(realmGet$POSPName() != null ? realmGet$POSPName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{POSEmail:");
        stringBuilder.append(realmGet$POSEmail() != null ? realmGet$POSEmail() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{POSPMobile:");
        stringBuilder.append(realmGet$POSPMobile() != null ? realmGet$POSPMobile() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{SuccessStatus:");
        stringBuilder.append(realmGet$SuccessStatus() != null ? realmGet$SuccessStatus() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{POSPInfo:");
        stringBuilder.append(realmGet$POSPInfo() != null ? realmGet$POSPInfo() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{FSM:");
        stringBuilder.append(realmGet$FSM() != null ? realmGet$FSM() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{rm_id:");
        stringBuilder.append(realmGet$rm_id());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{referraid:");
        stringBuilder.append(realmGet$referraid() != null ? realmGet$referraid() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{POSPNo:");
        stringBuilder.append(realmGet$POSPNo() != null ? realmGet$POSPNo() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{POSPProfileUrl:");
        stringBuilder.append(realmGet$POSPProfileUrl() != null ? realmGet$POSPProfileUrl() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{FBAProfileUrl:");
        stringBuilder.append(realmGet$FBAProfileUrl() != null ? realmGet$FBAProfileUrl() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{referer_code:");
        stringBuilder.append(realmGet$referer_code() != null ? realmGet$referer_code() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{IsUidLogin:");
        stringBuilder.append(realmGet$IsUidLogin() != null ? realmGet$IsUidLogin() : "null");
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
        LoginResponseEntityRealmProxy aLoginResponseEntity = (LoginResponseEntityRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aLoginResponseEntity.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aLoginResponseEntity.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aLoginResponseEntity.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
