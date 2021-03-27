package upload;

import upload.upload.UploadFile;

public class main {

    public String filePath="";
    public static void main(String[] args) {


        UploadFile uf=new UploadFile("C:\\Users\\15478\\Desktop\\新知识入口\\《Redis开发与运维》.pdf","C:\\Users\\15478\\Desktop\\file.pdf");
        try {
            uf.startUpload();
        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
