package self.srr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import self.srr.config.SfhConfiguration;
import self.srr.model.Files;
import self.srr.model.Message;
import self.srr.processor.FileProcessor;

import java.io.File;

/**
 * Class handling file upload request
 * <p>
 * Created by Sharuru on 2017/03/30.
 */
@RestController
public class FileUploadController {

    @Autowired
    private SfhConfiguration properties;

    @Autowired
    private FileProcessor processor;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public Message uploadFile(@RequestParam("files") MultipartFile[] files) throws Exception {
        Message msg = new Message();

        for (MultipartFile aFile : files) {
            if (!aFile.isEmpty()) {
                try {
                    Files processedFile = processor.save(aFile);
                    msg.setMarkdownComm("![" + aFile.getOriginalFilename() + "](" + properties.getExposedAddr() + processedFile.getFileName() + ")");
                    msg.setMsg("Success: " + aFile.getOriginalFilename());
                } catch (Exception e) {
                    msg.setMsg("Exception captured." + e.getMessage());
                    e.printStackTrace();
                }
            } else {
                msg.setMsg("File is empty.");
            }
        }
        return msg;
    }
}
