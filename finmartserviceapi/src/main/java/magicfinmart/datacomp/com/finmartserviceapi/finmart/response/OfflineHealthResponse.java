package magicfinmart.datacomp.com.finmartserviceapi.finmart.response;

import java.util.List;

import magicfinmart.datacomp.com.finmartserviceapi.finmart.APIResponse;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.HealthQuote;

/**
 * Created by Rajeev Ranjan on 17/01/2019.
 */

public class OfflineHealthResponse extends APIResponse {

    private List<HealthQuote> MasterData;

    public List<HealthQuote> getMasterData() {
        return MasterData;
    }

    public void setMasterData(List<HealthQuote> MasterData) {
        this.MasterData = MasterData;
    }

//    public static class HealthQuote {
//        /**
//         * fba_id : 1976
//         * HealthRequestId : 1
//         * agent_source : App
//         * crn : 0
//         * selectedPrevInsID : 0
//         * HealthRequest : {"HealthRequestId":1,"crn":"0","insImage":null,"CityID":0,"ContactEmail":"","ContactMobile":"8087571995","ContactName":"Test For Development","DeductibleAmount":0,"ExistingCustomerReferenceID":0,"HealthType":"Health","MaritalStatusID":1,"PolicyFor":"Self","PolicyTermYear":1,"ProductID":2,"SessionID":0,"SourceType":"APP","SumInsured":"100000","SupportsAgentID":2,"FBAID":1976,"agent_source":"App","Quote_Application_Status":"Q","conversion_date":null,"created_date":"17/01/2019","updated_date":null,"isActive":1,"PBStatus":"","PBStatusDesc":"","StatusPercent":0,"selectedPrevInsID":0,"pincode":"400051","MemberList":[{"HealthMemberListId":"1","MemberDOB":"20-06-1968","MemberAge":"50","MemberGender":"null","MemberNumber":"null","MemberType":"Adult","MemberTypeID":"null","HealthRequestId":"1"},{"HealthMemberListId":"2","MemberDOB":"20-06-1968","MemberAge":"50","MemberGender":"null","MemberNumber":"null","MemberType":"Adult","MemberTypeID":"null","HealthRequestId":"2"}],"progress_image":null}
//         */
//
//        private int fba_id;
//        private int HealthRequestId;
//        private String agent_source;
//        private String crn;
//        private int selectedPrevInsID;
//        private HealthRequestEntity HealthRequest;
//
//        public int getFba_id() {
//            return fba_id;
//        }
//
//        public void setFba_id(int fba_id) {
//            this.fba_id = fba_id;
//        }
//
//        public int getHealthRequestId() {
//            return HealthRequestId;
//        }
//
//        public void setHealthRequestId(int HealthRequestId) {
//            this.HealthRequestId = HealthRequestId;
//        }
//
//        public String getAgent_source() {
//            return agent_source;
//        }
//
//        public void setAgent_source(String agent_source) {
//            this.agent_source = agent_source;
//        }
//
//        public String getCrn() {
//            return crn;
//        }
//
//        public void setCrn(String crn) {
//            this.crn = crn;
//        }
//
//        public int getSelectedPrevInsID() {
//            return selectedPrevInsID;
//        }
//
//        public void setSelectedPrevInsID(int selectedPrevInsID) {
//            this.selectedPrevInsID = selectedPrevInsID;
//        }
//
//        public HealthRequestEntity getHealthRequest() {
//            return HealthRequest;
//        }
//
//        public void setHealthRequest(HealthRequestEntity HealthRequest) {
//            this.HealthRequest = HealthRequest;
//        }
//
//        public static class HealthRequestEntity {
//            /**
//             * HealthRequestId : 1
//             * crn : 0
//             * insImage : null
//             * CityID : 0
//             * ContactEmail :
//             * ContactMobile : 8087571995
//             * ContactName : Test For Development
//             * DeductibleAmount : 0
//             * ExistingCustomerReferenceID : 0
//             * HealthType : Health
//             * MaritalStatusID : 1
//             * PolicyFor : Self
//             * PolicyTermYear : 1
//             * ProductID : 2
//             * SessionID : 0
//             * SourceType : APP
//             * SumInsured : 100000
//             * SupportsAgentID : 2
//             * FBAID : 1976
//             * agent_source : App
//             * Quote_Application_Status : Q
//             * conversion_date : null
//             * created_date : 17/01/2019
//             * updated_date : null
//             * isActive : 1
//             * PBStatus :
//             * PBStatusDesc :
//             * StatusPercent : 0
//             * selectedPrevInsID : 0
//             * pincode : 400051
//             * MemberList : [{"HealthMemberListId":"1","MemberDOB":"20-06-1968","MemberAge":"50","MemberGender":"null","MemberNumber":"null","MemberType":"Adult","MemberTypeID":"null","HealthRequestId":"1"},{"HealthMemberListId":"2","MemberDOB":"20-06-1968","MemberAge":"50","MemberGender":"null","MemberNumber":"null","MemberType":"Adult","MemberTypeID":"null","HealthRequestId":"2"}]
//             * progress_image : null
//             */
//
//            private int HealthRequestId;
//            private String crn;
//            private Object insImage;
//            private int CityID;
//            private String ContactEmail;
//            private String ContactMobile;
//            private String ContactName;
//            private int DeductibleAmount;
//            private int ExistingCustomerReferenceID;
//            private String HealthType;
//            private int MaritalStatusID;
//            private String PolicyFor;
//            private int PolicyTermYear;
//            private int ProductID;
//            private int SessionID;
//            private String SourceType;
//            private String SumInsured;
//            private int SupportsAgentID;
//            private int FBAID;
//            private String agent_source;
//            private String Quote_Application_Status;
//            private Object conversion_date;
//            private String created_date;
//            private Object updated_date;
//            private int isActive;
//            private String PBStatus;
//            private String PBStatusDesc;
//            private int StatusPercent;
//            private int selectedPrevInsID;
//            private String pincode;
//            private Object progress_image;
//            private List<MemberListBean> MemberList;
//
//            public int getHealthRequestId() {
//                return HealthRequestId;
//            }
//
//            public void setHealthRequestId(int HealthRequestId) {
//                this.HealthRequestId = HealthRequestId;
//            }
//
//            public String getCrn() {
//                return crn;
//            }
//
//            public void setCrn(String crn) {
//                this.crn = crn;
//            }
//
//            public Object getInsImage() {
//                return insImage;
//            }
//
//            public void setInsImage(Object insImage) {
//                this.insImage = insImage;
//            }
//
//            public int getCityID() {
//                return CityID;
//            }
//
//            public void setCityID(int CityID) {
//                this.CityID = CityID;
//            }
//
//            public String getContactEmail() {
//                return ContactEmail;
//            }
//
//            public void setContactEmail(String ContactEmail) {
//                this.ContactEmail = ContactEmail;
//            }
//
//            public String getContactMobile() {
//                return ContactMobile;
//            }
//
//            public void setContactMobile(String ContactMobile) {
//                this.ContactMobile = ContactMobile;
//            }
//
//            public String getContactName() {
//                return ContactName;
//            }
//
//            public void setContactName(String ContactName) {
//                this.ContactName = ContactName;
//            }
//
//            public int getDeductibleAmount() {
//                return DeductibleAmount;
//            }
//
//            public void setDeductibleAmount(int DeductibleAmount) {
//                this.DeductibleAmount = DeductibleAmount;
//            }
//
//            public int getExistingCustomerReferenceID() {
//                return ExistingCustomerReferenceID;
//            }
//
//            public void setExistingCustomerReferenceID(int ExistingCustomerReferenceID) {
//                this.ExistingCustomerReferenceID = ExistingCustomerReferenceID;
//            }
//
//            public String getHealthType() {
//                return HealthType;
//            }
//
//            public void setHealthType(String HealthType) {
//                this.HealthType = HealthType;
//            }
//
//            public int getMaritalStatusID() {
//                return MaritalStatusID;
//            }
//
//            public void setMaritalStatusID(int MaritalStatusID) {
//                this.MaritalStatusID = MaritalStatusID;
//            }
//
//            public String getPolicyFor() {
//                return PolicyFor;
//            }
//
//            public void setPolicyFor(String PolicyFor) {
//                this.PolicyFor = PolicyFor;
//            }
//
//            public int getPolicyTermYear() {
//                return PolicyTermYear;
//            }
//
//            public void setPolicyTermYear(int PolicyTermYear) {
//                this.PolicyTermYear = PolicyTermYear;
//            }
//
//            public int getProductID() {
//                return ProductID;
//            }
//
//            public void setProductID(int ProductID) {
//                this.ProductID = ProductID;
//            }
//
//            public int getSessionID() {
//                return SessionID;
//            }
//
//            public void setSessionID(int SessionID) {
//                this.SessionID = SessionID;
//            }
//
//            public String getSourceType() {
//                return SourceType;
//            }
//
//            public void setSourceType(String SourceType) {
//                this.SourceType = SourceType;
//            }
//
//            public String getSumInsured() {
//                return SumInsured;
//            }
//
//            public void setSumInsured(String SumInsured) {
//                this.SumInsured = SumInsured;
//            }
//
//            public int getSupportsAgentID() {
//                return SupportsAgentID;
//            }
//
//            public void setSupportsAgentID(int SupportsAgentID) {
//                this.SupportsAgentID = SupportsAgentID;
//            }
//
//            public int getFBAID() {
//                return FBAID;
//            }
//
//            public void setFBAID(int FBAID) {
//                this.FBAID = FBAID;
//            }
//
//            public String getAgent_source() {
//                return agent_source;
//            }
//
//            public void setAgent_source(String agent_source) {
//                this.agent_source = agent_source;
//            }
//
//            public String getQuote_Application_Status() {
//                return Quote_Application_Status;
//            }
//
//            public void setQuote_Application_Status(String Quote_Application_Status) {
//                this.Quote_Application_Status = Quote_Application_Status;
//            }
//
//            public Object getConversion_date() {
//                return conversion_date;
//            }
//
//            public void setConversion_date(Object conversion_date) {
//                this.conversion_date = conversion_date;
//            }
//
//            public String getCreated_date() {
//                return created_date;
//            }
//
//            public void setCreated_date(String created_date) {
//                this.created_date = created_date;
//            }
//
//            public Object getUpdated_date() {
//                return updated_date;
//            }
//
//            public void setUpdated_date(Object updated_date) {
//                this.updated_date = updated_date;
//            }
//
//            public int getIsActive() {
//                return isActive;
//            }
//
//            public void setIsActive(int isActive) {
//                this.isActive = isActive;
//            }
//
//            public String getPBStatus() {
//                return PBStatus;
//            }
//
//            public void setPBStatus(String PBStatus) {
//                this.PBStatus = PBStatus;
//            }
//
//            public String getPBStatusDesc() {
//                return PBStatusDesc;
//            }
//
//            public void setPBStatusDesc(String PBStatusDesc) {
//                this.PBStatusDesc = PBStatusDesc;
//            }
//
//            public int getStatusPercent() {
//                return StatusPercent;
//            }
//
//            public void setStatusPercent(int StatusPercent) {
//                this.StatusPercent = StatusPercent;
//            }
//
//            public int getSelectedPrevInsID() {
//                return selectedPrevInsID;
//            }
//
//            public void setSelectedPrevInsID(int selectedPrevInsID) {
//                this.selectedPrevInsID = selectedPrevInsID;
//            }
//
//            public String getPincode() {
//                return pincode;
//            }
//
//            public void setPincode(String pincode) {
//                this.pincode = pincode;
//            }
//
//            public Object getProgress_image() {
//                return progress_image;
//            }
//
//            public void setProgress_image(Object progress_image) {
//                this.progress_image = progress_image;
//            }
//
//            public List<MemberListBean> getMemberList() {
//                return MemberList;
//            }
//
//            public void setMemberList(List<MemberListBean> MemberList) {
//                this.MemberList = MemberList;
//            }
//
//            public static class MemberListBean {
//                /**
//                 * HealthMemberListId : 1
//                 * MemberDOB : 20-06-1968
//                 * MemberAge : 50
//                 * MemberGender : null
//                 * MemberNumber : null
//                 * MemberType : Adult
//                 * MemberTypeID : null
//                 * HealthRequestId : 1
//                 */
//
//                private String HealthMemberListId;
//                private String MemberDOB;
//                private String MemberAge;
//                private String MemberGender;
//                private String MemberNumber;
//                private String MemberType;
//                private String MemberTypeID;
//                private String HealthRequestId;
//
//                public String getHealthMemberListId() {
//                    return HealthMemberListId;
//                }
//
//                public void setHealthMemberListId(String HealthMemberListId) {
//                    this.HealthMemberListId = HealthMemberListId;
//                }
//
//                public String getMemberDOB() {
//                    return MemberDOB;
//                }
//
//                public void setMemberDOB(String MemberDOB) {
//                    this.MemberDOB = MemberDOB;
//                }
//
//                public String getMemberAge() {
//                    return MemberAge;
//                }
//
//                public void setMemberAge(String MemberAge) {
//                    this.MemberAge = MemberAge;
//                }
//
//                public String getMemberGender() {
//                    return MemberGender;
//                }
//
//                public void setMemberGender(String MemberGender) {
//                    this.MemberGender = MemberGender;
//                }
//
//                public String getMemberNumber() {
//                    return MemberNumber;
//                }
//
//                public void setMemberNumber(String MemberNumber) {
//                    this.MemberNumber = MemberNumber;
//                }
//
//                public String getMemberType() {
//                    return MemberType;
//                }
//
//                public void setMemberType(String MemberType) {
//                    this.MemberType = MemberType;
//                }
//
//                public String getMemberTypeID() {
//                    return MemberTypeID;
//                }
//
//                public void setMemberTypeID(String MemberTypeID) {
//                    this.MemberTypeID = MemberTypeID;
//                }
//
//                public String getHealthRequestId() {
//                    return HealthRequestId;
//                }
//
//                public void setHealthRequestId(String HealthRequestId) {
//                    this.HealthRequestId = HealthRequestId;
//                }
//            }
//        }
//    }


