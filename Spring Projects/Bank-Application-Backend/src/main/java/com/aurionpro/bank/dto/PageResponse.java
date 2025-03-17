package com.aurionpro.bank.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PageResponse<T> {
    private int totalPages;
    private int pageSize;
    private long totalElements;
    private boolean isLast;
    private List<T> content;
}
