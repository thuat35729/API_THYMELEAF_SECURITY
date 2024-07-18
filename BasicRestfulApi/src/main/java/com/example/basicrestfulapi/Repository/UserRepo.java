package com.example.basicrestfulapi.Repository;

import com.example.basicrestfulapi.Entity.User;
import com.example.basicrestfulapi.Map.UserMap;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class UserRepo {
    RestTemplate rest = new RestTemplate();
    String url = "https://poly-java6-e4363-default-rtdb.firebaseio.com/user.json";

    private String getUrl(String key) {
        return url.replace(".json", "/" + key + ".json");
    }

    public UserMap findAll() {
        return rest.getForObject(url, UserMap.class);
    }

    public User findByKey(String key) {
        return rest.getForObject(getUrl(key), User.class);
    }

    public String create(User data) {
        HttpEntity<User> entity = new HttpEntity<>(data);
        JsonNode resp = rest.postForObject(url, entity, JsonNode.class);
        return resp.get("name").asText();
    }

    public User update(String key, User data) {
        HttpEntity<User> entity = new HttpEntity<>(data);
        rest.put(getUrl(key), entity);
        return data;
    }

    public void delete(String key) {
        rest.delete(getUrl(key));
    }
}
