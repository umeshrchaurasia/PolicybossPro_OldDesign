package io.realm;


import android.util.JsonReader;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.RealmProxyMediator;
import io.realm.internal.Row;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

@io.realm.annotations.RealmModule
class DefaultRealmModuleMediator extends RealmProxyMediator {

    private static final Set<Class<? extends RealmModel>> MODEL_CLASSES;
    static {
        Set<Class<? extends RealmModel>> modelClasses = new HashSet<Class<? extends RealmModel>>(31);
        modelClasses.add(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.SalesProductEntity.class);
        modelClasses.add(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.DashboardarrayEntity.class);
        modelClasses.add(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoSubcategoryEntity.class);
        modelClasses.add(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ConstantEntity.class);
        modelClasses.add(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MultiLangEntity.class);
        modelClasses.add(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.InsuranceSubtypeEntity.class);
        modelClasses.add(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.DocsEntity.class);
        modelClasses.add(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.BikeMasterEntity.class);
        modelClasses.add(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LifeinsuranceEntity.class);
        modelClasses.add(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoTicketCategoryEntity.class);
        modelClasses.add(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.RblCityEntity.class);
        modelClasses.add(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoClassificationEntity.class);
        modelClasses.add(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity.class);
        modelClasses.add(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CarMasterEntity.class);
        modelClasses.add(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.GeneralinsuranceEntity.class);
        modelClasses.add(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CityMasterEntity.class);
        modelClasses.add(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.HealthinsuranceEntity.class);
        modelClasses.add(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoCategoryEntity.class);
        modelClasses.add(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ContactlistEntity.class);
        modelClasses.add(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.DocAvailableEntity.class);
        modelClasses.add(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.AccountDtlEntity.class);
        modelClasses.add(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.UserConstantEntity.class);
        modelClasses.add(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackParameterEntity.class);
        modelClasses.add(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity.class);
        modelClasses.add(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDEntity.class);
        modelClasses.add(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDetailsDBean.class);
        modelClasses.add(magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model.CityEntity.class);
        modelClasses.add(magicfinmart.datacomp.com.finmartserviceapi.express_loan.model.KotakPLEmployerNameEntity.class);
        modelClasses.add(magicfinmart.datacomp.com.finmartserviceapi.model.DashboardMultiLangEntity.class);
        modelClasses.add(magicfinmart.datacomp.com.finmartserviceapi.model.DashboardEntity.class);
        modelClasses.add(magicfinmart.datacomp.com.finmartserviceapi.model.PropertyInfoEntity.class);
        MODEL_CLASSES = Collections.unmodifiableSet(modelClasses);
    }

