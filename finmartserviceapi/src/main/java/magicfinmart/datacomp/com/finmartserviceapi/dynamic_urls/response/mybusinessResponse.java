package magicfinmart.datacomp.com.finmartserviceapi.dynamic_urls.response;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;

/**
 * Created by IN-RB on 16-02-2019.
 */

public class mybusinessResponse extends APIResponse {

    /**
     * Url : https://user.mgfm.in/FM/ID?ID=eyJpdiI6IlprVlpDU1FSYlhYSmpkMDI0clFOS1E9PSIsInZhbHVlIjoiMVBTV0s1NVBlcWg1K3A3NWkzVExaUT09IiwibWFjIjoiYmUxY2QwMmI4NTJjMTY1ZDBlYmQ4NmE2ZjZiMWJkMTMzYWU0NDQ3NTkxYjlhYjgyMjRjMmY5MDlkNjAzZjY4OSJ9
     */

    private String Url;

    public String getUrl() {
        return Url;
    }

    public void setUrl(String Url) {
        this.Url = Url;
    }
}