    /**
     * MasterData : {"quote":[{"fba_id":1976,"HealthRequestId":7352,"agent_source":"App","crn":"0","selectedPrevInsID":0,"HealthRequest":{"HealthRequestId":7352,"crn":"0","insImage":null,"CityID":0,"ContactEmail":"","ContactMobile":"9930855588","ContactName":"Test Ted","DeductibleAmount":0,"ExistingCustomerReferenceID":0,"HealthType":"Health","MaritalStatusID":1,"PolicyFor":"Self","PolicyTermYear":1,"ProductID":2,"SessionID":0,"SourceType":"APP","SumInsured":"500000","SupportsAgentID":2,"FBAID":1976,"agent_source":"App","Quote_Application_Status":"Q","conversion_date":null,"created_date":"08/10/2018","updated_date":null,"isActive":1,"PBStatus":"","PBStatusDesc":"","StatusPercent":0,"selectedPrevInsID":0,"pincode":"400070","MemberList":[{"HealthMemberListId":"31994","MemberDOB":"08-10-1982","MemberAge":"36","MemberGender":"null","MemberNumber":"null","MemberType":"Adult","MemberTypeID":"null","HealthRequestId":"7352"}],"progress_image":null}},{"fba_id":1976,"HealthRequestId":7285,"agent_source":"App","crn":"0","selectedPrevInsID":0,"HealthRequest":{"HealthRequestId":7285,"crn":"0","insImage":null,"CityID":0,"ContactEmail":"","ContactMobile":"9797976676","ContactName":"Test Hsga","DeductibleAmount":0,"ExistingCustomerReferenceID":0,"HealthType":"Health","MaritalStatusID":2,"PolicyFor":"Family","PolicyTermYear":1,"ProductID":2,"SessionID":0,"SourceType":"APP","SumInsured":"500000","SupportsAgentID":2,"FBAID":1976,"agent_source":"App","Quote_Application_Status":"Q","conversion_date":null,"created_date":"06/08/2018","updated_date":"11/09/2018","isActive":1,"PBStatus":"","PBStatusDesc":"","StatusPercent":0,"selectedPrevInsID":0,"pincode":"400080","MemberList":[{"HealthMemberListId":"31957","MemberDOB":"11-09-1976","MemberAge":"42","MemberGender":"null","MemberNumber":"null","MemberType":"Adult","MemberTypeID":"null","HealthRequestId":"7285"},{"HealthMemberListId":"31958","MemberDOB":"11-09-1986","MemberAge":"32","MemberGender":"null","MemberNumber":"null","MemberType":"Adult","MemberTypeID":"null","HealthRequestId":"7285"},{"HealthMemberListId":"31959","MemberDOB":"11-09-2010","MemberAge":"8","MemberGender":"null","MemberNumber":"null","MemberType":"Child","MemberTypeID":"null","HealthRequestId":"7285"}],"progress_image":null}},{"fba_id":1976,"HealthRequestId":7284,"agent_source":"App","crn":"0","selectedPrevInsID":0,"HealthRequest":{"HealthRequestId":7284,"crn":"0","insImage":null,"CityID":0,"ContactEmail":"","ContactMobile":"9965566666","ContactName":"Test Hdh","DeductibleAmount":0,"ExistingCustomerReferenceID":0,"HealthType":"Health","MaritalStatusID":2,"PolicyFor":"Family","PolicyTermYear":1,"ProductID":2,"SessionID":0,"SourceType":"APP","SumInsured":"500000","SupportsAgentID":2,"FBAID":1976,"agent_source":"App","Quote_Application_Status":"Q","conversion_date":null,"created_date":"06/08/2018","updated_date":null,"isActive":1,"PBStatus":"","PBStatusDesc":"","StatusPercent":0,"selectedPrevInsID":0,"pincode":"400080","MemberList":[{"HealthMemberListId":"31526","MemberDOB":"06-08-1986","MemberAge":"32","MemberGender":"null","MemberNumber":"null","MemberType":"Adult","MemberTypeID":"null","HealthRequestId":"7284"},{"HealthMemberListId":"31527","MemberDOB":"06-08-1990","MemberAge":"28","MemberGender":"null","MemberNumber":"null","MemberType":"Adult","MemberTypeID":"null","HealthRequestId":"7284"},{"HealthMemberListId":"31528","MemberDOB":"06-08-2013","MemberAge":"5","MemberGender":"null","MemberNumber":"null","MemberType":"Child","MemberTypeID":"null","HealthRequestId":"7284"},{"HealthMemberListId":"31529","MemberDOB":"06-08-2016","MemberAge":"2","MemberGender":"null","MemberNumber":"null","MemberType":"Child","MemberTypeID":"null","HealthRequestId":"7284"}],"progress_image":null}},{"fba_id":1976,"HealthRequestId":7283,"agent_source":"App","crn":"0","selectedPrevInsID":0,"HealthRequest":{"HealthRequestId":7283,"crn":"0","insImage":null,"CityID":0,"ContactEmail":"","ContactMobile":"9999966666","ContactName":"Test New","DeductibleAmount":0,"ExistingCustomerReferenceID":0,"HealthType":"Health","MaritalStatusID":2,"PolicyFor":"Family","PolicyTermYear":1,"ProductID":2,"SessionID":0,"SourceType":"APP","SumInsured":"500000","SupportsAgentID":2,"FBAID":1976,"agent_source":"App","Quote_Application_Status":"Q","conversion_date":null,"created_date":"06/08/2018","updated_date":null,"isActive":1,"PBStatus":"","PBStatusDesc":"","StatusPercent":0,"selectedPrevInsID":0,"pincode":"400080","MemberList":[{"HealthMemberListId":"31524","MemberDOB":"06-08-1986","MemberAge":"32","MemberGender":"null","MemberNumber":"null","MemberType":"Adult","MemberTypeID":"null","HealthRequestId":"7283"},{"HealthMemberListId":"31525","MemberDOB":"06-08-1990","MemberAge":"28","MemberGender":"null","MemberNumber":"null","MemberType":"Adult","MemberTypeID":"null","HealthRequestId":"7283"}],"progress_image":null}},{"fba_id":1976,"HealthRequestId":7281,"agent_source":"App","crn":"0","selectedPrevInsID":0,"HealthRequest":{"HealthRequestId":7281,"crn":"0","insImage":null,"CityID":0,"ContactEmail":"","ContactMobile":"9898995646","ContactName":"Gsgs Sggd","DeductibleAmount":0,"ExistingCustomerReferenceID":0,"HealthType":"Health","MaritalStatusID":2,"PolicyFor":"Family","PolicyTermYear":1,"ProductID":2,"SessionID":0,"SourceType":"APP","SumInsured":"500000","SupportsAgentID":2,"FBAID":1976,"agent_source":"App","Quote_Application_Status":"Q","conversion_date":null,"created_date":"06/08/2018","updated_date":"11/09/2018","isActive":1,"PBStatus":"","PBStatusDesc":"","StatusPercent":0,"selectedPrevInsID":0,"pincode":"400080","MemberList":[{"HealthMemberListId":"31950","MemberDOB":"06-08-1976","MemberAge":"42","MemberGender":"null","MemberNumber":"null","MemberType":"Adult","MemberTypeID":"null","HealthRequestId":"7281"},{"HealthMemberListId":"31951","MemberDOB":"06-08-1986","MemberAge":"32","MemberGender":"null","MemberNumber":"null","MemberType":"Adult","MemberTypeID":"null","HealthRequestId":"7281"},{"HealthMemberListId":"31952","MemberDOB":"06-08-2012","MemberAge":"6","MemberGender":"null","MemberNumber":"null","MemberType":"Child","MemberTypeID":"null","HealthRequestId":"7281"}],"progress_image":null}},{"fba_id":1976,"HealthRequestId":7278,"agent_source":"App","crn":"0","selectedPrevInsID":0,"HealthRequest":{"HealthRequestId":7278,"crn":"0","insImage":null,"CityID":0,"ContactEmail":"","ContactMobile":"9797944949","ContactName":"Test Beheh","DeductibleAmount":0,"ExistingCustomerReferenceID":0,"HealthType":"Health","MaritalStatusID":2,"PolicyFor":"Family","PolicyTermYear":1,"ProductID":2,"SessionID":0,"SourceType":"APP","SumInsured":"500000","SupportsAgentID":2,"FBAID":1976,"agent_source":"App","Quote_Application_Status":"Q","conversion_date":null,"created_date":"06/08/2018","updated_date":null,"isActive":1,"PBStatus":"","PBStatusDesc":"","StatusPercent":0,"selectedPrevInsID":0,"pincode":"400020","MemberList":[{"HealthMemberListId":"31507","MemberDOB":"06-08-1976","MemberAge":"42","MemberGender":"null","MemberNumber":"null","MemberType":"Adult","MemberTypeID":"null","HealthRequestId":"7278"},{"HealthMemberListId":"31508","MemberDOB":"06-08-1982","MemberAge":"36","MemberGender":"null","MemberNumber":"null","MemberType":"Adult","MemberTypeID":"null","HealthRequestId":"7278"},{"HealthMemberListId":"31509","MemberDOB":"06-08-2001","MemberAge":"17","MemberGender":"null","MemberNumber":"null","MemberType":"Child","MemberTypeID":"null","HealthRequestId":"7278"},{"HealthMemberListId":"31510","MemberDOB":"06-08-2013","MemberAge":"5","MemberGender":"null","MemberNumber":"null","MemberType":"Child","MemberTypeID":"null","HealthRequestId":"7278"}],"progress_image":null}},{"fba_id":1976,"HealthRequestId":7277,"agent_source":"App","crn":"0","selectedPrevInsID":0,"HealthRequest":{"HealthRequestId":7277,"crn":"0","insImage":null,"CityID":0,"ContactEmail":"","ContactMobile":"9797976764","ContactName":"Test Meq","DeductibleAmount":0,"ExistingCustomerReferenceID":0,"HealthType":"Health","MaritalStatusID":1,"PolicyFor":"Self","PolicyTermYear":1,"ProductID":2,"SessionID":0,"SourceType":"APP","SumInsured":"600000","SupportsAgentID":2,"FBAID":1976,"agent_source":"App","Quote_Application_Status":"Q","conversion_date":null,"created_date":"06/08/2018","updated_date":null,"isActive":1,"PBStatus":"","PBStatusDesc":"","StatusPercent":0,"selectedPrevInsID":0,"pincode":"400010","MemberList":[{"HealthMemberListId":"31503","MemberDOB":"06-08-1986","MemberAge":"32","MemberGender":"null","MemberNumber":"null","MemberType":"Adult","MemberTypeID":"null","HealthRequestId":"7277"}],"progress_image":null}},{"fba_id":1976,"HealthRequestId":7276,"agent_source":"App","crn":"0","selectedPrevInsID":0,"HealthRequest":{"HealthRequestId":7276,"crn":"0","insImage":null,"CityID":0,"ContactEmail":"","ContactMobile":"9898986686","ContactName":"Test New","DeductibleAmount":0,"ExistingCustomerReferenceID":0,"HealthType":"Health","MaritalStatusID":2,"PolicyFor":"Family","PolicyTermYear":1,"ProductID":2,"SessionID":0,"SourceType":"APP","SumInsured":"500000","SupportsAgentID":2,"FBAID":1976,"agent_source":"App","Quote_Application_Status":"Q","conversion_date":null,"created_date":"06/08/2018","updated_date":null,"isActive":1,"PBStatus":"","PBStatusDesc":"","StatusPercent":0,"selectedPrevInsID":0,"pincode":"400070","MemberList":[{"HealthMemberListId":"31498","MemberDOB":"06-08-1985","MemberAge":"33","MemberGender":"null","MemberNumber":"null","MemberType":"Adult","MemberTypeID":"null","HealthRequestId":"7276"},{"HealthMemberListId":"31499","MemberDOB":"06-08-1990","MemberAge":"28","MemberGender":"null","MemberNumber":"null","MemberType":"Adult","MemberTypeID":"null","HealthRequestId":"7276"},{"HealthMemberListId":"31500","MemberDOB":"06-08-2016","MemberAge":"2","MemberGender":"null","MemberNumber":"null","MemberType":"Child","MemberTypeID":"null","HealthRequestId":"7276"}],"progress_image":null}},{"fba_id":1976,"HealthRequestId":7275,"agent_source":"App","crn":"0","selectedPrevInsID":0,"HealthRequest":{"HealthRequestId":7275,"crn":"0","insImage":null,"CityID":0,"ContactEmail":"","ContactMobile":"9794994646","ContactName":"Have Bsvs","DeductibleAmount":0,"ExistingCustomerReferenceID":0,"HealthType":"Health","MaritalStatusID":2,"PolicyFor":"Family","PolicyTermYear":1,"ProductID":2,"SessionID":0,"SourceType":"APP","SumInsured":"500000","SupportsAgentID":2,"FBAID":1976,"agent_source":"App","Quote_Application_Status":"Q","conversion_date":null,"created_date":"06/08/2018","updated_date":null,"isActive":1,"PBStatus":"","PBStatusDesc":"","StatusPercent":0,"selectedPrevInsID":0,"pincode":"400080","MemberList":[{"HealthMemberListId":"31494","MemberDOB":"06-08-1986","MemberAge":"32","MemberGender":"null","MemberNumber":"null","MemberType":"Adult","MemberTypeID":"null","HealthRequestId":"7275"},{"HealthMemberListId":"31495","MemberDOB":"06-08-1990","MemberAge":"28","MemberGender":"null","MemberNumber":"null","MemberType":"Adult","MemberTypeID":"null","HealthRequestId":"7275"},{"HealthMemberListId":"31496","MemberDOB":"06-08-2013","MemberAge":"5","MemberGender":"null","MemberNumber":"null","MemberType":"Child","MemberTypeID":"null","HealthRequestId":"7275"},{"HealthMemberListId":"31497","MemberDOB":"06-08-2015","MemberAge":"3","MemberGender":"null","MemberNumber":"null","MemberType":"Child","MemberTypeID":"null","HealthRequestId":"7275"}],"progress_image":null}},{"fba_id":1976,"HealthRequestId":7232,"agent_source":"App","crn":"0","selectedPrevInsID":0,"HealthRequest":{"HealthRequestId":7232,"crn":"0","insImage":null,"CityID":0,"ContactEmail":"","ContactMobile":"","ContactName":"Gdgd Sbgs","DeductibleAmount":0,"ExistingCustomerReferenceID":0,"HealthType":"Health","MaritalStatusID":2,"PolicyFor":"Family","PolicyTermYear":1,"ProductID":2,"SessionID":0,"SourceType":"APP","SumInsured":"500000","SupportsAgentID":2,"FBAID":1976,"agent_source":"App","Quote_Application_Status":"Q","conversion_date":null,"created_date":"04/08/2018","updated_date":"04/08/2018","isActive":1,"PBStatus":"","PBStatusDesc":"","StatusPercent":0,"selectedPrevInsID":0,"pincode":"400080","MemberList":[{"HealthMemberListId":"31235","MemberDOB":"04-08-1986","MemberAge":"32","MemberGender":"null","MemberNumber":"null","MemberType":"Adult","MemberTypeID":"null","HealthRequestId":"7232"},{"HealthMemberListId":"31236","MemberDOB":"04-08-1990","MemberAge":"28","MemberGender":"null","MemberNumber":"null","MemberType":"Adult","MemberTypeID":"null","HealthRequestId":"7232"},{"HealthMemberListId":"31237","MemberDOB":"04-08-2013","MemberAge":"5","MemberGender":"null","MemberNumber":"null","MemberType":"Child","MemberTypeID":"null","HealthRequestId":"7232"},{"HealthMemberListId":"31238","MemberDOB":"04-08-2015","MemberAge":"3","MemberGender":"null","MemberNumber":"null","MemberType":"Child","MemberTypeID":"null","HealthRequestId":"7232"}],"progress_image":null}}],"application":[]}
     */


}
