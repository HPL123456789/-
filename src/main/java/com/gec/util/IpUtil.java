package com.gec.util;

import com.maxmind.db.CHMCache;
import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.model.CountryResponse;
import com.maxmind.geoip2.record.*;


import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;

public class IpUtil {
   static DatabaseReader reader = null;
    static{
        String destFilePath = new File("D:\\桌面\\zkweblogssm\\src\\main\\resources\\GeoLite2-City.mmdb").getAbsolutePath();
        File database = new File(destFilePath);

        // 读取数据库内容
        try {
            reader = new DatabaseReader.Builder(database).build();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static  String getRegion(String ip){
        try {
            InetAddress ipAddress = InetAddress.getByName(ip);//要解析的ip地址
            // 获取查询结果
            CityResponse response = reader.city(ipAddress);
            // 获取省份
            Subdivision subdivision = response.getMostSpecificSubdivision();

            return subdivision.getNames().get("zh-CN");

        } catch (Exception e) {
            e.printStackTrace();
        }
            return null;
    }

    public static void main(String[] args) throws Exception {
        // 创建 GeoLite2 数据库

//        String destFilePath = new File("src/main/resources/GeoLite2-City.mmdb").getAbsolutePath();
//        File database = new File(destFilePath);

        // 读取数据库内容
//        DatabaseReader reader = new DatabaseReader.Builder(database).build();
//        InetAddress ipAddress = InetAddress.getByName("183.49.46.228");//要解析的ip地址

//        // 获取查询结果
//        CityResponse response = reader.city(ipAddress);
//
//        // 获取国家信息
//        Country country = response.getCountry();
//        System.out.println(country.getIsoCode());               // 'CN'
//        System.out.println(country.getName());                  // 'China'
//        System.out.println(country.getNames().get("zh-CN"));    // '中国'
//
//        // 获取省份
//        Subdivision subdivision = response.getMostSpecificSubdivision();
//        System.out.println(subdivision.getName());   // 'Guangxi'
//        System.out.println(subdivision.getIsoCode()); // 'GX'
//        System.out.println(subdivision.getNames().get("zh-CN")); // '广西壮族自治区'
//        String s = subdivision.getNames().get("zh-CN");
//
//
//        // 获取城市
//        City city = response.getCity();
//        System.out.println(city.getName()); // 'Guilin'
//        Postal postal = response.getPostal();
//        System.out.println(postal.getCode()); // 'null'
//        System.out.println(city.getNames().get("zh-CN")); // '桂林市'
//        Location location = response.getLocation();
//        System.out.println(location.getLatitude());  // 25.2802
//        System.out.println(location.getLongitude()); // 110.2964

        System.out.println(IpUtil.getRegion("1.80.249.223"));
    }


}
