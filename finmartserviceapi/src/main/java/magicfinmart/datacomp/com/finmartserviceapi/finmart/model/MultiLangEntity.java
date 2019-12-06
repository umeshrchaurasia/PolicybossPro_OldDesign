package magicfinmart.datacomp.com.finmartserviceapi.finmart.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public  class MultiLangEntity extends RealmObject {
        /**
         * Id : 1
         * Keyname : FinmartExclutitle
         * English : FINMART EXCLUSIVES
         * Hindi : फिनमार्ट एक्सक्लुसिवस
         * Marathi : फिनमार्ट एक्सक्लुसिवस
         * Gujrathi : ફિંમાર્ટ એક્સકલુસિવેસ 
         */

        @PrimaryKey
        private int Id;
        private String Keyname;
        private String English;
        private String Hindi;
        private String Marathi;
        private String Gujrathi;

        public int getId() {
            return Id;
        }

        public void setId(int Id) {
            this.Id = Id;
        }

        public String getKeyname() {
            return Keyname;
        }

        public void setKeyname(String Keyname) {
            this.Keyname = Keyname;
        }

        public String getEnglish() {
            return English;
        }

        public void setEnglish(String English) {
            this.English = English;
        }

        public String getHindi() {
            return Hindi;
        }

        public void setHindi(String Hindi) {
            this.Hindi = Hindi;
        }

        public String getMarathi() {
            return Marathi;
        }

        public void setMarathi(String Marathi) {
            this.Marathi = Marathi;
        }

        public String getGujrathi() {
            return Gujrathi;
        }

        public void setGujrathi(String Gujrathi) {
            this.Gujrathi = Gujrathi;
        }
    }