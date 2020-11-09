package com.example.veus_plugin;

import java.util.ArrayList;
import java.util.HashMap;

public class Contact implements Comparable<Contact> {
    Contact(String id) {
        this.identifier = id;
    }

    private Contact() {
    }

    String identifier;
    String contactName;
    ArrayList<ContactItem> phones = new ArrayList<>();
    byte[] avatar = new byte[0];

    HashMap<String, Object> toMap() {
        HashMap<String, Object> contactMap = new HashMap<>();
        contactMap.put("identifier", identifier);
        contactMap.put("contactName", contactName);
        contactMap.put("avatar", avatar);

        ArrayList<HashMap<String, String>> emailsMap = new ArrayList<>();

        ArrayList<HashMap<String, String>> phonesMap = new ArrayList<>();
        for (ContactItem phone : phones) {
            phonesMap.add(phone.toMap());
        }
        contactMap.put("phones", phonesMap);

        return contactMap;
    }

    static Contact fromMap(HashMap map) {
        Contact contact = new Contact();
        contact.identifier = (String) map.get("identifier");
        contact.contactName = (String) map.get("contactName");
        contact.avatar = (byte[]) map.get("avatar");

        ArrayList<HashMap> phones = (ArrayList<HashMap>) map.get("phones");
        if (phones != null) {
            for (HashMap phone : phones) {
                contact.phones.add(ContactItem.fromMap(phone));
            }
        }

        return contact;
    }

    @Override
    public int compareTo(Contact contact) {
        String contactName1 = this.contactName == null ? "" : this.contactName.toLowerCase();
        String contactName2 = contact == null ? ""
                : (contact.contactName == null ? "" : contact.contactName.toLowerCase());
        return contactName1.compareTo(contactName2);
    }
}
