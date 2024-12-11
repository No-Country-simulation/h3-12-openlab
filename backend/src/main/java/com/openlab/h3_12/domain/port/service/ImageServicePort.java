package com.openlab.h3_12.domain.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

public interface ImageServicePort {
    Optional<Map> upload(MultipartFile multipartFile, Long id) throws IOException;

    Map delete(String publicId) throws IOException;
}
