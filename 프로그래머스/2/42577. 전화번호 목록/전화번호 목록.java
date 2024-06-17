import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        Map<String, Integer> phoneMap = new HashMap<>();
        for (String phone : phone_book) {
            phoneMap.put(phone, 1);
        }

        for (String phone : phone_book) {
            for (int i = 1; i < phone.length(); i++) {
                String prefix = phone.substring(0, i);
                if (phoneMap.containsKey(prefix)) {
                    return false;
                }
            }
        }

        return true;
    }
}