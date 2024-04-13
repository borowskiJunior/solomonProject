package com.solomon.backend.solomonproject.service.impl;

import com.solomon.backend.solomonproject.model.Result;
import com.solomon.backend.solomonproject.repository.ResultRepository;
import com.solomon.backend.solomonproject.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ResultServiceImpl implements ResultService {
    private final ResultRepository resultRepository;

    @Autowired
    public ResultServiceImpl(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    @Override
    public List<Result> getResults() {
        return resultRepository.findAll();
    }

    @Override
    public Result getResult(Long id) {
        Optional<Result> foundResult = resultRepository.findById(id);
        return foundResult.orElse(null);
    }

    @Override
    @Transactional
    public Result saveResult(Result result) {
        return resultRepository.save(result);
    }

    @Override
    @Transactional
    public void deleteResult(Long id) {
        resultRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void updateResult(Long id, Result updateResult) {
        updateResult.setId(id);
        resultRepository.save(updateResult);
    }


}
