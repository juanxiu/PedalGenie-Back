package com.pedalgenie.pedalgenieback.domain.image.dto;

public record ImageResponse(
        String imageUrl
) {
    public static ImageResponse from(String url){
        return new ImageResponse(url);
    }
}