    @Override
    public Map<Class<? extends RealmModel>, OsObjectSchemaInfo> getExpectedObjectSchemaInfoMap() {
        Map<Class<? extends RealmModel>, OsObjectSchemaInfo> infoMap = new HashMap<Class<? extends RealmModel>, OsObjectSchemaInfo>(31);
        infoMap.put(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.SalesProductEntity.class, io.realm.SalesProductEntityRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.DashboardarrayEntity.class, io.realm.DashboardarrayEntityRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoSubcategoryEntity.class, io.realm.ZohoSubcategoryEntityRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ConstantEntity.class, io.realm.ConstantEntityRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MultiLangEntity.class, io.realm.MultiLangEntityRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.InsuranceSubtypeEntity.class, io.realm.InsuranceSubtypeEntityRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.DocsEntity.class, io.realm.DocsEntityRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.BikeMasterEntity.class, io.realm.BikeMasterEntityRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LifeinsuranceEntity.class, io.realm.LifeinsuranceEntityRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoTicketCategoryEntity.class, io.realm.ZohoTicketCategoryEntityRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.RblCityEntity.class, io.realm.RblCityEntityRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoClassificationEntity.class, io.realm.ZohoClassificationEntityRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity.class, io.realm.LoginResponseEntityRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CarMasterEntity.class, io.realm.CarMasterEntityRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.GeneralinsuranceEntity.class, io.realm.GeneralinsuranceEntityRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CityMasterEntity.class, io.realm.CityMasterEntityRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.HealthinsuranceEntity.class, io.realm.HealthinsuranceEntityRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoCategoryEntity.class, io.realm.ZohoCategoryEntityRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ContactlistEntity.class, io.realm.ContactlistEntityRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.DocAvailableEntity.class, io.realm.DocAvailableEntityRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.AccountDtlEntity.class, io.realm.AccountDtlEntityRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.UserConstantEntity.class, io.realm.UserConstantEntityRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackParameterEntity.class, io.realm.LstPackParameterEntityRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity.class, io.realm.LstPackageDetailsEntityRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDEntity.class, io.realm.HealthPackDEntityRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDetailsDBean.class, io.realm.HealthPackDetailsDBeanRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model.CityEntity.class, io.realm.CityEntityRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(magicfinmart.datacomp.com.finmartserviceapi.express_loan.model.KotakPLEmployerNameEntity.class, io.realm.KotakPLEmployerNameEntityRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(magicfinmart.datacomp.com.finmartserviceapi.model.DashboardMultiLangEntity.class, io.realm.DashboardMultiLangEntityRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(magicfinmart.datacomp.com.finmartserviceapi.model.DashboardEntity.class, io.realm.DashboardEntityRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(magicfinmart.datacomp.com.finmartserviceapi.model.PropertyInfoEntity.class, io.realm.PropertyInfoEntityRealmProxy.getExpectedObjectSchemaInfo());
        return infoMap;
    }

    @Override
    public ColumnInfo createColumnInfo(Class<? extends RealmModel> clazz, OsSchemaInfo schemaInfo) {
        checkClass(clazz);

        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.SalesProductEntity.class)) {
            return io.realm.SalesProductEntityRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.DashboardarrayEntity.class)) {
            return io.realm.DashboardarrayEntityRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoSubcategoryEntity.class)) {
            return io.realm.ZohoSubcategoryEntityRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ConstantEntity.class)) {
            return io.realm.ConstantEntityRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MultiLangEntity.class)) {
            return io.realm.MultiLangEntityRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.InsuranceSubtypeEntity.class)) {
            return io.realm.InsuranceSubtypeEntityRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.DocsEntity.class)) {
            return io.realm.DocsEntityRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.BikeMasterEntity.class)) {
            return io.realm.BikeMasterEntityRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LifeinsuranceEntity.class)) {
            return io.realm.LifeinsuranceEntityRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoTicketCategoryEntity.class)) {
            return io.realm.ZohoTicketCategoryEntityRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.RblCityEntity.class)) {
            return io.realm.RblCityEntityRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoClassificationEntity.class)) {
            return io.realm.ZohoClassificationEntityRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity.class)) {
            return io.realm.LoginResponseEntityRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CarMasterEntity.class)) {
            return io.realm.CarMasterEntityRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.GeneralinsuranceEntity.class)) {
            return io.realm.GeneralinsuranceEntityRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CityMasterEntity.class)) {
            return io.realm.CityMasterEntityRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.HealthinsuranceEntity.class)) {
            return io.realm.HealthinsuranceEntityRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoCategoryEntity.class)) {
            return io.realm.ZohoCategoryEntityRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ContactlistEntity.class)) {
            return io.realm.ContactlistEntityRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.DocAvailableEntity.class)) {
            return io.realm.DocAvailableEntityRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.AccountDtlEntity.class)) {
            return io.realm.AccountDtlEntityRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.UserConstantEntity.class)) {
            return io.realm.UserConstantEntityRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackParameterEntity.class)) {
            return io.realm.LstPackParameterEntityRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity.class)) {
            return io.realm.LstPackageDetailsEntityRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDEntity.class)) {
            return io.realm.HealthPackDEntityRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDetailsDBean.class)) {
            return io.realm.HealthPackDetailsDBeanRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model.CityEntity.class)) {
            return io.realm.CityEntityRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.express_loan.model.KotakPLEmployerNameEntity.class)) {
            return io.realm.KotakPLEmployerNameEntityRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.model.DashboardMultiLangEntity.class)) {
            return io.realm.DashboardMultiLangEntityRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.model.DashboardEntity.class)) {
            return io.realm.DashboardEntityRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.model.PropertyInfoEntity.class)) {
            return io.realm.PropertyInfoEntityRealmProxy.createColumnInfo(schemaInfo);
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public List<String> getFieldNames(Class<? extends RealmModel> clazz) {
        checkClass(clazz);

        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.SalesProductEntity.class)) {
            return io.realm.SalesProductEntityRealmProxy.getFieldNames();
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.DashboardarrayEntity.class)) {
            return io.realm.DashboardarrayEntityRealmProxy.getFieldNames();
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoSubcategoryEntity.class)) {
            return io.realm.ZohoSubcategoryEntityRealmProxy.getFieldNames();
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ConstantEntity.class)) {
            return io.realm.ConstantEntityRealmProxy.getFieldNames();
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MultiLangEntity.class)) {
            return io.realm.MultiLangEntityRealmProxy.getFieldNames();
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.InsuranceSubtypeEntity.class)) {
            return io.realm.InsuranceSubtypeEntityRealmProxy.getFieldNames();
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.DocsEntity.class)) {
            return io.realm.DocsEntityRealmProxy.getFieldNames();
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.BikeMasterEntity.class)) {
            return io.realm.BikeMasterEntityRealmProxy.getFieldNames();
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LifeinsuranceEntity.class)) {
            return io.realm.LifeinsuranceEntityRealmProxy.getFieldNames();
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoTicketCategoryEntity.class)) {
            return io.realm.ZohoTicketCategoryEntityRealmProxy.getFieldNames();
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.RblCityEntity.class)) {
            return io.realm.RblCityEntityRealmProxy.getFieldNames();
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoClassificationEntity.class)) {
            return io.realm.ZohoClassificationEntityRealmProxy.getFieldNames();
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity.class)) {
            return io.realm.LoginResponseEntityRealmProxy.getFieldNames();
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CarMasterEntity.class)) {
            return io.realm.CarMasterEntityRealmProxy.getFieldNames();
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.GeneralinsuranceEntity.class)) {
            return io.realm.GeneralinsuranceEntityRealmProxy.getFieldNames();
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CityMasterEntity.class)) {
            return io.realm.CityMasterEntityRealmProxy.getFieldNames();
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.HealthinsuranceEntity.class)) {
            return io.realm.HealthinsuranceEntityRealmProxy.getFieldNames();
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoCategoryEntity.class)) {
            return io.realm.ZohoCategoryEntityRealmProxy.getFieldNames();
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ContactlistEntity.class)) {
            return io.realm.ContactlistEntityRealmProxy.getFieldNames();
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.DocAvailableEntity.class)) {
            return io.realm.DocAvailableEntityRealmProxy.getFieldNames();
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.AccountDtlEntity.class)) {
            return io.realm.AccountDtlEntityRealmProxy.getFieldNames();
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.UserConstantEntity.class)) {
            return io.realm.UserConstantEntityRealmProxy.getFieldNames();
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackParameterEntity.class)) {
            return io.realm.LstPackParameterEntityRealmProxy.getFieldNames();
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity.class)) {
            return io.realm.LstPackageDetailsEntityRealmProxy.getFieldNames();
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDEntity.class)) {
            return io.realm.HealthPackDEntityRealmProxy.getFieldNames();
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDetailsDBean.class)) {
            return io.realm.HealthPackDetailsDBeanRealmProxy.getFieldNames();
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model.CityEntity.class)) {
            return io.realm.CityEntityRealmProxy.getFieldNames();
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.express_loan.model.KotakPLEmployerNameEntity.class)) {
            return io.realm.KotakPLEmployerNameEntityRealmProxy.getFieldNames();
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.model.DashboardMultiLangEntity.class)) {
            return io.realm.DashboardMultiLangEntityRealmProxy.getFieldNames();
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.model.DashboardEntity.class)) {
            return io.realm.DashboardEntityRealmProxy.getFieldNames();
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.model.PropertyInfoEntity.class)) {
            return io.realm.PropertyInfoEntityRealmProxy.getFieldNames();
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public String getSimpleClassNameImpl(Class<? extends RealmModel> clazz) {
        checkClass(clazz);

        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.SalesProductEntity.class)) {
            return io.realm.SalesProductEntityRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.DashboardarrayEntity.class)) {
            return io.realm.DashboardarrayEntityRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoSubcategoryEntity.class)) {
            return io.realm.ZohoSubcategoryEntityRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ConstantEntity.class)) {
            return io.realm.ConstantEntityRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MultiLangEntity.class)) {
            return io.realm.MultiLangEntityRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.InsuranceSubtypeEntity.class)) {
            return io.realm.InsuranceSubtypeEntityRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.DocsEntity.class)) {
            return io.realm.DocsEntityRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.BikeMasterEntity.class)) {
            return io.realm.BikeMasterEntityRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LifeinsuranceEntity.class)) {
            return io.realm.LifeinsuranceEntityRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoTicketCategoryEntity.class)) {
            return io.realm.ZohoTicketCategoryEntityRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.RblCityEntity.class)) {
            return io.realm.RblCityEntityRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoClassificationEntity.class)) {
            return io.realm.ZohoClassificationEntityRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity.class)) {
            return io.realm.LoginResponseEntityRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CarMasterEntity.class)) {
            return io.realm.CarMasterEntityRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.GeneralinsuranceEntity.class)) {
            return io.realm.GeneralinsuranceEntityRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CityMasterEntity.class)) {
            return io.realm.CityMasterEntityRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.HealthinsuranceEntity.class)) {
            return io.realm.HealthinsuranceEntityRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoCategoryEntity.class)) {
            return io.realm.ZohoCategoryEntityRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ContactlistEntity.class)) {
            return io.realm.ContactlistEntityRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.DocAvailableEntity.class)) {
            return io.realm.DocAvailableEntityRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.AccountDtlEntity.class)) {
            return io.realm.AccountDtlEntityRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.UserConstantEntity.class)) {
            return io.realm.UserConstantEntityRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackParameterEntity.class)) {
            return io.realm.LstPackParameterEntityRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity.class)) {
            return io.realm.LstPackageDetailsEntityRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDEntity.class)) {
            return io.realm.HealthPackDEntityRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDetailsDBean.class)) {
            return io.realm.HealthPackDetailsDBeanRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model.CityEntity.class)) {
            return io.realm.CityEntityRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.express_loan.model.KotakPLEmployerNameEntity.class)) {
            return io.realm.KotakPLEmployerNameEntityRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.model.DashboardMultiLangEntity.class)) {
            return io.realm.DashboardMultiLangEntityRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.model.DashboardEntity.class)) {
            return io.realm.DashboardEntityRealmProxy.getSimpleClassName();
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.model.PropertyInfoEntity.class)) {
            return io.realm.PropertyInfoEntityRealmProxy.getSimpleClassName();
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E newInstance(Class<E> clazz, Object baseRealm, Row row, ColumnInfo columnInfo, boolean acceptDefaultValue, List<String> excludeFields) {
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        try {
            objectContext.set((BaseRealm) baseRealm, row, columnInfo, acceptDefaultValue, excludeFields);
            checkClass(clazz);

            if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.SalesProductEntity.class)) {
                return clazz.cast(new io.realm.SalesProductEntityRealmProxy());
            }
            if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.DashboardarrayEntity.class)) {
                return clazz.cast(new io.realm.DashboardarrayEntityRealmProxy());
            }
            if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoSubcategoryEntity.class)) {
                return clazz.cast(new io.realm.ZohoSubcategoryEntityRealmProxy());
            }
            if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ConstantEntity.class)) {
                return clazz.cast(new io.realm.ConstantEntityRealmProxy());
            }
            if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MultiLangEntity.class)) {
                return clazz.cast(new io.realm.MultiLangEntityRealmProxy());
            }
            if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.InsuranceSubtypeEntity.class)) {
                return clazz.cast(new io.realm.InsuranceSubtypeEntityRealmProxy());
            }
            if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.DocsEntity.class)) {
                return clazz.cast(new io.realm.DocsEntityRealmProxy());
            }
            if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.BikeMasterEntity.class)) {
                return clazz.cast(new io.realm.BikeMasterEntityRealmProxy());
            }
            if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LifeinsuranceEntity.class)) {
                return clazz.cast(new io.realm.LifeinsuranceEntityRealmProxy());
            }
            if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoTicketCategoryEntity.class)) {
                return clazz.cast(new io.realm.ZohoTicketCategoryEntityRealmProxy());
            }
            if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.RblCityEntity.class)) {
                return clazz.cast(new io.realm.RblCityEntityRealmProxy());
            }
            if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoClassificationEntity.class)) {
                return clazz.cast(new io.realm.ZohoClassificationEntityRealmProxy());
            }
            if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity.class)) {
                return clazz.cast(new io.realm.LoginResponseEntityRealmProxy());
            }
            if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CarMasterEntity.class)) {
                return clazz.cast(new io.realm.CarMasterEntityRealmProxy());
            }
            if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.GeneralinsuranceEntity.class)) {
                return clazz.cast(new io.realm.GeneralinsuranceEntityRealmProxy());
            }
            if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CityMasterEntity.class)) {
                return clazz.cast(new io.realm.CityMasterEntityRealmProxy());
            }
            if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.HealthinsuranceEntity.class)) {
                return clazz.cast(new io.realm.HealthinsuranceEntityRealmProxy());
            }
            if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoCategoryEntity.class)) {
                return clazz.cast(new io.realm.ZohoCategoryEntityRealmProxy());
            }
            if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ContactlistEntity.class)) {
                return clazz.cast(new io.realm.ContactlistEntityRealmProxy());
            }
            if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.DocAvailableEntity.class)) {
                return clazz.cast(new io.realm.DocAvailableEntityRealmProxy());
            }
            if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.AccountDtlEntity.class)) {
                return clazz.cast(new io.realm.AccountDtlEntityRealmProxy());
            }
            if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.UserConstantEntity.class)) {
                return clazz.cast(new io.realm.UserConstantEntityRealmProxy());
            }
            if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackParameterEntity.class)) {
                return clazz.cast(new io.realm.LstPackParameterEntityRealmProxy());
            }
            if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity.class)) {
                return clazz.cast(new io.realm.LstPackageDetailsEntityRealmProxy());
            }
            if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDEntity.class)) {
                return clazz.cast(new io.realm.HealthPackDEntityRealmProxy());
            }
            if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDetailsDBean.class)) {
                return clazz.cast(new io.realm.HealthPackDetailsDBeanRealmProxy());
            }
            if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model.CityEntity.class)) {
                return clazz.cast(new io.realm.CityEntityRealmProxy());
            }
            if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.express_loan.model.KotakPLEmployerNameEntity.class)) {
                return clazz.cast(new io.realm.KotakPLEmployerNameEntityRealmProxy());
            }
            if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.model.DashboardMultiLangEntity.class)) {
                return clazz.cast(new io.realm.DashboardMultiLangEntityRealmProxy());
            }
            if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.model.DashboardEntity.class)) {
                return clazz.cast(new io.realm.DashboardEntityRealmProxy());
            }
            if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.model.PropertyInfoEntity.class)) {
                return clazz.cast(new io.realm.PropertyInfoEntityRealmProxy());
            }
            throw getMissingProxyClassException(clazz);
        } finally {
            objectContext.clear();
        }
    }

    @Override
    public Set<Class<? extends RealmModel>> getModelClasses() {
        return MODEL_CLASSES;
    }

    @Override
    public <E extends RealmModel> E copyOrUpdate(Realm realm, E obj, boolean update, Map<RealmModel, RealmObjectProxy> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.SalesProductEntity.class)) {
            return clazz.cast(io.realm.SalesProductEntityRealmProxy.copyOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.SalesProductEntity) obj, update, cache));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.DashboardarrayEntity.class)) {
            return clazz.cast(io.realm.DashboardarrayEntityRealmProxy.copyOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.DashboardarrayEntity) obj, update, cache));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoSubcategoryEntity.class)) {
            return clazz.cast(io.realm.ZohoSubcategoryEntityRealmProxy.copyOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoSubcategoryEntity) obj, update, cache));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ConstantEntity.class)) {
            return clazz.cast(io.realm.ConstantEntityRealmProxy.copyOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ConstantEntity) obj, update, cache));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MultiLangEntity.class)) {
            return clazz.cast(io.realm.MultiLangEntityRealmProxy.copyOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MultiLangEntity) obj, update, cache));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.InsuranceSubtypeEntity.class)) {
            return clazz.cast(io.realm.InsuranceSubtypeEntityRealmProxy.copyOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.InsuranceSubtypeEntity) obj, update, cache));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.DocsEntity.class)) {
            return clazz.cast(io.realm.DocsEntityRealmProxy.copyOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.DocsEntity) obj, update, cache));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.BikeMasterEntity.class)) {
            return clazz.cast(io.realm.BikeMasterEntityRealmProxy.copyOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.BikeMasterEntity) obj, update, cache));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LifeinsuranceEntity.class)) {
            return clazz.cast(io.realm.LifeinsuranceEntityRealmProxy.copyOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LifeinsuranceEntity) obj, update, cache));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoTicketCategoryEntity.class)) {
            return clazz.cast(io.realm.ZohoTicketCategoryEntityRealmProxy.copyOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoTicketCategoryEntity) obj, update, cache));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.RblCityEntity.class)) {
            return clazz.cast(io.realm.RblCityEntityRealmProxy.copyOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.RblCityEntity) obj, update, cache));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoClassificationEntity.class)) {
            return clazz.cast(io.realm.ZohoClassificationEntityRealmProxy.copyOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoClassificationEntity) obj, update, cache));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity.class)) {
            return clazz.cast(io.realm.LoginResponseEntityRealmProxy.copyOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity) obj, update, cache));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CarMasterEntity.class)) {
            return clazz.cast(io.realm.CarMasterEntityRealmProxy.copyOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CarMasterEntity) obj, update, cache));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.GeneralinsuranceEntity.class)) {
            return clazz.cast(io.realm.GeneralinsuranceEntityRealmProxy.copyOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.GeneralinsuranceEntity) obj, update, cache));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CityMasterEntity.class)) {
            return clazz.cast(io.realm.CityMasterEntityRealmProxy.copyOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CityMasterEntity) obj, update, cache));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.HealthinsuranceEntity.class)) {
            return clazz.cast(io.realm.HealthinsuranceEntityRealmProxy.copyOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.HealthinsuranceEntity) obj, update, cache));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoCategoryEntity.class)) {
            return clazz.cast(io.realm.ZohoCategoryEntityRealmProxy.copyOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoCategoryEntity) obj, update, cache));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ContactlistEntity.class)) {
            return clazz.cast(io.realm.ContactlistEntityRealmProxy.copyOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ContactlistEntity) obj, update, cache));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.DocAvailableEntity.class)) {
            return clazz.cast(io.realm.DocAvailableEntityRealmProxy.copyOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.DocAvailableEntity) obj, update, cache));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.AccountDtlEntity.class)) {
            return clazz.cast(io.realm.AccountDtlEntityRealmProxy.copyOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.AccountDtlEntity) obj, update, cache));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.UserConstantEntity.class)) {
            return clazz.cast(io.realm.UserConstantEntityRealmProxy.copyOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.UserConstantEntity) obj, update, cache));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackParameterEntity.class)) {
            return clazz.cast(io.realm.LstPackParameterEntityRealmProxy.copyOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackParameterEntity) obj, update, cache));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity.class)) {
            return clazz.cast(io.realm.LstPackageDetailsEntityRealmProxy.copyOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity) obj, update, cache));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDEntity.class)) {
            return clazz.cast(io.realm.HealthPackDEntityRealmProxy.copyOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDEntity) obj, update, cache));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDetailsDBean.class)) {
            return clazz.cast(io.realm.HealthPackDetailsDBeanRealmProxy.copyOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDetailsDBean) obj, update, cache));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model.CityEntity.class)) {
            return clazz.cast(io.realm.CityEntityRealmProxy.copyOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model.CityEntity) obj, update, cache));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.express_loan.model.KotakPLEmployerNameEntity.class)) {
            return clazz.cast(io.realm.KotakPLEmployerNameEntityRealmProxy.copyOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.express_loan.model.KotakPLEmployerNameEntity) obj, update, cache));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.model.DashboardMultiLangEntity.class)) {
            return clazz.cast(io.realm.DashboardMultiLangEntityRealmProxy.copyOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.model.DashboardMultiLangEntity) obj, update, cache));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.model.DashboardEntity.class)) {
            return clazz.cast(io.realm.DashboardEntityRealmProxy.copyOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.model.DashboardEntity) obj, update, cache));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.model.PropertyInfoEntity.class)) {
            return clazz.cast(io.realm.PropertyInfoEntityRealmProxy.copyOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.model.PropertyInfoEntity) obj, update, cache));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public void insert(Realm realm, RealmModel object, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.SalesProductEntity.class)) {
            io.realm.SalesProductEntityRealmProxy.insert(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.SalesProductEntity) object, cache);
        } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.DashboardarrayEntity.class)) {
            io.realm.DashboardarrayEntityRealmProxy.insert(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.DashboardarrayEntity) object, cache);
        } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoSubcategoryEntity.class)) {
            io.realm.ZohoSubcategoryEntityRealmProxy.insert(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoSubcategoryEntity) object, cache);
        } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ConstantEntity.class)) {
            io.realm.ConstantEntityRealmProxy.insert(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ConstantEntity) object, cache);
        } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MultiLangEntity.class)) {
            io.realm.MultiLangEntityRealmProxy.insert(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MultiLangEntity) object, cache);
        } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.InsuranceSubtypeEntity.class)) {
            io.realm.InsuranceSubtypeEntityRealmProxy.insert(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.InsuranceSubtypeEntity) object, cache);
        } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.DocsEntity.class)) {
            io.realm.DocsEntityRealmProxy.insert(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.DocsEntity) object, cache);
        } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.BikeMasterEntity.class)) {
            io.realm.BikeMasterEntityRealmProxy.insert(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.BikeMasterEntity) object, cache);
        } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LifeinsuranceEntity.class)) {
            io.realm.LifeinsuranceEntityRealmProxy.insert(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LifeinsuranceEntity) object, cache);
        } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoTicketCategoryEntity.class)) {
            io.realm.ZohoTicketCategoryEntityRealmProxy.insert(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoTicketCategoryEntity) object, cache);
        } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.RblCityEntity.class)) {
            io.realm.RblCityEntityRealmProxy.insert(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.RblCityEntity) object, cache);
        } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoClassificationEntity.class)) {
            io.realm.ZohoClassificationEntityRealmProxy.insert(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoClassificationEntity) object, cache);
        } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity.class)) {
            io.realm.LoginResponseEntityRealmProxy.insert(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity) object, cache);
        } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CarMasterEntity.class)) {
            io.realm.CarMasterEntityRealmProxy.insert(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CarMasterEntity) object, cache);
        } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.GeneralinsuranceEntity.class)) {
            io.realm.GeneralinsuranceEntityRealmProxy.insert(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.GeneralinsuranceEntity) object, cache);
        } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CityMasterEntity.class)) {
            io.realm.CityMasterEntityRealmProxy.insert(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CityMasterEntity) object, cache);
        } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.HealthinsuranceEntity.class)) {
            io.realm.HealthinsuranceEntityRealmProxy.insert(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.HealthinsuranceEntity) object, cache);
        } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoCategoryEntity.class)) {
            io.realm.ZohoCategoryEntityRealmProxy.insert(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoCategoryEntity) object, cache);
        } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ContactlistEntity.class)) {
            io.realm.ContactlistEntityRealmProxy.insert(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ContactlistEntity) object, cache);
        } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.DocAvailableEntity.class)) {
            io.realm.DocAvailableEntityRealmProxy.insert(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.DocAvailableEntity) object, cache);
        } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.AccountDtlEntity.class)) {
            io.realm.AccountDtlEntityRealmProxy.insert(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.AccountDtlEntity) object, cache);
        } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.UserConstantEntity.class)) {
            io.realm.UserConstantEntityRealmProxy.insert(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.UserConstantEntity) object, cache);
        } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackParameterEntity.class)) {
            io.realm.LstPackParameterEntityRealmProxy.insert(realm, (magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackParameterEntity) object, cache);
        } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity.class)) {
            io.realm.LstPackageDetailsEntityRealmProxy.insert(realm, (magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity) object, cache);
        } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDEntity.class)) {
            io.realm.HealthPackDEntityRealmProxy.insert(realm, (magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDEntity) object, cache);
        } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDetailsDBean.class)) {
            io.realm.HealthPackDetailsDBeanRealmProxy.insert(realm, (magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDetailsDBean) object, cache);
        } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model.CityEntity.class)) {
            io.realm.CityEntityRealmProxy.insert(realm, (magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model.CityEntity) object, cache);
        } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.express_loan.model.KotakPLEmployerNameEntity.class)) {
            io.realm.KotakPLEmployerNameEntityRealmProxy.insert(realm, (magicfinmart.datacomp.com.finmartserviceapi.express_loan.model.KotakPLEmployerNameEntity) object, cache);
        } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.model.DashboardMultiLangEntity.class)) {
            io.realm.DashboardMultiLangEntityRealmProxy.insert(realm, (magicfinmart.datacomp.com.finmartserviceapi.model.DashboardMultiLangEntity) object, cache);
        } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.model.DashboardEntity.class)) {
            io.realm.DashboardEntityRealmProxy.insert(realm, (magicfinmart.datacomp.com.finmartserviceapi.model.DashboardEntity) object, cache);
        } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.model.PropertyInfoEntity.class)) {
            io.realm.PropertyInfoEntityRealmProxy.insert(realm, (magicfinmart.datacomp.com.finmartserviceapi.model.PropertyInfoEntity) object, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insert(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new HashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.SalesProductEntity.class)) {
                io.realm.SalesProductEntityRealmProxy.insert(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.SalesProductEntity) object, cache);
            } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.DashboardarrayEntity.class)) {
                io.realm.DashboardarrayEntityRealmProxy.insert(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.DashboardarrayEntity) object, cache);
            } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoSubcategoryEntity.class)) {
                io.realm.ZohoSubcategoryEntityRealmProxy.insert(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoSubcategoryEntity) object, cache);
            } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ConstantEntity.class)) {
                io.realm.ConstantEntityRealmProxy.insert(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ConstantEntity) object, cache);
            } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MultiLangEntity.class)) {
                io.realm.MultiLangEntityRealmProxy.insert(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MultiLangEntity) object, cache);
            } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.InsuranceSubtypeEntity.class)) {
                io.realm.InsuranceSubtypeEntityRealmProxy.insert(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.InsuranceSubtypeEntity) object, cache);
            } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.DocsEntity.class)) {
                io.realm.DocsEntityRealmProxy.insert(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.DocsEntity) object, cache);
            } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.BikeMasterEntity.class)) {
                io.realm.BikeMasterEntityRealmProxy.insert(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.BikeMasterEntity) object, cache);
            } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LifeinsuranceEntity.class)) {
                io.realm.LifeinsuranceEntityRealmProxy.insert(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LifeinsuranceEntity) object, cache);
            } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoTicketCategoryEntity.class)) {
                io.realm.ZohoTicketCategoryEntityRealmProxy.insert(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoTicketCategoryEntity) object, cache);
            } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.RblCityEntity.class)) {
                io.realm.RblCityEntityRealmProxy.insert(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.RblCityEntity) object, cache);
            } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoClassificationEntity.class)) {
                io.realm.ZohoClassificationEntityRealmProxy.insert(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoClassificationEntity) object, cache);
            } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity.class)) {
                io.realm.LoginResponseEntityRealmProxy.insert(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity) object, cache);
            } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CarMasterEntity.class)) {
                io.realm.CarMasterEntityRealmProxy.insert(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CarMasterEntity) object, cache);
            } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.GeneralinsuranceEntity.class)) {
                io.realm.GeneralinsuranceEntityRealmProxy.insert(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.GeneralinsuranceEntity) object, cache);
            } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CityMasterEntity.class)) {
                io.realm.CityMasterEntityRealmProxy.insert(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CityMasterEntity) object, cache);
            } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.HealthinsuranceEntity.class)) {
                io.realm.HealthinsuranceEntityRealmProxy.insert(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.HealthinsuranceEntity) object, cache);
            } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoCategoryEntity.class)) {
                io.realm.ZohoCategoryEntityRealmProxy.insert(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoCategoryEntity) object, cache);
            } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ContactlistEntity.class)) {
                io.realm.ContactlistEntityRealmProxy.insert(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ContactlistEntity) object, cache);
            } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.DocAvailableEntity.class)) {
                io.realm.DocAvailableEntityRealmProxy.insert(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.DocAvailableEntity) object, cache);
            } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.AccountDtlEntity.class)) {
                io.realm.AccountDtlEntityRealmProxy.insert(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.AccountDtlEntity) object, cache);
            } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.UserConstantEntity.class)) {
                io.realm.UserConstantEntityRealmProxy.insert(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.UserConstantEntity) object, cache);
            } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackParameterEntity.class)) {
                io.realm.LstPackParameterEntityRealmProxy.insert(realm, (magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackParameterEntity) object, cache);
            } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity.class)) {
                io.realm.LstPackageDetailsEntityRealmProxy.insert(realm, (magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity) object, cache);
            } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDEntity.class)) {
                io.realm.HealthPackDEntityRealmProxy.insert(realm, (magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDEntity) object, cache);
            } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDetailsDBean.class)) {
                io.realm.HealthPackDetailsDBeanRealmProxy.insert(realm, (magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDetailsDBean) object, cache);
            } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model.CityEntity.class)) {
                io.realm.CityEntityRealmProxy.insert(realm, (magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model.CityEntity) object, cache);
            } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.express_loan.model.KotakPLEmployerNameEntity.class)) {
                io.realm.KotakPLEmployerNameEntityRealmProxy.insert(realm, (magicfinmart.datacomp.com.finmartserviceapi.express_loan.model.KotakPLEmployerNameEntity) object, cache);
            } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.model.DashboardMultiLangEntity.class)) {
                io.realm.DashboardMultiLangEntityRealmProxy.insert(realm, (magicfinmart.datacomp.com.finmartserviceapi.model.DashboardMultiLangEntity) object, cache);
            } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.model.DashboardEntity.class)) {
                io.realm.DashboardEntityRealmProxy.insert(realm, (magicfinmart.datacomp.com.finmartserviceapi.model.DashboardEntity) object, cache);
            } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.model.PropertyInfoEntity.class)) {
                io.realm.PropertyInfoEntityRealmProxy.insert(realm, (magicfinmart.datacomp.com.finmartserviceapi.model.PropertyInfoEntity) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.SalesProductEntity.class)) {
                    io.realm.SalesProductEntityRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.DashboardarrayEntity.class)) {
                    io.realm.DashboardarrayEntityRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoSubcategoryEntity.class)) {
                    io.realm.ZohoSubcategoryEntityRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ConstantEntity.class)) {
                    io.realm.ConstantEntityRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MultiLangEntity.class)) {
                    io.realm.MultiLangEntityRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.InsuranceSubtypeEntity.class)) {
                    io.realm.InsuranceSubtypeEntityRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.DocsEntity.class)) {
                    io.realm.DocsEntityRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.BikeMasterEntity.class)) {
                    io.realm.BikeMasterEntityRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LifeinsuranceEntity.class)) {
                    io.realm.LifeinsuranceEntityRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoTicketCategoryEntity.class)) {
                    io.realm.ZohoTicketCategoryEntityRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.RblCityEntity.class)) {
                    io.realm.RblCityEntityRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoClassificationEntity.class)) {
                    io.realm.ZohoClassificationEntityRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity.class)) {
                    io.realm.LoginResponseEntityRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CarMasterEntity.class)) {
                    io.realm.CarMasterEntityRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.GeneralinsuranceEntity.class)) {
                    io.realm.GeneralinsuranceEntityRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CityMasterEntity.class)) {
                    io.realm.CityMasterEntityRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.HealthinsuranceEntity.class)) {
                    io.realm.HealthinsuranceEntityRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoCategoryEntity.class)) {
                    io.realm.ZohoCategoryEntityRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ContactlistEntity.class)) {
                    io.realm.ContactlistEntityRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.DocAvailableEntity.class)) {
                    io.realm.DocAvailableEntityRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.AccountDtlEntity.class)) {
                    io.realm.AccountDtlEntityRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.UserConstantEntity.class)) {
                    io.realm.UserConstantEntityRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackParameterEntity.class)) {
                    io.realm.LstPackParameterEntityRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity.class)) {
                    io.realm.LstPackageDetailsEntityRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDEntity.class)) {
                    io.realm.HealthPackDEntityRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDetailsDBean.class)) {
                    io.realm.HealthPackDetailsDBeanRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model.CityEntity.class)) {
                    io.realm.CityEntityRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.express_loan.model.KotakPLEmployerNameEntity.class)) {
                    io.realm.KotakPLEmployerNameEntityRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.model.DashboardMultiLangEntity.class)) {
                    io.realm.DashboardMultiLangEntityRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.model.DashboardEntity.class)) {
                    io.realm.DashboardEntityRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.model.PropertyInfoEntity.class)) {
                    io.realm.PropertyInfoEntityRealmProxy.insert(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public void insertOrUpdate(Realm realm, RealmModel obj, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.SalesProductEntity.class)) {
            io.realm.SalesProductEntityRealmProxy.insertOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.SalesProductEntity) obj, cache);
        } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.DashboardarrayEntity.class)) {
            io.realm.DashboardarrayEntityRealmProxy.insertOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.DashboardarrayEntity) obj, cache);
        } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoSubcategoryEntity.class)) {
            io.realm.ZohoSubcategoryEntityRealmProxy.insertOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoSubcategoryEntity) obj, cache);
        } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ConstantEntity.class)) {
            io.realm.ConstantEntityRealmProxy.insertOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ConstantEntity) obj, cache);
        } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MultiLangEntity.class)) {
            io.realm.MultiLangEntityRealmProxy.insertOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MultiLangEntity) obj, cache);
        } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.InsuranceSubtypeEntity.class)) {
            io.realm.InsuranceSubtypeEntityRealmProxy.insertOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.InsuranceSubtypeEntity) obj, cache);
        } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.DocsEntity.class)) {
            io.realm.DocsEntityRealmProxy.insertOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.DocsEntity) obj, cache);
        } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.BikeMasterEntity.class)) {
            io.realm.BikeMasterEntityRealmProxy.insertOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.BikeMasterEntity) obj, cache);
        } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LifeinsuranceEntity.class)) {
            io.realm.LifeinsuranceEntityRealmProxy.insertOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LifeinsuranceEntity) obj, cache);
        } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoTicketCategoryEntity.class)) {
            io.realm.ZohoTicketCategoryEntityRealmProxy.insertOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoTicketCategoryEntity) obj, cache);
        } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.RblCityEntity.class)) {
            io.realm.RblCityEntityRealmProxy.insertOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.RblCityEntity) obj, cache);
        } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoClassificationEntity.class)) {
            io.realm.ZohoClassificationEntityRealmProxy.insertOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoClassificationEntity) obj, cache);
        } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity.class)) {
            io.realm.LoginResponseEntityRealmProxy.insertOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity) obj, cache);
        } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CarMasterEntity.class)) {
            io.realm.CarMasterEntityRealmProxy.insertOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CarMasterEntity) obj, cache);
        } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.GeneralinsuranceEntity.class)) {
            io.realm.GeneralinsuranceEntityRealmProxy.insertOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.GeneralinsuranceEntity) obj, cache);
        } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CityMasterEntity.class)) {
            io.realm.CityMasterEntityRealmProxy.insertOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CityMasterEntity) obj, cache);
        } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.HealthinsuranceEntity.class)) {
            io.realm.HealthinsuranceEntityRealmProxy.insertOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.HealthinsuranceEntity) obj, cache);
        } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoCategoryEntity.class)) {
            io.realm.ZohoCategoryEntityRealmProxy.insertOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoCategoryEntity) obj, cache);
        } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ContactlistEntity.class)) {
            io.realm.ContactlistEntityRealmProxy.insertOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ContactlistEntity) obj, cache);
        } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.DocAvailableEntity.class)) {
            io.realm.DocAvailableEntityRealmProxy.insertOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.DocAvailableEntity) obj, cache);
        } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.AccountDtlEntity.class)) {
            io.realm.AccountDtlEntityRealmProxy.insertOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.AccountDtlEntity) obj, cache);
        } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.UserConstantEntity.class)) {
            io.realm.UserConstantEntityRealmProxy.insertOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.UserConstantEntity) obj, cache);
        } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackParameterEntity.class)) {
            io.realm.LstPackParameterEntityRealmProxy.insertOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackParameterEntity) obj, cache);
        } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity.class)) {
            io.realm.LstPackageDetailsEntityRealmProxy.insertOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity) obj, cache);
        } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDEntity.class)) {
            io.realm.HealthPackDEntityRealmProxy.insertOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDEntity) obj, cache);
        } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDetailsDBean.class)) {
            io.realm.HealthPackDetailsDBeanRealmProxy.insertOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDetailsDBean) obj, cache);
        } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model.CityEntity.class)) {
            io.realm.CityEntityRealmProxy.insertOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model.CityEntity) obj, cache);
        } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.express_loan.model.KotakPLEmployerNameEntity.class)) {
            io.realm.KotakPLEmployerNameEntityRealmProxy.insertOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.express_loan.model.KotakPLEmployerNameEntity) obj, cache);
        } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.model.DashboardMultiLangEntity.class)) {
            io.realm.DashboardMultiLangEntityRealmProxy.insertOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.model.DashboardMultiLangEntity) obj, cache);
        } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.model.DashboardEntity.class)) {
            io.realm.DashboardEntityRealmProxy.insertOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.model.DashboardEntity) obj, cache);
        } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.model.PropertyInfoEntity.class)) {
            io.realm.PropertyInfoEntityRealmProxy.insertOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.model.PropertyInfoEntity) obj, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insertOrUpdate(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new HashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.SalesProductEntity.class)) {
                io.realm.SalesProductEntityRealmProxy.insertOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.SalesProductEntity) object, cache);
            } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.DashboardarrayEntity.class)) {
                io.realm.DashboardarrayEntityRealmProxy.insertOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.DashboardarrayEntity) object, cache);
            } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoSubcategoryEntity.class)) {
                io.realm.ZohoSubcategoryEntityRealmProxy.insertOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoSubcategoryEntity) object, cache);
            } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ConstantEntity.class)) {
                io.realm.ConstantEntityRealmProxy.insertOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ConstantEntity) object, cache);
            } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MultiLangEntity.class)) {
                io.realm.MultiLangEntityRealmProxy.insertOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MultiLangEntity) object, cache);
            } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.InsuranceSubtypeEntity.class)) {
                io.realm.InsuranceSubtypeEntityRealmProxy.insertOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.InsuranceSubtypeEntity) object, cache);
            } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.DocsEntity.class)) {
                io.realm.DocsEntityRealmProxy.insertOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.DocsEntity) object, cache);
            } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.BikeMasterEntity.class)) {
                io.realm.BikeMasterEntityRealmProxy.insertOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.BikeMasterEntity) object, cache);
            } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LifeinsuranceEntity.class)) {
                io.realm.LifeinsuranceEntityRealmProxy.insertOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LifeinsuranceEntity) object, cache);
            } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoTicketCategoryEntity.class)) {
                io.realm.ZohoTicketCategoryEntityRealmProxy.insertOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoTicketCategoryEntity) object, cache);
            } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.RblCityEntity.class)) {
                io.realm.RblCityEntityRealmProxy.insertOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.RblCityEntity) object, cache);
            } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoClassificationEntity.class)) {
                io.realm.ZohoClassificationEntityRealmProxy.insertOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoClassificationEntity) object, cache);
            } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity.class)) {
                io.realm.LoginResponseEntityRealmProxy.insertOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity) object, cache);
            } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CarMasterEntity.class)) {
                io.realm.CarMasterEntityRealmProxy.insertOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CarMasterEntity) object, cache);
            } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.GeneralinsuranceEntity.class)) {
                io.realm.GeneralinsuranceEntityRealmProxy.insertOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.GeneralinsuranceEntity) object, cache);
            } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CityMasterEntity.class)) {
                io.realm.CityMasterEntityRealmProxy.insertOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CityMasterEntity) object, cache);
            } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.HealthinsuranceEntity.class)) {
                io.realm.HealthinsuranceEntityRealmProxy.insertOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.HealthinsuranceEntity) object, cache);
            } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoCategoryEntity.class)) {
                io.realm.ZohoCategoryEntityRealmProxy.insertOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoCategoryEntity) object, cache);
            } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ContactlistEntity.class)) {
                io.realm.ContactlistEntityRealmProxy.insertOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ContactlistEntity) object, cache);
            } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.DocAvailableEntity.class)) {
                io.realm.DocAvailableEntityRealmProxy.insertOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.DocAvailableEntity) object, cache);
            } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.AccountDtlEntity.class)) {
                io.realm.AccountDtlEntityRealmProxy.insertOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.AccountDtlEntity) object, cache);
            } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.UserConstantEntity.class)) {
                io.realm.UserConstantEntityRealmProxy.insertOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.UserConstantEntity) object, cache);
            } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackParameterEntity.class)) {
                io.realm.LstPackParameterEntityRealmProxy.insertOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackParameterEntity) object, cache);
            } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity.class)) {
                io.realm.LstPackageDetailsEntityRealmProxy.insertOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity) object, cache);
            } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDEntity.class)) {
                io.realm.HealthPackDEntityRealmProxy.insertOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDEntity) object, cache);
            } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDetailsDBean.class)) {
                io.realm.HealthPackDetailsDBeanRealmProxy.insertOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDetailsDBean) object, cache);
            } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model.CityEntity.class)) {
                io.realm.CityEntityRealmProxy.insertOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model.CityEntity) object, cache);
            } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.express_loan.model.KotakPLEmployerNameEntity.class)) {
                io.realm.KotakPLEmployerNameEntityRealmProxy.insertOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.express_loan.model.KotakPLEmployerNameEntity) object, cache);
            } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.model.DashboardMultiLangEntity.class)) {
                io.realm.DashboardMultiLangEntityRealmProxy.insertOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.model.DashboardMultiLangEntity) object, cache);
            } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.model.DashboardEntity.class)) {
                io.realm.DashboardEntityRealmProxy.insertOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.model.DashboardEntity) object, cache);
            } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.model.PropertyInfoEntity.class)) {
                io.realm.PropertyInfoEntityRealmProxy.insertOrUpdate(realm, (magicfinmart.datacomp.com.finmartserviceapi.model.PropertyInfoEntity) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.SalesProductEntity.class)) {
                    io.realm.SalesProductEntityRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.DashboardarrayEntity.class)) {
                    io.realm.DashboardarrayEntityRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoSubcategoryEntity.class)) {
                    io.realm.ZohoSubcategoryEntityRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ConstantEntity.class)) {
                    io.realm.ConstantEntityRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MultiLangEntity.class)) {
                    io.realm.MultiLangEntityRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.InsuranceSubtypeEntity.class)) {
                    io.realm.InsuranceSubtypeEntityRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.DocsEntity.class)) {
                    io.realm.DocsEntityRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.BikeMasterEntity.class)) {
                    io.realm.BikeMasterEntityRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LifeinsuranceEntity.class)) {
                    io.realm.LifeinsuranceEntityRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoTicketCategoryEntity.class)) {
                    io.realm.ZohoTicketCategoryEntityRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.RblCityEntity.class)) {
                    io.realm.RblCityEntityRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoClassificationEntity.class)) {
                    io.realm.ZohoClassificationEntityRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity.class)) {
                    io.realm.LoginResponseEntityRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CarMasterEntity.class)) {
                    io.realm.CarMasterEntityRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.GeneralinsuranceEntity.class)) {
                    io.realm.GeneralinsuranceEntityRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CityMasterEntity.class)) {
                    io.realm.CityMasterEntityRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.HealthinsuranceEntity.class)) {
                    io.realm.HealthinsuranceEntityRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoCategoryEntity.class)) {
                    io.realm.ZohoCategoryEntityRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ContactlistEntity.class)) {
                    io.realm.ContactlistEntityRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.DocAvailableEntity.class)) {
                    io.realm.DocAvailableEntityRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.AccountDtlEntity.class)) {
                    io.realm.AccountDtlEntityRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.UserConstantEntity.class)) {
                    io.realm.UserConstantEntityRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackParameterEntity.class)) {
                    io.realm.LstPackParameterEntityRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity.class)) {
                    io.realm.LstPackageDetailsEntityRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDEntity.class)) {
                    io.realm.HealthPackDEntityRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDetailsDBean.class)) {
                    io.realm.HealthPackDetailsDBeanRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model.CityEntity.class)) {
                    io.realm.CityEntityRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.express_loan.model.KotakPLEmployerNameEntity.class)) {
                    io.realm.KotakPLEmployerNameEntityRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.model.DashboardMultiLangEntity.class)) {
                    io.realm.DashboardMultiLangEntityRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.model.DashboardEntity.class)) {
                    io.realm.DashboardEntityRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.model.PropertyInfoEntity.class)) {
                    io.realm.PropertyInfoEntityRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public <E extends RealmModel> E createOrUpdateUsingJsonObject(Class<E> clazz, Realm realm, JSONObject json, boolean update)
        throws JSONException {
        checkClass(clazz);

        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.SalesProductEntity.class)) {
            return clazz.cast(io.realm.SalesProductEntityRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.DashboardarrayEntity.class)) {
            return clazz.cast(io.realm.DashboardarrayEntityRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoSubcategoryEntity.class)) {
            return clazz.cast(io.realm.ZohoSubcategoryEntityRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ConstantEntity.class)) {
            return clazz.cast(io.realm.ConstantEntityRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MultiLangEntity.class)) {
            return clazz.cast(io.realm.MultiLangEntityRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.InsuranceSubtypeEntity.class)) {
            return clazz.cast(io.realm.InsuranceSubtypeEntityRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.DocsEntity.class)) {
            return clazz.cast(io.realm.DocsEntityRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.BikeMasterEntity.class)) {
            return clazz.cast(io.realm.BikeMasterEntityRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LifeinsuranceEntity.class)) {
            return clazz.cast(io.realm.LifeinsuranceEntityRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoTicketCategoryEntity.class)) {
            return clazz.cast(io.realm.ZohoTicketCategoryEntityRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.RblCityEntity.class)) {
            return clazz.cast(io.realm.RblCityEntityRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoClassificationEntity.class)) {
            return clazz.cast(io.realm.ZohoClassificationEntityRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity.class)) {
            return clazz.cast(io.realm.LoginResponseEntityRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CarMasterEntity.class)) {
            return clazz.cast(io.realm.CarMasterEntityRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.GeneralinsuranceEntity.class)) {
            return clazz.cast(io.realm.GeneralinsuranceEntityRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CityMasterEntity.class)) {
            return clazz.cast(io.realm.CityMasterEntityRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.HealthinsuranceEntity.class)) {
            return clazz.cast(io.realm.HealthinsuranceEntityRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoCategoryEntity.class)) {
            return clazz.cast(io.realm.ZohoCategoryEntityRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ContactlistEntity.class)) {
            return clazz.cast(io.realm.ContactlistEntityRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.DocAvailableEntity.class)) {
            return clazz.cast(io.realm.DocAvailableEntityRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.AccountDtlEntity.class)) {
            return clazz.cast(io.realm.AccountDtlEntityRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.UserConstantEntity.class)) {
            return clazz.cast(io.realm.UserConstantEntityRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackParameterEntity.class)) {
            return clazz.cast(io.realm.LstPackParameterEntityRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity.class)) {
            return clazz.cast(io.realm.LstPackageDetailsEntityRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDEntity.class)) {
            return clazz.cast(io.realm.HealthPackDEntityRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDetailsDBean.class)) {
            return clazz.cast(io.realm.HealthPackDetailsDBeanRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model.CityEntity.class)) {
            return clazz.cast(io.realm.CityEntityRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.express_loan.model.KotakPLEmployerNameEntity.class)) {
            return clazz.cast(io.realm.KotakPLEmployerNameEntityRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.model.DashboardMultiLangEntity.class)) {
            return clazz.cast(io.realm.DashboardMultiLangEntityRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.model.DashboardEntity.class)) {
            return clazz.cast(io.realm.DashboardEntityRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.model.PropertyInfoEntity.class)) {
            return clazz.cast(io.realm.PropertyInfoEntityRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E createUsingJsonStream(Class<E> clazz, Realm realm, JsonReader reader)
        throws IOException {
        checkClass(clazz);

        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.SalesProductEntity.class)) {
            return clazz.cast(io.realm.SalesProductEntityRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.DashboardarrayEntity.class)) {
            return clazz.cast(io.realm.DashboardarrayEntityRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoSubcategoryEntity.class)) {
            return clazz.cast(io.realm.ZohoSubcategoryEntityRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ConstantEntity.class)) {
            return clazz.cast(io.realm.ConstantEntityRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MultiLangEntity.class)) {
            return clazz.cast(io.realm.MultiLangEntityRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.InsuranceSubtypeEntity.class)) {
            return clazz.cast(io.realm.InsuranceSubtypeEntityRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.DocsEntity.class)) {
            return clazz.cast(io.realm.DocsEntityRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.BikeMasterEntity.class)) {
            return clazz.cast(io.realm.BikeMasterEntityRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LifeinsuranceEntity.class)) {
            return clazz.cast(io.realm.LifeinsuranceEntityRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoTicketCategoryEntity.class)) {
            return clazz.cast(io.realm.ZohoTicketCategoryEntityRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.RblCityEntity.class)) {
            return clazz.cast(io.realm.RblCityEntityRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoClassificationEntity.class)) {
            return clazz.cast(io.realm.ZohoClassificationEntityRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity.class)) {
            return clazz.cast(io.realm.LoginResponseEntityRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CarMasterEntity.class)) {
            return clazz.cast(io.realm.CarMasterEntityRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.GeneralinsuranceEntity.class)) {
            return clazz.cast(io.realm.GeneralinsuranceEntityRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CityMasterEntity.class)) {
            return clazz.cast(io.realm.CityMasterEntityRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.HealthinsuranceEntity.class)) {
            return clazz.cast(io.realm.HealthinsuranceEntityRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoCategoryEntity.class)) {
            return clazz.cast(io.realm.ZohoCategoryEntityRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ContactlistEntity.class)) {
            return clazz.cast(io.realm.ContactlistEntityRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.DocAvailableEntity.class)) {
            return clazz.cast(io.realm.DocAvailableEntityRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.AccountDtlEntity.class)) {
            return clazz.cast(io.realm.AccountDtlEntityRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.UserConstantEntity.class)) {
            return clazz.cast(io.realm.UserConstantEntityRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackParameterEntity.class)) {
            return clazz.cast(io.realm.LstPackParameterEntityRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity.class)) {
            return clazz.cast(io.realm.LstPackageDetailsEntityRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDEntity.class)) {
            return clazz.cast(io.realm.HealthPackDEntityRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDetailsDBean.class)) {
            return clazz.cast(io.realm.HealthPackDetailsDBeanRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model.CityEntity.class)) {
            return clazz.cast(io.realm.CityEntityRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.express_loan.model.KotakPLEmployerNameEntity.class)) {
            return clazz.cast(io.realm.KotakPLEmployerNameEntityRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.model.DashboardMultiLangEntity.class)) {
            return clazz.cast(io.realm.DashboardMultiLangEntityRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.model.DashboardEntity.class)) {
            return clazz.cast(io.realm.DashboardEntityRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.model.PropertyInfoEntity.class)) {
            return clazz.cast(io.realm.PropertyInfoEntityRealmProxy.createUsingJsonStream(realm, reader));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E createDetachedCopy(E realmObject, int maxDepth, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) realmObject.getClass().getSuperclass();

        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.SalesProductEntity.class)) {
            return clazz.cast(io.realm.SalesProductEntityRealmProxy.createDetachedCopy((magicfinmart.datacomp.com.finmartserviceapi.finmart.model.SalesProductEntity) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.DashboardarrayEntity.class)) {
            return clazz.cast(io.realm.DashboardarrayEntityRealmProxy.createDetachedCopy((magicfinmart.datacomp.com.finmartserviceapi.finmart.model.DashboardarrayEntity) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoSubcategoryEntity.class)) {
            return clazz.cast(io.realm.ZohoSubcategoryEntityRealmProxy.createDetachedCopy((magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoSubcategoryEntity) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ConstantEntity.class)) {
            return clazz.cast(io.realm.ConstantEntityRealmProxy.createDetachedCopy((magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ConstantEntity) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MultiLangEntity.class)) {
            return clazz.cast(io.realm.MultiLangEntityRealmProxy.createDetachedCopy((magicfinmart.datacomp.com.finmartserviceapi.finmart.model.MultiLangEntity) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.InsuranceSubtypeEntity.class)) {
            return clazz.cast(io.realm.InsuranceSubtypeEntityRealmProxy.createDetachedCopy((magicfinmart.datacomp.com.finmartserviceapi.finmart.model.InsuranceSubtypeEntity) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.DocsEntity.class)) {
            return clazz.cast(io.realm.DocsEntityRealmProxy.createDetachedCopy((magicfinmart.datacomp.com.finmartserviceapi.finmart.model.DocsEntity) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.BikeMasterEntity.class)) {
            return clazz.cast(io.realm.BikeMasterEntityRealmProxy.createDetachedCopy((magicfinmart.datacomp.com.finmartserviceapi.finmart.model.BikeMasterEntity) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LifeinsuranceEntity.class)) {
            return clazz.cast(io.realm.LifeinsuranceEntityRealmProxy.createDetachedCopy((magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LifeinsuranceEntity) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoTicketCategoryEntity.class)) {
            return clazz.cast(io.realm.ZohoTicketCategoryEntityRealmProxy.createDetachedCopy((magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoTicketCategoryEntity) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.RblCityEntity.class)) {
            return clazz.cast(io.realm.RblCityEntityRealmProxy.createDetachedCopy((magicfinmart.datacomp.com.finmartserviceapi.finmart.model.RblCityEntity) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoClassificationEntity.class)) {
            return clazz.cast(io.realm.ZohoClassificationEntityRealmProxy.createDetachedCopy((magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoClassificationEntity) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity.class)) {
            return clazz.cast(io.realm.LoginResponseEntityRealmProxy.createDetachedCopy((magicfinmart.datacomp.com.finmartserviceapi.finmart.model.LoginResponseEntity) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CarMasterEntity.class)) {
            return clazz.cast(io.realm.CarMasterEntityRealmProxy.createDetachedCopy((magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CarMasterEntity) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.GeneralinsuranceEntity.class)) {
            return clazz.cast(io.realm.GeneralinsuranceEntityRealmProxy.createDetachedCopy((magicfinmart.datacomp.com.finmartserviceapi.finmart.model.GeneralinsuranceEntity) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CityMasterEntity.class)) {
            return clazz.cast(io.realm.CityMasterEntityRealmProxy.createDetachedCopy((magicfinmart.datacomp.com.finmartserviceapi.finmart.model.CityMasterEntity) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.HealthinsuranceEntity.class)) {
            return clazz.cast(io.realm.HealthinsuranceEntityRealmProxy.createDetachedCopy((magicfinmart.datacomp.com.finmartserviceapi.finmart.model.HealthinsuranceEntity) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoCategoryEntity.class)) {
            return clazz.cast(io.realm.ZohoCategoryEntityRealmProxy.createDetachedCopy((magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoCategoryEntity) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ContactlistEntity.class)) {
            return clazz.cast(io.realm.ContactlistEntityRealmProxy.createDetachedCopy((magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ContactlistEntity) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.DocAvailableEntity.class)) {
            return clazz.cast(io.realm.DocAvailableEntityRealmProxy.createDetachedCopy((magicfinmart.datacomp.com.finmartserviceapi.finmart.model.DocAvailableEntity) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.AccountDtlEntity.class)) {
            return clazz.cast(io.realm.AccountDtlEntityRealmProxy.createDetachedCopy((magicfinmart.datacomp.com.finmartserviceapi.finmart.model.AccountDtlEntity) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.UserConstantEntity.class)) {
            return clazz.cast(io.realm.UserConstantEntityRealmProxy.createDetachedCopy((magicfinmart.datacomp.com.finmartserviceapi.finmart.model.UserConstantEntity) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackParameterEntity.class)) {
            return clazz.cast(io.realm.LstPackParameterEntityRealmProxy.createDetachedCopy((magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackParameterEntity) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity.class)) {
            return clazz.cast(io.realm.LstPackageDetailsEntityRealmProxy.createDetachedCopy((magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.LstPackageDetailsEntity) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDEntity.class)) {
            return clazz.cast(io.realm.HealthPackDEntityRealmProxy.createDetachedCopy((magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDEntity) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDetailsDBean.class)) {
            return clazz.cast(io.realm.HealthPackDetailsDBeanRealmProxy.createDetachedCopy((magicfinmart.datacomp.com.finmartserviceapi.healthcheckup.model.HealthPackDetailsDBean) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model.CityEntity.class)) {
            return clazz.cast(io.realm.CityEntityRealmProxy.createDetachedCopy((magicfinmart.datacomp.com.finmartserviceapi.loan_fm.model.CityEntity) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.express_loan.model.KotakPLEmployerNameEntity.class)) {
            return clazz.cast(io.realm.KotakPLEmployerNameEntityRealmProxy.createDetachedCopy((magicfinmart.datacomp.com.finmartserviceapi.express_loan.model.KotakPLEmployerNameEntity) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.model.DashboardMultiLangEntity.class)) {
            return clazz.cast(io.realm.DashboardMultiLangEntityRealmProxy.createDetachedCopy((magicfinmart.datacomp.com.finmartserviceapi.model.DashboardMultiLangEntity) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.model.DashboardEntity.class)) {
            return clazz.cast(io.realm.DashboardEntityRealmProxy.createDetachedCopy((magicfinmart.datacomp.com.finmartserviceapi.model.DashboardEntity) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(magicfinmart.datacomp.com.finmartserviceapi.model.PropertyInfoEntity.class)) {
            return clazz.cast(io.realm.PropertyInfoEntityRealmProxy.createDetachedCopy((magicfinmart.datacomp.com.finmartserviceapi.model.PropertyInfoEntity) realmObject, 0, maxDepth, cache));
        }
        throw getMissingProxyClassException(clazz);
    }

}
