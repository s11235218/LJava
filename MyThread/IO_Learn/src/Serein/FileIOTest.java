package Serein;

import org.junit.Test;

import java.io.*;

public class FileIOTest {

    @Test
    public void t1() throws IOException {
        InputStream fis = null;
        try {
            // 方式1：使用FileInputStream + 绝对路径 方式2：使用ClassLoader + 相对路径（推荐）
            // fis = new FileInputStream(new File("E:\\git\\LJava\\MyThread\\IO_Learn\\data\\我的文档.txt"));
            fis = this.getClass().getClassLoader().getResourceAsStream("我的文档.txt");
            // abcdef 读取操作，从当前位置偏移多少位（read, new String中的第二参数），读取多长（第三个参数）
            byte[] bytes = new byte[1024];
            int length;
            while ((length = fis.read(bytes)) != -1) {
                String s = new String(bytes, 0, length);
                System.out.println(s);
            }
        } finally {
            if (fis != null)
                fis.close();
        }
    }

    @Test
    public void t2() throws IOException {
        FileReader reader = new FileReader("E:\\git\\LJava\\MyThread\\IO_Learn\\data\\我的文档.txt");
        char[] chars = new char[1024];
        int length;
        while ((length = reader.read(chars)) != -1) {
            String s = new String(chars, 0, length);
            System.out.println(s);
        }
    }

    @Test
    public void t3() throws IOException {
        FileInputStream fis = new FileInputStream("E:\\git\\LJava\\MyThread\\IO_Learn\\data\\我的文档.txt");
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    }

    @Test
    public void t4() throws IOException {
        FileInputStream fis = new FileInputStream("E:\\git\\LJava\\MyThread\\IO_Learn\\data\\我的文档.txt");
        BufferedInputStream bis = new BufferedInputStream(fis);
        byte[] bytes = new byte[1024];
        int length;

        while ((length = bis.read(bytes)) != -1) {
            String s = new String(bytes, 0, length);
            System.out.println(s);
        }

        while ((length = bis.read(bytes)) != -1) {
            String s = new String(bytes, 0, length);
            System.out.println(s);
        }
    }
}
