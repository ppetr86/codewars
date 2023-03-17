package com.example.entwicklerheld;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EasyStorage {

    private HashMap<String, String> storage = new HashMap<>();

    public void store(String item, String repository) {
        if (item == null || repository == null) {
            throw new NullPointerException();
        }
        if (item.trim().isEmpty() || repository.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
        storage.put(item, repository);
    }

    public Map<String, String> getAllData() {
        return storage;
    }

    public String getRepository(String item) {
        return storage.get(item);
    }

    public Set<String> getItems(String repository) {

        Set<String> result = new HashSet<>();
        for (Map.Entry<String, String> pair : storage.entrySet()) {
            if (pair.getValue().equals(repository))
                result.add(pair.getKey());
        }
        return result;
    }

}
