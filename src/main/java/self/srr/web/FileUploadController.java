package self.srr.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import self.srr.model.Message;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Sharuru on 2017/03/30.
 */
@RestController
public class FileUploadController {

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public Message uploadFile(@RequestParam("file") MultipartFile file) throws Exception {
        Message msg = new Message();

        if (!file.isEmpty()) {

            try {
                String rootPath = "E:\\recv";
                File targetPath = new File(rootPath);
                if (!targetPath.exists()) {
                    targetPath.mkdirs();
                }

                file.transferTo(new File(targetPath.getAbsolutePath() + File.separator + file.getOriginalFilename()));

                //logger.info("Server File Location=" + serverFile.getAbsolutePath());

      /*          Message msg = new Message();
                msg.setStatus(Status.SUCCESS);
                msg.setStatusMsg("File upload success");
                return msg;*/
            } catch (Exception e) {
//                Message msg = new Message();
//                msg.setStatus(Status.ERROR);
//                msg.setError("File upload file");
//                return msg;
                e.printStackTrace();
            }
        } else {
            /*Message msg = new Message();
            msg.setStatus(Status.ERROR);
            msg.setError("File is empty");
            return msg;*/
        }
        msg.setMsg("aaaa");
        return msg;
    }
}
