package com.example.kingcar_be.Service;

import com.amazonaws.services.s3.AmazonS3Client;
import com.example.kingcar_be.DTO.BrandResponse;
import com.example.kingcar_be.DTO.ModelResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@SpringBootApplication
@RequiredArgsConstructor
public class AwsService {

    private final AmazonS3Client amazonS3Client;

    @Value("${cloud.aws.s3.bucket}")
    private String bucketName;

    public String getThumbnailPath(String path) {
        return amazonS3Client.getUrl(bucketName, path).toString();
    }

    //특정 브랜드 차 모델 이미지 조회
    public List<String> getModelImagesAll (String directory , String category) {
        List<String> list = new ArrayList<>();
        category+="_";
        for (int i = 1; i < 4; i++) {
            String str = String.valueOf(i) + ".png";
            System.out.println(str);
            list.add(getThumbnailPath(directory + category + str));
        }
        return list;
    }

        //브랜드 이미지 모두 조회
        public List<String> getBrandImageAll(String directory){
            List<String> list = new ArrayList<>();

            for (int i = 1; i<7; i++){
                String str = String.valueOf(i)+ ".png";
                System.out.println(str);
                str=getThumbnailPath(directory + str);
                list.add(str);
            }
            return list;
        }
}
