package magicfinmart.datacomp.com.finmartserviceapi.express_loan.model;

import java.util.List;

public  class ExpressLoanEntity {
        private List<PersonalLoanEntity> PersonalLoan;
        private List<ShortTermPersonalLoanEntity> ShortTermPersonalLoan;

        public List<PersonalLoanEntity> getPersonalLoan() {
            return PersonalLoan;
        }

        public void setPersonalLoan(List<PersonalLoanEntity> PersonalLoan) {
            this.PersonalLoan = PersonalLoan;
        }

        public List<ShortTermPersonalLoanEntity> getShortTermPersonalLoan() {
            return ShortTermPersonalLoan;
        }

        public void setShortTermPersonalLoan(List<ShortTermPersonalLoanEntity> ShortTermPersonalLoan) {
            this.ShortTermPersonalLoan = ShortTermPersonalLoan;
        }




    }