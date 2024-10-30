package com.app.ggumteo.repository.admin;

import com.app.ggumteo.domain.admin.AnnouncementVO;
import com.app.ggumteo.mapper.admin.AnnouncementMapper;
import com.app.ggumteo.pagination.AdminPagination;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AnnouncementDAO {
    private final AnnouncementMapper announcementMapper;

//    공지사항작성
    public void save(AnnouncementVO announcementVO) {
        announcementMapper.insert(announcementVO);
    }
    // 공지사항 전체 조회 (페이지네이션 포함)
    public List<AnnouncementVO> findAll(AdminPagination pagination) {
        return announcementMapper.selectAll(pagination);
    }

    // 총 공지사항 수 조회
    public int countTotal() {
        return announcementMapper.countTotal();
    }
}
