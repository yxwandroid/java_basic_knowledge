package com.wilson.java.zipfile;

public class ZipFileDemo {

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
