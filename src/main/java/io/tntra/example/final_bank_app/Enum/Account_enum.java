package io.tntra.example.final_bank_app.Enum;

public enum Account_enum {
    SAVING("saving"),
    CURRENT("current");

    public String value;
    Account_enum(String value) {
        this.value = value;
    }

    public static Account_enum compare(String text){
        Account_enum acc_type[] = Account_enum.values();
        for(Account_enum type : acc_type){
            if(type.getValue().equalsIgnoreCase(text)){
                return type;
            }
        }
        return CURRENT;
    }

    private String getValue() {
        return this.value;
    }
}
