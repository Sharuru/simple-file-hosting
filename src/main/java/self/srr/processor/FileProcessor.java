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

/**
 * File processor
 * <p>
 * Created by Sharuru on 2017/03/30.
 */
@Service
public class FileProcessor {

    @Autowired
    private FileMapper mapper;

    @Autowired
    private SfhConfiguration properties;


    /**
     * Save file process
     *
     * @param receivedFile file
     * @return processed file model
     */
    public Files save(MultipartFile receivedFile) {
        try {
            // calc MD5
            String md5 = calcMD5(receivedFile);
            // check duplicate
            Files queriedFile = mapper.findOneByFilename(md5 + ".jpg");
            if (queriedFile == null) {
                // first time, save
                storage(receivedFile, md5);
                // write to database
                Files dao = new Files();
                dao.setOrgFilename(receivedFile.getOriginalFilename());
                dao.setFileName(md5 + ".jpg");
                dao.setAdm_password("default");
                dao.setCreator("web");
                mapper.insert(dao);
                return dao;
            } else {
                return queriedFile;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Save file to local
     *
     * @param file target file
     * @throws IOException exception
     */
    private void storage(MultipartFile file, String md5) throws IOException {
        String rootPath = properties.getStoragePath();
        File targetPath = new File(rootPath);
        if (!targetPath.exists()) {
            targetPath.mkdirs();
        }
        file.transferTo(new File(targetPath.getAbsolutePath() + File.separator + md5 + ".jpg"));
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
