package com.app.ggumteo.domain.work;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class WorkVO {

    private Long id; // 작품 ID
    private String workPrice; // 작품 가격
    private Long genreId; // 장르 ID
    private int readCount; // 조회수
    private String createdDate; // 생성 날짜
    private String updatedDate; // 수정 날짜

}