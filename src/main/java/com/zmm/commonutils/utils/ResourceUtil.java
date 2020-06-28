package com.zmm.commonutils.utils;


import org.apache.commons.lang3.StringUtils;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;
import java.util.UUID;

/**
 * 国际化资源文件工具类
 * 
 * @author lzy
 */
public class ResourceUtil extends ResourceBundleMessageSource
{
    private static final String REQUEST_LOCALE_HEADER = "X-Client-Language";
    
    private static Locale defaultLocale = new Locale("zh", "CN");
    
    private static final String LOCAL_KEY = "RESULTCODE_";
    
    private static final ThreadLocal<Locale> LOCALE_STORE = new InheritableThreadLocal<Locale>();
    

    
    private static final ResourceUtil instance = new ResourceUtil();
    
    public static final String KEY_SEPARATOR = "_";
    
    private ResourceUtil()
    {
    }
    
    /**
     * 获取唯一实例
     * 
     * @return
     */
    public static ResourceUtil getInstance()
    {
        return instance;
    }
    
    /**
     * 获取之指定key的资源描述字符
     * <p>
     * 支持MessageFormat,例如：<br>
     * code: <i>getMessage("USER_NOT_EXIST" , "admin");</i><br>
     * properties:<i>USER_NOT_EXIST = user {0} not exist!</i>
     * </p>
     * 
     * @param key
     * @param args
     * @return
     */

    
    /**
     * 获取返回码指定的资源值
     * 
     * @param code
     * @return
     */

    
    /**
     * 设置当前处理线程的locale
     * 
     * @param localeStr
     */
    public static void setLocale(String localeStr)
    {
        Locale locale = null;
        if (StringUtils.isEmpty(localeStr))
        {
            locale = defaultLocale;
        }
        else
        {
            // 兼容语言和国家的连接符号
            int splitIndex = localeStr.indexOf('_');
            if (splitIndex < 0)
            {
                splitIndex = localeStr.indexOf('-');
            }
            if (splitIndex < 0)
            {
                locale = new Locale(localeStr.toLowerCase());
            }
            else
            {
                locale = new Locale(localeStr.substring(0, splitIndex).toLowerCase(),
                    localeStr.substring(splitIndex + 1).toUpperCase());
            }
        }
        setLocale(locale);
    }
    
    public static void setLocale(Locale locale)
    {
        LOCALE_STORE.set(locale);
    }
    
    /**
     * 获取本地化字符串
     * 
     * @return
     */

    

    
    /**
     * 获取本地化对象
     * 
     * @return
     */
    public static Locale getLocaleObject()
    {
        Locale l = LOCALE_STORE.get();
        if (l == null)
        {
            LOCALE_STORE.set(l = defaultLocale);
        }
        return l;
    }
    
    public static void clearLocale()
    {
        LOCALE_STORE.remove();
    }
    
    public static void setDefaultLocale(Locale locale)
    {
        defaultLocale = locale;
    }
    
    public static Locale getDefaultLocale()
    {
        return defaultLocale;
    }

    public static void main(String[] args) {
        System.out.println(UUID.randomUUID().toString().replaceAll("-",""));
    }
}
