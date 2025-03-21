package com.school.view;

import java.util.ResourceBundle;

public enum FxmlView {
    MAIN{
        @Override
        String getTitle() {
            return getStringFromResourceBundle("main.app.title");
        }
        @Override
        public String getFxmlFile() {
            return "/fxml/Main.fxml";
        }
    },
    LOGIN {
        @Override
        String getTitle() {
            return getStringFromResourceBundle("login.title");
        }
        @Override
        public String getFxmlFile() {
            return "/fxml/user_login/Login.fxml";
        }
    },
    CREATE {
        @Override
        String getTitle() {
            return getStringFromResourceBundle("login.title");
        }
        @Override
        public String getFxmlFile() {
            return "/fxml/user_login/Employee.fxml";
        }
    },

    EMPLOYEE {
        @Override
        String getTitle() {
            return getStringFromResourceBundle("login.title");
        }
        @Override
        public String getFxmlFile() {
            return "/fxml/create/AddEmployee.fxml";
        }
    },
    ADDUSER {
        @Override
        String getTitle() {
            return getStringFromResourceBundle("login.title");
        }
        @Override
        public String getFxmlFile() {
            return "/fxml/create/AddUser.fxml";
        }
    },
    HOME {
        @Override
        String getTitle() {
            return getStringFromResourceBundle("dashboard.title");
        }
        @Override
        public String getFxmlFile() {
            return "/fxml/home/Home.fxml";
        }
    },
    DASHBOARD {
        @Override
        String getTitle() {
            return getStringFromResourceBundle("dashboard.title");
        }
        @Override
        public String getFxmlFile() {
            return "/fxml/dashboard/Dashboard.fxml";
        }
    },
    PURCHASEPARTY {
        @Override
        String getTitle() {
            return getStringFromResourceBundle("dashboard.title");
        }
        @Override
        public String getFxmlFile() {
            return "/fxml/create/AddPurchaseParty.fxml";
        }
    },
    ITEM {
        @Override
        String getTitle() {
            return getStringFromResourceBundle("dashboard.title");
        }
        @Override
        public String getFxmlFile() {
            return "/fxml/create/AddItem.fxml";
        }
    },
    PURCHASEINVOICE {
        @Override
        String getTitle() {
            return getStringFromResourceBundle("dashboard.title");
        }
        @Override
        public String getFxmlFile() {
            return "/fxml/transaction/PurchaseInvoice.fxml";
        }
    },
    PURCHASEINVOICE2 {
        @Override
        String getTitle() {
            return "Purchase Invoice 2";
            //return getStringFromResourceBundle("dashboard.title");
        }
        @Override
        public String getFxmlFile() {
            return "/fxml/transaction/PurchaseInvoice2.fxml";
        }
    },
    BANK {
        @Override
        String getTitle() {
            return getStringFromResourceBundle("dashboard.title");
        }
        @Override
        public String getFxmlFile() {
            return "/fxml/create/AddBank.fxml";
        }
    },
    ITEMSTOCK {
        @Override
        String getTitle() {
            return getStringFromResourceBundle("dashboard.title");
        }
        @Override
        public String getFxmlFile() {
            return "/fxml/report/item/ItemStock.fxml";
        }
    },
    BILLING {
        @Override
        String getTitle() {
            return getStringFromResourceBundle("dashboard.title");
        }
        @Override
        public String getFxmlFile() {
            return "/fxml/transaction/BillingFrame.fxml";
        }
    },
    CUSTOMER {
        @Override
        String getTitle() {
            return getStringFromResourceBundle("dashboard.title");
        }
        @Override
        public String getFxmlFile() {
            return "/fxml/create/AddCustomer.fxml";
        }
    },
    SALEREPORT {
        @Override
        String getTitle() {
            return getStringFromResourceBundle("dashboard.title");
        }
        @Override
        public String getFxmlFile() {
            return "/fxml/report/salesreport/DailySalesReport.fxml";
        }
    }
    ;
    abstract String getTitle();
    public abstract String getFxmlFile();
    String getStringFromResourceBundle(String key){
        return ResourceBundle.getBundle("Bundle").getString(key);
    }
}
