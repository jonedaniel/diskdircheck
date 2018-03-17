import com.sun.deploy.util.StringUtils;

import java.io.File;
import java.util.Scanner;

/**
 * a simple util to check you disk`s file size
 * qq 1392954851
 * @author https://github.com/jonedaniel
 */
public class DiskCheckUtil {
    public static void main(String[] args) {
        System.out.println("Please Input The disk dir`s fullpath you want to check");
        Scanner s = new Scanner(System.in);
        new DiskCheckUtil().getAllDir(s.nextLine());
        System.out.println(DiskFileCheck.author);
    }

    private void getAllDir(String filePath) {
        if (filePath==null||"".equals(filePath)) {
            filePath = "C:/Windows";
            System.out.println("default C:/Windows dir`s status:");
        }
        File file = new File(filePath);
        fileLoop(file);

    }

    private void fileLoop(File file) {
        if (file.isDirectory()) {
            if (file.length() == 0) {
                return;
            }
            save(file);
            File[] files = file.listFiles();
            if (files == null) {
                return;
            }
            for (File file1 : files) {
                fileLoop(file1);
            }
        }
    }

    private void save(File file) {
        DiskFileCheck df = new DiskFileCheck();
        df.setName(file.getName());
        Long size = getSize(file);
        if (size < 200) {
            return;
        }
        df.setSize(size.toString()+"MB");
        df.setPath(file.getPath());
        System.out.println(df);
    }

    private Long getSize(File file) {
        Long   sum   = 0L;
        File[] files = file.listFiles();
        if (files!=null) {
            for (File file1 : files) {
                sum += file1.length();
            }
        }
        return sum/1024/1024;
    }
}
