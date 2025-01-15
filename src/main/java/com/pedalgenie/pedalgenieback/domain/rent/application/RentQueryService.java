package com.pedalgenie.pedalgenieback.domain.rent.application;

import com.pedalgenie.pedalgenieback.domain.rent.dto.response.RentDetailResponse;
import com.pedalgenie.pedalgenieback.domain.rent.dto.response.RentListResponse;
import com.pedalgenie.pedalgenieback.domain.rent.entity.Rent;
import com.pedalgenie.pedalgenieback.domain.rent.repository.RentRepository;
import com.pedalgenie.pedalgenieback.global.exception.CustomException;
import com.pedalgenie.pedalgenieback.global.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class RentQueryService {

    private final RentRepository rentRepository;


    // 대여 상세 조회
    public RentDetailResponse getRentDetail(Long rentId){
        Rent rent = getRent(rentId);

        return new RentDetailResponse(
                rent.getId(),
                rent.getRentStartTime(),
                rent.getRentEndTime(),
                rent.getProduct().getPrice(),
                rent.getMember().getNickname(),
                LocalDate.now(),
                rent.getRentStatusType().name(),
                rent.getProduct().getName(),
                rent.getProduct().getShop().getShopname()
        );
    }
    // 대여 목록 조회
    public List<RentListResponse> getRentList(Long memberId) {

        List<Rent> rents = rentRepository.findAllByMemberId(memberId);


        return rents.stream()
                .map(RentListResponse::from)
                .toList();
    }

    // 어드민용, 대여 상태 픽업 예정으로 변경
    public RentDetailResponse updateRentStatusToPickUp(Long rentId){
        Rent rent = getRent(rentId);

        rent.updateToPickUp();
        rentRepository.save(rent);

        return new RentDetailResponse(
                rent.getId(),
                rent.getRentStartTime(),
                rent.getRentEndTime(),
                rent.getProduct().getPrice(),
                rent.getMember().getNickname(),
                LocalDate.now(),
                rent.getRentStatusType().name(),
                rent.getProduct().getName(),
                rent.getProduct().getShop().getShopname()
        );
    }

    // 직원 확인용, 사용 중으로 변경
    public RentDetailResponse updateRentStatusToInUse(Long rentId){
        Rent rent = getRent(rentId);

        rent.updateToRent();
        rentRepository.save(rent);

        return new RentDetailResponse(
                rent.getId(),
                rent.getRentStartTime(),
                rent.getRentEndTime(),
                rent.getProduct().getPrice(),
                rent.getMember().getNickname(),
                LocalDate.now(),
                rent.getRentStatusType().name(),
                rent.getProduct().getName(),
                rent.getProduct().getShop().getShopname()
        );
    }

    // 직원 확인용, 반납 완료로 변경
    public RentDetailResponse updateRentStatusToReturned(Long rentId){
        Rent rent = getRent(rentId);

        rent.updateToRETURND();
        rentRepository.save(rent);

        return new RentDetailResponse(
                rent.getId(),
                rent.getRentStartTime(),
                rent.getRentEndTime(),
                rent.getProduct().getPrice(),
                rent.getMember().getNickname(),
                LocalDate.now(),
                rent.getRentStatusType().name(),
                rent.getProduct().getName(),
                rent.getProduct().getShop().getShopname()
        );
    }

    // 어드민용, 취소로 변경
    public RentDetailResponse cancelRent(Long rentId){
        Rent rent = getRent(rentId);

        rent.cancel();
        rentRepository.save(rent);

        return new RentDetailResponse(
                rent.getId(),
                rent.getRentStartTime(),
                rent.getRentEndTime(),
                rent.getProduct().getPrice(),
                rent.getMember().getNickname(),
                LocalDate.now(),
                rent.getRentStatusType().name(),
                rent.getProduct().getName(),
                rent.getProduct().getShop().getShopname()
        );
    }

    private Rent getRent(final Long rentId){
        return rentRepository.findById(rentId)
                .orElseThrow(()-> new CustomException(ErrorCode.NOT_FOUND_RENT));
    }

}
