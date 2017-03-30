package self.srr.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Sharuru on 2017/03/30.
 */
@RestController
public class FileUploadController {

    @RequestMapping(value = "/upload", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public String uploadFile(@RequestParam("file") MultipartFile file) throws Exception {
        if (!file.isEmpty()) {
            InputStream in = null;
            OutputStream out = null;

            try {
                String rootPath = "D:\\abc";
                File dir = new File(rootPath + File.separator + "tmpFiles");
                if (!dir.exists())
                    dir.mkdirs();
                File serverFile = new File(dir.getAbsolutePath() + File.separator + file.getOriginalFilename());
                in = file.getInputStream();
                out = new FileOutputStream(serverFile);
                byte[] b = new byte[1024];
                int len = 0;
                while ((len = in.read(b)) > 0) {
                    out.write(b, 0, len);
                }
                out.close();
                in.close();
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
            } finally {
                if (out != null) {
                    out.close();
                    out = null;
                }

                if (in != null) {
                    in.close();
                    in = null;
                }
            }
        } else {
            /*Message msg = new Message();
            msg.setStatus(Status.ERROR);
            msg.setError("File is empty");
            return msg;*/
        }

        return "OK";
    }
}
