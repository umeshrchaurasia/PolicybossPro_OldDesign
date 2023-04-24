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
public class ZohoTicketCategoryEntityRealmProxy extends magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoTicketCategoryEntity
    implements RealmObjectProxy, ZohoTicketCategoryEntityRealmProxyInterface {

    static final class ZohoTicketCategoryEntityColumnInfo extends ColumnInfo {
        long categoryIndex;
        long subcategoryIndex;
        long classificationIndex;

        ZohoTicketCategoryEntityColumnInfo(OsSchemaInfo schemaInfo) {
            super(3);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("ZohoTicketCategoryEntity");
            this.categoryIndex = addColumnDetails("category", objectSchemaInfo);
            this.subcategoryIndex = addColumnDetails("subcategory", objectSchemaInfo);
            this.classificationIndex = addColumnDetails("classification", objectSchemaInfo);
        }

        ZohoTicketCategoryEntityColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new ZohoTicketCategoryEntityColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final ZohoTicketCategoryEntityColumnInfo src = (ZohoTicketCategoryEntityColumnInfo) rawSrc;
            final ZohoTicketCategoryEntityColumnInfo dst = (ZohoTicketCategoryEntityColumnInfo) rawDst;
            dst.categoryIndex = src.categoryIndex;
            dst.subcategoryIndex = src.subcategoryIndex;
            dst.classificationIndex = src.classificationIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>(3);
        fieldNames.add("category");
        fieldNames.add("subcategory");
        fieldNames.add("classification");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    private ZohoTicketCategoryEntityColumnInfo columnInfo;
    private ProxyState<magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoTicketCategoryEntity> proxyState;
    private RealmList<magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoCategoryEntity> categoryRealmList;
    private RealmList<magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoSubcategoryEntity> subcategoryRealmList;
    private RealmList<magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoClassificationEntity> classificationRealmList;

    ZohoTicketCategoryEntityRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (ZohoTicketCategoryEntityColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoTicketCategoryEntity>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    public RealmList<magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoCategoryEntity> realmGet$category() {
        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (categoryRealmList != null) {
            return categoryRealmList;
        } else {
            OsList osList = proxyState.getRow$realm().getModelList(columnInfo.categoryIndex);
            categoryRealmList = new RealmList<magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoCategoryEntity>(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoCategoryEntity.class, osList, proxyState.getRealm$realm());
            return categoryRealmList;
        }
    }

    @Override
    public void realmSet$category(RealmList<magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoCategoryEntity> value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("category")) {
                return;
            }
            // if the list contains unmanaged RealmObjects, convert them to managed.
            if (value != null && !value.isManaged()) {
                final Realm realm = (Realm) proxyState.getRealm$realm();
                final RealmList<magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoCategoryEntity> original = value;
                value = new RealmList<magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoCategoryEntity>();
                for (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoCategoryEntity item : original) {
                    if (item == null || RealmObject.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.copyToRealm(item));
                    }
                }
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        OsList osList = proxyState.getRow$realm().getModelList(columnInfo.categoryIndex);
        // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
        if (value != null && value.size() == osList.size()) {
            int objects = value.size();
            for (int i = 0; i < objects; i++) {
                magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoCategoryEntity linkedObject = value.get(i);
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
                magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoCategoryEntity linkedObject = value.get(i);
                proxyState.checkValidObject(linkedObject);
                osList.addRow(((RealmObjectProxy) linkedObject).realmGet$proxyState().getRow$realm().getIndex());
            }
        }
    }

    @Override
    public RealmList<magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoSubcategoryEntity> realmGet$subcategory() {
        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (subcategoryRealmList != null) {
            return subcategoryRealmList;
        } else {
            OsList osList = proxyState.getRow$realm().getModelList(columnInfo.subcategoryIndex);
            subcategoryRealmList = new RealmList<magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoSubcategoryEntity>(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoSubcategoryEntity.class, osList, proxyState.getRealm$realm());
            return subcategoryRealmList;
        }
    }

    @Override
    public void realmSet$subcategory(RealmList<magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoSubcategoryEntity> value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("subcategory")) {
                return;
            }
            // if the list contains unmanaged RealmObjects, convert them to managed.
            if (value != null && !value.isManaged()) {
                final Realm realm = (Realm) proxyState.getRealm$realm();
                final RealmList<magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoSubcategoryEntity> original = value;
                value = new RealmList<magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoSubcategoryEntity>();
                for (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoSubcategoryEntity item : original) {
                    if (item == null || RealmObject.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.copyToRealm(item));
                    }
                }
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        OsList osList = proxyState.getRow$realm().getModelList(columnInfo.subcategoryIndex);
        // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
        if (value != null && value.size() == osList.size()) {
            int objects = value.size();
            for (int i = 0; i < objects; i++) {
                magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoSubcategoryEntity linkedObject = value.get(i);
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
                magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoSubcategoryEntity linkedObject = value.get(i);
                proxyState.checkValidObject(linkedObject);
                osList.addRow(((RealmObjectProxy) linkedObject).realmGet$proxyState().getRow$realm().getIndex());
            }
        }
    }

    @Override
    public RealmList<magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoClassificationEntity> realmGet$classification() {
        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (classificationRealmList != null) {
            return classificationRealmList;
        } else {
            OsList osList = proxyState.getRow$realm().getModelList(columnInfo.classificationIndex);
            classificationRealmList = new RealmList<magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoClassificationEntity>(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoClassificationEntity.class, osList, proxyState.getRealm$realm());
            return classificationRealmList;
        }
    }

    @Override
    public void realmSet$classification(RealmList<magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoClassificationEntity> value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("classification")) {
                return;
            }
            // if the list contains unmanaged RealmObjects, convert them to managed.
            if (value != null && !value.isManaged()) {
                final Realm realm = (Realm) proxyState.getRealm$realm();
                final RealmList<magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoClassificationEntity> original = value;
                value = new RealmList<magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoClassificationEntity>();
                for (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoClassificationEntity item : original) {
                    if (item == null || RealmObject.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.copyToRealm(item));
                    }
                }
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        OsList osList = proxyState.getRow$realm().getModelList(columnInfo.classificationIndex);
        // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
        if (value != null && value.size() == osList.size()) {
            int objects = value.size();
            for (int i = 0; i < objects; i++) {
                magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoClassificationEntity linkedObject = value.get(i);
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
                magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoClassificationEntity linkedObject = value.get(i);
                proxyState.checkValidObject(linkedObject);
                osList.addRow(((RealmObjectProxy) linkedObject).realmGet$proxyState().getRow$realm().getIndex());
            }
        }
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("ZohoTicketCategoryEntity", 3, 0);
        builder.addPersistedLinkProperty("category", RealmFieldType.LIST, "ZohoCategoryEntity");
        builder.addPersistedLinkProperty("subcategory", RealmFieldType.LIST, "ZohoSubcategoryEntity");
        builder.addPersistedLinkProperty("classification", RealmFieldType.LIST, "ZohoClassificationEntity");
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static ZohoTicketCategoryEntityColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new ZohoTicketCategoryEntityColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "ZohoTicketCategoryEntity";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoTicketCategoryEntity createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(3);
        if (json.has("category")) {
            excludeFields.add("category");
        }
        if (json.has("subcategory")) {
            excludeFields.add("subcategory");
        }
        if (json.has("classification")) {
            excludeFields.add("classification");
        }
        magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoTicketCategoryEntity obj = realm.createObjectInternal(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoTicketCategoryEntity.class, true, excludeFields);

        final ZohoTicketCategoryEntityRealmProxyInterface objProxy = (ZohoTicketCategoryEntityRealmProxyInterface) obj;
        if (json.has("category")) {
            if (json.isNull("category")) {
                objProxy.realmSet$category(null);
            } else {
                objProxy.realmGet$category().clear();
                JSONArray array = json.getJSONArray("category");
                for (int i = 0; i < array.length(); i++) {
                    magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoCategoryEntity item = ZohoCategoryEntityRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    objProxy.realmGet$category().add(item);
                }
            }
        }
        if (json.has("subcategory")) {
            if (json.isNull("subcategory")) {
                objProxy.realmSet$subcategory(null);
            } else {
                objProxy.realmGet$subcategory().clear();
                JSONArray array = json.getJSONArray("subcategory");
                for (int i = 0; i < array.length(); i++) {
                    magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoSubcategoryEntity item = ZohoSubcategoryEntityRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    objProxy.realmGet$subcategory().add(item);
                }
            }
        }
        if (json.has("classification")) {
            if (json.isNull("classification")) {
                objProxy.realmSet$classification(null);
            } else {
                objProxy.realmGet$classification().clear();
                JSONArray array = json.getJSONArray("classification");
                for (int i = 0; i < array.length(); i++) {
                    magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoClassificationEntity item = ZohoClassificationEntityRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    objProxy.realmGet$classification().add(item);
                }
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoTicketCategoryEntity createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoTicketCategoryEntity obj = new magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoTicketCategoryEntity();
        final ZohoTicketCategoryEntityRealmProxyInterface objProxy = (ZohoTicketCategoryEntityRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("category")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$category(null);
                } else {
                    objProxy.realmSet$category(new RealmList<magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoCategoryEntity>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoCategoryEntity item = ZohoCategoryEntityRealmProxy.createUsingJsonStream(realm, reader);
                        objProxy.realmGet$category().add(item);
                    }
                    reader.endArray();
                }
            } else if (name.equals("subcategory")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$subcategory(null);
                } else {
                    objProxy.realmSet$subcategory(new RealmList<magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoSubcategoryEntity>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoSubcategoryEntity item = ZohoSubcategoryEntityRealmProxy.createUsingJsonStream(realm, reader);
                        objProxy.realmGet$subcategory().add(item);
                    }
                    reader.endArray();
                }
            } else if (name.equals("classification")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$classification(null);
                } else {
                    objProxy.realmSet$classification(new RealmList<magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoClassificationEntity>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoClassificationEntity item = ZohoClassificationEntityRealmProxy.createUsingJsonStream(realm, reader);
                        objProxy.realmGet$classification().add(item);
                    }
                    reader.endArray();
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    public static magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoTicketCategoryEntity copyOrUpdate(Realm realm, magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoTicketCategoryEntity object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoTicketCategoryEntity) cachedRealmObject;
        }

        return copy(realm, object, update, cache);
    }

    public static magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoTicketCategoryEntity copy(Realm realm, magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoTicketCategoryEntity newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoTicketCategoryEntity) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoTicketCategoryEntity realmObject = realm.createObjectInternal(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoTicketCategoryEntity.class, false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        ZohoTicketCategoryEntityRealmProxyInterface realmObjectSource = (ZohoTicketCategoryEntityRealmProxyInterface) newObject;
        ZohoTicketCategoryEntityRealmProxyInterface realmObjectCopy = (ZohoTicketCategoryEntityRealmProxyInterface) realmObject;


        RealmList<magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoCategoryEntity> categoryList = realmObjectSource.realmGet$category();
        if (categoryList != null) {
            RealmList<magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoCategoryEntity> categoryRealmList = realmObjectCopy.realmGet$category();
            categoryRealmList.clear();
            for (int i = 0; i < categoryList.size(); i++) {
                magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoCategoryEntity categoryItem = categoryList.get(i);
                magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoCategoryEntity cachecategory = (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoCategoryEntity) cache.get(categoryItem);
                if (cachecategory != null) {
                    categoryRealmList.add(cachecategory);
                } else {
                    categoryRealmList.add(ZohoCategoryEntityRealmProxy.copyOrUpdate(realm, categoryItem, update, cache));
                }
            }
        }


        RealmList<magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoSubcategoryEntity> subcategoryList = realmObjectSource.realmGet$subcategory();
        if (subcategoryList != null) {
            RealmList<magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoSubcategoryEntity> subcategoryRealmList = realmObjectCopy.realmGet$subcategory();
            subcategoryRealmList.clear();
            for (int i = 0; i < subcategoryList.size(); i++) {
                magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoSubcategoryEntity subcategoryItem = subcategoryList.get(i);
                magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoSubcategoryEntity cachesubcategory = (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoSubcategoryEntity) cache.get(subcategoryItem);
                if (cachesubcategory != null) {
                    subcategoryRealmList.add(cachesubcategory);
                } else {
                    subcategoryRealmList.add(ZohoSubcategoryEntityRealmProxy.copyOrUpdate(realm, subcategoryItem, update, cache));
                }
            }
        }


        RealmList<magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoClassificationEntity> classificationList = realmObjectSource.realmGet$classification();
        if (classificationList != null) {
            RealmList<magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoClassificationEntity> classificationRealmList = realmObjectCopy.realmGet$classification();
            classificationRealmList.clear();
            for (int i = 0; i < classificationList.size(); i++) {
                magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoClassificationEntity classificationItem = classificationList.get(i);
                magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoClassificationEntity cacheclassification = (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoClassificationEntity) cache.get(classificationItem);
                if (cacheclassification != null) {
                    classificationRealmList.add(cacheclassification);
                } else {
                    classificationRealmList.add(ZohoClassificationEntityRealmProxy.copyOrUpdate(realm, classificationItem, update, cache));
                }
            }
        }

        return realmObject;
    }

    public static long insert(Realm realm, magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoTicketCategoryEntity object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoTicketCategoryEntity.class);
        long tableNativePtr = table.getNativePtr();
        ZohoTicketCategoryEntityColumnInfo columnInfo = (ZohoTicketCategoryEntityColumnInfo) realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoTicketCategoryEntity.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);

        RealmList<magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoCategoryEntity> categoryList = ((ZohoTicketCategoryEntityRealmProxyInterface) object).realmGet$category();
        if (categoryList != null) {
            OsList categoryOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.categoryIndex);
            for (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoCategoryEntity categoryItem : categoryList) {
                Long cacheItemIndexcategory = cache.get(categoryItem);
                if (cacheItemIndexcategory == null) {
                    cacheItemIndexcategory = ZohoCategoryEntityRealmProxy.insert(realm, categoryItem, cache);
                }
                categoryOsList.addRow(cacheItemIndexcategory);
            }
        }

        RealmList<magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoSubcategoryEntity> subcategoryList = ((ZohoTicketCategoryEntityRealmProxyInterface) object).realmGet$subcategory();
        if (subcategoryList != null) {
            OsList subcategoryOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.subcategoryIndex);
            for (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoSubcategoryEntity subcategoryItem : subcategoryList) {
                Long cacheItemIndexsubcategory = cache.get(subcategoryItem);
                if (cacheItemIndexsubcategory == null) {
                    cacheItemIndexsubcategory = ZohoSubcategoryEntityRealmProxy.insert(realm, subcategoryItem, cache);
                }
                subcategoryOsList.addRow(cacheItemIndexsubcategory);
            }
        }

        RealmList<magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoClassificationEntity> classificationList = ((ZohoTicketCategoryEntityRealmProxyInterface) object).realmGet$classification();
        if (classificationList != null) {
            OsList classificationOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.classificationIndex);
            for (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoClassificationEntity classificationItem : classificationList) {
                Long cacheItemIndexclassification = cache.get(classificationItem);
                if (cacheItemIndexclassification == null) {
                    cacheItemIndexclassification = ZohoClassificationEntityRealmProxy.insert(realm, classificationItem, cache);
                }
                classificationOsList.addRow(cacheItemIndexclassification);
            }
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoTicketCategoryEntity.class);
        long tableNativePtr = table.getNativePtr();
        ZohoTicketCategoryEntityColumnInfo columnInfo = (ZohoTicketCategoryEntityColumnInfo) realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoTicketCategoryEntity.class);
        magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoTicketCategoryEntity object = null;
        while (objects.hasNext()) {
            object = (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoTicketCategoryEntity) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);

            RealmList<magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoCategoryEntity> categoryList = ((ZohoTicketCategoryEntityRealmProxyInterface) object).realmGet$category();
            if (categoryList != null) {
                OsList categoryOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.categoryIndex);
                for (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoCategoryEntity categoryItem : categoryList) {
                    Long cacheItemIndexcategory = cache.get(categoryItem);
                    if (cacheItemIndexcategory == null) {
                        cacheItemIndexcategory = ZohoCategoryEntityRealmProxy.insert(realm, categoryItem, cache);
                    }
                    categoryOsList.addRow(cacheItemIndexcategory);
                }
            }

            RealmList<magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoSubcategoryEntity> subcategoryList = ((ZohoTicketCategoryEntityRealmProxyInterface) object).realmGet$subcategory();
            if (subcategoryList != null) {
                OsList subcategoryOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.subcategoryIndex);
                for (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoSubcategoryEntity subcategoryItem : subcategoryList) {
                    Long cacheItemIndexsubcategory = cache.get(subcategoryItem);
                    if (cacheItemIndexsubcategory == null) {
                        cacheItemIndexsubcategory = ZohoSubcategoryEntityRealmProxy.insert(realm, subcategoryItem, cache);
                    }
                    subcategoryOsList.addRow(cacheItemIndexsubcategory);
                }
            }

            RealmList<magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoClassificationEntity> classificationList = ((ZohoTicketCategoryEntityRealmProxyInterface) object).realmGet$classification();
            if (classificationList != null) {
                OsList classificationOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.classificationIndex);
                for (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoClassificationEntity classificationItem : classificationList) {
                    Long cacheItemIndexclassification = cache.get(classificationItem);
                    if (cacheItemIndexclassification == null) {
                        cacheItemIndexclassification = ZohoClassificationEntityRealmProxy.insert(realm, classificationItem, cache);
                    }
                    classificationOsList.addRow(cacheItemIndexclassification);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoTicketCategoryEntity object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoTicketCategoryEntity.class);
        long tableNativePtr = table.getNativePtr();
        ZohoTicketCategoryEntityColumnInfo columnInfo = (ZohoTicketCategoryEntityColumnInfo) realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoTicketCategoryEntity.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);

        OsList categoryOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.categoryIndex);
        RealmList<magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoCategoryEntity> categoryList = ((ZohoTicketCategoryEntityRealmProxyInterface) object).realmGet$category();
        if (categoryList != null && categoryList.size() == categoryOsList.size()) {
            // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
            int objects = categoryList.size();
            for (int i = 0; i < objects; i++) {
                magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoCategoryEntity categoryItem = categoryList.get(i);
                Long cacheItemIndexcategory = cache.get(categoryItem);
                if (cacheItemIndexcategory == null) {
                    cacheItemIndexcategory = ZohoCategoryEntityRealmProxy.insertOrUpdate(realm, categoryItem, cache);
                }
                categoryOsList.setRow(i, cacheItemIndexcategory);
            }
        } else {
            categoryOsList.removeAll();
            if (categoryList != null) {
                for (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoCategoryEntity categoryItem : categoryList) {
                    Long cacheItemIndexcategory = cache.get(categoryItem);
                    if (cacheItemIndexcategory == null) {
                        cacheItemIndexcategory = ZohoCategoryEntityRealmProxy.insertOrUpdate(realm, categoryItem, cache);
                    }
                    categoryOsList.addRow(cacheItemIndexcategory);
                }
            }
        }


        OsList subcategoryOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.subcategoryIndex);
        RealmList<magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoSubcategoryEntity> subcategoryList = ((ZohoTicketCategoryEntityRealmProxyInterface) object).realmGet$subcategory();
        if (subcategoryList != null && subcategoryList.size() == subcategoryOsList.size()) {
            // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
            int objects = subcategoryList.size();
            for (int i = 0; i < objects; i++) {
                magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoSubcategoryEntity subcategoryItem = subcategoryList.get(i);
                Long cacheItemIndexsubcategory = cache.get(subcategoryItem);
                if (cacheItemIndexsubcategory == null) {
                    cacheItemIndexsubcategory = ZohoSubcategoryEntityRealmProxy.insertOrUpdate(realm, subcategoryItem, cache);
                }
                subcategoryOsList.setRow(i, cacheItemIndexsubcategory);
            }
        } else {
            subcategoryOsList.removeAll();
            if (subcategoryList != null) {
                for (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoSubcategoryEntity subcategoryItem : subcategoryList) {
                    Long cacheItemIndexsubcategory = cache.get(subcategoryItem);
                    if (cacheItemIndexsubcategory == null) {
                        cacheItemIndexsubcategory = ZohoSubcategoryEntityRealmProxy.insertOrUpdate(realm, subcategoryItem, cache);
                    }
                    subcategoryOsList.addRow(cacheItemIndexsubcategory);
                }
            }
        }


        OsList classificationOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.classificationIndex);
        RealmList<magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoClassificationEntity> classificationList = ((ZohoTicketCategoryEntityRealmProxyInterface) object).realmGet$classification();
        if (classificationList != null && classificationList.size() == classificationOsList.size()) {
            // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
            int objects = classificationList.size();
            for (int i = 0; i < objects; i++) {
                magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoClassificationEntity classificationItem = classificationList.get(i);
                Long cacheItemIndexclassification = cache.get(classificationItem);
                if (cacheItemIndexclassification == null) {
                    cacheItemIndexclassification = ZohoClassificationEntityRealmProxy.insertOrUpdate(realm, classificationItem, cache);
                }
                classificationOsList.setRow(i, cacheItemIndexclassification);
            }
        } else {
            classificationOsList.removeAll();
            if (classificationList != null) {
                for (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoClassificationEntity classificationItem : classificationList) {
                    Long cacheItemIndexclassification = cache.get(classificationItem);
                    if (cacheItemIndexclassification == null) {
                        cacheItemIndexclassification = ZohoClassificationEntityRealmProxy.insertOrUpdate(realm, classificationItem, cache);
                    }
                    classificationOsList.addRow(cacheItemIndexclassification);
                }
            }
        }

        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoTicketCategoryEntity.class);
        long tableNativePtr = table.getNativePtr();
        ZohoTicketCategoryEntityColumnInfo columnInfo = (ZohoTicketCategoryEntityColumnInfo) realm.getSchema().getColumnInfo(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoTicketCategoryEntity.class);
        magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoTicketCategoryEntity object = null;
        while (objects.hasNext()) {
            object = (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoTicketCategoryEntity) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);

            OsList categoryOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.categoryIndex);
            RealmList<magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoCategoryEntity> categoryList = ((ZohoTicketCategoryEntityRealmProxyInterface) object).realmGet$category();
            if (categoryList != null && categoryList.size() == categoryOsList.size()) {
                // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
                int objectCount = categoryList.size();
                for (int i = 0; i < objectCount; i++) {
                    magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoCategoryEntity categoryItem = categoryList.get(i);
                    Long cacheItemIndexcategory = cache.get(categoryItem);
                    if (cacheItemIndexcategory == null) {
                        cacheItemIndexcategory = ZohoCategoryEntityRealmProxy.insertOrUpdate(realm, categoryItem, cache);
                    }
                    categoryOsList.setRow(i, cacheItemIndexcategory);
                }
            } else {
                categoryOsList.removeAll();
                if (categoryList != null) {
                    for (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoCategoryEntity categoryItem : categoryList) {
                        Long cacheItemIndexcategory = cache.get(categoryItem);
                        if (cacheItemIndexcategory == null) {
                            cacheItemIndexcategory = ZohoCategoryEntityRealmProxy.insertOrUpdate(realm, categoryItem, cache);
                        }
                        categoryOsList.addRow(cacheItemIndexcategory);
                    }
                }
            }


            OsList subcategoryOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.subcategoryIndex);
            RealmList<magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoSubcategoryEntity> subcategoryList = ((ZohoTicketCategoryEntityRealmProxyInterface) object).realmGet$subcategory();
            if (subcategoryList != null && subcategoryList.size() == subcategoryOsList.size()) {
                // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
                int objectCount = subcategoryList.size();
                for (int i = 0; i < objectCount; i++) {
                    magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoSubcategoryEntity subcategoryItem = subcategoryList.get(i);
                    Long cacheItemIndexsubcategory = cache.get(subcategoryItem);
                    if (cacheItemIndexsubcategory == null) {
                        cacheItemIndexsubcategory = ZohoSubcategoryEntityRealmProxy.insertOrUpdate(realm, subcategoryItem, cache);
                    }
                    subcategoryOsList.setRow(i, cacheItemIndexsubcategory);
                }
            } else {
                subcategoryOsList.removeAll();
                if (subcategoryList != null) {
                    for (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoSubcategoryEntity subcategoryItem : subcategoryList) {
                        Long cacheItemIndexsubcategory = cache.get(subcategoryItem);
                        if (cacheItemIndexsubcategory == null) {
                            cacheItemIndexsubcategory = ZohoSubcategoryEntityRealmProxy.insertOrUpdate(realm, subcategoryItem, cache);
                        }
                        subcategoryOsList.addRow(cacheItemIndexsubcategory);
                    }
                }
            }


            OsList classificationOsList = new OsList(table.getUncheckedRow(rowIndex), columnInfo.classificationIndex);
            RealmList<magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoClassificationEntity> classificationList = ((ZohoTicketCategoryEntityRealmProxyInterface) object).realmGet$classification();
            if (classificationList != null && classificationList.size() == classificationOsList.size()) {
                // For lists of equal lengths, we need to set each element directly as clearing the receiver list can be wrong if the input and target list are the same.
                int objectCount = classificationList.size();
                for (int i = 0; i < objectCount; i++) {
                    magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoClassificationEntity classificationItem = classificationList.get(i);
                    Long cacheItemIndexclassification = cache.get(classificationItem);
                    if (cacheItemIndexclassification == null) {
                        cacheItemIndexclassification = ZohoClassificationEntityRealmProxy.insertOrUpdate(realm, classificationItem, cache);
                    }
                    classificationOsList.setRow(i, cacheItemIndexclassification);
                }
            } else {
                classificationOsList.removeAll();
                if (classificationList != null) {
                    for (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoClassificationEntity classificationItem : classificationList) {
                        Long cacheItemIndexclassification = cache.get(classificationItem);
                        if (cacheItemIndexclassification == null) {
                            cacheItemIndexclassification = ZohoClassificationEntityRealmProxy.insertOrUpdate(realm, classificationItem, cache);
                        }
                        classificationOsList.addRow(cacheItemIndexclassification);
                    }
                }
            }

        }
    }

    public static magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoTicketCategoryEntity createDetachedCopy(magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoTicketCategoryEntity realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoTicketCategoryEntity unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoTicketCategoryEntity();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoTicketCategoryEntity) cachedObject.object;
            }
            unmanagedObject = (magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoTicketCategoryEntity) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        ZohoTicketCategoryEntityRealmProxyInterface unmanagedCopy = (ZohoTicketCategoryEntityRealmProxyInterface) unmanagedObject;
        ZohoTicketCategoryEntityRealmProxyInterface realmSource = (ZohoTicketCategoryEntityRealmProxyInterface) realmObject;

        // Deep copy of category
        if (currentDepth == maxDepth) {
            unmanagedCopy.realmSet$category(null);
        } else {
            RealmList<magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoCategoryEntity> managedcategoryList = realmSource.realmGet$category();
            RealmList<magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoCategoryEntity> unmanagedcategoryList = new RealmList<magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoCategoryEntity>();
            unmanagedCopy.realmSet$category(unmanagedcategoryList);
            int nextDepth = currentDepth + 1;
            int size = managedcategoryList.size();
            for (int i = 0; i < size; i++) {
                magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoCategoryEntity item = ZohoCategoryEntityRealmProxy.createDetachedCopy(managedcategoryList.get(i), nextDepth, maxDepth, cache);
                unmanagedcategoryList.add(item);
            }
        }

        // Deep copy of subcategory
        if (currentDepth == maxDepth) {
            unmanagedCopy.realmSet$subcategory(null);
        } else {
            RealmList<magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoSubcategoryEntity> managedsubcategoryList = realmSource.realmGet$subcategory();
            RealmList<magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoSubcategoryEntity> unmanagedsubcategoryList = new RealmList<magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoSubcategoryEntity>();
            unmanagedCopy.realmSet$subcategory(unmanagedsubcategoryList);
            int nextDepth = currentDepth + 1;
            int size = managedsubcategoryList.size();
            for (int i = 0; i < size; i++) {
                magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoSubcategoryEntity item = ZohoSubcategoryEntityRealmProxy.createDetachedCopy(managedsubcategoryList.get(i), nextDepth, maxDepth, cache);
                unmanagedsubcategoryList.add(item);
            }
        }

        // Deep copy of classification
        if (currentDepth == maxDepth) {
            unmanagedCopy.realmSet$classification(null);
        } else {
            RealmList<magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoClassificationEntity> managedclassificationList = realmSource.realmGet$classification();
            RealmList<magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoClassificationEntity> unmanagedclassificationList = new RealmList<magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoClassificationEntity>();
            unmanagedCopy.realmSet$classification(unmanagedclassificationList);
            int nextDepth = currentDepth + 1;
            int size = managedclassificationList.size();
            for (int i = 0; i < size; i++) {
                magicfinmart.datacomp.com.finmartserviceapi.finmart.model.ZohoClassificationEntity item = ZohoClassificationEntityRealmProxy.createDetachedCopy(managedclassificationList.get(i), nextDepth, maxDepth, cache);
                unmanagedclassificationList.add(item);
            }
        }

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("ZohoTicketCategoryEntity = proxy[");
        stringBuilder.append("{category:");
        stringBuilder.append("RealmList<ZohoCategoryEntity>[").append(realmGet$category().size()).append("]");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{subcategory:");
        stringBuilder.append("RealmList<ZohoSubcategoryEntity>[").append(realmGet$subcategory().size()).append("]");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{classification:");
        stringBuilder.append("RealmList<ZohoClassificationEntity>[").append(realmGet$classification().size()).append("]");
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
        ZohoTicketCategoryEntityRealmProxy aZohoTicketCategoryEntity = (ZohoTicketCategoryEntityRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aZohoTicketCategoryEntity.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aZohoTicketCategoryEntity.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aZohoTicketCategoryEntity.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
