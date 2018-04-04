package magicfinmart.datacomp.com.finmartserviceapi.inspection.facade;

import android.content.Context;
import android.content.SharedPreferences;



import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.inspection.Constants;
import magicfinmart.datacomp.com.finmartserviceapi.inspection.entity.FrontRearEntity;


/**
 * Created by Rajeev Ranjan on 12/12/2017.
 */

public class FrontRearFacade {

    String TAG = "FrontRearFacade";
    Context mContext;

    public FrontRearFacade(Context context) {
        mContext = context;
    }

    //region FRONT REAR

    public void storeFrontRear(List<FrontRearEntity> frontRearEntities) {

        SharedPreferences sharedPreferences = mContext.getSharedPreferences(Constants.SHARED_PREFERENCE_POLICYBOSS, mContext.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        editor.putString(Constants.FRONTREAR, gson.toJson(frontRearEntities));
        editor.commit();
    }

    public List<FrontRearEntity> getFrontRearList() {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(Constants.SHARED_PREFERENCE_POLICYBOSS, mContext.MODE_PRIVATE);


        String frontRearList = sharedPreferences.getString(Constants.FRONTREAR, null);
        if (!frontRearList.matches("")) {
            Type type = new TypeToken<List<FrontRearEntity>>() {
            }.getType();
            List<FrontRearEntity> frontRearEntities = new Gson().fromJson(frontRearList, type);
            return frontRearEntities;
        }
        return null;
    }

    public List<FrontRearEntity> setListFrontEntity() {
        List<FrontRearEntity> frontRearEntities = new ArrayList<FrontRearEntity>();
        frontRearEntities.add(new FrontRearEntity("Front Bumper", 0));
        frontRearEntities.add(new FrontRearEntity("Indicator Light(LT)", 1));
        frontRearEntities.add(new FrontRearEntity("Front Panel", 2));
        frontRearEntities.add(new FrontRearEntity("Dicky", 3));
        frontRearEntities.add(new FrontRearEntity("Grill", 4));
        frontRearEntities.add(new FrontRearEntity("Indicator Light(RT)", 5));
        frontRearEntities.add(new FrontRearEntity("Bonnet", 6));
        frontRearEntities.add(new FrontRearEntity("Rear Bumper", 7));
        frontRearEntities.add(new FrontRearEntity("Head Lamp(LT)", 8));
        frontRearEntities.add(new FrontRearEntity("Fog Lamp(LT)", 9));
        frontRearEntities.add(new FrontRearEntity("Left Apron", 10));
        frontRearEntities.add(new FrontRearEntity("Tail Lamp(LT)", 11));
        frontRearEntities.add(new FrontRearEntity("Head Lamp(RT)", 12));
        frontRearEntities.add(new FrontRearEntity("Fog Lamp(RT)", 13));
        frontRearEntities.add(new FrontRearEntity("Right Apron", 14));
        frontRearEntities.add(new FrontRearEntity("Tail Lamp(RT)", 15));
        return frontRearEntities;
    }


    public void updateFrontEntity(FrontRearEntity frontRearEntity, String value) {
        List<FrontRearEntity> frontRearEntities = getFrontRearList();
        for (int i = 0; i < frontRearEntities.size(); i++) {
            FrontRearEntity entity = frontRearEntities.get(i);
            if (entity.getId() == frontRearEntity.getId()) {
                frontRearEntities.get(i).setValue(value);
                storeFrontRear(frontRearEntities);
                break;
            }

        }
    }

    //endregion

    //region LEFT

    public void storeLeft(List<FrontRearEntity> frontRearEntities) {

        SharedPreferences sharedPreferences = mContext.getSharedPreferences(Constants.SHARED_PREFERENCE_POLICYBOSS, mContext.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        editor.putString(Constants.LEFT, gson.toJson(frontRearEntities));
        editor.commit();
    }

    public List<FrontRearEntity> getLeftList() {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(Constants.SHARED_PREFERENCE_POLICYBOSS, mContext.MODE_PRIVATE);


        String frontRearList = sharedPreferences.getString(Constants.LEFT, null);
        if (!frontRearList.matches("")) {
            Type type = new TypeToken<List<FrontRearEntity>>() {
            }.getType();
            List<FrontRearEntity> frontRearEntities = new Gson().fromJson(frontRearList, type);
            return frontRearEntities;
        }
        return null;
    }

    public List<FrontRearEntity> setListLeftEntity() {
        List<FrontRearEntity> frontRearEntities = new ArrayList<FrontRearEntity>();
        frontRearEntities.add(new FrontRearEntity("Front Fender(LT)", 0));
        frontRearEntities.add(new FrontRearEntity("Front Door(LT)", 1));
        frontRearEntities.add(new FrontRearEntity("Rear Door(LT)", 2));
        frontRearEntities.add(new FrontRearEntity("Running Board(LT)", 3));
        frontRearEntities.add(new FrontRearEntity("LT Pillar Door(A)", 4));
        frontRearEntities.add(new FrontRearEntity("LT Pillar Centre(B)", 5));
        frontRearEntities.add(new FrontRearEntity("LT Pillar Rear(C)", 6));
        frontRearEntities.add(new FrontRearEntity("Qtr Panel(LT)", 7));
        return frontRearEntities;
    }

    public void updateLeftEntity(FrontRearEntity frontRearEntity, String value) {
        List<FrontRearEntity> frontRearEntities = getLeftList();
        for (int i = 0; i < frontRearEntities.size(); i++) {
            FrontRearEntity entity = frontRearEntities.get(i);
            if (entity.getId() == frontRearEntity.getId()) {
                frontRearEntities.get(i).setValue(value);
                storeLeft(frontRearEntities);
                break;
            }

        }
    }

    //endregion

    //region RIGHT

    public void storeRight(List<FrontRearEntity> frontRearEntities) {

        SharedPreferences sharedPreferences = mContext.getSharedPreferences(Constants.SHARED_PREFERENCE_POLICYBOSS, mContext.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        editor.putString(Constants.RIGHT, gson.toJson(frontRearEntities));
        editor.commit();
    }

    public List<FrontRearEntity> getRightList() {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(Constants.SHARED_PREFERENCE_POLICYBOSS, mContext.MODE_PRIVATE);


        String frontRearList = sharedPreferences.getString(Constants.RIGHT, null);
        if (!frontRearList.matches("")) {
            Type type = new TypeToken<List<FrontRearEntity>>() {
            }.getType();
            List<FrontRearEntity> frontRearEntities = new Gson().fromJson(frontRearList, type);
            return frontRearEntities;
        }
        return null;
    }

    public List<FrontRearEntity> setListRightEntity() {
        List<FrontRearEntity> frontRearEntities = new ArrayList<FrontRearEntity>();

        frontRearEntities.add(new FrontRearEntity("Qtr Panel(RT)", 0));
        frontRearEntities.add(new FrontRearEntity("Rear Door(RT)", 1));
        frontRearEntities.add(new FrontRearEntity("Front Door(RT)", 2));
        frontRearEntities.add(new FrontRearEntity("RT Front Pillar(A)", 3));
        frontRearEntities.add(new FrontRearEntity("RT Centre Pillar(B)", 4));
        frontRearEntities.add(new FrontRearEntity("RT Rear Pillar(C)", 5));
        frontRearEntities.add(new FrontRearEntity("Running Board(RT)", 6));
        frontRearEntities.add(new FrontRearEntity("Front Fender(RT)", 7));
        frontRearEntities.add(new FrontRearEntity("Floor/Silencer", 8));
        frontRearEntities.add(new FrontRearEntity("Rear View Mirror (LT)", 9));
        frontRearEntities.add(new FrontRearEntity("Rear View Mirror (RT)", 10));
        frontRearEntities.add(new FrontRearEntity("Tyres", 11));

        return frontRearEntities;
    }

    public void updateRightEntity(FrontRearEntity frontRearEntity, String value) {
        List<FrontRearEntity> frontRearEntities = getRightList();
        for (int i = 0; i < frontRearEntities.size(); i++) {
            FrontRearEntity entity = frontRearEntities.get(i);
            if (entity.getId() == frontRearEntity.getId()) {
                frontRearEntities.get(i).setValue(value);
                storeRight(frontRearEntities);
                break;
            }

        }
    }

    //endregion

    //region GLASS

    public void storeGlass(List<FrontRearEntity> frontRearEntities) {

        SharedPreferences sharedPreferences = mContext.getSharedPreferences(Constants.SHARED_PREFERENCE_POLICYBOSS, mContext.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        editor.putString(Constants.GLASS, gson.toJson(frontRearEntities));
        editor.commit();
    }

    public List<FrontRearEntity> getGlassList() {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(Constants.SHARED_PREFERENCE_POLICYBOSS, mContext.MODE_PRIVATE);


        String frontRearList = sharedPreferences.getString(Constants.GLASS, null);
        if (!frontRearList.matches("")) {
            Type type = new TypeToken<List<FrontRearEntity>>() {
            }.getType();
            List<FrontRearEntity> frontRearEntities = new Gson().fromJson(frontRearList, type);
            return frontRearEntities;
        }
        return null;
    }

    public List<FrontRearEntity> setListGlassEntity() {
        List<FrontRearEntity> frontRearEntities = new ArrayList<FrontRearEntity>();

        frontRearEntities.add(new FrontRearEntity("Back Glass", 0));
        frontRearEntities.add(new FrontRearEntity("Front ws Glass Laminated", 1));
        frontRearEntities.add(new FrontRearEntity("RF Door Glass", 2));
        frontRearEntities.add(new FrontRearEntity("RR Door Glass", 3));
        frontRearEntities.add(new FrontRearEntity("LF Door Glass", 4));
        frontRearEntities.add(new FrontRearEntity("LR Door Glass", 5));
        frontRearEntities.add(new FrontRearEntity("Rim", 6));
        frontRearEntities.add(new FrontRearEntity("Under Carriage", 7));
        return frontRearEntities;
    }

    public void updateGlassEntity(FrontRearEntity frontRearEntity, String value) {
        List<FrontRearEntity> frontRearEntities = getGlassList();
        for (int i = 0; i < frontRearEntities.size(); i++) {
            FrontRearEntity entity = frontRearEntities.get(i);
            if (entity.getId() == frontRearEntity.getId()) {
                frontRearEntities.get(i).setValue(value);
                storeGlass(frontRearEntities);
                break;
            }

        }
    }

    //endregion
}
