package self.srr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import self.srr.config.SfhConfiguration;
import self.srr.model.Message;

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

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public Message uploadFile(@RequestParam("file") MultipartFile file) throws Exception {
        Message msg = new Message();

        if (!file.isEmpty()) {

            try {
                String rootPath = properties.getStoragePath();
                File targetPath = new File(rootPath);
                if (!targetPath.exists()) {
                    targetPath.mkdirs();
                }
                file.transferTo(new File(targetPath.getAbsolutePath() + File.separator + file.getOriginalFilename()));
                msg.setMsg("Success");
            } catch (Exception e) {
                msg.setMsg("Exception captured." + e.getMessage());
                e.printStackTrace();
            }
        } else {
            msg.setMsg("File is empty.");
        }
        return msg;
    }
}
