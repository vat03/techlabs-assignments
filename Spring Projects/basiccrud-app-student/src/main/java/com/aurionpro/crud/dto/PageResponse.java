package com.aurionpro.crud.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class PageResponse<T> {
	private int totalPages;
	private int pageSize;
	private long totalElements;
	private boolean isLast;
	private List<T> content;
}
