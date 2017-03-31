package self.srr.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import self.srr.config.SfhConfiguration;
import self.srr.mapper.FileMapper;
import self.srr.model.Files;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Arrays;

/**
 * Created by Sharuru on 2017/03/30.
 */
@Service
public class FileProcessor {

    @Autowired
    FileMapper mapper;

    @Autowired
    private SfhConfiguration properties;


    public boolean save(MultipartFile receivedFile) {

        try {
            // calc MD5
            String md5 = calcMD5(receivedFile);

            // check duplicate
            Files queriedFile = mapper.findOneByFilename(md5);
            if (queriedFile == null) {
                // first time, save
                storage(receivedFile);
                // write to database
                Files dao = new Files();
                dao.setOrgFilename(receivedFile.getOriginalFilename());
                dao.setFileName(md5 + ".jpg");
                dao.setAdm_password("default");
                dao.setCreator("web");
                mapper.insert(dao);
            } else {
                // skip and return queriedFile
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * Save file to local
     *
     * @param file target file
     * @throws IOException exception
     */
    private void storage(MultipartFile file) throws IOException {
        String rootPath = properties.getStoragePath();
        File targetPath = new File(rootPath);
        if (!targetPath.exists()) {
            targetPath.mkdirs();
        }
        file.transferTo(new File(targetPath.getAbsolutePath() + File.separator + file.getOriginalFilename()));
    }


    /**
     * Get MD5 of a multipart file
     *
     * @param file single multipart file
     * @return MD5 in uppercase
     */
    private String calcMD5(MultipartFile file) throws Exception {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(file.getBytes());
        return new BigInteger(1, md5.digest()).toString(16).toUpperCase();
    }
}
