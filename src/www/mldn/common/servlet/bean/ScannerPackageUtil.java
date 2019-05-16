package www.mldn.common.servlet.bean;

import java.io.File;

public class ScannerPackageUtil {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
    public ScannerPackageUtil() {
    }
    public static void scannerHandle(Class<?> clazz,String packages){
        //将当前获取到的包进行拆分
        String[] resultPackages = packages.split(";");
        String baseDir = clazz.getResource("/").getPath();
        baseDir = baseDir.substring(1).replace("/",File.separator);
        /*
           System.out.println(baseDir);
            /D:/工作空间/idea工作空间/message/out
            /artifacts/DispacherServlet_war_exploded/
            WEB-INF/classes/
        */
        for (int i = 0; i <resultPackages.length ; i++) {
            String subDir = resultPackages[i].replace(".", File.separator);
            System.out.println("File路径:"+baseDir + subDir);
            File file = new File(baseDir,subDir);
            listDirClass(file,baseDir);
        }
    }

    private static void listDirClass(File file,String baseDir) {
        if (file.isDirectory()){
            File[] result = file.listFiles();
            if(result !=null){
               for (int i = 0; i < result.length; i++) {
            	   listDirClass(result[i],baseDir);
               }
            }
        }else{
            if(file.isFile()){
            	String className = 
            			file.getAbsolutePath().replace(baseDir, "").
            			replace(File.separator,".").replace(".class","");
            	System.out.println("className:"+className);
            }
        }
    }
}






