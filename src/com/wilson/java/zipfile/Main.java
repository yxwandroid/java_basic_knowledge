package com.wilson.java.zipfile;

/**
 * Created by yangxuewu on 2017/12/3.
 */
public class Main {

    public static void main(String[] args) {

        String[] my={"/Users/yangxuewu/Desktop/wilson.docx"};
        ZipCompressor compressor = new ZipCompressor();
        boolean isSuccessful = compressor.zipCompress(my,my[my.length-1]);
        if (isSuccessful) {
            System.out.println("文件压缩成功。");
        } else {
            System.out.println("文件压缩失败。");
        }
    }
}
