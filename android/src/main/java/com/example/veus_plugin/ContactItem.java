package com.example.veus_plugin;

import java.util.HashMap;
import java.util.Map;

import static android.provider.ContactsContract.CommonDataKinds;

public class ContactItem {
    public String contactType, value;

    private static Map<Integer, String> phoneStringTypes = new HashMap<Integer, String>() {{
        put(CommonDataKinds.Phone.TYPE_HOME, "home");
        put(CommonDataKinds.Phone.TYPE_WORK, "work");
        put(CommonDataKinds.Phone.TYPE_FAX_WORK, "fax work");
        put(CommonDataKinds.Phone.TYPE_FAX_HOME, "fax home");
        put(CommonDataKinds.Phone.TYPE_MAIN, "main");
        put(CommonDataKinds.Phone.TYPE_COMPANY_MAIN, "company");
        put(CommonDataKinds.Phone.TYPE_PAGER, "pager");
    }};

    public ContactItem(String contactType, String value) {
        this.contactType = contactType;
        this.value = value;
    }

    HashMap<String, String> toMap() {
        HashMap<String, String> result = new HashMap<>();
        result.put("contactType", contactType);
        result.put("value", value);
        return result;
    }

    public static ContactItem fromMap(HashMap<String, String> map) {
        return new ContactItem(map.get("contactType"), map.get("value"));
    }

    public static String getPhoneStringType(Integer type) {
        if (phoneStringTypes.containsKey(type)) {
            return phoneStringTypes.get(type);
        }

        return "other";
    }
}
