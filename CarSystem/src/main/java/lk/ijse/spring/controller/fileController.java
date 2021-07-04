package lk.ijse.spring.controller;
import lk.ijse.spring.service.FileSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

@RestController
@CrossOrigin
@RequestMapping("/file")

public class fileController {

    @Autowired
    FileSystemService service;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveFile(@RequestPart("myFile") MultipartFile myFile) {

        try {
            String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
            File uploadsDir = new File(projectPath + "/uploads");
            uploadsDir.mkdir();
            myFile.transferTo(new File(uploadsDir.getAbsolutePath() + "/" + myFile.getOriginalFilename()));
            return true;
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
            return false;
        }

//        try {
//            service.nicFile(myFile, myFile.getOriginalFilename());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return true;

    }


    }






    ////////////////////////////////////////////////////////////////////////////////////////



//
//    @PostMapping
//    public ResponseEntity saveNicImage(MultipartFile file) throws IOException {
//        service.nicFile(file,"C1212");
//        return new ResponseEntity(new StandardResponse("200", "Done", null), HttpStatus.OK);
//    }
//
//    @PostMapping(params = {"id"})
//    public ResponseEntity saveNicImage(@RequestParam("file") MultipartFile file, String id) throws IOException {
//        service.nicFile(file, id);
//        return new ResponseEntity(new StandardResponse("200", "Done", id), HttpStatus.OK);
//    }
//
//
//    @PostMapping("/upload")
//    public ResponseEntity saveNicImage(@RequestParam MultipartFile file) throws IOException {
//
//        String fileName = file.getOriginalFilename();
//        try {
//            file.transferTo( new File("/home/chathumal/Videos" + fileName));
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//        return ResponseEntity.ok("File uploaded successfully.");
//
//        service.nicFile(file, "C001");
//
//    }
//
//    @PostMapping(params = {"oid"})
//    public ResponseEntity saveBankSlipImage(@RequestParam("file") MultipartFile file, String oid) throws IOException {
//        service.orderFile(file, oid);
//        return new ResponseEntity(new StandardResponse("200", "Done", oid), HttpStatus.OK);
//    }
//
//    @PostMapping(params = {"regNo"})
//    public ResponseEntity saveBankSlipImage(@RequestParam("file") MultipartFile[] file, String regNo) throws IOException {
//        service.carFiles(file, regNo);
//        return new ResponseEntity(new StandardResponse("200", "Done", regNo), HttpStatus.OK);
//    }





//}
