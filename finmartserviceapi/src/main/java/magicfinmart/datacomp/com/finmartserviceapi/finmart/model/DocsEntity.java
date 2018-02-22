package magicfinmart.datacomp.com.finmartserviceapi.finmart.model;

public class DocsEntity {
            /**
             * company_id : 2
             * Company_Name : Bharti
             * language : 
             * image_path : uploads/sales_material/image.jpg
             */

            private String company_id;
            private String Company_Name;
            private String language;
            private String image_path;

            public String getCompany_id() {
                return company_id;
            }

            public void setCompany_id(String company_id) {
                this.company_id = company_id;
            }

            public String getCompany_Name() {
                return Company_Name;
            }

            public void setCompany_Name(String Company_Name) {
                this.Company_Name = Company_Name;
            }

            public String getLanguage() {
                return language;
            }

            public void setLanguage(String language) {
                this.language = language;
            }

            public String getImage_path() {
                return image_path;
            }

            public void setImage_path(String image_path) {
                this.image_path = image_path;
            }
        }