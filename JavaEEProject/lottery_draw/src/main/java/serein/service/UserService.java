package serein.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import serein.exception.ClientException;
import serein.exception.SystemException;
import serein.mapper.UserMapper;
import serein.model.User;

import java.io.*;

@Service
public class UserService {

    @Value("${user.head.local-path}")
    private String localPath;
    @Value("${user.head.remote-path}")
    private String remotePath;
    @Value("${user.head.filename}")
    private String fileName;

    @Autowired
    private UserMapper userMapper;

    public User login(User user) {

//        User exist = userMapper.login(user);
//        if (exist == null) {
//            throw new ClientException("USR001", "用户名密码校验失败");
//        }
        User query = new User();
        query.setUsername(user.getUsername());
        User exist = userMapper.selectOne(query);// 只根据用户名查询用户信息
        if (exist == null) {
            throw new ClientException("USR001", "用户不存在！");
        }
        if (!exist.getPassword().equals(user.getPassword()))
            throw new ClientException("USR002", "用户名密码校验失败！");
        return exist;
    }

    public void register(User user, MultipartFile headFile) {

        String path = "/" + user.getUsername() + "/" + fileName;
        user.setHead(remotePath + path);
        userMapper.insertSelective(user);
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;

        try {
            try {
                File dir = new File(localPath + "/" + user.getUsername());
                dir.mkdirs();
                fos = new FileOutputStream(localPath + path);
                bos = new BufferedOutputStream(fos);
                bos.write(headFile.getBytes());
                bos.flush();
            } finally {
                if (bos != null)
                    bos.close();
                if (fos != null)
                    fos.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new SystemException("USER003", "用户注册失败，头像上传错误！");
        }
    }
}
