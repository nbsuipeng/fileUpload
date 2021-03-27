package com.morefile.upload;


import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 执行文件上传功能，上传到本地路径,多线程上传
 */
public class UploadFile {
    public String sourceFile;
    public String desFile;

    public void setSourceFile(String sourceFile) {
        this.sourceFile = sourceFile;
    }

    public void setDesFile(String desFile) {
        this.desFile = desFile;
    }

    public UploadFile(String sourceFile, String desFile) {
        this.sourceFile = sourceFile;
        this.desFile = desFile;
    }
    public int startUpload() throws Exception {
        //判断文件名是否齐全
        if(sourceFile==null||desFile==null)
        {
            throw new Exception("请指定源和目的文件路径");
        }
        //已指定文件路径
        FileInputStream fis=new FileInputStream(sourceFile);
        FileOutputStream fos=new FileOutputStream(desFile);

        int max=fis.available();
        //byte []b=new byte[max];   //这个正常
        byte []b=new byte[max];     //全部读取
        //一下子把文件全部读进内存可以正常传输
        //分段读分段写就不行，会少一些字节
        /**
         * 已传输:100.0%
         * 247828627  全部
         * 247709696  传输  少了一些 且b越大，少的越少
         */
        int sum=0;

        //开始传输
        
        
        long start = System.currentTimeMillis();
        
        while(fis.read()!=-1)
        {
            fis.read(b,0,b.length);
            fos.write(b,0,b.length);
            sum+=b.length;
            System.out.println("已传输:"+Math.ceil(sum/(double)max*100)+"%");
//            System.out.println(max);
//            System.out.println(sum);

        }
        long end = System.currentTimeMillis();
        System.out.println("共花费:"+(end-start)/1000.0+"秒");

        fis.close();
        fos.close();

        return 1;
    }


}
