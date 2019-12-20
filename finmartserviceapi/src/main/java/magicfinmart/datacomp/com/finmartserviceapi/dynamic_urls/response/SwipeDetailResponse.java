package magicfinmart.datacomp.com.finmartserviceapi.dynamic_urls.response;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.dynamic_urls.model.SwipeDetailsEntity;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;

/**
 * Created by IN-RB on 12-04-2017.
 */

public class SwipeDetailResponse extends APIResponse {


    private List<SwipeDetailsEntity> SwipeDetails;

    public List<SwipeDetailsEntity> getSwipeDetails() {
        return SwipeDetails;
    }

    public void setSwipeDetails(List<SwipeDetailsEntity> SwipeDetails) {
        this.SwipeDetails = SwipeDetails;
    }


}
