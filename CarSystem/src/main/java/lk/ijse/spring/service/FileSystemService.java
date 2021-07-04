package lk.ijse.spring.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileSystemService {
    void nicFile(MultipartFile file, String id) throws IOException;
    void orderFile(MultipartFile file, String id) throws IOException;
    void carFiles(MultipartFile[] file, String id) throws IOException;

}
