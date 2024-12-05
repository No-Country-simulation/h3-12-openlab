package com.openlab.h3_12.application.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.openlab.h3_12.domain.service.ImageServicePort;
import lombok.RequiredArgsConstructor;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ImageService implements ImageServicePort {
    private final Cloudinary cloudinary;

    public Optional<Map> upload(MultipartFile multipartFile, Long id) throws IOException {
        if (StringUtils.isBlank(multipartFile.getOriginalFilename())) {
            throw new BadRequestException("La imagen no puede estar vacia");
        }

        String etag = DigestUtils.md5Hex(multipartFile.getInputStream());
        Map<String, Object> params = ObjectUtils.asMap(
                "public_id", etag,
                "overwrite", false
        );
        Map uploadResult = cloudinary.uploader().upload(multipartFile.getBytes(), params);

        return Optional.of(uploadResult);
    }

    @Transactional
    public Map delete(String publicId) throws IOException {
        if (StringUtils.isBlank(publicId)) {
            throw new BadRequestException("La imagen no puede estar vacia");
        }
        return cloudinary.uploader().destroy(publicId, ObjectUtils.emptyMap());
    }

}
