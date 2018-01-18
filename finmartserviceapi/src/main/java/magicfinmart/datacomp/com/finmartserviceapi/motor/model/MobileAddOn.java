package magicfinmart.datacomp.com.finmartserviceapi.motor.model;

public class MobileAddOn {

    public String AddonName;
    public double min;
    public double max;
    public String AddonKey;
    public boolean isSelected;

    public String getAddonName() {
        return AddonName;
    }

    public void setAddonName(String addonName) {
        AddonName = addonName;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public String getAddonKey() {
        return AddonKey;
    }

    public void setAddonKey(String addonKey) {
        AddonKey = addonKey;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}