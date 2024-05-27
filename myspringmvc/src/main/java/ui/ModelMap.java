package ui;

import java.util.LinkedHashMap;

/**
 * 将数据存储到域中
 */
public class ModelMap extends LinkedHashMap<String, Object> {
    public ModelMap() {

    }

    public ModelMap addAttribute(String key, Object value) {
        this.put(key, value);
        return this;
    }

}
