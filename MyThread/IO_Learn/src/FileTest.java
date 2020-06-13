import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileTest {

    @Test
    public void t1() {
        // 文件的相对路径和绝对路径
        //   绝对路径：全路径；
        //   相对路径：./(当前目录)  ../(上一级目录)
        // Java项目在idea中的编译路径
        // 全路径
        File file = new File("E:\\git\\LJava\\MyThread\\IO_Learn\\data\\我的文档.txt");
        System.out.println(file.exists());
        // 相对路径
        File f2 = new File("../data/我的文档.txt");
        System.out.println(f2.exists());
        // 查看Java代码的路径
        File f3 = new File(".");
        System.out.println(f3.getAbsolutePath());// 获取绝对路径
        File f4 = new File("data/我的文档.txt");// file类写相对路径不建议在真实项目使用
        System.out.println(f4.exists());// 文件是否存在
        System.out.println(f4.getPath());// 获取路径
        System.out.println(f4.lastModified());// 上次修改时间

    }

    @Test
    public void t2() {
        File f5 = new File("E:\\git\\LJava\\MyThread");
        File[] children = f5.listFiles();// 返回目录下一级的子文件/子文件夹数组
        for (File child: children) {
            System.out.println(child.getName());// 文件名
        }
    }

    // 递归获取目录下所有子文件和子文件夹
    public static List<File> list(File f) {
        List<File> files = new ArrayList<>();
        if (f.isFile())
            files.add(f);
        else{
            File[] children = f.listFiles();
            for (File child: children) {
                List<File> subs = list(child);
                files.addAll(subs);
            }
        }
        return files;
    }

    @Test
    public void t3() {
        File f5 = new File("E:\\git\\LJava\\MyThread");
        List<File> children = list(f5);// 返回目录下一级的子文件/子文件夹数组
        for (File child: children) {
            System.out.println(child.getName());// 文件名
        }
    }
}
