package magicfinmart.datacomp.com.finmartserviceapi.finmart.response;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;


public class UsersignupResponse extends APIResponse {

	private List<UsersingupEntity> MasterData;
	public List<UsersingupEntity> getMasterData() {
		return MasterData;
	}

	public void setMasterData(List<UsersingupEntity> masterData) {
		MasterData = masterData;
	}




	public static class UsersingupEntity {

		private String enable_pro_signupurl;
		private String enable_elite_signupurl;

    	private String enable_pro_pospurl;
		private  String enable_pro_Addsubuser_url;

		public String getEnableEliteSignupurl(){
			return enable_elite_signupurl;
		}

		public String getEnableProSignupurl(){
			return enable_pro_signupurl;
		}

		public String getEnable_pro_pospurl() {
			return enable_pro_pospurl;
		}

		public void setEnable_pro_pospurl(String enable_pro_pospurl) {
			this.enable_pro_pospurl = enable_pro_pospurl;
		}

		public String getEnable_pro_Addsubuser_url() {
			return enable_pro_Addsubuser_url;
		}

		public void setEnable_pro_Addsubuser_url(String enable_pro_Addsubuser_url) {
			this.enable_pro_Addsubuser_url = enable_pro_Addsubuser_url;
		}

	}
}