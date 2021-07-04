package lk.ijse.spring.service.impl;

import lk.ijse.spring.service.FileSystemService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;

@Service
@Transactional
public class FileSystemServiceImpl implements FileSystemService {

    @Override
    public void nicFile(MultipartFile file, String id) throws IOException {
        file.transferTo(new File("/home/chathumal/Pictures/project/upload" + "/nic/" + id));
    }

    @Override
    public void orderFile(MultipartFile file, String id) throws IOException {
        file.transferTo(new File("/home/chathumal/Pictures/project/upload" + "/orders/" + id));
    }

    @Override
    public void carFiles(MultipartFile[] file, String id) throws IOException {
        int nId = 0;
        String newPath = "/home/chathumal/Pictures/project/upload" + "/cars/" + id;

        new File(newPath).mkdir();
        for (MultipartFile img : file) {
            img.transferTo(new File(newPath + "/" + nId));
            nId++;
        }
    }


}
