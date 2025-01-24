package org.charlie.position.infrastructure.utils;

import org.springframework.cglib.beans.BeanCopier;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mah
 * @description
 * @title CopierUtil
 * @date 2025/1/24 10:15
 **/
public class CopierUtil {

    private static final String delimiter = "_";

    private static final Map<String, BeanCopier> copierCache = new HashMap<String, BeanCopier>();

    public static void copy(Object source,Object target){
        String key = String.join(delimiter,source.getClass().getName(),target.getClass().getName());
        BeanCopier copier = copierCache.get(key);
        if (copier == null) {
            copier = BeanCopier.create(source.getClass(),target.getClass(),false);
            copierCache.put(key,copier);
        }
        copier.copy(source,target,null);
    }
}
