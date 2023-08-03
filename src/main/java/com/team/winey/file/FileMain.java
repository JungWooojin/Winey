package com.team.winey.file;

import com.team.winey.file.model.FileEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

@Component
@RequiredArgsConstructor
public class FileMain {

    @Value("${file.dir}")
    private String fileDir;

    private final FileMapper MAPPER;

    public void imgFile() {
        String urlPath = "https://images.vivino.com/thumbs/";
        String localPath = fileDir;

        for (int i = 1; i < 486; i++) {
            FileEntity entity = MAPPER.getFileEntityById(i); // FileMapper를 활용하여 DB에서 이미지 URL을 가져옴

            String path = entity.getImagePath();
            String fullPath = "https:" + path;
            String fileName = fullPath.replace(urlPath, "");

            String file_ext = fileName.substring(
                    fileName.lastIndexOf('.') + 1,
                    fileName.length());

            try {
                String realUrl = urlPath + fileName;

                BufferedImage image = ImageIO.read(new URL(realUrl));

                ImageIO.write(image, file_ext, new File(localPath + "/" + fileName));

                System.out.println(fileName + " 다운완료");

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("failed");
            }
        }
    }

}
