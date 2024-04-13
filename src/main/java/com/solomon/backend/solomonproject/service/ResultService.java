package com.solomon.backend.solomonproject.service;

import com.solomon.backend.solomonproject.model.Result;

import java.util.List;
import java.util.Optional;

public interface ResultService {
    List<Result> getResults();
    Result getResult(Long id);
    void saveResult(Result result);
    void deleteResult(Long id);
    void updateResult(Long id, Result updateResult);
}
