package WHJ.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PaginationDTO<T> {
    private List<T> data;
    private List<QuestionDTO> questions;
    private List<QuestionDTO> latestQuestions;
    private boolean showPrevious;
    private boolean showFirstPage;
    private boolean showNext;
    private boolean showEndPage;
    private Integer page;
    private List<Integer> pages = new ArrayList<>();
    private Integer totalPage;

    public void setPagination(Integer totalCount, Integer uncheckedPage, Integer size) {

        if (totalCount % size == 0) {
            this.totalPage = totalCount / size;
        } else {
            this.totalPage = totalCount / size + 1;
        }

        if (uncheckedPage!=0 && uncheckedPage > totalPage) {
            page = totalPage;
        }else if (uncheckedPage < 1) {
            page = 1;
        } else {
            page = uncheckedPage;
        }

        pages.add(page);
        for (int i = 1; i <= 3; i++) {
            if (page - i > 0) {
                pages.add(0, page - i);
            }

            if (page + i <= totalPage) {
                pages.add(page + i);
            }
        }

        showPrevious = page != 1;

        if (page.equals(totalPage)) {
            showNext = false;
        } else showNext = !totalPage.equals(0);

        showFirstPage = !page.equals(1);

        if (totalPage.equals(0))
            showEndPage = false;
        else showEndPage = !page.equals(totalPage);
    }

}
