package com.pedalgenie.pedalgenieback.global.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    // 400
    BAD_REQUEST(HttpStatus.BAD_REQUEST, 400, "잘못된 요청입니다."),
    PASSWORD_MISMATCH(HttpStatus.BAD_REQUEST, 400, "비밀번호가 일치하지 않습니다."),

    KAKAO_LOGIN_FAILED(HttpStatus.BAD_REQUEST, 400, "카카오 로그인에 실패했습니다."),
    KAKAO_ACCESS_TOKEN_ERROR(HttpStatus.BAD_REQUEST, 400, "카카오 액세스 토큰을 가져오는데 실패했습니다."),
    KAKAO_USER_INFO_ERROR(HttpStatus.BAD_REQUEST, 400, "카카오 사용자 정보를 가져오는데 실패했습니다."),
    KAKAO_UNLINK_FAILED(HttpStatus.BAD_REQUEST, 400, "카카오 연동 해제에 실패했습니다."),
    KAKAO_INVALID_CODE(HttpStatus.BAD_REQUEST, 400, "유효하지 않은 카카오 인가 코드입니다."),

    // 401
    AUTHENTICATION_FAILED(HttpStatus.UNAUTHORIZED, 401, "인증에 실패했습니다."),
    TOKEN_EXPIRED(HttpStatus.UNAUTHORIZED, 401, "토큰이 만료되었습니다."),
    NOT_VALID_TOKEN(HttpStatus.UNAUTHORIZED, 401, "토큰이 유효하지 않습니다."),
    NOT_EXISTS_AUTHORIZATION(HttpStatus.UNAUTHORIZED, 401, "Authorization 헤더가 비어 있습니다."),
    NOT_VALID_BEARER_GRANT_TYPE(HttpStatus.UNAUTHORIZED, 401, "인증 타입이 Bearer 타입이 아닙니다."),
    REFRESH_TOKEN_NOT_FOUND(HttpStatus.UNAUTHORIZED, 401, "refresh token이 존재하지 않습니다."),
    REFRESH_TOKEN_EXPIRED(HttpStatus.UNAUTHORIZED, 401, "refresh token이 만료되었습니다."),
    NOT_ACCESS_TOKEN_TYPE(HttpStatus.UNAUTHORIZED, 401, "해당 토큰은 ACCESS TOKEN이 아닙니다."),

    // 403
    NO_PERMISSION(HttpStatus.FORBIDDEN, 403, "권한이 없습니다."),
    FORBIDDEN_ROLE(HttpStatus.FORBIDDEN, 403, "허용되지 않은 역할을 가진 유저의 요청입니다."),

    // 404
    NOT_EXISTS_MEMBER_ID(HttpStatus.NOT_FOUND, 404, "존재하지 않는 멤버 아이디입니다."),
    NOT_EXISTS_MEMBER_NICKNAME(HttpStatus.NOT_FOUND, 404, "존재하지 않는 멤버 닉네임입니다."),
    NOT_EXISTS_MEMBER_EMAIL(HttpStatus.NOT_FOUND, 404, "존재하지 않는 멤버 이메일입니다."),
    NOT_EXISTS_SHOP_ID(HttpStatus.NOT_FOUND,404,"존재하지 않는 가게 아이디입니다."),

    NOT_FOUND_SHOP_NAME(HttpStatus.NOT_FOUND, 404, "존재하지 않는 가게 이름입니다."),
    NOT_FOUND_SUBCATEGORY(HttpStatus.NOT_FOUND,404,"존재하지 않는 서브 카테고리입니다."),
    NOT_FOUND_PRODUCT(HttpStatus.NOT_FOUND,404,"존재하지 않는 상품입니다."),
    NOT_FOUND_CATEGORY(HttpStatus.NOT_FOUND,404,"존재하지 않는 카테고리입니다."),
    NOT_FOUND_PRODUCT_IMAGE(HttpStatus.NOT_FOUND,404,"존재하지 않는 상품 이미지입니다."),
    NOT_FOUND_SORT_BY(HttpStatus.NOT_FOUND,404,"해당하는 정렬 기준을 찾을 수 없습니다."),
    NOT_FOUND_LIKE(HttpStatus.NOT_FOUND,404,"존재하지 않는 좋아요입니다."),

    NOT_FOUND_ARTICLE(HttpStatus.NOT_FOUND,404, "존재하지 않는 아티클입니다."),

    // 409
    ALREADY_REGISTERED_MEMBER_EMAIL(HttpStatus.CONFLICT, 409, "이미 가입된 이메일입니다."),
    ALREADY_LIKED(HttpStatus.CONFLICT, 409, "이미 좋아요를 눌렀습니다."),

    // 500
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, 500, "서버 오류가 발생했습니다.");

    private final HttpStatus httpStatus;
    private final int code;
    private final String message;
}
