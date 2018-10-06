package magicfinmart.datacomp.com.finmartserviceapi.finmart.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class UserConstantEntity extends RealmObject {
    /**
     * pospselfid : 3416
     * pospparentid : 2345
     * pospsendid : 3416
     * pospselfname : TESTPS POSP
     * pospparentname : Teet Tetet
     * pospsendname : TESTPS POSP
     * pospselfemail : testfl@gmail.com
     * pospparentemail : qq@gmail.com
     * pospsendemail : testfl@gmail.com
     * pospselfmobile : 9649679767
     * pospparentmobile : 8864545484
     * pospsendmobile : 9649679767
     * pospselfdesignation : LANDMARK POSP
     * pospparentdesignation : test
     * pospsenddesignation : LANDMARK POSP
     * pospselfphoto : http://qa.mgfm.in/uploads/37292/POSPPhotograph.jpg
     * pospparentphoto :
     * pospsendphoto : http://qa.mgfm.in/uploads/37292/POSPPhotograph.jpg
     * loanselfid : 38054
     * loanparentid : 333
     * loansendid : 38054
     * loanselfname : TEST TEDT
     * loanparentname : nitin test
     * loansendname : TEST TEDT
     * loanselfemail : testfl@gmail.com
     * loanparentemail : tedtgr@fff.vfty
     * loansendemail : testfl@gmail.com
     * loanselfmobile : 9687554545
     * loanparentmobile : 9625657576
     * loansendmobile : 9687554545
     * loanselfdesignation : Finmart Business Associate
     * loanparentdesignation : FINMART BUSINESS ASSOCIATE
     * loansenddesignation : Finmart Business Associate
     * loanselfphoto : http://qa.mgfm.in/uploads/37292/FBAPhotograph.jpg
     * loanparentphoto :
     * loansendphoto : http://qa.mgfm.in/uploads/37292/FBAPhotograph.jpg
     * FullName : TESTpl Test DATACOMP
     * FBAId : 37292
     * POSPNo : 3416
     * POSP_STATUS : Certified Agent for GI
     * MangMobile : 9137850198
     * MangEmail : rrm.12@magicfinmart.com
     * SuppMobile : 022-66048200
     * SuppEmail : fba.support@magicfinmart.com
     */
    @PrimaryKey
    private String FBAId;
    private String pospselfid;
    private String pospparentid;
    private String pospsendid;
    private String pospselfname;
    private String pospparentname;
    private String pospsendname;
    private String pospselfemail;
    private String pospparentemail;
    private String pospsendemail;
    private String pospselfmobile;
    private String pospparentmobile;
    private String pospsendmobile;
    private String pospselfdesignation;
    private String pospparentdesignation;
    private String pospsenddesignation;
    private String pospselfphoto;
    private String pospparentphoto;
    private String pospsendphoto;
    private String loanselfid;
    private String loanparentid;
    private String loansendid;
    private String loanselfname;
    private String loanparentname;
    private String loansendname;
    private String loanselfemail;
    private String loanparentemail;
    private String loansendemail;
    private String loanselfmobile;
    private String loanparentmobile;
    private String loansendmobile;
    private String loanselfdesignation;
    private String loanparentdesignation;
    private String loansenddesignation;
    private String loanselfphoto;
    private String loanparentphoto;
    private String loansendphoto;
    private String FullName;

    private String POSPNo;
    private String POSP_STATUS;
    private String MangMobile;
    private String MangEmail;
    private String SuppMobile;
    private String SuppEmail;
    private String LoginID;
    private String ManagName;

    private String healthurl;


    public String getHealthurl() {
        return healthurl;
    }

    public void setHealthurl(String healthurl) {
        this.healthurl = healthurl;
    }

    public String getLoginID() {
        return LoginID;
    }

    public void setLoginID(String loginID) {
        LoginID = loginID;
    }

    public String getManagName() {
        return ManagName;
    }

    public void setManagName(String managName) {
        ManagName = managName;
    }


    public String getPospselfid() {
        return pospselfid;
    }

    public void setPospselfid(String pospselfid) {
        this.pospselfid = pospselfid;
    }

    public String getPospparentid() {
        return pospparentid;
    }

    public void setPospparentid(String pospparentid) {
        this.pospparentid = pospparentid;
    }

    public String getPospsendid() {
        return pospsendid;
    }

    public void setPospsendid(String pospsendid) {
        this.pospsendid = pospsendid;
    }

    public String getPospselfname() {
        return pospselfname;
    }

    public void setPospselfname(String pospselfname) {
        this.pospselfname = pospselfname;
    }

    public String getPospparentname() {
        return pospparentname;
    }

    public void setPospparentname(String pospparentname) {
        this.pospparentname = pospparentname;
    }

    public String getPospsendname() {
        return pospsendname;
    }

    public void setPospsendname(String pospsendname) {
        this.pospsendname = pospsendname;
    }

    public String getPospselfemail() {
        return pospselfemail;
    }

    public void setPospselfemail(String pospselfemail) {
        this.pospselfemail = pospselfemail;
    }

    public String getPospparentemail() {
        return pospparentemail;
    }

    public void setPospparentemail(String pospparentemail) {
        this.pospparentemail = pospparentemail;
    }

    public String getPospsendemail() {
        return pospsendemail;
    }

    public void setPospsendemail(String pospsendemail) {
        this.pospsendemail = pospsendemail;
    }

    public String getPospselfmobile() {
        return pospselfmobile;
    }

    public void setPospselfmobile(String pospselfmobile) {
        this.pospselfmobile = pospselfmobile;
    }

    public String getPospparentmobile() {
        return pospparentmobile;
    }

    public void setPospparentmobile(String pospparentmobile) {
        this.pospparentmobile = pospparentmobile;
    }

    public String getPospsendmobile() {
        return pospsendmobile;
    }

    public void setPospsendmobile(String pospsendmobile) {
        this.pospsendmobile = pospsendmobile;
    }

    public String getPospselfdesignation() {
        return pospselfdesignation;
    }

    public void setPospselfdesignation(String pospselfdesignation) {
        this.pospselfdesignation = pospselfdesignation;
    }

    public String getPospparentdesignation() {
        return pospparentdesignation;
    }

    public void setPospparentdesignation(String pospparentdesignation) {
        this.pospparentdesignation = pospparentdesignation;
    }

    public String getPospsenddesignation() {
        return pospsenddesignation;
    }

    public void setPospsenddesignation(String pospsenddesignation) {
        this.pospsenddesignation = pospsenddesignation;
    }

    public String getPospselfphoto() {
        return pospselfphoto;
    }

    public void setPospselfphoto(String pospselfphoto) {
        this.pospselfphoto = pospselfphoto;
    }

    public String getPospparentphoto() {
        return pospparentphoto;
    }

    public void setPospparentphoto(String pospparentphoto) {
        this.pospparentphoto = pospparentphoto;
    }

    public String getPospsendphoto() {
        return pospsendphoto;
    }

    public void setPospsendphoto(String pospsendphoto) {
        this.pospsendphoto = pospsendphoto;
    }

    public String getLoanselfid() {
        return loanselfid;
    }

    public void setLoanselfid(String loanselfid) {
        this.loanselfid = loanselfid;
    }

    public String getLoanparentid() {
        return loanparentid;
    }

    public void setLoanparentid(String loanparentid) {
        this.loanparentid = loanparentid;
    }

    public String getLoansendid() {
        return loansendid;
    }

    public void setLoansendid(String loansendid) {
        this.loansendid = loansendid;
    }

    public String getLoanselfname() {
        return loanselfname;
    }

    public void setLoanselfname(String loanselfname) {
        this.loanselfname = loanselfname;
    }

    public String getLoanparentname() {
        return loanparentname;
    }

    public void setLoanparentname(String loanparentname) {
        this.loanparentname = loanparentname;
    }

    public String getLoansendname() {
        return loansendname;
    }

    public void setLoansendname(String loansendname) {
        this.loansendname = loansendname;
    }

    public String getLoanselfemail() {
        return loanselfemail;
    }

    public void setLoanselfemail(String loanselfemail) {
        this.loanselfemail = loanselfemail;
    }

    public String getLoanparentemail() {
        return loanparentemail;
    }

    public void setLoanparentemail(String loanparentemail) {
        this.loanparentemail = loanparentemail;
    }

    public String getLoansendemail() {
        return loansendemail;
    }

    public void setLoansendemail(String loansendemail) {
        this.loansendemail = loansendemail;
    }

    public String getLoanselfmobile() {
        return loanselfmobile;
    }

    public void setLoanselfmobile(String loanselfmobile) {
        this.loanselfmobile = loanselfmobile;
    }

    public String getLoanparentmobile() {
        return loanparentmobile;
    }

    public void setLoanparentmobile(String loanparentmobile) {
        this.loanparentmobile = loanparentmobile;
    }

    public String getLoansendmobile() {
        return loansendmobile;
    }

    public void setLoansendmobile(String loansendmobile) {
        this.loansendmobile = loansendmobile;
    }

    public String getLoanselfdesignation() {
        return loanselfdesignation;
    }

    public void setLoanselfdesignation(String loanselfdesignation) {
        this.loanselfdesignation = loanselfdesignation;
    }

    public String getLoanparentdesignation() {
        return loanparentdesignation;
    }

    public void setLoanparentdesignation(String loanparentdesignation) {
        this.loanparentdesignation = loanparentdesignation;
    }

    public String getLoansenddesignation() {
        return loansenddesignation;
    }

    public void setLoansenddesignation(String loansenddesignation) {
        this.loansenddesignation = loansenddesignation;
    }

    public String getLoanselfphoto() {
        return loanselfphoto;
    }

    public void setLoanselfphoto(String loanselfphoto) {
        this.loanselfphoto = loanselfphoto;
    }

    public String getLoanparentphoto() {
        return loanparentphoto;
    }

    public void setLoanparentphoto(String loanparentphoto) {
        this.loanparentphoto = loanparentphoto;
    }

    public String getLoansendphoto() {
        return loansendphoto;
    }

    public void setLoansendphoto(String loansendphoto) {
        this.loansendphoto = loansendphoto;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    public String getFBAId() {
        return FBAId;
    }

    public void setFBAId(String FBAId) {
        this.FBAId = FBAId;
    }

    public String getPOSPNo() {
        return POSPNo;
    }

    public void setPOSPNo(String POSPNo) {
        this.POSPNo = POSPNo;
    }

    public String getPOSP_STATUS() {
        return POSP_STATUS;
    }

    public void setPOSP_STATUS(String POSP_STATUS) {
        this.POSP_STATUS = POSP_STATUS;
    }

    public String getMangMobile() {
        return MangMobile;
    }

    public void setMangMobile(String MangMobile) {
        this.MangMobile = MangMobile;
    }

    public String getMangEmail() {
        return MangEmail;
    }

    public void setMangEmail(String MangEmail) {
        this.MangEmail = MangEmail;
    }

    public String getSuppMobile() {
        return SuppMobile;
    }

    public void setSuppMobile(String SuppMobile) {
        this.SuppMobile = SuppMobile;
    }

    public String getSuppEmail() {
        return SuppEmail;
    }

    public void setSuppEmail(String SuppEmail) {
        this.SuppEmail = SuppEmail;
    }
}