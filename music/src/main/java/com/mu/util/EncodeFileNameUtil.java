package com.mu.util;

public class EncodeFileNameUtil {

   public static String encode(int singerId,int albumId,int songId){
       return singerId+"sa"+albumId+"as"+songId;
   }

    public static String encodeLy(int singerId,int albumId,int songId){
        return singerId+"sa"+albumId+"ly"+songId;
    }
}
